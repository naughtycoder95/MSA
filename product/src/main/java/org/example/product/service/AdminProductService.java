package org.example.product.service;

import org.example.product.model.entity.Product;
import org.example.product.repository.AdminProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * packageName : org.example.product.service.admin
 * fileName : AdminProductService
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
@Service
public class AdminProductService {
    @Autowired
    AdminProductRepository adminProductRepository;

    //    TODO: 등록(insert),수정(update)
    // 등록(insert) 함수
    public void save(Product product) {
        System.out.println("Saving product: " + product);
        adminProductRepository.save(product);
    }
}
