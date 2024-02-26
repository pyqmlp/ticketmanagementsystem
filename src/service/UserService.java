    package service;

    import dao.UpdateDao;
    import dao.QueryDao;
    import entity.User;

    import javax.swing.*;


    public class UserService {
        //判断用户是否存在
        public static boolean isLogin(String name) {
            String sql = String.format("select count(*) from tb_user where userId = '%s'", name);
            return QueryDao.sqlQuery(sql) > 0 ? true : false;
        }

        //判断密码是否正确
        public static boolean isCorrect(String name, String password) {
            String sql = String.format("select count(*) from tb_user where userId = '%s' and userPassword = '%s'", name, password);
            return QueryDao.sqlQuery(sql) > 0 ? true : false;
        }

        //找回密码功能的判断手机号码
        public static boolean isPhoneExit(String userId, String phone) {
            String sql = String.format("select count(*) from tb_user where userId = '%s' and userPhone = '%s'", userId, phone);
            return QueryDao.sqlQuery(sql) > 0 ? true : false;
        }

        public static boolean UpdatePwd(String userId, String newPwd) {
            String sql = String.format("update tb_user set userPassword = '%s' where userId = '%s", newPwd, userId);
            return UpdateDao.sqlUpdate(sql) > 0 ? true : false;
        }

        //用户注册
        public static boolean Register(User user) {
            String sql = String.format("insert into tb_user values('%s','%s','%s','%s','%s','%s')",
                    user.getUserId(), user.getUserPassword(), user.getUserName(), user.getUserPhone(), user.getUserIdNum(), user.getUserSex());
            return UpdateDao.sqlUpdate(sql) > 0 ? true : false;
        }

        //查询车票信息
        public static JTable QueryTicketInfo(String startPosition, String endPosition, String date) {
            String QuerySql = String.format("CALL GetTicketInfoByDateAndStations('%s', '%s', '%s')", date, startPosition, endPosition);
            return QueryDao.getTableData(QuerySql);
        }

        //获取用户信息
        public static User getUser(String userId) {
            String sql = String.format("select * from tb_user where userId = '%s'", userId);
            return QueryDao.getUser(sql);
        }

        //用户买票
        public static boolean userBuyTicket(String userId, String date, int shift, int number) {
            String buyTicketSql = String.format("insert into tb_buyticket values('%s','%s','%s','%s')", userId, date, shift, number);
            return UpdateDao.sqlUpdate(buyTicketSql) > 0 ? true : false;
        }

        //查询我的订单
        public static JTable queryOrder(String userId) {
            String sql = String.format("select s.data as '日期', s.shift as '班次', s.time as '发车时间', s.startPosition as '起点站', s.endPosition as '终点站', s.duration as '行车时间', t.已购票数 from tb_shift_info s join ( select data, shift, SUM(purchaseQuantity) as '已购票数' from tb_buyticket where userId = '%s' group by data, shift ) t on s.data = t.data and s.shift = t.shift;", userId);
            return QueryDao.getTableData(sql);
        }

        //退票
        public static boolean refund(String userId, String date, String shift) {
            String sql = String.format("delete from tb_buyticket where userId = '%s' and data = '%s' and shift = %s", userId, date, shift);
            return UpdateDao.sqlUpdate(sql) > 0 ? true : false;
        }

        //CALL GetTicketInfoByStartStation('玉林')用户只输入起始站模糊查询
        //CALL GetTicketInfoByDateAndStations('2023-06-08', '', '');//必须输入一个数据的模糊查询的sql语句

        //<editor-fold desc="查询用户订单sql">
        // select s.data as '日期', s.shift as '班次', s.time as '发车时间', s.startPosition as '起点站', s.endPosition as '终点站', s.duration as '行车时间', t.已购票数
        //  from tb_shift_info s
        //  join (
        //    select data, shift, SUM(purchaseQuantity) as '已购票数'
        //    from tb_buyticket
        //    where userId = '202200406217'
        //    group by data, shift
        //  ) t on s.data = t.data and s.shift = t.shift;
    }
