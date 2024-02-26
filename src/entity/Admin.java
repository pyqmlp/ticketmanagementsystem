package entity;

/**
 * @Author：真IKUN
 * @Package：model
 * @Project：TicketManagementSystem
 * @name：Admin
 * @Date：2023/6/16 9:22
 * @Filename：Admin
 */
public class Admin {
    private String adminId;
    private String adminPassword;
    private String adminName;
    private String adminPhone;
    private String adminIdNum;
    private String adminSex;
    private String adminAvatar;

    public Admin() {
    }

    public Admin(String adminId, String adminPassword, String adminName, String adminPhone, String adminIdNum, String adminSex) {
        this.adminId = adminId;
        this.adminPassword = adminPassword;
        this.adminName = adminName;
        this.adminPhone = adminPhone;
        this.adminIdNum = adminIdNum;
        this.adminSex = adminSex;
    }

    public String getAdminAvatar() {
        return adminAvatar;
    }

    public void setAdminAvatar(String adminAvatar) {
        this.adminAvatar = adminAvatar;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }

    public String getAdminIdNum() {
        return adminIdNum;
    }

    public void setAdminIdNum(String adminIdNum) {
        this.adminIdNum = adminIdNum;
    }

    public String getAdminSex() {
        return adminSex;
    }

    public void setAdminSex(String adminSex) {
        this.adminSex = adminSex;
    }
}
