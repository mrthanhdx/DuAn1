/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.DanhMuc;
import Model.GioHang;
import Model.HoaDon;
import Model.HoaDon1;
import Model.KhachHang;
import Model.MauSac;
import Model.NhaSX;
import Model.SanPhamCT;
import Model.Size;
import Model.ThuongHieu;
import Model.Users1;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author trant
 */
public interface BanHangService {

    public List<SanPhamCT> getListSP();

    public List<HoaDon> getListHD();

    public List<Users1> getAllUsers();

    public List<DanhMuc> getListDanhMuc();

    public List<Size> getListSize();

    public List<NhaSX> getListNsx();

    public List<ThuongHieu> getListThuongHieu();

    public List<MauSac> getListMauSac();

    public KhachHang getKhById(String idKh);

    public List<GioHang> getListGioHang();

    public boolean addGioHang(GioHang gioHang);

    public boolean addHoaDon(HoaDon hoaDon);

    public List<HoaDon> getAllHoaDon();

    public boolean thanhToan(String ma);

    public boolean deleteGioHang(String idGioHang);

    public boolean updateSoLuongGioHang(int idSP, int soLuongMoi);

    public List<HoaDon> getHoaDonDaThanhToan();
    
    public boolean addHoaDonDaThanhToan(HoaDon hoaDon);
    
    public boolean deleteHoaDonDaThanhToan();
    

}
