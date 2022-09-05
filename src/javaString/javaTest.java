package javaString;

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
}
