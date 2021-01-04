/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.view.internalframe.action;

import com.qlks.dao.impl.LoaiPhongDAO;
import com.qlks.dao.impl.LoaiTinhTrangDAO;
import com.qlks.dao.impl.PhongDAO;
import com.qlks.models.LoaiPhong;
import com.qlks.models.LoaiTinhTrang;
import com.qlks.models.Phong;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author hello
 */
public class SearchPhong extends javax.swing.JInternalFrame {

    private LoaiPhongDAO loaiPhongDAO;
    private List<LoaiPhong> lstLoaiPhong;
    private DefaultComboBoxModel modelLoaiPhong;
    private LoaiTinhTrangDAO loaiTinhTrangDAO;
    private List<LoaiTinhTrang> lstLoaiTinhTrang;
    private DefaultComboBoxModel modelLoaiTinhTrang;

    CallBackSearch cb;
    private ResourceBundle rb;

    public interface CallBackSearch {

        void doSearch(String maPhong, String maLoaiPhong, int maLoaiTinhTrangPhong);
    }

    /**
     * Creates new form AddKhachHang
     */
    public SearchPhong(CallBackSearch _cb, ResourceBundle rb) {
        initComponents();

        modelLoaiPhong = new DefaultComboBoxModel();
        loaiPhongDAO = new LoaiPhongDAO();
        lstLoaiPhong = loaiPhongDAO.getAll();

        modelLoaiTinhTrang = new DefaultComboBoxModel();
        loaiTinhTrangDAO = new LoaiTinhTrangDAO();
        lstLoaiTinhTrang = loaiTinhTrangDAO.getAll();

        resetText();
        this.cb = _cb;
        initDataLoaiPhong();
        initDataLoaiTinhTrang();
        this.rb = rb;
        translate(this.rb);
    }

    public void initDataLoaiPhong() {
        modelLoaiPhong.addElement("");
        for (LoaiPhong adv : lstLoaiPhong) {
            modelLoaiPhong.addElement(adv);
        }
        jcbMaLoaiPhong.setModel(modelLoaiPhong);
    }

    public void initDataLoaiTinhTrang() {
        modelLoaiTinhTrang.addElement("");
        for (LoaiTinhTrang adv : lstLoaiTinhTrang) {
            modelLoaiTinhTrang.addElement(adv);
        }
        jComboBoxMaTinhTrang.setModel(modelLoaiTinhTrang);
    }

    public void resetText() {
        txtMaPhong.setText("");
    }

    public void translate(ResourceBundle rb) {
        this.rb = rb;
        setTitle(this.rb.getString("SearchPhong"));
        jlbTitle.setText(this.rb.getString("SearchPhong"));
        jlbMaPhong.setText(this.rb.getString("JIFQuanLyPhongMaPhong"));
        jlbTenLoaiPhong.setText(this.rb.getString("AddLoaiPhongTen"));
        jlbTinhTrang.setText(this.rb.getString("JIFQuanLyPhongTinhTrang"));

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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jlbTitle = new javax.swing.JLabel();
        jlbMaPhong = new javax.swing.JLabel();
        txtMaPhong = new javax.swing.JTextField();
        jlbTenLoaiPhong = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnHuyBo = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jcbMaLoaiPhong = new javax.swing.JComboBox<>();
        jComboBoxMaTinhTrang = new javax.swing.JComboBox<>();
        jlbTinhTrang = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);

        jlbTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbTitle.setText("TÌM KIẾM PHÒNG");

        jlbMaPhong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlbMaPhong.setText("Mã phòng:");

        jlbTenLoaiPhong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlbTenLoaiPhong.setText("Tên loại phòng:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

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

        jlbTinhTrang.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlbTinhTrang.setText("Tình trạng:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbMaPhong)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlbTenLoaiPhong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jlbTinhTrang))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHuyBo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtMaPhong)
                    .addComponent(jcbMaLoaiPhong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxMaTinhTrang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 58, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jlbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbMaPhong)
                    .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbTenLoaiPhong)
                    .addComponent(jcbMaLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbTinhTrang)
                    .addComponent(jComboBoxMaTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuyBo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jLabel6)
                .addContainerGap(34, Short.MAX_VALUE))
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
        jComboBoxMaTinhTrang.setSelectedIndex(0);
        jcbMaLoaiPhong.setSelectedIndex(0);
        resetText();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnHuyBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyBoActionPerformed
        resetText();
        dispose();
    }//GEN-LAST:event_btnHuyBoActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        Boolean check = true;
        String maPhong = txtMaPhong.getText();

        LoaiPhong lp = null;
        String maLoaiPhong = "";
        try {
            lp = (LoaiPhong) modelLoaiPhong.getSelectedItem();
            maLoaiPhong = lp.getMaLoaiPhong();
        } catch (Exception e) {
            maLoaiPhong = "";
        }

        LoaiTinhTrang loaiTT = null;
        int maLoaiTT = 0;
        try {
            loaiTT = (LoaiTinhTrang) modelLoaiTinhTrang.getSelectedItem();
            maLoaiTT = loaiTT.getMaLoaiTinhTrangPhong();
        } catch (Exception e) {
            maLoaiTT = 0;
        }

        cb.doSearch(maPhong, maLoaiPhong, maLoaiTT);

    }//GEN-LAST:event_btnTimKiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuyBo;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<LoaiTinhTrang> jComboBoxMaTinhTrang;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<LoaiPhong> jcbMaLoaiPhong;
    private javax.swing.JLabel jlbMaPhong;
    private javax.swing.JLabel jlbTenLoaiPhong;
    private javax.swing.JLabel jlbTinhTrang;
    private javax.swing.JLabel jlbTitle;
    private javax.swing.JTextField txtMaPhong;
    // End of variables declaration//GEN-END:variables
}
