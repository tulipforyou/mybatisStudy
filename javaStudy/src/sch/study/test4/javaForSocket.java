package sch.study.test4;
/*
@author 孙朝辉
@create 2019-11-23 下午12:44
@packName sch.study.test4
@sys sunchaohui
@project mybatiStudy

socket学习

*/

import org.junit.Test;

import java.io.IOException;
import java.net.Socket;

class socket1{
    @Test
    static void test1(){ //客户端socket建立
        try(Socket socket=new Socket("127.0.0.1",2000)){


        }catch(IOException e){
            e.printStackTrace();
        }
    }
    @Test
    public static void test2(){

    }
}

public class javaForSocket {
    public static void main(String[] args) {
        socket1.test1();
    }
}

