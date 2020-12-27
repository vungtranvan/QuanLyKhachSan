/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.view.internalframe.action;

import com.qlks.dao.impl.LoaiPhongDAO;
import com.qlks.models.LoaiPhong;
import javax.swing.JOptionPane;

/**
 *
 * @author hello
 */
public class UpdateLoaiPhong extends javax.swing.JInternalFrame {

    private LoaiPhongDAO loaiPhongDAO;

    CallBackUpdate cb;

    public interface CallBackUpdate {

        void doUpdate();
    }

    /**
     * Creates new form AddKhachHang
     */
    public UpdateLoaiPhong(LoaiPhong loaiPhong, CallBackUpdate _cb) {
        initComponents();
        resetText();
        loaiPhongDAO = new LoaiPhongDAO();
        this.cb = _cb;
        txtSoNguoiToiDa.setText(Integer.toString(loaiPhong.getSoNguoiToiDa()));
        txtMaLP.setText(loaiPhong.getMaLoaiPhong());
        txtTyLeTang.setText(Float.toString(loaiPhong.getTyLeTang()));
        txtTenLP.setText(loaiPhong.getTenLoaiPhong());
        txtDonGia.setText(Float.toString(loaiPhong.getDonGia()));
        txtSoNguoiToiThieu.setText(Integer.toString(loaiPhong.getSoNguoiChuan()));
    }

    public void resetText() {
        txtErrorSoNguoiToiThieu.setText("");
        txtErrorSoNguoiToiDa.setText("");
        txtErrorDonGia.setText("");
        txtErrorMaLP.setText("");
        txtErrorTyLeTang.setText("");
        txtErrorTenLP.setText("");

        txtSoNguoiToiDa.setText("");
        txtMaLP.setText("");
        txtTyLeTang.setText("");
        txtTenLP.setText("");
        txtDonGia.setText("");
        txtSoNguoiToiThieu.setText("");
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaLP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTenLP = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtSoNguoiToiDa = new javax.swing.JTextField();
        txtTyLeTang = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnHuyBo = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        txtErrorMaLP = new javax.swing.JLabel();
        txtErrorTenLP = new javax.swing.JLabel();
        txtErrorSoNguoiToiThieu = new javax.swing.JLabel();
        txtErrorSoNguoiToiDa = new javax.swing.JLabel();
        txtErrorDonGia = new javax.swing.JLabel();
        txtErrorTyLeTang = new javax.swing.JLabel();
        txtSoNguoiToiThieu = new javax.swing.JTextField();
        txtDonGia = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CẬP NHẬT LOẠI PHÒNG");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Mã loại phòng:");

        txtMaLP.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Tên loại phòng:");

        txtTenLP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Số người tối thiểu:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Số người tối đa:");

        txtSoNguoiToiDa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtTyLeTang.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Đơn giá:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Tỷ lệ tăng:");

