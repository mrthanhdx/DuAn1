/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Serviceimpl;

import Model.HoaDon1;
import Service.BanHangService;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import DBcontext.DBConnection;
import Model.DanhMuc;
import Model.GioHang;
import Model.HoaDon;
import Model.KhachHang;
import Model.MauSac;
import Model.NhaSX;
import Model.SanPhamCT;
import Model.Size;
import Model.ThuongHieu;
import Model.Users1;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author trant
 */
public class BanHangServiceImpl implements BanHangService {

    Connection conn = DBConnection.openDbConnection();

    @Override
    public List<SanPhamCT> getListSP() {
        List<SanPhamCT> list = new ArrayList<>();
        String sql = "select * from chitietSP";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                SanPhamCT sp = new SanPhamCT();
                sp.setId(rs.getInt("id"));
                sp.setIdSP(rs.getString("IdSP"));
                sp.setIdNsx(rs.getString("Idnsx"));
                sp.setIdMauSac(rs.getString("Idmausac"));
                sp.setIdDanhMuc(rs.getString("IDdmuc"));
                sp.setIdKichco(rs.getString("idKc"));
                sp.setIdChatLieu(rs.getString("idCL"));
                sp.setIdThuongHieu(rs.getString("idTH"));
                sp.setIdKhuyenMai(rs.getString("IDkm"));
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
    public List<HoaDon> getListHD() {
        List<HoaDon> list = new ArrayList<>();
        String sql = "select * from HoaDon";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                HoaDon sp = new HoaDon();
                sp.setId(rs.getInt("id"));
                sp.setIdKH(rs.getInt("idKH"));
                sp.setIdNV(rs.getInt("idNV"));
                sp.setMa(rs.getString("ma"));
                sp.setNgayTao(rs.getDate("ngayTao"));
                sp.setNgayThanhToan(rs.getDate("ngaythanhtoan"));
                sp.setTinhTrang(rs.getInt("tinhTrang"));
                sp.setGhiChu(rs.getString("ghiChu"));
                sp.setTongTien(rs.getFloat("Tongtien"));
                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Users1> getAllUsers() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DanhMuc> getListDanhMuc() {
        List<DanhMuc> list = new ArrayList<>();
        String sql = "select * from DanhMucSP";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                DanhMuc dm = new DanhMuc();
                dm.setIdDanhMuc(rs.getString("id"));
                dm.setTenDanhMuc(rs.getString("Ten"));
                list.add(dm);

            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Size> getListSize() {
        List<Size> list = new ArrayList<>();
        String sql = "select * from KICHCO";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Size dm = new Size();
                dm.setIdSize(rs.getString("id"));
                dm.setTenSize(rs.getString("Ten"));
                list.add(dm);

            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<NhaSX> getListNsx() {
        List<NhaSX> list = new ArrayList<>();
        String sql = "select * from NSX";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                NhaSX dm = new NhaSX();
                dm.setIdNhaSX(rs.getString("id"));
                dm.setTenNhaSX(rs.getString("Ten"));
                list.add(dm);

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
        String sql = "select * from THUONGHIEU";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ThuongHieu dm = new ThuongHieu();
                dm.setIdThuongHieu(rs.getString("id"));
                dm.setTenThuongHieu(rs.getString("Ten"));
                list.add(dm);

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
        String sql = "select * from MauSac";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                MauSac dm = new MauSac();
                dm.setIdMau(rs.getString("id"));
                dm.setTenMau(rs.getString("Ten"));
                list.add(dm);

            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public KhachHang getKhById(String idKh) {
        String sql = "select * from KhachHang where id =?";
        try {
            KhachHang kh = new KhachHang();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, idKh);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                kh.setTen(rs.getString("Ten"));
                kh.setTendem(rs.getString("TENDEM"));
                kh.setHo(rs.getString("HO"));
                kh.setGioitinh(rs.getInt("GioiTinh"));
                kh.setNgaysinh(rs.getDate("NgaySinh"));
                kh.setEmail(rs.getString("email"));
                kh.setSdt(rs.getString("SDT"));
                kh.setDiemthuong(rs.getInt("DIEMTHUONG"));
            }
            return kh;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<GioHang> getListGioHang() {
        List<GioHang> list = new ArrayList<>();
        String sql = "select gioHang.Id,gioHang.IdSP,chitietsp.idsp as idSPTQ ,SoLuong,TongTien,IdNsx,IdMauSac,IdDMuc,IdKC,IdCL,IdTH,IdKM,MoTa,SoLuongTon,GiaNhap,GiaBan from GioHang join chitietsp on Giohang.idsp = chitietsp.id ";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                GioHang gioHang = new GioHang();
                gioHang.setId(rs.getInt("ID"));
                gioHang.setIdSP(rs.getInt("IDSp"));
                gioHang.setSoLuong(rs.getInt("SoLuong"));
                gioHang.setTongTien(rs.getFloat("GiaBan"));
                list.add(gioHang);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean addGioHang(GioHang gioHang) {
        String sql = "insert into giohang(idsp,SoLuong,TongTien) values(?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, gioHang.getIdSP());
            stmt.setInt(2, gioHang.getSoLuong());
            stmt.setFloat(3, gioHang.getTongTien());
            stmt.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addHoaDon(HoaDon hoaDon) {
        String sql = "INSERT INTO HoaDon (IdKH, IdNV, Ma, NgayTao, NgayThanhToan, TinhTrang, TongTien) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, hoaDon.getIdKH());
            stmt.setInt(2, hoaDon.getIdNV());
            stmt.setString(3, hoaDon.getMa());
            stmt.setDate(4, new java.sql.Date(new java.util.Date().getTime()));
            if (hoaDon.getNgayThanhToan() != null) {
                stmt.setDate(5, new java.sql.Date(hoaDon.getNgayThanhToan().getTime()));
            } else {
                stmt.setDate(5, null);
            }
            stmt.setInt(6, hoaDon.getTinhTrang());
            stmt.setFloat(7, hoaDon.getTongTien());
            stmt.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<HoaDon> getAllHoaDon() {
        List<HoaDon> list = new ArrayList<>();
        String sql = "select * from HoaDon";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                HoaDon hoaDon = new HoaDon();
                hoaDon.setId(rs.getInt("id"));
                hoaDon.setIdKH(rs.getInt("IDKH"));
                hoaDon.setIdNV(rs.getInt("IDNV"));
                hoaDon.setMa(rs.getString("Ma"));
                hoaDon.setNgayTao(rs.getDate("NgayTao"));
                hoaDon.setNgayThanhToan(rs.getDate("NgayThanhToan"));
                hoaDon.setTinhTrang(rs.getInt("TinhTrang"));
                hoaDon.setGhiChu(rs.getString("GhiChu"));
                hoaDon.setTongTien(rs.getFloat("Tongtien"));
                list.add(hoaDon);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean thanhToan(String ma) {
        String sql = "update HoaDon set tinhtrang =?,ngayThanhToan=? where ma=?";
        try {
            // Get current date
            LocalDate currentDate = LocalDate.now();
            java.sql.Date sqlDate = java.sql.Date.valueOf(currentDate);

            // Print the current date
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, 1);
            stmt.setDate(2, sqlDate);
            stmt.setString(3, ma);
            stmt.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteGioHang(String idGioHang) {
        String sql = "delete from GioHang where id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, idGioHang);
            stmt.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateSoLuongGioHang(int idSP, int soLuongMoi) {
        String sql = "update giohang set soluong = ? where id =?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, soLuongMoi);
            stmt.setInt(2, idSP);
            stmt.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<HoaDon> getHoaDonDaThanhToan() {
        List<HoaDon> list = new ArrayList<>();
        String sql = "select * from hoadon where tinhtrang=1";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                HoaDon hoaDon = new HoaDon();
                hoaDon.setId(rs.getInt("id"));
                hoaDon.setIdKH(rs.getInt("IDKH"));
                hoaDon.setIdNV(rs.getInt("IDNV"));
                hoaDon.setMa(rs.getString("Ma"));
                hoaDon.setNgayTao(rs.getDate("NgayTao"));
                hoaDon.setNgayThanhToan(rs.getDate("NgayThanhToan"));
                hoaDon.setTinhTrang(rs.getInt("TinhTrang"));
                hoaDon.setGhiChu(rs.getString("GhiChu"));
                hoaDon.setTongTien(rs.getFloat("Tongtien"));
                list.add(hoaDon);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean addHoaDonDaThanhToan(HoaDon hoaDon) {
        String sql = "insert into HoaDonDaThanhToan(IdKH,IdNV,Ma,NgayTao,NgayThanhToan,TinhTrang,Ghichu,TongTien) values(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, hoaDon.getIdKH());
            stmt.setInt(2, hoaDon.getIdNV());
            stmt.setString(3, hoaDon.getMa());
            stmt.setDate(4, new java.sql.Date(hoaDon.getNgayTao().getTime()));
            stmt.setDate(5, new java.sql.Date(hoaDon.getNgayThanhToan().getTime()));
            stmt.setInt(6, hoaDon.getTinhTrang());
            stmt.setString(7, hoaDon.getGhiChu());
            stmt.setFloat(8, hoaDon.getTongTien());
            stmt.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteHoaDonDaThanhToan() {
//        String sql = "delete from HoaDon where tinhtrang = 1";
//        try {
//            Statement stmt= conn.createStatement();
//            stmt.execute(sql);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
    return false;
    }
}
