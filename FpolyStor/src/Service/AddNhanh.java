/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.ChatLieu;
import Model.DanhMuc;
import Model.MauSac;
import Model.NhaSX;
import Model.Size;
import Model.ThuongHieu;
import java.util.List;

/**
 *
 * @author trant
 */
public interface AddNhanh {

    public List<DanhMuc> getListDanhMuc();

    public List<MauSac> getlistMauSac();

    public List<Size> getListSize();

    public List<ThuongHieu> getListThuongHieu();

    public List<ChatLieu> getListChatLieu();

    public List<NhaSX> getListNhaSX();

    public boolean addDanhMuc(DanhMuc danhMuc);

    public boolean addMauSac(MauSac mauSac);

    public boolean addSize(Size size);

    public boolean addChatLieu(ChatLieu chatLieu);

    public boolean addNsx(NhaSX nsx);

    public boolean addThuongHieu(ThuongHieu thuongHieu);

}
