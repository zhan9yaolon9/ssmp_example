package config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import pojo.Book;

import java.util.List;

//统一前后端格式
@Data
@AllArgsConstructor
public class R {
    private Boolean flag;   //标识操作是否成功
    private Object data;    //封装操作数据

    public R(boolean flag){
        this.flag = flag;
    }
}
