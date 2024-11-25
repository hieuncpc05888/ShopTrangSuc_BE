package com.poly.shoptrangsuc.Repository;
import com.poly.shoptrangsuc.Model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
    List<OrderDetail> findByOrder_OrderStatus_OrderStatusId(Integer statusId);
    List<OrderDetail> findByOrderOrderId(Integer orderId);
}
