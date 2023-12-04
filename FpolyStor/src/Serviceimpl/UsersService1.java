/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Serviceimpl;

import DBcontext.ConnectionProvider;
import Service.UsersInterfaceService;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.ChucVu1;
import Model.Users1;

/**
 *
 * @author H
 */
public class UsersService1 implements UsersInterfaceService{
        Connection con = ConnectionProvider.getConnection();
    @Override
    public int login(Users1 u) {
        String sql = "select * from Users where TaiKhoan=? and MatKhau=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, u.getTaiKhoan());
            ps.setString(1, u.getMatKhau());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public ArrayList<Users1> getAllUsers() {
        ArrayList<Users1> list = new ArrayList<>();
        String sql = """
                     SELECT Users.id,Users.Ten,TenDem,Ho,NgaySinh,Gioitinh,Sdt,IdCV,TaiKhoan,MatKhau,Email,ChucVu.Ten,TrangThai 
                     		FROM Users join ChucVu on ChucVu.Id = Users.IdCV""";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Users1 u = new Users1();
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
        } return null;
    }
    
    public List<Users1> getUser(String TaiKhoan , String MatKhau) {
        List<Users1> list = new ArrayList<>();
        try {
            String sql = "select nv.ho,nv.TenDem,nv.Ten ,nv.IdCV, cv.Ten , nv.id from Users nv join ChucVu  cv on nv.idCV = cv.id where nv.TaiKhoan =? and nv.matKhau =?";
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement pr = conn.prepareStatement(sql);
            pr.setString(1, TaiKhoan);
            pr.setString(2, MatKhau);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {                
                Users1 user = new Users1();
                user.setHo(rs.getString(1));
                user.setTenDem(rs.getString(2));
                user.setTen(rs.getString(3));
                ChucVu1 cv = new ChucVu1();
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
    
}
