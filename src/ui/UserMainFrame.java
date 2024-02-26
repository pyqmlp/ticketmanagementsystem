package ui;

import entity.User;

import javax.swing.*;
import java.awt.*;

/**
 * @Author：真IKUN
 * @Package：ui
 * @Project：TicketManagementSystem
 * @name：MainFrame
 * @Date：2023/6/5 20:09
 * @Filename：MainFrame
 */
public class UserMainFrame extends JFrame {
    MyOrdersJDialog myOrdersJDialog = null;
    BuyTicketJDialog buyTicketJDialog = null;
    String imgsrc = "libs/images/Appicon.png";
    static User user = new User();

    public static String getUserId() {
        return user.getUserId();
    }

    public void setUserId(String userId) {
        this.user.setUserId(userId);
    }

    public void setUser(User user) {
        this.user = user;
    }


    public UserMainFrame(User user) {
        this.setUser(user);
        setLogo();
        init();
        addContentpane();
        this.setVisible(true);
    }

    private void addContentpane() {
        JPanel root = new JPanel();
        root.setLayout(null);
        this.setContentPane(root);

        JPanel welcomeItem = new JPanel();
        welcomeItem.setLayout(new FlowLayout());
        welcomeItem.setBounds(0, 0, 300, 50);
        root.add(welcomeItem);

        JLabel welcomeText = new JLabel();
        welcomeText.setText("欢迎你用户：" + user.getUserName());
        welcomeItem.add(welcomeText);

        JPanel buyTicketItem = new JPanel();
        buyTicketItem.setLayout(new FlowLayout());
        buyTicketItem.setBounds(0, 50, 300, 50);
        root.add(buyTicketItem);

        JButton buyTicket = new JButton("买票");
        buyTicketItem.add(buyTicket);

        JPanel myOrderItem = new JPanel();
        myOrderItem.setLayout(new FlowLayout());
        myOrderItem.setBounds(0, 100, 300, 50);
        root.add(myOrderItem);

        JButton myOrder = new JButton("我的订单");
        myOrderItem.add(myOrder);

        JPanel exitLoginItem = new JPanel();
        exitLoginItem.setLayout(new FlowLayout());
        exitLoginItem.setBounds(0, 150, 300, 50);
        root.add(exitLoginItem);

        JButton btnExit = new JButton("退出登录");
        exitLoginItem.add(btnExit);

        btnExit.addActionListener((e) -> {
            OnExit();
        });

        buyTicket.addActionListener((e) -> {
            buyTicket();
        });
        myOrder.addActionListener((e) -> {
            OnMyOrder();
        });
    }

    private void OnExit() {
        int i = JOptionPane.showConfirmDialog(this, "确认是否退出", "退出登录", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            this.dispose();
            if (buyTicketJDialog != null) buyTicketJDialog.dispose();
            new LoginFrame();
        }

    }

    private void OnMyOrder() {
        myOrdersJDialog = new MyOrdersJDialog(this);
    }

    private void buyTicket() {
        buyTicketJDialog = new BuyTicketJDialog();
        buyTicketJDialog.setVisible(true);
    }


    private void init() {
        this.setTitle("主界面");

        this.setSize(300, 600);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setLocationRelativeTo(null);
    }

    private void setLogo() {
        Image icon = Toolkit.getDefaultToolkit().getImage(imgsrc);
        this.setIconImage(icon);
    }

}
