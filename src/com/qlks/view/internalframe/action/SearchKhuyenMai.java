/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.view.internalframe.action;

import java.util.ResourceBundle;

/**
 *
 * @author hello
 */
public class SearchKhuyenMai extends javax.swing.JInternalFrame {

    CallBackSearch cb;
    private ResourceBundle rb;

    public interface CallBackSearch {

        void doSearch(String maSearchInput, String tenSearchInput, Boolean trangThai);
    }

    /**
     * Creates new form AddKhachHang
     */
    public SearchKhuyenMai(CallBackSearch _cb, ResourceBundle rb) {
        initComponents();
        resetText();
        this.cb = _cb;
        this.rb = rb;
        translate(this.rb);
    }

    public void resetText() {
        txtMaPhieu.setText("");
        txtNoiDung.setText("");
    }

    public void translate(ResourceBundle rb) {
        this.rb = rb;
        setTitle(this.rb.getString("AddKhuyenMai"));
        jlbTitle.setText(this.rb.getString("UpdateKhuyenMai"));
        jlbMaPhieu.setText(this.rb.getString("UpdateKhuyenMai"));
        jlbNoiDung.setText(this.rb.getString("JIFQLKhuyenMaiNoiDung"));
        jRadioChuaSD.setText(this.rb.getString("JIFQLKhuyenMaiChuaSD"));
        jRadioDaSD.setText(this.rb.getString("JIFQLKhuyenMaiDaSuDung"));
        jlbTrangThai.setText(this.rb.getString("JIFQLKhuyenMaiTrangThai"));

        btnLamMoi.setText(this.rb.getString("BtnLamMoi"));
        btnHuyBo.setText(this.rb.getString("BtnHuy"));
        btnTimKiem.setText(this.rb.getString("BtnTimKiem"));

        revalidate();
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RadioGroupTrangThai = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jlbTitle = new javax.swing.JLabel();
        jlbMaPhieu = new javax.swing.JLabel();
        txtMaPhieu = new javax.swing.JTextField();
        jlbNoiDung = new javax.swing.JLabel();
        txtNoiDung = new javax.swing.JTextField();
        btnHuyBo = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jlbTrangThai = new javax.swing.JLabel();
        jRadioChuaSD = new javax.swing.JRadioButton();
        jRadioDaSD = new javax.swing.JRadioButton();

        setClosable(true);
        setIconifiable(true);

        jlbTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbTitle.setText("TÌM KIẾM KHUYẾN MẠI");

        jlbMaPhieu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlbMaPhieu.setText("Mã code KM:");

        jlbNoiDung.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlbNoiDung.setText("Nội dung:");

        txtNoiDung.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnHuyBo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnHuyBo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_close.png"))); // NOI18N
        btnHuyBo.setText("Hủy bỏ");
        btnHuyBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyBoActionPerformed(evt);
            }
        });

        btnTimKiem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_search.png"))); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        btnLamMoi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_refresh.png"))); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        jlbTrangThai.setText("Trạng thái:");

        RadioGroupTrangThai.add(jRadioChuaSD);
        jRadioChuaSD.setText("Chưa sử dụng");

        RadioGroupTrangThai.add(jRadioDaSD);
        jRadioDaSD.setText("Đã sử dụng");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jlbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHuyBo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbMaPhieu)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jlbTrangThai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jlbNoiDung, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNoiDung, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRadioChuaSD)
                                .addGap(29, 29, 29)
                                .addComponent(jRadioDaSD)))))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jlbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbMaPhieu)
                    .addComponent(txtMaPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbNoiDung)
                    .addComponent(txtNoiDung, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbTrangThai)
                    .addComponent(jRadioChuaSD)
                    .addComponent(jRadioDaSD))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuyBo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        RadioGroupTrangThai.clearSelection();
        resetText();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnHuyBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyBoActionPerformed
        resetText();
        dispose();
    }//GEN-LAST:event_btnHuyBoActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        String MaLP = txtMaPhieu.getText().trim();
        String tenLP = txtNoiDung.getText().trim();
        Boolean ckeckTrangThai = null;

        if (jRadioDaSD.isSelected()) {
            ckeckTrangThai = true;
        } else if (jRadioChuaSD.isSelected()) {
            ckeckTrangThai = false;
        }

        cb.doSearch(MaLP, tenLP, ckeckTrangThai);
    }//GEN-LAST:event_btnTimKiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup RadioGroupTrangThai;
    private javax.swing.JButton btnHuyBo;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioChuaSD;
    private javax.swing.JRadioButton jRadioDaSD;
    private javax.swing.JLabel jlbMaPhieu;
    private javax.swing.JLabel jlbNoiDung;
    private javax.swing.JLabel jlbTitle;
    private javax.swing.JLabel jlbTrangThai;
    private javax.swing.JTextField txtMaPhieu;
    private javax.swing.JTextField txtNoiDung;
    // End of variables declaration//GEN-END:variables
}
