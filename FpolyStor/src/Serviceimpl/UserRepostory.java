/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Serviceimpl;

import DBcontext.DBContext1;
import Model.Chucvu;
import Model.User;
import Service.IUserRepostory;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class UserRepostory implements IUserRepostory {

    Connection conn = DBContext1.getConnection();

    @Override
    public List<User> getUser(String TaiKhoan, String MatKhau) {
        List<User> list = new ArrayList<>();
        try {
            String sql = "select nv.ho,nv.TenDem,nv.Ten ,nv.IdCV, cv.Ten , nv.id from Users nv join ChucVu  cv on nv.idCV = cv.id where nv.TaiKhoan =? and nv.matKhau =?";
            Connection conn = DBContext1.getConnection();
            PreparedStatement pr = conn.prepareStatement(sql);
            pr.setString(1, TaiKhoan);
            pr.setString(2, MatKhau);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setHo(rs.getString(1));
                user.setTenDem(rs.getString(2));
                user.setTen(rs.getString(3));
                Chucvu cv = new Chucvu();
                cv.setId(rs.getString(4));
                cv.setTen(rs.getString(5));
                user.setChucVu(cv);
                user.setId(rs.getInt(6));
                list.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<User> getAllUsers() {
        ArrayList<User> list = new ArrayList<>();
        String sql = """
                     SELECT Users.id,Users.Ten,TenDem,Ho,NgaySinh,Gioitinh,Sdt,IdCV,TaiKhoan,MatKhau,Email,ChucVu.Ten,TrangThai 
                     		FROM Users join ChucVu on ChucVu.Id = Users.IdCV""";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setEmail(rs.getString("Email"));
                u.setGioTinh(rs.getBoolean("GioiTinh"));
                u.setHo(rs.getString("Ho"));
                u.setId(rs.getInt("id"));
                u.setMatKhau(rs.getString("MatKhau"));
                u.setNgaySinh(rs.getDate("NgaySinh"));
                u.setSdt(rs.getString("sdt"));
                u.setTaiKhoan(rs.getString("TaiKhoan"));
                u.setTen(rs.getString("Ten"));
                u.setTenDem(rs.getString("TenDem"));
                u.setTrangThai(rs.getInt("TrangThai"));
                list.add(u);

            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }

    @Override
    public int login(User u) {
        String sql = "select * from Users where TaiKhoan=? and MatKhau=?";
        System.out.println("tai khoan:"+u.getTaiKhoan() +"mat khau:"+u.getMatKhau());
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, u.getTaiKhoan());
            ps.setString(1, u.getMatKhau());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
