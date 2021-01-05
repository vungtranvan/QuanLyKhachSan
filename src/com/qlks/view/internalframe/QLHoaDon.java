/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.view.internalframe;

import com.qlks.custom.FunctionBase;
import com.qlks.dao.impl.HoaDonDAO;
import com.qlks.dao.impl.KhachHangDAO;
import com.qlks.models.HoaDon;
import com.qlks.models.KhachHang;
import com.qlks.view.internalframe.action.AddKhachHang;
import com.qlks.view.internalframe.action.SearchKhachHang;
import com.qlks.view.internalframe.action.UpdateKhachHang;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hello
 */
public class QLHoaDon extends javax.swing.JInternalFrame implements AddKhachHang.CallBackAdd, UpdateKhachHang.CallBackUpdate, SearchKhachHang.CallBackSearch {

    private HoaDonDAO hoaDonDAO;
    private List<HoaDon> lstHoaDon;
    private DefaultTableModel dtmHoaDon;
    private JDesktopPane jdek;
    private FunctionBase funcBase;
    private KhachHangDAO khachHangDAO;

    public QLHoaDon() {
        initComponents();
        khachHangDAO = new KhachHangDAO();
        dtmHoaDon = new DefaultTableModel();
        hoaDonDAO = new HoaDonDAO();
        funcBase = new FunctionBase();
        loadData(null, null, null, null, null, null, null);
    }

    public void loadData(String maSearchInput, String tenSearchInput, String CMNDSearchInput,
            String diaChiSearchInput, String dienThoaiSearchInput, Boolean gioiTinhSearchInput, String quocTichSearchInput) {

        if (maSearchInput != null || tenSearchInput != null || CMNDSearchInput != null
                || diaChiSearchInput != null || dienThoaiSearchInput != null || quocTichSearchInput != null) {

            // lstHoaDon = hoaDonDAO.search(maSearchInput, tenSearchInput, CMNDSearchInput, diaChiSearchInput,
            // dienThoaiSearchInput, quocTichSearchInput);
        } else {
            lstHoaDon = hoaDonDAO.getAll();
        }

        Object[] columnNames = {"STT", "Mã hóa đơn", "Mã khách hàng", "Tên khách hàng", "Mã nhận phòng", "Nhân viên lập", "Tổng tiền", "Ngày lập", ""};
        dtmHoaDon = new DefaultTableModel(new Object[0][0], columnNames);
        int index = 1;
        for (HoaDon adv : lstHoaDon) {
            Object[] o = new Object[8];
            o[0] = index;
            o[1] = adv.getMaHoaDon();
            o[2] = adv.getMaKhachHang();
            List<KhachHang> lstKHbyID = khachHangDAO.getByMa(adv.getMaKhachHang());
            for (KhachHang lst : lstKHbyID) {
                o[3] = lst.getTenKhachHang();
            }
            o[4] = adv.getMaNhanPhong();
            o[5] = adv.getNhanVienLap();
            o[6] = adv.getTongTien();
            o[7] = adv.getNgayLap();
            dtmHoaDon.addRow(o);
            index++;
        }
        tblHoaDon.setModel(dtmHoaDon);
    }

    public void centerJIF(JInternalFrame jif) {
        Dimension desktopSize = jdek.getSize();
        Dimension jInternalFrameSize = jif.getSize();
        int width = (desktopSize.width - jInternalFrameSize.width) / 2;
        int height = (desktopSize.height - jInternalFrameSize.height) / 2;
        jif.setLocation(width, height);
        jif.setVisible(true);
    }

    public void showInternalFrame(JInternalFrame jif) {
        if (!jif.isVisible()) {
            jdek = getDesktopPane();
            jdek.add(jif);
            centerJIF(jif);
            jif.setVisible(true);
            jdek.show();
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
        btnLamMoi = new javax.swing.JButton();
        btnInHoaDon = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        btnChiTiet = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Quản lý hóa đơn");

        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_refresh.png"))); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });
        btnLamMoi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnLamMoiKeyPressed(evt);
            }
        });

        btnInHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_printer.png"))); // NOI18N
        btnInHoaDon.setText("In hóa đơn");
        btnInHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInHoaDonActionPerformed(evt);
            }
        });

        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_search.png"))); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        btnChiTiet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_date.png"))); // NOI18N
        btnChiTiet.setText("Chi Tiết");
        btnChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(btnInHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(240, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblHoaDon);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInHoaDonActionPerformed
        //QuanLyCauHinh jInterFrame = new QuanLyCauHinh();
        // showInternalFrame(new AddKhachHang(this));
    }//GEN-LAST:event_btnInHoaDonActionPerformed

    private void btnLamMoiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnLamMoiKeyPressed
        loadData(null, null, null, null, null, null, null);
    }//GEN-LAST:event_btnLamMoiKeyPressed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        loadData(null, null, null, null, null, null, null);
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietActionPerformed
        int currentRow = tblHoaDon.getSelectedRow();

        if (currentRow >= 0) {
//            String maKH = dtmHoaDon.getValueAt(currentRow, 1).toString();
//            String tenKH = dtmHoaDon.getValueAt(currentRow, 2).toString();
//            String CMND = dtmHoaDon.getValueAt(currentRow, 3).toString();
//            String diaChi = dtmHoaDon.getValueAt(currentRow, 4).toString();
//            String dienThoai = dtmHoaDon.getValueAt(currentRow, 5).toString();
//            String gioiTinhInTable = dtmHoaDon.getValueAt(currentRow, 6).toString();
//            Boolean gioiTinh = true;
//            if (gioiTinhInTable.equals("Nữ")) {
//                gioiTinh = false;
//            }
//            String quocTich = dtmHoaDon.getValueAt(currentRow, 7).toString();
//            KhachHang dataKH = new KhachHang(maKH, tenKH, CMND, diaChi, dienThoai, gioiTinh, quocTich);
//            showInternalFrame(new UpdateKhachHang(dataKH, this));
        } else {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn hàng để cập nhật", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnChiTietActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        showInternalFrame(new SearchKhachHang(this));
    }//GEN-LAST:event_btnTimKiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChiTiet;
    private javax.swing.JButton btnInHoaDon;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHoaDon;
    // End of variables declaration//GEN-END:variables

    @Override
    public void doAdd() {
        loadData(null, null, null, null, null, null, null);
    }

    @Override
    public void doUpdate() {
        loadData(null, null, null, null, null, null, null);
    }

    @Override
    public void doSearch(String maSearchInput, String tenSearchInput, String CMNDSearchInput, String diaChiSearchInput, String dienThoaiSearchInput, Boolean gioiTinhSearchInput, String quocTichSearchInput) {
        loadData(maSearchInput, tenSearchInput, CMNDSearchInput, diaChiSearchInput, dienThoaiSearchInput, gioiTinhSearchInput, quocTichSearchInput);
    }
}
