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
 * fileName : Member
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
@Table(name = "TB_MEMBER")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Where(clause = "STATUS = 'Y'")
@SQLDelete(sql = "UPDATE TB_MEMBER SET STATUS = 'N' WHERE MEMBER_ID = ?")
public class Member extends BaseTimeEntity2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String memberId;

    private String memberPw;
    private String memberName;
    private String memberEmail;
    private String memberPhone;
    private String memberCode;
}
