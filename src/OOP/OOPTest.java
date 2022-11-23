package OOP;

import org.junit.jupiter.api.Test;

public class OOPTest {
    @Test
    public void test() {
        Student stu = new Student("Tom","CS");
        stu.eat();
        stu.walk();
        stu.study();
        System.out.println(stu.age);

        Person per = new Student("Jeff","CS");
        per.eat();
        per.walk();
        // per.study();
        System.out.println(per.age);
        //System.out.println(per.major);

    }

    public class Person{
        String name;
        int age;
        public  Person(){

        }
        public Person(String name, int age){
            this.name = name;
            this.age = age;
        }
        public void eat(){
            System.out.println("人吃饭");
        }
        public void walk(){
            System.out.println("人走路");
        }
    }

    public class Student extends Person{
        String major;
        public Student(){

        }
        public Student(String name, String major){
            this();
            this.age = 18;
            this.name = name;
            this.major = major;
        }
        public void eat(){
            super.eat();
            System.out.println("学生吃饭");
        }
        public void study(){
            System.out.println("学生学习");
        }
    }

}
