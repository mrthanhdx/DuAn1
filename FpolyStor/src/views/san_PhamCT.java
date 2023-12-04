/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import Model.ChatLieu;
import Model.DanhMuc;
import Model.Size;
import Model.MauSac;
import Model.NhaSX;
import Model.SanPham;
import Model.SanPhamCT;
import Model.ThuongHieu;
import Serviceimpl.SanPhamServiceImpl;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import views.properties.AddDanhMuc;
import views.properties.addChatLieu;
import views.properties.addMauSac;
import views.properties.addNSX;
import views.properties.addSize;
import views.properties.addThuongHieu;
import Service.SanPhamCTService;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author H
 */
public final class san_PhamCT extends javax.swing.JFrame {

    private static String idSPXem;
    static int currentPage = 1;
    static int rowFetch = 4;
    SanPhamCTService sanPhamService = new SanPhamServiceImpl();

    public void setIdSpXem(String idSPxem) {
        this.idSPXem = idSPxem;
    }

    public String getIdSPXem() {
        return this.idSPXem;
    }

    public san_PhamCT() {
        initComponents();
        setLocationRelativeTo(null);
        loadThuocTinh();
        loadPage(currentPage, rowFetch);
        AutoCompleteDecorator.decorate(cbo_nsx);
        AutoCompleteDecorator.decorate(cboMaSp);
        AutoCompleteDecorator.decorate(cbo_chatlieu);
        AutoCompleteDecorator.decorate(cbo_danhmuc);
        AutoCompleteDecorator.decorate(cbo_mausac);
        AutoCompleteDecorator.decorate(cbo_size);
        AutoCompleteDecorator.decorate(cbo_thuonghieu1);

    }

    public String getTenChatLieu(String idcl) {
        String chatLieu = "";
        List<ChatLieu> listChatLieu = sanPhamService.getListChatLieu();
        for (ChatLieu chatlieu : listChatLieu) {
            if (chatlieu.getIdChatLieu().equalsIgnoreCase(idcl)) {
                chatLieu = chatlieu.getTenChatLieu();
            }
        }
        return chatLieu;
    }

    public String getTenThuongHieu(String idTH) {
        String result = "";
        List<ThuongHieu> listThuongHieu = sanPhamService.getListThuongHieu();
        for (ThuongHieu thuongHieu : listThuongHieu) {
            if (thuongHieu.getIdThuongHieu().equalsIgnoreCase(idTH)) {
                result = thuongHieu.getTenThuongHieu();
            }
        }
        return result;
    }

    public String getTenMau(String idMau) {
        String result = "";
        List<MauSac> listMauSac = sanPhamService.getListMauSac();
        for (MauSac mauSac : listMauSac) {
            if (mauSac.getIdMau().equalsIgnoreCase(idMau)) {
                result = mauSac.getTenMau();
            }
        }
        return result;
    }

    public String getTenSize(String idSize) {
        String result = "";
        List<Size> listSize = sanPhamService.getListKichCo();
        for (Size size : listSize) {
            if (size.getIdSize().equalsIgnoreCase(idSize)) {
                result = size.getTenSize();
            }
        }
        return result;
    }

    public String getTenDanhMuc(String idDanhMuc) {
        String result = "";
        List<DanhMuc> listDanhMuc = sanPhamService.getListDanhMuc();
        for (DanhMuc danhMuc : listDanhMuc) {
            if (danhMuc.getIdDanhMuc().equalsIgnoreCase(idDanhMuc)) {
                result = danhMuc.getTenDanhMuc();
            }
        }
        return result;
    }   
    public float getGiaBan (String idSP) {
        List<SanPhamCT> listSPCT = sanPhamService.getAll();
        float giaBan=0;
        for (SanPhamCT sanPhamCT : listSPCT) {
            if (sanPhamCT.getIdSP().equalsIgnoreCase(idSP)) {
                giaBan = sanPhamCT.getGiaBan();
            }
        }
        return giaBan;
    }
    
