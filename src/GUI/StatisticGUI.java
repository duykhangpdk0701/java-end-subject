/*
 * Created by JFormDesigner on Thu Sep 09 22:10:41 ICT 2021
 */

package GUI;

import BLL.Helper;
import BLL.OrderBLL;
import BLL.StoreUserID;
import BLL.UserBLL;
import DTO.OrderDTO;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author unknown
 */
public class StatisticGUI extends JPanel {
    OrderBLL orderBLL = new OrderBLL();
    UserBLL userBLL = new UserBLL();
    float totalAll = 0;

    public StatisticGUI() {
        initComponents();
        loadStatistic();
    }


    public void loadStatistic() {

        DefaultTableModel dtm = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dtm.addColumn("id");
        dtm.addColumn("username");
        dtm.addColumn("date");
        dtm.addColumn("total");
        table1.setModel(dtm);

        orderBLL.getAllOrder().forEach(item -> {
            totalAll += item.getTotal();
            int id = item.getId();
            String username = userBLL.findUserByUserId(item.getUserId()).getUsername();
            String date = item.getDate();
            float total = item.getTotal();
            Object[] arr = {id, username, date, total};
            dtm.addRow(arr);
        });
        totalValue.setText(String.valueOf(totalAll));
    }


    public void loadStatisticWithMonthAndYear(int month, int year) {
        DefaultTableModel dtm = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dtm.addColumn("id");
        dtm.addColumn("username");
        dtm.addColumn("date");
        dtm.addColumn("total");
        table1.setModel(dtm);

        orderBLL.getOrderByMonthAndYear(month, year).forEach(item -> {
            totalAll += item.getTotal();
            int id = item.getId();
            String username = userBLL.findUserByUserId(item.getUserId()).getUsername();
            String date = item.getDate();
            float total = item.getTotal();
            Object[] arr = {id, username, date, total};
            dtm.addRow(arr);
        });
        totalValue.setText(String.valueOf(totalAll));
    }

    private void detailBtnActionPerformed(ActionEvent e) {
        DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
        int orderId = Integer.parseInt(dtm.getValueAt(table1.getSelectedRow(), 0).toString());
        OrderDetailGUI orderDetailGUI = new OrderDetailGUI(orderId);
        orderDetailGUI.setVisible(true);
    }

    private void printBtnActionPerformed(ActionEvent e) {
        Helper.print(table1, "thống kê tháng" + "năm");
    }

    private void exportBtnActionPerformed(ActionEvent e) {
        Helper.exportFileExcel(table1, this);
    }

    private void yearInputItemStateChanged(ItemEvent e) {
        totalAll = 0;
        loadStatisticWithMonthAndYear(Integer.parseInt(monthInput.getSelectedItem().toString()), Integer.parseInt(yearInput.getSelectedItem().toString()));
    }

    private void monthInputItemStateChanged(ItemEvent e) {
        totalAll = 0;
        loadStatisticWithMonthAndYear(Integer.parseInt(monthInput.getSelectedItem().toString()), Integer.parseInt(yearInput.getSelectedItem().toString()));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        monthInput = new JComboBox<>();
        yearInput = new JComboBox<>();
        monthLabel = new JLabel();
        yearLabel = new JLabel();
        exportBtn = new JButton();
        printBtn = new JButton();
        detailBtn = new JButton();
        totalLabel = new JLabel();
        totalValue = new JLabel();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.
                EmptyBorder(0, 0, 0, 0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax.swing.border.TitledBorder.CENTER, javax.swing
                .border.TitledBorder.BOTTOM, new java.awt.Font("Dia\u006cog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder()));
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            @Override
            public void propertyChange(java.beans.PropertyChangeEvent e) {
                if ("\u0062ord\u0065r".equals(e.getPropertyName()))
                    throw new RuntimeException();
            }
        });
        setLayout(null);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                    new Object[][]{
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                    },
                    new String[]{
                            null, null, null, null, null
                    }
            ));
            scrollPane1.setViewportView(table1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(0, 0, 1200, scrollPane1.getPreferredSize().height);

        //---- monthInput ----
        monthInput.setModel(new DefaultComboBoxModel<>(new String[]{
                "0",
                "1",
                "2",
                "3",
                "4",
                "5",
                "6",
                "7",
                "8",
                "9",
                "10",
                "11",
                "12"
        }));
        monthInput.addItemListener(e -> monthInputItemStateChanged(e));
        add(monthInput);
        monthInput.setBounds(150, 450, 100, 30);

        //---- yearInput ----
        yearInput.setModel(new DefaultComboBoxModel<>(new String[]{
                "0",
                "2017",
                "2018",
                "2019",
                "2020",
                "2021"
        }));
        yearInput.addItemListener(e -> yearInputItemStateChanged(e));
        add(yearInput);
        yearInput.setBounds(345, 450, 100, 30);

        //---- monthLabel ----
        monthLabel.setText("Th\u00e1ng");
        add(monthLabel);
        monthLabel.setBounds(75, 450, 75, 30);

        //---- yearLabel ----
        yearLabel.setText("N\u0103m");
        add(yearLabel);
        yearLabel.setBounds(275, 450, 75, 30);

        //---- exportBtn ----
        exportBtn.setText("Xu\u1ea9t ra file excel");
        exportBtn.addActionListener(e -> exportBtnActionPerformed(e));
        add(exportBtn);
        exportBtn.setBounds(1010, 560, 150, 40);

        //---- printBtn ----
        printBtn.setText("In");
        printBtn.addActionListener(e -> printBtnActionPerformed(e));
        add(printBtn);
        printBtn.setBounds(815, 560, 150, 40);

        //---- detailBtn ----
        detailBtn.setText("Xem chi ti\u1ebft");
        detailBtn.addActionListener(e -> detailBtnActionPerformed(e));
        add(detailBtn);
        detailBtn.setBounds(620, 560, 150, 40);

        //---- totalLabel ----
        totalLabel.setText("T\u1ed5ng");
        add(totalLabel);
        totalLabel.setBounds(850, 460, 100, 30);

        //---- totalValue ----
        totalValue.setText("000");
        add(totalValue);
        totalValue.setBounds(950, 460, 200, 30);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for (int i = 0; i < getComponentCount(); i++) {
                Rectangle bounds = getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            setMinimumSize(preferredSize);
            setPreferredSize(preferredSize);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JScrollPane scrollPane1;
    private JTable table1;
    private JComboBox<String> monthInput;
    private JComboBox<String> yearInput;
    private JLabel monthLabel;
    private JLabel yearLabel;
    private JButton exportBtn;
    private JButton printBtn;
    private JButton detailBtn;
    private JLabel totalLabel;
    private JLabel totalValue;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
