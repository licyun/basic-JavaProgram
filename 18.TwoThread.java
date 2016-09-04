/*
 *Author: Create by 李呈云
 *Description: 通过实现Runnable接口来获得自己的线程（t2）
 *Date: 2016-9-4 上午11:01:41  
 */

public class TwoThread implements Runnable{
	/*
	 * 方法说明：构造器，实际线程，并启用这个线程
	 */
	TwoThread(){
		Thread t1 = Thread.currentThread();
		t1.setName("The first main Thread");
		System.out.println("The runing thread:" + t1);
		//通过将本类(Runnable接口)和名称构造一个线程
		Thread t2 = new Thread(this,"the second Thread");
		System.out.println("create another thread");
		//启动线程
		t2.start();
		try{
			System.out.println("first thread will sleep!");
			Thread.sleep(3000);
		}catch(InterruptedException e){
			System.out.println("first thread has wrong!");
		}
		System.out.println("first thread exit！");
	}
	public void run(){
		try { 
		     System.out.println("first thread will sleep"); 
		     Thread.sleep(3000); 
		   }catch (InterruptedException e) {
		     System.out.println("first thread has wrong"); 
		   } 
		   System.out.println("first thread exit"); 
	}
	/*
	 * 方法说明：主方法
	 */
	public static void main(String[] args){
		new TwoThread();
	}
}
