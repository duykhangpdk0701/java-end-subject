package BLL;

import DTO.CartDTO;

import java.util.Vector;

public abstract class Cart {
    static VegetableBLL vegetableBLL = new VegetableBLL();

    private static Vector<CartDTO> arr = new Vector<CartDTO>();

    public static Vector<CartDTO> getArr() {
        return arr;
    }

    public static void setArr(Vector<CartDTO> arr) {
        Cart.arr = arr;
    }

    public static String addItem(int idVegetable) {
        for (CartDTO item : arr) {
            if (item.getValue() == idVegetable) {
                if (item.getOccur() >= vegetableBLL.findVegetableById(idVegetable).getAmount()) {
                    return "Số lượng vượt mức trong kho";
                }
                item.setOccur(item.getOccur() + 1);
                return "thêm thành công";
            }
        }
        arr.add(new CartDTO(idVegetable, 1));
        return "thêm thành công";
    }

}
