package top.slrjy.edu.Dao;

import org.apache.ibatis.annotations.Select;
import top.slrjy.edu.Config.Mapper;
import top.slrjy.edu.Entity.Login;

public interface LoginDao extends Mapper<Login> {
    @Select("select  *  from login  where state = 1  and account = #{account}")
    public Login selectByAccount(String account);

    @Select("select  count(1)  from login  where  account = #{account}")
    public int  isExist (String account);
}
