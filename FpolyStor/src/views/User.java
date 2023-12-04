package views;

import Model.Chucvu;
import Model.Users;
import Model.UsersViewmodel;
import Service.IChucvuService;
import Service.IUsersReposytory;
import Service.IUsersService;
import Serviceimpl.ChucVuService;
import Serviceimpl.UsersReposytory;
import Serviceimpl.UsersService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class User extends javax.swing.JFrame {

    /**
     * Creates new form User
     */
    DefaultTableModel defaultTableModel;
    DefaultComboBoxModel defaultComboBoxModel;
    private final IUsersService nhanVienService;
    private final IChucvuService CVService;
    private static final IUsersReposytory uiRepoService = new UsersReposytory();
    private static int currentPage = 1;
    private static int rowFetch = 2;

    public User() {
        initComponents();
        nhanVienService = new UsersService();
        CVService = new ChucVuService();
        inittable();
        List<Chucvu> cvv = CVService.getAllChucVu();
        cbochucvu.setModel(new DefaultComboBoxModel((cvv.toArray())));
        txtTaikhoan.setEditable(true);
        defaultTableModel = (DefaultTableModel) tblnhanvien.getModel();
        loadPage(currentPage, rowFetch);
//        loaddata();
    }

    private void inittable() {
        DefaultTableModel model = (DefaultTableModel) tblnhanvien.getModel();

        model.addColumn("STT");
        model.addColumn("Họ");
        model.addColumn("Tên đệm");
        model.addColumn("Tên");
        model.addColumn("Ngày sinh");
        model.addColumn("Giới tính");
        model.addColumn("SĐT");
        model.addColumn("Tài Khoản");
        model.addColumn("Mật Khẩu");
        model.addColumn("Email");
        model.addColumn("Chức Vụ");
        model.addColumn("Trạng thái");
    }

    public void loaddata() {
        defaultTableModel.setRowCount(0);
        List<UsersViewmodel> nvv = nhanVienService.getAllNhanVien();
        int stt = 1;
        for (UsersViewmodel x : nvv) {
            defaultTableModel.addRow(new Object[]{
                stt,
                x.getHo(),
                x.getTendem(),
                x.getTen(),
                x.getNgaysinh(),
                x.getGioitinh() == 1 ? "Nam" : "Nữ",
                x.getSdt(),
                x.getTk(),
                x.getMk(),
                x.getEmail(),
                x.getChucVu().getTen(),
                x.getTT() == 1 ? "Làm việc" : "Nghỉ Làm"
            });
            stt++;
        }
        lblTongnv.setText("Tổng nhân viên : " + nvv.size());
    }

    private void loadPage(int page, int rowFetch) {
        defaultTableModel.setRowCount(0);
        List<Users> list = uiRepoService.loadPaging(page, rowFetch);
        List<UsersViewmodel> nvv = nhanVienService.getAllNhanVien();
        int stt = 1;
        for (Users x : list) {
            String idChucVu = x.getChucVu().getId();
            String ChucVu = idChucVu.equals("1") ? "Quản lý" : "Nhân viên bán hàng";
            defaultTableModel.addRow(new Object[]{
                stt,
                x.getHo(),
                x.getTendem(),
                x.getTen(),
                x.getNgaysinh(),
                x.getGioitinh() == 1 ? "Nam" : "Nữ",
                x.getSdt(),
                x.getTk(),
                x.getMk(),
                x.getEmail(),
                ChucVu,
                x.getTT() == 1 ? "Làm việc" : "Nghỉ Làm"
            });
            stt++;
        }
        lblTongnv.setText("Tổng nhân viên : " + nvv.size());
    }

    public void ClearForm() {
        txtten.setText("");
        txttendem.setText("");
        txtho.setText("");
        txtTaikhoan.setText("");
        txtMatkhau.setText("");
        txtemail.setText("");
        txtsdt.setText("");
        buttonGroup1.clearSelection();
        chk_tt.setSelected(false);
        cbochucvu.setSelectedIndex(0);
        datengaysinh.setDate(null);
        loaddata();
    }

    public void Showtable() {
        try {
            Integer row = tblnhanvien.getSelectedRow();

            txtho.setText(tblnhanvien.getValueAt(row, 1).toString());
            txttendem.setText(tblnhanvien.getValueAt(row, 2).toString());
            txtten.setText(tblnhanvien.getValueAt(row, 3).toString());
            String gt = (tblnhanvien.getValueAt(row, 5).toString());
            if (gt == "Nam") {
                rd_nam.setSelected(true);
            } else {
                rd_nu.setSelected(true);
            }
            String tt = (tblnhanvien.getValueAt(row, 11).toString());
            if (tt == "Làm việc") {
                chk_tt.setSelected(true);
            } else if (tt == "Nghỉ Làm") {
                chk_tt.setSelected(false);
            }

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse((String) tblnhanvien.getValueAt(row, 4));
            datengaysinh.setDate(date);

            txtsdt.setText(tblnhanvien.getValueAt(row, 6).toString());
            txtTaikhoan.setText(tblnhanvien.getValueAt(row, 7).toString());
            txtMatkhau.setText(tblnhanvien.getValueAt(row, 8).toString());
            txtemail.setText(tblnhanvien.getValueAt(row, 9).toString());

        } catch (ParseException ex) {
//            Logger.getLogger(frm_Nhanvien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private UsersViewmodel getInputForm() {
        String sdt = "(0\\d{9})";
        String mail = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        UsersViewmodel nv = new UsersViewmodel();
        Pattern p = Pattern.compile("^[0-9]+$");
// Tên
        try {
            if (txtten.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên!");
                return null;
            }
        } catch (Exception e) {
        }
        if (p.matcher(txtten.getText()).find() == true) {
            JOptionPane.showMessageDialog(this, "Tên không được nhập số");
            return null;
        }
        if (txtten.getText().length() > 30) {
            JOptionPane.showMessageDialog(this, "Tên không được quá 30 kí tự");
            return null;
        }
// Tên Đệm
        try {
            if (txttendem.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên đệm!");
                return null;
            }
        } catch (Exception e) {
        }
        if (p.matcher(txttendem.getText()).find() == true) {
            JOptionPane.showMessageDialog(this, "Tên đệm không được nhập số");
            return null;
        }
        if (txttendem.getText().length() > 30) {
            JOptionPane.showMessageDialog(this, "Tên đệm không được quá 30 kí tự");
            return null;
        }
// Họ
        try {
            if (txtho.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Bạn chưa nhập họ!");
                return null;
            }
        } catch (Exception e) {
        }
        if (p.matcher(txtho.getText()).find() == true) {
            JOptionPane.showMessageDialog(this, "Họ không được nhập số");
            return null;
        }
        if (txtho.getText().length() > 30) {
            JOptionPane.showMessageDialog(this, "Họ không được quá 30 kí tự");
            return null;
        }
// Ngày Sinh        
        try {
            if (datengaysinh.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Bạn chưa Chọn ngày sinh!");
                return null;
            }
        } catch (Exception e) {
        }
// SĐT
        try {
            if (txtsdt.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Bạn chưa nhập sdt!");
                return null;
            }
        } catch (Exception e) {

        }

        try {
            if (!txtsdt.getText().matches(sdt)) {
                JOptionPane.showMessageDialog(this, "Số điện thoại của bạn chưa đúng định dạng");
                return null;
            }
        } catch (Exception e) {
        }

        if (nhanVienService.kiemtrasdt(txtsdt.getText()) != null) {
            JOptionPane.showMessageDialog(this, "Số điện thoại của bạn đã tồn tại");
            return null;
        }
// TÀi Khoản
        try {
            if (txtTaikhoan.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Bạn Chưa Nhập Tài Khoản");
                return null;
            }
        } catch (Exception e) {
        }
        if (nhanVienService.kiemtratk(txtTaikhoan.getText()) != null) {
            JOptionPane.showMessageDialog(this, "Tên tài khoản đã tồn tại");
            return null;
        }
// Mật Khẩu
        try {
            if (txtMatkhau.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Bạn chưa nhập mật khẩu!");
                return null;
            }
        } catch (Exception e) {
        }
// Email        
        try {
            if (txtemail.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Bạn chưa nhập email!");
                return null;
            }
        } catch (Exception e) {
        }

        try {
            if (!txtemail.getText().matches(mail)) {
                JOptionPane.showMessageDialog(this, "Email của bạn chưa đúng định dạng");
                return null;
            }
        } catch (Exception e) {
        }
        if (nhanVienService.kiemtra(txtemail.getText()) != null) {
            JOptionPane.showMessageDialog(this, "Email đã tồn tại");
            return null;
        }

        nv.setTen(txtten.getText());
        nv.setTendem(txttendem.getText());
        nv.setHo(txtho.getText());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(datengaysinh.getDate());
        nv.setNgaysinh(date);
        Integer gt;
        if (rd_nam.isSelected()) {
            gt = 1;
        } else {
            gt = 0;
        }
        nv.setGioitinh(gt);
        nv.setSdt(txtsdt.getText());
        nv.setTk(txtTaikhoan.getText());
        nv.setMk(txtMatkhau.getText());
        nv.setEmail(txtemail.getText());
        Chucvu cvv = (Chucvu) cbochucvu.getSelectedItem();
        nv.setChucVu(cvv);
        if (chk_tt.isSelected()) {
            nv.setTT(1);
        } else {
            nv.setTT(0);
        }
        return nv;
    }

    public Integer getNhanVienSelectTedRow() {
        Integer row = tblnhanvien.getSelectedRow();
        Integer id = (Integer) tblnhanvien.getValueAt(row, 0);
        return id;
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
        panelGradiente1 = new swing.PanelGradiente();
        jLabel1 = new javax.swing.JLabel();
        txtten = new swing.MyTextField();
        jLabel2 = new javax.swing.JLabel();
        txttendem = new swing.MyTextField();
        jLabel3 = new javax.swing.JLabel();
        txtho = new swing.MyTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtsdt = new swing.MyTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTaikhoan = new swing.MyTextField();
        jLabel7 = new javax.swing.JLabel();
        txtMatkhau = new swing.MyTextField();
        jLabel8 = new javax.swing.JLabel();
        txtemail = new swing.MyTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblnhanvien = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        rd_nu = new javax.swing.JRadioButton();
        rd_nam = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        chk_tt = new javax.swing.JCheckBox();
        lblTongnv = new javax.swing.JLabel();
        btnthem = new swing.MyButton();
        btncapnhat = new swing.MyButton();
        panelBorder2 = new swing.PanelBorder();
        searchtxt = new swing.SearchText();
        lbl_search = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbochucvu = new javax.swing.JComboBox<>();
        datengaysinh = new com.toedter.calendar.JDateChooser();
        btnlmmoi = new swing.MyButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelGradiente1.setColorPrimario(new java.awt.Color(204, 255, 255));
        panelGradiente1.setColorSecundario(new java.awt.Color(255, 204, 255));
        panelGradiente1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Tên");
        panelGradiente1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 0, 220, 20));
        panelGradiente1.add(txtten, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 20, 220, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Tên đệm");
        panelGradiente1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 70, 220, 20));
        panelGradiente1.add(txttendem, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 90, 220, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Họ");
        panelGradiente1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 140, 220, 20));
        panelGradiente1.add(txtho, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 160, 220, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Ngày sinh");
        panelGradiente1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 210, 220, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("SĐT");
        panelGradiente1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 0, 220, 20));
        panelGradiente1.add(txtsdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 20, 220, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Tài Khoản");
        panelGradiente1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 70, 220, 20));
        panelGradiente1.add(txtTaikhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 90, 220, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Mật khẩu");
        panelGradiente1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 140, 220, 20));
        panelGradiente1.add(txtMatkhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 160, 220, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Giới tính");
        panelGradiente1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 280, 60, 20));
        panelGradiente1.add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 230, 220, 40));

        tblnhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblnhanvien.setGridColor(new java.awt.Color(255, 255, 255));
        tblnhanvien.setRowHeight(25);
        tblnhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblnhanvienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblnhanvien);

        panelGradiente1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 380, 990, 139));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Trạng thái");
        panelGradiente1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 320, 60, 20));

        rd_nu.setBackground(new java.awt.Color(230, 230, 250));
        buttonGroup1.add(rd_nu);
        rd_nu.setText("Nữ");
        panelGradiente1.add(rd_nu, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 280, -1, -1));

        rd_nam.setBackground(new java.awt.Color(230, 230, 250));
        buttonGroup1.add(rd_nam);
        rd_nam.setSelected(true);
        rd_nam.setText("Nam");
        panelGradiente1.add(rd_nam, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 280, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Email");
        panelGradiente1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 210, 220, 20));

        chk_tt.setBackground(new java.awt.Color(230, 230, 250));
        chk_tt.setText("Làm việc");
        panelGradiente1.add(chk_tt, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 320, 90, -1));

        lblTongnv.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTongnv.setForeground(new java.awt.Color(255, 0, 0));
        lblTongnv.setText("Tổng nhân viên :");
        panelGradiente1.add(lblTongnv, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 360, 200, -1));

        btnthem.setBackground(new java.awt.Color(125, 224, 237));
        btnthem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnthem.setText("Thêm");
        btnthem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });
        panelGradiente1.add(btnthem, new org.netbeans.lib.awtextra.AbsoluteConstraints(718, 20, 120, 40));

        btncapnhat.setBackground(new java.awt.Color(125, 224, 237));
        btncapnhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/floppy-disk.png"))); // NOI18N
        btncapnhat.setText("Cập nhật");
        btncapnhat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btncapnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncapnhatActionPerformed(evt);
            }
        });
        panelGradiente1.add(btncapnhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(718, 90, 120, 40));

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));

        searchtxt.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                searchtxtCaretUpdate(evt);
            }
        });
        panelBorder2.add(searchtxt);
        searchtxt.setBounds(10, 0, 240, 40);

        lbl_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search_24px.png"))); // NOI18N
        lbl_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_searchMouseClicked(evt);
            }
        });
        panelBorder2.add(lbl_search);
        lbl_search.setBounds(260, 0, 40, 40);

        panelGradiente1.add(panelBorder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(628, 320, 300, 40));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Chức vụ");
        panelGradiente1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 280, 220, 20));

        cbochucvu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 2));
        cbochucvu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbochucvuActionPerformed(evt);
            }
        });
        panelGradiente1.add(cbochucvu, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 300, 220, 40));

        datengaysinh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 2));
        datengaysinh.setDateFormatString("yyyy-MM-dd");
        panelGradiente1.add(datengaysinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 230, 220, 40));

        btnlmmoi.setBackground(new java.awt.Color(125, 224, 237));
        btnlmmoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        btnlmmoi.setText("Làm Mới");
        btnlmmoi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnlmmoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlmmoiActionPerformed(evt);
            }
        });
        panelGradiente1.add(btnlmmoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(718, 160, 120, 40));

        jButton1.setText("<");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelGradiente1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 588, 45, -1));

        jButton2.setText(">");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panelGradiente1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(546, 588, 36, -1));

        jButton3.setText("2");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        panelGradiente1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 588, 50, -1));

        jButton4.setText("1");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        panelGradiente1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 588, 45, -1));

        jButton5.setText("3");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        panelGradiente1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 588, 49, -1));

        getContentPane().add(panelGradiente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 630));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblnhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblnhanvienMouseClicked

        try {
            int index = tblnhanvien.getSelectedRow();
            String gt = (String) tblnhanvien.getValueAt(index, 5);
            String tt = (String) tblnhanvien.getValueAt(index, 11);
            int trangthai = tt.equals("Làm việc") ? 1 : 0;
            int gioiitinh = gt.equals("Nam") ? 1 : 0;
            txtho.setText(tblnhanvien.getValueAt(index, 1) + "");
            txtten.setText(tblnhanvien.getValueAt(index, 3) + "");
            txttendem.setText(tblnhanvien.getValueAt(index, 2) + "");
            txtsdt.setText(tblnhanvien.getValueAt(index, 6) + "");
            txtemail.setText(tblnhanvien.getValueAt(index, 9) + "");
            txtTaikhoan.setText(tblnhanvien.getValueAt(index, 7) + "");
            txtMatkhau.setText(tblnhanvien.getValueAt(index, 8) + "");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = sdf.parse((String) tblnhanvien.getValueAt(index, 4));
            datengaysinh.setDate(date1);
            chk_tt.setSelected(trangthai == 1 ? true : false);
            if (gioiitinh == 1) {
                rd_nam.setSelected(true);
            } else {
                rd_nu.setSelected(true);
            }
            if (tblnhanvien.getValueAt(index, 10).toString().equals("Quản lý")) {
                cbochucvu.setSelectedIndex(0);
            } else {
                cbochucvu.setSelectedIndex(1);
            }

        } catch (ParseException ex) {
//            Logger.getLogger(frm_Nhanvien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblnhanvienMouseClicked

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        UsersViewmodel nv = getInputForm();
        if (nv == null) {
            return;
        }
        if (JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thêm ?", "Add", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            if (nhanVienService.add(nv) != false) {
                JOptionPane.showMessageDialog(this, "Thêm Thành Công");
//                loaddata();
                loadPage(1, 2);
            } else {
                JOptionPane.showMessageDialog(this, "Thêm Thất Bại");
            }
        }
    }//GEN-LAST:event_btnthemActionPerformed

    private void btncapnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncapnhatActionPerformed
        // TODO add your handling code here:
        UsersViewmodel nv = new UsersViewmodel();
        Integer row = tblnhanvien.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Bạn Cần Chọn 1 Dòng Muốn Sửa!");
            return;
        }

        nv.setTen(txtten.getText());
        nv.setTendem(txttendem.getText());
        nv.setHo(txtho.getText());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(datengaysinh.getDate());
        nv.setNgaysinh(date);
        Integer gt;
        if (rd_nam.isSelected()) {
            gt = 1;
        } else {
            gt = 0;
        }
        nv.setGioitinh(gt);
        nv.setSdt(txtsdt.getText());
        nv.setTk(txtTaikhoan.getText());
        nv.setMk(txtMatkhau.getText());
        nv.setEmail(txtemail.getText());
        Chucvu cvv = (Chucvu) cbochucvu.getSelectedItem();
        nv.setChucVu(cvv);
        if (chk_tt.isSelected()) {
            nv.setTT(1);
        } else {
            nv.setTT(0);
        }

        if (JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn sửa ?", "Update", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            IUsersReposytory usersReposytory = new UsersReposytory();
            List<Users> lst = usersReposytory.getAllNhanVien();
            if (nhanVienService.update(nv, lst.get(row).getId()) != false) {
                JOptionPane.showMessageDialog(this, "Sửa Thành Công");
                loadPage(1, 2);
            } else {
                JOptionPane.showMessageDialog(this, "Sửa Thất Bại");
                Showtable();
            }
        }
    }//GEN-LAST:event_btncapnhatActionPerformed

    private void searchtxtCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_searchtxtCaretUpdate
        // TODO add your handling code here:
        defaultTableModel.setRowCount(0);
        int stt = 1;
        for (UsersViewmodel x : nhanVienService.SearchNVV(searchtxt.getText())) {
            defaultTableModel.addRow(new Object[]{
                stt,
                x.getHo(),
                x.getTendem(),
                x.getTen(),
                x.getNgaysinh(),
                x.getGioitinh() == 1 ? "Nam" : "Nữ",
                x.getSdt(),
                x.getTk(),
                x.getMk(),
                x.getEmail(),
                x.getChucVu().getTen(),
                x.getTT() == 1 ? "Làm việc" : "Nghỉ Làm"
            });
            stt++;
        }
    }//GEN-LAST:event_searchtxtCaretUpdate

    private void lbl_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_searchMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_lbl_searchMouseClicked

    private void btnlmmoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlmmoiActionPerformed
        //        loaddata();
        ClearForm();
