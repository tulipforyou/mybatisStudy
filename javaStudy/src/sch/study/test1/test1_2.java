package sch.study.test1;
/*
@author 孙朝辉
@create 2019-11-20 下午4:59
@packName sch.study.test1
@sys sunchaohui
@project mybatiStudy

泛型说明

*/

import org.junit.Test;

public class test1_2 {
    @Test
    public void test(){
        test1_2_other<Integer> a=new test1_2_other<>();
        a.sch(1);
    }
}

class test1_2_other <TT extends Number>{  //有限制的泛型,只能是数字
    public void sch(TT a){
        System.out.println(a);
    }
}

