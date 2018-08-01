package top.slrjy.edu.Config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ Author : Luc .
 * Date :  Created in  14:20.   2018/8/1.
 * 功能 : 对捕获的错误进行判定
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);

    /**
     * 判断错误是否是已定义的已知错误，不是则由未知错误代替，同时记录在log中
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exceptionGet(Exception e){
        if(e instanceof DescribeException){
            DescribeException MyException = (DescribeException) e;
            return ResultGenerator.genFailResult(MyException.getMessage());
        }

        LOGGER.error("【系统异常】{}"+e.getMessage()+",class:"+e.getClass());
        return ResultGenerator.genUnknownResult("未知异常发生了！！");

    }
}
