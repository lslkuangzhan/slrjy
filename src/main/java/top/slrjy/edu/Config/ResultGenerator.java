package top.slrjy.edu.Config;

/**
 * @ Author : Luc .
 * Date :  Created in  9:34.   2018/7/31.
 * 功能 : 响应结果生成工具
 */

public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static Result genSuccessResult() {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static Result genSuccessResult(Object data) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }
    public static Result genSuccessResult(String message,Object data) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(message)
                .setData(data);
    }

    public static Result genFailResult(String message) {
        return new Result()
                .setCode(ResultCode.FAIL)
                .setMessage(message);
    }
    public static Result genUnknownResult(String message) {
        return new Result()
                .setCode(ResultCode.UNKNOWN_ERROR)
                .setMessage(message);
    }
}
