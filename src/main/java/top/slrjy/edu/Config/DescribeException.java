package top.slrjy.edu.Config;

/**
 * @ Author : Luc .
 * Date :  Created in  14:12.   2018/8/1.
 * 功能 :
 */
public class DescribeException extends RuntimeException{

    private Integer code;
    /**
     * 自定义错误信息
     * @param message
     * @param code
     */
    public DescribeException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
