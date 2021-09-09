/*
 * Created by JFormDesigner on Mon Sep 06 16:28:54 ICT 2021
 */

package GUI;

import BLL.StoreUserID;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * @author unknown
 */
public class MainFrameGUI extends JFrame {

    public MainFrameGUI() {
        initComponents();
        if (StoreUserID.getAdmin() != 1) {
            menuBar2.remove(menu2);
        }
        containerPanel.add(new VegetableGUI());
    }

    private void vegetableMenuItemActionPerformed(ActionEvent e) {
        containerPanel.removeAll();
        containerPanel.invalidate();
        containerPanel.add(new VegetableGUI());
        containerPanel.revalidate();
    }

    private void userMenuItemActionPerformed(ActionEvent e) {
        containerPanel.removeAll();
        containerPanel.invalidate();
        containerPanel.add(new UserGUI());
        containerPanel.revalidate();
    }

    private void vegetableMenuItemMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void categoryMenuItemActionPerformed(ActionEvent e) {
        containerPanel.removeAll();
        containerPanel.invalidate();
        containerPanel.add(new CategoryGUI());
        containerPanel.revalidate();
    }

    private void cartBtnActionPerformed(ActionEvent e) {
        containerPanel.removeAll();
        containerPanel.invalidate();
        containerPanel.add(new CartGUI());
        containerPanel.revalidate();
    }

    private void historyMenuItemActionPerformed(ActionEvent e) {
        containerPanel.removeAll();
        containerPanel.invalidate();
        containerPanel.add(new HistoryGUI());
        containerPanel.revalidate();
    }

    private void adminVegetableMenuItemActionPerformed(ActionEvent e) {
        containerPanel.removeAll();
        containerPanel.invalidate();
        containerPanel.add(new AdminVegetableGUI());
        containerPanel.revalidate();
    }

    private void profileMenuItemActionPerformed(ActionEvent e) {
        containerPanel.removeAll();
        containerPanel.invalidate();
        containerPanel.add(new editUser());
        containerPanel.revalidate();
    }

    private void statisticMenuItemActionPerformed(ActionEvent e) {
        containerPanel.removeAll();
        containerPanel.invalidate();
        containerPanel.add(new StatisticGUI());
        containerPanel.revalidate();
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        menuBar2 = new JMenuBar();
        menu1 = new JMenu();
        vegetableMenuItem = new JMenuItem();
        historyMenuItem = new JMenuItem();
        cartBtn = new JMenuItem();
        profileMenuItem = new JMenuItem();
        menu2 = new JMenu();
        userMenuItem = new JMenuItem();
        categoryMenuItem = new JMenuItem();
        adminVegetableMenuItem = new JMenuItem();
        statisticMenuItem = new JMenuItem();
        containerPanel = new JPanel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar2 ========
        {

            //======== menu1 ========
            {
                menu1.setText("user");

                //---- vegetableMenuItem ----
                vegetableMenuItem.setText("C\u1eeda h\u00e0ng");
                vegetableMenuItem.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        vegetableMenuItemMouseClicked(e);
                    }
                });
                vegetableMenuItem.addActionListener(e -> vegetableMenuItemActionPerformed(e));
                menu1.add(vegetableMenuItem);

                //---- historyMenuItem ----
                historyMenuItem.setText("L\u1ecbch s\u1eed");
                historyMenuItem.addActionListener(e -> historyMenuItemActionPerformed(e));
                menu1.add(historyMenuItem);

                //---- cartBtn ----
                cartBtn.setText("Gi\u00f4 h\u00e0ng");
                cartBtn.addActionListener(e -> cartBtnActionPerformed(e));
                menu1.add(cartBtn);

                //---- profileMenuItem ----
                profileMenuItem.setText("Th\u00f4ng tin c\u00e1 nh\u00e2n");
                profileMenuItem.addActionListener(e -> profileMenuItemActionPerformed(e));
                menu1.add(profileMenuItem);
            }
            menuBar2.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("admin");

                //---- userMenuItem ----
                userMenuItem.setText("Ng\u01b0\u1eddi d\u00f9ng");
                userMenuItem.addActionListener(e -> userMenuItemActionPerformed(e));
                menu2.add(userMenuItem);

                //---- categoryMenuItem ----
                categoryMenuItem.setText("Danh muc");
                categoryMenuItem.addActionListener(e -> categoryMenuItemActionPerformed(e));
                menu2.add(categoryMenuItem);

                //---- adminVegetableMenuItem ----
                adminVegetableMenuItem.setText("s\u1ea3n ph\u1ea9m");
                adminVegetableMenuItem.addActionListener(e -> adminVegetableMenuItemActionPerformed(e));
                menu2.add(adminVegetableMenuItem);

                //---- statisticMenuItem ----
                statisticMenuItem.setText("Th\u1ed1ng k\u00ea");
                statisticMenuItem.addActionListener(e -> statisticMenuItemActionPerformed(e));
                menu2.add(statisticMenuItem);
            }
            menuBar2.add(menu2);
        }
        setJMenuBar(menuBar2);

        //======== containerPanel ========
        {
            containerPanel.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(
                    0, 0, 0, 0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder
                    .BOTTOM, new java.awt.Font("Dia\u006cog", java.awt.Font.BOLD, 12), java.awt.Color.
                    red), containerPanel.getBorder()));
            containerPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                @Override
                public void propertyChange(java.
                                                   beans.PropertyChangeEvent e) {
                    if ("\u0062ord\u0065r".equals(e.getPropertyName())) throw new RuntimeException();
                }
            });
            containerPanel.setLayout(new CardLayout());
        }
        contentPane.add(containerPanel);
        containerPanel.setBounds(0, 0, 1200, 635);

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
        setSize(1200, 700);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JMenuBar menuBar2;
    private JMenu menu1;
    private JMenuItem vegetableMenuItem;
    private JMenuItem historyMenuItem;
    private JMenuItem cartBtn;
    private JMenuItem profileMenuItem;
    private JMenu menu2;
    private JMenuItem userMenuItem;
    private JMenuItem categoryMenuItem;
    private JMenuItem adminVegetableMenuItem;
    private JMenuItem statisticMenuItem;
    private JPanel containerPanel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
