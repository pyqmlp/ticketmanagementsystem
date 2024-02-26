package ui;

import javax.swing.*;
import java.awt.*;

/**
 * @Author：真IKUN
 * @Package：ui
 * @Project：TicketManagementSystem
 * @name：AdminMainJPanel
 * @Date：2023/6/15 21:52
 * @Filename：AdminMainJPanel
 */
public class AdminMainJPanel extends JPanel {
    public AdminMainJPanel() {
        init();
        addConpotents();
    }


    private void init() {
        this.setLayout(null);
        this.setBounds(200, 0, 800, 600);
        this.setBackground(Color.WHITE);
    }

    private void addConpotents() {
        JPanel header = new JPanel();
        header.setLayout(null);
        header.setBounds(0, 0, 800, 50);
        header.setBackground(Color.WHITE);
        this.add(header);

        ImageIcon icon1 = new ImageIcon("libs/images/main (1).png");
        JLabel jLabel1 = new JLabel(icon1);
        jLabel1.setBounds(10, 10, 20, 30);
        header.add(jLabel1);

        JLabel headerText = new JLabel("主页");
        headerText.setBounds(35, 10, 100, 30);
        header.add(headerText);

        ImageIcon icon2 = new ImageIcon("libs/images/zuanyetuandui2.jpg");
        JLabel jLabel = new JLabel(icon2);
        jLabel.setBounds(0, 50, 800, 550);
        this.add(jLabel);
    }
}
