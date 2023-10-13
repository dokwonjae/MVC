package com.example.mybatisexam.controller.exam02;

import com.example.mybatisexam.model.common.PageReq;
import com.example.mybatisexam.model.common.PageRes;
import com.example.mybatisexam.model.vo.Dept;
import com.example.mybatisexam.service.exam01.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * packageName : com.example.mybatisexam.controller.exam02
 * fileName : Dept02Controller
 * author : GGG
 * date : 2023-10-13
 * description : 부서 컨트롤러
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-13         GGG          최초 생성
 */
@Slf4j
@RestController
@RequestMapping("/exam02")
public class Dept02Controller {

    @Autowired
    DeptService deptService;

    /**
     * 전체조회 : 부서명 like 검색
     */
//  todo: @RequestParam - url?변수=값&변수2=값2 (쿼리스트링 방식)
    @GetMapping("/dept")
    public ResponseEntity<Object> getDeptAll(
            @RequestParam(defaultValue = "") String dname
            , @RequestParam(defaultValue = "0") int page
            , @RequestParam(defaultValue = "3") int size
    ) {
        try {
            PageReq pageReq = new PageReq(page, size);

//      todo: 전체 조회 함수 호출
            PageRes<Dept> pageRes
                    = deptService.findByDnameContaining(dname, pageReq);
//      todo: jsp 정보전달( 부서배열, 페이징정보 )
//        자료구조 (키,값) : Map
            Map<String, Object> response = new HashMap<>();

            response.put("dept", pageRes.getContent()); // 부서배열
            response.put("currentPage", pageRes.getNumber()); // 현재 페이지 번호
            response.put("totalItems", pageRes.getTotalElements()); // 전체 테이블 건수
            response.put("totalPages", pageRes.getTotalPages()); // 전체 페이지 개수

            if(pageRes.isEmpty() == false) {
//                todo: 조회 성공
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
//                todo: 0건 조회 (실패)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}