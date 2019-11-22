package sch.study.test1;
/*
@author 孙朝辉
@create 2019-11-20 下午5:23
@packName sch.study.test1
@sys sunchaohui
@project mybatiStudy

文件操作

*/

import org.junit.Test;

import java.io.*;

public class test1_3 {
    /*
    * 文件写入   FileWriter
    * */
    @Test
    public void test1() {
        String fileName="sch.txt";
        try (FileWriter writer=new FileWriter(fileName)) {
            writer.write("孙朝辉");
            writer.write("好帅");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    * 文件写入   BufferedWriter
    * */
    @Test
    public void test2(){
        String fileName="wbq.txt";
        try(BufferedWriter writer= new BufferedWriter(new FileWriter(fileName))) {
            writer.write("孙朝辉");
            writer.newLine(); //跨平台换行符
            writer.write("好帅");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    * 文件读出
    * */
    @Test
    public void test3(){
        String fileName="sch.txt",line;
        try (BufferedReader read = new BufferedReader(new FileReader(fileName))) {
            line = read.readLine();
            while (line != null) {
                System.out.println(line);
                line = read.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    * 二进制文件写入
    * */
    @Test
    public void test4() {
        String fileName="sch.dat";
        int a=255,b=1,c=-1;
        try(DataOutputStream dos=new DataOutputStream(new FileOutputStream(fileName))){
            dos.writeInt(a);
            dos.writeInt(b);
            dos.writeInt(c);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    * 二进制文件读出
    * */
    @Test
    public void test5(){
        String fileName="sch.dat";
        int sum=0;
        try(DataInputStream dis=new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)))){
            sum+=dis.readInt();
            sum+=dis.readInt();
            sum+=dis.readInt();  //三个数字相加
            System.out.println(sum);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
