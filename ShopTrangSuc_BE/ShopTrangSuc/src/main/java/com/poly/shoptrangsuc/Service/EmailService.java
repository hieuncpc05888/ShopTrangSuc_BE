package com.poly.shoptrangsuc.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String to, String subject, String body) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(body);
            mailSender.send(message);
        } catch (Exception e) {
            // Ghi log lỗi (tùy chọn)
            System.err.println("Gửi email thất bại: " + e.getMessage());
            // Có thể ném ngoại lệ nếu cần
            throw new RuntimeException("Lỗi khi gửi email: " + e.getMessage());
        }
    }
}
