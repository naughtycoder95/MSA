package org.example.product.repository;

import org.example.product.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName : org.example.product.repository.admin
 * fileName : AdminProductRepository
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
@Repository
public interface AdminProductRepository extends JpaRepository<Product, Long> {
}