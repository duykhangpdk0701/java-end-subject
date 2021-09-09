/*
 * Created by JFormDesigner on Mon Sep 06 21:40:02 ICT 2021
 */

package GUI;

import java.awt.event.*;

import BLL.CategoryBLL;
import BLL.Helper;
import DTO.CategoryDTO;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Vector;
import javax.print.attribute.standard.JobSheets;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
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
        addCategoryGUI.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                loadCategory();
            }
        });
    }

    private void editBtnActionPerformed(ActionEvent e) {
        DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
        int value = Integer.parseInt(dtm.getValueAt(table1.getSelectedRow(), 0).toString());
        EditCategoryGUI editCategoryGUI = new EditCategoryGUI(value);
        editCategoryGUI.setVisible(true);
        editCategoryGUI.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                loadCategory();
            }
        });
    }

    private void orderBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void exportExelActionPerformed(ActionEvent e) {
        Helper.exportFileExcel(table1, this);
    }

    private void printBtnActionPerformed(ActionEvent e) {
        Helper.print(table1, "Category");
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        addBtn = new JButton();
        editBtn = new JButton();
        exportExel = new JButton();
        printBtn = new JButton();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder
                (0, 0, 0, 0), "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e", javax.swing.border.TitledBorder.CENTER, javax.swing.border
                .TitledBorder.BOTTOM, new java.awt.Font("D\u0069al\u006fg", java.awt.Font.BOLD, 12), java.awt
                .Color.red), getBorder()));
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            @Override
            public void
            propertyChange(java.beans.PropertyChangeEvent e) {
                if ("\u0062or\u0064er".equals(e.getPropertyName())) throw new RuntimeException()
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

        //---- exportExel ----
        exportExel.setText("Xu\u1ea5t file");
        exportExel.addActionListener(e -> {
            orderBtnActionPerformed(e);
            exportExelActionPerformed(e);
        });
        add(exportExel);
        exportExel.setBounds(715, 515, 100, 40);

        //---- printBtn ----
        printBtn.setText("In");
        printBtn.addActionListener(e -> printBtnActionPerformed(e));
        add(printBtn);
        printBtn.setBounds(555, 520, 100, 35);

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
    private JButton exportExel;
    private JButton printBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
