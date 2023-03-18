package config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.logging.LogRecord;


/*
    * RestResult类，不仅将返回给前端的数据规范化，
        而且可以通过状态码返回当前结果的状态（是否有错误，错误是什么）
 */
public class RestResult {
    private String message; //消息
    private Object data;    //封装操作数据
    private int code; //状态码

    public RestResult(){

    }
    public RestResult (int code){
        this.code = code;
    }
    public RestResult (int code, String message){
        this.code = code;
        this.message = message;
    }
    public RestResult (int code,Object data, String message){
        this.code = code;
        this.data = data;
        this.message = message;
    }
    public RestResult setCode(ResultCode code) {
        this.code = code.getCode();
        return this;
    }

    public int getCode() {
        return code;
    }

    public RestResult setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public RestResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public RestResult setData(Object data) {
        this.data = data;
        return this;
    }
}
