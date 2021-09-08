package BLL;

import DAL.UserDAL;
import DTO.UserDTO;

import java.util.Vector;

public class UserBLL {
    UserDAL userDAL = new UserDAL();

    public Vector<UserDTO> getAllUsers() {
        return userDAL.getAllUsers();
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
}
