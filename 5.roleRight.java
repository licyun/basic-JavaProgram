/*
 *Author: Create by 李呈云
 *Description: 这是一个权限认证的例子，使用了哈希表作为数据的存储
 *Date: 2016-9-2 上午9:36:12  
 */

import java.util.*;

public class roleRight {
	private static Hashtable<String, String> rightList = new Hashtable();
	/*
	 * 方法说明：初始化数据
	 * 输入参数：无
	 * 输出参数：无
	 */
	public void init(){
	    String[] roleList = {"admin","satrap","manager","user","guest"};
	    String[] rightCodeList = {"10001","10011","10021","20011","24011"};
	    for(int i = 0; i < roleList.length; i++){
	    	rightList.put(roleList[i], rightCodeList[i]);
	    }
	}
	/*
	 * 方法说明：获取角色权限代码
	 * 输入参数：String role 角色名称
	 * 返回类型：String 权限代码
	 */
	public String hashGet(String role){
		if(rightList.contains(role)){
			return (String)rightList.get(role);
		}else{
			return null;
		}
	}
	/*
	 *方法说明：添加角色和代码信息
	 *输入参数：String accRole 角色名称
	 *输入参数：String rightCode 角色权限代码 
	 *返回类型：void （无）
	 */
	 public void hashInsert(String key,String value)
	 {
	   rightList.put(key,value);
	 }
	/*
	 * 方法说明：添加角色和代码信息
	 * 输入参数：String role 角色名称
	 * 返回类型： 无
	 */
	public void hashDelete(String role){
		if(rightList.contains(role)){
			rightList.remove(role);
		}
	}
	/*
	 * 方法说明：修改角色权限和代码对应表
	 * 输入参数：String role 角色名称
	 * 输入参数：String code 权限代码
	 * 返回类型：无
	 */
	public void hashUpdate(String role, String code){
		if(rightList.contains(role)){
			rightList.remove(role);
			rightList.put(role, code);
		}
	}
	/*
	 * 方法说明：打印hash表中的键和值
	 * 输入参数：无
	 * 输出参数：无
	 */
	public void hashPrint(){
		Enumeration keyValue = rightList.keys();
		while(keyValue.hasMoreElements()){
			String key = keyValue.nextElement().toString();
			System.out.println(key + "=" + rightList.get(key));
		}
	}
	/*
	 *<br>方法说明：打印信息（过载）
	 *<br>输入参数：Object oPara 打印的信息内容
	 *<br>返回类型：无
	 */
	 public void hashPrint(Object oPara)
	 {
	    System.out.println(oPara);
	 }
	/*
	 *<br>方法说明：主方法，
	 *<br>输入参数：
	 *<br>返回类型：
	 */
	 public static void main(String[] args)
	 {
	    roleRight RR = new roleRight();
	    RR.init();
	    RR.hashPrint();
	    RR.hashPrint("___________________________");
	    RR.hashInsert("presider","10110");
	    RR.hashPrint();
	    RR.hashPrint("___________________________");
	    RR.hashUpdate("presider","10100");
	    RR.hashPrint();
	    RR.hashPrint("___________________________");
	    RR.hashDelete("presider");
	    RR.hashPrint();
	 } 
}
