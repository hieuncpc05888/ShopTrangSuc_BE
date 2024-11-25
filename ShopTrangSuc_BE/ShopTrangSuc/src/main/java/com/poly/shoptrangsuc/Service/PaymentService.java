package com.poly.shoptrangsuc.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
//    @Autowired
//    private PaymentRepository paymentRepository;
//
//    public List<PaymentDTO> getAllPayments() {
//        List<Payment> payments = paymentRepository.findAll();
//        return payments.stream()
//                .map(this::convertToDTO)
//                .collect(Collectors.toList());
//    }
//
//    private PaymentDTO convertToDTO(Payment payment) {
//        PaymentDTO paymentDTO = new PaymentDTO();
//        paymentDTO.setPaymentId(payment.getPaymentId());
//        paymentDTO.setOrderId(payment.getOrder().getOrderId()); // Lấy Order ID từ Order
//        paymentDTO.setAmount(payment.getAmount());
//        paymentDTO.setPaymentStatus(payment.getPaymentStatus());
//        paymentDTO.setPaymentDate(payment.getPaymentDate());
//        paymentDTO.setPaymentMethod(payment.getPaymentMethod());
//        return paymentDTO;
//    }
}
