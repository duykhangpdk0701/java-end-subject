/*
 * Created by JFormDesigner on Wed Sep 08 15:37:13 ICT 2021
 */

package GUI;

import BLL.Helper;
import BLL.OrderBLL;
import BLL.StoreUserID;
import DTO.UserDTO;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author unknown
 */
public class HistoryGUI extends JPanel {
    OrderBLL orderBLL = new OrderBLL();

    public HistoryGUI() {
        initComponents();
        loadHistory();
    }

    public void loadHistory() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("id");
        dtm.addColumn("date");
        dtm.addColumn("total");
        table1.setModel(dtm);

        orderBLL.getOrderById(StoreUserID.getId()).forEach(item -> {
            int id = item.getId();
            String date = item.getDate();
            float total = item.getTotal();
            Object[] arr = {id, date, total};
            dtm.addRow(arr);
        });
    }

    private void detailBtnActionPerformed(ActionEvent e) {
        DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
        int orderId = Integer.parseInt(dtm.getValueAt(table1.getSelectedRow(), 0).toString());
        OrderDetailGUI orderDetailGUI = new OrderDetailGUI(orderId);
        orderDetailGUI.setVisible(true);
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
        detailBtn = new JButton();
        exportBtn = new JButton();
        printBtn = new JButton();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.
                swing.border.EmptyBorder(0, 0, 0, 0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax.swing.border
                .TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dia\u006cog"
                , java.awt.Font.BOLD, 12), java.awt.Color.red), getBorder
                ()));
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            @Override
            public void propertyChange(java
                                               .beans.PropertyChangeEvent e) {
                if ("bord\u0065r".equals(e.getPropertyName())) throw new RuntimeException
                        ();
            }
        });
        setLayout(null);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                    new Object[][]{
                            {null, null, null},
                            {null, null, null},
                    },
                    new String[]{
                            null, null, null
                    }
            ));
            scrollPane1.setViewportView(table1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(0, 0, 1200, scrollPane1.getPreferredSize().height);

        //---- detailBtn ----
        detailBtn.setText("detail");
        detailBtn.addActionListener(e -> detailBtnActionPerformed(e));
        add(detailBtn);
        detailBtn.setBounds(1025, 520, 100, 40);

        //---- exportBtn ----
        exportBtn.setText("Xu\u1ea5t file excel");
        exportBtn.addActionListener(e -> exportBtnActionPerformed(e));
        add(exportBtn);
        exportBtn.setBounds(845, 520, 120, 40);

        //---- printBtn ----
        printBtn.setText("In");
        printBtn.addActionListener(e -> printBtnActionPerformed(e));
        add(printBtn);
        printBtn.setBounds(675, 520, 100, 40);

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
    private JButton detailBtn;
    private JButton exportBtn;
    private JButton printBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
