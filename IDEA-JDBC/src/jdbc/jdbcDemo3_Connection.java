package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcDemo3_Connection {
    public static void main(String[] args) throws Exception {
        // 1.注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        // 2.获取连接
        String url = "jdbc:mysql:///myclass?useSSL=false";
        String username = "root";
        String password = "whoami";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3.定义sql
        String sql1 = "update b210410 set QQ = '2878348186' where id = 22";
        String sql2 = "update b210410 set WeChat = 'EVANGELION0389' where id = 22";
        // 4.获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();

        try {
            // 开启事务
            conn.setAutoCommit(false);
            // 5.执行sql
            int count1 = stmt.executeUpdate(sql1);
            // 6.处理结果
            System.out.println(count1);

            // 5.执行sql
            int count2 = stmt.executeUpdate(sql2);
            // 6.处理结果
            System.out.println(count2);

            // 提交事务
            conn.commit();
        } catch (SQLException e) {
            // 回滚事务
            conn.rollback();
            throw new RuntimeException(e);
        }

        // 7.释放资源
        stmt.close();
        conn.close();
    }
}
