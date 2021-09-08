/*
 * Created by JFormDesigner on Mon Sep 06 21:08:11 ICT 2021
 */

package GUI;

import BLL.UserBLL;
import DTO.UserDTO;

import java.awt.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author unknown
 */
public class UserGUI extends JPanel {
    UserBLL userBLL = new UserBLL();
    DefaultTableModel dtm = new DefaultTableModel();

    public UserGUI() {
        initComponents();
        loadUser();
    }

    public void loadUser() {
        dtm.addColumn("id");
        dtm.addColumn("fullname");
        dtm.addColumn("username");
        dtm.addColumn("password");
        dtm.addColumn("phone number");
        dtm.addColumn("admin");
        table1.setModel(dtm);
        Vector<UserDTO> userDTOS = new Vector<UserDTO>();
        userDTOS = userBLL.getAllUsers();
        for (int i = 0; i < userDTOS.size(); i++) {
            UserDTO userDTO = userDTOS.get(i);
            int id = userDTO.getId();
            String fullname = userDTO.getFullname();
            String username = userDTO.getUsername();
            String password = userDTO.getPassword();
            String phoneNumber = userDTO.getPhoneNumber();
            int admin = userDTO.getAdmin();
            Object[] row = {id, fullname, username, password, phoneNumber, admin};
            dtm.addRow(row);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(
                0, 0, 0, 0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder
                .BOTTOM, new java.awt.Font("Dia\u006cog", java.awt.Font.BOLD, 12), java.awt.Color.
                red), getBorder()));
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            @Override
            public void propertyChange(java.
                                               beans.PropertyChangeEvent e) {
                if ("bord\u0065r".equals(e.getPropertyName())) throw new RuntimeException();
            }
        });
        setLayout(null);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                    new Object[][]{
                            {null, null, null, null, null, null, null},
                            {null, null, null, null, null, null, null},
                    },
                    new String[]{
                            null, null, null, null, null, null, null
                    }
            ));
            scrollPane1.setViewportView(table1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(0, 0, 1200, scrollPane1.getPreferredSize().height);

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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
