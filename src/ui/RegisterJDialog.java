package ui;

import service.UserService;
import entity.User;

import javax.swing.*;
import java.awt.*;


public class RegisterJDialog extends JDialog {
    JLabel userId_jLabel;
    JLabel userIdTip;
    JLabel userPassword_jLabel1;
    JLabel userPassword_jLabel2;
    JLabel userName;
    JLabel userSex;
    JLabel userNameTip;
    JLabel userPhoneTip;
    JLabel userIdNumTip;
    JLabel userPwdTip1;
    JLabel userPwdTip2;
    JLabel userPhone_jLabel;
    JLabel userIdNum_jLabel;
    JTextField userId_jTextField;
    JTextField userPhone_jTextField;
    JTextField userIdNum_jTextField;
    JTextField userName_jTextField;
    JPasswordField userPwd_jPasswordField2;
    JPasswordField userPwd_jPasswordField1;
    ButtonGroup sex;
    JRadioButton male;
    JRadioButton female;
    JButton Register_jButton;
    boolean isRegister;
    User user = new User();

    public RegisterJDialog(Window owner) {
        super(owner);
        init();
    }

    /**
     * 初始化注册窗口
     */
    private void init() {
        this.setTitle("注册账号");

        this.setModal(true);

        this.setResizable(false);

        addContentpane();

        this.setLocationRelativeTo(null);

        //this.setVisible(true);
    }

    /**
     * 添加组件
     */
    private void addContentpane() {
        JPanel root = new JPanel();
        this.setContentPane(root);
        root.setLayout(null);

        /**
         * 账号输入模块
         */
        //用户名JLabel
        userId_jLabel = new JLabel("账号:");
        userId_jLabel.setBounds(70, 10, 30, 20);
        root.add(userId_jLabel);
        //用户名输入框
        userId_jTextField = new JTextField(20);
        userId_jTextField.setBounds(120, 10, 200, 20);
        root.add(userId_jTextField);

        //用户名为空提示
        userIdTip = new JLabel();
        userIdTip.setBounds(330, 10, 200, 20);
        userIdTip.setForeground(Color.red);
        root.add(userIdTip);
        userIdTip.setVisible(false);

        /**
         * 密码输入模块
         */
        //密码JLabel
        userPassword_jLabel1 = new JLabel("密码:");
        userPassword_jLabel1.setBounds(70, 35, 30, 20);
        root.add(userPassword_jLabel1);
        //密码输入框
        userPwd_jPasswordField1 = new JPasswordField(20);
        userPwd_jPasswordField1.setBounds(120, 35, 200, 20);
        root.add(userPwd_jPasswordField1);
        //
        userPwdTip1 = new JLabel();
        userPwdTip1.setBounds(330, 35, 200, 20);
        userPwdTip1.setForeground(Color.red);
        root.add(userPwdTip1);
        userPwdTip1.setVisible(false);

        //确认密码JLabel
        userPassword_jLabel2 = new JLabel("确认密码:");
        userPassword_jLabel2.setBounds(60, 60, 60, 20);
        root.add(userPassword_jLabel2);
        //确认密码输入框
        userPwd_jPasswordField2 = new JPasswordField(20);
        userPwd_jPasswordField2.setBounds(120, 60, 200, 20);
        root.add(userPwd_jPasswordField2);
        //
        userPwdTip2 = new JLabel();
        userPwdTip2.setBounds(330, 60, 200, 20);
        userPwdTip2.setForeground(Color.red);
        root.add(userPwdTip2);
        userPwdTip2.setVisible(false);

        /**
         * 姓名输入模块
         */
        //姓名JLabel
        userName = new JLabel("姓名:");
        userName.setBounds(70, 85, 30, 20);
        root.add(userName);
        //姓名输入框
        userName_jTextField = new JTextField(20);
        userName_jTextField.setBounds(120, 85, 200, 20);
        root.add(userName_jTextField);
        //
        userNameTip = new JLabel();
        userNameTip.setBounds(330, 85, 200, 20);
        userNameTip.setForeground(Color.red);
        root.add(userNameTip);
        userNameTip.setVisible(false);

        /**
         * 性别选择模块
         */
        //性别JLabel
        userSex = new JLabel("性别:");
        userSex.setBounds(70, 110, 30, 20);
        root.add(userSex);
        //性别单选框
        sex = new ButtonGroup();
        male = new JRadioButton("男");
        female = new JRadioButton("女");
        male.setBounds(120, 110, 40, 20);
        female.setBounds(170, 110, 40, 20);
        male.setSelected(true);
        sex.add(male);
        sex.add(female);
        root.add(male);
        root.add(female);

        //手机号码
        userPhone_jLabel = new JLabel("手机号码:");
        userPhone_jLabel.setBounds(60, 135, 60, 20);
        root.add(userPhone_jLabel);

        userPhone_jTextField = new JTextField(11);
        userPhone_jTextField.setBounds(120, 135, 200, 20);
        root.add(userPhone_jTextField);
        //
        userPhoneTip = new JLabel();
        userPhoneTip.setBounds(330, 135, 200, 20);
        userPhoneTip.setForeground(Color.red);
        root.add(userPhoneTip);
        userPhoneTip.setVisible(false);

        //身份证号码
        userIdNum_jLabel = new JLabel("身份证号:");
        userIdNum_jLabel.setBounds(60, 160, 60, 20);
        root.add(userIdNum_jLabel);

        userIdNum_jTextField = new JTextField(11);
        userIdNum_jTextField.setBounds(120, 160, 200, 20);
        root.add(userIdNum_jTextField);

        userIdNumTip = new JLabel();
        userIdNumTip.setBounds(330, 160, 200, 20);
        userIdNumTip.setForeground(Color.red);
        root.add(userIdNumTip);
        userIdNumTip.setVisible(false);

        //注册按钮
        Register_jButton = new JButton("注册");
        Register_jButton.setBounds(160, 200, 80, 25);
        root.add(Register_jButton);
        Register_jButton.addActionListener((e) -> {
            //一系列的判断
            Click();
        });

    }

