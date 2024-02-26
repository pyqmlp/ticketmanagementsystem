package ui;

import service.UserService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * @Author：真IKUN
 * @Package：ui
 * @Project：TicketManagementSystem
 * @name：MyOrdersJDialog
 * @Date：2023/6/11 19:25
 * @Filename：MyOrdersJDialog
 */
public class MyOrdersJDialog extends JDialog {
    JTable MyOrderJTable = new JTable();

    public MyOrdersJDialog(Window owner) {
        super(owner);
        init();
        addComptents();
        this.setVisible(true);
    }

    private void addComptents() {
        JPanel root = new JPanel();
        root.setLayout(null);
        this.setContentPane(root);

        JPanel subJPanel = new JPanel(new FlowLayout());
        subJPanel.setSize(1000, 50);

        JButton btnRefund = new JButton("退票");
        subJPanel.add(btnRefund);
        btnRefund.addActionListener((e) -> {
            OnbtnRefund();
        });

        MyOrderJTable = UserService.queryOrder(UserMainFrame.getUserId());
        MyOrderJTable.setFillsViewportHeight(true);
        MyOrderJTable.setRowSelectionAllowed(true);
        MyOrderJTable.setRowHeight(24);
        JScrollPane jScrollPane = new JScrollPane(MyOrderJTable);
        jScrollPane.setBounds(0, 50, 1000, 600);
        root.add(jScrollPane);

        root.add(subJPanel);
    }

    private void OnbtnRefund() {
        int[] selectedRows = MyOrderJTable.getSelectedRows();
        for (int row = 0; row < selectedRows.length; row++) {
            String date = MyOrderJTable.getValueAt(selectedRows[row], 0).toString();
            String shift = MyOrderJTable.getValueAt(selectedRows[row], 1).toString();
            if (UserService.refund(UserMainFrame.getUserId(), date, shift)) {
                JOptionPane.showMessageDialog(this, "退票成功");
                Onquery();
            } else {
                JOptionPane.showMessageDialog(this, "退票失败");
            }

        }
    }

    public void init() {
        this.setTitle("我的订单");

        this.setSize(1000, 600);

        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(2);

        this.setModal(true);

    }

    private void Onquery() {
            JTable newTable = UserService.queryOrder(UserMainFrame.getUserId());
            DefaultTableModel newTableModel = (DefaultTableModel) newTable.getModel();
            MyOrderJTable.setModel(newTableModel);
    }
}
