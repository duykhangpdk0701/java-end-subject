/*
 * Created by JFormDesigner on Sun Sep 05 21:56:34 ICT 2021
 */

package GUI;

import BLL.UserBLL;
import DTO.UserDTO;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class RegisterGUI extends JFrame {
    UserBLL userBLL = new UserBLL();

    public RegisterGUI() {
        initComponents();
    }


    private void backToLoginBtnActionPerformed(ActionEvent e) {
        this.dispose();
        LoginGUI loginGUI = new LoginGUI();
        loginGUI.setVisible(true);
    }

    private void registerBtnActionPerformed(ActionEvent e) {
        try {
            if (fullnameInput.getText().trim().equals("") || usernameInput.getText().trim().equals("") || passwordInput.getText().trim().equals("") || phoneInput.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin");
            } else {
                UserDTO userDTO = new UserDTO();
                userDTO.setFullname(fullnameInput.getText());
                userDTO.setUsername(usernameInput.getText().trim());
                userDTO.setPassword(passwordInput.getText().trim());
                userDTO.setPhoneNumber(phoneInput.getText().trim());
                JOptionPane.showMessageDialog(this, userBLL.addUser(userDTO));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Thông tin không hợp lệ");
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        fullnameLabel = new JLabel();
        usernameLabel = new JLabel();
        passwordLabel = new JLabel();
        phoneNumberLabel = new JLabel();
        passwordInput = new JTextField();
        phoneInput = new JTextField();
        usernameInput = new JTextField();
        fullnameInput = new JTextField();
        label1 = new JLabel();
        backToLoginBtn = new JButton();
        registerBtn = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- fullnameLabel ----
        fullnameLabel.setText("H\u1ecd v\u00e0 t\u00ean");
        contentPane.add(fullnameLabel);
        fullnameLabel.setBounds(65, 220, 100, 25);

        //---- usernameLabel ----
        usernameLabel.setText("Username");
        contentPane.add(usernameLabel);
        usernameLabel.setBounds(65, 280, 100, 25);

        //---- passwordLabel ----
        passwordLabel.setText("Password");
        contentPane.add(passwordLabel);
        passwordLabel.setBounds(65, 340, 100, 25);

        //---- phoneNumberLabel ----
        phoneNumberLabel.setText("S\u0111t");
        contentPane.add(phoneNumberLabel);
        phoneNumberLabel.setBounds(65, 405, 100, 25);
        contentPane.add(passwordInput);
        passwordInput.setBounds(195, 340, 200, 25);
        contentPane.add(phoneInput);
        phoneInput.setBounds(195, 405, 200, 25);
        contentPane.add(usernameInput);
        usernameInput.setBounds(195, 280, 200, 25);
        contentPane.add(fullnameInput);
        fullnameInput.setBounds(195, 220, 200, 25);

        //---- label1 ----
        label1.setText("\u0110\u0103ng k\u00fd");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 10f));
        contentPane.add(label1);
        label1.setBounds(65, 75, 335, 45);

        //---- backToLoginBtn ----
        backToLoginBtn.setText("Tr\u1edf v\u1ec1 \u0111\u0103ng nh\u1eadp");
        backToLoginBtn.addActionListener(e -> backToLoginBtnActionPerformed(e));
        contentPane.add(backToLoginBtn);
        backToLoginBtn.setBounds(60, 485, 145, 40);

        //---- registerBtn ----
        registerBtn.setText("\u0110\u0103ng k\u00fd");
        registerBtn.addActionListener(e -> registerBtnActionPerformed(e));
        contentPane.add(registerBtn);
        registerBtn.setBounds(250, 485, 145, 40);

        contentPane.setPreferredSize(new Dimension(470, 705));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel fullnameLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel phoneNumberLabel;
    private JTextField passwordInput;
    private JTextField phoneInput;
    private JTextField usernameInput;
    private JTextField fullnameInput;
    private JLabel label1;
    private JButton backToLoginBtn;
    private JButton registerBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
