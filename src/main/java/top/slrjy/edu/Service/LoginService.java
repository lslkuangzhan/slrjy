package top.slrjy.edu.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.slrjy.edu.Config.Result;
import top.slrjy.edu.Config.ResultGenerator;
import top.slrjy.edu.Dao.LoginDao;
import top.slrjy.edu.Entity.Login;
import top.slrjy.edu.Entity.User;

import java.util.List;

@Service
public class LoginService  {
    @Autowired
    LoginDao loginDao;
    public Result login  (Login login){
        Login login1 =loginDao.selectByAccount(login.getAccount());
        if(login1==null){
            return  ResultGenerator.genSuccessResult("error","账户不存在!");
        }
        else  if  (login1.getPassword().equals(login.getPassword())){
            return ResultGenerator.genSuccessResult("登陆成功!");
        }

        else{
            return ResultGenerator.genSuccessResult("error","密码错误!");
        }

    }

    public String isExist  (String account){
        int isExist  = loginDao.isExist(account);
        if (isExist== 0){
            return "该账可以注册!";
        }
        return "该账户已存在";
    }


    public Result register(Login login){
        int isExist  = loginDao.isExist(login.getAccount());
        if(isExist == 0){
            login.setState("1");
            loginDao.insertSelective(login);
            return ResultGenerator.genSuccessResult("注册成功！");
        }else{
            return ResultGenerator.genSuccessResult("fail","注册失败！");
        }
    }
}
