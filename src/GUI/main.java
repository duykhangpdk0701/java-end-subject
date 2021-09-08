package GUI;

import BLL.CategoryBLL;
import BLL.Helper;
import BLL.VegetableBLL;
import DAL.Conn;
import DAL.UserDAL;
import DTO.CategoryDTO;
import DTO.UserDTO;
import DTO.VegetableDTO;

import java.util.Vector;

public class main {
    public static void main(String[] args) {
        LoginGUI loginGUI = new LoginGUI();
        loginGUI.setVisible(true);
    }
}
