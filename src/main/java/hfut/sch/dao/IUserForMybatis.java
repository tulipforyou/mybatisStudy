package hfut.sch.dao;

import hfut.sch.bean.UserForMybatis;
import hfut.sch.bean.UserVo;
import hfut.sch.bean.foreachCollection;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.List;

public interface IUserForMybatis {
    /*
    * 查询所有
    * @return
    * */
   // @Select(value = "select * from UserForMybatis")
    List<UserForMybatis> findAll();

    void saveUser(UserForMybatis user);

    void updateUser(UserForMybatis user);

    void deleteUserById(int id);

    UserForMybatis findById(int id);

    List<UserForMybatis> findByName(String name);

    int findTotal();

    UserForMybatis findUserByUserVo(UserVo uv);

    void deleteUsers(foreachCollection fc);
}
