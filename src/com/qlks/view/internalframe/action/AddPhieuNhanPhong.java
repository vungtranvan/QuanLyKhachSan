/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.view.internalframe.action;

import com.qlks.custom.RanDomMaSDDV;
import com.qlks.dao.impl.ChiTietPhieuNhanPhongDAO;
import com.qlks.dao.impl.ChiTietPhieuThuePhongDAO;
import com.qlks.dao.impl.DanhSachSuDungDichVuDAO;
import com.qlks.dao.impl.KhachHangDAO;
import com.qlks.dao.impl.PhieuNhanPhongDAO;
import com.qlks.dao.impl.PhieuThuePhongDAO;
import com.qlks.dao.impl.PhongDAO;
import com.qlks.models.ChiTietPhieuNhanPhong;
import com.qlks.models.ChiTietPhieuThuePhong;
import com.qlks.models.KhachHang;
import com.qlks.models.PhieuNhanPhong;
import com.qlks.models.PhieuThuePhong;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hello
 */
public class AddPhieuNhanPhong extends javax.swing.JInternalFrame {

    private CallBackAdd cb;
    private PhieuThuePhongDAO phieuThuePhongDAO;
    private PhieuNhanPhongDAO phieuNhanPhongDAO;
    private ChiTietPhieuThuePhongDAO chiTietPhieuThuePhongDAO;
    private ChiTietPhieuNhanPhongDAO chiTietPhieuNhanPhongDAO;
    private PhongDAO phongDAO;
    private List<PhieuThuePhong> lstPhieuThuePhong;
    private DefaultTableModel dtmPhieuThuePhong;
    private DanhSachSuDungDichVuDAO danhSachSuDungDichVuDAO;
    private KhachHangDAO khachHangDAO;

    public interface CallBackAdd {

        void doAdd();
    }

    public AddPhieuNhanPhong(CallBackAdd _cb) {
        initComponents();
        cb = _cb;
        danhSachSuDungDichVuDAO = new DanhSachSuDungDichVuDAO();
        phieuNhanPhongDAO = new PhieuNhanPhongDAO();
        phieuThuePhongDAO = new PhieuThuePhongDAO();
        dtmPhieuThuePhong = new DefaultTableModel();
        chiTietPhieuThuePhongDAO = new ChiTietPhieuThuePhongDAO();
        phongDAO = new PhongDAO();
        chiTietPhieuNhanPhongDAO = new ChiTietPhieuNhanPhongDAO();
        khachHangDAO = new KhachHangDAO();
        resetText();
        initdataTablePhong();
    }

