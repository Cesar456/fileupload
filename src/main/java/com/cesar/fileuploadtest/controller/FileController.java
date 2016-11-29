package com.cesar.fileuploadtest.controller;

import com.cesar.fileuploadtest.model.UploadFile;
import com.cesar.fileuploadtest.service.FileService;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

/**
 * Created by Cesar on 2016/11/28.
 */
@Controller
@RequestMapping("/file")
public class FileController {

    private Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "upload", method = RequestMethod.GET)
    public String upload() {
        return "need/upload";
    }

    /**
     * 通过普通方式上传文件
     * 还应该有前后端分离的方式
     * @param file 传入的文件
     * @return 文件上传成功的网页
     */
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public String fileUpload2(@RequestParam("file") CommonsMultipartFile file){
        logger.debug("文件上传:" + file.getOriginalFilename());
        fileService.save(file);
        return "need/upload";
    }

    @RequestMapping(value = "filelist", method = RequestMethod.GET)
    public String getAllFile(@RequestParam("pagesize") int pagesize, @RequestParam("pagenum") int pagenum, Model model) {
        List<UploadFile> files = fileService.getUploadFiles(pagesize, pagenum);
        model.addAttribute("files", files);
        return "need/showupload";
    }


    @RequestMapping(value = "download/{fileId}", method = RequestMethod.GET)
    public String download(@PathVariable("fileId") int fileId, HttpServletRequest request,
                           HttpServletResponse response) {
        fileService.download(fileId, request, response);
        return null;
    }
}
