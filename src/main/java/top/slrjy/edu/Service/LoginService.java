package top.slrjy.edu.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.slrjy.edu.Config.Result;
import top.slrjy.edu.Config.ResultGenerator;
import top.slrjy.edu.Dao.LoginDao;
import top.slrjy.edu.Entity.Login;
import top.slrjy.edu.Entity.User;

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
}
