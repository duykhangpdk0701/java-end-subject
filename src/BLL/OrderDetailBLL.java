package BLL;

import DAL.OrderDetailDAL;
import DTO.OrderDetailDTO;

import java.util.Vector;

public class OrderDetailBLL {
    OrderDetailDAL orderDetailDAL = new OrderDetailDAL();

    public Vector<OrderDetailDTO> getAllOrderDetail() {
        return orderDetailDAL.getAllOrderDetail();
    }

    public boolean addOrderDetail(OrderDetailDTO orderDetailDTO) {
        return orderDetailDAL.addOrderDetail(orderDetailDTO);

    }

    public Vector<OrderDetailDTO> getOrderDetailByOrderId(int orderId) {
        return orderDetailDAL.getOrderDetailByOrderId(orderId);
    }

}
