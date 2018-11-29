package cn.my.jdbc.connection;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Test;
import cn.my.jdbc.JDbctest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
public class JDBcConnection {
	private static Connection conn=null;
	  @Test
	public void fun1() throws ClassNotFoundException, SQLException{
		JDbctest jdbc=new JDbctest();
		Class.forName("com.mysql.jdbc.Driver");//加载驱动类
		String url="jdbc:mysql://localhost:3306/stu_info";
		String username="root";
		String password="mysql123";
	    conn=DriverManager.getConnection(url,username,password);//用参数得到连接对象
//		jdbc.jdball();
		/**
		 * 对数据库进行增、删、查、改;
		 */
		//1.通过connection得到statement
		Statement stmt=conn.createStatement();
		//2.使用statement发送sql语句！                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
		String sql1="select * from student";
		String sql2="insert into student values(181,'张二风','123852')";
		String sql3="update student set sname='liu' where s_id=11"; 
		int r=stmt.executeUpdate(sql3);
		System.out.println(r);
	}
	  @Test
	  public void funFind() throws ClassNotFoundException{
		  /**
		   * 得到connection,得到statement,发送select语句
		   * 对查询结果进行解析
		   * 1.得到连接
		   */
		  String driverClassName="com.mysql.jdbc.Driver";
		  String url="jdbc:mysql://localhost:3306/info";
		  String username="root";
		  String password="mysql123";
		  //加载驱动
		  Class.forName(driverClassName);
		  try {
			Connection conn=DriverManager.getConnection(url,username,password);
			//得到statement,执行select语句，使用的方法;connection的createstatement
			Statement stmt=conn.createStatement();
			ResultSet rS=stmt.executeQuery("select * from student");
			  //解析resultset
			while(rS.next()){
				rS.getInt(1);//通过列编号获取
				rS.getString(2);
				rS.getString(3);
				System.out.println(	rS.getInt(1)+rS.getString(2)+rS.getString(3));
				
			}
			 rS.close();
			 stmt.close();
			  conn.close();
			  //关闭资源连接
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
}
