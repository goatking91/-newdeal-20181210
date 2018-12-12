<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.jquery.ajax.board.BoardDAO"%>
<%@ page import="com.jquery.ajax.board.BoardVO"%>
<%@ page import="java.util.List"%>
<%@ page import="net.sf.json.JSONArray"%>

<%
int num = Integer.parseInt(request.getParameter("idx"));
	BoardDAO dao = BoardDAO.getInstance();
	BoardVO board = dao.getBoardDetail(num);

	//JSON 데이터
	JSONArray jsonarray = JSONArray.fromObject(board);
%>
<%=jsonarray %>











