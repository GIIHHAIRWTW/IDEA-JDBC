package example;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;
import pojo.Brand;

import javax.sql.DataSource;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author Lee-win10
 */

public class BrandTest {
    @Test
    public void testSelectAll() throws Exception {
        // 1.获取connection

        // 3.加载配置文件
        Properties prop = new Properties();
        prop.load(Files.newInputStream(Paths.get("src/druid.properties")));
        // 4.获取连接池对象

        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        // 5.获取数据库连接
        Connection coon = dataSource.getConnection();

        // 2.定义SQL
        String sql = "select * from tb_brand";

        // 3.获取pstmt对象
        PreparedStatement pstmt = coon.prepareStatement(sql);

        // 4.设置参数

        // 5.执行SQL
        ResultSet rs = pstmt.executeQuery();

        // 6.处理结果
        Brand brand;
        List<Brand> brands = new ArrayList<>();
        while(rs.next()) {
            int id = rs.getInt("id");
            String brandName = rs.getString("brand_name");
            String companyName = rs.getString("company_name");
            int ordered = rs.getInt("ordered");
            String description = rs.getString("description");
            int status = rs.getInt("status");
            brand = new Brand();

            brand.setId(id);
            brand.setBrandName(brandName);
            brand.setCompanyName(companyName);
            brand.setOrdered(ordered);
            brand.setDescription(description);
            brand.setStatus(status);

            brands.add(brand);
        }
        System.out.println(brands);
        // 7.释放资源
        rs.close();
        pstmt.close();
        coon.close();
    }


    @Test
    public void testAdd() throws Exception {
        // 接受页面提交的参数
        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered = 1;
        String description = "一年卖出三亿杯，绕地球一圈";
        int status = 1;

        // 1.获取connection

        // 3.加载配置文件
        Properties prop = new Properties();
        prop.load(Files.newInputStream(Paths.get("src/druid.properties")));
        // 4.获取连接池对象

        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        // 5.获取数据库连接
        Connection coon = dataSource.getConnection();

        // 2.定义SQL
        String sql = "insert into tb_brand(brand_name,company_name,ordered,description,status) values(?,?,?,?,?);";

        // 3.获取pstmt对象
        PreparedStatement pstmt = coon.prepareStatement(sql);

        // 4.设置参数
        pstmt.setString(1,brandName);
        pstmt.setString(2,companyName);
        pstmt.setInt(3,ordered);
        pstmt.setString(4,description);
        pstmt.setInt(5,status);

        // 5.执行SQL
        int count = pstmt.executeUpdate();
        System.out.println(count > 0);
        // 7.释放资源
        pstmt.close();
        coon.close();
    }


    @Test
    public void testUpdate() throws Exception {
        // 接受页面提交的参数
        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered = 1000;
        String description = "一年卖出三亿杯，绕地球三圈";
        int status = 1;
        int id = 4;

        // 1.获取connection

        // 3.加载配置文件
        Properties prop = new Properties();
        prop.load(Files.newInputStream(Paths.get("src/druid.properties")));
        // 4.获取连接池对象

        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        // 5.获取数据库连接
        Connection coon = dataSource.getConnection();

        // 2.定义SQL
        String sql = "update tb_brand set brand_name = ?,company_name = ?,ordered = ?,description = ?,status = ? where id = ?;";

        // 3.获取pstmt对象
        PreparedStatement pstmt = coon.prepareStatement(sql);

        // 4.设置参数
        pstmt.setString(1,brandName);
        pstmt.setString(2,companyName);
        pstmt.setInt(3,ordered);
        pstmt.setString(4,description);
        pstmt.setInt(5,status);
        pstmt.setInt(6,id);

        // 5.执行SQL
        int count = pstmt.executeUpdate();
        System.out.println(count > 0);
        // 7.释放资源
        pstmt.close();
        coon.close();
    }


    @Test
    public void testDeleteById() throws Exception {
        // 接受页面提交的参数
        int id = 4;

        // 1.获取connection

        // 3.加载配置文件
        Properties prop = new Properties();
        prop.load(Files.newInputStream(Paths.get("src/druid.properties")));
        // 4.获取连接池对象

        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        // 5.获取数据库连接
        Connection coon = dataSource.getConnection();

        // 2.定义SQL
        String sql = "delete from tb_brand where id = ?;";

        // 3.获取pstmt对象
        PreparedStatement pstmt = coon.prepareStatement(sql);

        // 4.设置参数

        pstmt.setInt(1,id);

        // 5.执行SQL
        int count = pstmt.executeUpdate();
        System.out.println(count > 0);
        // 7.释放资源
        pstmt.close();
        coon.close();
    }
}
