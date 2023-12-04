package Service;

import Model.ChatLieu;
import Model.DanhMuc;
import Model.MauSac;
import Model.NhaSX;
import Model.SanPham;
import Model.SanPhamCT;
import Model.Size;
import Model.ThuongHieu;
import java.util.List;

public interface SanPhamCTService {

    public boolean add(SanPhamCT sanPham);

    public boolean upadte(SanPhamCT sanPham);

    public List<SanPhamCT> getAll();

    public List<DanhMuc> getListDanhMuc();

    public List<ChatLieu> getListChatLieu();

    public List<Size> getListKichCo();

    public List<MauSac> getListMauSac();

    public List<ThuongHieu> getListThuongHieu();

    public List<NhaSX> getListNSX();

    public List<SanPham> getListSP();

    public List<SanPhamCT> loadPaging(int PageNum, int FetchRow);
}
