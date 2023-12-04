/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import views.properties.KhachHang_BanHang;
import Model.DanhMuc;
import Model.GioHang;
import Model.HoaDon;
import Model.SanPham;
import Model.HoaDon1;
import Model.KhachHang;
import Model.SanPhamCT;
import Service.BanHangService;
import Serviceimpl.BanHangServiceImpl;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author H
 */
public class ban_Hang extends javax.swing.JFrame {

    BanHangService banHangService = new BanHangServiceImpl();
    san_PhamCT sanPhamView = new san_PhamCT();
    private static String idKHChon;

    /**
     * Creates new form ban_Hang
     */
    public ban_Hang() {
        initComponents();
        loadData();
    }

    private void loadData() {
        DefaultTableModel model1 = (DefaultTableModel) tb_sanPham.getModel();
        model1.setRowCount(0);
        List<SanPhamCT> listSp = banHangService.getListSP();
        for (SanPhamCT sanPham : listSp) {
            Object rowData[] = {sanPham.getId(), sanPhamView.loadMaSp(sanPham.getIdSP()), sanPhamView.loadTenSp(sanPham.getIdSP()),
                sanPhamView.getTenMau(sanPham.getIdMauSac()),
                sanPhamView.getTenThuongHieu(sanPham.getIdThuongHieu()),
                sanPhamView.getTenSize(sanPham.getIdKichco()),
                sanPham.getGiaBan(),
                sanPham.getSoLuongTon()};
            model1.addRow(rowData);
        }
        DefaultTableModel model2 = (DefaultTableModel) tb_hoaDon.getModel();
        model2.setRowCount(0);
        List<HoaDon> listHD = banHangService.getListHD();
        for (HoaDon hd : listHD) {
            String tinhtrang = hd.getTinhTrang() == 1 ? "Đã thanh toán" : "Chưa thanh toán";
            if (tinhtrang.equalsIgnoreCase("Chưa thanh toán")) {
                Object rowData[] = {
                hd.getMa(),
                hd.getNgayTao(),
                hd.getIdNV(),
                tinhtrang
            };
                model2.addRow(rowData);
            }
            
        }
        DefaultComboBoxModel danhmucBoxModel = (DefaultComboBoxModel) cb_danhMuc.getModel();
        List<DanhMuc> listDanhMuc = banHangService.getListDanhMuc();
        for (DanhMuc danhMuc : listDanhMuc) {
            danhmucBoxModel.addElement(danhMuc.getTenDanhMuc());
        }

        DefaultTableModel model3 = (DefaultTableModel) tb_gioHang.getModel();
        model3.setRowCount(0);
        List<GioHang> listGioHang = banHangService.getListGioHang();
        for (GioHang gioHang : listGioHang) {
            Object rowData[] = {gioHang.getId(), sanPhamView.loadMaSp(sanPhamView.getIDSP1(gioHang.getIdSP() + "")),
                sanPhamView.loadTenSp(sanPhamView.getIDSP1(gioHang.getIdSP() + "")),
                sanPhamView.getTenMau(sanPhamView.getIDSP1(gioHang.getIdSP() + "")),
                sanPhamView.getTenThuongHieu(sanPhamView.getIDSP1(gioHang.getIdSP() + "")),
                sanPhamView.getTenSize(sanPhamView.getIDSP1(gioHang.getIdSP() + "")),
                gioHang.getSoLuong(),
                sanPhamView.getGiaBan1(gioHang.getIdSP() + ""),
                gioHang.getTongTien()
            };

            model3.addRow(rowData);
        }
    }

