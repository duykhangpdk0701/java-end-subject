/*
 * Created by JFormDesigner on Wed Sep 08 16:07:08 ICT 2021
 */

package GUI;

import java.awt.event.*;

import BLL.Helper;
import BLL.OrderDetailBLL;
import BLL.VegetableBLL;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author unknown
 */
public class OrderDetailGUI extends JFrame {
    VegetableBLL vegetableBLL = new VegetableBLL();
    OrderDetailBLL orderDetailBLL = new OrderDetailBLL();
    int count = 1;

    public OrderDetailGUI(int orderId) {
        initComponents();
        loadOrderDetailGUI(orderId);
    }


    public void loadOrderDetailGUI(int orderId) {

        DefaultTableModel dtm = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dtm.addColumn("Số thứ tự");
        dtm.addColumn("name");
        dtm.addColumn("amount");
        dtm.addColumn("price");
        dtm.addColumn("total");
        table1.setModel(dtm);

        orderDetailBLL.getOrderDetailByOrderId(orderId).forEach(item -> {
            int id = count++;
            String name = vegetableBLL.findVegetableById(item.getVegetableId()).getName();
            int amount = item.getQuantity();
            float price = item.getPrice();
            float total = amount * price;
            Object[] arr = {id, name, amount, price, total};
            dtm.addRow(arr);
        });

    }

    private void exportBtnActionPerformed(ActionEvent e) {
        Helper.exportFileExcel(table1, this);
    }

    private void printBtnActionPerformed(ActionEvent e) {
        Helper.print(table1, "History");
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        exportBtn = new JButton();
        printBtn = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                    new Object[][]{
                            {null, null, null, null},
                            {null, null, null, null},
                    },
                    new String[]{
                            null, null, null, null
                    }
            ));
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 0, 900, 400);

        //---- exportBtn ----
        exportBtn.setText("Xu\u1ea5t file Excel");
        exportBtn.addActionListener(e -> exportBtnActionPerformed(e));
        contentPane.add(exportBtn);
        exportBtn.setBounds(710, 415, 150, 40);

        //---- printBtn ----
        printBtn.setText("In");
        printBtn.addActionListener(e -> printBtnActionPerformed(e));
        contentPane.add(printBtn);
        printBtn.setBounds(470, 415, 150, 40);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for (int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        setSize(900, 500);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton exportBtn;
    private JButton printBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
