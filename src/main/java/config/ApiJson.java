package config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: frank
 * @Date: 2023/03/21/21:37
 * @Description:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiJson<T> implements Serializable {
    private int code;
    private String msg;
    private T data;
    public static ApiJson ok(){
        return new ApiJson(1, "ok", null);
    }

    public static ApiJson ok(String msg){
        return new ApiJson(1, msg, null);
    }

    public static ApiJson ok(Object data){
        return new ApiJson(1, "ok", data);
    }

    public static ApiJson ok(String msg, Object data){
        return new ApiJson(1, msg, data);
    }

    public static ApiJson error(){
        return new ApiJson(0, "error", null);
    }

    public static ApiJson error(String msg){
        return new ApiJson(0, msg, null);
    }

    public static ApiJson error(String msg, Object data){
        return new ApiJson(0, msg, data);
    }
}