/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

/**
 *
 * @author H
 */
public class khuyen_mai extends javax.swing.JFrame {

    /**
     * Creates new form khuyen_mai
     */
    public khuyen_mai() {
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
        panelBorder1 = new swing.PanelBorder();
        jLabel2 = new javax.swing.JLabel();
        txt_tenkm = new swing.MyTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rd_VND = new javax.swing.JRadioButton();
        rd_phantram = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        txt_giatrgiam = new swing.MyTextField();
        jLabel8 = new javax.swing.JLabel();
        btn_them = new swing.MyButton();
        btn_sua = new swing.MyButton();
        btn_clear = new swing.MyButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_sp = new javax.swing.JTable();
        cb_selectAll = new javax.swing.JCheckBox();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_khuyenmai = new javax.swing.JTable();
        panelBorder2 = new swing.PanelBorder();
        src_timkiem = new swing.SearchText();
        lbl_timkiem = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1010, 640));

        panelGradiente1.setBackground(new java.awt.Color(204, 255, 255));
        panelGradiente1.setColorPrimario(new java.awt.Color(204, 255, 255));
        panelGradiente1.setColorSecundario(new java.awt.Color(255, 204, 255));

        panelBorder1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Ngày bắt đầu");
        panelBorder1.add(jLabel2);
        jLabel2.setBounds(390, 0, 260, 20);
        panelBorder1.add(txt_tenkm);
        txt_tenkm.setBounds(60, 20, 260, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Tên khuyễn mãi");
        panelBorder1.add(jLabel3);
        jLabel3.setBounds(60, 0, 260, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Hình thức giảm giá");
        panelBorder1.add(jLabel4);
        jLabel4.setBounds(390, 130, 130, 30);

        rd_VND.setBackground(new java.awt.Color(204, 204, 255));
        rd_VND.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rd_VND.setText("VND");
        panelBorder1.add(rd_VND);
        rd_VND.setBounds(530, 130, 50, 30);

        rd_phantram.setBackground(new java.awt.Color(204, 204, 255));
        rd_phantram.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rd_phantram.setText("%");
        panelBorder1.add(rd_phantram);
        rd_phantram.setBounds(600, 130, 50, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Ngày kết thúc");
        panelBorder1.add(jLabel6);
        jLabel6.setBounds(60, 60, 260, 20);
        panelBorder1.add(txt_giatrgiam);
        txt_giatrgiam.setBounds(390, 80, 260, 40);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Giá trị giảm");
        panelBorder1.add(jLabel8);
        jLabel8.setBounds(390, 60, 260, 20);

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
        btn_them.setBounds(750, 30, 130, 40);

        btn_sua.setBackground(new java.awt.Color(125, 224, 237));
        btn_sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/floppy-disk.png"))); // NOI18N
        btn_sua.setText("Cập nhật");
        btn_sua.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });
        panelBorder1.add(btn_sua);
        btn_sua.setBounds(750, 100, 130, 40);

        btn_clear.setBackground(new java.awt.Color(125, 224, 237));
        btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        btn_clear.setText("Làm mới");
        btn_clear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });
        panelBorder1.add(btn_clear);
        btn_clear.setBounds(750, 170, 130, 40);

        tb_sp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Select", "Mã sản phẩm", "Tên sản phẩm"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tb_sp);

        panelBorder1.add(jScrollPane2);
        jScrollPane2.setBounds(20, 160, 580, 130);

        cb_selectAll.setBackground(new java.awt.Color(204, 204, 255));
        cb_selectAll.setText("Select All");
        cb_selectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_selectAllActionPerformed(evt);
            }
        });
        panelBorder1.add(cb_selectAll);
        cb_selectAll.setBounds(20, 130, 71, 20);

        jDateChooser1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 2));
        panelBorder1.add(jDateChooser1);
        jDateChooser1.setBounds(60, 80, 260, 40);

        jDateChooser2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 2));
        panelBorder1.add(jDateChooser2);
        jDateChooser2.setBounds(390, 20, 260, 40);

        panelGradiente1.add(panelBorder1);
        panelBorder1.setBounds(10, 0, 990, 300);

        tb_khuyenmai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên khuyến mãi", "Ngày bắt đầu", "Ngày kết thúc", "Giá trị giảm", "Trạng thái"
            }
        ));
        tb_khuyenmai.setRowHeight(25);
        tb_khuyenmai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_khuyenmaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_khuyenmai);

        panelGradiente1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 370, 990, 260);

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));

        src_timkiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                src_timkiemCaretUpdate(evt);
            }
        });
        panelBorder2.add(src_timkiem);
        src_timkiem.setBounds(10, 0, 240, 40);

        lbl_timkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search_24px.png"))); // NOI18N
        lbl_timkiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_timkiemMouseClicked(evt);
            }
        });
        panelBorder2.add(lbl_timkiem);
        lbl_timkiem.setBounds(250, 0, 40, 40);

        panelGradiente1.add(panelBorder2);
        panelBorder2.setBounds(660, 310, 290, 40);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Ngày kết thúc");
        panelGradiente1.add(jLabel7);
        jLabel7.setBounds(370, 300, 260, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Ngày bắt đầu");
        panelGradiente1.add(jLabel5);
        jLabel5.setBounds(50, 300, 260, 20);

        jDateChooser5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 2));
        panelGradiente1.add(jDateChooser5);
        jDateChooser5.setBounds(370, 320, 260, 40);

        jDateChooser3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 2));
        panelGradiente1.add(jDateChooser3);
        jDateChooser3.setBounds(50, 320, 260, 40);

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

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:
     
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
     
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
     
    }//GEN-LAST:event_btn_clearActionPerformed

    private void cb_selectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_selectAllActionPerformed
     
    }//GEN-LAST:event_cb_selectAllActionPerformed

    private void tb_khuyenmaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_khuyenmaiMouseClicked
      
    }//GEN-LAST:event_tb_khuyenmaiMouseClicked

    private void src_timkiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_src_timkiemCaretUpdate

    }//GEN-LAST:event_src_timkiemCaretUpdate

    private void lbl_timkiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_timkiemMouseClicked
       
    }//GEN-LAST:event_lbl_timkiemMouseClicked

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
            java.util.logging.Logger.getLogger(khuyen_mai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(khuyen_mai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(khuyen_mai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(khuyen_mai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new khuyen_mai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.MyButton btn_clear;
    private swing.MyButton btn_sua;
    private swing.MyButton btn_them;
    private javax.swing.JCheckBox cb_selectAll;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_timkiem;
    private swing.PanelBorder panelBorder1;
    private swing.PanelBorder panelBorder2;
    private swing.PanelGradiente panelGradiente1;
    private javax.swing.JRadioButton rd_VND;
    private javax.swing.JRadioButton rd_phantram;
    private swing.SearchText src_timkiem;
    private javax.swing.JTable tb_khuyenmai;
    private javax.swing.JTable tb_sp;
    private swing.MyTextField txt_giatrgiam;
    private swing.MyTextField txt_tenkm;
    // End of variables declaration//GEN-END:variables
}