    private boolean addGioHang() {
        GioHang gioHang = new GioHang();
        int idSp;
        try {
            idSp = Integer.parseInt(tb_sanPham.getValueAt(tb_sanPham.getSelectedRow(), 0) + "");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Chưa chọn sản phẩm muốn mua");
            return false;
        }

        int soLuong;
        try {
//            soLuong = Integer.parseInt(txtSoLuong.getText());
                soLuong = Integer.parseInt(JOptionPane.showInputDialog("nhập số lượng muốn mua",DISPOSE_ON_CLOSE));
            if (soLuong > 0) {
                gioHang.setSoLuong(soLuong);
            } else {
                JOptionPane.showMessageDialog(this, "So luong nhap khong hop le");
                return false;
            }
        } catch (Exception e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(this, "So luong nhap khong hop le2");
            return false;
        }
        float tongTien = sanPhamView.getGiaBan1(idSp + "");
        System.out.println(tongTien);
        gioHang.setIdSP(idSp);
        gioHang.setTongTien(tongTien);
        if (banHangService.addGioHang(gioHang)) {
            JOptionPane.showMessageDialog(this, "thêm vào giỏ hàng thành công !");
            loadData();
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "thêm vào giỏ hàng thất bại !");
            return false;
        }

    }

    private boolean addHoaDon() {
        HoaDon hoaDon = new HoaDon();
        if (idKHChon == null) {
            JOptionPane.showMessageDialog(this, "Chưa chọn khách hàng");
            return false;
        }
        hoaDon.setIdKH(Integer.parseInt(idKHChon));
        hoaDon.setIdNV(5);
        Random random = new Random();
        hoaDon.setMa("HD-" + random.nextInt(90000000));
        hoaDon.setNgayThanhToan(null);
        hoaDon.setTinhTrang(0);
        hoaDon.setGhiChu(txt_ghiChu.getText());
        Float tongtien=Float.parseFloat(0+"");
        try {
            List<GioHang> list = banHangService.getListGioHang();
            int[] selectedRows = tb_gioHang.getSelectedRows();

                // Print selected rows
                for (GioHang gioHang : list) {
                for (int row : selectedRows) {
                    int idGioHang = gioHang.getId();
                    int idSelected = Integer.parseInt(tb_gioHang.getValueAt(row, 0)+"");
                    if (idGioHang==idSelected) {
                        tongtien += gioHang.getTongTien();
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Chưa chọn sản phẩm trong giỏ");
            return false;
        }
        hoaDon.setTongTien(tongtien);
//        System.out.println(hoaDon.getTongTien());
        try {
            if (banHangService.addHoaDon(hoaDon)) {
                JOptionPane.showMessageDialog(this, "Thêm hóa đơn thành công!");
                return true;
            }
            JOptionPane.showMessageDialog(this, "Thêm hóa đơn thất bại!");
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Thêm hóa đơn thất bại!");
            return false;
        }

    }

    private void loadHDToThanhToan() {
        List<HoaDon> list = banHangService.getAllHoaDon();
        String maHDSelect = tb_hoaDon.getValueAt(tb_hoaDon.getSelectedRow(), 0) + "";
        for (HoaDon hoaDon : list) {
            if (hoaDon.getMa().equalsIgnoreCase(maHDSelect)) {
                Float tongtien = hoaDon.getTongTien();
                lbl_tongTien1.setText(tongtien + "");
                Float giaGiam = Float.valueOf(lbl_giamGia1.getText());
                Float giaPhaiTra = (tongtien - giaGiam);
                lbl_thanhTien.setText(giaPhaiTra + "");

            }
        }
    }

    private float handlePay() {
        float tienthua;
        String a = txt_tienKhachDua.getText();
        try {
            float tienkhachDua = Float.parseFloat(a);
            System.out.println(tienkhachDua);
            float tienKhachcanTra = Float.parseFloat(lbl_thanhTien.getText());
            tienthua = tienkhachDua - tienKhachcanTra;
            if (tienthua >= 0) {
                lbl_tienThua.setText(tienthua + "");
            } else {
                lbl_tienThua.setText("Chưa đưa đủ");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "tien nhap khong hop le");
            return -1;
        }
        return tienthua;
    }

    private boolean thanhtoan() {
        String maHD;
        if (handlePay() >= 0 && !lb_SdtKh.getText().equals(" ")) {
            try {
                maHD = tb_hoaDon.getValueAt(tb_hoaDon.getSelectedRow(), 0) + "";
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "chưa chọn hóa đơn cần thanh toan");
                return false;
            }
            try {
                if (banHangService.thanhToan(maHD)) {
                    JOptionPane.showMessageDialog(this, "Thanh toan thanh cong");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(this, "Tien khach dua ko chinh xac");
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        } else {
           
                JOptionPane.showMessageDialog(this, "Chưa chọn khách hàng hoặc tiền gửi không hợp lệ");
                return false;
            
        }
    }

    private boolean xoaGioHang() {
        String idGioHang;
        try {
            idGioHang = tb_gioHang.getValueAt(tb_gioHang.getSelectedRow(), 0) + "";
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "chưa chọn giỏ hàng cần xóa");
            return false;
        }
        try {
            banHangService.deleteGioHang(idGioHang);
            JOptionPane.showMessageDialog(this, "Xoa thanh cong");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Xoa that bai");
            e.printStackTrace();
            return false;
        }
    }

    private boolean updateSLSP() {
        int SLSPmoi;
        try {
            SLSPmoi = Integer.parseInt(JOptionPane.showInputDialog("Nhap so luong muon sua"));
            if (SLSPmoi <= 0) {
                JOptionPane.showMessageDialog(this, "so luong khong hop le");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "so luong khong hop le");
            return false;
        }
        int idSP;
        int SoLuongHtai;

        try {
            idSP = Integer.parseInt(tb_gioHang.getValueAt(tb_gioHang.getSelectedRow(), 0) + "");
            SoLuongHtai = Integer.parseInt(tb_gioHang.getValueAt(tb_gioHang.getSelectedRow(), 3) + "");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Chua chon Gio Hang can Sua");
            e.printStackTrace();
            return false;
        }
        System.out.println(idSP);
        System.out.println(SLSPmoi);

        if (banHangService.updateSoLuongGioHang(idSP, SLSPmoi)) {
            JOptionPane.showMessageDialog(this, "Sua thanh cong");
            return true;
        }

        return true;
    }

//    private void handleBillPaid() {
//        List<HoaDon> list = banHangService.getHoaDonDaThanhToan();
//        for (HoaDon hoaDon : list) {
//            banHangService.addHoaDonDaThanhToan(hoaDon);
//        }
//    }

//    private void deleteHDDaThanhToan() {
//        try {
//            banHangService.deleteHoaDonDaThanhToan();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "thanh cong");
//        }
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        panelGradiente1 = new swing.PanelGradiente();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_sanPham = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cb_danhMuc = new javax.swing.JComboBox<>();
        panelBorder1 = new swing.PanelBorder();
        txtSearchText = new swing.SearchText();
        jLabel3 = new javax.swing.JLabel();
        btnThemGioHang = new javax.swing.JButton();
        cb_thuonghieu = new javax.swing.JComboBox<>();
        cb_mausac = new javax.swing.JComboBox<>();
        panelGradiente2 = new swing.PanelGradiente();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_gioHang = new javax.swing.JTable();
        btn_xoa = new swing.MyButton();
        btn_clear = new swing.MyButton();
        panelGradiente3 = new swing.PanelGradiente();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_hoaDon = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        panelGradiente4 = new swing.PanelGradiente();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_diem = new swing.MyTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_tienKhachDua = new swing.MyTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txt_ghiChu = new javax.swing.JTextArea();
        chk_inHoaDon = new javax.swing.JCheckBox();
        btn_thanhToan = new swing.MyButton();
        btn_suDung = new swing.MyButton();
        lbl_thanhTien = new javax.swing.JLabel();
        lbl_tienThua = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbl_tongTien1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbl_giamGia1 = new javax.swing.JLabel();
        myButton9 = new swing.MyButton();
        lbl_tenKhachHang = new javax.swing.JLabel();
        lbl_diemThuong = new javax.swing.JLabel();
        btn_thayDoi = new swing.MyButton();
        jLabel6 = new javax.swing.JLabel();
        lbl_sdt = new javax.swing.JLabel();
        btn_taoHoaDon = new swing.MyButton();
        lb_SdtKh = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1010, 640));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1010, 640));
        jPanel1.setName(""); // NOI18N

        panelGradiente1.setColorPrimario(new java.awt.Color(204, 255, 255));
        panelGradiente1.setColorSecundario(new java.awt.Color(255, 204, 255));

        tb_sanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "IDSp", "Mã SP", "Tên SP", "Mằu Sắc", "Thương hiệu", "Kích Cỡ", "Giá Bán", "Số Lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_sanPham.setGridColor(new java.awt.Color(255, 255, 255));
        tb_sanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_sanPhamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_sanPham);

        panelGradiente1.add(jScrollPane2);
        jScrollPane2.setBounds(10, 100, 580, 140);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Sản phẩm");
        panelGradiente1.add(jLabel1);
        jLabel1.setBounds(10, 0, 100, 15);

        cb_danhMuc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 2));
        cb_danhMuc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_danhMucItemStateChanged(evt);
            }
        });
        cb_danhMuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb_danhMucMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cb_danhMucMouseEntered(evt);
            }
        });
        cb_danhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_danhMucActionPerformed(evt);
            }
        });
        panelGradiente1.add(cb_danhMuc);
        cb_danhMuc.setBounds(270, 60, 100, 30);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        txtSearchText.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSearchTextCaretUpdate(evt);
            }
        });
        panelBorder1.add(txtSearchText);
        txtSearchText.setBounds(10, 0, 180, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search_24px.png"))); // NOI18N
        jLabel3.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel3AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
        });
        panelBorder1.add(jLabel3);
        jLabel3.setBounds(194, 0, 40, 30);

        panelGradiente1.add(panelBorder1);
        panelBorder1.setBounds(10, 20, 230, 30);

        btnThemGioHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/shopping-cart.png"))); // NOI18N
        btnThemGioHang.setText("Thêm ");
        btnThemGioHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemGioHangActionPerformed(evt);
            }
        });
        panelGradiente1.add(btnThemGioHang);
        btnThemGioHang.setBounds(500, 40, 100, 40);

        cb_thuonghieu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 2));
        cb_thuonghieu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_thuonghieuItemStateChanged(evt);
            }
        });
        cb_thuonghieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb_thuonghieuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cb_thuonghieuMouseEntered(evt);
            }
        });
        cb_thuonghieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_thuonghieuActionPerformed(evt);
            }
        });
        panelGradiente1.add(cb_thuonghieu);
        cb_thuonghieu.setBounds(50, 60, 100, 30);

        cb_mausac.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 2));
        cb_mausac.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_mausacItemStateChanged(evt);
            }
        });
        cb_mausac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb_mausacMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cb_mausacMouseEntered(evt);
            }
        });
        cb_mausac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_mausacActionPerformed(evt);
            }
        });
        panelGradiente1.add(cb_mausac);
        cb_mausac.setBounds(160, 60, 100, 30);

        panelGradiente2.setColorPrimario(new java.awt.Color(204, 255, 255));
        panelGradiente2.setColorSecundario(new java.awt.Color(255, 204, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("Giỏ hàng");
        panelGradiente2.add(jLabel2);
        jLabel2.setBounds(10, 10, 55, 10);

        tb_gioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "IdGioHang", "Mã SP", "Tên SP", "Màu sắc", "Brand", "Kích cỡ", "Số Lượng", "Đơn Giá", "Thành Tiền"
            }
        ));
        tb_gioHang.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(tb_gioHang);

        panelGradiente2.add(jScrollPane3);
        jScrollPane3.setBounds(10, 30, 580, 120);

        btn_xoa.setBackground(new java.awt.Color(125, 224, 237));
        btn_xoa.setText("Xóa (Giỏ Hàng)");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });
        panelGradiente2.add(btn_xoa);
        btn_xoa.setBounds(120, 160, 120, 30);

        btn_clear.setBackground(new java.awt.Color(125, 224, 237));
        btn_clear.setText("Sửa số lượng(Giỏ)");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });
        panelGradiente2.add(btn_clear);
        btn_clear.setBounds(310, 160, 130, 30);

        panelGradiente3.setColorPrimario(new java.awt.Color(204, 255, 255));
        panelGradiente3.setColorSecundario(new java.awt.Color(255, 204, 255));

        tb_hoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã HD", "Ngày Tạo", "Nhân Viên", "Trạng Thái"
            }
        ));
        tb_hoaDon.setGridColor(new java.awt.Color(255, 255, 255));
        tb_hoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_hoaDonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tb_hoaDonMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tb_hoaDon);

        panelGradiente3.add(jScrollPane1);
        jScrollPane1.setBounds(10, 30, 580, 140);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("Hóa đơn chờ");
        jLabel4.setToolTipText("");
        panelGradiente3.add(jLabel4);
        jLabel4.setBounds(10, 0, 90, 15);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelGradiente2, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelGradiente3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(479, 479, 479))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelGradiente1, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelGradiente3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(panelGradiente2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelGradiente1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 640));

        panelGradiente4.setColorPrimario(new java.awt.Color(204, 255, 255));
        panelGradiente4.setColorSecundario(new java.awt.Color(255, 204, 255));
        panelGradiente4.setMinimumSize(new java.awt.Dimension(1010, 640));
        panelGradiente4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("Thanh toán");
        jLabel5.setToolTipText("");
        panelGradiente4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 120, -1));

        jLabel7.setText("Tên khách hàng");
        panelGradiente4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 100, 20));

        jLabel8.setText("SĐT khách hàng");
        panelGradiente4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 90, 20));

        txt_diem.setForeground(new java.awt.Color(0, 153, 153));
        panelGradiente4.add(txt_diem, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 250, 30));

        jLabel9.setText("Điểm thưởng");
        panelGradiente4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 250, 20));

        jLabel10.setText("Khách Hàng Được Điểm");
        panelGradiente4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 250, 20));

        jLabel11.setText("Khách Cần Trả");
        panelGradiente4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 90, 20));

        txt_tienKhachDua.setForeground(new java.awt.Color(255, 51, 51));
        txt_tienKhachDua.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_tienKhachDuaCaretUpdate(evt);
            }
        });
        txt_tienKhachDua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tienKhachDuaActionPerformed(evt);
            }
        });
        txt_tienKhachDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_tienKhachDuaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_tienKhachDuaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_tienKhachDuaKeyTyped(evt);
            }
        });
        panelGradiente4.add(txt_tienKhachDua, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 250, 30));

        jLabel12.setText("Tiền khách đưa");
        panelGradiente4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 110, 20));

        jLabel13.setText("Ghi chú");
        panelGradiente4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 250, 20));

        jLabel14.setText("Tiền thừa");
        panelGradiente4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 70, 20));

        txt_ghiChu.setColumns(20);
        txt_ghiChu.setRows(3);
        txt_ghiChu.setTabSize(0);
        txt_ghiChu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        jScrollPane4.setViewportView(txt_ghiChu);

        panelGradiente4.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 250, 60));

        chk_inHoaDon.setBackground(new java.awt.Color(255, 204, 255));
        chk_inHoaDon.setText("In hóa đơn");
        panelGradiente4.add(chk_inHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 100, -1));

        btn_thanhToan.setBackground(new java.awt.Color(125, 224, 237));
        btn_thanhToan.setForeground(new java.awt.Color(0, 51, 102));
        btn_thanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/credit-card.png"))); // NOI18N
        btn_thanhToan.setText("Thanh toán");
        btn_thanhToan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_thanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thanhToanActionPerformed(evt);
            }
        });
        panelGradiente4.add(btn_thanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 590, 260, 40));

        btn_suDung.setBackground(new java.awt.Color(125, 224, 237));
        btn_suDung.setText("Sử dụng");
        btn_suDung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suDungActionPerformed(evt);
            }
        });
        panelGradiente4.add(btn_suDung, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 100, 30));

        lbl_thanhTien.setForeground(new java.awt.Color(255, 51, 51));
        lbl_thanhTien.setText("0");
        panelGradiente4.add(lbl_thanhTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 130, 20));

        lbl_tienThua.setForeground(new java.awt.Color(0, 153, 153));
        panelGradiente4.add(lbl_tienThua, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 240, 20));

        jLabel15.setText("Tổng tiền");
        panelGradiente4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 60, 20));

        lbl_tongTien1.setForeground(new java.awt.Color(255, 51, 51));
        lbl_tongTien1.setText("0");
        panelGradiente4.add(lbl_tongTien1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 140, 20));

        jLabel16.setText("Giảm Giá");
        panelGradiente4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 60, 20));

        lbl_giamGia1.setForeground(new java.awt.Color(255, 51, 51));
        lbl_giamGia1.setText("0");
        panelGradiente4.add(lbl_giamGia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 160, 20));

        myButton9.setBackground(new java.awt.Color(125, 224, 237));
        myButton9.setText("Làm Mới");
        myButton9.setMaximumSize(new java.awt.Dimension(101, 25));
        myButton9.setMinimumSize(new java.awt.Dimension(101, 25));
        myButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton9ActionPerformed(evt);
            }
        });
        panelGradiente4.add(myButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 540, 110, 30));

        lbl_tenKhachHang.setForeground(new java.awt.Color(0, 153, 153));
        panelGradiente4.add(lbl_tenKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 150, 20));

        lbl_diemThuong.setForeground(new java.awt.Color(255, 51, 51));
        panelGradiente4.add(lbl_diemThuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 220, 20));

        btn_thayDoi.setBackground(new java.awt.Color(125, 224, 237));
        btn_thayDoi.setText("Khách Hàng");
        btn_thayDoi.setRolloverEnabled(false);
        btn_thayDoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thayDoiActionPerformed(evt);
            }
        });
        panelGradiente4.add(btn_thayDoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 100, 30));
        panelGradiente4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 220, -1));

        lbl_sdt.setForeground(new java.awt.Color(0, 153, 153));
        panelGradiente4.add(lbl_sdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 220, -1));

        btn_taoHoaDon.setBackground(new java.awt.Color(125, 224, 237));
        btn_taoHoaDon.setText("Tạo Hoá Đơn");
        btn_taoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taoHoaDonActionPerformed(evt);
            }
        });
        panelGradiente4.add(btn_taoHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 110, 30));

        lb_SdtKh.setForeground(new java.awt.Color(0, 153, 153));
        lb_SdtKh.setText(" ");
        panelGradiente4.add(lb_SdtKh, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 140, 20));

        getContentPane().add(panelGradiente4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, 430, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_tienKhachDuaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_tienKhachDuaCaretUpdate

    }//GEN-LAST:event_txt_tienKhachDuaCaretUpdate

    private void btn_thanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thanhToanActionPerformed
        thanhtoan();
