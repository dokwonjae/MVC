package com.example.mybatisexam.dao;

import com.example.mybatisexam.model.common.PageReq;

import com.example.mybatisexam.model.vo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.mybatisexam.dao
 * fileName : EmpDao
 * author : GGG
 * date : 2023-10-12
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-12         GGG          최초 생성
 */
@Mapper
public interface EmpDao {
    public List<Emp> findByEnameContaining(@Param("ename") String ename,
                                           PageReq pageReq
    );

    /**
     * 전체 테이블 개수 세기 함수
     */
    long countByEname(String ename);

    Optional<Emp> findById(int eno);

    /**
     * 저장함수
     */
    int insert(Emp emp);

    /**
     * 수정함수
     */
    int update(Emp emp);

    /**
     * 삭제함수
     */
    int deleteById(int eno);

    /**
     * 기본키(dno) 가 있는지 확인하는 조회함수
     */
    long existById(int eno);

    /**
     * todo: 다이나믹 SQL 작성 예제
     */
    public List<Emp> findByDynamicContaining(
            @Param("ename") String ename,
            @Param("job") String job,
            @Param("manager") Integer manager,
            @Param("hiredate") String hiredate,
            @Param("salary") Integer salary,
            @Param("commission") Integer commission,
            @Param("dno") String dno,
            PageReq pageReq);

    /**
     * todo: 다이나믹 SQL 작성 전체 카운트 예제
     */
    long countByDynamic(@Param("ename") String ename, @Param("job") String job,
                        @Param("manager") Integer manager,
                        @Param("hiredate") String hiredate,
                        @Param("salary") Integer salary,
                        @Param("commission") Integer commission,
                        @Param("dno") String dno);

}
