package DAL;

import DTO.OrderDTO;
import DTO.UserDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class OrderDAL {
    public Vector<OrderDTO> getAllOrder() {
        Vector<OrderDTO> arr = new Vector<OrderDTO>();
        if (Conn.openConnection()) {
            try {
                String sql = "SELECT * FROM `order`";
                Statement stmt = Conn.getCon().createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    OrderDTO order = new OrderDTO();
                    order.setId(rs.getInt("id"));
                    order.setUserId(rs.getInt("userId"));
                    order.setDate(rs.getString("date"));
                    order.setTotal(rs.getFloat("total"));
                    order.setNote(rs.getString("note"));
                    arr.add(order);
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                Conn.closeConnection();
            }
        }
        return arr;
    }

    public Vector<OrderDTO> getOrdersByUserId(int userId) {
        Vector<OrderDTO> arr = new Vector<OrderDTO>();
        if (Conn.openConnection()) {
            try {
                String sql = "SELECT * FROM `order` WHERE `userId` = ? ";
                PreparedStatement prstmt = Conn.getCon().prepareStatement(sql);
                prstmt.setInt(1, userId);
                ResultSet rs = prstmt.executeQuery();
                while (rs.next()) {
                    OrderDTO order = new OrderDTO();
                    order.setId(rs.getInt("id"));
                    order.setUserId(rs.getInt("userId"));
                    order.setDate(rs.getString("date"));
                    order.setTotal(rs.getFloat("total"));
                    order.setNote(rs.getString("note"));
                    arr.add(order);
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                Conn.closeConnection();
            }
        }
        return arr;
    }

    public boolean addOrder(OrderDTO order) {
        boolean result = false;
        if (Conn.openConnection()) {
            try {
                String sql = "INSERT INTO `order`(`userId`, `date`, `total`, `note`) VALUES ( ?, ?, ?, ?)";
                PreparedStatement prstmt = Conn.getCon().prepareStatement(sql);
                prstmt.setInt(1, order.getUserId());
                prstmt.setString(2, order.getDate());
                prstmt.setFloat(3, order.getTotal());
                prstmt.setString(4, order.getNote());
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

    public OrderDTO getLastOrder() {
        OrderDTO orderDTO = new OrderDTO();
        if (Conn.openConnection()) {
            try {
                String sql = "SELECT * FROM `order` ORDER BY id DESC LIMIT 1;";
                PreparedStatement prstmt = Conn.getCon().prepareStatement(sql);
                ResultSet rs = prstmt.executeQuery();
                while (rs.next()) {
                    orderDTO.setId(rs.getInt("id"));
                    orderDTO.setUserId(rs.getInt("userId"));
                    orderDTO.setDate(rs.getString("date"));
                    orderDTO.setTotal(rs.getFloat("total"));
                    orderDTO.setNote(rs.getString("note"));
                }
                return orderDTO;
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                Conn.closeConnection();
            }

        }
        return null;
    }
}