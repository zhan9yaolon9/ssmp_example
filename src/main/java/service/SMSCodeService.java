package service;

import pojo.SMSCode;

/**
 * @Author: frank
 * @Date: 2022/10/25/19:49
 * @Description:
 **/
public interface SMSCodeService {
    public String sendCodeToSMS(String tele);
    public boolean checkCode(SMSCode smsCode);
}
