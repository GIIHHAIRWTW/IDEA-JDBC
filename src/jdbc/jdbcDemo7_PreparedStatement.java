package jdbc;

import org.junit.Test;

import java.sql.*;

public class jdbcDemo7_PreparedStatement {
    @Test
    public void testPreparedStatememt() throws Exception {
        // 2.获取连接
        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "whoami";
        Connection conn = DriverManager.getConnection(url, username, password);

        String name = "zhangsan";
        String pwd = "' or '1' = '1";

        //定义sql
        String sql = "select * from tb_user where username = ? and password = ?";

        //获取 pstmt 对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //设置 ? 的值
        pstmt.setString(1, name);
        pstmt.setString(2, pwd);

        //执行sql
        ResultSet rs = pstmt.executeQuery();

        //判断是否登录成功
        if (rs.next()) {
            System.out.println("登录成功!");
        } else {
            System.out.println("登录失败!");
        }

        // 7.释放资源
        rs.close();
        pstmt.close();
        conn.close();
    }


    @Test
    public void testPreparedStatememt2() throws Exception {
        // 2.获取连接
        String url = "jdbc:mysql:///db1?useSSL=false&useServerPrepStmts=true";
        String username = "root";
        String password = "whoami";
        Connection conn = DriverManager.getConnection(url, username, password);

        String name = "zhangsan";
        String pwd = "' or '1' = '1";

        //定义sql
        String sql = "select * from tb_user where username = ? and password = ?";

        //获取 pstmt 对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //设置 ? 的值
        pstmt.setString(1, name);
        pstmt.setString(2, pwd);

        //执行sql
        ResultSet rs = pstmt.executeQuery();

        //判断是否登录成功
        if (rs.next()) {
            System.out.println("登录成功!");
        } else {
            System.out.println("登录失败!");
        }

        // 7.释放资源
        rs.close();
        pstmt.close();
        conn.close();
    }
}
