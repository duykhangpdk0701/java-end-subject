/*
 * Created by JFormDesigner on Thu Sep 09 10:52:57 ICT 2021
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
public class EditVegetableGUI extends JFrame {
    VegetableBLL vegetableBLL = new VegetableBLL();
    CategoryBLL categoryBLL = new CategoryBLL();
    int id;
    String nameBeforeEdit;
    String nameAfterEdit;

    public EditVegetableGUI(int vegetableId) {
        initComponents();
        loadEditVegetable(vegetableId);
        id = vegetableId;

    }

    public void loadEditVegetable(int vegetableId) {
        categoryBLL.getAllCategory().forEach(n -> {
            categoryInput.addItem(n.getName());
        });

        VegetableDTO vegetableDTO = vegetableBLL.findVegetableById(vegetableId);
        categoryInput.setSelectedIndex((vegetableDTO.getCategoryId() - 1));
        nameInput.setText(vegetableDTO.getName().trim().toLowerCase());
        unitInput.setText(vegetableDTO.getUnit().trim().toLowerCase());
        amountInput.setText(String.valueOf(vegetableDTO.getAmount()));
        priceInput.setText(String.valueOf(vegetableDTO.getPrice()));
        nameBeforeEdit = nameInput.getText().trim().toLowerCase();
    }


    private void confirmBtnActionPerformed(ActionEvent e) {
        try {
            if (nameInput.getText().trim().equals("") || unitInput.getText().trim().equals("") || amountInput.getText().trim().equals("") || priceInput.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
            } else {
                nameAfterEdit = nameInput.getText().trim().toLowerCase();
                VegetableDTO vegetableDTO = new VegetableDTO();
                vegetableDTO.setId(id);
                vegetableDTO.setName(nameInput.getText().trim().toLowerCase());
                vegetableDTO.setCategoryId(categoryBLL.getCategoryByName(categoryInput.getSelectedItem().toString()).getId());
                vegetableDTO.setUnit(unitInput.getText().trim().toLowerCase());
                vegetableDTO.setAmount(Integer.parseInt(amountInput.getText().trim()));
                vegetableDTO.setPrice(Float.parseFloat(priceInput.getText().trim()));
                JOptionPane.showMessageDialog(this, vegetableBLL.editVegetable(nameBeforeEdit, nameAfterEdit, vegetableDTO));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Thông tin không hợp lệ");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        categorylabel = new JLabel();
        nameLabel = new JLabel();
        unitLabel = new JLabel();
        amountLabel = new JLabel();
        priceLabel = new JLabel();
        nameInput = new JTextField();
        priceInput = new JTextField();
        amountInput = new JTextField();
        unitInput = new JTextField();
        categoryInput = new JComboBox();
        confirmBtn = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("S\u1eeda s\u1ea3n ph\u1ea9m");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 10f));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(110, 90, 750, 35);

        //---- categorylabel ----
        categorylabel.setText("Category");
        contentPane.add(categorylabel);
        categorylabel.setBounds(105, 190, 100, 30);

        //---- nameLabel ----
        nameLabel.setText("name");
        contentPane.add(nameLabel);
        nameLabel.setBounds(105, 275, 100, 30);

        //---- unitLabel ----
        unitLabel.setText("Unit");
        contentPane.add(unitLabel);
        unitLabel.setBounds(105, 360, 100, 30);

        //---- amountLabel ----
        amountLabel.setText("amount");
        contentPane.add(amountLabel);
        amountLabel.setBounds(560, 195, 100, 30);

        //---- priceLabel ----
        priceLabel.setText("price");
        contentPane.add(priceLabel);
        priceLabel.setBounds(560, 275, 100, 30);
        contentPane.add(nameInput);
        nameInput.setBounds(205, 275, 200, 30);
        contentPane.add(priceInput);
        priceInput.setBounds(660, 275, 200, 30);
        contentPane.add(amountInput);
        amountInput.setBounds(660, 195, 200, 30);
        contentPane.add(unitInput);
        unitInput.setBounds(205, 360, 200, 30);
        contentPane.add(categoryInput);
        categoryInput.setBounds(205, 190, 200, 30);

        //---- confirmBtn ----
        confirmBtn.setText("Ch\u1ea5p nh\u1eadn");
        confirmBtn.addActionListener(e -> confirmBtnActionPerformed(e));
        contentPane.add(confirmBtn);
        confirmBtn.setBounds(795, 450, 100, 40);

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
        setSize(970, 575);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JLabel categorylabel;
    private JLabel nameLabel;
    private JLabel unitLabel;
    private JLabel amountLabel;
    private JLabel priceLabel;
    private JTextField nameInput;
    private JTextField priceInput;
    private JTextField amountInput;
    private JTextField unitInput;
    private JComboBox categoryInput;
    private JButton confirmBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
