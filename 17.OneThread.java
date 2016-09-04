/*
 *Author: Create by 李呈云
 *Description: 通过继承Thread类，实现其run方法，实现自己的线程
 *Date: 2016-9-4 上午10:48:08  
 */

public class OneThread extends Thread{
	/*
	 * 方法说明：构造器，本类没有使用
	 */
	public OneThread(){
		
	}
	/*
	 * 方法说明：继承Thread类必须实现的方法，但调用start方法时运行本方法
	 */
	public void run(){
		System.out.println("...............oneThread begining................");
		int flag = 0;
		while(true){
			if(flag == 20){
				System.out.println("\n...............oneThread end............. ");
			      break;
			}
			for(int i = 0; i < flag; i++){
				System.out.print("*");
			}
			System.out.println();
			flag++;
			try{
				sleep(100);
			}catch(Exception e){
				
			}
		}
	}
	/*
	 * 方法说明：主方法
	 */
	public static void mian(String[] args){
		new OneThread().start();
	}
}
