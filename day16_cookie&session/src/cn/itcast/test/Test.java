package cn.itcast.test;

public class Test {
    public static void main(String[] args) {
        int[] obj=new int[]{0,3,11,3};
     /*   增强型for循环(快捷的生成方式是iter)
        for (循环变量类型 循环变量名称 : 要的被遍历对象) 循环体*/
        for (int i : obj) {
            System.out.println(i);

        }
    }
}
