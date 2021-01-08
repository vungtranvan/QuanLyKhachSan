/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.view.internalframe.action;

import com.qlks.custom.FunctionBase;
import com.qlks.custom.RanDomMa;
import com.qlks.dao.impl.ChiTietPhieuNhanPhongDAO;
import com.qlks.dao.impl.ChiTietPhieuThuePhongDAO;
import com.qlks.dao.impl.KhachHangDAO;
import com.qlks.dao.impl.PhieuThuePhongDAO;
import com.qlks.dao.impl.PhongDAO;
import com.qlks.models.ChiTietPhieuNhanPhong;
import com.qlks.models.ChiTietPhieuThuePhong;
import com.qlks.models.KhachHang;
import com.qlks.models.PhieuThuePhong;
import com.qlks.models.Phong;
import com.qlks.utils.MethodMain;
import java.awt.Dimension;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hello
 */
public class AddPhieuThuePhong extends javax.swing.JInternalFrame implements AddKhachHang.CallBackAdd {

    private CallBackAdd cb;
    private PhieuThuePhongDAO phieuThuePhongDAO;
    private ChiTietPhieuThuePhongDAO chiTietPhieuThuePhongDAO;

    private ChiTietPhieuNhanPhongDAO chiTietPhieuNhanPhongDAO;

    private PhongDAO phongDAO;
    private List<Phong> lstPhong;
    private DefaultTableModel dtmPhong;

    private KhachHangDAO khachHangDAO;
    private List<KhachHang> lstKhachHang;
    private DefaultTableModel dtmKhachHang;
    private DefaultComboBoxModel modelKhachHang;
    private JDesktopPane jdek;
    private FunctionBase funcBase;
    private List<String> lstMaPhong;
    private RanDomMa ranDomMa;
    ResourceBundle rb;

    @Override
    public void doAddKH() {
        initdataTableKhachHang();
    }

    public interface CallBackAdd {

        void doAdd();
    }

    public AddPhieuThuePhong(CallBackAdd _cb,ResourceBundle rb) {
        this.rb = rb;
        initComponents();
        funcBase = new FunctionBase();
        cb = _cb;
        phieuThuePhongDAO = new PhieuThuePhongDAO();
        chiTietPhieuThuePhongDAO = new ChiTietPhieuThuePhongDAO();
        chiTietPhieuNhanPhongDAO = new ChiTietPhieuNhanPhongDAO();
        phongDAO = new PhongDAO();
        ranDomMa = new RanDomMa();
        dtmKhachHang = new DefaultTableModel();
        khachHangDAO = new KhachHangDAO();
        modelKhachHang = new DefaultComboBoxModel();
        resetText();
        LocalDate ngayDk = LocalDate.now();

        Date dateBDDK = java.sql.Date.valueOf(ngayDk);
        txtNgayDangKy.setDate(dateBDDK);
        initdataTablePhong();
        initdataTableKhachHang();

    }

    public void initdataTablePhong() {
        lstPhong = phongDAO.getPhongTrong();
       
        Object[] columnNames = {"", "Mã Phòng", "Loại phòng", "Tình trạng", "Giá", "Ghi chú"};
        dtmPhong = new DefaultTableModel(new Object[0][0], columnNames);

        for (Phong adv : lstPhong) {
            Object[] o = new Object[6];

            o[1] = adv.getMaPhong();
            o[2] = adv.getTenLoaiPhong();
            o[3] = adv.getTenLoaiTinhTrangPhong();
            o[4] = (int) adv.getDonGia();
            o[5] = adv.getGhiChu();
            dtmPhong.addRow(o);

        }
        tblPhong.setModel(dtmPhong);
        funcBase.addCheckBox(0, tblPhong);

    }

    public void initdataTableKhachHang() {
        lstKhachHang = khachHangDAO.getAll();
        Object[] columnNames = {"STT", "Mã khách hàng", "Tên khách hàng", "CMND", "Địa chỉ", "Điện thoại", "Giới tính", "Quốc tịch"};
        dtmKhachHang = new DefaultTableModel(new Object[0][0], columnNames);
        int index2 = 1;
        for (KhachHang adv : lstKhachHang) {
            Object[] o = new Object[8];
            o[0] = index2;
            o[1] = adv.getMaKhachHang();
            o[2] = adv.getTenKhachHang();
            o[3] = adv.getChungMinhThuNhanDan();
            o[4] = adv.getDiaChi();
            o[5] = adv.getDienThoai();
            String gioiTinh = "Nữ";
            if (adv.isGioiTinh() == true) {
                gioiTinh = "Nam";
            }
            o[6] = gioiTinh;
            o[7] = adv.getQuocTich();
            dtmKhachHang.addRow(o);
            index2++;
        }
        tblKhachHang.setModel(dtmKhachHang);

        // Add data in jcombobox
        for (KhachHang adv : lstKhachHang) {
            modelKhachHang.addElement(adv);
        }
        jcbxKhachHang.setModel(modelKhachHang);
    }

