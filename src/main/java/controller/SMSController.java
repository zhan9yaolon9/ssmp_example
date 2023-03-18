package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.SMSCode;
import service.SMSCodeService;

/**
 * @Author: frank
 * @Date: 2022/10/25/20:08
 * @Description:
 **/

@RestController
@RequestMapping("/sms")
public class SMSController {
    @Autowired
    private SMSCodeService smsCodeService;

    @GetMapping
    public String getCode(String tele){
        String code = smsCodeService.sendCodeToSMS(tele);
        return code;
    }

    @PostMapping
    public boolean checkCode(SMSCode smsCode){
        return smsCodeService.checkCode(smsCode);
    }
}
