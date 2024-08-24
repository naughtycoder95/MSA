package org.example.product.controller;

import org.example.product.model.entity.Product;
import org.example.product.service.admin.AdminProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName : org.example.product.controller
 * fileName : AdminProductController
 * author : GGG
 * date : 2024-06-13
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-13         GGG          최초 생성
 */
@RestController
@RequestMapping("/api/product")
public class AdminProductController {

    @Autowired
    private AdminProductService adminProductService;

    @PostMapping("/save")
    public void saveProduct(@RequestBody Product product) {
        adminProductService.save(product);
    }
}