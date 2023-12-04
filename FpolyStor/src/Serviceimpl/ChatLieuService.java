/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Serviceimpl;

import DBcontext.ConnectionProvider;
import java.util.ArrayList;
import Model.ChatLieu;
import Service.ChatLieuInterface;
import java.sql.*;

/**
 *
 * @author H
 */
public class ChatLieuService implements ChatLieuInterface{
    Connection con = ConnectionProvider.getConnection();

    @Override
    public ArrayList<ChatLieu> getAll(int page, int limit) {
         ArrayList<ChatLieu> list = new ArrayList<>();
        String sql = "SELECT * FROM chatlieu ORDER BY id OFFSET ? ROW FETCH NEXT ? ROW ONLY";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
             ps.setInt(1, (page-1)*limit);
            ps.setInt(2, limit);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                ChatLieu ms = new ChatLieu();
                ms.setIdChatLieu(rs.getString("id"));
                ms.setTenChatLieu(rs.getString("ten"));
                list.add(ms);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int add(ChatLieu cl) {
        String sql = """
                     INSERT INTO ChatLieu
                     (
                         ten
                     )
                     VALUES
                     (?
                         )""";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cl.getTenChatLieu());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(ChatLieu cl, String id) {
        String sql = """
                     UPDATE ChatLieu SET ten =? 
                     	WHERE id=?""";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cl.getTenChatLieu());
            ps.setString(2, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    }
   

