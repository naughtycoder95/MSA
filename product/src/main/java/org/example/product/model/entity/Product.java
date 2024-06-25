package org.example.product.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.product.model.common.BaseTimeEntity2;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 * packageName : org.example.product.model.entity
 * fileName : Product
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
@Entity
@Table(name = "TB_PRODUCT")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Where(clause = "STATUS = 'Y'")
@SQLDelete(sql = "UPDATE TB_PRODUCT SET STATUS = 'N' WHERE PD_ID = ?")
public class Product extends BaseTimeEntity2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pdId;

    private String pdTitle;

    private Integer pdPrice;

    private Integer pdStock;

    private String cgCode;

    private String status;
}