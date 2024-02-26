package ui;

import entity.Admin;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @Author：真IKUN
 * @Package：ui
 * @Project：TicketManagementSystem
 * @name：AdminMainJFrame
 * @Date：2023/6/12 21:44
 * @Filename：AdminMainJFrame
 */
    public class AdminJFrame extends JFrame {
    JPanel Main;
    JPanel root;
    static Admin admin;
    JPanel ticketInfoManage;
    JPanel MainMenu;
    JPanel exitLoginMenu;

    public AdminJFrame(Admin admin) {
        this.admin = admin;
        setLogo();
        init();
        addComponents();
        setVisible(true);
    }

    private void addComponents() {
        root = new JPanel();
        this.setContentPane(root);
        root.setBackground(Color.WHITE);
        root.setLayout(null);

        JPanel Aside = new JPanel();
        Aside.setBounds(0, 0, 200, 1000);
        Aside.setBorder(new LineBorder(Color.lightGray, 2));
        Aside.setBackground(Color.WHITE);
        Aside.setLayout(null);
        root.add(Aside);

        Main = new AdminMainJPanel();
        //Main.setBackground(Color.PINK);
        //Main.setLayout(null);
        //Main.setBounds(200, 0, 800, 600);
        root.add(Main);

        JPanel logo = new JPanel();
        logo.setBounds(10, 10, 180, 180);
        logo.setBorder(new LineBorder(Color.WHITE, 2));
        logo.setBackground(Color.WHITE);
        logo.setLayout(null);
        Aside.add(logo);

        String path = String.format("libs/images/adminlogo%s.jpg", admin.getAdminAvatar());
        ImageIcon icon = new ImageIcon(path);
        JLabel imglogo = new JLabel(icon);
        imglogo.setBounds(0, 0, 180, 200);
        logo.add(imglogo);

        JLabel welcomeText = new JLabel();
        welcomeText.setText("admin:" + admin.getAdminName());
        welcomeText.setBounds(60, 195, 80, 40);
        Aside.add(welcomeText);

        MainMenu = new JPanel();
        MainMenu.setBounds(1, 240, 198, 44);
        MainMenu.setLayout(null);
        MainMenu.setBackground(Color.WHITE);
        Aside.add(MainMenu);
        MainMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MainMenu.setBackground(Color.PINK);
                ticketInfoManage.setBackground(Color.WHITE);
                exitLoginMenu.setBackground(Color.WHITE);
                OnMainMenu();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (MainMenu.getBackground() != Color.PINK)
                    MainMenu.setBackground(Color.cyan);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (MainMenu.getBackground() == Color.cyan)
                    MainMenu.setBackground(Color.WHITE);
            }
        });

        ImageIcon icon1 = new ImageIcon("libs/images/main (1).png");
        JLabel mainIcon = new JLabel(icon1);
        mainIcon.setBounds(60, 10, 20, 20);
        MainMenu.add(mainIcon);

        JLabel mainItem = new JLabel("主页");
        mainItem.setBounds(85, 10, 100, 20);
        MainMenu.add(mainItem);

        ticketInfoManage = new JPanel();
        ticketInfoManage.setBounds(1, 284, 198, 44);
        ticketInfoManage.setLayout(null);
        ticketInfoManage.setBackground(Color.WHITE);
        Aside.add(ticketInfoManage);
        ticketInfoManage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ticketInfoManage.setBackground(Color.PINK);
                MainMenu.setBackground(Color.WHITE);
                exitLoginMenu.setBackground(Color.WHITE);
                OnticketInfoManage();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

                if (ticketInfoManage.getBackground() != Color.PINK)
                    ticketInfoManage.setBackground(Color.cyan);
            }

            @Override
            public void mouseExited(MouseEvent e) {

                if (ticketInfoManage.getBackground() == Color.cyan)
                    ticketInfoManage.setBackground(Color.WHITE);
            }
        });


        ImageIcon icon2 = new ImageIcon("libs/images/ticketmanage (1).png");
        JLabel ticIcon = new JLabel(icon2);
        ticIcon.setLayout(null);
        ticIcon.setBounds(40, 10, 20, 20);
        ticketInfoManage.add(ticIcon);

        JLabel ticManageText = new JLabel("班次信息管理");
        ticManageText.setBounds(65, 10, 100, 20);
        ticketInfoManage.add(ticManageText);

        exitLoginMenu = new JPanel();
        exitLoginMenu.setBounds(1, 328, 198, 44);
        exitLoginMenu.setLayout(null);
        exitLoginMenu.setBackground(Color.WHITE);
        Aside.add(exitLoginMenu);
        exitLoginMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                OnmouseClicked();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (exitLoginMenu.getBackground() != Color.PINK)
                    exitLoginMenu.setBackground(Color.cyan);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (exitLoginMenu.getBackground() == Color.cyan)
                    exitLoginMenu.setBackground(Color.WHITE);
            }
        });

        ImageIcon icon3 = new ImageIcon("libs/images/exitlogin.png");
        JLabel exitIcon = new JLabel(icon3);
        exitIcon.setBounds(50, 10, 20, 20);
        exitLoginMenu.add(exitIcon);

        JLabel exitLoginText = new JLabel("退出登录");
        exitLoginText.setBounds(75, 10, 100, 20);
        exitLoginMenu.add(exitLoginText);
    }

    private void init() {
        setTitle("管理员");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
    }

    public void OnticketInfoManage() {
        root.remove(Main);
        Main = new ticketInfoManageJPanel();
        root.add(Main);
        root.repaint();
    }

    public void OnMainMenu() {
        root.remove(Main);
        Main = new AdminMainJPanel();
        root.add(Main);
        root.repaint();
    }

    public void OnmouseClicked() {
        int i = JOptionPane.showConfirmDialog(this, "是否确认退出登录?", "退出登录", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            this.dispose();
            new LoginFrame();
        }
    }

    /**
     * 设置图标
     */
    private void setLogo() {
        Image icon = Toolkit.getDefaultToolkit().getImage("libs/images/Appicon.png");
        this.setIconImage(icon);
    }
}
