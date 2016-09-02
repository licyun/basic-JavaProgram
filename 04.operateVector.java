/*
 *Author: Create by 李呈云
 *Description: 演示一个矢量（Vector）的基本操作
 *Date: 2016-9-2 上午8:21:43  
 */

import java.util.*;

public class operateVector {
	/*
	 * 方法说明：生成一个4*4的二维Vector
	 * 输入参数：
	 * 输出变量：Vector
	 */
	public Vector buildVector(){
		Vector vTemps = new Vector();
		for(int i = 0; i < 4; i ++){
			Vector vTemp = new Vector();
			for(int j = 0; j < 4; j++){
				vTemp.addElement("Vector("+i+")("+j+")");
			}
			vTemps.addElement(vTemp);
		}
		return vTemps;
	}
	
	/*
	 * 方法说明：插入数据
	 * 输入参数：Vector vTemp 待插入数据对象
	 * 输入参数：int iTemp 插入的位置
	 * 输入参数：Object oTemp 插入数据的值
	 * 输出变量：Vector vTemp 
	 */
	public Vector vInsert(Vector vTemp, int iTemp, Object oTemp){
		if(iTemp > vTemp.size()){
			System.out.println("数组越界");
			return null;
		}else{
			vTemp.insertElementAt(oTemp,iTemp);
		}
		return vTemp;
		
	}
	/*
	 * 方法说明：移除数据
	 * 输入参数：Vector vTemp 待移除的数据对象
	 * 输入参数：int iTemp 移除数据的位置
	 * 输出变量：Vector vTemp
	 */
	public Vector vDelete(Vector vTemp, int iTemp){
		if(iTemp > vTemp.size()){
			System.out.println("数组越界");
			return null;
		}else{
			vTemp.removeElementAt(iTemp);
		}
		return vTemp;
	}
	
	/*
	*<br>方法说明：修改数据
	*<br>输入参数：Vector vTemp 待修改矢量对象
	*<br>输入参数：int iTemp 修改数据的位置
	*<br>输入参数：Object oTemp 修改数据值
	*<br>输出变量：Vector
	*<br>其它说明：如果修改位置超界的数据，将返回null
	*/
	    public Vector vUpdata(Vector vTemp,int iTemp,Object oTemp){
	        if(iTemp>vTemp.size()){
	            print("数据超界!");
	            return null;
	        }else{
	             vTemp.setElementAt(oTemp,iTemp);
	        }
	        return vTemp;
	    }
	/*
	*方法说明：输出信息
	*输入参数：String sTemp 输出信息名称
	*输入参数：Object oTemp 输出信息值
	*返回变量：无
	*/
	    public void print(String sTemp,Vector oTemp){
	        System.out.println(sTemp+"数据：");
	        this.print(oTemp);
	    }
	/*
	 *方法说明：打印输出（过载）
	 *输入参数：Object oParam 输出的对象
	 *返回类型：无
	 */
	    public void print(Object oParam){
	        System.out.println(oParam);
	    }
	/*
	 *方法说明：打印输出（过载）
	 *输入参数：Vector vPara 显示输出矢量对象
	 *返回类型：无
	 */
	    public void print(Vector vPara){
	       for(int i=0;i<vPara.size();i++){
	        System.out.println(vPara.elementAt(i));
	       }
	    }
	/*
	 *方法说明：主方法，程序入口
	 *输入参数：String[] args
	 *返回类型：无
	 */
	    public static void main(String[] args) 
	    {
	        operateVector ov = new operateVector();
	        Vector vTemp = ov.buildVector();
	        ov.print("vTemp0",vTemp);
	        Vector vResult = ov.vInsert(vTemp,2,"添加的数据");
	        ov.print("vResult",vResult);
	        Vector vResultup = ov.vUpdata(vResult,2,"修改的数据");
	        ov.print("vResultmp",vResultup);
	        Vector vResultnow = ov.vDelete(vResultup,2);
	        ov.print("vResultnow",vResultnow);
	    }
}
