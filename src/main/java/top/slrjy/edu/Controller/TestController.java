package top.slrjy.edu.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.slrjy.edu.Config.Result;
import top.slrjy.edu.Entity.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/show")
    @ResponseBody
    public Result show(User user) {
        System.out.println("这里被访问了!");
        return  new Result("登陆成功！","OKOKOK");
    }

    @RequestMapping("/show2")
    public Result show2(@NotBlank  @Size(min = 8, max = 10) String code) {
        return new Result("2","1");
    }
}