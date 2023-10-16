package com.example.jpaexam.controller.exam01;

import com.example.jpaexam.model.Dept;
import com.example.jpaexam.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * packageName : com.example.jpaexam.controller.exam01
 * fileName : DeptController
 * author : GGG
 * date : 2023-10-16
 * description : 부서 컨트롤러 : (@RestController)
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-16         GGG          최초 생성
 */
@Slf4j
@RestController
@RequestMapping("/exam01")
public class DeptController {

    @Autowired
    DeptService deptService; // 객체 가져오기 (DI)

    /** 전체 조회 */
    @GetMapping("/dept")
    public ResponseEntity<Object> getDeptAll() {
        try {
//          todo: 전체 조회 함수 호출
            List<Dept> list = deptService.findAll();

            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //  todo: 연습1) 부서 클래스를 참고하여 사원 모델을(Emp) 만들고,
//    empRepository, empService, empController 를 작성하세요
//    전체 조회 함수 만드세요
//    (시퀀스명 : SQ_EMP,
//     시퀀스함수명 : SQ_EMP_GENERATOR )
//    url : /emp

}