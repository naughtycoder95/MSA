package org.example.product.controller;

import org.example.product.model.entity.Product;
import org.example.product.service.AdminProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName : org.example.product.controller
 * fileName : AdminProductController
 * author : kimtaewan
 * date : 2024-06-19
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-19         kimtaewan          최초 생성
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