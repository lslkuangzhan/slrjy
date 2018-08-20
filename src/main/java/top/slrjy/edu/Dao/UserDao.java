package top.slrjy.edu.Dao;

import org.apache.ibatis.annotations.Select;
import top.slrjy.edu.Config.Mapper;
import top.slrjy.edu.Entity.User;

import java.util.List;

/**
 * @ Author : Luc .
 * Date :  Created in  10:29.   2018/8/20.
 * 功能 :
 */
public interface UserDao extends Mapper<User> {
    @Select("select *  from user ")
    public List<User> getAllUser();
}
