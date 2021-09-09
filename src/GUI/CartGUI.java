/*
 * Created by JFormDesigner on Wed Sep 08 10:44:40 ICT 2021
 */

package GUI;

import BLL.*;
import DTO.CartDTO;
import DTO.OrderDTO;
import DTO.OrderDetailDTO;
import DTO.VegetableDTO;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author unknown
 */
public class CartGUI extends JPanel {
    VegetableBLL vegetableBLL = new VegetableBLL();
    CategoryBLL categoryBLL = new CategoryBLL();
    OrderBLL orderBLL = new OrderBLL();
    OrderDetailBLL orderDetailBLL = new OrderDetailBLL();
    float totalAll = 0;

    public CartGUI() {
        initComponents();
        loadCart();
    }

    public void loadCart() {

        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("name");
        dtm.addColumn("category");
        dtm.addColumn("unit");
        dtm.addColumn("amount");
        dtm.addColumn("price");
        dtm.addColumn("total");
        table1.setModel(dtm);

        Cart.getArr().forEach(n -> {
            VegetableDTO item = vegetableBLL.findVegetableById(n.getValue());
            String name = item.getName();
            int categoryId = item.getCategoryId();
            String unit = item.getUnit();
            int amount = n.getOccur();
            float price = item.getPrice();
            float total = price * amount;
            totalAll += total;
            Object[] arr = {name, categoryId, unit, amount, price, total};
            dtm.addRow(arr);
        });
        totalValue.setText(String.valueOf(totalAll));
    }

    private void table1MouseClicked(MouseEvent e) {
        // TODO add your code here
    }


    public String purchase(OrderDTO orderDTO, Vector<CartDTO> cartDTOS) {
        orderBLL.addOrder(orderDTO);
        int lastIdOrder = orderBLL.getLastOrder().getId();
        cartDTOS.forEach(n -> {
            OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
            orderDetailDTO.setOrderId(lastIdOrder);
            orderDetailDTO.setVegetableId(n.getValue());
            orderDetailDTO.setQuantity(n.getOccur());
            orderDetailDTO.setPrice(vegetableBLL.findVegetableById(n.getValue()).getPrice());
            orderDetailBLL.addOrderDetail(orderDetailDTO);
        });
        return "mua thanh cong";
    }

    private void orderBtnActionPerformed(ActionEvent e) {
        if (Cart.getArr().size() == 0) {
            JOptionPane.showMessageDialog(this, "vui lòng thêm sản phẩm vào giỏ hàng");
            return;
        }
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setUserId(StoreUserID.getId());
        orderDTO.setDate(Helper.getCurrentDate());
        orderDTO.setTotal(Float.parseFloat(totalValue.getText()));
        JOptionPane.showMessageDialog(this, purchase(orderDTO, Cart.getArr()));
        Cart.setArr(new Vector<CartDTO>());
        loadCart();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        orderBtn = new JButton();
        totalLabel = new JLabel();
        totalValue = new JLabel();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.
        border.EmptyBorder(0,0,0,0), "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e",javax.swing.border.TitledBorder.CENTER
        ,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dialo\u0067",java.awt.Font
        .BOLD,12),java.awt.Color.red), getBorder())); addPropertyChangeListener(
        new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("borde\u0072"
        .equals(e.getPropertyName()))throw new RuntimeException();}});
        setLayout(null);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                },
                new String[] {
                    null, null, null, null, null, null
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

        //---- orderBtn ----
        orderBtn.setText("order");
        orderBtn.addActionListener(e -> orderBtnActionPerformed(e));
        add(orderBtn);
        orderBtn.setBounds(945, 505, 155, 40);

        //---- totalLabel ----
        totalLabel.setText("T\u1ed5ng :");
        add(totalLabel);
        totalLabel.setBounds(970, 470, 50, totalLabel.getPreferredSize().height);

        //---- totalValue ----
        totalValue.setText("0");
        add(totalValue);
        totalValue.setBounds(1025, 470, 150, totalValue.getPreferredSize().height);

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
    private JButton orderBtn;
    private JLabel totalLabel;
    private JLabel totalValue;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