     public float getGiaBan1 (String idSP) {
        List<SanPhamCT> listSPCT = sanPhamService.getAll();
        float giaBan=0;
        for (SanPhamCT sanPhamCT : listSPCT) {
            if ((sanPhamCT.getId()+"").equalsIgnoreCase(idSP)) {
                giaBan = sanPhamCT.getGiaBan();
            }
        }
        return giaBan;
    }
    private void loadData() {
        List<SanPhamCT> list = sanPhamService.getAll();
        List<DanhMuc> listDanhMuc = sanPhamService.getListDanhMuc();
        List<MauSac> listMauSac = sanPhamService.getListMauSac();
        List<ThuongHieu> listThuongHieu = sanPhamService.getListThuongHieu();
        List<Size> listSize = sanPhamService.getListKichCo();

        DefaultTableModel model = (DefaultTableModel) tblList.getModel();
        model.setRowCount(0);
        for (SanPhamCT sanPham : list) {
            Object rowData[] = {sanPham.getId(), loadMaSp(sanPham.getIdSP()), loadTenSp(sanPham.getIdSP()), getTenDanhMuc(sanPham.getIdDanhMuc()),
                getTenMau(sanPham.getIdMauSac()), getTenSize(sanPham.getIdKichco()), getTenThuongHieu(sanPham.getIdThuongHieu()), getTenChatLieu(sanPham.getIdChatLieu()),
                sanPham.getSoLuongTon(), sanPham.getGiaNhap(), sanPham.getGiaBan(), sanPham.getMota()};
            model.addRow(rowData);
        }
    }

    private void loadThuocTinh() {
        DefaultComboBoxModel cboDanhmuc = (DefaultComboBoxModel) cbo_danhmuc.getModel();
        cboDanhmuc.removeAllElements();
        DefaultComboBoxModel cboChatLieu = (DefaultComboBoxModel) cbo_chatlieu.getModel();
        cboChatLieu.removeAllElements();

        DefaultComboBoxModel cboKichCo = (DefaultComboBoxModel) cbo_size.getModel();
        cboKichCo.removeAllElements();

        DefaultComboBoxModel cboMauSac = (DefaultComboBoxModel) cbo_mausac.getModel();
        cboMauSac.removeAllElements();

        DefaultComboBoxModel cboNsx = (DefaultComboBoxModel) cbo_nsx.getModel();
        cboNsx.removeAllElements();

        DefaultComboBoxModel cboThuongHieu = (DefaultComboBoxModel) cbo_thuonghieu1.getModel();
        cboThuongHieu.removeAllElements();

        DefaultComboBoxModel cboMaSP = (DefaultComboBoxModel) cboMaSp.getModel();
        cboMaSP.removeAllElements();

        List<DanhMuc> listDanhMuc = sanPhamService.getListDanhMuc();
        List<ChatLieu> listChatLieu = sanPhamService.getListChatLieu();
        List<Size> listKichCo = sanPhamService.getListKichCo();
        List<MauSac> listMauSac = sanPhamService.getListMauSac();
        List<NhaSX> listNSX = sanPhamService.getListNSX();
        List<ThuongHieu> listThongHieu = sanPhamService.getListThuongHieu();
        List<SanPham> listSanPham = sanPhamService.getListSP();

        for (SanPham sanPham : listSanPham) {
            cboMaSP.addElement(sanPham.getMaSp());
        }
        for (ThuongHieu thuongHieu : listThongHieu) {
            cboThuongHieu.addElement(thuongHieu.getTenThuongHieu());
        }
        for (DanhMuc danhMuc : listDanhMuc) {
            cboDanhmuc.addElement(danhMuc.getTenDanhMuc());
        }
        for (Size kichCo : listKichCo) {
            cboKichCo.addElement(kichCo.getTenSize());
        }
        for (MauSac mauSac : listMauSac) {
            cboMauSac.addElement(mauSac.getTenMau());
        }
        for (NhaSX nsx : listNSX) {
            cboNsx.addElement(nsx.getTenNhaSX());
        }
        for (ChatLieu chatLieu : listChatLieu) {
            cboChatLieu.addElement(chatLieu.getTenChatLieu());
        }
    }

    public String loadMaSp(String idSP) {
        String masp = "";
        List<SanPham> list = sanPhamService.getListSP();
        for (SanPham sanPham : list) {
            if ((sanPham.getIdSP() + "").equalsIgnoreCase(idSP)) {
                masp = sanPham.getMaSp();
            }
        }
        return masp;
    }

    public String loadTenSp(String idSP) {
        String ten = "";
        List<SanPham> list = sanPhamService.getListSP();
        for (SanPham sanPham : list) {
            if ((sanPham.getIdSP() + "").equalsIgnoreCase(idSP)) {
                ten = sanPham.getTenSP();
            }
        }
        return ten;
    }
    public String getIDSP1(String idSPCT) {
        List<SanPhamCT> list = sanPhamService.getAll();
        String idSPTQ = "";
        for (SanPhamCT sanPhamCT : list) {
            if ((sanPhamCT.getId()+"").equalsIgnoreCase(idSPCT)) {
                idSPTQ = sanPhamCT.getIdSP();
            }
        }
        return idSPTQ;
    }
    
