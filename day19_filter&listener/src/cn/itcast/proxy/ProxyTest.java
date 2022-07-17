package cn.itcast.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        //1.创建真实对象
        Lenovo lenovo = new Lenovo();

        //2.动态代理增强lenovo对象     proxy_lenovo(代理对象)
        //强转化为接口对象
        SaleComputer proxy_lenovo = (SaleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
            /*代理逻辑编写的方法：代理对象调用的所有方法，都会触发该方法执行*/
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
               /* System.out.println("该方法执行了。。。。。");
                //获取调用对象的名字
                System.out.println(method.getName());
                System.out.println(args[0]);*/


                //1.增强参数
                //判断是否是sale方法
                if(method.getName().equals("sale")){
                    //1.增强参数
                    double money = (double)args[0];
                    money = money*0.85;
                    System.out.println("专车接你");
                    //使用真实对象调用该方法
                    String obj =(String) method.invoke(lenovo, money);
                    System.out.println("免费送货。");
                    //2.增强返回值


                    return obj+"，鼠标垫";

                }else{
                    Object obj = method.invoke(lenovo, args);
                    return obj;
                }



            }
        });


        //3.调用方法(用代理对象进行调用)
        String computer = proxy_lenovo.sale(8000);
        System.out.println(computer);
        //proxy_lenovo.show();


    }
}
