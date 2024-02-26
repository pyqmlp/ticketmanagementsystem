package ui;

import service.UserService;

import javax.swing.*;
import java.awt.*;

/**
 * @Author：真IKUN
 * @Package：ui
 * @Project：TicketManagementSystem
 * @name：InputJDialog
 * @Date：2023/6/9 13:28
 * @Filename：InputJDialog
 */
public class InputJDialog extends JDialog{
    private JTextField buyNumber;//购票数量输入框
    private int number;//

    private int shift;//班次
    private String date;//日期

    public InputJDialog(Window owner, int number, int shift, String date) {
        super(owner);
        this.number = number;
        this.shift = shift;
        this.date = date;
        init();
        addContentpanes();
        this.setVisible(true);
    }

    //添加组件
    private void addContentpanes() {
        JPanel root = new JPanel();
        this.setContentPane(root);
        root.setLayout(new FlowLayout());

        root.add(new JLabel("购买数量:"));
        buyNumber = new JTextField(5);
        root.add(buyNumber);
        JButton btnConfirm = new JButton("确认购买");
        root.add(btnConfirm);
        btnConfirm.addActionListener((e) -> {
            OnConfirm();
        });
    }

    //确认的点击事件
    private void OnConfirm() {
        int bunumber = getValue();
        if (bunumber > number) {
            JOptionPane.showMessageDialog(this, "剩余数量小于购买数量");
        } else if (bunumber <= 0) {
            JOptionPane.showMessageDialog(this, "购买数量应大于0");
        } else {
            //执行买票操作
            boolean result = UserService.userBuyTicket(UserMainFrame.getUserId(), date, shift, getValue());
            if (result) {
                JOptionPane.showMessageDialog(this, "购买成功");
            } else {
                JOptionPane.showMessageDialog(this, "购买失败");
            }

            this.dispose();
        }
    }

    //界面初始化
    private void init() {
        this.setTitle("购买数量");

        this.setLocationRelativeTo(null);

        this.setModal(true);

        this.setSize(200, 100);

    }

    //获取购票数量
    public int getValue() {
        int number = 0;
        if (buyNumber.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "请输入购买数量");
        } else {
            try {
                number = Integer.parseInt(buyNumber.getText().trim());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "非法输入");
            }
        }
        return number;
    }
}
