package top.slrjy.edu.Config;

/**
 * 响应码枚举，参考HTTP状态码的语义
 */
public enum ResultCode {
    SUCCESS(200),//成功
    FAIL(400),//失败
    UNAUTHORIZED(401),//未认证（签名错误）   （未登录）
    UNVALIDATION(402),//数据验证失败
    UNKNOWN_ERROR(403),   //未知错误
    NOT_FOUND(404),//接口不存在
    LANDINGINELSEWHERE(405),//  其他地方登陆
    INTERNAL_SERVER_ERROR(500);//服务器内部错误

    private final int code;

    ResultCode(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }
}
