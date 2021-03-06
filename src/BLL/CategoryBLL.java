package BLL;

import DAL.CategoryDAL;
import DTO.CategoryDTO;

import java.util.Vector;

public class CategoryBLL {
    CategoryDAL categoryDAL = new CategoryDAL();

    public Vector<CategoryDTO> getAllCategory() {
        return categoryDAL.getAllCategory();
    }

    public boolean hasCategoryName(String name) {
        return categoryDAL.hasCategoryName(name);
    }

    public CategoryDTO getCategoryById(int id) {
        return categoryDAL.getCategoryById(id);
    }

    public CategoryDTO getCategoryByName(String name) {
        return categoryDAL.getCategoryByName(name);
    }

    public String addCategory(CategoryDTO category) {
        if (categoryDAL.hasCategoryName(category.getName())) {
            return "Thư mục đã tồn tại";
        }
        if (categoryDAL.addCategory(category)) {
            return "Thêm thành công";
        }
        return "Thêm thất bại";
    }


    public String editCategory(String nameBeforeEdit, String nameAfterEdit, CategoryDTO categoryDTO) {

        if (categoryDAL.hasCategoryName(nameBeforeEdit, nameAfterEdit)) {
            return "Tên thư mục đã tồn tại";
        }
        if (categoryDAL.editCategory(categoryDTO)) {
            return "Sửa thành công thành công";
        }
        return "thêm thất bại";
    }

}
