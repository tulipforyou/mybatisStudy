package hfut.sch.test;

import hfut.sch.bean.UserForMybatis;
import hfut.sch.bean.UserVo;
import hfut.sch.bean.foreachCollection;
import hfut.sch.dao.IUserForMybatis;
import hfut.sch.dao.IZhujieTest;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class UserForMybatisTest {
    private InputStream in;
    private SqlSession session;
    private IUserForMybatis ufm;
    private IZhujieTest zt;
    @Before  //测试方法调用前执行
    public void init() throws IOException {
        //无需写dao实现类
        //1.读取配置文件
        in= Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.使用sqlSessionFactory工厂
        SqlSessionFactory factory= new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产Sqlsssion对象
        session=factory.openSession();
        //4.使用代理对象执行方法
        ufm=session.getMapper(IUserForMybatis.class);
        zt=session.getMapper(IZhujieTest.class);
    }
    @After    //测试方法结束后执行
    public void destroy() throws IOException {
        session.commit();
        //5.释放资源
        session.close();
        in.close();
    }
    /*
    * 测试非代理模式
    * */
    @Test
    public void test(){                          //Mapper的namespace加上语句的id,第二个参数shi是SQL语句的参数
        UserForMybatis ufm=session.selectOne("hfut.sch.dao.IUserForMybatis.findById",1);
        System.out.println(ufm);
    }
    /*
    * 测试select
    * */
    @Test
    public void test1() throws IOException {
        List<hfut.sch.bean.UserForMybatis> list=ufm.findAll();
        for(hfut.sch.bean.UserForMybatis e:list){
            System.out.println(e);
        }
    }
    /*
    * 测试insert
    * */
    @Test
    public void test2() throws IOException {
        UserForMybatis user=new UserForMybatis();
        user.setUserName("胡靖宇");
        user.setSex("男");
        user.setAge(22);
        ufm.saveUser(user);
        System.out.println(user.getId()); //在xml文件中有配置
    }
    /*
     * 测试update
     * */
    @Test
    public void test3() throws IOException {
        UserForMybatis user=new UserForMybatis();
        user.setId(7);
        user.setUserName("王浩颖");
        user.setSex("女");
        user.setAge(28);
        ufm.updateUser(user);
    }
    /*
     * 测试delete
     * */
    @Test
    public void test4() throws IOException {
        int id=7;
        ufm.deleteUserById(id);
    }
    /*
    * 测试通过id查询
    * */
    @Test
    public void test5() throws IOException {
        int id=5;
        System.out.println(ufm.findById(id));
    }
    /*
     * 测试通过name模糊查询
     * */
    @Test
    public void test6() throws IOException {
        String userName = "%孙%";
        List<UserForMybatis> u=ufm.findByName(userName);
        for(UserForMybatis y:u){
            System.out.println(y);
        }
    }
    /*
     * 测试统计总数据条数
     * */
    @Test
    public void test7() throws IOException {
       System.out.println(ufm.findTotal());
    }
    /*
     * 测试OGL表达式用法
     * */
    @Test
    public void test8() throws IOException {
        UserVo uv =new UserVo();
        UserForMybatis user=new UserForMybatis();
        user.setUserName("孙玉婷");
        uv.setUser(user);
        System.out.println(ufm.findUserByUserVo(uv));
    }
    /*
     * 测试delete
     * */
    @Test
    public void test9() throws IOException {
        List<Integer> idList=new ArrayList<Integer>();
        idList.add(12);
        idList.add(13);
        idList.add(14);
        idList.add(15);
        foreachCollection fc=new foreachCollection();
        fc.setIdList(idList);
        ufm.deleteUsers(fc);
    }
    @Test
    public void test10(){
        List<UserForMybatis> list=zt.findAll();
        for(UserForMybatis ufm:list){
            System.out.println(ufm);
        }
    }
    @Test
    public void test11(){
        UserForMybatis ufm=new UserForMybatis();
        ufm.setUserName("孙尚香");
        ufm.setAge(66);
        ufm.setSex("女");
        zt.insertToUserForMybatis(ufm);
    }
    @Test
    public void test12(){
        int id=26;
        zt.deleteFromUserForMybatis(id);
    }
}
