/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Model.KhachHang;
import Serviceimpl.KhachHangService_IMPL;
import Model.KhachHang;
import Model.KhachHang02;
import Service.KhachHangService;
/**
 *
 * @author H
 */
public class Khach_Hangg extends javax.swing.JFrame {
DefaultTableModel defaultTableModel = new DefaultTableModel();
    List<KhachHang> listKhachHang;
    List<KhachHang02> listKhachHang01;

    KhachHangService khsv = new KhachHangService_IMPL();
    private KhachHangService KH;
    /**
     * Creates new form home
     */
    public Khach_Hangg() {
         initComponents();
        setLocationRelativeTo(null);
        KH = new KhachHangService_IMPL();
        listKhachHang = KH.getall();
        showTable(listKhachHang);
        TXT_01.setText("Tổng số khách hàng là : " + listKhachHang.size());

    }
public void showTable(List<KhachHang> list) {
        defaultTableModel = (DefaultTableModel) TB_bang1.getModel();
        defaultTableModel.setRowCount(0);
        for (KhachHang khachHang01 : list) {
            defaultTableModel.addRow(khachHang01.toDataRow());
        }
    }

    public void showTable2(List<KhachHang02> list01) {
        defaultTableModel = (DefaultTableModel) TB_bang02.getModel();
        defaultTableModel.setRowCount(0);
        for (KhachHang02 khachHang01 : list01) {
            defaultTableModel.addRow(khachHang01.toDataRow());
        }
    }

    public void showTable3(List<KhachHang02> list01) {
        int id = layid();
        defaultTableModel = (DefaultTableModel) TB_bang02.getModel();
        defaultTableModel.setRowCount(0);
        for (KhachHang02 khachHangViewMD : KH.GetTKTheoIDKH(id)) {
            defaultTableModel.addRow(khachHangViewMD.toDataRow());
        }
    }

    private KhachHang getData() {
        KhachHang cv = new KhachHang();
        cv.setTen(txt_Ten.getText());
        cv.setTendem(txt_tenDem.getText());
        cv.setHo(txt_Ho.getText());
        int gt;
        if (rd_Nam.isSelected()) {
            gt = 0;
        } else {
            gt = 1;
        }
        cv.setGioitinh(gt);
        cv.setNgaysinh(date_ngaysinh1.getDate());
        cv.setSdt(txt_sdt.getText());
        cv.setEmail(txt_email.getText());

        return cv;
    }

    public int layid() {
        Integer row = TB_bang1.getSelectedRow();
        int id = Integer.parseInt(TB_bang1.getValueAt(row, 0).toString());
        return id;

    }

    public boolean check() {
        String sdt = "(0\\d{9})";
        String mail = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern p = Pattern.compile("^[0-9]+$");
        if (txt_Ten.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên!");
            return false;
        }
        if (p.matcher(txt_Ten.getText()).find() == true) {
            JOptionPane.showMessageDialog(this, "Tên của bạn không được nhập số");
            return false;
        }
        if (txt_Ten.getText().length() > 30) {
            JOptionPane.showMessageDialog(this, "Tên không được quá 30 kí tự");
            return false;
        }

        if (txt_sdt.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập SĐT!");
            return false;
        }
        try {
            if (!txt_sdt.getText().matches(sdt)) {
                JOptionPane.showMessageDialog(this, "Số điện thoại của bạn chưa đúng định dạng");
                return false;
            }
        } catch (Exception e) {
        }

        if (KH.kiemtrasdt(txt_sdt.getText()) != null) {
            JOptionPane.showMessageDialog(this, "Số điện thoại của bạn đã tồn tại");
            return false;
        } else if (txt_email.getText().equals("")) {
            return true;
        } else {
            try {

                if (!txt_email.getText().matches(mail)) {
                    JOptionPane.showMessageDialog(this, "Email của bạn chưa đúng định dạng");
                    return false;
                }
                if (KH.kiemtra(txt_email.getText()) != null) {
                    JOptionPane.showMessageDialog(this, "Email đã tồn tại");
                    return false;
                }

            } catch (Exception e) {
            }
        }

        return true;

    }

