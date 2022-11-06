package druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author Lee-win10
 */
public class DruidDemo1 {
    public static void main(String[] args) throws Exception {
        // 1.导入jar包
        // 2.定义配置文件
        // 3.加载配置文件
        Properties prop = new Properties();
        prop.load(Files.newInputStream(Paths.get("src/druid.properties")));
        // 4.获取连接池对象

        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        // 5.获取数据库连接
        Connection coon = dataSource.getConnection();
        System.out.println(coon);
    }
}
