package com.sky.controller.admin;

import com.sky.annotation.AutoFill;
import com.sky.constant.MessageConstant;
import com.sky.result.Result;
import com.sky.utils.AliOssUtil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Slf4j
public class CommonController {
    @Autowired
    private AliOssUtil aliOssUtil;

    /**
     * 文件上传
     * @param file
     * @return
     */
    private Result<String> upload(MultipartFile file) {
        log.info("文件上传：{}", file.getOriginalFilename());

        try {
            //原始文件名
            String originalFilename = file.getOriginalFilename();
            //截取原始文件的后缀
            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            //构建文件名称
            String objectName = UUID.randomUUID().toString() + "." + extension;
            //文件的请求
            String fileName = aliOssUtil.upload(file.getBytes(), objectName);

            return Result.success(fileName);
        } catch (IOException e) {
            log.error("文件上传失败，{}" , e.getMessage());
        }
        return Result.error(MessageConstant.UPLOAD_FAILED);
    }

}
