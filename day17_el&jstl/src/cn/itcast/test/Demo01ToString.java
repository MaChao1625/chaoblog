package cn.itcast.test;

public class Demo01ToString {
    public static void main(String[] args) {
        Person p = new Person("张三",18);
        /*
        java.lang.Object类
        类Object 是类层次结构的根（最顶层）类。每个类都使用Object作为超父类
        所有的对象（包括数组）都实现这个类的方法
            1.person类默认继承了Object类。所以可以使用Object类中的toString方法
             String toString()  返回该对象的字符串表示
             直接打印对象的名字，其实就是调用对象的toString方法   p=p.toString
            2.看一个类是否重写了toString方法，直接打印这个类对应对象的名字即可
                如果重写了toString方法，那么打印的就是对象的地址值（默认）
                如果重写了toString方法，那么就按照重写的方法打印
        */

        String s = p.toString();
        System.out.println(p);
        System.out.println(s);



    }
}
