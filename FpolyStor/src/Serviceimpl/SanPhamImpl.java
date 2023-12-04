/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Serviceimpl;

import Model.SanPham;
import Service.SanPhamService;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trant
 */
public class SanPhamImpl implements SanPhamService {

    Connection conn = DBcontext.DBConnection.openDbConnection();

    @Override
    public boolean addSP(SanPham sp) {
        String sql = "insert into SanPham values(?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, sp.getMaSp());
            stmt.setString(2, sp.getTenSP());
            stmt.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

 
    @Override
    public boolean updateSP(SanPham sp) {
          String sql = "update SanPham set maSP = ?,tenSP = ? where id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, sp.getMaSp());
            stmt.setString(2, sp.getTenSP());
            stmt.setInt(3, sp.getIdSP());
            stmt.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<SanPham> getAllSanPham() {
         List<SanPham> list = new ArrayList<>();
        String sql = "select * from sanpham";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                SanPham sanPham = new SanPham();
                sanPham.setIdSP(rs.getInt("id"));
                sanPham.setMaSp(rs.getString("maSP"));
                sanPham.setTenSP(rs.getString("tenSp"));
                list.add(sanPham);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
