package BLL;

import DAL.OrderDAL;
import DTO.OrderDTO;

import java.util.Vector;

public class OrderBLL {
    OrderDAL orderDAL = new OrderDAL();

    public Vector<OrderDTO> getAllOrder() {
        return orderDAL.getAllOrder();
    }

    public boolean addOrder(OrderDTO orderDTO) {
        return orderDAL.addOrder(orderDTO);
    }

    public OrderDTO getLastOrder() {
        return orderDAL.getLastOrder();
    }

    public Vector<OrderDTO> getOrderById(int userId) {
        return orderDAL.getOrdersByUserId(userId);
    }

    public Vector<OrderDTO> getOrderByMonthAndYear(int month, int year) {
        System.out.println(month);
        System.out.println(year);
        if (month == 0 && year == 0) {
            return orderDAL.getAllOrder();
        }
        if (month == 0) {
            return orderDAL.getOrderByYear(year);
        }
        if (year == 0) {
            return orderDAL.getOrderByMonth(month);
        }
        return orderDAL.getOrderByMonthAndYear(month, year);
    }


}
