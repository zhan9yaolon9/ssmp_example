package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import pojo.SMSCode;
import utils.CodeUtils;

/**
 * @Author: frank
 * @Date: 2022/10/25/19:50
 * @Description:
 **/
@Service
public class SMSCodeServiceImpl implements SMSCodeService{
    @Autowired
    private CodeUtils codeUtils;

    @CachePut(value="smsCode", key="#tele")
    public String sendCodeToSMS(String tele){
        String code = codeUtils.generator(tele);
        return code;
    }

    public boolean checkCode(SMSCode smsCode){
        //去除内存中的验证码与传递过来的验证码比较，相同返回true
        String code = smsCode.getCode();
        String cacheCode = codeUtils.get(smsCode.getCode());
        return code.equals(cacheCode);
    }
}
