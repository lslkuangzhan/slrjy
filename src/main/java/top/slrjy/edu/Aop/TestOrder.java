package top.slrjy.edu.Aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(0)
@Aspect
public class TestOrder {


    @Pointcut("execution(* top.slrjy.edu.Controller..*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void controllerMethodPointcut(){}
    @Pointcut("within(top.slrjy.edu.Controller..*) && !within(top.slrjy.edu.Controller.LoginController)")
    public void pointCut1(){}


    @Before("controllerMethodPointcut()")
    public void  TestBefore (JoinPoint joinPoint){
            System.out.println("-------------before-------------");
        }
    @Before("controllerMethodPointcut()")
    public void  TestBefore1 (JoinPoint joinPoint){
        System.out.println("-------------before1-------------");
    }
    @Around("controllerMethodPointcut()")
    public void trackInfo(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("[Aspect1] around advise 1");
        pjp.proceed();
        System.out.println("[Aspect1] around advise2");
    }
   @After("controllerMethodPointcut()")
   public void  TestAfter (JoinPoint joinPoint){
       System.out.println("-------------TestAfter-------------");
   }

   /* @Before("controllerMethodPointcut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("[Aspect1] before advise");
    }

    @Around("controllerMethodPointcut()")
    public void around(ProceedingJoinPoint pjp) throws  Throwable{
        System.out.println("[Aspect1] around advise 1");
        pjp.proceed();
        System.out.println("[Aspect1] around advise2");
    }

    @AfterReturning("controllerMethodPointcut()")
    public void afterReturning(JoinPoint joinPoint) {
        System.out.println("[Aspect1] afterReturning advise");
    }

    @AfterThrowing("controllerMethodPointcut()")
    public void afterThrowing(JoinPoint joinPoint) {
        System.out.println("[Aspect1] afterThrowing advise");
    }

    @After("controllerMethodPointcut()")
    public void after(JoinPoint joinPoint) {
        System.out.println("[Aspect1] after advise");
    }*/
}