    public void resetText() {
        txtMaPhieuThue.setText("");
        txtErrorMaPhieuThue.setText("");
        txtNgayDangKy.setCalendar(null);
        txtNgayNhan.setCalendar(null);
        txtErrorNgayDangKy.setText("");
        txtErrorNgayNhan.setText("");
        txtErrorNgayTraDuKien.setText("");
        txtNgayTraDuKien.setCalendar(null);
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
        txtMaPhieuThue = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcbxKhachHang = new javax.swing.JComboBox<KhachHang>();
        txtNgayDangKy = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        txtNgayNhan = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        btnXacNhan = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtErrorMaPhieuThue = new javax.swing.JLabel();
        txtErrorNgayDangKy = new javax.swing.JLabel();
        txtErrorNgayNhan = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNgayTraDuKien = new com.toedter.calendar.JDateChooser();
        txtErrorNgayTraDuKien = new javax.swing.JLabel();
        btnThemMoiKhachHang = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPhong = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);

        txtMaPhieuThue.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Mã Phiếu Thuê:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Tên khách hàng:");

        jcbxKhachHang.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtNgayDangKy.setDateFormatString("dd/MM/yyyy");
        txtNgayDangKy.setEnabled(false);
        txtNgayDangKy.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Ngày đăng ký:");

        txtNgayNhan.setDateFormatString("dd/MM/yyyy");
        txtNgayNhan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Ngày nhận:");

        btnXacNhan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnXacNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_success_green.png"))); // NOI18N
        btnXacNhan.setText("Xác nhận");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
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
        jLabel1.setText("THÊM MỚI PHIẾU ĐĂNG KÝ PHÒNG");

        txtErrorMaPhieuThue.setForeground(new java.awt.Color(255, 51, 51));
        txtErrorMaPhieuThue.setText("...");

        txtErrorNgayDangKy.setForeground(new java.awt.Color(255, 51, 51));
        txtErrorNgayDangKy.setText("...");

        txtErrorNgayNhan.setForeground(new java.awt.Color(255, 0, 0));
        txtErrorNgayNhan.setText("...");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Ngày trả dự kiến:");

        txtNgayTraDuKien.setDateFormatString("dd/MM/yyyy");
        txtNgayTraDuKien.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtErrorNgayTraDuKien.setForeground(new java.awt.Color(255, 0, 0));
        txtErrorNgayTraDuKien.setText("...");

