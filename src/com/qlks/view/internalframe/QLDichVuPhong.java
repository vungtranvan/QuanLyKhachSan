/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.view.internalframe;

import com.qlks.custom.CustomButtonClumnJTable;
import com.qlks.custom.FunctionBase;
import com.qlks.dao.impl.ChiTietPhieuNhanPhongDAO;
import com.qlks.dao.impl.DanhSachSuDungDichVuDAO;
import com.qlks.dao.impl.PhieuNhanPhongDAO;
import com.qlks.dao.impl.PhongDAO;
import com.qlks.models.NguoiDung;
import com.qlks.models.PhieuNhanPhong;
import com.qlks.utils.MethodMain;
import com.qlks.view.internalframe.action.AddPhieuNhanPhong;
import com.qlks.view.internalframe.action.SearchPhieuNhanPhong;
import java.awt.Dimension;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hello
 */
public class QLDichVuPhong extends javax.swing.JInternalFrame implements AddPhieuNhanPhong.CallBackAdd, SearchPhieuNhanPhong.CallBackSearch {

    private PhieuNhanPhongDAO phieuNhanPhongDAO;
    private ChiTietPhieuNhanPhongDAO chiTietPhieuNhanPhongDAO;
    private List<PhieuNhanPhong> lstPhieuNhanPhong;
    private DefaultTableModel dtmPhieuNhanPhong;
    private JDesktopPane jdek;
    private FunctionBase funcBase;
    private PhongDAO phongDAO;
    private String tenNhanVien;
    private DanhSachSuDungDichVuDAO danhSachSuDungDichVuDAO;
    ResourceBundle rb;
    private Locale lc;
    ThanhToanHoaDon thanhToanHoaDon;

    public QLDichVuPhong(List<NguoiDung> lstND, Locale lc) {
        initComponents();
        danhSachSuDungDichVuDAO = new DanhSachSuDungDichVuDAO();
        dtmPhieuNhanPhong = new DefaultTableModel();
        phieuNhanPhongDAO = new PhieuNhanPhongDAO();
        phongDAO = new PhongDAO();
        chiTietPhieuNhanPhongDAO = new ChiTietPhieuNhanPhongDAO();
        funcBase = new FunctionBase();
        loadData(null, null, null);
        tenNhanVien = lstND.get(0).getTenNguoiDung();

        this.lc = lc;
        this.rb = ResourceBundle.getBundle("com.qlks.i18n.resources.resources", this.lc);

        if (!MethodMain.checkQuyen("QlDaoDich")) {
            GroupBtn.setVisible(false);
        }
    }

    public void loadData(String maPhong, String tenKH, String CMND) {

        if (maPhong != null || tenKH != null || CMND != null) {
            lstPhieuNhanPhong = phieuNhanPhongDAO.search(maPhong, tenKH, CMND);
        } else {
            lstPhieuNhanPhong = phieuNhanPhongDAO.getAll();
        }

        Object[] columnNames = {"STT", "Mã nhận phòng", "Mã phiếu thuê", "Mã khách hàng", "Mã phòng", "Tên khách hàng", "CMND", "Ngày nhận", "Ngày trả dự kiến", "Ngày trả thực tế", "Trạng thái", "", "Xóa"};
        dtmPhieuNhanPhong = new DefaultTableModel(new Object[0][0], columnNames);
        int index = 1;
        for (PhieuNhanPhong adv : lstPhieuNhanPhong) {
            Object[] o = new Object[13];
            o[0] = index;
            o[1] = adv.getMaNhanPhong();
            o[2] = adv.getMaPhieuThue();
            o[3] = adv.getMaKhachHang();
            o[4] = adv.getMaPhong();
            o[5] = adv.getHoTenKhachHang();
            o[6] = adv.getChungMinhThuNhanDan();
            o[7] = adv.getNgayNhan();
            o[8] = adv.getNgayTraDuKien();
            o[9] = adv.getNgayTraThucTe();
            Boolean Status = adv.isTrangThai();
            String trangThai = "Chưa thanh toán";
            if (Status == true) {
                trangThai = "Đã thanh toán";
            }
            o[10] = trangThai;
            o[11] = "Thêm DV";
            dtmPhieuNhanPhong.addRow(o);
            index++;
        }
        tblPhieuNhanPhong.setModel(dtmPhieuNhanPhong);
        new CustomButtonClumnJTable(tblPhieuNhanPhong, 11);

        funcBase.addCheckBox(12, tblPhieuNhanPhong);
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

        GroupBtn = new javax.swing.JPanel();
        btnLamMoi = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhieuNhanPhong = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Quản lý dịch vụ phòng");

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

        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_search.png"))); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout GroupBtnLayout = new javax.swing.GroupLayout(GroupBtn);
        GroupBtn.setLayout(GroupBtnLayout);
        GroupBtnLayout.setHorizontalGroup(
            GroupBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GroupBtnLayout.createSequentialGroup()
                .addContainerGap(580, Short.MAX_VALUE)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(502, 502, 502))
        );
        GroupBtnLayout.setVerticalGroup(
            GroupBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GroupBtnLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(GroupBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        tblPhieuNhanPhong.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPhieuNhanPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuNhanPhongMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPhieuNhanPhong);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GroupBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GroupBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLamMoiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnLamMoiKeyPressed
        loadData(null, null, null);
    }//GEN-LAST:event_btnLamMoiKeyPressed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        loadData(null, null, null);
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        showInternalFrame(new SearchPhieuNhanPhong(this));
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void tblPhieuNhanPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuNhanPhongMouseClicked
        int currentRow = tblPhieuNhanPhong.getSelectedRow();
        int currentColumns = tblPhieuNhanPhong.getSelectedColumn();
        if (currentRow >= 0 && currentColumns == 11) {
            String trangThai = dtmPhieuNhanPhong.getValueAt(currentRow, 10).toString();
            if (trangThai.equals("Chưa thanh toán")) {
                String maNhanPhong = dtmPhieuNhanPhong.getValueAt(currentRow, 1).toString();
                String maPhong = dtmPhieuNhanPhong.getValueAt(currentRow, 4).toString();
                String tenKH = dtmPhieuNhanPhong.getValueAt(currentRow, 5).toString();
                showInternalFrame(new PhieuSDDichVu(maNhanPhong, maPhong, tenKH));
            } else {
                JOptionPane.showMessageDialog(rootPane, "Khách hàng này đã thanh toán. Không thể thêm dịch vụ cho khách hàng này !", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_tblPhieuNhanPhongMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel GroupBtn;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPhieuNhanPhong;
    // End of variables declaration//GEN-END:variables

    @Override
    public void doAdd() {
        loadData(null, null, null);
    }

    @Override
    public void doSearch(String maPhong, String tenKH, String CMND) {
        loadData(maPhong, tenKH, CMND);
    }

}
