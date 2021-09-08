package DAL;

import DTO.OrderDTO;
import DTO.OrderDetailDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class OrderDetailDAL {
    public Vector<OrderDetailDTO> getAllOrderDetail() {
        Vector<OrderDetailDTO> arr = new Vector<OrderDetailDTO>();
        if (Conn.openConnection()) {
            try {
                String sql = "SELECT * FROM `orderdetail`";
                Statement stmt = Conn.getCon().createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    OrderDetailDTO orderDetail = new OrderDetailDTO();
                    orderDetail.setOrderId(rs.getInt("orderId"));
                    orderDetail.setVegetableId(rs.getInt("vegetableId"));
                    orderDetail.setQuantity(rs.getInt("quantity"));
                    orderDetail.setPrice(rs.getFloat("price"));
                    arr.add(orderDetail);
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                Conn.closeConnection();
            }
        }
        return arr;
    }

    public boolean addOrderDetail(OrderDetailDTO orderDetail) {
        boolean result = false;
        if (Conn.openConnection()) {
            try {
                String sql = "INSERT INTO `orderdetail`(`orderId`, `vegetableId`, `quantity`, `price`) VALUES ( ?, ?, ?, ?)";
                PreparedStatement prstmt = Conn.getCon().prepareStatement(sql);
                prstmt.setInt(1, orderDetail.getOrderId());
                prstmt.setInt(2, orderDetail.getVegetableId());
                prstmt.setInt(3, orderDetail.getQuantity());
                prstmt.setFloat(4, orderDetail.getPrice());
                if (prstmt.executeUpdate() >= 1) {
                    result = true;
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                Conn.closeConnection();
            }
        }
        return result;

    }

    public Vector<OrderDetailDTO> getOrderDetailByOrderId(int orderId) {
        Vector<OrderDetailDTO> arr = new Vector<OrderDetailDTO>();
        if (Conn.openConnection()) {
            try {
                String sql = "SELECT * FROM `orderdetail` WHERE orderId = ?";
                PreparedStatement prstmt = Conn.getCon().prepareStatement(sql);
                prstmt.setInt(1, orderId);
                ResultSet rs = prstmt.executeQuery();
                while (rs.next()) {
                    OrderDetailDTO orderDetail = new OrderDetailDTO();
                    orderDetail.setOrderId(rs.getInt("orderId"));
                    orderDetail.setVegetableId(rs.getInt("vegetableId"));
                    orderDetail.setQuantity(rs.getInt("quantity"));
                    orderDetail.setPrice(rs.getFloat("price"));
                    arr.add(orderDetail);
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                Conn.closeConnection();
            }
        }
        return arr;

    }

}
