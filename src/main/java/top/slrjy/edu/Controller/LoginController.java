package top.slrjy.edu.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.slrjy.edu.Config.Result;

/**
 * @ Author : Luc .
 * Date :  Created in  13:54.   2018/7/24.
 * 功能 : 实现登录 注册 修改密码功能
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @RequestMapping("/show")
    @ResponseBody
    public String show() {
        return "这里是登陆页面的 OK1";
    }

    @RequestMapping("/login")
    @ResponseBody
    public Result login() {
        return new Result("登陆成功！","");
    }
    @RequestMapping("/register")
    @ResponseBody
    public Result register() {
        return new Result("注册成功！","");
    }
}
