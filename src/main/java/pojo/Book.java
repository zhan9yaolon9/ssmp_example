package pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data   //lombok简化，生成set/get，toString等方法
@TableName("tbl_book")
public class Book {
    //@ApiParam("主键id")
//    @TableId(value="id")
    private Integer id;

   // @ApiParam("类别")
    //@TableId(value="type")
    private String type;

    //@ApiParam("名称")
    //@TableId(value="name")
    private String name;

    //@ApiParam("简介")
    //@TableId(value="description")
    private String description;
}
