package com.cyl.test.service;

import com.cyl.wms.service.ShipmentOrderService;
import com.ruoyi.RuoYiApplication;
import com.ruoyi.common.utils.SecurityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = RuoYiApplication.class)
public class ServiceTest {
    @Autowired
    private ShipmentOrderService shipmentOrderService;

    @Test
    public void contextLoads() {
        shipmentOrderService.allocatedInventory(490L, 1);
    }

    /*
     * 加密密码 重置密码 默认密码 更改密码
     * */
    @Test
    public void encryptPassword() {
        Map<String, PasswordEncoder> encoderMap = new HashMap<>();
        encoderMap.put("bcrypt", new BCryptPasswordEncoder());
        encoderMap.put("pbkdf2", new Pbkdf2PasswordEncoder());
        encoderMap.put("argon2", new Argon2PasswordEncoder());
        encoderMap.put("scrypt", new SCryptPasswordEncoder());

        // 创建一个DelegatingPasswordEncoder实例
        PasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("bcrypt", encoderMap);

        // 加密密码
        String encodedPassword = passwordEncoder.encode("admin");
        System.out.println("Encoded password: " + encodedPassword);
    }
}
