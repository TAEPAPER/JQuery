package kr.or.ddit.member.dao;

import java.util.List;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public interface IMemberDao {
	
	public List<MemberVO> selectAll();
	
	//중복검사 메소드
	public String idCheck(String memId); 
	
		//우편번호검색 메소드
   public List<ZipVO> zipList(String dong);		
	
		//저장하기
   
   public String insertMember(MemberVO memberVO);
}
