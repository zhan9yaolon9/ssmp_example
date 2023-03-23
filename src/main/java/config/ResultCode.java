package config;

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
//    public int getCode() {
//        return this.code;
//    }

    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 根据code获取message
     *
     * @param code
     * @return
     */
    public static String getMessageByCode(Integer code) {
        for (ResultCode ele : values()) {
            if (ele.getCode().equals(code)) {
                return ele.getMessage();
            }
        }
        return null;
    }
}

