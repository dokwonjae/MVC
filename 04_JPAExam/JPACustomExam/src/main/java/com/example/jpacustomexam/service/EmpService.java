package com.example.jpacustomexam.service;


import com.example.jpacustomexam.dto.EmpGroupDto;
import com.example.jpacustomexam.model.Dept;
import com.example.jpacustomexam.model.Emp;
import com.example.jpacustomexam.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName : com.example.jpacustomexam.service
 * fileName : EmpService
 * author : GGG
 * date : 2023-10-17
 * description : 사원 서비스
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-17         GGG          최초 생성
 */
@Service
public class EmpService {

    @Autowired
    EmpRepository empRepository; // DI

    /**
     * 전체조회 + 정렬(eno 내림차순) : 쿼리메소드
     */
    public List<Emp> findAllByOrderByEnoDesc() {
        List<Emp> list = empRepository.findAllByOrderByEnoDesc();

        return list;
    }

    /**
     * 전체조회 + 정렬(ename 오름차순) : 쿼리메소드
     */
    public List<Emp> findAllByOrderByEname() {
        List<Emp> list = empRepository.findAllByOrderByEname();

        return list;
    }

    /**
     * 전체조회 + like(Containing) 검색( ename ) : 쿼리메소드
     */
    public List<Emp> findAllByEnameContaining(String ename) {
        List<Emp> list = empRepository.findAllByEnameContaining(ename);

        return list;
    }

    //    todo: 연습 4) EMP 테이블에서 Job 이 manager 이고
//              매개변수로 부서번호(dno)를 받는 함수를 작성하세요.
    public List<Emp> findAllByJobAndDno(String job, int dno) {
        List<Emp> list = empRepository.findAllByJobAndDno(job, dno);

        return list;
    }

    //    todo: 연습 5) Emp 테이블에서 salary 가 1000 ~ 1500 사이의 값을 같는
//     사원을 조회하려고 합니다.  함수를 작성해 주세요
    public List<Emp> findAllBySalaryBetween(int first, int last) {
        List<Emp> list = empRepository.findAllBySalaryBetween(first, last);

        return list;
    }

    //    todo: 연습 6)
    public List<Emp> findAllByJobIgnoreCase(String job) {
        List<Emp> list = empRepository.findAllByJobIgnoreCase(job);

        return list;
    }

    //    todo: 연습 7)
    public List<Emp> findAllByCommissionNotNull() {
        List<Emp> list = empRepository.findAllByCommissionNotNull();

        return list;
    }

    //    todo: 연습 8)
    public List<Emp> findAllByOrderBySalaryDescEnameAsc() {
        List<Emp> list = empRepository.findAllByOrderBySalaryDescEnameAsc();

        return list;
    }

    //    todo: 연습 9)
    public List<Emp> findAllBySalaryLessThanOrSalaryGreaterThan(int first,
                                                                int last) {
        List<Emp> list
                = empRepository
                .findAllBySalaryLessThanOrSalaryGreaterThan(first,last);

        return list;
    }


    //    todo: 연습 10)
    public List<Emp> findAllByCommissionOrCommissionOrCommission(int x, int y, int z) {
        List<Emp> list = empRepository.findAllByCommissionOrCommissionOrCommission(x, y, z);

        return list;
    }

//    -------------------------------------------------
//    @Query 예제
//    -------------------------------------------------
    /** 전체조회 + ename like 검색 : @Query */
    public List<Emp> selectByEname(String ename) {
        List<Emp> list
                = empRepository.selectByEname(ename);

        return list;
    }

    /** 전체조회 + ename like 검색 : @Query */
    public List<Emp> selectDesc() {
        List<Emp> list
                = empRepository.selectDesc();

        return list;
    }

    /** 전체조회 + ename like 검색 : @Query */
    public List<Emp> selectSalary(int salary) {
        List<Emp> list
                = empRepository.selectSalary(salary);

        return list;
    }

    /** 전체조회 + ename like 검색 : @Query */
    public List<Emp> selectHiredate(String first, String last) {
        List<Emp> list
                = empRepository.selectHiredate(first, last);

        return list;
    }

    /** 전체조회 그룹 함수 검색(dto) : @Query */
    public List<EmpGroupDto> selectGroupDnoJob() {
        List<EmpGroupDto> list
                = empRepository.selectGroupDnoJob();

        return list;
    }

    /** 전체조회 그룹 함수 검색(dto) : @Query */
    public List<EmpGroupDto> selectGroupDnoTrunc() {
        List<EmpGroupDto> list
                = empRepository.selectGroupDnoTrunc();

        return list;
    }

    /** 연습 7) : @Query(dto)*/
    public List<EmpGroupDto> selectGroupSumMax() {
        List<EmpGroupDto> list
                = empRepository.selectGroupSumMax();

        return list;
    }

    /** 연습 8) : @Query(dto) */
    public List<EmpGroupDto> selectGroupHiredate() {
        List<EmpGroupDto> list
                = empRepository.selectGroupHiredate();

        return list;
    }

//    --------------------------------------------------
//    페이지 예제
//    --------------------------------------------------
    public Page<Emp> findAllByEnameContaining(String ename, Pageable pageable) {
        Page<Emp> page
                = empRepository.findAllByEnameContaining(ename, pageable);

        return page;
    }

    //    2) 기본 제공되는 전체 조회 함수 : 페이징처리 기능 추가
    public Page<Emp> findAllPage(Pageable pageable) {
        Page<Emp> page
                = empRepository.findAll(pageable);

        return page;
    }
//    --------------------------
//    @Query : 페이징 처리
//    --------------------------
    //    2)  : 페이징처리 기능 추가
    public Page<Emp> selectByEnamePage(String ename, Pageable pageable) {
        Page<Emp> page
                = empRepository.selectByEnamePage(ename, pageable);

        return page;
    }

}