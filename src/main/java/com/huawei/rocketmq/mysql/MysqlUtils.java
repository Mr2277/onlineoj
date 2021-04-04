package com.huawei.rocketmq.mysql;

import java.sql.*;

public class MysqlUtils {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        //1.加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/mall?serverTimezone=GMT%2B8";

        String user = "root";

        String password = "1234567";
        //2.建立连接
        Connection connections = DriverManager.getConnection(url, user, password);
        //返回连接对象
        return connections;

    }

    public static void query(String query) throws SQLException, ClassNotFoundException {
        //获取connection对象
        Connection connection = getConnection();
        //3.准备SQL语句
        PreparedStatement pStatement = connection.prepareStatement(query);
        //4.执行SQL语句
        ResultSet resultSet = pStatement.executeQuery();
        //检索此 ResultSet对象的列的数量，类型和属性。
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        //5.处理结果遍历要查询的数据
        while (resultSet.next()) {
            //遍历行数
            String shopId = resultSet.getString("SHOPID");
            System.out.println(shopId);
        }
        //6.关闭连接
        resultSet.close();
        pStatement.close();
        connection.close();
    }

    public static void insert(String sql, int queueId, String messageBody, String unixTime) throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, queueId);
        ps.setString(2, messageBody);
        ps.setString(3, unixTime);
        ps.executeUpdate();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        /*
        System.out.println(System.currentTimeMillis());
        String sql = "select * from sale where bill = '61001515090100292'";
        query(sql);
        */
        String sql = "insert into rocket_message_info(QUEUE_ID, MESSAGE_BODY,CREATE_TIME) VALUES(?, ?, ?);";
        //insert(sql);
    }

}
