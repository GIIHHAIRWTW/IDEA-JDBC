package jdbc;

import org.junit.Test;
import pojo.Account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class jdbcDemo5_ResultSet {
    @Test
    public void testDQL() throws Exception {
        // 1.注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        // 2.获取连接
        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "whoami";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 3.定义SQL
        String sql = "select * from account";

        // 4.获取 statement 对象
        Statement stmt = conn.createStatement();

        // 5.执行sql
        ResultSet rs = stmt.executeQuery(sql);

        List<Account> list = new ArrayList<>();
        // 6.处理结果，遍历 rs 中的所有数据
        while(rs.next()){
            Account account = new Account();
            //获取数据
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double money = rs.getDouble("money");

            account.setId(id);
            account.setName(name);
            account.setMoney(money);

            list.add(account);
        }

        System.out.println(list);

        // 7.释放资源
        rs.close();
        stmt.close();
        conn.close();
    }
}
