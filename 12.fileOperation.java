import java.io.*;
import java.util.*;
/*
 *Author: Create by 李呈云
 *Description: 演示文件的删除和获取文件的信息
 *Date: 2016-9-2 下午4:46:21  
 */

public class FileOperation {
	/*
	 * 方法说明：删除文件
	 * 输入参数：String file 待删除的文件名
	 * 输出类型：删除成功返回true,删除失败返回false
	 */
	public boolean delFile(String filename){
		File file = new File(filename);
		boolean delsuccess = true;
		try{
			delsuccess = file.delete();
			if(!delsuccess)
				delsuccess = false;
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
		return delsuccess;
	}
	/*
	 * 方法说明：获取文件信息
	 * 输入参数：String filename 文件名
	 * 返回类型：String[] 文件信息数组
	 */
	public String[] getFileInof(String filename){
		try{
			File file = new File(filename);
			//获取文件修改日期（返回的是句）
			long modifiedTime = file.lastModified();
			//获取文件长度（单位：bite）
			long fileSize = file.length();
			//测试文件是否可读
			boolean cr = file.canRead();
			//测试文件是否可写
			boolean cw = file.canWrite();
			//测试文件是否隐藏
			boolean ih = file.isHidden();
			//获取文件路径
			String path = file.getCanonicalPath();
			
			String[] sTemp = new String[6];
			sTemp[0] = String.valueOf(fileSize);
			sTemp[1] = getDateString(modifiedTime);
			sTemp[2] = String.valueOf(cr);
			sTemp[3] = String.valueOf(cw);
			sTemp[4] = String.valueOf(ih);
			sTemp[5] = String.valueOf(path);
			return sTemp;
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
	}
	/*
	 * 方法说明：将毫秒数字转换为日期
	 * 输入参数：long mill 毫秒数
	 * 返回类型：String 字符串 格式为：yyyy-mm-dd hh:mm
	 */
	public static String getDateString(long mill)
	  {
	    if(mill < 0) return  "";
	    
	    Date date = new Date(mill);
	    Calendar rightNow = Calendar.getInstance();
	    rightNow.setTime(date);
	    int year = rightNow.get(Calendar.YEAR);
	    int month = rightNow.get(Calendar.MONTH);
	    int day = rightNow.get(Calendar.DAY_OF_MONTH);
	    int hour = rightNow.get(Calendar.HOUR_OF_DAY);
	    int min = rightNow.get(Calendar.MINUTE);

	    return year + "-" + (month <10 ? "0" + month : "" + month) + "-" 
	           +  (day <10 ? "0" + day : "" + day)
	           +  (hour <10 ? "0" + hour : "" + hour)+":"
	           + (min <10 ? "0" + min : "" + min);
	  }
	/*
	 * 方法说明：主函数
	 */
	public static void main(String[] args){
		FileOperation fo = new FileOperation();
		String filename = "d:/a.txt";
		String outfile = "d:/b.txt";
		if(fo.delFile(filename)){
			System.out.println("del success!");
		}else{
			System.out.println("del error");
		}
		String[] sTemp = fo.getFileInof(outfile);
		for(int i = 0; i < sTemp.length; i++){
			System.out.println(sTemp[i]);
		}
	}
}
