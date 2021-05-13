package com.feng.controller;

import com.feng.file.FastDFSFile;
import com.feng.util.FastDFSUtil;
import entity.Result;
import entity.StatusCode;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
@CrossOrigin
public class FileController {

    //文件上传
    @PostMapping("/upload")
    public Result upload(@RequestParam("file")MultipartFile file) throws Exception {
        FastDFSFile fastDFSFile = new FastDFSFile(
                file.getOriginalFilename(),
                file.getBytes(),
                //获取文件扩展名
                StringUtils.getFilenameExtension(file.getOriginalFilename())
        );

        /**
         * uploads[0]:文件上传所存储的Storage的组名字 group1
         * uploads[1]:文件存储到Storage上的文件名字    路径/文件名
         * */
        String[] uploads = FastDFSUtil.upload(fastDFSFile);
        //拼接访问的链接地址
        String url = "http://10.96.83.111:8080/"+uploads[0]+"/"+uploads[1];
        return new Result(true, StatusCode.OK, "上传成功", url);
    }
}