    public void getMaSpTQ() {
        
    }
    private void addData() {
        SanPhamCT sp = new SanPhamCT();
        int idSP = 2;
        String maSP = cboMaSp.getSelectedItem() + "";
        List<SanPham> listSP = sanPhamService.getListSP();
        for (SanPham sanPham : listSP) {

            if (sanPham.getMaSp().equalsIgnoreCase(maSP)) {
                idSP = sanPham.getIdSP();
                sp.setIdSP(idSP + "");
            }
        }

        String idNsx;
        String idMauSac;
        String idDanhMuc;
        String idKichCo;
        String idChatLieu;
        String idThuongHieu;
        String idKhuyenMai;
        String nSx = cbo_nsx.getSelectedItem() + "";
        List<NhaSX> listNsx = sanPhamService.getListNSX();
        for (NhaSX nhaSX : listNsx) {
            if (nhaSX.getTenNhaSX().equalsIgnoreCase(nSx)) {
                idNsx = nhaSX.getIdNhaSX();
                sp.setIdNsx(idNsx);
            }
        }
        String mauSac = cbo_mausac.getSelectedItem() + "";
        List<MauSac> listMauSac = sanPhamService.getListMauSac();
        for (MauSac mausac : listMauSac) {
            if (mausac.getTenMau().equalsIgnoreCase(mauSac)) {
                idMauSac = mausac.getIdMau();
                sp.setIdMauSac(idMauSac);
            }
        }

        String DanhMuc = cbo_danhmuc.getSelectedItem() + "";
        List<DanhMuc> listDanhMuc = sanPhamService.getListDanhMuc();
        for (DanhMuc danhMuc : listDanhMuc) {
            if (danhMuc.getTenDanhMuc().equalsIgnoreCase(DanhMuc)) {
                idDanhMuc = danhMuc.getIdDanhMuc();
                sp.setIdDanhMuc(idDanhMuc);
            }
        }

        String KichCo = cbo_size.getSelectedItem() + "";
        List<Size> listKichCo = sanPhamService.getListKichCo();
        for (Size size : listKichCo) {
            if (size.getTenSize().equalsIgnoreCase(KichCo)) {
                idKichCo = size.getIdSize();
                sp.setIdKichco(idKichCo);
            }
        }

        String ChatLieu = cbo_chatlieu.getSelectedItem() + "";
        List<ChatLieu> listChatLieu = sanPhamService.getListChatLieu();
        for (ChatLieu chatLieu : listChatLieu) {
            if (chatLieu.getTenChatLieu().equalsIgnoreCase(ChatLieu)) {
                idChatLieu = chatLieu.getIdChatLieu();
                sp.setIdChatLieu(idChatLieu);
            }
        }

        String ThuongHieu = cbo_thuonghieu1.getSelectedItem() + "";
        List<ThuongHieu> listThuongHieu = sanPhamService.getListThuongHieu();
        for (ThuongHieu thuongHieu : listThuongHieu) {
            if (thuongHieu.getTenThuongHieu().equalsIgnoreCase(ThuongHieu)) {
                idThuongHieu = thuongHieu.getIdThuongHieu();
                sp.setIdThuongHieu(idThuongHieu);
            }
        }

//          String KhuyenMai = cbo.getSelectedItem()+"";
//        List<ThuongHieu> listThuongHieu = sanPhamService.getListThuongHieu();
//        for (ThuongHieu thuongHieu : listThuongHieu) {
//            if (thuongHieu.getTenThuongHieu().equalsIgnoreCase(ThuongHieu)) {
//                idThuongHieu = thuongHieu.getIdThuongHieu();
//                sp.setIdThuongHieu(idThuongHieu);
//            }
//        }
        sp.setIdKhuyenMai("1");
        sp.setMota(txt_mota.getText());

        sp.setSoLuongTon(Integer.parseInt(txt_soluongton.getText()));
        sp.setGiaNhap(Float.parseFloat(txt_gianhap.getText()));
        sp.setGiaBan(Float.parseFloat(txt_giaban.getText()));
        try {
            if (sanPhamService.add(sp)) {
                JOptionPane.showMessageDialog(this, "them thanh cong");
            } else {
                JOptionPane.showMessageDialog(this, "them that bai");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "loi service");

        }

    }