    public boolean check2() {
        Pattern p = Pattern.compile("^[0-9]+$");

        if (txt_Ho.getText() == null & txt_tenDem.getText() == null) {
            return true;
        } else {

            if (p.matcher(txt_Ho.getText()).find() == true) {
                JOptionPane.showMessageDialog(this, "Họ của bạn không được nhập số");
                return false;
            }
            if (txt_Ho.getText().length() > 30) {
                JOptionPane.showMessageDialog(this, "Họ không được quá 30 kí tự");
                return false;
            }
            if (p.matcher(txt_tenDem.getText()).find() == true) {
                JOptionPane.showMessageDialog(this, "Tên đệm của bạn không được nhập số");
                return false;
            }
            if (txt_tenDem.getText().length() > 30) {
                JOptionPane.showMessageDialog(this, "Tên Đệm không được quá 30 kí tự");
                return false;

            }
        }

        return true;
    }

    public boolean check3() {
        String sdt = "(0\\d{9})";
        String mail = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern p = Pattern.compile("^[0-9]+$");
        if (txt_Ten.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên!");
            return false;
        }
        if (p.matcher(txt_Ten.getText()).find() == true) {
            JOptionPane.showMessageDialog(this, "Tên của bạn không được nhập số");
            return false;
        }
        if (txt_Ten.getText().length() > 30) {
            JOptionPane.showMessageDialog(this, "Tên không được quá 30 kí tự");
            return false;
        }
        if (txt_sdt.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập SĐT!");
            return false;
        }
        try {
            if (!txt_sdt.getText().matches(sdt)) {
                JOptionPane.showMessageDialog(this, "Số điện thoại của bạn chưa đúng định dạng");
                return false;
            }
        } catch (Exception e) {
        }

        if (txt_email.getText().equals("")) {
            return true;
        } else {
            try {

                if (!txt_email.getText().matches(mail)) {
                    JOptionPane.showMessageDialog(this, "Email của bạn chưa đúng định dạng");
                    return false;
                }

            } catch (Exception e) {
            }
        }

        return true;

    }

