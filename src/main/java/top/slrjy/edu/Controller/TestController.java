package top.slrjy.edu.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/show")
    @ResponseBody
    public String show() {
        return "OK";
    }

    @RequestMapping("/show2")
    public String show2() {
        return "OK2";
    }
}