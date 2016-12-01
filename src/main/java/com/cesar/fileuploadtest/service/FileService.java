package com.cesar.fileuploadtest.service;

import com.alibaba.druid.util.StringUtils;
import com.cesar.fileuploadtest.dao.UploadFileMapper;
import com.cesar.fileuploadtest.model.UploadFile;
import com.cesar.fileuploadtest.model.UploadFileExample;
import com.cesar.fileuploadtest.util.TimeUtil;
import com.cesar.fileuploadtest.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Cesar on 2016/11/28.
 * 对文件上传下载进行操作
 */
@Service
public class FileService {

    private Logger logger = LoggerFactory.getLogger(FileService.class);

    private static String FILE_PARENT_PATH = "../webapps/fileupload/upload/file/";

    @Autowired
    private UploadFileMapper fileMapper;

    /**
     * 存储文件到硬盘
     * 存储文件信息到数据库
     * @param file 要存储的文件
     * @return 文件信息的对象
     */
    public UploadFile save(CommonsMultipartFile file) {
        UploadFile uploadFile = new UploadFile();
        uploadFile.setFilename(file.getOriginalFilename());
        uploadFile.setUploadtime(new Date());

        // 检查父目录是否存在
        File todayFolder = new File(FILE_PARENT_PATH + TimeUtil.getDateTime());
        if (!todayFolder.exists()) {
            todayFolder.mkdirs();
        }

        // 获取文件后缀名
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);

        String filePath = todayFolder.getAbsolutePath() + "/" + System.currentTimeMillis() + "." + suffix;
        File newFile = new File(filePath);
        try {
            file.transferTo(newFile);
            uploadFile.setPath(newFile.getAbsolutePath());
            uploadFile.setSuffix(suffix);
            fileMapper.insert(uploadFile);
            logger.info("上传文件" + uploadFile.toString());
            return uploadFile;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    // TODO 需要分页
    public List<UploadFile> getUploadFiles(int pagesize, int pagenum) {
        UploadFileExample example = new UploadFileExample();
        UploadFileExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("uploadtime");
        return fileMapper.selectByExample(example);
    }

    public void download(int fileId, HttpServletResponse response) {
        UploadFile file = fileMapper.selectByPrimaryKey(fileId);
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");

        String name = Utils.transHanziToPinyin(file.getFilename());
        if (StringUtils.isEmpty(name)) {
            name = file.getPath().substring(file.getPath().lastIndexOf("\\") + 1);
        }
        response.setHeader("Content-Disposition", "attachment;fileName="
                + name);
        try {
            InputStream inputStream = new FileInputStream(new File(file.getPath()));
            OutputStream os = response.getOutputStream();
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }
            os.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
