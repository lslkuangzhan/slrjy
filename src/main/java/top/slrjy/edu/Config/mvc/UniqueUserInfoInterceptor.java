package top.slrjy.edu.Config.mvc;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.slrjy.edu.Config.Result;
import top.slrjy.edu.Service.LoginService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.OutputStream;
import java.io.PrintWriter;

import static top.slrjy.edu.Config.ResultCode.LANDINGINELSEWHERE;
import static top.slrjy.edu.Config.ResultCode.UNAUTHORIZED;

/**
 * @auther luc
 * @desc 自定义拦截器，用户判断用户是否登陆，同一用户限制一个地方登陆
         *
 */
public class UniqueUserInfoInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        // 可以成功获取到Bean啦
        LoginService loginService = (LoginService) SpringContextHolder.getBean ("loginService");
        String token = request.getHeader("token");
        if (null!=token||!"".equals(token)){
                if (token .equals("MyToken"))
                {
                    return true;
                } else {
                    response.setCharacterEncoding("utf-8");
                    response.setContentType("application/json; charset=utf-8");
                    PrintWriter writer = response.getWriter();
                    Result result = new Result();
                    result.setCode(LANDINGINELSEWHERE);
                    result.setMessage("您的账号已在其他地方登陆！");
                    writer.write(result.toString());
                }
        }else{
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json; charset=utf-8");
            PrintWriter writer = response.getWriter();
            Result result = new Result();
            result.setCode(UNAUTHORIZED);
            result.setMessage("未登录！");
            writer.write(result.toString());
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
