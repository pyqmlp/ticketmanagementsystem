package ui;

import service.AdminService;
import service.UserService;
import dao.CaptchaUtil;
import entity.Admin;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class LoginFrame extends JFrame {
    String imgsrc = "libs/images/Appicon.png";

    String bgsrc = "libs/images/background.png";
    String captcha;
    JLabel captchaShow = new JLabel();
    JLabel name_text;
    JTextField name_jTextField;
    JLabel password_text;
    JPasswordField password_jPasswordField;
    JTextField captcha_jTextField = new JTextField(5);
    ButtonGroup identity;
    JRadioButton user;
    JRadioButton admin;
    JPanel root = new JPanel();

    public LoginFrame() {
        setLogo();

        init();

        addComponent();

        //setBackGround();
        this.setVisible(true);
    }


    private void addComponent() {
        root.setOpaque(true);

        root.setBackground(new Color(255, 255, 255));

        this.setContentPane(root);

        root.setLayout(null);

        //项目名JLabel
        JLabel welcome_text = new JLabel("车票管理系统");
        welcome_text.setFont(new Font("华文彩云", 0, 40));
        welcome_text.setBounds(150, 20, 400, 50);
        welcome_text.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                welcome_text.setForeground(Color.red);
            }
        });
        root.add(welcome_text);

        //用户名JLabel
        name_text = new JLabel("账号:");
        name_text.setBounds(170, 100, 30, 25);
        root.add(name_text);

        //用户名输入框
        name_jTextField = new JTextField(20);
        name_jTextField.setBounds(210, 100, 165, 25);
        name_jTextField.setOpaque(false);
        MatteBorder border = new MatteBorder(0, 0, 1, 0, new Color(193, 193, 193));
        name_jTextField.setBorder(border);
        name_jTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                name_jTextField.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLUE));
            }

            @Override
            public void focusLost(FocusEvent e) {
                name_jTextField.setBorder(border);
            }
        });
        name_jTextField.setFont(new Font("Consolas", Font.BOLD, 18));
        root.add(name_jTextField);

        //密码JLabel
        password_text = new JLabel("密码:");
        password_text.setBounds(170, 140, 30, 25);
        root.add(password_text);

        //密码输入框
        password_jPasswordField = new JPasswordField(20);
        password_jPasswordField.setBounds(210, 140, 165, 25);
        password_jPasswordField.setFont(new Font("Consolas", Font.BOLD, 20));
        password_jPasswordField.setBorder(border);
        password_jPasswordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                password_jPasswordField.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLUE));
            }

            @Override
            public void focusLost(FocusEvent e) {
                password_jPasswordField.setBorder(border);
            }
        });
        root.add(password_jPasswordField);

        //验证码
        JLabel jLabel_captcha = new JLabel("验证码:");
        jLabel_captcha.setBounds(165, 170, 40, 25);
        root.add(jLabel_captcha);

        //验证码输入框

        captcha_jTextField.setBounds(210, 170, 80, 25);
        captcha_jTextField.setFont(new Font("Consolas", Font.BOLD, 20));
        captcha_jTextField.setBorder(border);
        captcha_jTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                captcha_jTextField.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLUE));
            }

            @Override
            public void focusLost(FocusEvent e) {
                captcha_jTextField.setBorder(border);
            }
        });
        root.add(captcha_jTextField);

        //验证码显示
        captcha = CaptchaUtil.getCaptcha();
        captchaShow.setText(captcha);
        captchaShow.setBounds(300, 170, 60, 25);
        captchaShow.setFont(new Font("Consolas", Font.BOLD, 20));
        root.add(captchaShow);
        captchaShow.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 在此处处理点击事件的逻辑
                changeCaptcha();
            }
        });

        //身份选择
        JLabel identity_jLabel = new JLabel("身份:");
        identity_jLabel.setBounds(165, 200, 40, 25);
        root.add(identity_jLabel);

        identity = new ButtonGroup();
        admin = new JRadioButton("管理员");
        user = new JRadioButton("用户");
        identity.add(admin);
        identity.add(user);
        user.setSelected(true);
        user.setOpaque(false);
        admin.setOpaque(false);
        user.setBounds(210, 200, 60, 25);
        admin.setBounds(275, 200, 70, 25);

        root.add(admin);
        root.add(user);

        //登录按钮
        JButton btnLogin = new JButton("登录");
        btnLogin.setBounds(175, 230, 200, 25);
        btnLogin.setBackground(new Color(4, 189, 252));
        root.add(btnLogin);
        btnLogin.addActionListener((e) -> {
            String name = name_jTextField.getText().trim();
            String password = password_jPasswordField.getText().trim();
            Login(name, password);
        });

        //注册账号
        JLabel register = new JLabel("注册账号");
        register.setBounds(10, 290, 80, 25);
        root.add(register);
        register.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                createRegister();
            }
        });


        //找回密码
        JLabel retrievePassword = new JLabel("忘记密码");
        retrievePassword.setBounds(530, 290, 80, 25);
        root.add(retrievePassword);
        retrievePassword.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                createRetrievePwdJDialog();
            }
        });

    }

    /**
     * 设置图标
     */
    private void setLogo() {
        Image icon = Toolkit.getDefaultToolkit().getImage(imgsrc);
        this.setIconImage(icon);
    }

    public void setBackGround() {
        // 创建用于显示背景图片的标签
        JLabel backgroundLabel = new JLabel(new ImageIcon("libs/images/background_(2)_(1).png"));
        backgroundLabel.setBounds(0, 0, this.getWidth(), this.getHeight());

        // 获取主窗口的内容面板，并将背景标签添加到内容面板中
        Container contentPane = this.getContentPane();
        contentPane.setLayout(null);
        contentPane.add(backgroundLabel);
    }

    /**
     * 创建注册窗口
     */
    private void createRegister() {
        RegisterJDialog registerJDialog = new RegisterJDialog(this);
        registerJDialog.setTitle("注册账号");

        registerJDialog.setModal(true);

        registerJDialog.setSize(450, 300);

        registerJDialog.setResizable(false);

        registerJDialog.setLocationRelativeTo(null);

        registerJDialog.setVisible(true);

        String userId = registerJDialog.getUserId();

        if (userId != null && !userId.equals("") && registerJDialog.isRegister) {
            name_jTextField.setText(userId);
            captcha_jTextField.setText("");
            password_jPasswordField.setText("");
        }
    }

    /**
     * 创建找回密码窗口
     */
    private void createRetrievePwdJDialog() {
        RetrievePwdJDialog retrievePwdJDialog = new RetrievePwdJDialog(this);
    }

    /**
     * 更换验证码
     */
    private void changeCaptcha() {
        captcha = CaptchaUtil.getCaptcha();
        captchaShow.setText(captcha);
    }

    /**
     * 初始化登录界面
     */
    private void init() {
        this.setTitle("登录");

        this.setSize(600, 350);

        this.setLocationRelativeTo(null);

        this.setAlwaysOnTop(true);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setResizable(false);


    }


    /**
     * 登录处理
     *
     * @param name     账号
     * @param password 密码
     */
    private void Login(String name, String password) {
        //判断验证码是否正确
        String captchaInput = captcha_jTextField.getText();
        boolean selected = user.isSelected();
        if (captchaInput.equals("")) {
            JOptionPane.showMessageDialog(this, "请输入验证码");
            return;
        } else if (!captchaInput.equalsIgnoreCase(captcha)) {
            JOptionPane.showMessageDialog(this, "验证码错误");
            changeCaptcha();
            return;
        }

        if (name.equals("") && password.equals("")) {
            JOptionPane.showMessageDialog(this, "账号和密码不能为空");
            return;
        } else if (name.equals("") && !password.equals("")) {
            JOptionPane.showMessageDialog(this, "账号不能为空");
            return;
        } else if (!name.equals("") && password.equals("")) {
            JOptionPane.showMessageDialog(this, "密码不能为空");
            return;
        }
        boolean isLogin = false;
        if (selected) {
            isLogin = UserService.isLogin(name);
        } else {
            //管理员账号存在判断
            isLogin = AdminService.isExit(name);
        }
        if (isLogin) {
            boolean isCorrect = false;
            int flag = 0;
            if (selected) {
                //用户密码判断
                flag = 1;
                isCorrect = UserService.isCorrect(name, password);
            } else {
                //管理员密码判断
                flag = 2;
                isCorrect = AdminService.isCorrect(name, password);
            }
            if (isCorrect) {
                this.dispose();
                if (flag == 1) {
                    new UserMainFrame(UserService.getUser(name));
                } else if (flag == 2) {
                    Admin admin = AdminService.getAdminInfo(name);
                    new AdminJFrame(admin);
                }
            } else {
                JOptionPane.showMessageDialog(this, "密码错误");
            }
        } else {
            JOptionPane.showMessageDialog(this, "用户" + name + "未注册！");
        }
    }
}
