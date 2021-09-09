/*
 * Created by JFormDesigner on Mon Sep 06 21:40:02 ICT 2021
 */

package GUI;

import java.awt.event.*;

import BLL.CategoryBLL;
import DTO.CategoryDTO;

import java.awt.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author unknown
 */
public class CategoryGUI extends JPanel {
    CategoryBLL categoryBLL = new CategoryBLL();

    public CategoryGUI() {
        initComponents();
        loadCategory();
    }

    public void loadCategory() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("id");
        dtm.addColumn("name");
        dtm.addColumn("description");
        table1.setModel(dtm);
        Vector<CategoryDTO> categoryDTOS = new Vector<CategoryDTO>();
        categoryDTOS = categoryBLL.getAllCategory();
        categoryDTOS.forEach(n -> {
            int id = n.getId();
            String name = n.getName();
            String description = n.getDescription();
            Object[] arr = {id, name, description};
            dtm.addRow(arr);
        });
    }

    private void table1MouseClicked(MouseEvent e) {
        int selectRowIndex = table1.getSelectedRow();
    }

    private void addBtnActionPerformed(ActionEvent e) {
        AddCategoryGUI addCategoryGUI = new AddCategoryGUI();
        addCategoryGUI.setVisible(true);
        loadCategory();
    }

    private void editBtnActionPerformed(ActionEvent e) {
        DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
        int value = Integer.parseInt(dtm.getValueAt(table1.getSelectedRow(), 0).toString());
        EditCategoryGUI editCategoryGUI = new EditCategoryGUI(value);
        editCategoryGUI.setVisible(true);
        loadCategory();
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        addBtn = new JButton();
        editBtn = new JButton();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder
                (0, 0, 0, 0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax.swing.border.TitledBorder.CENTER, javax.swing.border
                .TitledBorder.BOTTOM, new java.awt.Font("D\u0069alog", java.awt.Font.BOLD, 12), java.awt
                .Color.red), getBorder()));
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            @Override
            public void
            propertyChange(java.beans.PropertyChangeEvent e) {
                if ("\u0062order".equals(e.getPropertyName())) throw new RuntimeException()
                        ;
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
            table1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    table1MouseClicked(e);
                }
            });
            scrollPane1.setViewportView(table1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(0, 0, 1200, scrollPane1.getPreferredSize().height);

        //---- addBtn ----
        addBtn.setText("Th\u00eam");
        addBtn.addActionListener(e -> addBtnActionPerformed(e));
        add(addBtn);
        addBtn.setBounds(1015, 515, 100, 40);

        //---- editBtn ----
        editBtn.setText("S\u1eeda");
        editBtn.addActionListener(e -> editBtnActionPerformed(e));
        add(editBtn);
        editBtn.setBounds(865, 515, 100, 40);

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
    private JButton addBtn;
    private JButton editBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