    public boolean check4() {
        Pattern p = Pattern.compile("^[0-9]+$");

        if (txt_Ho.getText() == null & txt_tenDem.getText() == null) {
            return true;
        } else {

            if (p.matcher(txt_Ho.getText()).find() == true) {
                JOptionPane.showMessageDialog(this, "Họ của bạn không được nhập số");
                return false;
            }
            if (txt_Ho.getText().length() > 30) {
                JOptionPane.showMessageDialog(this, "Họ không được quá 30 kí tự");
                return false;
            }
            if (p.matcher(txt_tenDem.getText()).find() == true) {
                JOptionPane.showMessageDialog(this, "Tên đệm của bạn không được nhập số");
                return false;
            }
            if (txt_tenDem.getText().length() > 30) {
                JOptionPane.showMessageDialog(this, "Tên Đệm không được quá 30 kí tự");
                return false;

            }
        }

        return true;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lbltieude = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lbl_tenNhanVien = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnbanhang = new javax.swing.JPanel();
        crep1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnsanpham = new javax.swing.JPanel();
        crep2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnkhuyenmai = new javax.swing.JPanel();
        crep3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnkhachhang = new javax.swing.JPanel();
        crep4 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnnhanvien = new javax.swing.JPanel();
        crep5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnhoadon = new javax.swing.JPanel();
        crepp2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnthongke = new javax.swing.JPanel();
        crepp1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btndangxuat = new javax.swing.JPanel();
        crepp3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        pnmain = new javax.swing.JPanel();
        panelGradiente1 = new swing.PanelGradiente();
        panelBorder1 = new swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        txt_Ten = new swing.MyTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_tenDem = new swing.MyTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_Ho = new swing.MyTextField();
        jLabel14 = new javax.swing.JLabel();
        rd_nu = new javax.swing.JRadioButton();
        rd_Nam = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_sdt = new swing.MyTextField();
        jLabel17 = new javax.swing.JLabel();
        txt_email = new swing.MyTextField();
        btn_them = new swing.MyButton();
        Btn_capNhat = new swing.MyButton();
        btn_LamMoi = new swing.MyButton();
        date_ngaysinh1 = new com.toedter.calendar.JDateChooser();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TB_bang1 = new javax.swing.JTable();
        panelBorder3 = new swing.PanelBorder();
        Btn_timKiem1 = new javax.swing.JLabel();
        txt_timKiem01 = new swing.SearchText();
        TXT_01 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TB_bang02 = new javax.swing.JTable();
        btn_LamMoi1 = new swing.MyButton();
        LBL_SOLUONG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 255));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/power.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        lbltieude.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbltieude.setForeground(new java.awt.Color(255, 51, 51));
        lbltieude.setText("Bán hàng");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lbltieude, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 709, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbltieude, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(153, 153, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_tenNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_tenNhanVien.setForeground(new java.awt.Color(255, 0, 255));
        lbl_tenNhanVien.setText("TÊN NHÂN VIÊN");
        jPanel4.add(lbl_tenNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 140, 40));

        jLabel2.setForeground(new java.awt.Color(204, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user64px.png"))); // NOI18N
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 70, 80));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 160));

        btnbanhang.setBackground(new java.awt.Color(153, 153, 255));
        btnbanhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnbanhangMousePressed(evt);
            }
        });

        crep1.setBackground(new java.awt.Color(255, 255, 255));
        crep1.setOpaque(false);
        crep1.setPreferredSize(new java.awt.Dimension(3, 60));

        javax.swing.GroupLayout crep1Layout = new javax.swing.GroupLayout(crep1);
        crep1.setLayout(crep1Layout);
        crep1Layout.setHorizontalGroup(
            crep1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        crep1Layout.setVerticalGroup(
            crep1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/shopping32px.png"))); // NOI18N
        jLabel4.setText("Bán Hàng");

        javax.swing.GroupLayout btnbanhangLayout = new javax.swing.GroupLayout(btnbanhang);
        btnbanhang.setLayout(btnbanhangLayout);
        btnbanhangLayout.setHorizontalGroup(
            btnbanhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnbanhangLayout.createSequentialGroup()
                .addComponent(crep1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnbanhangLayout.setVerticalGroup(
            btnbanhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(crep1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.add(btnbanhang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 190, 60));

        btnsanpham.setBackground(new java.awt.Color(153, 153, 255));
        btnsanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnsanphamMousePressed(evt);
            }
        });

        crep2.setBackground(new java.awt.Color(255, 255, 255));
        crep2.setOpaque(false);
        crep2.setPreferredSize(new java.awt.Dimension(3, 60));

        javax.swing.GroupLayout crep2Layout = new javax.swing.GroupLayout(crep2);
        crep2.setLayout(crep2Layout);
        crep2Layout.setHorizontalGroup(
            crep2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        crep2Layout.setVerticalGroup(
            crep2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/product.png"))); // NOI18N
        jLabel5.setText("Sản Phẩm");

        javax.swing.GroupLayout btnsanphamLayout = new javax.swing.GroupLayout(btnsanpham);
        btnsanpham.setLayout(btnsanphamLayout);
        btnsanphamLayout.setHorizontalGroup(
            btnsanphamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnsanphamLayout.createSequentialGroup()
                .addComponent(crep2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnsanphamLayout.setVerticalGroup(
            btnsanphamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnsanphamLayout.createSequentialGroup()
                .addGroup(btnsanphamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(crep2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.add(btnsanpham, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 190, 60));

        btnkhuyenmai.setBackground(new java.awt.Color(153, 153, 255));
        btnkhuyenmai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnkhuyenmaiMousePressed(evt);
            }
        });

        crep3.setBackground(new java.awt.Color(255, 255, 255));
        crep3.setOpaque(false);
        crep3.setPreferredSize(new java.awt.Dimension(3, 60));

        javax.swing.GroupLayout crep3Layout = new javax.swing.GroupLayout(crep3);
        crep3.setLayout(crep3Layout);
        crep3Layout.setHorizontalGroup(
            crep3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        crep3Layout.setVerticalGroup(
            crep3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/coupon.png"))); // NOI18N
        jLabel6.setText("Khuyễn Mãi");

        javax.swing.GroupLayout btnkhuyenmaiLayout = new javax.swing.GroupLayout(btnkhuyenmai);
        btnkhuyenmai.setLayout(btnkhuyenmaiLayout);
        btnkhuyenmaiLayout.setHorizontalGroup(
            btnkhuyenmaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnkhuyenmaiLayout.createSequentialGroup()
                .addComponent(crep3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        btnkhuyenmaiLayout.setVerticalGroup(
            btnkhuyenmaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnkhuyenmaiLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(btnkhuyenmaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(crep3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel2.add(btnkhuyenmai, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 190, -1));

        btnkhachhang.setBackground(new java.awt.Color(153, 153, 255));
        btnkhachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnkhachhangMousePressed(evt);
            }
        });

        crep4.setBackground(new java.awt.Color(255, 255, 255));
        crep4.setMinimumSize(new java.awt.Dimension(100, 60));
        crep4.setOpaque(false);
        crep4.setPreferredSize(new java.awt.Dimension(3, 60));

        jPanel12.setMinimumSize(new java.awt.Dimension(100, 60));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout crep4Layout = new javax.swing.GroupLayout(crep4);
        crep4.setLayout(crep4Layout);
        crep4Layout.setHorizontalGroup(
            crep4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, crep4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(340, 340, 340))
        );
        crep4Layout.setVerticalGroup(
            crep4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crep4Layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/customer.png"))); // NOI18N
        jLabel7.setText("Khách Hàng");
        jLabel7.setRequestFocusEnabled(false);

        javax.swing.GroupLayout btnkhachhangLayout = new javax.swing.GroupLayout(btnkhachhang);
        btnkhachhang.setLayout(btnkhachhangLayout);
        btnkhachhangLayout.setHorizontalGroup(
            btnkhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnkhachhangLayout.createSequentialGroup()
                .addComponent(crep4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addGap(35, 35, 35))
        );
        btnkhachhangLayout.setVerticalGroup(
            btnkhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnkhachhangLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(btnkhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(crep4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel2.add(btnkhachhang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 190, -1));

        btnnhanvien.setBackground(new java.awt.Color(153, 153, 255));
        btnnhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnnhanvienMousePressed(evt);
            }
        });

        crep5.setBackground(new java.awt.Color(255, 255, 255));
        crep5.setOpaque(false);
        crep5.setPreferredSize(new java.awt.Dimension(3, 60));

        javax.swing.GroupLayout crep5Layout = new javax.swing.GroupLayout(crep5);
        crep5.setLayout(crep5Layout);
        crep5Layout.setHorizontalGroup(
            crep5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        crep5Layout.setVerticalGroup(
            crep5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jLabel3.setBackground(new java.awt.Color(0, 0, 128));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/id-card.png"))); // NOI18N
        jLabel3.setText("Nhân Viên");

        javax.swing.GroupLayout btnnhanvienLayout = new javax.swing.GroupLayout(btnnhanvien);
        btnnhanvien.setLayout(btnnhanvienLayout);
        btnnhanvienLayout.setHorizontalGroup(
            btnnhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnnhanvienLayout.createSequentialGroup()
                .addComponent(crep5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addGap(34, 34, 34))
        );
        btnnhanvienLayout.setVerticalGroup(
            btnnhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnnhanvienLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(btnnhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(crep5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel2.add(btnnhanvien, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 190, -1));

        btnhoadon.setBackground(new java.awt.Color(153, 153, 255));
        btnhoadon.setPreferredSize(new java.awt.Dimension(100, 60));
        btnhoadon.setRequestFocusEnabled(false);
        btnhoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnhoadonMousePressed(evt);
            }
        });

        crepp2.setBackground(new java.awt.Color(255, 255, 255));
        crepp2.setOpaque(false);
        crepp2.setPreferredSize(new java.awt.Dimension(3, 60));

        javax.swing.GroupLayout crepp2Layout = new javax.swing.GroupLayout(crepp2);
        crepp2.setLayout(crepp2Layout);
        crepp2Layout.setHorizontalGroup(
            crepp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        crepp2Layout.setVerticalGroup(
            crepp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/validating-ticket.png"))); // NOI18N
        jLabel9.setText("Hóa Đơn");

        javax.swing.GroupLayout btnhoadonLayout = new javax.swing.GroupLayout(btnhoadon);
        btnhoadon.setLayout(btnhoadonLayout);
        btnhoadonLayout.setHorizontalGroup(
            btnhoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnhoadonLayout.createSequentialGroup()
                .addComponent(crepp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 37, Short.MAX_VALUE))
        );
        btnhoadonLayout.setVerticalGroup(
            btnhoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnhoadonLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(btnhoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(crepp2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel2.add(btnhoadon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 190, -1));

        btnthongke.setBackground(new java.awt.Color(153, 153, 255));
        btnthongke.setForeground(new java.awt.Color(204, 255, 255));
        btnthongke.setPreferredSize(new java.awt.Dimension(210, 60));
        btnthongke.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnthongkeMousePressed(evt);
            }
        });
        btnthongke.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        crepp1.setBackground(new java.awt.Color(255, 255, 255));
        crepp1.setOpaque(false);
        crepp1.setPreferredSize(new java.awt.Dimension(3, 60));
        crepp1.setRequestFocusEnabled(false);

        javax.swing.GroupLayout crepp1Layout = new javax.swing.GroupLayout(crepp1);
        crepp1.setLayout(crepp1Layout);
        crepp1Layout.setHorizontalGroup(
            crepp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        crepp1Layout.setVerticalGroup(
            crepp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        btnthongke.add(crepp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/chart.png"))); // NOI18N
        jLabel10.setText("Thống Kê");
        btnthongke.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 140, 60));

        jPanel2.add(btnthongke, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 190, 60));

        btndangxuat.setBackground(new java.awt.Color(153, 153, 255));
        btndangxuat.setPreferredSize(new java.awt.Dimension(100, 60));
        btndangxuat.setRequestFocusEnabled(false);
        btndangxuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btndangxuatMousePressed(evt);
            }
        });

        crepp3.setBackground(new java.awt.Color(255, 255, 255));
        crepp3.setOpaque(false);
        crepp3.setPreferredSize(new java.awt.Dimension(3, 60));

        javax.swing.GroupLayout crepp3Layout = new javax.swing.GroupLayout(crepp3);
        crepp3.setLayout(crepp3Layout);
        crepp3Layout.setHorizontalGroup(
            crepp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        crepp3Layout.setVerticalGroup(
            crepp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        jLabel11.setText("  Đăng xuất");

        javax.swing.GroupLayout btndangxuatLayout = new javax.swing.GroupLayout(btndangxuat);
        btndangxuat.setLayout(btndangxuatLayout);
        btndangxuatLayout.setHorizontalGroup(
            btndangxuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btndangxuatLayout.createSequentialGroup()
                .addComponent(crepp3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        btndangxuatLayout.setVerticalGroup(
            btndangxuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btndangxuatLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(btndangxuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(crepp3, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );

        jPanel2.add(btndangxuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 190, 40));

        pnmain.setBackground(new java.awt.Color(255, 255, 255));
        pnmain.setLayout(new java.awt.BorderLayout());

        panelGradiente1.setColorPrimario(new java.awt.Color(204, 255, 255));
        panelGradiente1.setColorSecundario(new java.awt.Color(255, 204, 255));

        panelBorder1.setBackground(new java.awt.Color(204, 204, 255));
        panelBorder1.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Tên");
        panelBorder1.add(jLabel1);
        jLabel1.setBounds(90, 10, 210, 20);
        panelBorder1.add(txt_Ten);
        txt_Ten.setBounds(90, 30, 210, 30);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Tên đệm");
        panelBorder1.add(jLabel12);
        jLabel12.setBounds(90, 70, 210, 20);
        panelBorder1.add(txt_tenDem);
        txt_tenDem.setBounds(90, 90, 210, 30);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Họ");
        panelBorder1.add(jLabel13);
        jLabel13.setBounds(90, 130, 210, 20);
        panelBorder1.add(txt_Ho);
        txt_Ho.setBounds(90, 150, 210, 30);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Giới tính");
        panelBorder1.add(jLabel14);
        jLabel14.setBounds(90, 200, 48, 30);

        rd_nu.setBackground(new java.awt.Color(204, 204, 255));
        buttonGroup1.add(rd_nu);
        rd_nu.setText("Nữ");
        panelBorder1.add(rd_nu);
        rd_nu.setBounds(230, 200, 60, 30);

        rd_Nam.setBackground(new java.awt.Color(204, 204, 255));
        buttonGroup1.add(rd_Nam);
        rd_Nam.setSelected(true);
        rd_Nam.setText("Nam");
        rd_Nam.setToolTipText("");
        rd_Nam.setDoubleBuffered(true);
        panelBorder1.add(rd_Nam);
        rd_Nam.setBounds(157, 200, 60, 30);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Ngày sinh");
        panelBorder1.add(jLabel15);
        jLabel15.setBounds(390, 10, 210, 20);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("Số điện thoại");
        panelBorder1.add(jLabel16);
        jLabel16.setBounds(390, 70, 210, 20);
        panelBorder1.add(txt_sdt);
        txt_sdt.setBounds(390, 90, 210, 30);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("E-mail");
        panelBorder1.add(jLabel17);
        jLabel17.setBounds(390, 130, 210, 20);
        panelBorder1.add(txt_email);
        txt_email.setBounds(390, 150, 210, 30);

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
        btn_them.setBounds(670, 30, 120, 40);

        Btn_capNhat.setBackground(new java.awt.Color(125, 224, 237));
        Btn_capNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/floppy-disk.png"))); // NOI18N
        Btn_capNhat.setText("Cập nhật");
        Btn_capNhat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btn_capNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_capNhatActionPerformed(evt);
            }
        });
        panelBorder1.add(Btn_capNhat);
        Btn_capNhat.setBounds(670, 90, 120, 40);

        btn_LamMoi.setBackground(new java.awt.Color(125, 224, 237));
        btn_LamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        btn_LamMoi.setText("Làm Mới");
        btn_LamMoi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_LamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LamMoiActionPerformed(evt);
            }
        });
        panelBorder1.add(btn_LamMoi);
        btn_LamMoi.setBounds(670, 150, 120, 40);
        panelBorder1.add(date_ngaysinh1);
        date_ngaysinh1.setBounds(390, 30, 210, 30);

        panelGradiente1.add(panelBorder1);
        panelBorder1.setBounds(10, 0, 990, 260);

        jTabbedPane3.setBackground(new java.awt.Color(204, 204, 255));

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        TB_bang1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Họ Và Tên", "Giới Tính", "Ngày Sinh", "SĐT", "Email", "Điểm Thưởng"
            }
        ));
        TB_bang1.setGridColor(new java.awt.Color(255, 255, 255));
        TB_bang1.setRowHeight(25);
        TB_bang1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TB_bang1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TB_bang1);

        panelBorder3.setBackground(new java.awt.Color(255, 255, 255));

        Btn_timKiem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search_24px.png"))); // NOI18N
        Btn_timKiem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_timKiem1MouseClicked(evt);
            }
        });
        panelBorder3.add(Btn_timKiem1);
        Btn_timKiem1.setBounds(480, 0, 40, 40);

        txt_timKiem01.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_timKiem01KeyReleased(evt);
            }
        });
        panelBorder3.add(txt_timKiem01);
        txt_timKiem01.setBounds(20, 0, 450, 40);

        TXT_01.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TXT_01.setForeground(new java.awt.Color(255, 51, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(TXT_01, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 254, Short.MAX_VALUE)
                        .addComponent(panelBorder3, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelBorder3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXT_01, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Thông Tin Khách Hàng", jPanel3);

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));

        TB_bang02.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Họ Và Tên", "SĐT", "Mã Hoá Đơn", "Ngày Tạo Hoá Đơn", "Tổng Tiền", "Trạng Thái"
            }
        ));
        TB_bang02.setRowHeight(25);
        jScrollPane4.setViewportView(TB_bang02);

        btn_LamMoi1.setBackground(new java.awt.Color(125, 224, 237));
        btn_LamMoi1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        btn_LamMoi1.setText("HIển THị");
        btn_LamMoi1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_LamMoi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LamMoi1ActionPerformed(evt);
            }
        });

        LBL_SOLUONG.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LBL_SOLUONG.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 978, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(LBL_SOLUONG, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_LamMoi1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_LamMoi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LBL_SOLUONG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Lịch Sử Mua Hàng", jPanel5);

        panelGradiente1.add(jTabbedPane3);
        jTabbedPane3.setBounds(12, 270, 990, 370);

        pnmain.add(panelGradiente1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 190, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnmain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1010, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 1010, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnmain, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked

    }//GEN-LAST:event_jLabel8MouseClicked

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged

    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed

    }//GEN-LAST:event_jPanel1MousePressed

    private void btnbanhangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbanhangMousePressed
        ban_Hang bh = new ban_Hang();
        bh.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnbanhangMousePressed

    private void btnsanphamMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsanphamMousePressed

    }//GEN-LAST:event_btnsanphamMousePressed

    private void btnkhuyenmaiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnkhuyenmaiMousePressed
        khuyen_mai km = new khuyen_mai();
        km.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnkhuyenmaiMousePressed

    private void btnkhachhangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnkhachhangMousePressed

    }//GEN-LAST:event_btnkhachhangMousePressed

    private void btnnhanvienMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnnhanvienMousePressed

    }//GEN-LAST:event_btnnhanvienMousePressed

    private void btnhoadonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhoadonMousePressed

    }//GEN-LAST:event_btnhoadonMousePressed

    private void btnthongkeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnthongkeMousePressed

    }//GEN-LAST:event_btnthongkeMousePressed

    private void btndangxuatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndangxuatMousePressed

    }//GEN-LAST:event_btndangxuatMousePressed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        if (check() && check2()) {
          //  JOptionPane.showMessageDialog(this, KH.add(getData()));
            
            if (KH.add(getData())) {
                JOptionPane.showMessageDialog(this, "Add thành công");
                listKhachHang = KH.getall();
            showTable(listKhachHang);
            TXT_01.setText("Tổng số khách hàng là : " + listKhachHang.size());
            } else {
                JOptionPane.showMessageDialog(this, "Add thất bại");
            }
        }
    }//GEN-LAST:event_btn_themActionPerformed

    private void Btn_capNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_capNhatActionPerformed
        int row = TB_bang1.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "cần chọn khách hàng để cập nhật");
            return;
        }
        if (check3() && check4()) {
            if (JOptionPane.showConfirmDialog(this, "Bạn có muốn cập nhật không?") == JOptionPane.YES_OPTION) {
                int id = layid();
               // JOptionPane.showMessageDialog(this, KH.update(id, getData()));               
                if(KH.update(id, getData())){
                    JOptionPane.showMessageDialog(this, "Update thành công");
                    listKhachHang = KH.getall();
                showTable(listKhachHang);
                TXT_01.setText("Tổng số khách hàng là : " + listKhachHang.size());
                }else{
                    JOptionPane.showMessageDialog(this, "Update thất bại");
                }
            }
        }

    }//GEN-LAST:event_Btn_capNhatActionPerformed

    private void btn_LamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LamMoiActionPerformed
        txt_Ten.setText("");
        txt_tenDem.setText("");
        txt_Ho.setText("");
        date_ngaysinh1.setCalendar(null);
        txt_sdt.setText("");
        txt_email.setText("");
    }//GEN-LAST:event_btn_LamMoiActionPerformed

    private void TB_bang1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TB_bang1MouseClicked

        int id = layid();
        showTable3(listKhachHang01);
        listKhachHang01 = KH.GetTKTheoIDKH(id);
        LBL_SOLUONG.setText("Tổng số hoá đơn là : " + KH.GetTKTheoIDKH(id).size());

        int row = TB_bang1.getSelectedRow();
        KhachHang kh = listKhachHang.get(row);
        txt_Ten.setText(kh.getTen());
        txt_tenDem.setText(kh.getTendem());
        txt_Ho.setText(kh.getHo());
        String gt = (TB_bang1.getValueAt(row, 2).toString());
        if (gt == "Nam") {
            rd_Nam.setSelected(true);
        } else {
            rd_nu.setSelected(true);
        }
        date_ngaysinh1.setDate((Date) TB_bang1.getValueAt(row, 3));
        txt_sdt.setText(kh.getSdt());
        txt_email.setText(kh.getEmail());
    }//GEN-LAST:event_TB_bang1MouseClicked

    private void Btn_timKiem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_timKiem1MouseClicked

    }//GEN-LAST:event_Btn_timKiem1MouseClicked

    private void txt_timKiem01KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timKiem01KeyReleased
        defaultTableModel = (DefaultTableModel) TB_bang1.getModel();
        defaultTableModel.setRowCount(0);
        for (KhachHang khachHang : KH.GetTK(txt_timKiem01.getText())) {
            defaultTableModel.addRow(khachHang.toDataRow());
        }
    }//GEN-LAST:event_txt_timKiem01KeyReleased

    private void btn_LamMoi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LamMoi1ActionPerformed
        listKhachHang01 = KH.getall02();
        showTable2(listKhachHang01);
        LBL_SOLUONG.setText("Tổng số hoá đơn là : " + listKhachHang01.size());
    }//GEN-LAST:event_btn_LamMoi1ActionPerformed


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
            java.util.logging.Logger.getLogger(KhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Khach_Hangg().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.MyButton Btn_capNhat;
    private javax.swing.JLabel Btn_timKiem1;
    private javax.swing.JLabel LBL_SOLUONG;
    private javax.swing.JTable TB_bang02;
    private javax.swing.JTable TB_bang1;
    private javax.swing.JLabel TXT_01;
    private swing.MyButton btn_LamMoi;
    private swing.MyButton btn_LamMoi1;
    private swing.MyButton btn_them;
    private javax.swing.JPanel btnbanhang;
    private javax.swing.JPanel btndangxuat;
    private javax.swing.JPanel btnhoadon;
    private javax.swing.JPanel btnkhachhang;
    private javax.swing.JPanel btnkhuyenmai;
    private javax.swing.JPanel btnnhanvien;
    private javax.swing.JPanel btnsanpham;
    private javax.swing.JPanel btnthongke;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel crep1;
    private javax.swing.JPanel crep2;
    private javax.swing.JPanel crep3;
    private javax.swing.JPanel crep4;
    private javax.swing.JPanel crep5;
    private javax.swing.JPanel crepp1;
    private javax.swing.JPanel crepp2;
    private javax.swing.JPanel crepp3;
    private com.toedter.calendar.JDateChooser date_ngaysinh1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JLabel lbl_tenNhanVien;
    private javax.swing.JLabel lbltieude;
    private swing.PanelBorder panelBorder1;
    private swing.PanelBorder panelBorder3;
    private swing.PanelGradiente panelGradiente1;
    private javax.swing.JPanel pnmain;
    private javax.swing.JRadioButton rd_Nam;
    private javax.swing.JRadioButton rd_nu;
    private swing.MyTextField txt_Ho;
    private swing.MyTextField txt_Ten;
    private swing.MyTextField txt_email;
    private swing.MyTextField txt_sdt;
    private swing.MyTextField txt_tenDem;
    private swing.SearchText txt_timKiem01;
    // End of variables declaration//GEN-END:variables
}