//        handleBillPaid();
//        deleteHDDaThanhToan();
        loadData();
    }//GEN-LAST:event_btn_thanhToanActionPerformed

    private void btn_suDungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suDungActionPerformed
      

    }//GEN-LAST:event_btn_suDungActionPerformed

    private void myButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton9ActionPerformed

    }//GEN-LAST:event_myButton9ActionPerformed

    private void btn_thayDoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thayDoiActionPerformed

        KhachHang_BanHang khbh = new KhachHang_BanHang();

// Add a WindowListener to listen for window closing event
        khbh.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                SwingUtilities.invokeLater(() -> {
                    // Get the idkh value after the KhachHang_BanHang form is closed
                    String idkh = khbh.getIdkh();
                    System.out.println(idkh);

                    KhachHang kh = banHangService.getKhById(idkh);
                    lbl_tenKhachHang.setText(kh.getHo() + " " + kh.getTendem() + " " + kh.getTen());
                    lb_SdtKh.setText(kh.getSdt());
                    idKHChon = idkh;

                });

            }

        });

// Show the KhachHang_BanHang form
//khbh.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            khbh.setVisible(true);
//        khbh.setVisible(true);


    }//GEN-LAST:event_btn_thayDoiActionPerformed

    private void btn_taoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taoHoaDonActionPerformed
       
            
        if (addHoaDon()) {
            int[] id = tb_gioHang.getSelectedRows();
            for (int i : id) {
                String idDelete = tb_gioHang.getValueAt(i, 0)+"";
                banHangService.deleteGioHang(idDelete);
            }
            
        }
        
        loadData();

    }//GEN-LAST:event_btn_taoHoaDonActionPerformed

    private void tb_hoaDonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_hoaDonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_hoaDonMouseEntered

    private void tb_hoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_hoaDonMouseClicked
        loadHDToThanhToan();
    }//GEN-LAST:event_tb_hoaDonMouseClicked

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        updateSLSP();
        loadData();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        xoaGioHang();
        loadData();
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btnThemGioHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemGioHangActionPerformed
        addGioHang();

    }//GEN-LAST:event_btnThemGioHangActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        DefaultTableModel model = (DefaultTableModel) tb_sanPham.getModel();
        model.setRowCount(0);
        List<SanPhamCT> listSp = banHangService.getListSP();

        for (SanPhamCT sanPham : listSp) {
            if (sanPhamView.loadTenSp(sanPham.getIdSP()).contains(txtSearchText.getText())) {
                Object rowData[] = {sanPham.getId(), sanPhamView.loadMaSp(sanPham.getIdSP()), sanPhamView.loadTenSp(sanPham.getIdSP()),
                    sanPhamView.getTenMau(sanPham.getIdMauSac()),
                    sanPhamView.getTenThuongHieu(sanPham.getIdThuongHieu()),
                    sanPhamView.getTenSize(sanPham.getIdKichco()),
                    sanPham.getGiaBan(),
                    sanPham.getSoLuongTon()};
                model.addRow(rowData);
            }
        }
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel3AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel3AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3AncestorAdded

    private void txtSearchTextCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSearchTextCaretUpdate

    }//GEN-LAST:event_txtSearchTextCaretUpdate

    private void cb_danhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_danhMucActionPerformed
        DefaultTableModel model1 = (DefaultTableModel) tb_sanPham.getModel();
        model1.setRowCount(0);
        String idDanhMuc = "";

        List<DanhMuc> listDM = banHangService.getListDanhMuc();
        for (DanhMuc danhMuc : listDM) {
            String category = cb_danhMuc.getSelectedItem() + "";
            if (danhMuc.getTenDanhMuc().equalsIgnoreCase(category)) {
                idDanhMuc = danhMuc.getIdDanhMuc();
            }
        }
        List<SanPhamCT> listSp = banHangService.getListSP();
        for (SanPhamCT sanPham : listSp) {

            if (sanPham.getIdDanhMuc().equalsIgnoreCase(idDanhMuc)) {
                Object rowData[] = {sanPham.getId(), sanPhamView.loadMaSp(sanPham.getIdSP()), sanPhamView.loadTenSp(sanPham.getIdSP()),
                    sanPhamView.getTenMau(sanPham.getIdMauSac()),
                    sanPhamView.getTenThuongHieu(sanPham.getIdThuongHieu()),
                    sanPhamView.getTenSize(sanPham.getIdKichco()),
                    sanPham.getGiaBan(),
                    sanPham.getSoLuongTon()};
                model1.addRow(rowData);
            }
        }
    }//GEN-LAST:event_cb_danhMucActionPerformed

    private void cb_danhMucMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_danhMucMouseEntered

    }//GEN-LAST:event_cb_danhMucMouseEntered

    private void cb_danhMucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_danhMucMouseClicked

    }//GEN-LAST:event_cb_danhMucMouseClicked

    private void cb_danhMucItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_danhMucItemStateChanged

    }//GEN-LAST:event_cb_danhMucItemStateChanged

    private void tb_sanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_sanPhamMouseClicked

    }//GEN-LAST:event_tb_sanPhamMouseClicked

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseEntered

    private void txt_tienKhachDuaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tienKhachDuaKeyPressed
