package com.puco.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import org.ocpsoft.prettytime.PrettyTime;
import com.puco.controller.Controller;
import com.puco.controller.RequestMapping;
import com.sun.xml.internal.ws.resources.HttpserverMessages;
import com.puco.board.dao.*;
import java.util.*;

@Controller("bc")
public class BoardController {

	@RequestMapping("boardmain.do")
	public String boardListData(HttpServletRequest req){
		String page=req.getParameter("page");
		PrettyTime p = new PrettyTime(new Locale("KO"));
		Map reltmap = new HashMap();
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=10;
		int start=(curpage*rowSize) - (rowSize-1);
		int end = curpage*rowSize;
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		List<QnaBoardVO> list = QBoardDAO.boardAllData(map);
		for(QnaBoardVO v:list){

			reltmap.put(v.getBno(), p.format(v.getBdate()));
		}

		int totalpage=QBoardDAO.BoardTotalPage();
		req.setAttribute("curpage",curpage);
		req.setAttribute("list", list);
		req.setAttribute("totalpage", totalpage);
		req.setAttribute("rtime", reltmap);
		req.setAttribute("jsp", "../board/BoardMain.jsp");
		return "common/container.jsp";
	}
	
	@RequestMapping("content.do")
	public String boardContentData(HttpServletRequest req){
		String no=req.getParameter("no");
		String page = req.getParameter("page");
		int ino = Integer.parseInt(no);
		/*BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.boardContentData(ino);*/
		QnaBoardVO vo= QBoardDAO.getContentData(ino);
		req.setAttribute("d", vo);
		req.setAttribute("page", page);
		req.setAttribute("jsp", "../board/content.jsp");
		return "common/container.jsp";
	
	}
	
	@RequestMapping("question.do")
	public static String askQuestion(HttpServletRequest req){
		req.setAttribute("jsp", "../board/insert.jsp");
		return "common/container.jsp";
	}
	
	@RequestMapping("question_ok.do")
	public static String question_ok(HttpServletRequest req) throws Exception{
		req.setCharacterEncoding("EUC-KR");
		HttpSession hs =req.getSession();
		String no = (String)hs.getAttribute("mno");
		int mno = Integer.parseInt(no);
		   String subject=req.getParameter("title");
		   String content=req.getParameter("ir1");
		   String taglist = req.getParameter("taglist");
		   StringTokenizer st=new StringTokenizer(taglist, ",");
		  String[] arrlist=new String[3];
		   for(int i=0;i<3;i++){
			   if(st.hasMoreTokens()){
			   arrlist[i]=st.nextToken();}
			   else arrlist[i]="1";
		   }
		   QnaBoardVO vo = new QnaBoardVO();
		   vo.setMno(mno);
		   vo.setBsubject(subject);
		   vo.setBcontent(content);
		   vo.setTgno1(Integer.parseInt(arrlist[0]));
		   vo.setTgno2(Integer.parseInt(arrlist[1]));
		   vo.setTgno3(Integer.parseInt(arrlist[2]));
		   System.out.println("boardinsert>>1");
		   QBoardDAO.boardInsert(vo);
		   System.out.println("boardinsert>>2");
		return "board/insert_ok.jsp";
		
	}
	
}
