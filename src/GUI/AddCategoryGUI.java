/*
 * Created by JFormDesigner on Wed Sep 08 20:01:44 ICT 2021
 */

package GUI;

import BLL.CategoryBLL;
import DTO.CategoryDTO;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class AddCategoryGUI extends JFrame {
    CategoryBLL categoryBLL = new CategoryBLL();

    public AddCategoryGUI() {
        initComponents();
    }

    private void confirmBtnActionPerformed(ActionEvent e) {
        try {
            String nameValue = nameInput.getText().trim().toLowerCase();
            String descriptionValue = descriptionInput.getText().trim();
            if (nameValue.equals("") || descriptionValue.equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin");
            } else {
                CategoryDTO categoryDTO = new CategoryDTO();
                categoryDTO.setName(nameValue);
                categoryDTO.setDescription(descriptionValue);
                JOptionPane.showMessageDialog(this, categoryBLL.addCategory(categoryDTO));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Thông tin không hợp lệ");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        nameLabel = new JLabel();
        descriptionLabel = new JLabel();
        label3 = new JLabel();
        nameInput = new JTextField();
        descriptionInput = new JTextField();
        confirmBtn = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- nameLabel ----
        nameLabel.setText("Name:");
        contentPane.add(nameLabel);
        nameLabel.setBounds(105, 125, 85, 30);

        //---- descriptionLabel ----
        descriptionLabel.setText("description:");
        contentPane.add(descriptionLabel);
        descriptionLabel.setBounds(105, 190, 85, 30);

        //---- label3 ----
        label3.setText("Th\u00eam m\u1ee5c ");
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 10f));
        contentPane.add(label3);
        label3.setBounds(105, 60, 345, 30);
        contentPane.add(nameInput);
        nameInput.setBounds(200, 125, 250, 30);
        contentPane.add(descriptionInput);
        descriptionInput.setBounds(200, 190, 250, 30);

        //---- confirmBtn ----
        confirmBtn.setText("X\u00e1c Nh\u1eadn");
        confirmBtn.addActionListener(e -> confirmBtnActionPerformed(e));
        contentPane.add(confirmBtn);
        confirmBtn.setBounds(400, 265, 105, confirmBtn.getPreferredSize().height);

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
        setSize(560, 365);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel nameLabel;
    private JLabel descriptionLabel;
    private JLabel label3;
    private JTextField nameInput;
    private JTextField descriptionInput;
    private JButton confirmBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
