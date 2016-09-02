/*
 *Author: Create by 李呈云
 *Description: 通过继承Exception类来实现自己的异常类。并使用try－catch来捕获这个异常
 *Date: 2016-9-2 上午11:25:09  
 */

class MyException extends Exception{
	public MyException(){}
	public MyException(String msg){
		super(msg);
	}
	public MyException(String msg, int x){
		super(msg);
		i = x;
	}
	public int val() {return i;}
	private int i;
}

public class DemoException {
	/*
	 * 方法说明：使用MyException中的默认构造器
	 * 输入参数：
	 * 返回类型：
	 */
	public static void a() throws MyException{
		System.out.println("Throwing MyException from a()");
		throw new MyException();
	}
	/*
	 * 方法说明：使用MyException中带信息的构造器
	 * 输入参数：
	 * 返回类型：
	 */
	public static void b() throws MyException{
		System.out.println("Throwing MyException from b()");
		throw new MyException("Originated in b()");
	}
	/*
	 * 方法说明：使用MyException中有编码的构造器
	 * 输入参数：
	 * 返回类型：
	 */
	public static void c() throws MyException{
		System.out.println("Throw MyException from c()");
		throw new MyException("Originated in c()",47);
	}
	/*
	 * 方法说明：主函数
	 */
	public static void main(){
		try{
			a();
		}catch(MyException e){
			e.getMessage();
		}
		try{
			b();
		}catch(MyException e){
			e.toString();
		}
		try{
			c();
		}catch(MyException e){
			e.printStackTrace();
			System.out.println("Error code: " + e.val());
		}
	}
}
