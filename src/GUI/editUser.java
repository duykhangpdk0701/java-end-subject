/*
 * Created by JFormDesigner on Thu Sep 09 19:52:20 ICT 2021
 */

package GUI;

import BLL.StoreUserID;
import BLL.UserBLL;
import DTO.UserDTO;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class editUser extends JPanel {
    UserBLL userBLL = new UserBLL();
    String usernameBefore;
    String usernameAfter;

    public editUser() {
        initComponents();
        loadEditUser();
    }

    public void loadEditUser() {
        nameInput.setText(StoreUserID.getUsername());
        usernameInput.setText(StoreUserID.getFullname());
        passwordInput.setText(StoreUserID.getPassword());
        phoneNumberInput.setText(StoreUserID.getPhoneNumber());
        usernameBefore = usernameInput.getText().trim().toLowerCase();
    }

    private void confirmBtnActionPerformed(ActionEvent e) {
        if (nameInput.getText().trim().toLowerCase().equals("")
                || usernameInput.getText().trim().toLowerCase().equals("")
                || passwordInput.getText().trim().toLowerCase().equals("")
                || phoneNumberInput.getText().trim().toLowerCase().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
        } else {
            usernameAfter = usernameInput.getText().trim().toLowerCase();
            UserDTO userDTO = new UserDTO();
            userDTO.setId(StoreUserID.getId());
            userDTO.setFullname(nameInput.getText().trim());
            userDTO.setUsername(usernameInput.getText().trim());
            userDTO.setPassword(passwordInput.getText().trim());
            userDTO.setPhoneNumber(phoneNumberInput.getText());
            userDTO.setAdmin(StoreUserID.getAdmin());
            JOptionPane.showMessageDialog(this, userBLL.editUser(usernameBefore, usernameAfter, userDTO));
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        nameLabel = new JLabel();
        phoneNumberLabel = new JLabel();
        usernameLabel = new JLabel();
        passwordLabel = new JLabel();
        nameInput = new JTextField();
        phoneNumberInput = new JTextField();
        usernameInput = new JTextField();
        passwordInput = new JTextField();
        confirmBtn = new JButton();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder
                (0, 0, 0, 0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax.swing.border.TitledBorder.CENTER, javax.swing.border
                .TitledBorder.BOTTOM, new java.awt.Font("Dia\u006cog", java.awt.Font.BOLD, 12), java.awt
                .Color.red), getBorder()));
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            @Override
            public void
            propertyChange(java.beans.PropertyChangeEvent e) {
                if ("\u0062ord\u0065r".equals(e.getPropertyName())) throw new RuntimeException()
                        ;
            }
        });
        setLayout(null);

        //---- label1 ----
        label1.setText("S\u1eeda th\u00f4ng tin");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 10f));
        add(label1);
        label1.setBounds(410, 60, 375, 100);

        //---- nameLabel ----
        nameLabel.setText("T\u00ean");
        add(nameLabel);
        nameLabel.setBounds(200, 190, 80, 30);

        //---- phoneNumberLabel ----
        phoneNumberLabel.setText("S\u0111t");
        add(phoneNumberLabel);
        phoneNumberLabel.setBounds(200, 300, 80, 30);

        //---- usernameLabel ----
        usernameLabel.setText("Username");
        add(usernameLabel);
        usernameLabel.setBounds(650, 190, 80, 30);

        //---- passwordLabel ----
        passwordLabel.setText("Password");
        add(passwordLabel);
        passwordLabel.setBounds(650, 300, 80, 30);
        add(nameInput);
        nameInput.setBounds(280, 190, 200, 30);
        add(phoneNumberInput);
        phoneNumberInput.setBounds(280, 300, 200, 30);
        add(usernameInput);
        usernameInput.setBounds(730, 190, 200, 30);
        add(passwordInput);
        passwordInput.setBounds(730, 300, 200, 30);

        //---- confirmBtn ----
        confirmBtn.setText("X\u00e1c Nh\u1eadn");
        confirmBtn.addActionListener(e -> confirmBtnActionPerformed(e));
        add(confirmBtn);
        confirmBtn.setBounds(1040, 545, 100, 40);

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
    private JLabel label1;
    private JLabel nameLabel;
    private JLabel phoneNumberLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField nameInput;
    private JTextField phoneNumberInput;
    private JTextField usernameInput;
    private JTextField passwordInput;
    private JButton confirmBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
