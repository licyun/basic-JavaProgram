/*
 *Author: Create by 李呈云
 *Description: 通过使用URL类，构造一个输入对象，并读取其内容。
 *Date: 2016-9-3 上午10:50:11  
 */

import java.io.*;
import java.net.*;

public class GetUrl {
	/*
	 * 方法说明：构造器
	 * 输入参数：String url 互联网地址
	 * 
	 */
	public GetUrl(String surl){
		try{
			//创建一个url对象
			URL url = new URL(surl);
			//获取网页源码
			InputStreamReader isr = new InputStreamReader(url.openStream(),"utf-8");
			//将源码输出到缓存流
			BufferedReader br = new BufferedReader(isr);
			String str ;
			while((str = br.readLine()) !=  null){
				//输出源码
				System.out.println(str);
			}
			br.close();
		}catch (MalformedURLException e) {
	    } catch (IOException e) {
	    }
	}
	/*
	 * 方法说明：主函数
	 */
	public static void main(String[] args){
		String surl = "https://www.baidu.com/";
		new GetUrl(surl);
	}
}
