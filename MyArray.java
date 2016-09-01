/*
 *Author: Create by 李呈云
 *Description: 演示一维数组和多维数组的初始化和基本操作
 *Date: 2016-8-31 下午02:43:45
 */

 public class MyArray {
	//初始化数组变量
	char[] cNumArray = {'1','2','3','4','5','6','7','8','9','0'};
	char[] cStrArray = {'a','b','c','d','e','f','g','h',			
					'i','j','k','l','m','n','o','p',
					'q','r','s','t','u','v','w','x','y','z'};
	int[] iMonthArray = {31,28,31,30,31,30,31,31,30,31,30,31};
	String[] sMailArray = {"@","."};
/*
 *<br>方法说明：校验电子邮件
 *<br>输入参数：String sMail 被校验的电子邮件字符
 *<br>返回类型：boolean 如果校验的格式符合电子邮件格式返回true；否则返回false
 */  
	public boolean isMail(String sMail){
		int mLength = sMailArray.length;
		for(int i = 0; i < mLength; i++){
			if(sMail.indexOf(sMailArray[i]) == -1)
				return false;
		}
		return true;
	}
	
/*
 *方法说明：判断是否是数字
 *输入参数：String sPara。 需要判断的字符串
 *返回类型：boolean。如果都是数字类型，返回true；否则返回false
 */  
	public boolean isNum(String sNum){
		int sNLength = sNum.length();
		int sNALength = cNumArray.length;
		for(int i = 0; i < sNLength; i ++){
			char cTemp = sNum.charAt(i);
			boolean bTemp = false;
			for(int j = 0; j < sNALength; j ++){
				if(cTemp == cNumArray[j]){
					bTemp = true;
					break;
				}
			}
			if(bTemp == false) 
				return false;
		}
		return true;
	}
	/*
	 * 方法说明：判断是否为英文字符
	 * 输入参数：String sParam。要检查的字符
	 * 返回类型：boolean。如果多是字符串返回true，反之false
	 */
	public boolean isString(String sParam){
		int iPLength = sParam.length();
		int iCLength = cStrArray.length;
		for(int i = 0; i < iPLength; i++){
			char cTemp = sParam.charAt(i);
			boolean bTemp = false;
			for(int j = 0; j < iCLength; j++){
				if(cTemp == cStrArray[j]){
					bTemp = true;
					break;
				}
			}
			if(bTemp == false) 
				return false;
		}
		return true;
	}
	/*
	 * 方法说明：判断是否为闰年
	 * 输入参数：年份
	 * 返回类型：为闰年返回true，非闰年返回false
	 */
	public boolean isLeapYear(int iParam){
		boolean bTemp = false;
		if((iParam % 4 == 0 && iParam % 100 != 0) || iParam % 400 ==0)
			bTemp = true;
		return bTemp;
	}
	/*
	 * 方法说明：检查日期格式是否正确 
	 * 输入参数：年-月-日 如：2016-09-01
	 * 返回类型： 日期正确返回true，错误返回false
	 */
	public boolean isData(String sParam){
		//bTemp 判断是否为年份
		boolean bTemp = true;
		if(sParam.length() != 9){
			return false;
		}
		//分隔字符串获取年月日
		String sYear = sParam.substring(1,5);
		String sMonth = sParam.substring(6,8);
		String sDay = sParam.substring(9);
		//判断字符串是否输入正确
		if(!(isNum(sYear) && isNum(sMonth) && isNum(sDay))) 
			return false;
		//将字符串的年月日转换为整型
		int iYear = Integer.parseInt(sYear);
		int iMonth = Integer.parseInt(sMonth);
		int iDay = Integer.parseInt(sDay);
		if(iMonth > 12) return false;
		//闰年二月份
		if(iMonth == 2 && isLeapYear(iYear)){
			if(iDay > 29) return false;
		}else{
			if(iDay > iMonthArray[iMonth - 1]) return false;
		}
		return bTemp;
	}
	
	public static void main(String[] args){
		MyArray mA = new MyArray();
	     //校验邮件地址
	     boolean bMail = mA.isMail("tom@163.com");
	     System.out.println("1 bMail is "+bMail);
	     bMail = mA.isMail("tom@163com");
	     System.out.println("2 bMail is "+bMail);
	     //演示是否是数字
	     boolean bIsNum = mA.isNum("1234");
	     System.out.println("1：bIsNum="+bIsNum);
	     bIsNum = mA.isNum("123r4");
	     System.out.println("2：bIsNum="+bIsNum);
	     //演示是否是英文字符
	     boolean bIsStr = mA.isString("wer");
	     System.out.println("1：bIsStr="+bIsStr);
	     bIsStr = mA.isString("wer3");
	     System.out.println("2：bIsStr="+bIsStr);
	     //演示检查日期
	     boolean iIsTime = mA.isData("2003-12-98");
	     System.out.println("1：iIsTime="+iIsTime);
	     iIsTime = mA.isData("2003-111-08");
	     System.out.println("2：iIsTime="+iIsTime);
	     iIsTime = mA.isData("2003-10-08");
	     System.out.println("3：iIsTime="+iIsTime);
	     iIsTime = mA.isData("2000-02-30");
	     System.out.println("4：iIsTime="+iIsTime);		
	}
	
}
