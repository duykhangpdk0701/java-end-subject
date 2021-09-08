package DAL;

import DTO.UserDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class UserDAL {
    public Vector<UserDTO> getAllUsers() {
        Vector<UserDTO> arr = new Vector<UserDTO>();
        if (Conn.openConnection()) {
            try {
                String sql = "SELECT * FROM user";
                Statement stmt = Conn.getCon().createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    UserDTO user = new UserDTO();
                    user.setId(rs.getInt("id"));
                    user.setFullname(rs.getString("fullname"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setPhoneNumber(rs.getString("phoneNumber"));
                    user.setAdmin(rs.getInt("admin"));
                    arr.add(user);
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                Conn.closeConnection();
            }
        }
        return arr;
    }

    public boolean addUser(UserDTO user) {
        boolean result = false;
        if (Conn.openConnection()) {
            try {
                String sql = "INSERT INTO `user`(`fullname`, `username`, `password`, `phoneNumber`) VALUES (?,?,?,?)";
                PreparedStatement prstmt = Conn.getCon().prepareStatement(sql);
                prstmt.setString(1, user.getFullname());
                prstmt.setString(2, user.getUsername());
                prstmt.setString(3, user.getPassword());
                prstmt.setString(4, user.getPhoneNumber());
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


    public boolean hasUserId(int id) {
        boolean result = false;
        if (Conn.openConnection()) {
            try {
                String sql = "SELECT * FROM user WHERE id = ?";
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


    public boolean hasUserUsername(String username) {
        boolean result = false;
        if (Conn.openConnection()) {
            try {
                String sql = "SELECT * FROM user WHERE username = ?";
                PreparedStatement prstmt = Conn.getCon().prepareStatement(sql);
                prstmt.setString(1, username);
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

    public boolean hasUser(String username, String password) {
        boolean result = false;
        if (Conn.openConnection()) {
            try {
                String sql = "SELECT * FROM `user` WHERE `username` = ? AND `password` = ?";
                PreparedStatement prstmt = Conn.getCon().prepareStatement(sql);
                prstmt.setString(1, username);
                prstmt.setString(2, password);
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

    public UserDTO findUserByUsername(String username) {
        UserDTO userDTO = new UserDTO();
        if (Conn.openConnection()) {
            try {
                String sql = "SELECT * FROM `user` WHERE `username` = ?";
                PreparedStatement prstmt = Conn.getCon().prepareStatement(sql);
                prstmt.setString(1, username);
                ResultSet rs = prstmt.executeQuery();
                while (rs.next()) {
                    userDTO.setId(rs.getInt("id"));
                    userDTO.setFullname(rs.getString("fullname"));
                    userDTO.setUsername(rs.getString("username"));
                    userDTO.setPhoneNumber(rs.getString("phoneNumber"));
                }
                return userDTO;
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                Conn.closeConnection();
            }

        }
        return null;
    }


}
