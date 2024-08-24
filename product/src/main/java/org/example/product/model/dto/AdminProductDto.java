package org.example.product.model.dto;

/**
 * packageName : org.example.product.model.dto
 * fileName : AdminProductDto
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
public interface AdminProductDto {
    Long pdId();
    String pdTitle();
    Integer pdPrice();
    Integer pdStock();
    String cgCode();
}
