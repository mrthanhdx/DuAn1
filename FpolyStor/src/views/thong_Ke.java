/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

/**
 *
 * @author H
 */
public class thong_Ke extends javax.swing.JFrame {

    /**
     * Creates new form thong_Ke
     */
    public thong_Ke() {
        initComponents();
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
        panelBorder2 = new swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_doanhthu = new javax.swing.JLabel();
        panelBorder3 = new swing.PanelBorder();
        jLabel6 = new javax.swing.JLabel();
        lbl_loinhuanYear = new javax.swing.JLabel();
        lbl_sanpham = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        panelBorder4 = new swing.PanelBorder();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_hd = new javax.swing.JLabel();
        panelBorder1 = new swing.PanelBorder();
        Click_Nv = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tb_Sp = new javax.swing.JTable();
        rd_ngay = new javax.swing.JRadioButton();
        rd_thang = new javax.swing.JRadioButton();
        rd_nam = new javax.swing.JRadioButton();
        date_day = new com.toedter.calendar.JDayChooser();
        date_month = new com.toedter.calendar.JMonthChooser();
        date_year = new com.toedter.calendar.JYearChooser();
        btn_bieudo = new javax.swing.JButton();
        rd_khoang = new javax.swing.JRadioButton();
        date_tu = new com.toedter.calendar.JMonthChooser();
        Date_den = new com.toedter.calendar.JMonthChooser();
        lbl_tu = new javax.swing.JLabel();
        lbl_den = new javax.swing.JLabel();
        panelBorder5 = new swing.PanelBorder();
        lbl_kh = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1010, 640));

        panelGradiente1.setColorPrimario(new java.awt.Color(204, 255, 255));
        panelGradiente1.setColorSecundario(new java.awt.Color(255, 204, 255));
        panelGradiente1.setMaximumSize(new java.awt.Dimension(1000, 630));
        panelGradiente1.setMinimumSize(new java.awt.Dimension(1000, 630));
        panelGradiente1.setName(""); // NOI18N

        panelBorder2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Doanh thu");
        panelBorder2.add(jLabel1);
        jLabel1.setBounds(80, 0, 110, 40);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/money.png"))); // NOI18N
        panelBorder2.add(jLabel5);
        jLabel5.setBounds(30, 0, 40, 40);

        lbl_doanhthu.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_doanhthu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelBorder2.add(lbl_doanhthu);
        lbl_doanhthu.setBounds(10, 50, 210, 90);

        panelGradiente1.add(panelBorder2);
        panelBorder2.setBounds(10, 0, 230, 190);

        panelBorder3.setBackground(new java.awt.Color(204, 204, 255));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/box.png"))); // NOI18N
        panelBorder3.add(jLabel6);
        jLabel6.setBounds(40, 10, 40, 40);

        lbl_loinhuanYear.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        panelBorder3.add(lbl_loinhuanYear);
        lbl_loinhuanYear.setBounds(130, 140, 140, 30);

        lbl_sanpham.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_sanpham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelBorder3.add(lbl_sanpham);
        lbl_sanpham.setBounds(30, 60, 160, 100);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("Sản phẩm");
        panelBorder3.add(jLabel7);
        jLabel7.setBounds(80, 0, 130, 50);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("Sản phẩm");
        panelBorder3.add(jLabel8);
        jLabel8.setBounds(80, 0, 130, 50);

        panelGradiente1.add(panelBorder3);
        panelBorder3.setBounds(510, 0, 230, 190);

        panelBorder4.setBackground(new java.awt.Color(204, 204, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Hóa đơn");
        panelBorder4.add(jLabel2);
        jLabel2.setBounds(70, 0, 110, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bill.png"))); // NOI18N
        panelBorder4.add(jLabel4);
        jLabel4.setBounds(30, 0, 40, 40);

        lbl_hd.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_hd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelBorder4.add(lbl_hd);
        lbl_hd.setBounds(40, 50, 150, 100);

        panelGradiente1.add(panelBorder4);
        panelBorder4.setBounds(260, 0, 230, 190);

        panelBorder1.setBackground(new java.awt.Color(204, 204, 255));

        Tb_Sp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên sản phẩm", "Số lượt mua"
            }
        ));
        Tb_Sp.setRowHeight(25);
        jScrollPane2.setViewportView(Tb_Sp);

        Click_Nv.addTab("Sản phẩm", jScrollPane2);

        panelBorder1.add(Click_Nv);
        Click_Nv.setBounds(0, 90, 990, 340);

        rd_ngay.setBackground(new java.awt.Color(204, 204, 255));
        rd_ngay.setText("Ngày");
        rd_ngay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_ngayActionPerformed(evt);
            }
        });
        panelBorder1.add(rd_ngay);
        rd_ngay.setBounds(30, 0, 60, 21);

        rd_thang.setBackground(new java.awt.Color(204, 204, 255));
        rd_thang.setText("Tháng");
        rd_thang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_thangActionPerformed(evt);
            }
        });
        panelBorder1.add(rd_thang);
        rd_thang.setBounds(30, 20, 60, 21);

        rd_nam.setBackground(new java.awt.Color(204, 204, 255));
        rd_nam.setText("Năm");
        rd_nam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_namActionPerformed(evt);
            }
        });
        panelBorder1.add(rd_nam);
        rd_nam.setBounds(30, 40, 60, 20);

        date_day.setBackground(new java.awt.Color(255, 255, 255));
        date_day.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)));
        panelBorder1.add(date_day);
        date_day.setBounds(490, 10, 280, 110);

        date_month.setBackground(new java.awt.Color(255, 255, 255));
        date_month.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 2));
        panelBorder1.add(date_month);
        date_month.setBounds(200, 10, 110, 30);

        date_year.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 2));
        panelBorder1.add(date_year);
        date_year.setBounds(360, 10, 100, 30);

        btn_bieudo.setBackground(new java.awt.Color(153, 255, 204));
        btn_bieudo.setText("Biểu đồ");
        btn_bieudo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 2));
        btn_bieudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bieudoActionPerformed(evt);
            }
        });
        panelBorder1.add(btn_bieudo);
        btn_bieudo.setBounds(780, 30, 140, 40);

        rd_khoang.setBackground(new java.awt.Color(204, 204, 255));
        rd_khoang.setText("Tìm theo khoảng");
        rd_khoang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_khoangActionPerformed(evt);
            }
        });
        panelBorder1.add(rd_khoang);
        rd_khoang.setBounds(30, 60, 120, 21);
        panelBorder1.add(date_tu);
        date_tu.setBounds(200, 60, 125, 22);
        panelBorder1.add(Date_den);
        Date_den.setBounds(360, 60, 125, 22);

        lbl_tu.setText("Từ");
        panelBorder1.add(lbl_tu);
        lbl_tu.setBounds(170, 60, 20, 20);

        lbl_den.setText("Đến");
        panelBorder1.add(lbl_den);
        lbl_den.setBounds(330, 60, 30, 20);

        panelGradiente1.add(panelBorder1);
        panelBorder1.setBounds(10, 210, 990, 430);

        panelBorder5.setBackground(new java.awt.Color(204, 204, 255));

        lbl_kh.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_kh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelBorder5.add(lbl_kh);
        lbl_kh.setBounds(40, 50, 170, 100);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Khách hàng");
        panelBorder5.add(jLabel3);
        jLabel3.setBounds(60, 0, 130, 50);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/woman.png"))); // NOI18N
        panelBorder5.add(jLabel9);
        jLabel9.setBounds(20, 0, 40, 50);

        panelGradiente1.add(panelBorder5);
        panelBorder5.setBounds(760, 0, 230, 190);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradiente1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1012, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradiente1, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1012, Short.MAX_VALUE)
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

    private void rd_ngayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_ngayActionPerformed
     
    }//GEN-LAST:event_rd_ngayActionPerformed

    private void rd_thangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_thangActionPerformed
    

    }//GEN-LAST:event_rd_thangActionPerformed

    private void rd_namActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_namActionPerformed
      
    }//GEN-LAST:event_rd_namActionPerformed

    private void btn_bieudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bieudoActionPerformed
      
    }//GEN-LAST:event_btn_bieudoActionPerformed

    private void rd_khoangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_khoangActionPerformed
      
    }//GEN-LAST:event_rd_khoangActionPerformed

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
            java.util.logging.Logger.getLogger(thong_Ke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(thong_Ke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(thong_Ke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(thong_Ke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new thong_Ke().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Click_Nv;
    private com.toedter.calendar.JMonthChooser Date_den;
    private javax.swing.JTable Tb_Sp;
    private javax.swing.JButton btn_bieudo;
    private com.toedter.calendar.JDayChooser date_day;
    private com.toedter.calendar.JMonthChooser date_month;
    private com.toedter.calendar.JMonthChooser date_tu;
    private com.toedter.calendar.JYearChooser date_year;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_den;
    private javax.swing.JLabel lbl_doanhthu;
    private javax.swing.JLabel lbl_hd;
    private javax.swing.JLabel lbl_kh;
    private javax.swing.JLabel lbl_loinhuanYear;
    private javax.swing.JLabel lbl_sanpham;
    private javax.swing.JLabel lbl_tu;
    private swing.PanelBorder panelBorder1;
    private swing.PanelBorder panelBorder2;
    private swing.PanelBorder panelBorder3;
    private swing.PanelBorder panelBorder4;
    private swing.PanelBorder panelBorder5;
    private swing.PanelGradiente panelGradiente1;
    private javax.swing.JRadioButton rd_khoang;
    private javax.swing.JRadioButton rd_nam;
    private javax.swing.JRadioButton rd_ngay;
    private javax.swing.JRadioButton rd_thang;
    // End of variables declaration//GEN-END:variables
}
