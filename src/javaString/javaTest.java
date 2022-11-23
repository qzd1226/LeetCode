package javaString;

import org.junit.jupiter.api.Test;

public class javaTest {
    public static void main(String[] args) {
        // 这个例子是想证明 String类 被创造后无法被修改
        String s1 = "123";
        String s2 = "abc";
        String s3 = s1;
        System.out.println("改变前s1:" + s1);
        System.out.println("改变前s3:" + s3);
        s1 = s1 + s2;
        System.out.println("改变后s1:" + s1);
        System.out.println("改变后s3:" + s3);
    }
    @Test
    public void test1(){
        StringBuilder sb = new StringBuilder(10);
        sb.append("Runoob..");
        System.out.println(sb);
        sb.append("!");
        System.out.println(sb);
        sb.insert(8, "Java");
        System.out.println(sb);
        sb.delete(5,8);
        System.out.println(sb);
        System.out.println(sb.getClass().getTypeName());
        String str = sb.toString();
        System.out.println(str.getClass().getTypeName());
    }
    @Test
    public void splitTest(){
        String str = "/leetcode/one/1";
        System.out.println("s" + str.substring(0,0).length() + "y");
        System.out.println(str.lastIndexOf('/'));
        System.out.println(str.substring(0,str.lastIndexOf('/')));
        String str2 = "/leetcode";
        String[] strArr = str2.split("/");
        for(int i = 0; i < strArr.length; i++){
            System.out.println(strArr[i]);
        }
    }
}
