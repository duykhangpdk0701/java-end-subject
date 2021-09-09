/*
 * Created by JFormDesigner on Mon Sep 06 20:55:01 ICT 2021
 */

package GUI;

import java.awt.event.*;

import BLL.Cart;
import BLL.CategoryBLL;
import BLL.Helper;
import BLL.VegetableBLL;
import DTO.VegetableDTO;

import java.awt.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author unknown
 */
public class VegetableGUI extends JPanel {
    VegetableBLL vegetableBLL = new VegetableBLL();
    CategoryBLL categoryBLL = new CategoryBLL();

    public VegetableGUI() {
        initComponents();
        loadVegetable();
    }

    public void loadVegetable() {
        DefaultTableModel dtm = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dtm.addColumn("id");
        dtm.addColumn("category");
        dtm.addColumn("name");
        dtm.addColumn("unit");
        dtm.addColumn("amount");
        dtm.addColumn("price");
        table1.setModel(dtm);
        Vector<VegetableDTO> vegetableDTOS = new Vector<VegetableDTO>();
        vegetableDTOS = vegetableBLL.getAllVegetable();
        vegetableDTOS.forEach(n -> {
            int id = n.getId();
            String category = categoryBLL.getCategoryById(n.getCategoryId()).getName();
            String name = n.getName();
            String unit = n.getUnit();
            int amount = n.getAmount();
            float price = n.getPrice();
            Object[] arr = {id, category, name, unit, amount, price};
            dtm.addRow(arr);
        });
    }

    private void addToCardBtnActionPerformed(ActionEvent e) {
        DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
        int value = Integer.parseInt(dtm.getValueAt(table1.getSelectedRow(), 0).toString());
        int amount = Integer.parseInt(dtm.getValueAt(table1.getSelectedRow(), 4).toString());
        if (amount == 0) {
            JOptionPane.showMessageDialog(this, "sản phẩm đã hết hàng");
            return;
        }
        try {

            JOptionPane.showMessageDialog(this, Cart.addItem(value));
        } catch (HeadlessException headlessException) {
            JOptionPane.showMessageDialog(this, "thêm vào gió hàng không thành công");
        }
    }

    private void table1MouseClicked(MouseEvent e) {
    }

    private void searchInputKeyReleased(KeyEvent e) {
        Helper.filterTable(table1, searchInput);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        addToCardBtn = new JButton();
        searchLabel = new JLabel();
        searchInput = new JTextField();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder
        ( 0, 0, 0, 0) , "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e", javax. swing. border. TitledBorder. CENTER, javax. swing. border
        . TitledBorder. BOTTOM, new java .awt .Font ("D\u0069al\u006fg" ,java .awt .Font .BOLD ,12 ), java. awt
        . Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void
        propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062or\u0064er" .equals (e .getPropertyName () )) throw new RuntimeException( )
        ; }} );
        setLayout(null);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                },
                new String[] {
                    null, null, null, null, null, null, null
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

        //---- addToCardBtn ----
        addToCardBtn.setText("Th\u00eam v\u00e0o gi\u1ecf h\u00e0ng");
        addToCardBtn.addActionListener(e -> addToCardBtnActionPerformed(e));
        add(addToCardBtn);
        addToCardBtn.setBounds(935, 545, 200, 40);

        //---- searchLabel ----
        searchLabel.setText("T\u00ccm ki\u1ebfm (T\u00ean):");
        add(searchLabel);
        searchLabel.setBounds(835, 460, 100, 30);

        //---- searchInput ----
        searchInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                searchInputKeyReleased(e);
            }
        });
        add(searchInput);
        searchInput.setBounds(935, 460, 200, 30);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < getComponentCount(); i++) {
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
    private JButton addToCardBtn;
    private JLabel searchLabel;
    private JTextField searchInput;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
