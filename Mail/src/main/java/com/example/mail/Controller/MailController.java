package com.example.mail.Controller;

import com.example.mail.Result;
import com.example.mail.Service.Impl.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/**
 * 测试邮件发送
 * @author qzz
 */
@RestController
@RequestMapping("/mail")
public class MailController {

    @Autowired
    private MailService mailService;

    /**
     * 发送文本邮件
     * @param to
     * @param subject
     * @param text
     */
    @PostMapping("/sendTextMail")
    public Result<String> sendTextMail(String to, String subject, String text){
        mailService.sendTextMailMessage(to,subject,text);
        return Result.success();
    }

    /**
     * 发送带有附件的邮件
     */
    @PostMapping("/sendMailWithAttach")
    public Result<String> sendMailWithAttach(String to, String subject, String text, MultipartFile file){
        mailService.sendMailWithAttach(to,subject,text,file);
        return Result.success();
    }
}

