package sch.study.test1;
/*
@author 孙朝辉
@create 2019-11-22 下午1:04
@packName sch.study.test1
@sys sunchaohui
@project mybatiStudy

File 类测试

*/

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class FileClassTest {
    /*
    * File文件简单操作
    * */
    @Test
    public void test1(){
        File f=new File("sch.txt");
        if(f.exists()) f.delete();
        else{
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    * 文件解压缩
    * */
    @Test
    public void test2(){
        try( FileInputStream fis=new FileInputStream("wbq.txt")){
            GZIPOutputStream gos=new GZIPOutputStream(new FileOutputStream("test.gz")); //创建空压缩文件
            int c;
            while((c=fis.read())!=-1) gos.write(c);//向压缩文件写入数据
            gos.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    @Test
    public void test3(){
        try( FileOutputStream fos=new FileOutputStream("sch.txt")){
            GZIPInputStream gis=new GZIPInputStream(new FileInputStream("test.gz"));
            int c;
            while((c=gis.read())!=-1) fos.write(c);
            gis.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
