package config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.omg.CORBA.INTERNAL;

/*
    * ResultCode类
    * 和RestResult对应，显示状态码的信息
 */
public enum ResultCode {
    SUCCESS(200), //成功
    FAIL(400),//失败
    UNAUTHORIZED(401),//未认证（签名失败）
    NOT_FOUND(404),//接口不存在
    INTERNAL_SERVER_ERROR(500);//服务器内部错误

    private int code;
    private ResultCode(int code) {
        this.code = code;
    }
    public int getCode() {
        return this.code;
    }
}
