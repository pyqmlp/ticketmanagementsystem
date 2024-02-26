package ui;

import service.AdminService;
import entity.Shift;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.time.LocalDateTime;

/**
 * @Author：真IKUN
 * @Package：ui
 * @Project：TicketManagementSystem
 * @name：addShiftInfoJDialog
 * @Date：2023/6/16 12:37
 * @Filename：addShiftInfoJDialog
 */
public class addShiftInfoJDialog extends JDialog {
    JComboBox<String> yearComboBox;
    JComboBox<String> monthComboBox;
    JComboBox<String> dayComboBox;

    JComboBox<String> hourComboBox;
    JComboBox<String> minuteComboBox;
    JTextField start_jTextField;
    JTextField shift_jTextField;
    JTextField end_jTextField;
    JTextField duration_jTextField;
    JTextField titleNum_jTextField;
    JLabel date_jLabelTip;
    JLabel shift_jLabelTip = new JLabel();
    JLabel time_jLabelTip;
    JLabel start_jLabelTip;
    JLabel end_jLabelTip;
    JLabel duration_jLabelTip;
    JLabel titleNum_jLabelTip;

    public addShiftInfoJDialog() {
        init();
        addCompotents();
        this.setVisible(true);
    }

    public void init() {
        this.setTitle("添加班次信息");
        setLogo();
        this.setSize(400, 600);
        this.setLocationRelativeTo(null);
        this.setModal(true);
    }

    public void addCompotents() {
        JPanel root = new JPanel();
        this.setContentPane(root);
        root.setBackground(Color.WHITE);
        root.setLayout(null);

        JPanel dateItem = new JPanel();
        dateItem.setLayout(null);
        dateItem.setBackground(Color.WHITE);
        dateItem.setBounds(0, 0, 400, 60);
        root.add(dateItem);

        JLabel date_jLabel = new JLabel("日期:");
        date_jLabel.setBounds(125, 15, 30, 30);
        dateItem.add(date_jLabel);

        String nowDate = LocalDateTime.now().toString().substring(0, 10);
        String nowYear = nowDate.substring(0, 4);
        yearComboBox = new JComboBox<>();
        for (int year = 2023; year <= 2025; year++) {
            yearComboBox.addItem(String.valueOf(year));
        }
        yearComboBox.setSelectedIndex(Integer.parseInt(nowYear) - 2023);
        yearComboBox.setBounds(160, 15, 60, 30);
        dateItem.add(yearComboBox);

        String nowMonth = nowDate.substring(5, 7);
        monthComboBox = new JComboBox<>();
        for (int month = 1; month <= 12; month++) {
            monthComboBox.addItem(String.valueOf(month));
        }
        monthComboBox.setSelectedIndex(Integer.parseInt(nowMonth) - 1);
        monthComboBox.setBounds(225, 15, 40, 30);
        dateItem.add(monthComboBox);

        String nowDay = nowDate.substring(8, 10);
        dayComboBox = new JComboBox<>();
        for (int day = 1; day < 31; day++) {
            dayComboBox.addItem(String.valueOf(day));
        }
        dayComboBox.setSelectedIndex(Integer.parseInt(nowDay) - 1);
        dayComboBox.setBounds(270, 15, 40, 30);
        dateItem.add(dayComboBox);

        date_jLabelTip = new JLabel();
        date_jLabelTip.setBounds(315, 15, 100, 30);
        date_jLabelTip.setVisible(false);
        date_jLabelTip.setForeground(Color.red);
        dateItem.add(date_jLabelTip);

        JPanel shiftItem = new JPanel();
        shiftItem.setLayout(null);
        shiftItem.setBackground(Color.WHITE);
        shiftItem.setBounds(0, 60, 400, 60);
        root.add(shiftItem);

        JLabel shift_jLabel = new JLabel("班次:");
        shift_jLabel.setBounds(125, 15, 30, 30);
        shiftItem.add(shift_jLabel);

        shift_jLabelTip.setBounds(265, 15, 100, 30);
        shift_jLabelTip.setVisible(false);
        shift_jLabelTip.setForeground(Color.red);
        shiftItem.add(shift_jLabelTip);

        shift_jTextField = new JTextField(5);
        shift_jTextField.setBounds(160, 15, 100, 30);
        shiftItem.add(shift_jTextField);
        shift_jTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                shift_jLabelTip.setForeground(Color.darkGray);
                shift_jLabelTip.setText("大于等于一");
                shift_jLabelTip.setVisible(true);
            }

