/*
 *Author: Create by 李呈云
 *Description: 本实例演示使用语句方式查询数据库操作。语句是一种预处理的执行方法。
 *Date: 2016-9-3 下午7:24:31  
 */

import java.sql.*;
import java.util.*;

public class PSCon {
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
	 * 方法说明：语句执行
	 */
	private PreparedStatement getStatement(String sql, Vector vCondition) throws SQLException{
		try{
			int i = 0;
			Object otemp;
			//创建preparedStatment对象
			ps = conn().prepareStatement(sql);
			for(i = 0; i < vCondition.size(); i++){
				otemp = vCondition.elementAt(i);
				if(otemp instanceof Integer){
					int in = ((Integer)otemp).intValue();
					ps.setInt(i+1, in);
				}
				else if(otemp instanceof Double){
					Double db = ((Double)otemp).doubleValue();
					ps.setDouble(i +1, db);
				}
				else if(otemp instanceof String){
					String str = (otemp.toString()).trim();
					ps.setString(i + 1, str);
				}
			}
		}catch(SQLException e){
			throw e;
		}
		return ps;
	}
	/*
	 * 方法说明：关闭语句对象
	 */
	public void closePs(){
		try{
			if(ps != null){
				ps.close();
			}
		}catch(Throwable e){
			System.out.println(e);
		}
		ps = null;
	}
	/*
	 * 方法说明：执行SQL
	 */
	public Vector execute(String sql, Vector vCondition) throws SQLException,Exception{
		ResultSet rs = null;
		Vector vResult = null;
		try{
			if(!isSelect(sql)){
				//insert,update,delete
				try{
					ps = getStatement(sql, vCondition);
					int iResult = ps.executeUpdate();
					vResult.addElement(iResult);
					return vResult;
				}catch(SQLException se){
					throw se;
				}
			}else{
				//select
				System.out.println("select");
				ps = getStatement(sql, vCondition);
				rs = ps.executeQuery();
				int columCount = rs.getMetaData().getColumnCount();
				System.out.println(columCount);
				vResult = new Vector();
				while(rs.next()){
					Vector vTemp = new Vector();
					for(int i = 0; i < columCount; i ++){
						String sTemp = rs.getString(i+1);
						vTemp.addElement(sTemp == null ? "" : sTemp.trim());
					}
					vResult.addElement(vTemp);
				}
				rs.close();
				ps.close();
			}
		}catch(Exception e){
			throw e;
		}finally{
			close();
		}
		return vResult;
	}
	/*
	 * 方法说明：判断是否为查询sql语句
	 */
	protected boolean isSelect(String ssql){
		boolean iss = false;
		String sql = ssql.trim().toUpperCase();
		if(sql.indexOf("SELECT") != -1){
			iss = true;
		}		
		return iss;
	}
	/*
	 * 方法说明：主函数
	 */
	public static void main(String[] args){
		demo();
	}
	/*
	 * 方法说明：演示实例
	 */
	public static void demo(){
		try{
			PSCon psc = new PSCon();
			String sql = "select * from jdbc_user where id > ?;";
			Vector vCondition = new Vector();
			vCondition.addElement(new Integer(3));
			Vector vResult = (Vector)psc.execute(sql, vCondition);
			for(int i = 0; i < vResult.size(); i++){
				System.out.println(vResult.elementAt(i));
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
