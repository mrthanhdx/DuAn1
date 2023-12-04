/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package views;

import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Model.ChatLieu;
import Model.DanhMuc;
import Model.MauSac;
import Model.NhaSX;
import Model.Objecttt;
import Model.Size;
import Model.ThuongHieu;
import Serviceimpl.ChatLieuService;
import Serviceimpl.DanhMucService;
import Serviceimpl.MauSacService;
import Serviceimpl.NhaSXService;
import Serviceimpl.SizeService;
import Serviceimpl.ThuongHieuService;

/**
 *
 * @author H
 */
public class Them_Thuoc_Tinh extends javax.swing.JDialog {
    DefaultTableModel model = new DefaultTableModel();
    MauSacService mauSacService = new MauSacService();
    ChatLieuService chatLieuService = new ChatLieuService();
    NhaSXService nhaSXService = new NhaSXService();
    SizeService sizeService = new SizeService();
    DanhMucService danhMucService = new DanhMucService();
    ThuongHieuService thuongHieuService = new ThuongHieuService();
    private static int page =1;
    private static int limit = 5;

    /**
     * Creates new form Them_Thuoc_Tinhh
     */
    public Them_Thuoc_Tinh(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        model = (DefaultTableModel) tblThemThuocTinh.getModel();
        this.setLocationRelativeTo(null);
        loadTableThuongHieu(page, limit);
        lblSo.setText(Integer.toString(page));
        
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
        panelGradiente2 = new swing.PanelGradiente();
        panelBorder6 = new swing.PanelBorder();
        jLabel4 = new javax.swing.JLabel();
        panelBorder7 = new swing.PanelBorder();
        rdoThuonghieu1 = new javax.swing.JRadioButton();
        rdoChatlieu1 = new javax.swing.JRadioButton();
        rdoNSX1 = new javax.swing.JRadioButton();
        rdoMausac1 = new javax.swing.JRadioButton();
        rdoSize1 = new javax.swing.JRadioButton();
        rdodanhmuc1 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        panelBorder8 = new swing.PanelBorder();
        txtTen = new javax.swing.JTextField();
        btn_them1 = new swing.MyButton();
        btn_LamMoi1 = new swing.MyButton();
        Btn_capNhat1 = new swing.MyButton();
        panelBorder9 = new swing.PanelBorder();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblThemThuocTinh = new javax.swing.JTable();
        panelBorder10 = new swing.PanelBorder();
        txtTimKiem = new swing.SearchText();
        jLabel5 = new javax.swing.JLabel();
        btnSau = new javax.swing.JButton();
        btntruoc = new javax.swing.JButton();
        lblSo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblExit = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        panelGradiente2.setColorPrimario(new java.awt.Color(204, 255, 255));

        panelBorder6.setBackground(new java.awt.Color(204, 204, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText(" Nhập Tên");
        panelBorder6.add(jLabel4);
        jLabel4.setBounds(60, 60, 250, 30);

        panelBorder7.setBackground(new java.awt.Color(255, 255, 255));

        rdoThuonghieu1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoThuonghieu1);
        rdoThuonghieu1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdoThuonghieu1.setText("Thương hiệu");
        rdoThuonghieu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoThuonghieu1MouseClicked(evt);
            }
        });
        rdoThuonghieu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoThuonghieu1ActionPerformed(evt);
            }
        });
        panelBorder7.add(rdoThuonghieu1);
        rdoThuonghieu1.setBounds(270, 100, 110, 40);

        rdoChatlieu1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoChatlieu1);
        rdoChatlieu1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdoChatlieu1.setSelected(true);
        rdoChatlieu1.setText("Chất liệu");
        rdoChatlieu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoChatlieu1ActionPerformed(evt);
            }
        });
        panelBorder7.add(rdoChatlieu1);
        rdoChatlieu1.setBounds(30, 30, 110, 40);

        rdoNSX1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoNSX1);
        rdoNSX1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdoNSX1.setText("Nhà sản xuất");
        rdoNSX1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoNSX1MouseClicked(evt);
            }
        });
        rdoNSX1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNSX1ActionPerformed(evt);
            }
        });
        panelBorder7.add(rdoNSX1);
        rdoNSX1.setBounds(150, 30, 110, 40);

        rdoMausac1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoMausac1);
        rdoMausac1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdoMausac1.setText("Màu sắc");
        rdoMausac1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoMausac1ActionPerformed(evt);
            }
        });
        panelBorder7.add(rdoMausac1);
        rdoMausac1.setBounds(270, 30, 110, 40);

        rdoSize1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoSize1);
        rdoSize1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdoSize1.setText("Size");
        rdoSize1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoSize1MouseClicked(evt);
            }
        });
        rdoSize1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoSize1ActionPerformed(evt);
            }
        });
        panelBorder7.add(rdoSize1);
        rdoSize1.setBounds(30, 100, 110, 40);

        rdodanhmuc1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdodanhmuc1);
        rdodanhmuc1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdodanhmuc1.setText("Danh mục");
        rdodanhmuc1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdodanhmuc1MouseClicked(evt);
            }
        });
        rdodanhmuc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdodanhmuc1ActionPerformed(evt);
            }
        });
        panelBorder7.add(rdodanhmuc1);
        rdodanhmuc1.setBounds(150, 100, 110, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        panelBorder7.add(jLabel3);
        jLabel3.setBounds(1140, 0, 40, 40);

        panelBorder6.add(panelBorder7);
        panelBorder7.setBounds(370, 20, 450, 170);

        panelBorder8.setBackground(new java.awt.Color(255, 255, 255));

        txtTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTen.setBorder(null);
        panelBorder8.add(txtTen);
        txtTen.setBounds(10, 0, 230, 50);

        panelBorder6.add(panelBorder8);
        panelBorder8.setBounds(60, 90, 250, 50);

        btn_them1.setBackground(new java.awt.Color(125, 224, 237));
        btn_them1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btn_them1.setText("Thêm");
        btn_them1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_them1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_them1ActionPerformed(evt);
            }
        });
        panelBorder6.add(btn_them1);
        btn_them1.setBounds(930, 90, 150, 31);

        btn_LamMoi1.setBackground(new java.awt.Color(125, 224, 237));
        btn_LamMoi1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        btn_LamMoi1.setText("Làm Mới");
        btn_LamMoi1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_LamMoi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LamMoi1ActionPerformed(evt);
            }
        });
        panelBorder6.add(btn_LamMoi1);
        btn_LamMoi1.setBounds(930, 30, 150, 31);

        Btn_capNhat1.setBackground(new java.awt.Color(125, 224, 237));
        Btn_capNhat1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/floppy-disk.png"))); // NOI18N
        Btn_capNhat1.setText("Cập nhật");
        Btn_capNhat1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btn_capNhat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_capNhat1ActionPerformed(evt);
            }
        });
        panelBorder6.add(Btn_capNhat1);
        Btn_capNhat1.setBounds(930, 150, 150, 31);

        panelGradiente2.add(panelBorder6);
        panelBorder6.setBounds(10, 50, 1160, 230);

        panelBorder9.setBackground(new java.awt.Color(204, 204, 255));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        tblThemThuocTinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Tên"
            }
        ));
        tblThemThuocTinh.setGridColor(new java.awt.Color(204, 204, 255));
        tblThemThuocTinh.setRowHeight(25);
        tblThemThuocTinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThemThuocTinhMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblThemThuocTinh);

        panelBorder9.add(jScrollPane2);
        jScrollPane2.setBounds(0, 70, 1160, 210);

        panelBorder10.setBackground(new java.awt.Color(255, 255, 255));

        txtTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        panelBorder10.add(txtTimKiem);
        txtTimKiem.setBounds(10, 0, 240, 50);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search_24px.png"))); // NOI18N
        panelBorder10.add(jLabel5);
        jLabel5.setBounds(264, 0, 40, 50);

        panelBorder9.add(panelBorder10);
        panelBorder10.setBounds(790, 10, 300, 50);

        btnSau.setText("Next");
        btnSau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSauActionPerformed(evt);
            }
        });
        panelBorder9.add(btnSau);
        btnSau.setBounds(613, 290, 60, 23);

        btntruoc.setText("Pre");
        btntruoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntruocActionPerformed(evt);
            }
        });
        panelBorder9.add(btntruoc);
        btntruoc.setBounds(490, 290, 60, 23);
        panelBorder9.add(lblSo);
        lblSo.setBounds(580, 290, 30, 20);

        panelGradiente2.add(panelBorder9);
        panelBorder9.setBounds(10, 300, 1160, 320);

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1130, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        panelGradiente2.add(jPanel2);
        jPanel2.setBounds(0, 0, 1130, 40);

        lblExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        lblExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExitMouseClicked(evt);
            }
        });
        panelGradiente2.add(lblExit);
        lblExit.setBounds(1140, 0, 40, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradiente2, javax.swing.GroupLayout.PREFERRED_SIZE, 1179, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradiente2, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdoThuonghieu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoThuonghieu1MouseClicked
        // TODO add your handling code here:
        if (rdoThuonghieu1.isSelected() == true) {
            loadTableThuongHieu(page, limit);
        }
    }//GEN-LAST:event_rdoThuonghieu1MouseClicked

    private void rdoThuonghieu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoThuonghieu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoThuonghieu1ActionPerformed

    private void rdoChatlieu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoChatlieu1ActionPerformed
        // TODO add your handling code here:
        if (rdoChatlieu1.isSelected() == true) {
            loadTableChatLieu(page, limit);
        }
    }//GEN-LAST:event_rdoChatlieu1ActionPerformed

    private void rdoNSX1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoNSX1MouseClicked
        // TODO add your handling code here:
        if (rdoNSX1.isSelected() == true) {
            loadTableNhaSX(page, limit);
        }
    }//GEN-LAST:event_rdoNSX1MouseClicked

    private void rdoNSX1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNSX1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNSX1ActionPerformed

    private void rdoMausac1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoMausac1ActionPerformed
        // TODO add your handling code here:
        if (rdoMausac1.isSelected() == true) {
            loadTableMauSac(page, limit);
        }
    }//GEN-LAST:event_rdoMausac1ActionPerformed

    private void rdoSize1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoSize1MouseClicked
        // TODO add your handling code here:
        if (rdoSize1.isSelected() == true) {
            loadTableSize(page, limit);
        }
    }//GEN-LAST:event_rdoSize1MouseClicked

    private void rdoSize1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoSize1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoSize1ActionPerformed

    private void rdodanhmuc1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdodanhmuc1MouseClicked
        // TODO add your handling code here:
        if (rdodanhmuc1.isSelected() == true) {
            loadTableDanhMuc(page, limit);
        }
    }//GEN-LAST:event_rdodanhmuc1MouseClicked

    private void rdodanhmuc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdodanhmuc1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdodanhmuc1ActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked

    }//GEN-LAST:event_jLabel3MouseClicked

    private void btn_them1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_them1ActionPerformed
        // TODO add your handling code here:
        if (checkDL()==true) {
            return;
        }
        if (rdoMausac1.isSelected() == true) {
            if(mauSacService.them(readFormMauSac())!= 0){
                    JOptionPane.showMessageDialog(this, "thêm thành công");
                }else JOptionPane.showMessageDialog(this, "thêm thất bại");
            loadTableMauSac(page, limit);
        }else if (rdoChatlieu1.isSelected() == true) {
            if(chatLieuService.add(readFormChatLieu())!= 0){
                    JOptionPane.showMessageDialog(this, "thêm thành công");
                }else JOptionPane.showMessageDialog(this, "thêm thất bại");
            loadTableChatLieu(page, limit);
        }else if (rdoNSX1.isSelected() == true) {
            if(nhaSXService.add(readFormNhaSX())!= 0){
                    JOptionPane.showMessageDialog(this, "thêm thành công");
                }else JOptionPane.showMessageDialog(this, "thêm thất bại");
            loadTableNhaSX(page, limit);
        }else if (rdoSize1.isSelected() == true) {
            if(sizeService.add(readFormSize())!= 0){
                    JOptionPane.showMessageDialog(this, "thêm thành công");
                }else JOptionPane.showMessageDialog(this, "thêm thất bại");
            loadTableSize(page, limit);
        }
    }//GEN-LAST:event_btn_them1ActionPerformed

    private void btn_LamMoi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LamMoi1ActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btn_LamMoi1ActionPerformed

    private void Btn_capNhat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_capNhat1ActionPerformed
        // TODO add your handling code here:
        int row = tblThemThuocTinh.getSelectedRow();
        if (row==-1) {
            JOptionPane.showMessageDialog(this, "bạn cần chọn một dòng để sửa");
            return;
        } if (checkDL()==true) {
            return;
        } if (JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn sửa không")!= JOptionPane.YES_OPTION) {
            return;
        }
        String id = (String) tblThemThuocTinh.getValueAt(row, 0);
        if (rdoMausac1.isSelected() == true) {
            if (mauSacService.sua(readFormMauSac(), id) >0) {
                  JOptionPane.showMessageDialog(this, "sửa thành công");
                  loadTableMauSac(page, limit);
                }else JOptionPane.showMessageDialog(this, "sửa thất bại");
        }else if (rdoChatlieu1.isSelected() == true) {
            if (chatLieuService.update(readFormChatLieu(), id) >0) {
                  JOptionPane.showMessageDialog(this, "sửa thành công");
                  loadTableChatLieu(page, limit);
                }else JOptionPane.showMessageDialog(this, "sửa thất bại");
        }else if (rdoNSX1.isSelected() == true) {
            if (nhaSXService.update(readFormNhaSX(), id) >0) {
                  JOptionPane.showMessageDialog(this, "sửa thành công");
                  loadTableNhaSX(page, limit);
                }else JOptionPane.showMessageDialog(this, "sửa thất bại");
        }else if (rdoSize1.isSelected() == true)  { 
            if (sizeService.update(readFormSize(), id) >0) {
                  JOptionPane.showMessageDialog(this, "sửa thành công");
                  loadTableSize(page, limit);
                }else JOptionPane.showMessageDialog(this, "sửa thất bại");
        }
    }//GEN-LAST:event_Btn_capNhat1ActionPerformed

    private void tblThemThuocTinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThemThuocTinhMouseClicked
        // TODO add your handling code here:
        showForm();
    }//GEN-LAST:event_tblThemThuocTinhMouseClicked

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MousePressed

    private void lblExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseClicked
        // TODO add your handling code here:
        this.dispose();
        
    }//GEN-LAST:event_lblExitMouseClicked

    private void btntruocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntruocActionPerformed
        // TODO add your handling code here:
        
        if (page ==1) {
            btntruoc.setEnabled(false);
        }else{
            page--;
        lblSo.setText(Integer.toString(page));
            if (rdoMausac1.isSelected()) { 
            loadTableMauSac(page, limit);
        }else if (rdoChatlieu1.isSelected()) {
            loadTableChatLieu(page, limit);
        }else if (rdoNSX1.isSelected()) {
            loadTableNhaSX(page, limit);
        }else if (rdoSize1.isSelected()) {
            loadTableSize(page, limit);
        }else if (rdoThuonghieu1.isSelected()) {
            loadTableThuongHieu(page, limit);
        }else if (rdodanhmuc1.isSelected()) {
            loadTableDanhMuc(page, limit);
        }
        }
         
    }//GEN-LAST:event_btntruocActionPerformed

    private void btnSauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSauActionPerformed
        // TODO add your handling code here:
        page++;
        lblSo.setText(Integer.toString(page));
        btntruoc.setEnabled(true);
        if (rdoMausac1.isSelected()) { 
            loadTableMauSac(page, limit);
        }else if (rdoChatlieu1.isSelected()) {
            loadTableChatLieu(page, limit);
        }else if (rdoNSX1.isSelected()) {
            loadTableNhaSX(page, limit);
        }else if (rdoSize1.isSelected()) {
            loadTableSize(page, limit);
        }else if (rdoThuonghieu1.isSelected()) {
            loadTableThuongHieu(page, limit);
        }else if (rdodanhmuc1.isSelected()) {
            loadTableDanhMuc(page, limit);
        }
    }//GEN-LAST:event_btnSauActionPerformed

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
            java.util.logging.Logger.getLogger(Them_Thuoc_Tinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Them_Thuoc_Tinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Them_Thuoc_Tinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Them_Thuoc_Tinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Them_Thuoc_Tinh dialog = new Them_Thuoc_Tinh(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    private void loadTableMauSac(int page, int limit){
        model.setRowCount(0);
        ArrayList<MauSac> list = mauSacService.getAll(page, limit);
        for (MauSac mauSac : list) {
            model.addRow(new Object[]{
            mauSac.getIdMau(), mauSac.getTenMau()});
        }
    }
    
    private void loadTableChatLieu(int page, int limit){
        model.setRowCount(0);
        ArrayList<ChatLieu> list = chatLieuService.getAll(page, limit);
        for (ChatLieu cl : list) {
            model.addRow(new Object[]{
            cl.getIdChatLieu(),cl.getTenChatLieu()});
        }
    }
    
    private void loadTableNhaSX(int page, int limit){
        model.setRowCount(0);
        ArrayList<NhaSX> list = nhaSXService.getAll(page, limit);
        for (NhaSX ns : list) {
            model.addRow(new Object[]{
            ns.getIdNhaSX(),ns.getTenNhaSX()});
        }
    }
    
    private void loadTableSize(int page, int limit){
        model.setRowCount(0);
        ArrayList<Size> list = sizeService.getAll(page, limit);
        for (Size s : list) {
            model.addRow(new Object[]{
            s.getIdSize(),s.getTenSize()});
        }
    }
    
    private void loadTableDanhMuc(int page, int limit){
        model.setRowCount(0);
        ArrayList<DanhMuc> list = danhMucService.getAll(page, limit);
        for (DanhMuc dm : list) {
            model.addRow(new Object[]{
            dm.getIdDanhMuc(),dm.getTenDanhMuc()});
        }
    }
    
    private void loadTableThuongHieu(int page, int limit){
        model.setRowCount(0);
        ArrayList<ThuongHieu> list = thuongHieuService.getAll(page, limit);
        for (ThuongHieu th : list) {
            model.addRow(new Object[]{
            th.getIdThuongHieu(),th.getTenThuongHieu()});
        }
    }
    
    
    
    private void showForm(){
        int index = tblThemThuocTinh.getSelectedRow();
        txtTen.setText(tblThemThuocTinh.getValueAt(index, 1).toString());
    }
    
    private void clearForm(){
        txtTen.setText("");
        txtTimKiem.setText("");
    }
    
    private boolean checkDL(){
        Pattern p = Pattern.compile("^[0-9]+$");
        if (txtTen.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, " Bạn chưa nhập tên thuộc tính!");
            txtTen.requestFocus();
            return true;
        }

        else if (txtTen.getText().length() > 30) {
            JOptionPane.showMessageDialog(this, "Tên thuộc tính sản phẩm không quá 30 kí tự!");
            txtTen.requestFocus();
            return true;
        }
        
        else if (p.matcher(txtTen.getText()).find() == true) {
            JOptionPane.showMessageDialog(this, "Tên thuộc tính sản phẩm phải là chữ!");
            txtTen.requestFocus();
            return true;
        }
        else return false;
    }
    
    private MauSac readFormMauSac(){
        String idmau = null;
        String mau = txtTen.getText();
        return new MauSac(idmau, mau);
    }
    
    
    private ChatLieu readFormChatLieu(){
        String idChatLieu = null;
        String ChatLieu = txtTen.getText();
        return new ChatLieu(idChatLieu, ChatLieu);
    }
    
    private NhaSX readFormNhaSX(){
        String idnsx = null;
        String nsx = txtTen.getText();
        return new NhaSX(idnsx, nsx);
    }
    
    private Size readFormSize(){
        String idsize = null;
        String size = txtTen.getText();
        return new Size(idsize, size);
    }
    
    private void updateButtonState() {
    if (page == 1) {
        btntruoc.setEnabled(false);
    } else {
        btntruoc.setEnabled(true);
    }
}
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.MyButton Btn_capNhat1;
    private javax.swing.JButton btnSau;
    private swing.MyButton btn_LamMoi1;
    private swing.MyButton btn_them1;
    private javax.swing.JButton btntruoc;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblExit;
    private javax.swing.JLabel lblSo;
    private swing.PanelBorder panelBorder10;
    private swing.PanelBorder panelBorder6;
    private swing.PanelBorder panelBorder7;
    private swing.PanelBorder panelBorder8;
    private swing.PanelBorder panelBorder9;
    private swing.PanelGradiente panelGradiente2;
    private javax.swing.JRadioButton rdoChatlieu1;
    private javax.swing.JRadioButton rdoMausac1;
    private javax.swing.JRadioButton rdoNSX1;
    private javax.swing.JRadioButton rdoSize1;
    private javax.swing.JRadioButton rdoThuonghieu1;
    private javax.swing.JRadioButton rdodanhmuc1;
    private javax.swing.JTable tblThemThuocTinh;
    private javax.swing.JTextField txtTen;
    private swing.SearchText txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