            @Override
            public void focusLost(FocusEvent e) {
                shift_jLabelTip.setVisible(false);
                shift_jLabelTip.setForeground(Color.RED);
            }
        });


        JPanel timeItem = new JPanel();
        timeItem.setLayout(null);
        timeItem.setBackground(Color.WHITE);
        timeItem.setBounds(0, 120, 400, 60);
        root.add(timeItem);

        JLabel time_jLabel = new JLabel("发车时间:");
        time_jLabel.setBounds(100, 15, 55, 30);
        timeItem.add(time_jLabel);

        hourComboBox = new JComboBox<>();
        for (int i = 1; i <= 24; i++) {
            String hour = "";
            if (i < 10) {
                hour = "0" + String.valueOf(i);
                hourComboBox.addItem(hour);
            } else {
                hourComboBox.addItem(String.valueOf(i));
            }
        }
        hourComboBox.setSelectedIndex(7);
        hourComboBox.setBounds(160, 15, 40, 30);
        timeItem.add(hourComboBox);

        minuteComboBox = new JComboBox<>();
        for (int i = 0; i <= 60; i += 10) {
            if (i == 0) minuteComboBox.addItem("00");
            else minuteComboBox.addItem(String.valueOf(i));
        }
        minuteComboBox.setBounds(205, 15, 40, 30);
        timeItem.add(minuteComboBox);

        time_jLabelTip = new JLabel();
        time_jLabelTip.setBounds(265, 15, 100, 30);
        time_jLabelTip.setVisible(false);
        time_jLabelTip.setForeground(Color.red);
        timeItem.add(time_jLabelTip);

        JPanel startItem = new JPanel();
        startItem.setLayout(null);
        startItem.setBackground(Color.WHITE);
        startItem.setBounds(0, 180, 400, 60);
        root.add(startItem);

        JLabel start_jLabel = new JLabel("起始站:");
        start_jLabel.setBounds(115, 15, 40, 30);
        startItem.add(start_jLabel);

        start_jTextField = new JTextField(5);
        start_jTextField.setBounds(160, 15, 100, 30);
        startItem.add(start_jTextField);

        start_jLabelTip = new JLabel();
        start_jLabelTip.setBounds(265, 15, 100, 30);
        start_jLabelTip.setVisible(false);
        start_jLabelTip.setForeground(Color.red);
        startItem.add(start_jLabelTip);

        JPanel endItem = new JPanel();
        endItem.setLayout(null);
        endItem.setBackground(Color.WHITE);
        endItem.setBounds(0, 240, 400, 60);
        root.add(endItem);

        JLabel end_jLabel = new JLabel("终点站:");
        end_jLabel.setBounds(115, 15, 40, 30);
        endItem.add(end_jLabel);

        end_jTextField = new JTextField(5);
        end_jTextField.setBounds(160, 15, 100, 30);
        endItem.add(end_jTextField);

        end_jLabelTip = new JLabel();
        end_jLabelTip.setBounds(265, 15, 100, 30);
        end_jLabelTip.setVisible(false);
        end_jLabelTip.setForeground(Color.red);
        endItem.add(end_jLabelTip);

        JPanel durationItem = new JPanel();
        durationItem.setLayout(null);
        durationItem.setBackground(Color.WHITE);
        durationItem.setBounds(0, 300, 400, 60);
        root.add(durationItem);

        JLabel duration_jLabel = new JLabel("行车时间:");
        duration_jLabel.setBounds(100, 15, 55, 30);
        durationItem.add(duration_jLabel);

        duration_jTextField = new JTextField(5);
        duration_jTextField.setBounds(160, 15, 100, 30);
        durationItem.add(duration_jTextField);

        duration_jLabelTip = new JLabel();
        duration_jLabelTip.setBounds(265, 15, 100, 30);
        duration_jLabelTip.setVisible(false);
        duration_jLabelTip.setForeground(Color.red);
        durationItem.add(duration_jLabelTip);


        JPanel titleNumItem = new JPanel();
        titleNumItem.setLayout(null);
        titleNumItem.setBackground(Color.WHITE);
        titleNumItem.setBounds(0, 360, 400, 60);
        root.add(titleNumItem);

        JLabel titleNum_jLabel = new JLabel("额定载量:");
        titleNum_jLabel.setBounds(100, 15, 55, 30);
        titleNumItem.add(titleNum_jLabel);

        titleNum_jTextField = new JTextField(5);
        titleNum_jTextField.setBounds(160, 15, 100, 30);
        titleNumItem.add(titleNum_jTextField);

        titleNum_jLabelTip = new JLabel();
        titleNum_jLabelTip.setBounds(265, 15, 100, 30);
        titleNum_jLabelTip.setVisible(false);
        titleNum_jLabelTip.setForeground(Color.red);
        titleNumItem.add(titleNum_jLabelTip);

        JPanel addItem = new JPanel();
        addItem.setLayout(null);
        addItem.setBackground(Color.WHITE);
        addItem.setBounds(0, 420, 400, 60);
        root.add(addItem);

        JButton btnAdd = new JButton("添加班次");
        btnAdd.setBounds(150, 15, 100, 30);
        addItem.add(btnAdd);

        btnAdd.addActionListener((e) -> {
            OnbtnAdd();
        });
    }

    private void OnbtnAdd() {
        boolean isAdd = true;
        String date = yearComboBox.getSelectedItem() + "-" +
                monthComboBox.getSelectedItem() + "-" +
                dayComboBox.getSelectedItem();
        String shift = shift_jTextField.getText().trim();
        String time = hourComboBox.getSelectedItem() + ":" +
                minuteComboBox.getSelectedItem();
        String startPosition = start_jTextField.getText().trim();
        String endPosition = end_jTextField.getText().trim();
        String duration = duration_jTextField.getText().trim();
        String titleNum = titleNum_jTextField.getText().trim();

        if (date.equals("")) {

        }

        if (shift.equals("")) {
            shift_jLabelTip.setForeground(Color.RED);
            shift_jLabelTip.setText("班次不能为空!");
            shift_jLabelTip.setVisible(true);
            isAdd = false;
        } else shift_jLabelTip.setVisible(false);
        if (startPosition.equals("")) {
            start_jLabelTip.setText("起始站不能为空!");
            start_jLabelTip.setVisible(true);
            isAdd = false;
        } else start_jLabelTip.setVisible(false);

        if (endPosition.equals("")) {
            end_jLabelTip.setText("终点站不能为空!");
            end_jLabelTip.setVisible(true);
            isAdd = false;
        } else end_jLabelTip.setVisible(false);

        if (duration.equals("")) {
            duration_jLabelTip.setText("行车时间不能为空");
            duration_jLabelTip.setVisible(true);
            isAdd = false;
        } else {
            duration_jLabelTip.setVisible(false);
        }

        if (titleNum.equals("")) {
            titleNum_jLabelTip.setText("额定载量不能为空");
            titleNum_jLabelTip.setVisible(true);
            isAdd = false;
        } else {
            titleNum_jLabelTip.setVisible(false);
        }

        //判断班次信息是否已经存在
        if (isAdd && AdminService.isShiftExit(date, shift)) {
            isAdd = false;
            JOptionPane.showMessageDialog(this, "该班次已经存在");
        }

        if (isAdd) {
            Shift shift1 = new Shift();
            shift1.setDate(date);
            shift1.setShift(shift);
            shift1.setTime(time);
            shift1.setStartPosition(startPosition);
            shift1.setEndPosition(endPosition);
            shift1.setDuration(duration);
            shift1.setTitleNum(titleNum);
            //添加班次
            if (AdminService.addShift(shift1)) {
                JOptionPane.showMessageDialog(this, "添加班次成功");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "添加班次失败");
            }
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
