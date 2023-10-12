package com.example.mybatisexam.service.exam01;

import com.example.mybatisexam.dao.EmpDao;
import com.example.mybatisexam.model.common.PageReq;
import com.example.mybatisexam.model.common.PageRes;
import com.example.mybatisexam.model.vo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName : com.example.mybatisexam.service.exam01
 * fileName : EmpService
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
@Service
public class EmpService {
    @Autowired
    EmpDao empDao;

    /** ename like 검색 */
    public PageRes<Emp> findByEnameContaining(String ename,
                                               PageReq pageReq) {
//        todo: 전체 조회 (like 됨)
        List<Emp> list = empDao.findByEnameContaining(ename, pageReq);

//        todo: 페이징 처리 로직
//         1) 총 테이블 개수 :
        long totalCount = empDao.countByEname(ename);
//        todo: 생성자 페이지 결과 객체(PageRes)
        PageRes pageRes = new PageRes(
                list,              // 검색 결과(부서) 배열
                pageReq.getPage(), // 현재 페이지 번호
                totalCount,        // 총 테이블 건수
                pageReq.getSize()  // 1페이지당 개수
        );

        return pageRes;
    }
}
