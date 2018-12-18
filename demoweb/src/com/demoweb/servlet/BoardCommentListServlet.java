package com.demoweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.demoweb.model.dao.CommentDao;
import com.demoweb.model.dto.BoardComment;
import net.sf.json.JSONArray;

@WebServlet("/board/commentList")
public class BoardCommentListServlet extends HttpServlet{
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    CommentDao dao = new CommentDao();
    List<BoardComment> commentlist = dao.getList(Integer.parseInt(req.getParameter("boardno")));
    JSONArray jsonarray = JSONArray.fromObject(commentlist);
    resp.setCharacterEncoding("UTF-8");
    resp.setContentType("application/json");
    PrintWriter out = resp.getWriter();
    out.print(jsonarray);
    out.flush();
  }

}
