package com.example.jpaexam.service;

import com.example.jpaexam.model.Dept;
import com.example.jpaexam.model.Emp;
import com.example.jpaexam.repository.DeptRepository;
import com.example.jpaexam.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName : com.example.jpaexam.service
 * fileName : EmpService
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
@Service
public class EmpService {
    @Autowired
    EmpRepository empRepository; // DI 객체 가져오기

    /** 전체조회 */
    public List<Emp> findAll() {
        List<Emp> list = empRepository.findAll(); // db 전체조회 함수 호출
        return list;
    }
}
