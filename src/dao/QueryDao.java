package dao;

import entity.Admin;
import entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;

/**
 * @Author：真IKUN
 * @Package：dao
 * @Project：TicketManagementSystem
 * @name：Query
 * @Date：2023/6/7 20:43
 * @Filename：Query
 */
public class QueryDao {
    public static int sqlQuery(String sql) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int result = -1;
        try {
            //连接
            connection = JDBCUtil.getConnection();
            //
            preparedStatement = connection.prepareStatement(sql);
            //执行sql语句
            resultSet = preparedStatement.executeQuery();
            //
            if (resultSet.next()) {
                result = resultSet.getInt(1);
            }

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            JDBCUtil.close(resultSet, preparedStatement, connection);
        }
        return result;
    }

    public static JTable getTableData(String QuerySql) {
        DefaultTableModel tableModel = new DefaultTableModel();//用于装表格数据
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        JTable jTable = new JTable();
        try {
            //连接
            connection = JDBCUtil.getConnection();
            //
            preparedStatement = connection.prepareStatement(QuerySql);
            //执行QuerySql语句
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();

            //得到列数
            int columnCount = metaData.getColumnCount();


            for (int i = 1; i <= columnCount; i++) {
                // 获取列名并存储到数组中
                tableModel.addColumn(metaData.getColumnName(i));
            }

            while (resultSet.next()) {
                Vector<Object> rowData = new Vector<>();
                for (int i = 1; i <= columnCount; i++) {
                    // 获取每列的数据并存储到数组中
                    System.out.println("resultSet" + resultSet);
                    System.out.println(resultSet.getObject(i));
                    rowData.add(resultSet.getObject(i));
                }
                // 将每行数据添加到List中
                tableModel.addRow(rowData);
            }

            jTable.setModel(tableModel);
            return jTable;
        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            JDBCUtil.close(resultSet, preparedStatement, connection);
        }
    }

    public static User getUser(String sql) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = new User();
        try {
            conn = JDBCUtil.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user.setUserId(resultSet.getString("userId"));
                user.setUserPassword(resultSet.getString("userPassword"));
                user.setUserName(resultSet.getString("userName"));
                user.setUserSex(resultSet.getString("userSex"));
                user.setUserPhone(resultSet.getString("userPhone"));
                user.setUserIdNum(resultSet.getString("userIdNum"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.close(resultSet, preparedStatement, conn);
        }
        return user;
    }

    public static Admin getAdmin(String sql) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Admin admin = new Admin();
        try {
            conn = JDBCUtil.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                admin.setAdminId(resultSet.getString("adminId"));
                admin.setAdminPassword(resultSet.getString("adminPassword"));
                admin.setAdminName(resultSet.getString("adminName"));
                admin.setAdminSex(resultSet.getString("adminSex"));
                admin.setAdminPhone(resultSet.getString("adminPhone"));
                admin.setAdminIdNum(resultSet.getString("adminIdNum"));
                admin.setAdminAvatar(resultSet.getString("adminAvatar"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.close(resultSet, preparedStatement, conn);
        }
        return admin;
    }


}
