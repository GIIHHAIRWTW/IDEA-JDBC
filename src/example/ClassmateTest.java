package example;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;
import pojo.Myclass;

import javax.sql.DataSource;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ClassmateTest {
    @Test
    public void testSelectAll() throws Exception {
        Properties prop = new Properties();
        prop.load(Files.newInputStream(Paths.get("src/druid2.properties")));

        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        Connection coon = dataSource.getConnection();

        String sql = "select * from b210410";

        PreparedStatement pstmt = coon.prepareStatement(sql);

        ResultSet rs = pstmt.executeQuery();

        Myclass myclass;
        List<Myclass> mates = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String QQ = rs.getString("QQ");
            String Wechat = rs.getString("Wechat");
            myclass = new Myclass();

            myclass.setId(id);
            myclass.setName(name);
            myclass.setQQ(QQ);
            myclass.setWechat(Wechat);

            mates.add(myclass);
        }
        System.out.println(mates);

        rs.close();
        pstmt.close();
        coon.close();
    }
}