//        try {
//            Float tienKhTra = Float.parseFloat(txt_tienKhachDua.getText());
//            System.out.println(tienKhTra);
//            tongTien = Float.parseFloat(lbl_thanhTien.getText());
//
//            System.out.println(tongTien);
//            Float tienThua = tienKhTra - tongTien;
//            if (tienThua > 0) {
//                lbl_tienThua.setText(tienThua + "");
//            } else {
//                lbl_tienThua.setText(0 + "");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
////            JOptionPane.showMessageDialog(this, "Tien nhap khong hop le");
//        }
    }//GEN-LAST:event_txt_tienKhachDuaKeyPressed

    private void txt_tienKhachDuaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tienKhachDuaKeyTyped

    }//GEN-LAST:event_txt_tienKhachDuaKeyTyped

    private void txt_tienKhachDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tienKhachDuaKeyReleased
        handlePay();

    }//GEN-LAST:event_txt_tienKhachDuaKeyReleased

    private void txt_tienKhachDuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tienKhachDuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tienKhachDuaActionPerformed

    private void cb_thuonghieuItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_thuonghieuItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_thuonghieuItemStateChanged

    private void cb_thuonghieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_thuonghieuMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_thuonghieuMouseClicked

    private void cb_thuonghieuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_thuonghieuMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_thuonghieuMouseEntered

    private void cb_thuonghieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_thuonghieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_thuonghieuActionPerformed

    private void cb_mausacItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_mausacItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_mausacItemStateChanged

    private void cb_mausacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_mausacMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_mausacMouseClicked

    private void cb_mausacMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_mausacMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_mausacMouseEntered

    private void cb_mausacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_mausacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_mausacActionPerformed

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
            java.util.logging.Logger.getLogger(ban_Hang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ban_Hang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ban_Hang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ban_Hang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ban_Hang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThemGioHang;
    private swing.MyButton btn_clear;
    private swing.MyButton btn_suDung;
    private swing.MyButton btn_taoHoaDon;
    private swing.MyButton btn_thanhToan;
    private swing.MyButton btn_thayDoi;
    private swing.MyButton btn_xoa;
    private javax.swing.JComboBox<String> cb_danhMuc;
    private javax.swing.JComboBox<String> cb_mausac;
    private javax.swing.JComboBox<String> cb_thuonghieu;
    private javax.swing.JCheckBox chk_inHoaDon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lb_SdtKh;
    private javax.swing.JLabel lbl_diemThuong;
    private javax.swing.JLabel lbl_giamGia1;
    private javax.swing.JLabel lbl_sdt;
    private javax.swing.JLabel lbl_tenKhachHang;
    private javax.swing.JLabel lbl_thanhTien;
    private javax.swing.JLabel lbl_tienThua;
    private javax.swing.JLabel lbl_tongTien1;
    private swing.MyButton myButton9;
    private swing.PanelBorder panelBorder1;
    private swing.PanelGradiente panelGradiente1;
    private swing.PanelGradiente panelGradiente2;
    private swing.PanelGradiente panelGradiente3;
    private swing.PanelGradiente panelGradiente4;
    private javax.swing.JTable tb_gioHang;
    private javax.swing.JTable tb_hoaDon;
    private javax.swing.JTable tb_sanPham;
    private swing.SearchText txtSearchText;
    private swing.MyTextField txt_diem;
    private javax.swing.JTextArea txt_ghiChu;
    private swing.MyTextField txt_tienKhachDua;
    // End of variables declaration//GEN-END:variables
}
