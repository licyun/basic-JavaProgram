
/*
 *Author: Create by 李呈云
 *Description: 使用结果集元数据对象获取数据库信息。
 *Date: 2016-9-4 上午9:27:46  
 */

import java.sql.*;
import java.util.*;

public class JDBCResultMeta {
	public static String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/jdbc";
	private String username = "root";
	private String password = "123456";
	Connection con = null;
	PreparedStatement ps = null;
	/*
	 * 方法说明：获得数据连接
	 * 输入参数：
	 * 输出参数：Connection 连接对象
	 */
	public Connection conn(){
		try{
			//加载jdbc驱动
			Class.forName(driver);
			//创建数据库连接
			con = DriverManager.getConnection(url, username, password);
			return con;
		}catch(ClassNotFoundException cnf){
			System.out.println("driver not find:" + cnf);
			return null;
		}catch(SQLException se){
			System.out.println("can't connection db:"+ se);
			return null;
		}catch(Exception e){
			System.out.println("Failed to load JDBC driver.");
			return null;
		}
	}
	/*
	 * 方法说明：关闭数据库
	 * 
	 */
	public void close(){
		try{
			con.close();
		}catch(Throwable e){
			System.out.println(e);
		}
		con = null;
	}
	/*
	 * 方法说明：获取结果集原数据信息
	 * 输入参数：String table 表名称
	 * 输出参数：Vector vResult 结果对象
	 */
	public Vector getResult(String table){
		Vector vResult = new Vector();
		ResultSet rs = null;
		try{
			con = conn();
			ps = con.prepareStatement("select * from jdbc_user ;");
			String sTable = table.toString();
			//ps.setString(1, sTable);
			rs = ps.executeQuery();
			ResultSetMetaData rsd = rs.getMetaData();
			int columCount = rsd.getColumnCount();
			Vector vTemp = new Vector();
			for(int i = 0; i < columCount; i ++){
				String sTemp = rsd.getColumnName(i+1);
				vTemp.addElement(sTemp == null ? "" : sTemp.trim());
			}
			vResult.addElement(vTemp);
			while(rs.next()){
				vTemp = new Vector();
				for(int i = 0; i < columCount; i++){
					String sTemp = rs.getString(i+1);
					vTemp.addElement(sTemp == null ? "" : sTemp.trim());
					
				}
				vResult.addElement(vTemp);
			}
			rs.close();
			ps.close();
		}catch(SQLException se){
			System.out.println(se);
		}finally{
			close();
		}
		return vResult;
	}
	/*
	 * 方法说明：演示方法
	 */
	public static void demo(){
		try{
			JDBCResultMeta jrm = new JDBCResultMeta();
			String table = "jdbc_user";
			Vector vTemp = jrm.getResult(table);
			for(int i = 0; i < vTemp.size(); i++){
				System.out.println(vTemp.elementAt(i));
			}	
		}catch(Exception e){
			System.out.println(e);
		}
	}
	/*
	 * 方法说明：主方法
	 */
	public static void main(String[] args){
		demo();
	}
}
