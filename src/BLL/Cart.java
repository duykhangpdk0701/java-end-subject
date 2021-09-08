package BLL;

import DTO.CartDTO;

import java.util.Vector;

public abstract class Cart {
    private static Vector<CartDTO> arr = new Vector<CartDTO>();

    public static Vector<CartDTO> getArr() {
        return arr;
    }

    public static void setArr(Vector<CartDTO> arr) {
        Cart.arr = arr;
    }

    public static void addItem(int idVegetable) {
        for (CartDTO item : arr) {
            if (item.getValue() == idVegetable) {
                item.setOccur(item.getOccur() + 1);
                return;
            }
        }
        arr.add(new CartDTO(idVegetable, 1));
    }

}
