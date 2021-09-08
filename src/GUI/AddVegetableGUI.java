/*
 * Created by JFormDesigner on Wed Sep 08 20:50:50 ICT 2021
 */

package GUI;

import BLL.CategoryBLL;
import BLL.VegetableBLL;
import DTO.VegetableDTO;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class AddVegetableGUI extends JFrame {
    VegetableBLL vegetableBLL = new VegetableBLL();
    CategoryBLL categoryBLL = new CategoryBLL();

    public AddVegetableGUI() {
        initComponents();
        loadComboBox();
    }

    public void loadComboBox() {
        categoryBLL.getAllCategory().forEach(n -> {
            categoryInput.addItem(n.getName());
        });
    }

    private void confirmBtnActionPerformed(ActionEvent e) {
        try {
            if (nameInput.getText().trim().equals("") || unitInput.getText().trim().equals("") || amountInput.getText().trim().equals("") || priceInput.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Vui long nhập đầy đủ thông tin");
            } else {
                VegetableDTO vegetableDTO = new VegetableDTO();
                vegetableDTO.setName(nameInput.getText().trim().toLowerCase());
                vegetableDTO.setCategoryId(categoryBLL.getCategoryByName(categoryInput.getSelectedItem().toString()).getId());
                vegetableDTO.setUnit(unitInput.getText().trim().toLowerCase());
                vegetableDTO.setAmount(Integer.parseInt(amountInput.getText().trim()));
                vegetableDTO.setPrice(Float.parseFloat(priceInput.getText().trim()));
                JOptionPane.showMessageDialog(this, vegetableBLL.addVegetable(vegetableDTO));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Thông tin không hợp lệ");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        categoryLabel = new JLabel();
        nameLabel = new JLabel();
        amountLabel = new JLabel();
        priceLabel = new JLabel();
        unitLabel = new JLabel();
        nameInput = new JTextField();
        priceInput = new JTextField();
        amountInput = new JTextField();
        unitInput = new JTextField();
        categoryInput = new JComboBox();
        confirmBtn = new JButton();
        label2 = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- categoryLabel ----
        categoryLabel.setText("Th\u01b0 m\u1ee5c");
        contentPane.add(categoryLabel);
        categoryLabel.setBounds(80, 230, 100, 30);

        //---- nameLabel ----
        nameLabel.setText("T\u00ean");
        contentPane.add(nameLabel);
        nameLabel.setBounds(80, 160, 100, 30);

        //---- amountLabel ----
        amountLabel.setText("S\u1ed1 l\u01b0\u1ee3ng");
        contentPane.add(amountLabel);
        amountLabel.setBounds(510, 230, 100, 30);

        //---- priceLabel ----
        priceLabel.setText("Price");
        contentPane.add(priceLabel);
        priceLabel.setBounds(80, 295, 100, 30);

        //---- unitLabel ----
        unitLabel.setText("\u0110\u01a1n v\u1ecb");
        contentPane.add(unitLabel);
        unitLabel.setBounds(510, 160, 100, 30);
        contentPane.add(nameInput);
        nameInput.setBounds(220, 160, 225, 30);
        contentPane.add(priceInput);
        priceInput.setBounds(220, 295, 225, 30);
        contentPane.add(amountInput);
        amountInput.setBounds(645, 230, 230, 30);
        contentPane.add(unitInput);
        unitInput.setBounds(645, 160, 230, 30);
        contentPane.add(categoryInput);
        categoryInput.setBounds(220, 230, 225, 30);

        //---- confirmBtn ----
        confirmBtn.setText("X\u00e1c Nh\u1eadn");
        confirmBtn.addActionListener(e -> confirmBtnActionPerformed(e));
        contentPane.add(confirmBtn);
        confirmBtn.setBounds(800, 385, 100, 40);

        //---- label2 ----
        label2.setText("Th\u00eam s\u1ea3n ph\u1ea9m");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 10f));
        contentPane.add(label2);
        label2.setBounds(80, 50, 795, 40);

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
        setSize(975, 515);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel categoryLabel;
    private JLabel nameLabel;
    private JLabel amountLabel;
    private JLabel priceLabel;
    private JLabel unitLabel;
    private JTextField nameInput;
    private JTextField priceInput;
    private JTextField amountInput;
    private JTextField unitInput;
    private JComboBox categoryInput;
    private JButton confirmBtn;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
