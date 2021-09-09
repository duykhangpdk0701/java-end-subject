/*
 * Created by JFormDesigner on Wed Sep 08 21:25:35 ICT 2021
 */

package GUI;

import BLL.Helper;
import BLL.VegetableBLL;
import DTO.VegetableDTO;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author unknown
 */
public class AdminVegetableGUI extends JPanel {
    VegetableBLL vegetableBLL = new VegetableBLL();

    public AdminVegetableGUI() {
        initComponents();
        loadVegetable();
    }

    public void loadVegetable() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("id");
        dtm.addColumn("categoryId");
        dtm.addColumn("name");
        dtm.addColumn("unit");
        dtm.addColumn("amount");
        dtm.addColumn("price");
        table1.setModel(dtm);
        Vector<VegetableDTO> vegetableDTOS = new Vector<VegetableDTO>();
        vegetableDTOS = vegetableBLL.getAllVegetable();
        vegetableDTOS.forEach(n -> {
            int id = n.getId();
            int categoryId = n.getCategoryId();
            String name = n.getName();
            String unit = n.getUnit();
            int amount = n.getAmount();
            float price = n.getPrice();
            Object[] arr = {id, categoryId, name, unit, amount, price};
            dtm.addRow(arr);
        });
    }

    private void addBtnActionPerformed(ActionEvent e) {
        AddVegetableGUI addVegetableGUI = new AddVegetableGUI();
        addVegetableGUI.setVisible(true);
        addVegetableGUI.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                loadVegetable();
            }
        });
    }

    private void editBtnActionPerformed(ActionEvent e) {
        DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
        int value = Integer.parseInt(dtm.getValueAt(table1.getSelectedRow(), 0).toString());
        EditVegetableGUI editVegetableGUI = new EditVegetableGUI(value);
        editVegetableGUI.setVisible(true);
        editVegetableGUI.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                loadVegetable();
            }
        });
    }

    private void printBtnActionPerformed(ActionEvent e) {
        Helper.print(table1, "Vegetable");
    }

    private void exportBtnActionPerformed(ActionEvent e) {
        Helper.exportFileExcel(table1, this);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        editBtn = new JButton();
        addBtn = new JButton();
        exportBtn = new JButton();
        printBtn = new JButton();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing
                .border.EmptyBorder(0, 0, 0, 0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax.swing.border.TitledBorder
                .CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dia\u006cog", java.
                awt.Font.BOLD, 12), java.awt.Color.red), getBorder()))
        ;
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            @Override
            public void propertyChange(java.beans.PropertyChangeEvent e
            ) {
                if ("bord\u0065r".equals(e.getPropertyName())) throw new RuntimeException();
            }
        })
        ;
        setLayout(null);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                    new Object[][]{
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                    },
                    new String[]{
                            null, null, null, null, null, null
                    }
            ));
            scrollPane1.setViewportView(table1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(0, 0, 1200, scrollPane1.getPreferredSize().height);

        //---- editBtn ----
        editBtn.setText("S\u1eeda");
        editBtn.addActionListener(e -> editBtnActionPerformed(e));
        add(editBtn);
        editBtn.setBounds(830, 520, 100, 40);

        //---- addBtn ----
        addBtn.setText("Th\u00eam");
        addBtn.addActionListener(e -> addBtnActionPerformed(e));
        add(addBtn);
        addBtn.setBounds(1015, 520, 100, 40);

        //---- exportBtn ----
        exportBtn.setText("Xu\u1ea5t file Excel");
        exportBtn.addActionListener(e -> exportBtnActionPerformed(e));
        add(exportBtn);
        exportBtn.setBounds(645, 520, 115, 40);

        //---- printBtn ----
        printBtn.setText("In");
        printBtn.addActionListener(e -> printBtnActionPerformed(e));
        add(printBtn);
        printBtn.setBounds(460, 520, 100, 40);

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
    private JButton editBtn;
    private JButton addBtn;
    private JButton exportBtn;
    private JButton printBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