//        loaddata();
        loadPage(1, 2);
    }//GEN-LAST:event_btnlmmoiActionPerformed

    private void cbochucvuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbochucvuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbochucvuActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        currentPage = 1;
        loadPage(currentPage, rowFetch);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        currentPage = 2;
        loadPage(currentPage, rowFetch);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        currentPage = 3;
        loadPage(currentPage, rowFetch);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (currentPage == 1) {
            JOptionPane.showMessageDialog(this, "bạn đã về trang đầu");
        } else {
            currentPage--;
            loadPage(currentPage, rowFetch);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (currentPage == 3) {
            JOptionPane.showMessageDialog(this, "bạn đã về trang cuối ");
        } else {
            currentPage++;
            loadPage(currentPage, rowFetch);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new User().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.MyButton btncapnhat;
    private swing.MyButton btnlmmoi;
    private swing.MyButton btnthem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbochucvu;
    private javax.swing.JCheckBox chk_tt;
    private com.toedter.calendar.JDateChooser datengaysinh;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTongnv;
    private javax.swing.JLabel lbl_search;
    private swing.PanelBorder panelBorder2;
    private swing.PanelGradiente panelGradiente1;
    private javax.swing.JRadioButton rd_nam;
    private javax.swing.JRadioButton rd_nu;
    private swing.SearchText searchtxt;
    private javax.swing.JTable tblnhanvien;
    private swing.MyTextField txtMatkhau;
    private swing.MyTextField txtTaikhoan;
    private swing.MyTextField txtemail;
    private swing.MyTextField txtho;
    private swing.MyTextField txtsdt;
    private swing.MyTextField txtten;
    private swing.MyTextField txttendem;
    // End of variables declaration//GEN-END:variables
}
