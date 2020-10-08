package connection;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author: lzy
 * @description: jdbc连接测试
 * @date: 2020-10-08-10:15
 */
public class ConnectionTest {
    //方式1
    @Test
    public void test1() throws SQLException {
        //使用时需要使用具体的mysql实现类，需要加载驱动,导入jar
        //获取Driver的实现类对象
        Driver driver=new com.mysql.jdbc.Driver();
        //          主协议，子协议，主机，端口号，数据库名
        String url="jdbc:mysql://localhost:3306/test";
        //将用户名和密码封装在properties中
        Properties info=new Properties();
        info.setProperty("user","root");
        info.setProperty("password","lzy1234");
        //使用connection类型接收
        Connection conn=driver.connect(url,info);
        System.out.println(conn);
    }
    //方式2：对方式1的迭代，因为出现了第三方的api（第21行的Driver（））
    @Test
    public void test2() throws Exception {
        //获取Driver的实现类对象，使用反射动态获取
        Class cla = Class.forName("com.mysql.jdbc.Driver");
        Driver driver= (Driver) cla.newInstance();

        //其他全部相同
    }
    //方式3：使用DriverManager替换Driver
    @Test
    public void tests3() throws Exception {
        //获取Driver的实现类对象
        Class cla = Class.forName("com.mysql.jdbc.Driver");
        Driver driver= (Driver) cla.newInstance();
        //注册驱动
        DriverManager.registerDriver(driver);
        //提供其他的基本信息
        String url="jdbc:mysql://localhost:3306/test";
        String user="root";
        String pwd="lzy1234";
        //获取连接
        DriverManager.getConnection(url,user,pwd);

    }
    //方法4：在3基础上优化，可以优化驱动
    @Test
    public void tests4() throws Exception {
        //提供其他的基本信息
        String url="jdbc:mysql://localhost:3306/test";
        String user="root";
        String pwd="lzy1234";
        //获取Driver的实现类对象
        //Driver中有静态代码快，在类加载的时候就直接执行，所以可以直接省略下述代码
        Class.forName("com.mysql.jdbc.Driver");
//        Driver driver= (Driver) cla.newInstance();
//        //注册驱动
//        DriverManager.registerDriver(driver);
        //获取连接
        DriverManager.getConnection(url,user,pwd);

    }
    //方式5：最终版本,使用配合文件方式加载信息
    //配置在src文件下，这样不会在配置到tomcat中缺失
    //实现了数据和代码的分离，实现了解耦。只修改配置文件，避免代码重新打包
    @Test
    public void test5() throws Exception {
        //读取配置文件中的加载信息
        InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(is);
        String user = pros.getProperty("user");
        String pwd = pros.getProperty("pwd");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");
        //加载驱动
        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(url, user, pwd);
        System.out.println(connection);
    }
}