    private boolean updateData() {
        SanPhamCT sp = new SanPhamCT();
        int idSP = 1;
        String maSp = (cboMaSp.getSelectedItem() + "");
        List<SanPham> listSP = sanPhamService.getListSP();
        for (SanPham sanPham : listSP) {
            if (sanPham.getMaSp().equalsIgnoreCase(maSp)) {
                idSP = sanPham.getIdSP();
                sp.setIdSP(idSP + "");
            }
        }
        String idNsx;
        String idMauSac;
        String idDanhMuc;
        String idKichCo;
        String idChatLieu;
        String idThuongHieu;
        String idKhuyenMai;
        String nSx = cbo_nsx.getSelectedItem() + "";
        List<NhaSX> listNsx = sanPhamService.getListNSX();
        for (NhaSX nhaSX : listNsx) {
            if (nhaSX.getTenNhaSX().equalsIgnoreCase(nSx)) {
                idNsx = nhaSX.getIdNhaSX();
                sp.setIdNsx(idNsx);
            }
        }
        String mauSac = cbo_mausac.getSelectedItem() + "";
        List<MauSac> listMauSac = sanPhamService.getListMauSac();
        for (MauSac mausac : listMauSac) {
            if (mausac.getTenMau().equalsIgnoreCase(mauSac)) {
                idMauSac = mausac.getIdMau();
                sp.setIdMauSac(idMauSac);
            }
        }

        String DanhMuc = cbo_danhmuc.getSelectedItem() + "";
        List<DanhMuc> listDanhMuc = sanPhamService.getListDanhMuc();
        for (DanhMuc danhMuc : listDanhMuc) {
            if (danhMuc.getTenDanhMuc().equalsIgnoreCase(DanhMuc)) {
                idDanhMuc = danhMuc.getIdDanhMuc();
                sp.setIdDanhMuc(idDanhMuc);
            }
        }

        String KichCo = cbo_size.getSelectedItem() + "";
        List<Size> listKichCo = sanPhamService.getListKichCo();
        for (Size size : listKichCo) {
            if (size.getTenSize().equalsIgnoreCase(KichCo)) {
                idKichCo = size.getIdSize();
                sp.setIdKichco(idKichCo);
            }
        }

        String ChatLieu = cbo_chatlieu.getSelectedItem() + "";
        List<ChatLieu> listChatLieu = sanPhamService.getListChatLieu();
        for (ChatLieu chatLieu : listChatLieu) {
            if (chatLieu.getTenChatLieu().equalsIgnoreCase(ChatLieu)) {
                idChatLieu = chatLieu.getIdChatLieu();
                sp.setIdChatLieu(idChatLieu);
            }
        }

        String ThuongHieu = cbo_thuonghieu1.getSelectedItem() + "";
        List<ThuongHieu> listThuongHieu = sanPhamService.getListThuongHieu();
        for (ThuongHieu thuongHieu : listThuongHieu) {
            if (thuongHieu.getTenThuongHieu().equalsIgnoreCase(ThuongHieu)) {
                idThuongHieu = thuongHieu.getIdThuongHieu();
                sp.setIdThuongHieu(idThuongHieu);
            }
        }

        sp.setIdKhuyenMai("1");
        sp.setMota(txt_mota.getText());

        sp.setSoLuongTon(Integer.parseInt(txt_soluongton.getText()));
        sp.setGiaNhap(Float.parseFloat(txt_gianhap.getText()));
        sp.setGiaBan(Float.parseFloat(txt_giaban.getText()));
        int index = tblList.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Chua chon dong can update");
            return false;
        } else {
            int id = Integer.parseInt(tblList.getValueAt(index, 0) + "");
            sp.setId(id);
        }
        sp.setSoLuongTon(Integer.parseInt(txt_soluongton.getText()));
        sp.setGiaNhap(Float.parseFloat(txt_gianhap.getText()));
        sp.setGiaBan(Float.parseFloat(txt_giaban.getText()));
        try {
            if (sanPhamService.upadte(sp)) {
                JOptionPane.showMessageDialog(this, "update thanh cong");
                return true;
            } else {
                JOptionPane.showMessageDialog(this, "update that bai");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "loi service");
            return false;

        }
    }

    private boolean ValidateAddText(JTextField txt, String tenText) {
        if (txt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "khong duoc de trong truong " + tenText);
            return false;
        }
        return true;
    }

    private boolean ValidateAddNum(JTextField txt, String tenText) {
        if (txt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "khong duoc de trong truong " + tenText);
            return false;
        }
        try {
            Float.parseFloat(txt.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, tenText + " khong hop le");
            return false;
        }
        if (Float.parseFloat(txt.getText()) < 0) {
            JOptionPane.showMessageDialog(this, tenText + " khong hop le");
            return false;
        }
        return true;
    }

    private void loadPage(int page, int rowfetch) {
        DefaultTableModel model = (DefaultTableModel) tblList.getModel();
        model.setRowCount(0);
        List<SanPhamCT> list = sanPhamService.loadPaging(page, rowfetch);
        for (SanPhamCT sanPham : list) {
            Object rowData[] = {sanPham.getId(), loadMaSp(sanPham.getIdSP()), loadTenSp(sanPham.getIdSP()), getTenDanhMuc(sanPham.getIdDanhMuc()),
                getTenMau(sanPham.getIdMauSac()), getTenSize(sanPham.getIdKichco()), getTenThuongHieu(sanPham.getIdThuongHieu()), getTenChatLieu(sanPham.getIdChatLieu()),
                sanPham.getSoLuongTon(), sanPham.getGiaNhap(), sanPham.getGiaBan(), sanPham.getMota()};
            model.addRow(rowData);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelGradiente1 = new swing.PanelGradiente();
        panelBorder1 = new swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_soluongton = new swing.MyTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_gianhap = new swing.MyTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_giaban = new swing.MyTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txt_mota = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        cbo_nsx = new javax.swing.JComboBox<>();
        cbo_mausac = new javax.swing.JComboBox<>();
        cbo_danhmuc = new javax.swing.JComboBox<>();
        cbo_size = new javax.swing.JComboBox<>();
        cbo_chatlieu = new javax.swing.JComboBox<>();
        btn_capnhat = new swing.MyButton();
        btn_lammoi = new swing.MyButton();
        btn_them = new swing.MyButton();
        cbo_thuonghieu1 = new javax.swing.JComboBox<>();
        myButton1 = new swing.MyButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lbTenSP = new javax.swing.JLabel();
        cboMaSp = new javax.swing.JComboBox<>();
        panelBorder2 = new swing.PanelBorder();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblList = new javax.swing.JTable();
        panelBorder3 = new swing.PanelBorder();
        searchText = new swing.SearchText();
        lb_Btn_Search = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        xemSp = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1010, 640));

        panelGradiente1.setColorPrimario(new java.awt.Color(204, 255, 255));
        panelGradiente1.setColorSecundario(new java.awt.Color(255, 204, 255));

        panelBorder1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setText("Mã sản phẩm");
        panelBorder1.add(jLabel1);
        jLabel1.setBounds(30, 10, 210, 20);

        jLabel2.setText("Tên sản phẩm");
        panelBorder1.add(jLabel2);
        jLabel2.setBounds(30, 80, 210, 20);

        jLabel3.setText("Nhà sản xuất");
        panelBorder1.add(jLabel3);
        jLabel3.setBounds(30, 150, 210, 20);

        jLabel4.setText("Màu sắc");
        panelBorder1.add(jLabel4);
        jLabel4.setBounds(30, 220, 210, 20);

        jLabel5.setText("Danh mục");
        panelBorder1.add(jLabel5);
        jLabel5.setBounds(280, 10, 210, 20);

        jLabel6.setText("Size");
        panelBorder1.add(jLabel6);
        jLabel6.setBounds(280, 80, 210, 20);

        jLabel7.setText("Chất liệu");
        panelBorder1.add(jLabel7);
        jLabel7.setBounds(280, 150, 210, 20);

        jLabel8.setText("Thương hiệu");
        panelBorder1.add(jLabel8);
        jLabel8.setBounds(280, 220, 210, 20);
        panelBorder1.add(txt_soluongton);
        txt_soluongton.setBounds(530, 30, 210, 40);

        jLabel10.setText("Số lượng tồn");
        panelBorder1.add(jLabel10);
        jLabel10.setBounds(530, 10, 210, 20);
        panelBorder1.add(txt_gianhap);
        txt_gianhap.setBounds(530, 100, 210, 40);

        jLabel11.setText("Giá nhập");
        panelBorder1.add(jLabel11);
        jLabel11.setBounds(530, 80, 210, 20);
        panelBorder1.add(txt_giaban);
        txt_giaban.setBounds(530, 170, 210, 40);

        jLabel12.setText("Mô tả");
        panelBorder1.add(jLabel12);
        jLabel12.setBounds(530, 220, 220, 20);

        txt_mota.setColumns(20);
        txt_mota.setRows(2);
        txt_mota.setTabSize(0);
        txt_mota.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        txt_mota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_motaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(txt_mota);

        panelBorder1.add(jScrollPane4);
        jScrollPane4.setBounds(530, 240, 210, 70);

        jLabel13.setText("Giá bán");
        panelBorder1.add(jLabel13);
        jLabel13.setBounds(530, 150, 210, 20);

        cbo_nsx.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 2));
        panelBorder1.add(cbo_nsx);
        cbo_nsx.setBounds(30, 170, 210, 40);

        cbo_mausac.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 2));
        panelBorder1.add(cbo_mausac);
        cbo_mausac.setBounds(30, 240, 210, 40);

        cbo_danhmuc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 2));
        cbo_danhmuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_danhmucActionPerformed(evt);
            }
        });
        panelBorder1.add(cbo_danhmuc);
        cbo_danhmuc.setBounds(280, 30, 210, 40);

        cbo_size.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 2));
        panelBorder1.add(cbo_size);
        cbo_size.setBounds(280, 100, 210, 40);

        cbo_chatlieu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 2));
        panelBorder1.add(cbo_chatlieu);
        cbo_chatlieu.setBounds(280, 170, 210, 40);

        btn_capnhat.setBackground(new java.awt.Color(125, 224, 237));
        btn_capnhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/floppy-disk.png"))); // NOI18N
        btn_capnhat.setText("Cập nhật");
        btn_capnhat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_capnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_capnhatActionPerformed(evt);
            }
        });
        panelBorder1.add(btn_capnhat);
        btn_capnhat.setBounds(810, 120, 140, 40);

        btn_lammoi.setBackground(new java.awt.Color(125, 224, 237));
        btn_lammoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        btn_lammoi.setText("Làm mới");
        btn_lammoi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_lammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lammoiActionPerformed(evt);
            }
        });
        panelBorder1.add(btn_lammoi);
        btn_lammoi.setBounds(810, 20, 140, 40);

        btn_them.setBackground(new java.awt.Color(125, 224, 237));
        btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btn_them.setText("Thêm");
        btn_them.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });
        panelBorder1.add(btn_them);
        btn_them.setBounds(810, 70, 140, 40);

        cbo_thuonghieu1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 2));
        panelBorder1.add(cbo_thuonghieu1);
        cbo_thuonghieu1.setBounds(280, 240, 210, 40);

        myButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        myButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myButton1MouseClicked(evt);
            }
        });
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });
        panelBorder1.add(myButton1);
        myButton1.setBounds(750, 20, 40, 40);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        panelBorder1.add(jLabel9);
        jLabel9.setBounds(490, 250, 28, 20);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        jLabel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel16MouseEntered(evt);
            }
        });
        panelBorder1.add(jLabel16);
        jLabel16.setBounds(490, 110, 28, 20);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        jLabel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        panelBorder1.add(jLabel17);
        jLabel17.setBounds(490, 180, 28, 20);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        jLabel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });
        panelBorder1.add(jLabel18);
        jLabel18.setBounds(490, 40, 28, 20);

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        jLabel19.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });
        panelBorder1.add(jLabel19);
        jLabel19.setBounds(240, 180, 28, 20);

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        jLabel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        panelBorder1.add(jLabel20);
        jLabel20.setBounds(240, 250, 28, 20);

        lbTenSP.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 204, 255), null));
        panelBorder1.add(lbTenSP);
        lbTenSP.setBounds(30, 100, 210, 40);

        cboMaSp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 2));
        cboMaSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMaSpActionPerformed(evt);
            }
        });
        panelBorder1.add(cboMaSp);
        cboMaSp.setBounds(30, 30, 210, 40);

        panelGradiente1.add(panelBorder1);
        panelBorder1.setBounds(10, 0, 990, 320);

        panelBorder2.setBackground(new java.awt.Color(204, 204, 255));

        tblList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "MaSP", "TênSP", "Danh Mục", "Màu", "Size", "Thương Hiệu", "Chất Liệu", "Số Lượng", "Giá  Nhập", "Giá Bán", "Mô tả"
            }
        ));
        tblList.setGridColor(new java.awt.Color(255, 255, 255));
        tblList.setRowHeight(25);
        tblList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblList);
        if (tblList.getColumnModel().getColumnCount() > 0) {
            tblList.getColumnModel().getColumn(8).setResizable(false);
            tblList.getColumnModel().getColumn(11).setResizable(false);
        }

        panelBorder2.add(jScrollPane1);
        jScrollPane1.setBounds(0, 60, 990, 210);

        panelBorder3.setBackground(new java.awt.Color(255, 255, 255));

        searchText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextActionPerformed(evt);
            }
        });
        searchText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextKeyReleased(evt);
            }
        });
        panelBorder3.add(searchText);
        searchText.setBounds(10, 0, 250, 40);

        lb_Btn_Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search_24px.png"))); // NOI18N
        lb_Btn_Search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_Btn_SearchMouseClicked(evt);
            }
        });
        panelBorder3.add(lb_Btn_Search);
        lb_Btn_Search.setBounds(270, 0, 24, 40);

        panelBorder2.add(panelBorder3);
        panelBorder3.setBounds(660, 10, 310, 40);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new-page.png"))); // NOI18N
        jLabel15.setText("Thêm thuộc tính");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        panelBorder2.add(jLabel15);
        jLabel15.setBounds(10, 10, 180, 40);

        xemSp.setText("Xem Sản phẩm vừa chọn");
        xemSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xemSpActionPerformed(evt);
            }
        });
        panelBorder2.add(xemSp);
        xemSp.setBounds(160, 20, 180, 30);

        panelGradiente1.add(panelBorder2);
        panelBorder2.setBounds(10, 329, 990, 270);

        jButton1.setText("1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelGradiente1.add(jButton1);
        jButton1.setBounds(380, 610, 40, 23);

        jButton2.setText("2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panelGradiente1.add(jButton2);
        jButton2.setBounds(430, 610, 40, 23);

        jButton3.setText("3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        panelGradiente1.add(jButton3);
        jButton3.setBounds(480, 610, 40, 23);

        jButton4.setText(">");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        panelGradiente1.add(jButton4);
        jButton4.setBounds(530, 610, 50, 23);

        jButton7.setText("<");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        panelGradiente1.add(jButton7);
        jButton7.setBounds(320, 610, 50, 23);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradiente1, javax.swing.GroupLayout.DEFAULT_SIZE, 1010, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradiente1, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1010, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_capnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_capnhatActionPerformed
        if (ValidateAddNum(txt_soluongton, "so luong ton")
                && ValidateAddNum(txt_giaban, "Gia Ban") && ValidateAddNum(txt_gianhap, "Gia Nhap")) {
            updateData();
        }
        loadPage(currentPage, rowFetch);
    }//GEN-LAST:event_btn_capnhatActionPerformed

    private void btn_lammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lammoiActionPerformed
        txt_giaban.setText("");
        txt_gianhap.setText("");
        txt_mota.setText("");
        txt_soluongton.setText("");
        searchText.setText("");
        loadThuocTinh();
        JOptionPane.showMessageDialog(this, "Lam mới thành công !");
    }//GEN-LAST:event_btn_lammoiActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        if (ValidateAddNum(txt_soluongton, "so luong ton")
                && ValidateAddNum(txt_giaban, "Gia Ban") && ValidateAddNum(txt_gianhap, "Gia Nhap")) {
            addData();
        }
        loadPage(currentPage, rowFetch);
    }//GEN-LAST:event_btn_themActionPerformed

    private void tblListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListMouseClicked
        int index = tblList.getSelectedRow();
        cboMaSp.setSelectedItem(tblList.getValueAt(index, 1) + "");
        lbTenSP.setText(tblList.getValueAt(index, 2) + "");
        txt_giaban.setText(tblList.getValueAt(index, 10) + "");
        txt_gianhap.setText(tblList.getValueAt(index, 9) + "");
        txt_soluongton.setText(tblList.getValueAt(index, 8) + "");
        txt_mota.setText(tblList.getValueAt(index, 11) + "");
        cbo_danhmuc.setSelectedItem(tblList.getValueAt(index, 3));
        cbo_mausac.setSelectedItem(tblList.getValueAt(index, 4));
        cbo_size.setSelectedItem(tblList.getValueAt(index, 5));
        cbo_thuonghieu1.setSelectedItem(tblList.getValueAt(index, 6));
        cbo_chatlieu.setSelectedItem(tblList.getValueAt(index, 7));


    }//GEN-LAST:event_tblListMouseClicked

    private void searchTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextKeyReleased

    }//GEN-LAST:event_searchTextKeyReleased

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        Them_Thuoc_Tinh themtt = new Them_Thuoc_Tinh(this, rootPaneCheckingEnabled);
        themtt.setVisible(true);
