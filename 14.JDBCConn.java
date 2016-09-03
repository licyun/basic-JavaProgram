/*
 *Author: Create by 李呈云
 *Description: 本实例演示如何使用JDBC连接Mysql数据库，并演示添加数据和查询数据。
 *Date: 2016-9-3 下午3:53:01  
 */

import java.sql.*;

public class JDBCConn {
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/jdbc";
	private String username = "root";
	private String password = "123456";
	/*
	 * 方法说明：获得数据连接
	 * 输入参数：
	 * 返回类型：Connection 连接对象
	 */
	public Connection conn(){
		try{
			//加载jdbc驱动
			Class.forName(driver);
			//创建数据库连接
			Connection conn = DriverManager.getConnection(url, username, password);
			return conn;
		}catch(ClassNotFoundException cnf){
			System.out.println("driver not find :"+ cnf);
		}catch(SQLException sqle){
			System.out.println("can't connection db:"+ sqle);
			return null;
		}catch(Exception e){
			System.out.println("Failed to load JDBC driver");
			return null;
		}
		return null;
	}
	/*
	 * 方法说明：执行查询SQL语句
	 * 输入参数：Connection conn 数据库连接
	 * 输入参数： String sql 要执行的sql语句
	 * 
	 */
	public void query(Connection conn, String sql){
		try{
			if(conn == null){
				throw new Exception("database connection can't use!");
			}
			if(sql == null){
				throw new Exception("check you parameter: 'sql' don't input null");
			}
			//创建statement对象，以便后面调用该对象的数据库操作方法
			Statement stmt = conn.createStatement();
			//执行查询
			ResultSet rs = stmt.executeQuery(sql);
			//获取操作后的返回信息
			ResultSetMetaData rsmd = rs.getMetaData();
			//获得数据字段个数
			int numColums = rsmd .getColumnCount();
			while(rs.next()){
				for(int i = 0; i < numColums; i++){
					String sTemp = rs.getString(i+1);
					System.out.print(sTemp+" ");
				}
				System.out.println();
			}
		}catch(Exception e){
			System.out.println("query error:"+ e);
		}
	}
	/*
	 * 方法说明：执行插入，更新，删除等没有返回结果集的SQL语句
	 * 输入参数：Connection conn 数据库连接
	 * 输入参数：String sql 要执行的SQL语句
	 * 返回类型：
	 */
	public void execute(Connection conn, String sql){
		try{
			if(conn == null ) 
				return;
			//创建statement对象
			Statement sm = conn.createStatement();
			sm.executeUpdate(sql);
		}catch(Exception e){
			System.out.println("excute error: sql = "+ sql);
			System.out.println(e);
		}
	}
	/*
	 * 方法说明：实例演示
	 * 
	 */
	public void demo(){
		try{
			JDBCConn jc = new JDBCConn();
			Connection conn = jc.conn();
//			//创建表的sql语句
//			String csql = "create table jdbc_user(id char(20), name char(20), password char(20));";
			//插入表的sql语句
			String isql = "insert into jdbc_user(id, name, password) " +
					"values(1, 'switch', '123456')";
			//执行对应的sql语句操作
//			jc.execute(conn, csql);
			jc.execute(conn, isql);
			//查询表的sql语句
			String sql = "select * from jdbc_user";
			jc.query(conn, sql);
			//关闭数据库连接
			conn.close();
		}catch(SQLException se){
			System.out.println(se);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	/*
	 * 方法说明：主方法
	 * 
	 */
	public static void main(String[] args){
		JDBCConn jc = new JDBCConn();
		jc.demo();
	}
}
