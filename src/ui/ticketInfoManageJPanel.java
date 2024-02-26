package ui;

import service.AdminService;
import entity.Shift;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDateTime;

/**
 * @Author：真IKUN
 * @Package：ui
 * @Project：TicketManagementSystem
 * @name：ticketInfoManageJFrame
 * @Date：2023/6/15 20:39
 * @Filename：ticketInfoManageJFrame
 */
public class ticketInfoManageJPanel extends JPanel {
    JComboBox<String> yearComboBox;
    JComboBox<String> monthComboBox;
    JComboBox<String> dayComboBox;
    JTable ticketInfoTable;

    String nowDate;

    public ticketInfoManageJPanel() {
        init();
        addConpotents();
    }


    private void init() {
        this.setLayout(null);
        this.setBounds(200, 0, 800, 600);
        this.setBackground(Color.WHITE);
    }

    private void addConpotents() {
        //添加根JPanel
        JPanel header = new JPanel();
        header.setBounds(0, 0, 800, 50);
        header.setLayout(null);
        header.setBorder(new LineBorder(new Color(192, 192, 192)));
        header.setBackground(Color.WHITE);
        this.add(header);

        //添加导航栏logo
        ImageIcon icon1 = new ImageIcon("libs/images/ticketmanage (1).png");
        JLabel jLabel1 = new JLabel(icon1);
        jLabel1.setBounds(10, 10, 20, 30);
        header.add(jLabel1);

        //添加导航栏logo后的文字
        JLabel headerText = new JLabel("班次信息管理");
        headerText.setBounds(35, 10, 100, 30);
        header.add(headerText);


        JPanel Main = new JPanel();
        Main.setLayout(null);
        Main.setBounds(0, 50, 800, 550);
        //Main.setBackground(Color.cyan);
        this.add(Main);

        //添加按钮区域
        JPanel buttonArea = new JPanel();
        buttonArea.setSize(800, 40);
        buttonArea.setBackground(Color.WHITE);
        buttonArea.setLayout(null);
        Main.add(buttonArea);

        //添加按钮
        JButton btnAdd = new JButton("增加");
        btnAdd.setBounds(0, 5, 80, 30);
        buttonArea.add(btnAdd);
        btnAdd.addActionListener((e) -> {
            OnbtnAdd();
        });

        JButton btnDelete = new JButton("删除");
        btnDelete.setBounds(85, 5, 80, 30);
        buttonArea.add(btnDelete);
        btnDelete.addActionListener((e) -> {
            OnbtnDelete();
        });

        JButton btnUpdate = new JButton("修改");
        btnUpdate.setBounds(170, 5, 80, 30);
        buttonArea.add(btnUpdate);
        btnUpdate.addActionListener((e) -> {
            OnUpdate();
        });

        nowDate = LocalDateTime.now().toString().substring(0, 10);
        System.out.println(nowDate);
        yearComboBox = new JComboBox<>();
        for (int i = 2000; i <= 2025; i++) {
            yearComboBox.addItem(String.valueOf(i));
        }
        yearComboBox.setSelectedIndex(Integer.parseInt(nowDate.toString().substring(2, 4)));
        buttonArea.add(yearComboBox);
        yearComboBox.setBounds(255, 5, 80, 30);


        monthComboBox = new JComboBox<>();
        for (int i = 1; i <= 12; i++) {
            monthComboBox.addItem(String.valueOf(i));
        }
        monthComboBox.setSelectedIndex(Integer.parseInt(nowDate.toString().substring(5, 7)) - 1);
        buttonArea.add(monthComboBox);
        monthComboBox.setBounds(340, 5, 50, 30);


        dayComboBox = new JComboBox<>();
        for (int i = 1; i <= 31; i++) {
            dayComboBox.addItem(String.valueOf(i));
        }
        dayComboBox.setSelectedIndex(Integer.parseInt(nowDate.toString().substring(8, 10)) - 1);
        buttonArea.add(dayComboBox);
        dayComboBox.setBounds(395, 5, 50, 30);


        JButton btnSearch = new JButton("查找");
        btnSearch.setBounds(445, 5, 100, 30);
        buttonArea.add(btnSearch);
        btnSearch.addActionListener((e) -> {
            OnbtnSearch();
        });

        ticketInfoTable = new JTable();
        ticketInfoTable = AdminService.GetTicketInfo(nowDate, "", "");
        ticketInfoTable.setFillsViewportHeight(true);
        ticketInfoTable.setRowSelectionAllowed(true);
        ticketInfoTable.setRowHeight(24);
        JScrollPane jScrollPane = new JScrollPane(ticketInfoTable);
        jScrollPane.setBounds(0, 50, 800, 500);
        Main.add(jScrollPane);
    }


    private void OnbtnSearch() {

        String date = yearComboBox.getSelectedItem() + "-" + monthComboBox.getSelectedItem() + "-" + dayComboBox.getSelectedItem();
        System.out.println(date);
        JTable newJTable = AdminService.GetTicketInfo(date, "", "");
        DefaultTableModel tableModel = (DefaultTableModel) newJTable.getModel();
        ticketInfoTable.setModel(tableModel);
    }

    public void OnUpdate() {
        int[] selectedRows = ticketInfoTable.getSelectedRows();
        if (selectedRows.length == 0) return;
        Shift shift = new Shift();
        for (int row = 0; row < selectedRows.length; row++) {
            shift.setDate(ticketInfoTable.getValueAt(selectedRows[row], 1).toString());
            shift.setShift(ticketInfoTable.getValueAt(selectedRows[row], 0).toString());
            shift.setTime(ticketInfoTable.getValueAt(selectedRows[row], 2).toString());
            shift.setStartPosition(ticketInfoTable.getValueAt(selectedRows[row], 3).toString());
            shift.setEndPosition(ticketInfoTable.getValueAt(selectedRows[row], 4).toString());
            shift.setDuration(ticketInfoTable.getValueAt(selectedRows[row], 5).toString());
            shift.setTitleNum(ticketInfoTable.getValueAt(selectedRows[row], 6).toString());
            new updateShiftInfoJDialog(shift);
        }
    }

    public void OnbtnAdd() {
        addShiftInfoJDialog addShiftInfoJDialog = new addShiftInfoJDialog();
        OnbtnSearch();
    }

    private void OnbtnDelete() {
        int[] selectedRows = ticketInfoTable.getSelectedRows();
        if (selectedRows.length == 0) return;
        int i = JOptionPane.showConfirmDialog(this, "是否删除已选中班次？", "删除班次", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            for (int row = 0; row < selectedRows.length; row++) {
                String date = ticketInfoTable.getValueAt(selectedRows[row], 1).toString();
                String shift = ticketInfoTable.getValueAt(selectedRows[row], 0).toString();
                if (AdminService.deleteShift(date, shift)) JOptionPane.showMessageDialog(this, "删除成功");
                else JOptionPane.showMessageDialog(this, "删除失败");
            }
            OnbtnSearch();
        }

    }
}
