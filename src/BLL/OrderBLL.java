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


}
