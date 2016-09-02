/*
 *Author: Create by 李呈云
 *Description: 
 *Date: 2016-9-2 下午2:40:06  
 */

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
	/*
	 * 方法说明：构造器，通过传递参数来完成窗体的构建
	 * 输入参数：String sTitle 窗体标题
	 * 输入参数：int iWidth 窗体宽度
	 * 输入参数： int iHeight 窗体高度
	 * 返回类型：
	 */
	public MainFrame(String sTitle, int iWidth, int iHeight){
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//获取屏幕尺寸
		setTitle(sTitle);											//设置标题
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);			//设置当窗体关闭时退出
		setSize(iWidth, iHeight);									//设置窗体大小
		int w = getSize().width;									//获取窗体宽度
		int h = getSize().height;									//获取窗体高度
		System.out.println("窗体宽："+ w +" 窗体高："+ h);				
		int x = (dim.width - w)/2;
		int y = (dim.height - h)/2;
		setLocation(x, y);											//设置窗体位置
		setVisible(true);											//显示窗体
	}
	
	public static void main(String[] args){
		JFrame.setDefaultLookAndFeelDecorated(true);//使用最新的SWING外观
		MainFrame mf = new MainFrame("main Frame Demo",400,300);
	}
}
