package com.puco.member.dao;

import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.ocpsoft.prettytime.PrettyTime;

import com.puco.board.dao.QnaBoardVO;

import org.apache.ibatis.session.SqlSession;

public class MemberDAO {
	private static SqlSessionFactory ssf;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("Config.xml");
			ssf = new SqlSessionFactoryBuilder().build(reader);
			System.out.println("MemberDAO WORKING~~~~");
		} catch (Exception ex) {
			System.out.println("MemberDAO ERROR " + ex.getMessage());
		}
	}
	public static String memberLogin(String id, String pwd) {
		String result="";
		System.out.println("MemberDAO 1");
		SqlSession session = ssf.openSession();
		System.out.println("MemberDAO 2");
		System.out.println("MemberDAO "+id);
		System.out.println("MemberDAO "+pwd);
		int count = session.selectOne("memberIdCount", id);
		System.out.println("MemberDAO 3");
		System.out.println(count);
		// 그런 아이디가 있나? 없다면, 아이디 없음 기능 작동
		if(count==0) {
			result="NOID";
		}
		// 아이디가 존재하면 비밀번호 여부 확인하고, email값을 받아옴
		else {
			System.out.println("memberGetpwd " + id);
			MemberDTO d = session.selectOne("memberGetpwd", id);
			System.out.println("memberGetpwd " + d.getMpwd());
			if(pwd.equals(d.getMpwd())) {
				System.out.println("memberGetpwd Work1");
				result = d.getMemail()+"|"+d.getMno()+"|"+d.getMimageURL();
				System.out.println(result);
			}
			else {
				System.out.println("memberGetpwd Wrong PWD");
				result="NOPWD";
			}
		}
		session.close();
		System.out.println("MemberDAO 4");
		return result;
	}
	public static void profileupdate(MemberDTO d) {
		SqlSession session = ssf.openSession(true);
		session.insert("profileupdate","d");
		session.close();
		
	}
	public static MemberDTO userdata(int mno) {
		SqlSession session = ssf.openSession();
		System.out.println("userdata>>1");
		MemberDTO vo=session.selectOne("getUserData", mno);
		System.out.println("userdata>>2");
		int point=session.selectOne("getUserSCore",mno);
		System.out.println("userdata>>3");
		vo.setMpoint(point);
		int boardhit = session.selectOne("getSumHit",mno);
		System.out.println("userdata>>4");
		vo.setBoardhit(boardhit);
		session.close();
		
		return vo;
	}
	public static void userUpdate(MemberDTO d) {
		
		SqlSession session = ssf.openSession(true);
		session.update("userUpdate", d);
		session.close();
		
	}
	public static void loginUpdate(int mno){
		SqlSession session = ssf.openSession(true);
		session.update("loginUpdate",mno);
		session.close();
	}
	
	public static String getTagName(int tgno){
		SqlSession session = ssf.openSession();
		String tag = session.selectOne("getTagName",tgno);
		session.close();
		return tag;
	}
	public static String getTaglist(int mno) {
		SqlSession session = ssf.openSession();
		String tag = session.selectOne("getTagList",mno);
		session.close();
		return tag;
		
	}
	
	public static List<QnaBoardVO> getUserPost(int mno) {
		SqlSession session = ssf.openSession();
		List<QnaBoardVO> map = session.selectList("getUserPost",mno);
		session.close();
		return map;
		
	}
	
	public static void recordScore(ScoreVO d) {
		SqlSession session = ssf.openSession(true);
		session.insert("recordScore",d);
		session.close();		
	}
	
	public static List<QnaBoardVO> getUserAnswerPost(int mno) {
		SqlSession session = ssf.openSession();
		List<QnaBoardVO> map = session.selectList("getUserAnswerPost",mno);
		session.close();
		return map;
		
	}
	
	public static int memberIdCheck(String id){
		SqlSession session=ssf.openSession();
		int count=session.selectOne("memberIdCount",id);
		System.out.println("memberIdCheck Complete / count : "+count);
		session.close();
		return count;
	}
	
	public static void insertMember(MemberDTO dto) {
		SqlSession session = ssf.openSession(true);
		session.insert("insertMember",dto);
		System.out.println("insertMember Complete Joined well");
		session.close();
	}
	
	public static List<String> getPointDateList(int mno){
		SqlSession session=ssf.openSession();
		System.out.println("1번 >> ");
		List<String> date=session.selectList("getPointDate",mno);
		session.close();
		return date;		
	}
	public static List<Integer> getPointDate(int mno,List<String> date){
		SqlSession session=ssf.openSession();
		System.out.println("2번 >> ");
		List<Integer> map = new ArrayList();
		Map emap=new HashMap();
		emap.put("mno", mno);
		int sum =0;
		for(String d:date){
			emap.put("date", d);
			int temp = session.selectOne("getDaySumPoint",emap);
			sum+=temp;
			map.add( sum);
			System.out.println(d+"일  >> "+ sum);
		}
		session.close();
		return map;
	}
	
	
	public static List<ScoreVO> getAllPointData(int mno){
		SqlSession session=ssf.openSession();
		System.out.println("1번 >>왜죠?? ");
		List<ScoreVO> list=session.selectList("getAllPointData",mno);
		session.close();
		return list;		
	}
	
	
	public static String getUserDatabyName(String mid) {
		SqlSession session = ssf.openSession();
		System.out.println("userdata>>1");
		String vo=session.selectOne("getUserDatabyName", mid);
		session.close();
		return vo;
	}
}