    /**
     * 点击注册按钮时的事件的方法调用
     */
    public void Click() {
        isRegister = true;
        String userId = userId_jTextField.getText().trim();
        String userPassword1 = userPwd_jPasswordField1.getText().trim();
        String userPassword2 = userPwd_jPasswordField2.getText().trim();
        String userName = userName_jTextField.getText().trim();
        String userPhone = userPhone_jTextField.getText().trim();
        String userIdNum = userIdNum_jTextField.getText().trim();
        String userSex = sex.getSelection() == male.getModel() ? "男" : "女";

        if (userId.equals("")) {
            userIdTip.setText("用户名不能为空！");
            userIdTip.setVisible(true);
            isRegister = false;
        } else if (!userId.matches("^\\d{12}$")) {
            userIdTip.setText("账号不符合规范！");
            userIdTip.setVisible(true);
            isRegister = false;
        } else if (UserService.isLogin(userId)) {
            userIdTip.setText("该账号已注册！");
            userIdTip.setVisible(true);
            isRegister = false;
        } else {
            userIdTip.setVisible(false);
            user.setUserId(userId);
        }

        if (userPassword1.equals("")) {
            userPwdTip1.setText("密码不能为空！");
            userPwdTip1.setVisible(true);
            isRegister = false;
        } else {
            userPwdTip1.setVisible(false);
        }

        if (userPassword2.equals("")) {
            userPwdTip2.setText("密码不能为空！");
            userPwdTip2.setVisible(true);
            isRegister = false;
        } else {
            userPwdTip2.setVisible(false);
        }

        if (!userPassword1.equals(userPassword2)) {
            userPwdTip2.setText("前后两次密码不一致！");
            userPwdTip2.setVisible(true);
            isRegister = false;
        } else user.setUserPassword(userPassword2);

        if (userName.equals("")) {
            userNameTip.setText("姓名不能为空！");
            userNameTip.setVisible(true);
            isRegister = false;
        } else {
            userNameTip.setVisible(false);
            user.setUserName(userName);
        }

        if (userPhone.equals("")) {
            userPhoneTip.setText("手机号不能为空！");
            userPhoneTip.setVisible(true);
            isRegister = false;
        } else {
            userPhoneTip.setVisible(false);
            user.setUserPhone(userPhone);
        }

        if (userIdNum.equals("")) {
            userIdNumTip.setText("身份证号不能为空！");
            userIdNumTip.setVisible(true);
            isRegister = false;
        } else {
            userIdNumTip.setVisible(false);
            user.setUserIdNum(userIdNum);
        }
        user.setUserSex(userSex);
        if (isRegister) {
            boolean result = UserService.Register(user);
            if (result) {
                JOptionPane.showMessageDialog(this, "注册成功");

            } else {
                JOptionPane.showMessageDialog(this, "注册失败");
            }
            this.dispose();
        }

    }

    public String getUserId() {
        if (userId_jTextField.getText().trim() != null || userId_jTextField.getText().trim().equals(""))
            return userId_jTextField.getText().trim();
        else return null;
    }

}
