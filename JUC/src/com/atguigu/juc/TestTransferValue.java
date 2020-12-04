package com.atguigu.juc;

/**
 * @author LHF
 * @date 2020/12/2 13:53
 */
public class TestTransferValue {

    public void changeValue1(int age){
        age = 30;
    }

    public void changeValue2(Person person){
        person.setName("xxx");
    }

    public void changeValue3(String str){
        str = "xxx";
    }

    public static void main(String[] args){
        TestTransferValue test = new TestTransferValue();
        int age = 20;
        test.changeValue1(age);
        System.out.println("age----" + age);//20

        Person person = new Person("abc");
        test.changeValue2(person);
        System.out.println("personName----" + person.getName());//xxx

        String str = "abc";
        test.changeValue3(str);
        System.out.println("String----" + str);//abc
    }

}