        btnHuyBo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnHuyBo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_close.png"))); // NOI18N
        btnHuyBo.setText("Hủy bỏ");
        btnHuyBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyBoActionPerformed(evt);
            }
        });

        btnCapNhat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_edit.png"))); // NOI18N
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
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

        txtErrorMaLP.setForeground(new java.awt.Color(255, 51, 51));
        txtErrorMaLP.setText("...");

        txtErrorTenLP.setForeground(new java.awt.Color(255, 0, 0));
        txtErrorTenLP.setText("...");

        txtErrorSoNguoiToiThieu.setForeground(new java.awt.Color(255, 0, 0));
        txtErrorSoNguoiToiThieu.setText("...");

        txtErrorSoNguoiToiDa.setForeground(new java.awt.Color(255, 51, 51));
        txtErrorSoNguoiToiDa.setText("...");

        txtErrorDonGia.setForeground(new java.awt.Color(255, 0, 0));
        txtErrorDonGia.setText("...");

        txtErrorTyLeTang.setForeground(new java.awt.Color(255, 0, 0));
        txtErrorTyLeTang.setText("...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 225, Short.MAX_VALUE)
                                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnHuyBo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtMaLP, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSoNguoiToiThieu)
                                    .addComponent(txtDonGia)
                                    .addComponent(txtErrorMaLP, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                                    .addComponent(txtErrorSoNguoiToiThieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtErrorDonGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTyLeTang)
                                    .addComponent(txtSoNguoiToiDa, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtTenLP, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtErrorTyLeTang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                                    .addComponent(txtErrorSoNguoiToiDa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtErrorTenLP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(67, 67, 67))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaLP, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenLP, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtErrorMaLP)
                    .addComponent(txtErrorTenLP))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(txtSoNguoiToiDa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtSoNguoiToiThieu)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtErrorSoNguoiToiThieu)
                    .addComponent(txtErrorSoNguoiToiDa))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(txtTyLeTang, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtErrorDonGia)
                    .addComponent(txtErrorTyLeTang))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuyBo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        resetText();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnHuyBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyBoActionPerformed
        resetText();
        dispose();
    }//GEN-LAST:event_btnHuyBoActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        Boolean check = true;
        String MaLP = txtMaLP.getText();
        String tenLP = txtTenLP.getText();
        String soNgToiDa = txtSoNguoiToiDa.getText();
        String tyLeTang = txtTyLeTang.getText();
        String soNgToiThieu = txtSoNguoiToiThieu.getText();
        String donGia = txtDonGia.getText();

        if (MaLP.length() <= 0) {
            txtErrorMaLP.setText("Mã không được để trống");
            check = false;
        } else if (MaLP.length() > 3) {
            txtErrorMaLP.setText("Mã có tối đa là 3 ký tự");
            check = false;
        } else {
            txtErrorMaLP.setText("");
        }

        if (tenLP.length() <= 0) {
            txtErrorTenLP.setText("Không được để trống");
            check = false;
        } else if (tenLP.length() > 50) {
            txtErrorTenLP.setText("Tên có tối đa là 50 ký tự");
            check = false;
        } else {
            txtErrorTenLP.setText("");
        }

        int soNgToiThieuX = 0;
        if (soNgToiThieu.length() <= 0) {
            txtErrorSoNguoiToiThieu.setText("Không được để trống");
            check = false;
        } else {
            try {
                soNgToiThieuX = Integer.parseInt(soNgToiThieu);
                if (soNgToiThieuX < 0) {
                    txtErrorSoNguoiToiThieu.setText("Phải lớn hơn hoặc bằng 0");
                    check = false;
                }
            } catch (Exception e) {
                txtErrorSoNguoiToiThieu.setText("Phải lớn hơn hoặc bằng 0");
                check = false;
            }
        }

        int soNgToiDaX = 0;
        if (soNgToiDa.length() <= 0) {
            txtErrorSoNguoiToiDa.setText("Không được để trống");
            check = false;
        } else {
            try {
                soNgToiDaX = Integer.parseInt(soNgToiDa);
                if (soNgToiDaX < 0) {
                    txtErrorSoNguoiToiDa.setText("Phải lớn hơn hoặc bằng 0");
                    check = false;
                }
            } catch (Exception e) {
                txtErrorSoNguoiToiDa.setText("Phải lớn hơn hoặc bằng 0");
                check = false;
            }
        }

        Float donGiaX = null;
        if (donGia.length() <= 0) {
            txtErrorDonGia.setText("Không được để trống");
            check = false;
        } else {
            try {
                donGiaX = Float.parseFloat(donGia);
                if (donGiaX < 0) {
                    txtErrorDonGia.setText("Phải lớn hơn hoặc bằng 0");
                    check = false;
                }
            } catch (Exception e) {
                txtErrorDonGia.setText("Phải lớn hơn hoặc bằng 0");
                check = false;
            }
        }

        Float tyLeTangX = null;
        if (tyLeTang.length() <= 0) {
            txtErrorTyLeTang.setText("Không được để trống");
            check = false;
        } else {
            try {
                tyLeTangX = Float.parseFloat(tyLeTang);
                if (tyLeTangX < 0) {
                    txtErrorTyLeTang.setText("Phải lớn hơn hoặc bằng 0");
                    check = false;
                }
            } catch (Exception e) {
                txtErrorTyLeTang.setText("Phải lớn hơn hoặc bằng 0");
                check = false;
            }
        }

        if (check == true) {
            txtErrorDonGia.setText("");
            int row = loaiPhongDAO.update(new LoaiPhong(MaLP, tenLP, donGiaX, soNgToiThieuX, soNgToiDaX, tyLeTangX));
            if (row > 0) {
                JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                resetText();
                cb.doUpdate();
                dispose();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Cập nhật thất bại", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnHuyBo;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JLabel txtErrorDonGia;
    private javax.swing.JLabel txtErrorMaLP;
    private javax.swing.JLabel txtErrorSoNguoiToiDa;
    private javax.swing.JLabel txtErrorSoNguoiToiThieu;
    private javax.swing.JLabel txtErrorTenLP;
    private javax.swing.JLabel txtErrorTyLeTang;
    private javax.swing.JTextField txtMaLP;
    private javax.swing.JTextField txtSoNguoiToiDa;
    private javax.swing.JTextField txtSoNguoiToiThieu;
    private javax.swing.JTextField txtTenLP;
    private javax.swing.JTextField txtTyLeTang;
    // End of variables declaration//GEN-END:variables
}