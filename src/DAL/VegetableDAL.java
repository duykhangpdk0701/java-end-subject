package DAL;

import DTO.UserDTO;
import DTO.VegetableDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class VegetableDAL {
    public Vector<VegetableDTO> getAllVegetables() {
        Vector<VegetableDTO> arr = new Vector<VegetableDTO>();
        if (Conn.openConnection()) {
            try {
                String sql = "SELECT * FROM vegetable";
                Statement stmt = Conn.getCon().createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    VegetableDTO vegetableDTO = new VegetableDTO();
                    vegetableDTO.setId(rs.getInt("id"));
                    vegetableDTO.setCategoryId(rs.getInt("categoryId"));
                    vegetableDTO.setName(rs.getString("name"));
                    vegetableDTO.setUnit(rs.getString("unit"));
                    vegetableDTO.setAmount(rs.getInt("amount"));
                    vegetableDTO.setPrice(rs.getInt("price"));
                    arr.add(vegetableDTO);
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                Conn.closeConnection();
            }
        }
        return arr;
    }

    public boolean addVegetable(VegetableDTO vegetable) {
        boolean result = false;
        if (Conn.openConnection()) {
            try {
                String sql = "INSERT INTO `vegetable`(`categoryId`, `name`, `unit`, `amount`, `price`) VALUES (?,?,?,?,?)";
                PreparedStatement prstmt = Conn.getCon().prepareStatement(sql);
                prstmt.setInt(1, vegetable.getCategoryId());
                prstmt.setString(2, vegetable.getName());
                prstmt.setString(3, vegetable.getUnit());
                prstmt.setInt(4, vegetable.getAmount());
                prstmt.setFloat(5, vegetable.getPrice());
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

    public boolean hasVegetableId(int id) {
        boolean result = false;
        if (Conn.openConnection()) {
            try {
                String sql = "SELECT * FROM vegetable WHERE id = ?";
                PreparedStatement prstmt = Conn.getCon().prepareStatement(sql);
                prstmt.setInt(1, id);
                ResultSet rs = prstmt.executeQuery();
                result = rs.next();
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                Conn.closeConnection();
            }
        }
        return result;
    }

    public boolean hasVegetableName(String vegetableName) {
        boolean result = false;
        if (Conn.openConnection()) {
            try {
                String sql = "SELECT * FROM `vegetable` WHERE `name` = ?";
                PreparedStatement prstmt = Conn.getCon().prepareStatement(sql);
                prstmt.setString(1, vegetableName);
                ResultSet rs = prstmt.executeQuery();
                result = rs.next();
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                Conn.closeConnection();
            }

        }
        return result;
    }

    public VegetableDTO findVegetableName(String name) {
        VegetableDTO vegetableDTO = new VegetableDTO();
        if (Conn.openConnection()) {
            try {
                String sql = "SELECT * FROM `vegetable` WHERE `name` = ?";
                PreparedStatement prstmt = Conn.getCon().prepareStatement(sql);
                prstmt.setString(1, name);
                ResultSet rs = prstmt.executeQuery();
                while (rs.next()) {
                    vegetableDTO.setId(rs.getInt("id"));
                    vegetableDTO.setCategoryId(rs.getInt("categoryId"));
                    vegetableDTO.setName(rs.getString("name"));
                    vegetableDTO.setUnit(rs.getString("unit"));
                    vegetableDTO.setAmount(rs.getInt("amount"));
                    vegetableDTO.setPrice(rs.getFloat("price"));
                }
                return vegetableDTO;
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                Conn.closeConnection();
            }

        }
        return null;
    }

    public VegetableDTO findVegetableID(int id) {
        VegetableDTO vegetableDTO = new VegetableDTO();
        if (Conn.openConnection()) {
            try {
                String sql = "SELECT * FROM `vegetable` WHERE `id` = ?";
                PreparedStatement prstmt = Conn.getCon().prepareStatement(sql);
                prstmt.setInt(1, id);
                ResultSet rs = prstmt.executeQuery();
                while (rs.next()) {
                    vegetableDTO.setId(rs.getInt("id"));
                    vegetableDTO.setCategoryId(rs.getInt("categoryId"));
                    vegetableDTO.setName(rs.getString("name"));
                    vegetableDTO.setUnit(rs.getString("unit"));
                    vegetableDTO.setAmount(rs.getInt("amount"));
                    vegetableDTO.setPrice(rs.getFloat("price"));
                }
                return vegetableDTO;
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                Conn.closeConnection();
            }

        }
        return null;
    }


}
