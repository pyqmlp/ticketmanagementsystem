package service;

import dao.UpdateDao;
import dao.QueryDao;
import entity.Admin;
import entity.Shift;

import javax.swing.*;

/**
 * @Author：真IKUN
 * @Package：Service
 * @Project：TicketManagementSystem
 * @name：AdminService
 * @Date：2023/6/6 8:10
 * @Filename：AdminService
 */
public class AdminService {
    public static boolean isExit(String name) {
        String sql = String.format("select count(*) from tb_admin where adminId = '%s'", name);
        return QueryDao.sqlQuery(sql) > 0 ? true : false;
    }

    public static boolean isCorrect(String name, String password) {
        String sql = String.format("select count(*) from tb_admin where adminId = '%s' and adminPassword = '%s'", name, password);
        return QueryDao.sqlQuery(sql) > 0 ? true : false;
    }

    /**
     * 获取售票情况
     *
     * @return
     */
    public static JTable GetTicketInfo(String date, String start, String end) {
        String sql = String.format("CALL GetTicketInfo('%s','%s','%s')", date, start, end);
        return QueryDao.getTableData(sql);
    }

    /**
     * 获取管理员信息
     *
     * @param adminId
     * @return
     */
    public static Admin getAdminInfo(String adminId) {
        String sql = String.format("select * from tb_admin where adminId = '%s'", adminId);
        return QueryDao.getAdmin(sql);
    }

    /**
     * 删除班次
     *
     * @param date
     * @param shift
     * @return
     */
    public static boolean deleteShift(String date, String shift) {
        String sql = String.format("delete from tb_shift_info where data = '%s' and shift = %s", date, shift);
        return UpdateDao.sqlUpdate(sql) > 0 ? true : false;
    }

    /**
     * 增加班次
     * @param shift
     * @return
     */
    public static boolean addShift(Shift shift) {
        String sql = String.format("insert into tb_shift_info values('%s',%s,'%s','%s','%s',%s,%s)",
                shift.getDate(),
                shift.getShift(),
                shift.getTime(),
                shift.getStartPosition(),
                shift.getEndPosition(),
                shift.getDuration(),
                shift.getTitleNum());
        return UpdateDao.sqlUpdate(sql) > 0 ? true : false;
    }

    /**
     * 判断班次是否存在
     * @param date
     * @param shift
     * @return
     */
    public static boolean isShiftExit(String date, String shift) {
        String sql = String.format("select count(*) from tb_shift_info where data = '%s' and shift = %s", date, shift);
        return QueryDao.sqlQuery(sql) > 0 ? true : false;
    }

    /**
     * 修改班次信息
     * @param shift
     * @param oldDate
     * @param oldShift
     * @return
     */
    public static boolean isUpdate(Shift shift, String oldDate, String oldShift) {
        String sql = String.format("update tb_shift_info set " +
                        "data = '%s', shift = %s, time = '%s', startPosition = '%s'," +
                        " endPosition = '%s', duration = %s, ratedCapacity = %s where data = '%s' and shift = %s",
                shift.getDate(),
                shift.getShift(),
                shift.getTime(),
                shift.getStartPosition(),
                shift.getEndPosition(),
                shift.getDuration(),
                shift.getTitleNum(),
                oldDate,
                oldShift);
        System.out.println(shift + "\n" + oldDate + "\n" + oldShift);
        return UpdateDao.sqlUpdate(sql) > 0 ? true : false;
    }
}
