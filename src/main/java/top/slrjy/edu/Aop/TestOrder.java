package top.slrjy.edu.Aop;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import top.slrjy.edu.Config.Result;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

@Component
@Order(0)
@Aspect
public class TestOrder {
    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final ExecutableValidator methodValidator = factory.getValidator().forExecutables();
    private final Validator beanValidator = factory.getValidator();

    @Pointcut("execution(* top.slrjy.edu.Controller..*(..)) && !execution(* top.slrjy.edu.Controller.LoginController.*(..))")
    public void controllerMethodPointcut(){}
    @Pointcut("within(top.slrjy.edu.Controller..*) && !within(top.slrjy.edu.Controller.LoginController)")
    public void pointCut1(){}

    /*
      调用数据验证
     */

    @Around("controllerMethodPointcut()")
    public Result trackInfo(ProceedingJoinPoint pjp) throws Throwable {
        Result result = new Result("","");
        //  获得切入目标对象
        Object target = pjp.getThis();
        // 获得切入方法参数
        Object [] args = pjp.getArgs();
        // 获得切入的方法
        Method method = ((MethodSignature)pjp.getSignature()).getMethod();

        Boolean temp = true;
        // 校验以基本数据类型 为方法参数的
        Set<ConstraintViolation<Object>> validResult = validMethodParams(target, method, args);


        Iterator<ConstraintViolation<Object>> violationIterator = validResult.iterator();
        while (violationIterator.hasNext()) {
            // 此处可以抛个异常提示用户参数输入格式不正确
            String message =violationIterator.next().getMessage();
           // System.out.println("method check---------" + message);
            result.setResultCode(201);
            result.setMessage("验证出错："+message);
            temp=false;
            break;
        }
        for (Object bean : args) {
            if (null != bean) {
                validResult = validBeanParams(bean);
                violationIterator = validResult.iterator();
                while (violationIterator.hasNext()) {
                    String message =violationIterator.next().getMessage();
                    // 此处可以抛个异常提示用户参数输入格式不正确
                  //  System.out.println("bean check-------" +message);
                    result.setResultCode(201);
                    result.setMessage("验证出错："+message);
                    temp=false;
                    break;
                }
            }
        }
        if (temp){
        result= (Result) pjp.proceed();
        System.out.println("[Aspect1] around advise2");
        }
        return  result;
    }
   @After("controllerMethodPointcut()")
   public void  TestAfter (JoinPoint joinPoint){
       System.out.println("-------------TestAfter1111-------------");
   }
    @AfterReturning(returning = "result",pointcut="controllerMethodPointcut()")
    public Result afterThrowing(JoinPoint joinPoint,Result result) {
        System.out.println("[Aspect1] afterThrowing advise");
        return result;
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

   /**
    *   数据验证的方法
    */
   private <T> Set<ConstraintViolation<T>> validMethodParams(T obj, Method method, Object [] params){
       return methodValidator.validateParameters(obj, method, params);
   }
    private <T> Set<ConstraintViolation<T>> validBeanParams(T bean) {
        return beanValidator.validate(bean);
    }

}

