/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Serviceimpl;

import DBcontext.ConnectionProvider;
import java.util.ArrayList;
import Model.Size;
import Service.SizeInterface;
import java.sql.*;

/**
 *
 * @author H
 */
public class SizeService implements SizeInterface{
    Connection con = ConnectionProvider.getConnection();

    @Override
    public ArrayList<Size> getAll(int page, int limit) {
        ArrayList<Size> list = new ArrayList<>();
        String sql = "SELECT * FROM KichCo ORDER BY id OFFSET ? ROW FETCH NEXT ? ROW ONLY";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
             ps.setInt(1, (page-1)*limit);
            ps.setInt(2, limit);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Size s = new Size();
                s.setIdSize(rs.getString("id"));
                s.setTenSize(rs.getString("ten"));
                list.add(s);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int add(Size s) {
        String sql = """
                     INSERT INTO kichco
                     (
                         ten
                     )
                     VALUES
                     (?
                         )""";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, s.getTenSize());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(Size s, String id) {
        String sql = """
                     update KichCo set Ten =? where id = ?""";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, s.getTenSize());
            ps.setString(2, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    
    }


    
}
