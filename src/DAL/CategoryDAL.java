package DAL;

import DTO.CategoryDTO;
import DTO.UserDTO;
import DTO.VegetableDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class CategoryDAL {
    public Vector<CategoryDTO> getAllCategory() {
        Vector<CategoryDTO> arr = new Vector<CategoryDTO>();
        if (Conn.openConnection()) {
            try {
                String sql = "SELECT * FROM `category`";
                Statement stmt = Conn.getCon().createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    CategoryDTO categoryDTO = new CategoryDTO();
                    categoryDTO.setId(rs.getInt("id"));
                    categoryDTO.setName(rs.getString("name"));
                    categoryDTO.setDescription(rs.getString("description"));
                    arr.add(categoryDTO);
                }
                stmt.close();
                return arr;
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                Conn.closeConnection();
            }
        }
        return null;
    }

    public boolean addCategory(CategoryDTO categoryDTO) {
        boolean result = false;
        if (Conn.openConnection()) {
            try {
                String sql = "INSERT INTO `category`(`name`, `description`) VALUES (?,?)";
                PreparedStatement prstmt = Conn.getCon().prepareStatement(sql);
                prstmt.setString(1, categoryDTO.getName());
                prstmt.setString(2, categoryDTO.getDescription());
                if (prstmt.executeUpdate() >= 1) {
                    result = true;
                }
                prstmt.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                Conn.closeConnection();
            }
        }
        return result;
    }


    public boolean hasCategoryName(String name) {
        boolean result = false;
        if (Conn.openConnection()) {
            try {
                String sql = "SELECT * FROM `category` WHERE name = ?";
                PreparedStatement prstmt = Conn.getCon().prepareStatement(sql);
                prstmt.setString(1, name);
                ResultSet rs = prstmt.executeQuery();
                result = rs.next();
                prstmt.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                Conn.closeConnection();
            }
        }
        return result;
    }

    public CategoryDTO getCategoryById(int categoryId) {
        CategoryDTO categoryDTO = new CategoryDTO();
        if (Conn.openConnection()) {
            try {
                String sql = "SELECT * FROM `category` WHERE `id` = ?";
                PreparedStatement prstmt = Conn.getCon().prepareStatement(sql);
                prstmt.setInt(1, categoryId);
                ResultSet rs = prstmt.executeQuery();
                while (rs.next()) {
                    categoryDTO.setId(rs.getInt("id"));
                    categoryDTO.setName(rs.getString("name"));
                    categoryDTO.setDescription(rs.getString("description"));
                }
                return categoryDTO;
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                Conn.closeConnection();
            }

        }
        return null;

    }

    public CategoryDTO getCategoryByName(String categoryName) {
        CategoryDTO categoryDTO = new CategoryDTO();
        if (Conn.openConnection()) {
            try {
                String sql = "SELECT * FROM `category` WHERE `name` = ?";
                PreparedStatement prstmt = Conn.getCon().prepareStatement(sql);
                prstmt.setString(1, categoryName);
                ResultSet rs = prstmt.executeQuery();
                while (rs.next()) {
                    categoryDTO.setId(rs.getInt("id"));
                    categoryDTO.setName(rs.getString("name"));
                    categoryDTO.setDescription(rs.getString("description"));
                }
                return categoryDTO;
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                Conn.closeConnection();
            }

        }
        return null;

    }


}
