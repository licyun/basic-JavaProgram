/*
 *Author: Create by 李呈云
 *Description: 通过使用同步锁实现对共享数据的操作
 *Date: 2016-9-4 上午11:23:32  
 */

public class SynThread {
	/*
	 *类说明：同步类
	 *功能描述：保存共享数据
	 */
	class trade{
		private String transName;
		private double amount;
		trade(){
			
		}
		/*
		 * 方法说明：更新数据
		 * 输入参数：String transName操作名称
		 * 输入参数：double amount 资金数量
		 */
		synchronized void update(String transName, double amount){
			this.transName = transName;
			this.amount = amount;
			System.out.println(this.transName + " " + this.amount);
		}
	}
	/*
	 * 类说明：添加资金
	 * 功能描述：单线程，调用trade.update()方法，修改数据
	 */
	class addThread extends Thread{
		private trade ft;
		addThread(trade ft, String name){
			super(name);
			this.ft = ft;
		}
		public void run(){
			for(int i = 0; i < 10; i++){
				ft.update("add", 2000);
			}
		}
	}
	/*
	 * 类说明：减少资金
	 * 功能描述：单线程，调用trade.update()方法，修改数据
	 */
	class decThread extends Thread{
		private trade ft;
		decThread(trade ft, String name){
			super(name);
			this.ft = ft;
		}
		public void run(){
			for(int i = 0; i < 10; i++){
				ft.update("dec", -2000);
			}
		}
	}
	/*
	 * 方法说明：演示方法
	 */
	SynThread(){
		trade ft = new trade();
	    addThread tt1 = new addThread (ft, "add"); 
	    decThread tt2 = new decThread (ft, "dec"); 
	    tt1.start (); 
	    tt2.start (); 
	}
	/*
	 * 方法说明：主方法
	 */
	public static void main(String[] args){
		new SynThread();
	}
}
