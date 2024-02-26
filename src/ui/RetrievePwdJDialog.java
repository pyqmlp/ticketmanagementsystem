package ui;

import service.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class RetrievePwdJDialog extends JDialog {
    JLabel userId_jLabel;
    JTextField userId_jTextField;
    JLabel userIdTip;
    JButton next;
    JButton jButton1;
    JLabel getBack;
    JLabel phone_jLabel;
    JButton btnConfirm;
    JTextField phone_jTextField;
    JPanel root;

    int page = 1;

    public RetrievePwdJDialog(Window owner) {
        super(owner);
        init();

    }

    /**
     * 初始化找回密码对话框
     */
    private void init() {
        this.setTitle("找回密码");

        this.setModal(true);

        add();

        this.setSize(500, 300);

        this.setResizable(false);

        this.setLocationRelativeTo(null);

        this.setVisible(true);
    }

    /**
     * 添加组件
     */
    private void add() {

        root = new JPanel();
        this.setContentPane(root);
        root.setLayout(null);
        /**
         * 账号输入模块
         */
        //用户名JLabel
        userId_jLabel = new JLabel("账号:");
        userId_jLabel.setBounds(135, 60, 30, 20);
        root.add(userId_jLabel);
        //用户名输入框
        userId_jTextField = new JTextField(20);
        userId_jTextField.setBounds(170, 60, 200, 20);
        root.add(userId_jTextField);

        //用户名为空提示
        userIdTip = new JLabel();
        userIdTip.setBounds(375, 60, 200, 20);
        userIdTip.setForeground(Color.red);
        root.add(userIdTip);
        userIdTip.setVisible(false);

        //
        next = new JButton("下一步");
        next.setBounds(200, 100, 100, 25);
        root.add(next);

        //
        jButton1 = new JButton("手机号验证");
        jButton1.setBounds(175, 80, 150, 30);
        root.add(jButton1);
        jButton1.setVisible(false);

        getBack = new JLabel("<-返回");
        getBack.setBounds(10, 0, 80, 25);
        root.add(getBack);
        getBack.setVisible(false);

        phone_jLabel = new JLabel("输入手机号码:");
        phone_jTextField = new JTextField(11);
        phone_jLabel.setBounds(135, 60, 80, 20);
        phone_jTextField.setBounds(220, 60, 160, 20);
        phone_jLabel.setVisible(false);
        phone_jTextField.setVisible(false);
        root.add(phone_jLabel);
        root.add(phone_jTextField);

        btnConfirm = new JButton("确认");
        btnConfirm.setBounds(230, 90, 60, 30);
        btnConfirm.setVisible(false);
        root.add(btnConfirm);

        getBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getBack();
            }
        });

        next.addActionListener((e) -> {
            next();
        });

        jButton1.addActionListener((e) -> {
            jButtonClick();
        });

        btnConfirm.addActionListener((e) -> {
            OnbtnConfirm();
        });

    }

    private void OnbtnConfirm() {
        String phoneText = phone_jTextField.getText().trim();
        String userId = userId_jTextField.getText().trim();
        boolean phoneExit = UserService.isPhoneExit(userId, phoneText);
        if (phoneExit) {
            phone_jTextField.setVisible(false);
            phone_jLabel.setVisible(false);
            btnConfirm.setVisible(false);
            getBack.setVisible(false);
            JLabel newPwd1 = new JLabel("新密码:");
            newPwd1.setBounds(135, 60, 80, 20);
            root.add(newPwd1);
            JTextField newPwdText1 = new JTextField(20);
            newPwdText1.setBounds(220, 60, 160, 20);
            root.add(newPwdText1);
            JLabel newPwd2 = new JLabel("再次输入:");
            newPwd2.setBounds(135, 85, 80, 20);
            root.add(newPwd2);

            JTextField newPwdText2 = new JTextField(20);
            newPwdText2.setBounds(220, 85, 160, 20);
            root.add(newPwdText2);

            JButton btnConfirm = new JButton("确认");
            btnConfirm.setBounds(150, 110, 60, 30);
            root.add(btnConfirm);
            btnConfirm.addActionListener((e) -> {
                String pwd1 = newPwdText1.getText().trim();
                String pwd2 = newPwdText2.getText().trim();
                if (!pwd1.equals(pwd2)) {
                    JOptionPane.showMessageDialog(this, "两次输入不一致");
                    return;
                }
                //修改密码
                boolean result = UserService.UpdatePwd(userId, pwd1);
                if (result) {
                    JOptionPane.showMessageDialog(this,"修改成功");
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this,"修改失败");
                    this.dispose();
                }
            });

        } else {
            JOptionPane.showMessageDialog(this, "手机号码错误");
        }
    }

    private void jButtonClick() {
        page = 3;
        jButton1.setVisible(false);
        getBack.setVisible(true);
        phone_jLabel.setVisible(true);
        phone_jTextField.setVisible(true);
        btnConfirm.setVisible(true);
    }

    private void getBack() {
        if (page == 2) {
            userId_jLabel.setVisible(true);
            userId_jTextField.setVisible(true);
            userIdTip.setVisible(true);
            next.setVisible(true);
            jButton1.setVisible(false);
            getBack.setVisible(false);
            page = 1;
        } else if (page == 3) {
            jButton1.setVisible(true);
            getBack.setVisible(true);
            phone_jLabel.setVisible(false);
            phone_jTextField.setVisible(false);
            phone_jTextField.setText("");
            btnConfirm.setVisible(false);
            page = 2;
        }
    }

    private void next() {
        //判断用户输入的账号是否存在并且符合规范
        if (userId_jTextField.getText().trim().equals("")) {
            userIdTip.setText("账号不能为空！");
            userIdTip.setVisible(true);
            return;
        } else if (!userId_jTextField.getText().trim().matches("^\\d{12}$")) {
            userIdTip.setText("账号不符合规范！");
            userIdTip.setVisible(true);
            return;
        } else {
            userIdTip.setText("");
            userIdTip.setVisible(false);
        }
        page = 2;
        userId_jLabel.setVisible(false);
        userId_jTextField.setVisible(false);
        userIdTip.setVisible(false);
        next.setVisible(false);
        jButton1.setVisible(true);
        getBack.setVisible(true);
    }

}
