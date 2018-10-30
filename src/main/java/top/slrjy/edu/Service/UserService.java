package top.slrjy.edu.Service;

import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;
import top.slrjy.edu.Dao.UserDao;
import top.slrjy.edu.Entity.User;

import java.util.List;

/**
 * @ Author : Luc .
 * Date :  Created in  10:29.   2018/8/20.
 * 功能 :
 */
@Service
public class UserService  implements top.slrjy.edu.Config.Service{
    @Autowired
    UserDao userDao;

    @Override
    public void save(Object model) {

    }

    @Override
    public void save(List models) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void deleteByIds(String ids) {

    }

    @Override
    public void update(Object model) {

    }

    @Override
    public Object findById(Integer id) {
        return null;
    }

    @Override
    public Object findBy(String fieldName, Object value) throws TooManyResultsException {
        return null;
    }

    @Override
    public List findByIds(String ids) {
        return null;
    }

    @Override
    public List findByCondition(Condition condition) {
        return null;
    }

    @Override
    public List findAll() {
        return userDao.getAllUser();
    }

    public String  login  (User user){
        User user1 =userDao.selectOne(user);
        if (user1!=null){
            return  "success";
        }
        return  "false";
    }
}
