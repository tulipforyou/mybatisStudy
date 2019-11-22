package sch.study.test1;
/*
@author 孙朝辉
@create 2019-11-20 下午4:38
@packName sch.study.test1
@sys sunchaohui
@project mybatiStudy

抽象类说明

*/

import org.junit.Test;

abstract class test {
    void wbq() {
        System.out.println("十四行诗");
    }

    abstract void sch();

    abstract void syt();
}

public class test1_1 extends test { //子类必须实现所有抽象方法
    @Test
    public void test1() {
        System.out.println();
    }

    @Override
    void sch() {

    }

    @Override
    void syt() {

    }
}
