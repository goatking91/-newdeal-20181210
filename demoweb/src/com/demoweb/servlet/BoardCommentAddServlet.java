package com.demoweb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.demoweb.model.dao.CommentDao;
import com.demoweb.model.dto.BoardComment;

@WebServlet("/board/commentAdd")
public class BoardCommentAddServlet extends HttpServlet{
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    int boardNo = Integer.parseInt(req.getParameter("boardNo"));
    String writer = req.getParameter("writer");
    String content = req.getParameter("content");
    CommentDao dao = new CommentDao();
    BoardComment boardComment = new BoardComment();
    boardComment.setBoardNo(boardNo);
    boardComment.setWriter(writer);
    boardComment.setContent(content);
    dao.insertComment(boardComment);
    
  }
  
}
