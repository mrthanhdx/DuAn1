/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Serviceimpl;

import DBcontext.DBConnection;
import Model.ChatLieu;
import Model.DanhMuc;
import Model.MauSac;
import Model.NhaSX;
import Model.SanPham;
import Model.SanPhamCT;
import Model.Size;
import Model.ThuongHieu;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import Service.SanPhamCTService;

/**
 *
 * @author trant
 */
public class SanPhamServiceImpl implements SanPhamCTService {

    static Connection connn = DBConnection.openDbConnection();

    @Override
    public boolean add(SanPhamCT sp) {
        String sql = "insert into chitietSP(idSP,idNsx,idMauSac,idDMuc,idKC,idCL,idTH,idKM,Mota,SoLuongTon,GiaNhap,GiaBan) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = connn.prepareStatement(sql);
            stmt.setString(1, sp.getIdSP());
            stmt.setString(2, sp.getIdNsx());
            stmt.setString(3, sp.getIdMauSac());
            stmt.setString(4, sp.getIdDanhMuc());
            stmt.setString(5, sp.getIdKichco());
            stmt.setString(6, sp.getIdChatLieu());
            stmt.setString(7, sp.getIdThuongHieu());
            stmt.setString(8, sp.getIdKhuyenMai());
            stmt.setString(9, sp.getMota());
            stmt.setInt(10, sp.getSoLuongTon());
            stmt.setFloat(11, sp.getGiaNhap());
            stmt.setFloat(12, sp.getGiaBan());
            stmt.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean upadte(SanPhamCT sp) {
        String sqlUpdate = "update chitietSP set idSP = ?,idNsx=?,idMausac=?,idDmuc=?,idkc=?,idcl=?,idth=?,idkm=?,mota=?,soluongton=?,gianhap=?,giaban=? where id=? ";
        try {
            PreparedStatement stmt = connn.prepareStatement(sqlUpdate);
            stmt.setString(1, sp.getIdSP());
            stmt.setString(2, sp.getIdNsx());
            stmt.setString(3, sp.getIdMauSac());
            stmt.setString(4, sp.getIdDanhMuc());
            stmt.setString(5, sp.getIdKichco());
            stmt.setString(6, sp.getIdChatLieu());
            stmt.setString(7, sp.getIdThuongHieu());
            stmt.setString(8, sp.getIdKhuyenMai());
            stmt.setString(9, sp.getMota());
            stmt.setInt(10, sp.getSoLuongTon());
            stmt.setFloat(11, sp.getGiaNhap());
            stmt.setFloat(12, sp.getGiaBan());
            stmt.setInt(13, sp.getId());
            stmt.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<SanPhamCT> getAll() {
        List<SanPhamCT> list = new ArrayList<>();
        String sql = "select TOP 200 * from chitietsp";
        try {
            Statement stmt = connn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                SanPhamCT sp = new SanPhamCT();
                sp.setId(rs.getInt("id"));
                sp.setIdSP(rs.getString("idSP"));
                sp.setIdNsx(rs.getString("idnsx"));
                sp.setIdMauSac(rs.getString("idmausac"));
                sp.setIdDanhMuc(rs.getString("iddmuc"));
                sp.setIdKichco(rs.getString("idkc"));
                sp.setIdChatLieu(rs.getString("idcl"));
                sp.setIdThuongHieu(rs.getString("idth"));
                sp.setIdKhuyenMai(rs.getString("idkm"));
                sp.setMota(rs.getString("mota"));
                sp.setSoLuongTon(rs.getInt("soluongton"));
                sp.setGiaNhap(rs.getFloat("gianhap"));
                sp.setGiaBan(rs.getFloat("giaban"));
                list.add(sp);

            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<DanhMuc> getListDanhMuc() {
        List<DanhMuc> list = new ArrayList<>();
        String sql = "Select top 200 * from DANHMUCSP";
        try {
            Statement stmt = connn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                DanhMuc danhMuc = new DanhMuc();
                danhMuc.setIdDanhMuc(rs.getString("id"));
                danhMuc.setTenDanhMuc(rs.getString("TEN"));
                list.add(danhMuc);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ChatLieu> getListChatLieu() {
        List<ChatLieu> list = new ArrayList<>();
        String sql = "Select top 200 * from ChatLieu";
        try {
            Statement stmt = connn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ChatLieu chatLieu = new ChatLieu();
                chatLieu.setIdChatLieu(rs.getString("id"));
                chatLieu.setTenChatLieu(rs.getString("TEN"));
                list.add(chatLieu);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Size> getListKichCo() {
        List<Size> list = new ArrayList<>();
        String sql = "Select top 200 * from KichCo";
        try {
            Statement stmt = connn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Size kichCo = new Size();
                kichCo.setIdSize(rs.getString("id"));
                kichCo.setTenSize(rs.getString("TEN"));
                list.add(kichCo);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<MauSac> getListMauSac() {
        List<MauSac> list = new ArrayList<>();
        String sql = "Select * from MauSac";
        try {
            Statement stmt = connn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                MauSac mauSac = new MauSac();
                mauSac.setIdMau(rs.getString("id"));
                mauSac.setTenMau(rs.getString("TEN"));
                list.add(mauSac);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ThuongHieu> getListThuongHieu() {
        List<ThuongHieu> list = new ArrayList<>();
        String sql = "Select * from THUONGHIEU";
        try {
            Statement stmt = connn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ThuongHieu thuongHieu = new ThuongHieu();
                thuongHieu.setIdThuongHieu(rs.getString("id"));
                thuongHieu.setTenThuongHieu(rs.getString("TEN"));
                list.add(thuongHieu);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<NhaSX> getListNSX() {
        List<NhaSX> list = new ArrayList<>();
        String sql = "Select * from NSX";
        try {
            Statement stmt = connn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                NhaSX nsx = new NhaSX();
                nsx.setIdNhaSX((rs.getString("id")));
                nsx.setTenNhaSX(rs.getString("TEN"));
                list.add(nsx);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<SanPhamCT> loadPaging(int PageNum, int FetchRow) {
        String sql = "SELECT * FROM chitietSP ORDER BY Id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY;";
        try {
            List<SanPhamCT> list = new ArrayList<>();
            PreparedStatement stmt = connn.prepareStatement(sql);
            stmt.setInt(1, (PageNum - 1) * FetchRow);
            stmt.setInt(2, FetchRow);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                SanPhamCT sp = new SanPhamCT();
                sp.setId(rs.getInt("id"));
                sp.setIdSP(rs.getString("IdSP"));
                sp.setIdNsx(rs.getString("idNSX"));
                sp.setIdMauSac(rs.getString("idmausac"));
                sp.setIdDanhMuc(rs.getString("iddmuc"));
                sp.setIdKichco(rs.getString("idkc"));
                sp.setIdChatLieu(rs.getString("idcl"));
                sp.setIdThuongHieu(rs.getString("idth"));
                sp.setIdKhuyenMai(rs.getString("idkm"));
                sp.setMota(rs.getString("mota"));
                sp.setSoLuongTon(rs.getInt("soluongton"));
                sp.setGiaNhap(rs.getFloat("gianhap"));
                sp.setGiaBan(rs.getFloat("giaban"));
                list.add(sp);
            }

            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<SanPham> getListSP() {
        List<SanPham> list = new ArrayList<>();
        String sql = "Select top 200 * from SanPham";
        try {
            Statement stmt = connn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setIdSP(rs.getInt("id"));
                sp.setMaSp(rs.getString("maSp"));
                sp.setTenSP(rs.getString("TENSP"));
                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
