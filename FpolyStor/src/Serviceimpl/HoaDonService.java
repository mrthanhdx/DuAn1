/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Serviceimpl;

import DBcontext.ConnectionProvider;
import java.util.ArrayList;
import Service.HoaDonInterface;
import java.sql.*;
import Model.HoaDon1;
import Model.HoaDonChiTiet;

/**
 *
 * @author H
 */
public class HoaDonService implements HoaDonInterface{
    Connection con = ConnectionProvider.getConnection();

    @Override
    public ArrayList<HoaDon1> getAllHoaDon(int page, int limit) {
        ArrayList<HoaDon1> list = new ArrayList<>();
        String sql = """
                     Select ma,Users.Ten As TenNV, KhachHang.Ten As TenKH, TongTien, NgayTao,NgayThanhToan,TinhTrang,Ghichu 
                     from HoaDon join KhachHang on HoaDon.IdKH = KhachHang.Id
                     			join Users on HoaDon.IdNV = Users.Id
                     ORDER BY ma OFFSET ? ROW FETCH NEXT ? ROW ONLY""";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, (page-1)*limit);
            ps.setInt(2, limit);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                HoaDon1 hd = new HoaDon1();
                hd.setGhiChu(rs.getString("Ghichu"));
                hd.setMa(rs.getString("ma"));
                hd.setNgayTT(rs.getString("NgayThanhToan"));
                hd.setNgayTao(rs.getString("ngaytao"));
                hd.setTenKH(rs.getString("tenkh"));
                hd.setTenNV(rs.getString("tenNV"));
                hd.setTongTien(rs.getString("TongTien"));
                hd.setTrangThai(rs.getInt("tinhtrang"));
                list.add(hd);
            } return list;
        } catch (Exception e) {
            e.printStackTrace();
        }return null;
    }

    @Override
    public ArrayList<HoaDonChiTiet> getAllHoaDonChiTiet(String ma) {
        ArrayList<HoaDonChiTiet> list = new ArrayList<>();
        String sql= """
                      select HoaDon.Ma, ChitietSP.id as MaSP,Soluong,Dongia , Soluong*Dongia as thanhtien
                                            from HoaDonChiTiet join ChitietSP on HoaDonChiTiet.IdCTSP = ChitietSP.Id
                      									join  hoadon on HoaDonChiTiet.IdHD = HoaDon.Id
                                                              							where HoaDon.Ma =?""";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                HoaDonChiTiet hdct = new HoaDonChiTiet();
                hdct.setDonGia(rs.getDouble("DonGia"));
                hdct.setMaHoaDon(rs.getString("ma"));
                hdct.setMaSP(rs.getString("maSP"));
                hdct.setSoLuong(rs.getInt("SoLuong"));
                hdct.setThanhTien(rs.getDouble("ThanhTien"));
                list.add(hdct);
            } return list;
        } catch (Exception e) {
            e.printStackTrace();
        }return null;
    }
    
}
