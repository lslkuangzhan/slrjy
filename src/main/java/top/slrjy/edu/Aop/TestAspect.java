package top.slrjy.edu.Aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * 权限拦截AOP
 * @author Administrator
 *
 */
@Component
@Order(1)
@Aspect
public class TestAspect {

    @Pointcut("within(top.slrjy.edu.Controller..*) && !within(top.slrjy.edu.Controller.LoginController)")
    public void pointCut(){}

    @Around("pointCut()")
    public void trackInfo(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("-------------没有登录1-------------");
        // return "redirect:/login/show";
    }

 /*
 @Aspect // FOR AOP
@Order(-99) // 控制多个Aspect的执行顺序，越小越先执行
@Component


 @After("pointCut()")
    public Object AfterInfo(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("-------------aFter-------------");
        return "redirect:/login/show";
    }*/


}
