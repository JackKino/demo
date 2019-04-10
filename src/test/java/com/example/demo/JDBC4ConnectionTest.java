package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JDBC4ConnectionTest {
    @Autowired
    DataSource dataSource;

    @Test
    public void contextLoads()throws SQLException{
        System.out.println(dataSource.getClass());

        Connection connection=dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
