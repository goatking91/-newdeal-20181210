package com.demoweb.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import com.demoweb.model.dto.BoardComment;

public class CommentDao {

  private final String dsn = "oracle";

  public ArrayList<BoardComment> getList(int boardno) {

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList<BoardComment> comments = new ArrayList<BoardComment>();

    try {
      conn = ConnectionHelper.getConnection(dsn);
      String sql = 
          "SELECT commentno, writer, content, regdate " + 
              "FROM boardcomment " + 
              "WHERE boardno=? " + 
              "ORDER BY commentno";
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, boardno);
      rs = pstmt.executeQuery();
      while (rs.next()) {
        BoardComment comment = new BoardComment();
        comment.setCommentNo(rs.getInt(1));
        comment.setWriter(rs.getString(2));               
        comment.setContent(rs.getString(3));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        comment.setRegDate(sdf.format(rs.getDate(4)));
        comments.add(comment);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      try { rs.close(); } catch (Exception ex) {}
      try { pstmt.close(); } catch (Exception ex) {}
      try { conn.close(); } catch (Exception ex) {}
    }
    return comments; 

  }
  
  public int insertComment(BoardComment comment) {

    Connection conn = null;
    PreparedStatement pstmt = null;
    int result = 0;
    try {
      conn = ConnectionHelper.getConnection(dsn);
      String sql = 
          "insert into boardcomment (commentno, boardno, writer, content, regdate) " + 
          "values(BOARDCOMMENT_SEQUENCE.nextval, ?, ?, ?, sysdate)";
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, comment.getBoardNo());
      pstmt.setString(2, comment.getWriter());
      pstmt.setString(3, comment.getContent());
      result = pstmt.executeUpdate();
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      try { pstmt.close(); } catch (Exception ex) {}
      try { conn.close(); } catch (Exception ex) {}
    }
   return result;

  }
  
  public int updateComment(BoardComment comment) {

    Connection conn = null;
    PreparedStatement pstmt = null;
    int result = 0;
    try {
      conn = ConnectionHelper.getConnection(dsn);
      String sql = 
          "update boardComment set content=? " + 
          "where commentno=?";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, comment.getContent());
      pstmt.setInt(2,comment.getCommentNo());
      result = pstmt.executeUpdate();
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      try { pstmt.close(); } catch (Exception ex) {}
      try { conn.close(); } catch (Exception ex) {}
    }
   return result;

  }

  public int deleteComment(int commentNo) {

    Connection conn = null;
    PreparedStatement pstmt = null;
    int result = 0;
    try {
      conn = ConnectionHelper.getConnection(dsn);
      String sql = 
          "delete from boardcomment " + 
          "where commentno=?";
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, commentNo);
      result = pstmt.executeUpdate();
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      try { pstmt.close(); } catch (Exception ex) {}
      try { conn.close(); } catch (Exception ex) {}
    }
   return result;

  }
  
}







