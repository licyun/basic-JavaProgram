import java.io.*;

/*
 *Author: Create by 李呈云
 *Description: 
 *Date: 2016-9-2 下午4:03:54  
 */

public class CopyBytes {
	/*
	 * 方法说明：主方法
	 */
	public static void main(String[] args) throws IOException{
		String sFile = "d:/a.txt";
		String oFile = "d:/b.txt";
		try{
			File inputFile = new File(sFile);//定义读取源文件
			File outputFile = new File(oFile);//定义拷贝目标文件
			//定义输入文件流
			FileInputStream in = new FileInputStream(inputFile);
			//将文件输入流构造到缓存
			BufferedInputStream bin = new BufferedInputStream(in);
			//定义输出文件流
			FileOutputStream out = new FileOutputStream(outputFile);
			//将输出文件构造到缓存
			BufferedOutputStream bout = new BufferedOutputStream(out);
			int c;
			//循环读取文件和写入文件
			while((c = bin.read()) != -1)
				bout.write(c);
			//关闭输入输出流，释放资源
			bin.close();
			bout.close();
		}catch(IOException e){
			//文件操作，捕获IO异常
			System.err.println(e);
		}
	}
}
