package com.yi.du.test;

import com.google.gson.Gson;
import com.yi.du.bean.Book;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 *
 *     ***--利用线程来抢锁--****
 * Created by Administrator on 2018/3/20.
 * 1.创建线程 CountDownLatch类
 * 2.用for循环来模拟10个人进行请求
 * 3.创建analogUser，传入相对的参数
 * 4.analogUser继承Thread类
 * 5.利用.strart()方法调用run方法
 *
 *
 */
public class bookTest {

    @org.junit.Test
    public void test1() {
        String result = "";
//        result = "{\"id\":9787115356253,\"sid\":2,\"bookName\":\"Objiective-C\",\"author\":\"黑马\",\"press\":\"人民邮电出版社\",\"picUrl\":\"/image/1.jpg\",\"mount\":9,\"location\":\"计算机类\",\"version\":9}";
        Book book = new Gson().fromJson(result, Book.class);
        System.out.println("book: " + new Gson().toJson(book));
    }

    final static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static  void  main(String[] args) {
        CountDownLatch latch=new CountDownLatch(1);//模拟10人并发请求，书本的库存

        for(int i=0;i<10;i++){//模拟10个用户
            AnalogUser analogUser = new AnalogUser("user"+i,
                    "10017","1","3",latch);

            analogUser.start();//虚拟机开始调用run方法
        }
        latch.countDown();//计数器減一  所有线程释放 并发访问。
        System.out.println("所有模拟请求结束  at "+sdf.format(new Date()));

    }

    static class AnalogUser extends Thread{

        //定义参数
        String workerName;//模拟用户姓名
        String id;
        String openType;
        String mount;
        CountDownLatch latch;

        public AnalogUser(String workerName, String id, String openType, String mount, CountDownLatch latch) {
            super();
            this.workerName = workerName;
            this.id = id;
            this.openType = openType;
            this.mount = mount;
            this.latch = latch;
        }

        @Override
        public void run() {
            // TODO Auto-generated method stub
            try {
                latch.await(); //一直阻塞当前线程，直到计时器的值为0
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            post();//发送post 请求



        }


        public void post(){


            String result = "";
            System.out.println("模拟用户： "+workerName+" 开始发送模拟请求  at "+sdf.format(new Date()));

             result = HttpRequest.sendPost("http://localhost:8081/api/Book/bookaction", "id="+id+"&openType="+openType+"&mount="+mount);
            System.out.println("操作结果："+result);
            System.out.println("模拟用户： "+workerName+" 模拟请求结束  at "+sdf.format(new Date()));

        }



    }

}

