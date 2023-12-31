package com.example.modelexam.service.exam08;

import com.example.modelexam.dao.MemberDao;
import com.example.modelexam.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.modelexam.service.exam01
 * fileName : MemberService
 * author : GGG
 * date : 2023-10-10
 * description : 회원 서비스 - 업무 로직
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-10         GGG          최초 생성
 */
@Service
public class Member08Service {

//    todo : db 접근 함수들이 있는 객체 : memberDao
    @Autowired
    MemberDao memberDao;

    /**
     * 전체 조회
     * @return
     */
    public List<Member> findAll() {
        List<Member> list = memberDao.selectAll(); // 전체 조회

        return list;
    }

    /**
     * 상세조회(1건조회)
     * 수정 : Optional 사용으로 수정
     * @param eno
     * @return
     */
    public Optional<Member> findById(long eno) {
//      todo: 상세조회(1건조회)
        Member member = memberDao.selectById(eno);
//      todo: null 방지 클래스 적용
        Optional<Member> optionalMember = Optional.ofNullable(member);

        return optionalMember;
    }

    /**
     * 회원 저장 함수
     * @param member
     * @return
     */
    public List<Member> save(Member member) {

        List<Member> list = null;

//      todo: ui(frontend) -> insert (사원번호가 없으면)
        if(member.getEno() == null) {
//          todo: 새로운 사원번호 생성
            int count = memberDao.selectAll().size(); // 전체 건수
            int newEno = count + 8000;
            member.setEno(newEno); // 새로운 사원번호 저장

            //      todo: db 저장
            list = memberDao.insert(member);
        } else {
//            todo: db 수정 저장
            list = memberDao.update(member);
        }

        return list;
    }

    /**
     * 사원번호로 삭제하는 함수
     * @param eno
     * @return
     */
    public boolean removeById(int eno) {
        int iCount = memberDao.deleteById(eno); // db 삭제

        return (iCount > 0)? true : false;
    }
}
