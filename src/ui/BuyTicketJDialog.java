package ui;

import service.UserService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDateTime;

/**
 * @Author：真IKUN
 * @Package：ui
 * @Project：TicketManagementSystem
 * @name：BuyTicketJDialog
 * @Date：2023/6/8 13:40
 * @Filename：BuyTicketJDialog
 */
public class BuyTicketJDialog extends JDialog {
    JTextField start_text;
    JTextField end_text;
    JButton query;
    JButton buy;
    JTable ticketInfoTable;
    String start = null;
    String end = null;
    String date = null;
    private JComboBox<String> dayComboBox;
    private JComboBox<String> monthComboBox;
    private JComboBox<String> yearComboBox;
    //获取当前时间
    LocalDateTime nowDate = LocalDateTime.now();

    public BuyTicketJDialog() {
        setLogo();
        init();
        addContentpane();
    }

    public void init() {
        this.setTitle("买票");

        this.setSize(1000, 600);

        this.setLocationRelativeTo(null);

        this.setResizable(false);

        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        this.setModal(true);
    }

    public void addContentpane() {
        JPanel root = new JPanel();
        root.setLayout(null);
        this.setContentPane(root);

        JPanel jPanel1 = new JPanel(new FlowLayout());
        jPanel1.setSize(1000, 50);
        //jPanel1.setBackground(Color.GREEN);
        JLabel jLabel = new JLabel("起始站:");
        jPanel1.add(jLabel);


        start_text = new JTextField(10);
        jPanel1.add(start_text);

        JLabel end_jLabel = new JLabel("终点站:");
        jPanel1.add(end_jLabel);

        end_text = new JTextField(10);
        jPanel1.add(end_text);

        JLabel time = new JLabel("日期");
        jPanel1.add(time);

        date = nowDate.toString().substring(0, 10);

        yearComboBox = new JComboBox<>();
        for (int i = 2000; i <= 2023; i++) {
            yearComboBox.addItem(String.valueOf(i));
        }
        yearComboBox.setSelectedIndex(Integer.parseInt(nowDate.toString().substring(2, 4)));
        jPanel1.add(yearComboBox);

        // 月份下拉框
        monthComboBox = new JComboBox<>();
        for (int i = 1; i <= 12; i++) {
            monthComboBox.addItem(String.valueOf(i));
        }
        monthComboBox.setSelectedIndex(Integer.parseInt(nowDate.toString().substring(5, 7)) - 1);
        jPanel1.add(monthComboBox);


        // 日期下拉框
        dayComboBox = new JComboBox<>();
        for (int i = 1; i <= 31; i++) {
            dayComboBox.addItem(String.valueOf(i));
        }
        dayComboBox.setSelectedIndex(Integer.parseInt(nowDate.toString().substring(8, 10)) - 1);
        jPanel1.add(dayComboBox);

        query = new JButton("查询");
        jPanel1.add(query);
        root.add(jPanel1);

        query.addActionListener((e) -> {
            Onquery();
        });


        buy = new JButton("购买");
        jPanel1.add(buy);
        buy.addActionListener((e) -> {
            OnBuy();
        });

        ticketInfoTable = UserService.QueryTicketInfo("", "", date);
        ticketInfoTable.setFillsViewportHeight(true);
        ticketInfoTable.setRowSelectionAllowed(true);
        ticketInfoTable.setRowHeight(24);
        JScrollPane jScrollPane = new JScrollPane(ticketInfoTable);
        jScrollPane.setBounds(0, 50, 1000, 600);
        root.add(jScrollPane);


    }

    //买票
    private void OnBuy() {
        //获取选中行的索引
        InputJDialog inputJDialog = null;
        int[] selectedRows = ticketInfoTable.getSelectedRows();
        for (int row = 0; row < selectedRows.length; row++) {
            int remainTicket = Integer.parseInt(ticketInfoTable.getValueAt(selectedRows[row], 7).toString());
            String date = ticketInfoTable.getValueAt(selectedRows[row], 1).toString();
            int shift = Integer.parseInt(ticketInfoTable.getValueAt(selectedRows[row], 0).toString());

            inputJDialog = new InputJDialog(this, remainTicket, shift, date);
        }
        //更新数据
        Onquery();
        if (inputJDialog != null) inputJDialog.dispose();

    }

    //查询
    private synchronized void Onquery() {
        start = start_text.getText().trim();
        end = end_text.getText().trim();
        date = yearComboBox.getSelectedItem() + "-"
                + monthComboBox.getSelectedItem() + "-"
                + dayComboBox.getSelectedItem();
        if (!date.equals("")) {
            JTable newTable = UserService.QueryTicketInfo(start, end, date);
            DefaultTableModel newTableModel = (DefaultTableModel) newTable.getModel();
            ticketInfoTable.setModel(newTableModel);
        }
    }

    private void setLogo() {
        Image icon = Toolkit.getDefaultToolkit().getImage("libs/images/Appicon.png");
        this.setIconImage(icon);
    }
}
