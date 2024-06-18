package org.example.gateway.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.gateway.model.common.BaseTimeEntity2;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 * packageName : org.example.gateway.model.entity
 * fileName : Member
 * author : kimtaewan
 * date : 2024-06-12
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-12         kimtaewan          최초 생성
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
