/*
 *Author: Create by 李呈云
 *Description: 使用构造器，创建多线程
 *Date: 2016-9-4 上午11:13:24  
 */

public class MultiThread 
{ 
/*
 *<br>方法说明：主方法
 *<br>输入参数：
 *<br>返回类型：
 */
 public static void main (String [] args){ 
    new MultiThread();
  }
/*
 *<br>方法说明：构造器。构造多个线程，并启动它们。
 *<br>输入参数：
 *<br>返回类型：
 */
  MultiThread(){
    for (int i = 0; i < 5; i++){
      System.out.println("Creating thread "+i);
      innThread mt = new innThread (i); 
      mt.start (); 
    }
  }
/*
 *<br>类说明：内部类通过继承Thread实现线程 
 *<br>类描述：通过构造器参数，区别不同的线程
 */     
 class innThread extends Thread 
 { 
  int count;
  innThread(int i){
     count=i;
  }
/*
 *<br>方法说明：内部类线程主体，继承Thread必须实现的方法。
 *<br>输入参数：
 *<br>返回类型：
 */
  public void run () 
  { 
    System.out.println("now "+count+" thread is beginning..... ");
    try{
      sleep(10-count);
    }catch(Exception e){
      System.out.println(e);
    }
    System.out.println("\n"+count+" thread is end!");
  } 
 } 
}