        btnThemMoiKhachHang.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnThemMoiKhachHang.setText("Thêm khách hàng");
        btnThemMoiKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMoiKhachHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jcbxKhachHang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel7))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(jLabel2))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtErrorMaPhieuThue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                                        .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtNgayNhan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNgayTraDuKien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtErrorNgayDangKy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtErrorNgayNhan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtErrorNgayTraDuKien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtMaPhieuThue, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtNgayDangKy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnThemMoiKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThemMoiKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaPhieuThue, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtErrorMaPhieuThue)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbxKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                        .addGap(44, 44, 44))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNgayDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtErrorNgayDangKy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNgayNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtErrorNgayNhan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNgayTraDuKien, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtErrorNgayTraDuKien)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(219, 219, 219))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách phòng trống"));

        tblPhong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblPhong.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhongMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblPhong);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách khách hàng"));

        tblKhachHang.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
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
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblKhachHang);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        dispose();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        Boolean check = true;
        String ma_PhieuThue = txtMaPhieuThue.getText();

        if (ma_PhieuThue.length() <= 0) {
            txtErrorMaPhieuThue.setText("Mã không được để trống");
            check = false;
        } else if (ma_PhieuThue.length() > 10) {
            txtErrorMaPhieuThue.setText("Mã có tối đa là 10 ký tự");
            check = false;
        } else {
            txtErrorMaPhieuThue.setText("");
        }

        try {
            List<ChiTietPhieuThuePhong> lstCheckID = chiTietPhieuThuePhongDAO.getByMaPhieuThue(ma_PhieuThue);
            if (lstCheckID.size() > 0) {
                txtErrorMaPhieuThue.setText("Mã phiếu thuê đã tồn tại !");
                check = false;
            }
        } catch (Exception e) {
            txtErrorMaPhieuThue.setText("Mã phiếu thuê đã tồn tại !");
            check = false;
        }

        KhachHang kh = (KhachHang) modelKhachHang.getSelectedItem();
        String ma_KhachHang = kh.getMaKhachHang();

        LocalDate dateDKy = null;
        if (txtNgayDangKy.getDate() != null) {
            dateDKy = txtNgayDangKy.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        } else {
            txtErrorNgayDangKy.setText("Ngày đăng ký ko được để trống");
            check = false;
        }

        LocalDate dateNhan = null;
        if (txtNgayDangKy.getDate() != null) {
            dateNhan = txtNgayNhan.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        } else {
            txtErrorNgayNhan.setText("Ngày nhận ko được để trống");
            check = false;
        }

        LocalDate dateTraDuKien = null;
        if (txtNgayDangKy.getDate() != null) {
            dateTraDuKien = txtNgayTraDuKien.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        } else {
            txtErrorNgayTraDuKien.setText("Ngày trả dự kiến ko được để trống");
            check = false;
        }

        String succesThuePhong = "";
        String errThuePhong = "";
        Boolean checkMessError = false;

        if (check == true) {
            boolean checkAddThuePhong = false;

            if (dateNhan.isAfter(dateTraDuKien)) {
                JOptionPane.showMessageDialog(rootPane, "Thêm thất bại vì ngày đi trước ngày đến", "Thông báo", JOptionPane.ERROR_MESSAGE);
            } else {
                for (String lstP : lstMaPhong) {
                    boolean checkOverlapping = false;

                    List<ChiTietPhieuNhanPhong> lstCheckDate = chiTietPhieuNhanPhongDAO.getChiTietPhieuNhanPhongByMaPhong(lstP);

                    if (lstCheckDate.size() > 0) {
                        for (ChiTietPhieuNhanPhong lstCheckDate1 : lstCheckDate) {
                            if (MethodMain.isOverlapping(lstCheckDate1.getNgayNhan(), lstCheckDate1.getNgayTraDuKien(), dateNhan, dateTraDuKien)) {
                                checkOverlapping = true;
                            }
                        }
                    }

                    if (checkOverlapping == true) {
                        errThuePhong += ", " + lstP;
                    } else {

                        if (checkAddThuePhong == false) {
                            int count1 = phieuThuePhongDAO.add(new PhieuThuePhong(ma_PhieuThue, ma_KhachHang));
                            if (count1 > 0) {
                                checkAddThuePhong = true;
                            }
                        }
                        succesThuePhong += ", " + lstP;
                        chiTietPhieuThuePhongDAO.add(new ChiTietPhieuThuePhong(ma_PhieuThue, lstP, dateDKy, dateNhan, dateTraDuKien));
                        phongDAO.updatePhongDaThue(lstP);
                        cb.doAdd();
                        resetText();
                    }
                    checkMessError = true;
                }
            }
        }

        if (checkMessError == true) {
            String mess = "";
            if (succesThuePhong.length() > 0) {
                mess += "Đã thuê phòng <" + succesThuePhong.replaceFirst(",", "") + "> thành công: \n";
            }
            if (errThuePhong.length() > 0) {
                mess += "Không thể đặt phòng: <" + errThuePhong.replaceFirst(",", "") + "> vì đã có người ở";
            }
            JOptionPane.showMessageDialog(rootPane, mess, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }

    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void btnThemMoiKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoiKhachHangActionPerformed
          showInternalFrame(new AddKhachHang(this, rb));
    }//GEN-LAST:event_btnThemMoiKhachHangActionPerformed

    private void tblPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhongMouseClicked
        lstMaPhong = new ArrayList();
        for (int i = 0; i < tblPhong.getRowCount(); i++) {
            if (funcBase.IsSelected(i, 0, tblPhong)) {
                lstMaPhong.add(tblPhong.getValueAt(i, 1).toString());
            }
        }
    }//GEN-LAST:event_tblPhongMouseClicked

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        int pos = tblKhachHang.getSelectedRow();
        String ma_KH = lstKhachHang.get(pos).getMaKhachHang();
        KhachHang c = lstKhachHang.stream().filter(x -> x.getMaKhachHang().equals(ma_KH)).findAny().orElse(null);
        modelKhachHang.setSelectedItem(c);
        txtMaPhieuThue.setText(ranDomMa.rDomMaThuePhong());
    }//GEN-LAST:event_tblKhachHangMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnThemMoiKhachHang;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JComboBox<KhachHang> jcbxKhachHang;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTable tblPhong;
    private javax.swing.JLabel txtErrorMaPhieuThue;
    private javax.swing.JLabel txtErrorNgayDangKy;
    private javax.swing.JLabel txtErrorNgayNhan;
    private javax.swing.JLabel txtErrorNgayTraDuKien;
    private javax.swing.JTextField txtMaPhieuThue;
    private com.toedter.calendar.JDateChooser txtNgayDangKy;
    private com.toedter.calendar.JDateChooser txtNgayNhan;
    private com.toedter.calendar.JDateChooser txtNgayTraDuKien;
    // End of variables declaration//GEN-END:variables
}
