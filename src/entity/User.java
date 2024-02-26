package entity;

/**
 * @Author：真IKUN
 * @Package：model
 * @Project：TicketManagementSystem
 * @name：User
 * @Date：2023/6/5 10:01
 * @Filename：User
 */
public class User {
    private String userId;
    private String userPassword;
    private String userName;
    private String userPhone    ;
    private String userIdNum;
    private String userSex;

    public User() {
    }

    public User(String userId, String userPassword, String userName, String userPhone, String userNum, String userSex) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userIdNum = userNum;
        this.userSex = userSex;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserIdNum() {
        return userIdNum;
    }

    public void setUserIdNum(String userIdNum) {
        this.userIdNum = userIdNum;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userNum='" + userIdNum + '\'' +
                ", userSex='" + userSex + '\'' +
                '}';
    }
}
