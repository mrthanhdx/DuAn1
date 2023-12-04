package Serviceimpl;

import Model.ChatLieu;
import Model.DanhMuc;
import Model.MauSac;
import Model.NhaSX;
import Model.Size;
import Model.ThuongHieu;
import Service.AddNhanh;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class AddNhanhImpl implements AddNhanh {

    Connection conn = DBcontext.DBConnection.openDbConnection();

    @Override
    public List<DanhMuc> getListDanhMuc() {
        List<DanhMuc> list = new ArrayList<>();
        String sql = "select * from DANHMUCSP";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                DanhMuc dm = new DanhMuc();
                dm.setIdDanhMuc(rs.getString("id"));
                dm.setTenDanhMuc(rs.getString("ten"));
                list.add(dm);

            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<MauSac> getlistMauSac() {
         List<MauSac> list = new ArrayList<>();
        String sql = "select * from MauSac";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                MauSac ms = new MauSac();
                ms.setIdMau(rs.getString("id"));
                ms.setTenMau(rs.getString("ten"));
                list.add(ms);

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
        String sql = "select * from Kichco";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Size size = new Size();
                size.setIdSize(rs.getString("id"));
                size.setTenSize(rs.getString("ten"));
                list.add(size);

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
                ThuongHieu th = new ThuongHieu();
                th.setIdThuongHieu(rs.getString("id"));
                th.setTenThuongHieu(rs.getString("ten"));
                list.add(th);

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
        String sql = "select * from ChatLieu";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ChatLieu cl = new ChatLieu();
                cl.setIdChatLieu(rs.getString("id"));
                cl.setTenChatLieu(rs.getString("ten"));
                list.add(cl);

            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<NhaSX> getListNhaSX() {
            List<NhaSX> list = new ArrayList<>();
        String sql = "select * from NSX";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                NhaSX nsx = new NhaSX();
                nsx.setIdNhaSX(rs.getString("id"));
                nsx.setTenNhaSX(rs.getString("ten"));
                list.add(nsx);

            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean addDanhMuc(DanhMuc danhMuc) {
        String sql = "insert into DanhMucSP values(?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, danhMuc.getTenDanhMuc());
            stmt.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addMauSac(MauSac mauSac) {
          String sql = "insert into MauSac values(?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, mauSac.getTenMau());
            stmt.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }    
    }

    @Override
    public boolean addSize(Size size) {
       String sql = "insert into KichCo values(?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, size.getTenSize());
            stmt.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }     
    }

    @Override
    public boolean addChatLieu(ChatLieu chatLieu) {
         String sql = "insert into ChatLieu values(?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, chatLieu.getTenChatLieu());
            stmt.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }     
    }

    @Override
    public boolean addNsx(NhaSX nsx) {
         String sql = "insert into NSX values(?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nsx.getTenNhaSX());
            stmt.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }     
    }

    @Override
    public boolean addThuongHieu(ThuongHieu thuongHieu) {
         String sql = "insert into ThuongHieu values(?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, thuongHieu.getTenThuongHieu());
            stmt.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }     
    }

}
