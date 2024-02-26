package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UpdateDao {
    public static int sqlUpdate(String sql) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int result = -1;
        try {
            //连接
            connection = JDBCUtil.getConnection();
            //
            preparedStatement = connection.prepareStatement(sql);
            //执行sql语句
            result = preparedStatement.executeUpdate();
        } catch(Exception e) {
            throw new RuntimeException();
        }finally {
            JDBCUtil.close(null, preparedStatement, connection);
        }
        return result;
    }
}
