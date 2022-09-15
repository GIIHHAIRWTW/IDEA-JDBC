package jdbc;

import org.junit.Test;

import java.sql.*;

public class jdbcDemo4_Statement {

    @Test
    public void testDML() throws Exception {
        // 1.注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        // 2.获取连接
        String url = "jdbc:mysql:///myclass?useSSL=false";
        String username = "root";
        String password = "whoami";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3.定义sql
        String sql = "update b210410 set QQ = '2878348186' where id = 22";
        // 4.获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();
        // 5.执行sql
        int count = stmt.executeUpdate(sql);
        // 6.处理结果
        if(count > 0){
            System.out.println("修改成功!");
        }else{
            System.out.println("修改失败!");

        }
        // 7.释放资源
        stmt.close();
        conn.close();
    }



    @Test
    public void testDDL() throws Exception {
        // 1.注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        // 2.获取连接
        String url = "jdbc:mysql:///myclass?useSSL=false";
        String username = "root";
        String password = "whoami";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3.定义sql
        String sql = "drop database db2";
        // 4.获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();
        // 5.执行sql
        int count = stmt.executeUpdate(sql);
        // 6.处理结果
        System.out.println(count);
        /*if(count > 0){
            System.out.println("修改成功!");
        }else{
            System.out.println("修改失败!");

        }*/
        // 7.释放资源
        stmt.close();
        conn.close();
    }


    @Test
    public void testDQL() throws Exception {
        // 1.注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        // 2.获取连接
        String url = "jdbc:mysql:///myclass?useSSL=false";
        String username = "root";
        String password = "whoami";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 3.定义SQL
        String sql = "select * from b210410";

        // 4.获取 statement 对象
        Statement stmt = conn.createStatement();

        // 5.执行sql
        ResultSet rs = stmt.executeQuery(sql);

        // 6.处理结果，遍历 rs 中的所有数据
        /*while(rs.next()){
            //获取数据
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String QQ = rs.getString(3);
            String WeChat = rs.getString(4);

            System.out.println(id);
            System.out.println(name);
            System.out.println(QQ);
            System.out.println(WeChat);
            System.out.println("---------------");
        }*/

        while(rs.next()){
            //获取数据
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String QQ = rs.getString("QQ");
            String WeChat = rs.getString("WeChat");

            System.out.println(id);
            System.out.println(name);
            System.out.println(QQ);
            System.out.println(WeChat);
            System.out.println("---------------");
        }

        // 7.释放资源
        rs.close();
        stmt.close();
        conn.close();
    }
}
