package com.demoweb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.demoweb.model.dao.CommentDao;
import com.demoweb.model.dto.BoardComment;

@WebServlet("/board/commentUpdate")
public class BoardCommentUpdateServlet extends HttpServlet{
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    int commentNo = Integer.parseInt(req.getParameter("no"));
    String content = req.getParameter("content");
    CommentDao dao = new CommentDao();
    req.setCharacterEncoding("UTF-8");
    BoardComment boardComment = new BoardComment();
    boardComment.setCommentNo(commentNo);
    boardComment.setContent(content);
    dao.updateComment(boardComment);
    
  }
  
}
