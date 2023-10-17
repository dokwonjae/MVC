package com.example.jpaexam.model;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * packageName : com.example.jpaexam.model
 * fileName : Emp
 * author : GGG
 * date : 2023-10-16
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-16         GGG          최초 생성
 */
@Entity
// todo: @Table(name = "생성될테이블명")
@Table(name = "TB_EMP")
// todo 사용법 : @SequenceGenerator(
//        name = "시퀀스함수이름"
//        , sequenceName = "DB에생성된시퀀스이름"
//        , initialValue = 시작값
//        , allocationSize = jpa에서관리용숫자(성능지표)
//)
@SequenceGenerator(
        name = "SQ_EMP_GENERATOR"
        , sequenceName = "SQ_EMP"
        , initialValue = 1
        , allocationSize = 1
)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
// todo: jpa 어노테이션 sql 자동 생성시 null 값 컬럼은 제외하고 생성
//   예) insert into 테이블명(컬럼1, 컬럼2, 컬럼3) values(1, 2, null);
//    => insert into 테이블명(컬럼1, 컬럼2) values(1, 2);
@DynamicInsert
@DynamicUpdate
public class Emp extends BaseTimeEntity {
    @Id
//  todo: @GeneratedValue(strategy = GenerationType.SEQUENCE
//            , generator = "시퀀스함수이름"
//    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "SQ_EMP_GENERATOR"
    )
    @Column(columnDefinition = "NUMBER")
    private Integer eno; // 사원번호(기본키) - 시퀀스 기능 부여

    @Column(columnDefinition = "VARCHAR2(255)")
    private String ename; // 사원명

    @Column(columnDefinition = "VARCHAR2(255)")
    private String job;   // 직위
    @Column(columnDefinition = "VARCHAR2(255)")
    private Integer manager;   // 매니저
    @Column(columnDefinition = "VARCHAR2(255)")
    private String hiredate;   // 입사일
    @Column(columnDefinition = "VARCHAR2(255)")
    private Integer salary;   // 급여
    @Column(columnDefinition = "VARCHAR2(255)")
    private Integer commission;   // 상여금
    @Column(columnDefinition = "VARCHAR2(255)")
    private Integer dno;   // 부서번호
}
