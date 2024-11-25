package com.poly.shoptrangsuc.Service;
import com.poly.shoptrangsuc.Model.OrderDetail;
import com.poly.shoptrangsuc.Repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailRepository.findAll();
    }

    public Optional<OrderDetail> getOrderDetailById(Integer id) {
        return orderDetailRepository.findById(id);
    }
    public List<OrderDetail> getOrderDetailsByOrderId(Integer orderId) {
        return orderDetailRepository.findByOrderOrderId(orderId);
    }
    public List<OrderDetail> getOrderDetailsByStatus(Integer statusId) {
        return orderDetailRepository.findByOrder_OrderStatus_OrderStatusId(statusId); // Tìm kiếm theo trạng thái
    }
//    public OrderDetail createOrderDetail(OrderDetail orderDetail) {
//        return orderDetailRepository.save(orderDetail);
//    }
//
//    public OrderDetail updateOrderDetail(OrderDetail orderDetail) {
//        return orderDetailRepository.save(orderDetail);
//    }
//
//    public void deleteOrderDetail(Integer id) {
//        orderDetailRepository.deleteById(id);
//    }
}
