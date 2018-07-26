package top.slrjy.edu.Config;

/**
 * @ Author : Luc .
 * Date :  Created in  14:32.   2018/7/24.
 * 功能 : 服务（业务）异常如“ 账号或密码错误 ”，该异常只做INFO级别的日志记录 @see WebMvcConfigurer
 */
public class ServiceException extends RuntimeException {
    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}

