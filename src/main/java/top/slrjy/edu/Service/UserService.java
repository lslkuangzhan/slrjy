package top.slrjy.edu.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.slrjy.edu.Dao.UserDao;
import top.slrjy.edu.Entity.User;

import java.util.List;

/**
 * @ Author : Luc .
 * Date :  Created in  10:29.   2018/8/20.
 * 功能 :
 */
@Service
public class UserService {
    @Autowired
    UserDao userDao;



    public List<User> getAllUser(){
        return userDao.getAllUser();
    }
}
