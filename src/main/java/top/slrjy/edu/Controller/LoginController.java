package top.slrjy.edu.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.slrjy.edu.Config.Result;
import top.slrjy.edu.Config.ResultGenerator;
import top.slrjy.edu.Entity.Login;
import top.slrjy.edu.Entity.User;
import top.slrjy.edu.Service.LoginService;
import top.slrjy.edu.Service.UserService;

/**
 * @ Author : Luc .
 * Date :  Created in  13:54.   2018/7/24.
 * 功能 : 实现登录 注册 修改密码功能
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginService loginService;
    @RequestMapping("/show")
    @ResponseBody
    public String show() {
        return "这里是登陆页面的 OK1";
    }

    @RequestMapping("/login")
    @ResponseBody
    public Result login(Login login ) {
            return loginService.login(login);
    }
    @RequestMapping("/register")
    @ResponseBody
    public Result register(Login login) {
        return loginService.register(login);
    }

    @RequestMapping("/isExist")
    @ResponseBody
    public Result isExist(String account) {
        return ResultGenerator.genSuccessResult(loginService.isExist(account));
    }
}
