package com.microservice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @Author zyf
 * @Description
 * @ClassName demo
 * @Date 2022/6/16 10:27
 **/
public class demo {

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        A a = new A(12,"张三",new B());
        A clone = (A)a.clone();
        System.out.println(a);
        System.out.println(clone);
        System.out.println(a.getName()==clone.getName());
        System.out.println("a.value:"+a.getValue());
        System.out.println("a.static:"+A.getSt());
        System.out.println("clone.value:"+clone.getValue());




        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("AAA"));
        // 使用 writeObject 序列化对象
        oos.writeObject(a);
        // 刷新
        oos.flush();
        //  关闭流
        oos.close();


        //  对象输入流
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("AAA"));
        //  使用 readObject() 反序列化
        Object obj = ois.readObject();
        //  关闭流
        ois.close();
        //  使用对象
        System.out.println(obj);
        A obj1 = (A) obj;
        System.out.println(a.getName()==obj1.getName());
        System.out.println("obj1.value:"+obj1.getValue());
        System.out.println("a.static:"+A.getSt());



    }

}


class A extends C implements Serializable, Cloneable{

    private static final long serialVersionUID = -1884792776853781635L;

    private static String st;
    private int age;
    private String name;
    private B bb;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public A(int age, String name, B bb) {
        super("123");
        this.age = age;
        this.name = name;
        this.bb = bb;
        st = "static";
        System.out.println("A:arg constructor...");
    }

    public A() {
        super("123");
        System.out.println("A:constructor...");
    }

    public static String getSt() {
        return st;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public B getBb() {
        return bb;
    }

    public void setBb(B bb) {
        this.bb = bb;
    }

    @Override
    public String toString() {
        return "A{" +
            "age=" + age +
            ", name='" + name + '\'' +
            ", bb=" + bb +
            '}';
    }
}
class B implements Serializable{
    public B(){
        System.out.println("B:constructor...");
    }

    public B(String arg){
        System.out.println("B:arg constructor...");
    }

}

class C implements Serializable{
    private String value;

    public C(){
        System.out.println("C:constructor...");
    }

    public C(String arg){
        this.value = arg;
        System.out.println("C:arg constructor...");
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "C{" +
            "value='" + value + '\'' +
            '}';
    }
}

