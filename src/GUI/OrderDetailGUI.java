/*
 * Created by JFormDesigner on Wed Sep 08 16:07:08 ICT 2021
 */

package GUI;

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

    public OrderDetailGUI(int orderId) {
        initComponents();
        loadOrderDetailGUI(orderId);
    }


    public void loadOrderDetailGUI(int orderId) {
        int count = 0;
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("id");
        dtm.addColumn("name");
        dtm.addColumn("amount");
        dtm.addColumn("price");
        dtm.addColumn("total");
        table1.setModel(dtm);

        orderDetailBLL.getOrderDetailByOrderId(orderId).forEach(item -> {
            int id = count + 1;
            String name = vegetableBLL.findVegetableById(item.getVegetableId()).getName();
            int amount = item.getQuantity();
            float price = item.getPrice();
            float total = amount * price;
            Object[] arr = {id, name, amount, price, total};
            dtm.addRow(arr);
        });

    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null},
                    {null, null, null, null},
                },
                new String[] {
                    null, null, null, null
                }
            ));
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 0, 900, 470);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
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
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