//        this.dispose();
    }//GEN-LAST:event_jLabel15MouseClicked

    private void searchTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextActionPerformed

    private void lb_Btn_SearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_Btn_SearchMouseClicked

        DefaultTableModel model = (DefaultTableModel) tblList.getModel();
        model.setRowCount(0);
        List<SanPham> listSp = sanPhamService.getListSP();
        for (SanPham sanPham1 : listSp) {
            if (sanPham1.getTenSP().contains(searchText.getText())) {
                List<SanPhamCT> list = sanPhamService.getAll();
                int idSP = sanPham1.getIdSP();

                for (SanPhamCT sanPham : list) {
                    if (sanPham.getIdSP().equalsIgnoreCase(idSP + "")) {
                        Object rowData[] = {sanPham.getId(), loadMaSp(sanPham.getIdSP()), loadTenSp(sanPham.getIdSP()), getTenDanhMuc(sanPham.getIdDanhMuc()),
                            getTenMau(sanPham.getIdMauSac()), getTenSize(sanPham.getIdKichco()), getTenThuongHieu(sanPham.getIdThuongHieu()), getTenChatLieu(sanPham.getIdChatLieu()),
                            sanPham.getSoLuongTon(), sanPham.getGiaNhap(), sanPham.getGiaBan(), sanPham.getMota()};
                        model.addRow(rowData);
                    }
                }
            }
        }


    }//GEN-LAST:event_lb_Btn_SearchMouseClicked

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed

    }//GEN-LAST:event_myButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        currentPage = 1;
        loadPage(currentPage, rowFetch);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        currentPage = 2;
        loadPage(currentPage, rowFetch);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        currentPage = 3;
        loadPage(currentPage, rowFetch);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if (currentPage == 1) {
            JOptionPane.showMessageDialog(this, "Bạn đã về trang đầu");
        } else {
            currentPage--;
            loadPage(currentPage, rowFetch);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (currentPage == 3) {
            JOptionPane.showMessageDialog(this, "Bạn đã về trang cuối");
        } else {
            currentPage++;
            loadPage(currentPage, rowFetch);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        AddDanhMuc adm = new AddDanhMuc();
        adm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adm.setVisible(true);

    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        addSize adm = new addSize();
        adm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adm.setVisible(true);
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        addChatLieu adm = new addChatLieu();
        adm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adm.setVisible(true);
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseEntered

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        addThuongHieu adm = new addThuongHieu();
        adm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adm.setVisible(true);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        addMauSac adm = new addMauSac();
        adm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adm.setVisible(true);
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        addNSX adm = new addNSX();
        adm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adm.setVisible(true);
    }//GEN-LAST:event_jLabel19MouseClicked

    private void myButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myButton1MouseClicked
        loadThuocTinh();
        JOptionPane.showMessageDialog(this, "Lam mới thành công !");
    }//GEN-LAST:event_myButton1MouseClicked

    private void cbo_danhmucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_danhmucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_danhmucActionPerformed

    private void cboMaSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMaSpActionPerformed

        String maSp = cboMaSp.getSelectedItem() + "";
        List<SanPham> list = sanPhamService.getListSP();
        for (SanPham sanPham : list) {
            if (sanPham.getMaSp().equalsIgnoreCase(maSp)) {
                lbTenSP.setText(sanPham.getTenSP());
            }
        }
    }//GEN-LAST:event_cboMaSpActionPerformed

    private void txt_motaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_motaMouseClicked
        System.out.println(getIdSPXem());
    }//GEN-LAST:event_txt_motaMouseClicked

    private void xemSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xemSpActionPerformed
            List<SanPhamCT> list = sanPhamService.getAll();
            DefaultTableModel model = (DefaultTableModel) tblList.getModel();
        model.setRowCount(0);
            if (this.getIdSPXem()==null) {
            JOptionPane.showMessageDialog(this, "Ban Chua chon San Pham tai SanphamView");
        } else {
                 for (SanPhamCT sanPham : list) {
            if (sanPham.getIdSP().equalsIgnoreCase(this.getIdSPXem())) {
                Object rowData[] = {sanPham.getId(), loadMaSp(sanPham.getIdSP()), loadTenSp(sanPham.getIdSP()), getTenDanhMuc(sanPham.getIdDanhMuc()),
                getTenMau(sanPham.getIdMauSac()), getTenSize(sanPham.getIdKichco()), getTenThuongHieu(sanPham.getIdThuongHieu()), getTenChatLieu(sanPham.getIdChatLieu()),
                sanPham.getSoLuongTon(), sanPham.getGiaNhap(), sanPham.getGiaBan(), sanPham.getMota()};
            model.addRow(rowData);
            }
        }
            }
       
    }//GEN-LAST:event_xemSpActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(san_PhamCT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(san_PhamCT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(san_PhamCT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(san_PhamCT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new san_PhamCT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.MyButton btn_capnhat;
    private swing.MyButton btn_lammoi;
    private swing.MyButton btn_them;
    private javax.swing.JComboBox<String> cboMaSp;
    private javax.swing.JComboBox<String> cbo_chatlieu;
    private javax.swing.JComboBox<String> cbo_danhmuc;
    private javax.swing.JComboBox<String> cbo_mausac;
    private javax.swing.JComboBox<String> cbo_nsx;
    private javax.swing.JComboBox<String> cbo_size;
    private javax.swing.JComboBox<String> cbo_thuonghieu1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbTenSP;
    private javax.swing.JLabel lb_Btn_Search;
    private swing.MyButton myButton1;
    private swing.PanelBorder panelBorder1;
    private swing.PanelBorder panelBorder2;
    private swing.PanelBorder panelBorder3;
    private swing.PanelGradiente panelGradiente1;
    private swing.SearchText searchText;
    private javax.swing.JTable tblList;
    private swing.MyTextField txt_giaban;
    private swing.MyTextField txt_gianhap;
    private javax.swing.JTextArea txt_mota;
    private swing.MyTextField txt_soluongton;
    private javax.swing.JButton xemSp;
    // End of variables declaration//GEN-END:variables
}
