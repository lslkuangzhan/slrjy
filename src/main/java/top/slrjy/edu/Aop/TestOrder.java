package top.slrjy.edu.Aop;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import top.slrjy.edu.Config.DescribeException;
import top.slrjy.edu.Config.Result;
import top.slrjy.edu.Config.ResultGenerator;
import top.slrjy.edu.Dao.ErrorLogDao;
import top.slrjy.edu.Dao.UserDao;
import top.slrjy.edu.Entity.ErrorLog;
import top.slrjy.edu.Entity.User;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import static top.slrjy.edu.Config.ResultCode.UNAUTHORIZED;
import static top.slrjy.edu.Config.ResultCode.UNVALIDATION;

@Component
@Order(0)
@Aspect
public class TestOrder {
    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final ExecutableValidator methodValidator = factory.getValidator().forExecutables();
    private final Validator beanValidator = factory.getValidator();
    @Autowired
    ErrorLogDao logDao;
    @Autowired
    UserDao userDao;
    @Pointcut("execution(* top.slrjy.edu.Controller..*(..)) && !execution(* top.slrjy.edu.Controller.LoginController.*(..))")
    public void controllerMethodPointcut(){}
    @Pointcut("within(top.slrjy.edu.Controller..*) && !within(top.slrjy.edu.Controller.LoginController)")
    public void pointCut1(){}

    /*
      调用数据验证
     */

    @Around("controllerMethodPointcut()")
    public Result trackInfo(ProceedingJoinPoint pjp) throws Throwable {
        Result result = new Result();
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

            System.out.println("method check---------" + message);
            result.setCode(UNVALIDATION);
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
                    System.out.println("bean check-------" +message);
                    result.setCode(UNVALIDATION);
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
    public Result afterReturning(JoinPoint joinPoint,Result result) {
        System.out.println("[Aspect1] afterReturning advise");
        return result;
    }


    @AfterThrowing(throwing = "e",pointcut="controllerMethodPointcut()")
    public void afterThrowing(JoinPoint joinPoint,Throwable e) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        Object [] args  =joinPoint.getArgs();
        String location = className + "." + methodName + ":";
        String arg = "";
        for (int i=0;i<args.length;i++)
        {
            arg += args[i];
        }
        String errorMessage =e.getMessage()+e.getStackTrace()[0].getLineNumber();
        System.out.println(location );
        System.out.println(arg );
        System.out.println(errorMessage );
        ErrorLog errorLog = new ErrorLog();
        errorLog.setClassName(className);
        errorLog.setMethodName(methodName);
        errorLog.setErrorType(errorMessage);
        errorLog.setArg(arg);
        errorLog.setCreatTime(new Date());
        logDao.insertSelective(errorLog);


    }

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