    public void initdataTablePhong() {
        lstPhieuThuePhong = phieuThuePhongDAO.getChuaXuLy();
        Object[] columnNames = {"STT", "Mã phiếu thuê", "Mã khách hàng", "Tên khách hàng", "Mã phòng", "Ngày đăng ký", "Ngày nhận", "Ngày trả dự kiến"};
        dtmPhieuThuePhong = new DefaultTableModel(new Object[0][0], columnNames);
        int index = 1;
        for (PhieuThuePhong adv : lstPhieuThuePhong) {
            Object[] o = new Object[8];
            o[0] = index;
            o[1] = adv.getMaPhieuThue();
            o[2] = adv.getMaKhachHang();
            o[3] = adv.getTenKhachHang();
            o[4] = adv.getMaPhong();
            o[5] = adv.getNgayDangKy();
            o[6] = adv.getNgayNhan();
            o[7] = adv.getNgayTraDuKien();
            dtmPhieuThuePhong.addRow(o);
            index++;
        }
        tblPhieuThuePhong.setModel(dtmPhieuThuePhong);

        // Click lên bảng
        if (lstPhieuThuePhong.size() > 0) {
            tblPhieuThuePhong.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

                @Override
                public void valueChanged(ListSelectionEvent e) {
                    int pos = tblPhieuThuePhong.getSelectedRow();
                    if (pos < 0) {
                        pos = 0;
                    }
                    if (pos >= 0) {
                        String ma_PhieuThue = tblPhieuThuePhong.getValueAt(pos, 1).toString();
                        List<ChiTietPhieuThuePhong> lstPhieuThue = chiTietPhieuThuePhongDAO.getByMaPhieuThue(ma_PhieuThue);
                        for (ChiTietPhieuThuePhong adm : lstPhieuThue) {
                            LocalDate ngayBD = adm.getNgayNhan();

                            Date dateBD = java.sql.Date.valueOf(ngayBD);
                            txtNgayNhan.setDate(dateBD);

                            LocalDate ngayTraDK = adm.getNgayTraDuKien();
                            Date dateTra = java.sql.Date.valueOf(ngayTraDK);
                            txtNgayTraDuKien.setDate(dateTra);
                        }
                        txtTenKhachHang.setText(tblPhieuThuePhong.getValueAt(pos, 3).toString());
                        txtMaPhong.setText(tblPhieuThuePhong.getValueAt(pos, 4).toString());
                    }
                }
            });
        }
    }

    public void resetText() {
        txtMaNhanPhong.setText("");
        txtErrorMaNhanPhong.setText("");
        txtNgayNhan.setCalendar(null);
        txtNgayTraDuKien.setCalendar(null);
        txtErrorNgayTraDuKien.setText("");
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
        txtMaNhanPhong = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNgayNhan = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        txtNgayTraDuKien = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        btnNhanPhong = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtErrorMaNhanPhong = new javax.swing.JLabel();
        txtErrorNgayTraDuKien = new javax.swing.JLabel();
        txtMaPhong = new javax.swing.JTextField();
        txtTenKhachHang = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPhieuThuePhong = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);

        txtMaNhanPhong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Mã nhận phòng:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Tên khách hàng:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Mã phòng:");

        txtNgayNhan.setDateFormatString("dd/MM/yyyy");
        txtNgayNhan.setEnabled(false);
        txtNgayNhan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Ngày nhận:");

        txtNgayTraDuKien.setDateFormatString("dd/MM/yyyy");
        txtNgayTraDuKien.setEnabled(false);
        txtNgayTraDuKien.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Ngày trả dự kiến:");

        btnNhanPhong.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNhanPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_add.png"))); // NOI18N
        btnNhanPhong.setText("Nhận phòng");
        btnNhanPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanPhongActionPerformed(evt);
            }
        });

        btnHuy.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_close.png"))); // NOI18N
        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÊM MỚI PHIẾU NHẬN PHÒNG");

        txtErrorMaNhanPhong.setForeground(new java.awt.Color(255, 51, 51));
        txtErrorMaNhanPhong.setText("...");

        txtErrorNgayTraDuKien.setForeground(new java.awt.Color(255, 0, 0));
        txtErrorNgayTraDuKien.setText("...");

        txtMaPhong.setEnabled(false);

        txtTenKhachHang.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(50, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(29, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtErrorNgayTraDuKien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtErrorMaNhanPhong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMaNhanPhong, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNgayNhan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNgayTraDuKien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMaPhong)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addComponent(btnNhanPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtTenKhachHang, javax.swing.GroupLayout.Alignment.LEADING))))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaNhanPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtErrorMaNhanPhong)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(txtNgayNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel5)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(txtNgayTraDuKien, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtErrorNgayTraDuKien)
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNhanPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách phiếu đăng ký phòng"));

        tblPhieuThuePhong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblPhieuThuePhong.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblPhieuThuePhong);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        dispose();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnNhanPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanPhongActionPerformed
        int currentRow = tblPhieuThuePhong.getSelectedRow();

        Boolean check = true;
        String ma_NhanPhong = txtMaNhanPhong.getText();

        if (ma_NhanPhong.length() <= 0) {
            txtErrorMaNhanPhong.setText("Mã phiếu nhận không được để trống");
            check = false;
        } else if (ma_NhanPhong.length() > 5) {
            txtErrorMaNhanPhong.setText("Mã phiếu nhận có tối đa là 5 ký tự");
            check = false;
        } else {
            txtErrorMaNhanPhong.setText("");
        }

        try {
            List<ChiTietPhieuNhanPhong> lstCheckID = chiTietPhieuNhanPhongDAO.getByMaNhanPhong(ma_NhanPhong);
            if (lstCheckID.size() > 0) {
                txtErrorMaNhanPhong.setText("Mã phiếu nhận phòng đã tồn tại !");
                check = false;
            }
        } catch (Exception e) {
            txtErrorMaNhanPhong.setText("Mã phiếu nhận phòng đã tồn tại !");
            check = false;
        }

        LocalDate dateNhan = null;
        if (txtNgayNhan.getDate() != null) {
            dateNhan = txtNgayNhan.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }

        LocalDate dateTraDuKien = null;
        if (txtNgayTraDuKien.getDate() != null) {
            dateTraDuKien = txtNgayTraDuKien.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        } else {
            txtErrorNgayTraDuKien.setText("Ngày trả dự kiến ko được để trống");
            check = false;
        }

        String ma_PhieuThue = dtmPhieuThuePhong.getValueAt(currentRow, 1).toString();
        String ma_KH = dtmPhieuThuePhong.getValueAt(currentRow, 2).toString();
        String ma_Phong = txtMaPhong.getText();
        String ten_KH = txtTenKhachHang.getText();
        String CMND = "";
        List<KhachHang> lstKhachHangByID = khachHangDAO.getByMa(ma_KH);
        for (KhachHang kh : lstKhachHangByID) {
            CMND = kh.getChungMinhThuNhanDan();
        }
        if (check == true) {

            int count1 = phieuNhanPhongDAO.add(new PhieuNhanPhong(ma_NhanPhong, ma_PhieuThue, ma_KH));
            int count2 = chiTietPhieuNhanPhongDAO.add(new ChiTietPhieuNhanPhong(ma_NhanPhong, ma_Phong, ten_KH, CMND, dateNhan, dateTraDuKien));

            if (count1 > 0 && count2 > 0) {
                phieuThuePhongDAO.updateTrangThai(ma_PhieuThue);
                phongDAO.updatePhongDaNhan(ma_Phong);
                RanDomMaSDDV rd = new RanDomMaSDDV();
                danhSachSuDungDichVuDAO.addDefault(rd.rDomMaSDVV(), ma_NhanPhong);
                tblPhieuThuePhong.clearSelection();
                JOptionPane.showMessageDialog(rootPane, "Nhận phòng thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                resetText();
                cb.doAdd();
                dispose();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Nhận phòng thất bại", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }

        }

    }//GEN-LAST:event_btnNhanPhongActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnNhanPhong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblPhieuThuePhong;
    private javax.swing.JLabel txtErrorMaNhanPhong;
    private javax.swing.JLabel txtErrorNgayTraDuKien;
    private javax.swing.JTextField txtMaNhanPhong;
    private javax.swing.JTextField txtMaPhong;
    private com.toedter.calendar.JDateChooser txtNgayNhan;
    private com.toedter.calendar.JDateChooser txtNgayTraDuKien;
    private javax.swing.JTextField txtTenKhachHang;
    // End of variables declaration//GEN-END:variables
}
