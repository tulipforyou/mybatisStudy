package sch.study.test2;
/*
@author 孙朝辉
@create 2019-11-22 下午2:27
@packName sch.study.test2
@sys sunchaohui
@project mybatiStudy

数组，list ,set．．．．．等操作

*/

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;

public class dataOperation {
    /*
    * iterator Test
    * */
    @Test
    public void test1(){
        String []str={"sch","wbq","syt","sssss"};
        Vector<String> aVector=new Vector<String>(Arrays.asList(str)); //数组转为列表
        Iterator<String> iterator=aVector.iterator();//获取迭代器
        while(iterator.hasNext()) {
            String tr=(String)iterator.next();
            System.out.println(tr);
            if(tr.length()>4) iterator.remove();
        }
        System.out.println(aVector);
    }
}
