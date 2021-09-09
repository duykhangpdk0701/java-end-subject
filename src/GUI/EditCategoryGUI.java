/*
 * Created by JFormDesigner on Thu Sep 09 09:57:16 ICT 2021
 */

package GUI;

import BLL.CategoryBLL;
import DTO.CategoryDTO;

import java.awt.*;
import java.awt.event.*;
import java.util.Locale;
import javax.swing.*;

/**
 * @author unknown
 */
public class EditCategoryGUI extends JFrame {
    CategoryBLL categoryBLL = new CategoryBLL();
    String nameBeforeEdit;
    String nameAfterEdit;
    int idCategory;

    public EditCategoryGUI(int id) {
        initComponents();
        loadCategory(id);
        idCategory = id;
    }

    public void loadCategory(int id) {
        CategoryDTO categoryDTO = categoryBLL.getCategoryById(id);
        nameInput.setText(categoryDTO.getName());
        descriptionInput.setText(categoryDTO.getDescription());
        nameBeforeEdit = nameInput.getText().trim().toLowerCase();
    }


    private void confirmBtnActionPerformed(ActionEvent e) {
        nameAfterEdit = nameInput.getText().trim().toLowerCase();
        if (nameInput.getText().trim().equals("") || descriptionInput.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
        } else {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setId(idCategory);
            categoryDTO.setName(nameInput.getText().trim().toLowerCase());
            categoryDTO.setDescription(descriptionInput.getText().trim());

            JOptionPane.showMessageDialog(this, categoryBLL.editCategory(nameBeforeEdit, nameAfterEdit, categoryDTO));
        }
    }

    private void confimBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        nameLabel = new JLabel();
        descriptionLabel = new JLabel();
        nameInput = new JTextField();
        descriptionInput = new JTextField();
        confirmBtn = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("S\u1eeda m\u1ee5c");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 10f));
        contentPane.add(label1);
        label1.setBounds(105, 65, 375, 40);

        //---- nameLabel ----
        nameLabel.setText("Name:");
        contentPane.add(nameLabel);
        nameLabel.setBounds(95, 145, 80, 30);

        //---- descriptionLabel ----
        descriptionLabel.setText("Description:");
        contentPane.add(descriptionLabel);
        descriptionLabel.setBounds(95, 225, 80, 30);
        contentPane.add(nameInput);
        nameInput.setBounds(185, 145, 295, 30);
        contentPane.add(descriptionInput);
        descriptionInput.setBounds(185, 225, 295, 30);

        //---- confirmBtn ----
        confirmBtn.setText("X\u00e1c nh\u1eadn");
        confirmBtn.addActionListener(e -> {
            confimBtnActionPerformed(e);
            confirmBtnActionPerformed(e);
        });
        contentPane.add(confirmBtn);
        confirmBtn.setBounds(445, 305, 100, 40);

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
        setSize(595, 415);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JLabel nameLabel;
    private JLabel descriptionLabel;
    private JTextField nameInput;
    private JTextField descriptionInput;
    private JButton confirmBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
