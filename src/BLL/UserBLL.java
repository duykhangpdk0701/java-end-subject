package BLL;

import DAL.UserDAL;
import DTO.UserDTO;

import java.util.Vector;

public class UserBLL {
    UserDAL userDAL = new UserDAL();

    public Vector<UserDTO> getAllUsers() {
        return userDAL.getAllUsers();
    }

    public String becomeUser(int id) {
        if (userDAL.becomeUser(id)) {
            return "Thành công";
        }
        return "Thất bại";
    }

    public String becomeAdmin(int id) {
        if (userDAL.becomeAdmin(id)) {
            return "Thành công";
        }
        return "thất bại";
    }

    public boolean hasUser(String username, String password) {
        return userDAL.hasUser(username, password);
    }

    public String addUser(UserDTO user) {
        if (userDAL.hasUserUsername(user.getUsername())) {
            return "username đã tồn tại";
        }
        if (userDAL.addUser(user)) {
            return "thêm thành công";
        }
        return "thêm thất bại";
    }

    public UserDTO findUserByUsername(String username) {
        return userDAL.findUserByUsername(username);
    }

    public UserDTO findUserByUserId(int id) {
        return userDAL.findUserByUserId(id);
    }

    public String editUser(String usernameBefore, String usernameAfter, UserDTO user) {
        if (userDAL.hasUserUsername(usernameBefore, usernameAfter)) {
            return "Username đã tồn tại";
        }
        if (userDAL.editUser(user)) {
            return "Lưu thành công";
        }
        return "Lưu thất bại";
    }
}
