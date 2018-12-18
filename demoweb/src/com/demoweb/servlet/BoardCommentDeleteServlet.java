package com.demoweb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.demoweb.model.dao.CommentDao;

@WebServlet("/board/commentDelete")
public class BoardCommentDeleteServlet extends HttpServlet{
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    int commentNo = Integer.parseInt(req.getParameter("no"));
    CommentDao dao = new CommentDao();
    dao.deleteComment(commentNo);
    
  }
  
}
