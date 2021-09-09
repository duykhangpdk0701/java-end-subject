package BLL;

import DAL.VegetableDAL;
import DTO.VegetableDTO;

import java.util.Vector;

public class VegetableBLL {
    VegetableDAL vegetableDAL = new VegetableDAL();

    public Vector<VegetableDTO> getAllVegetable() {
        return vegetableDAL.getAllVegetables();
    }

    public String addVegetable(VegetableDTO vegetable) {
        if (vegetableDAL.hasVegetableName(vegetable.getName())) {
            return "Tên sản phẩm đã tồn tại";
        }
        if (vegetableDAL.addVegetable(vegetable)) {
            return "Thêm sản phẩm thành công";
        }
        return "thêm sản phẩm thất bại";
    }

    public String editVegetable(String nameBeforeName, String nameAfterName, VegetableDTO vegetableDTO) {
        if (vegetableDAL.hasVegetableName(nameBeforeName, nameAfterName)) {
            return "Tên sản phẩm đã tồn tại";
        }
        if (vegetableDAL.editVegetable(vegetableDTO)) {
            return "Sửa sản phẩm thành công";
        }
        return "Sửa sản phẩm thất bại";

    }

    public VegetableDTO findVegetableByName(String name) {
        return vegetableDAL.findVegetableName(name);
    }

    public VegetableDTO findVegetableById(int id) {
        return vegetableDAL.findVegetableID(id);
    }
}
