package com.poly.shoptrangsuc.Config;
import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ConfigCloudinary {

    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "dhdt3pzh2");
        config.put("api_key", "665686713985449");
        config.put("api_secret", "f8cecoG7BRsAq-ah7UUoPLtYCwc");
        return new Cloudinary(config);
    }
}
