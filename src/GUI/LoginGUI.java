/*
 * Created by JFormDesigner on Sun Sep 05 17:13:08 ICT 2021
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
public class LoginGUI extends JFrame {
    public LoginGUI() {
        initComponents();
    }

    private void loginBtnActionPerformed(ActionEvent e) {
        if (usernameInput.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập ô username");
            return;
        }
        if (passwordInput.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập ô password");
            return;
        }
        //check login
        UserBLL userBLL = new UserBLL();
        if (userBLL.hasUser(usernameInput.getText().trim(), passwordInput.getText().trim())) {
            UserDTO user = userBLL.findUserByUsername(usernameInput.getText().trim());
            StoreUserID.setId(user.getId());
            StoreUserID.setFullname(user.getFullname());
            StoreUserID.setUsername(user.getUsername());
            StoreUserID.setPassword(user.getPassword());
            StoreUserID.setPhoneNumber(user.getPhoneNumber());
            System.out.println(StoreUserID.getFullname());
            JOptionPane.showMessageDialog(this, "đăng nhập thành công");
            MainFrameGUI mainFrameGUI = new MainFrameGUI();
            mainFrameGUI.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "sai tài khoản hoặc mật khẩu");
        }

    }

    private void registerBtnActionPerformed(ActionEvent e) {
        this.dispose();
        RegisterGUI registerGUI = new RegisterGUI();
        registerGUI.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        usernameInput = new JTextField();
        usernameLabel = new JLabel();
        passwordLabel = new JLabel();
        loginBtn = new JButton();
        registerBtn = new JButton();
        passwordInput = new JPasswordField();
        label3 = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.add(usernameInput);
        usernameInput.setBounds(260, 155, 250, 30);

        //---- usernameLabel ----
        usernameLabel.setText("Username");
        usernameLabel.setLabelFor(usernameInput);
        contentPane.add(usernameLabel);
        usernameLabel.setBounds(165, 155, 100, 30);

        //---- passwordLabel ----
        passwordLabel.setText("Password");
        passwordLabel.setLabelFor(passwordInput);
        contentPane.add(passwordLabel);
        passwordLabel.setBounds(165, 205, 100, 25);

        //---- loginBtn ----
        loginBtn.setText("Login");
        loginBtn.addActionListener(e -> loginBtnActionPerformed(e));
        contentPane.add(loginBtn);
        loginBtn.setBounds(160, 285, 155, 30);

        //---- registerBtn ----
        registerBtn.setText("Register");
        registerBtn.addActionListener(e -> registerBtnActionPerformed(e));
        contentPane.add(registerBtn);
        registerBtn.setBounds(350, 285, 160, 30);
        contentPane.add(passwordInput);
        passwordInput.setBounds(260, 205, 250, 30);

        //---- label3 ----
        label3.setText("\u0110\u0103ng nh\u1eadp");
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 10f));
        contentPane.add(label3);
        label3.setBounds(165, 90, 345, 40);

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
        setSize(720, 460);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JTextField usernameInput;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JButton loginBtn;
    private JButton registerBtn;
    private JPasswordField passwordInput;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
