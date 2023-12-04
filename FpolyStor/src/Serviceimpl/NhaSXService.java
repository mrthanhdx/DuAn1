/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Serviceimpl;

import DBcontext.ConnectionProvider;
import java.util.ArrayList;
import Model.NhaSX;
import Service.NhaSXInterface;
import java.sql.*;

/**
 *
 * @author H
 */
public class NhaSXService implements NhaSXInterface{
    Connection con = ConnectionProvider.getConnection();

    @Override
    public ArrayList<NhaSX> getAll(int page, int limit) {
        ArrayList<NhaSX> list = new ArrayList<>();
        String sql = "SELECT * FROM NSX ORDER BY id OFFSET ? ROW FETCH NEXT ? ROW ONLY";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
             ps.setInt(1, (page-1)*limit);
            ps.setInt(2, limit);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                NhaSX ns = new NhaSX();
                ns.setIdNhaSX(rs.getString("id"));
                ns.setTenNhaSX(rs.getString("ten"));
                list.add(ns);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int add(NhaSX ns) {
        String sql = """
                     INSERT INTO NSX
                     (
                         ten
                     )
                     VALUES
                     (?
                         )""";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ns.getTenNhaSX());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(NhaSX ns, String id) {
        String sql = """
                     UPDATE NSX SET ten =? 
                     	WHERE id=?""";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ns.getTenNhaSX());
            ps.setString(2, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }


    }
    
