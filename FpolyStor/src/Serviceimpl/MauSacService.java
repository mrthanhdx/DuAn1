/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Serviceimpl;

import DBcontext.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Model.MauSac;
import Service.MauSacInterface;

/**
 *
 * @author H
 */
public class MauSacService implements MauSacInterface{
    Connection con = ConnectionProvider.getConnection();

    @Override
    public ArrayList<MauSac> getAll(int page, int limit) {
        ArrayList<MauSac> list = new ArrayList<>();
        String sql = "SELECT * FROM MauSac ORDER BY id OFFSET ? ROW FETCH NEXT ? ROW ONLY";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
             ps.setInt(1, (page-1)*limit);
            ps.setInt(2, limit);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                MauSac ms = new MauSac();
                ms.setIdMau(rs.getString("id"));
                ms.setTenMau(rs.getString("ten"));
                list.add(ms);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    

    @Override
    public int them(MauSac ms) {
        String sql = """
                     INSERT INTO MauSac
                     (
                         ten
                     )
                     VALUES
                     (?
                         )""";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ms.getTenMau());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        
    }

    @Override
    public int sua(MauSac ms, String id) {
        String sql = """
                     UPDATE MauSac SET ten =? 
                     	WHERE id=?""";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ms.getTenMau());
            ps.setString(2, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }


}
