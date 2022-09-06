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
}
