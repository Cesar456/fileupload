package com.cesar.fileuploadtest.controller;

import com.cesar.fileuploadtest.service.FileService;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

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

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public String uploadPost(HttpServletRequest request) {
        fileService.save(request);
        return "need/upload";
    }
}
