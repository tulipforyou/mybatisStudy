package hfut.sch.dao;
/*
@author 孙朝辉
@create 2019-12-07 下午8:34
@packName hfut.sch.dao
@sys sunchaohui
@project mybatiStudy
注解开发测试
*/

import hfut.sch.bean.UserForMybatis;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IZhujieTest {
    /*
    * 注解开发select语句测试
    * */
    @Select("select * from UserForMybatis")
    List<UserForMybatis> findAll();
    /*
    * 注解开发insert语句测试
    * */
    @Insert("insert into UserForMybatis(userName,age,sex) values(#{userName},#{age},#{sex})")
    void insertToUserForMybatis(UserForMybatis ufm);
}
