package com.example.springboot_demo.controller;

import com.example.springboot_demo.pojo.Result;
import com.example.springboot_demo.utils.AliyunOSSOperator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/upload")
public class UploadController {
    private final AliyunOSSOperator aliyunOSSOperator;

    @PostMapping
    public Result upload(@RequestParam MultipartFile file) {
        log.info("上传文件：{}", file.getOriginalFilename());

        // 接受上传的文件交给OSS存储后返回URL
        try{
            String url = aliyunOSSOperator.upload(file.getBytes(),
                    file.getOriginalFilename());
            log.info("文件url：{}", url);

            return Result.success(url);
        }catch (Exception e){
            log.error(e.getMessage());
            return Result.error(e.getMessage());
        }
    }
}
