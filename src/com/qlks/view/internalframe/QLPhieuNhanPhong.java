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
import com.qlks.models.DanhSachSuDungDichVu;
import com.qlks.models.NguoiDung;
import com.qlks.models.PhieuNhanPhong;
import com.qlks.utils.MethodMain;
import com.qlks.view.internalframe.action.AddPhieuNhanPhong;
import com.qlks.view.internalframe.action.SearchPhieuNhanPhong;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.stream.Collectors;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hello
 */
public class QLPhieuNhanPhong extends javax.swing.JInternalFrame implements AddPhieuNhanPhong.CallBackAdd, SearchPhieuNhanPhong.CallBackSearch, ThanhToanHoaDon.CallBackCheckOut {

    private PhieuNhanPhongDAO phieuNhanPhongDAO;
    private ChiTietPhieuNhanPhongDAO chiTietPhieuNhanPhongDAO;
    private List<PhieuNhanPhong> lstPhieuNhanPhong;
    private List<PhieuNhanPhong> lstPhieuNhanPhong2;
    private DefaultTableModel dtmPhieuNhanPhong;
    private JDesktopPane jdek;
    private FunctionBase funcBase;
    private PhongDAO phongDAO;
    private String tenNhanVien;
    private DanhSachSuDungDichVuDAO danhSachSuDungDichVuDAO;
    ResourceBundle rb;
    private Locale lc;
    ThanhToanHoaDon thanhToanHoaDon;
    private List<NguoiDung> lstNDx;

    public QLPhieuNhanPhong(List<NguoiDung> lstND, Locale lc) {
        initComponents();
        lstNDx = lstND;
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

    List<PhieuNhanPhong> getListPtpByMaPt(String maPt, List<PhieuNhanPhong> list) {
        List<PhieuNhanPhong> listPt = new ArrayList<>();
        for (PhieuNhanPhong phieuNhanPhong : list) {
            if (phieuNhanPhong.getMaNhanPhong().equals(maPt)) {
                listPt.add(phieuNhanPhong);
            }
        }
        return listPt;
    }

    public void loadData(String maPhong, String tenKH, String CMND) {

        if (maPhong != null || tenKH != null || CMND != null) {
            lstPhieuNhanPhong2 = phieuNhanPhongDAO.search(maPhong, tenKH, CMND);
        } else {
            lstPhieuNhanPhong2 = phieuNhanPhongDAO.getAll();
        }
        Set<String> set = new HashSet<>(lstPhieuNhanPhong2.size());
        lstPhieuNhanPhong = lstPhieuNhanPhong2.stream().filter(p -> set.add(p.getMaNhanPhong())).collect(Collectors.toList());
        String phong = "";
        for (PhieuNhanPhong phieuNhanPhong : lstPhieuNhanPhong2) {
            phong = "";
            for (PhieuNhanPhong phieuNhanPhong1 : getListPtpByMaPt(phieuNhanPhong.getMaNhanPhong(), lstPhieuNhanPhong2)) {
                phong += phieuNhanPhong1.getMaPhong() + ",";
            }
            phieuNhanPhong.setMaPhong(phong.replaceFirst(".$", ""));
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
            o[11] = "Thanh toán";

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
        btnThemMoi = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        btnThemDichVu = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhieuNhanPhong = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Quản lý phiếu nhận phòng");

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

        btnThemMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_add.png"))); // NOI18N
        btnThemMoi.setText("Thêm mới");
        btnThemMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMoiActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_search.png"))); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        btnThemDichVu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnThemDichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_bookdv.png"))); // NOI18N
        btnThemDichVu.setText("Thêm dịch vụ");
        btnThemDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDichVuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout GroupBtnLayout = new javax.swing.GroupLayout(GroupBtn);
        GroupBtn.setLayout(GroupBtnLayout);
        GroupBtnLayout.setHorizontalGroup(
            GroupBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GroupBtnLayout.createSequentialGroup()
                .addContainerGap(336, Short.MAX_VALUE)
                .addComponent(btnThemMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnThemDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(311, 311, 311))
        );
        GroupBtnLayout.setVerticalGroup(
            GroupBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GroupBtnLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(GroupBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE))
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

    private void btnThemMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoiActionPerformed
        showInternalFrame(new AddPhieuNhanPhong(this));
    }//GEN-LAST:event_btnThemMoiActionPerformed

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
                String maKH = dtmPhieuNhanPhong.getValueAt(currentRow, 3).toString();
                thanhToanHoaDon = new ThanhToanHoaDon(this, maNhanPhong, maPhong, maKH, tenNhanVien, rb);
                this.thanhToanHoaDon.translate(this.rb);
                showInternalFrame(thanhToanHoaDon);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Khách hàng này đã thanh toán !", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_tblPhieuNhanPhongMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        String succesDeltete = "";
        String errDeltete = "";
        Boolean check = false;
        int thongbao = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn không ?", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (thongbao == JOptionPane.YES_OPTION) {

            for (int i = 0; i < tblPhieuNhanPhong.getRowCount(); i++) {
                if (funcBase.IsSelected(i, 12, tblPhieuNhanPhong)) {
                    if (tblPhieuNhanPhong.getValueAt(i, 10).toString().equals("Chưa thanh toán")) {
                        check = true;
                        List<DanhSachSuDungDichVu> lstDSSĐV = danhSachSuDungDichVuDAO.getAll(tblPhieuNhanPhong.getValueAt(i, 1).toString(), tblPhieuNhanPhong.getValueAt(i, 2).toString());
                        for (DanhSachSuDungDichVu lstDSSĐV1 : lstDSSĐV) {
                            danhSachSuDungDichVuDAO.delete(lstDSSĐV1.getMaSuDungDVu());
                        }
                        int rowSucces1 = chiTietPhieuNhanPhongDAO.delete(tblPhieuNhanPhong.getValueAt(i, 1).toString());
                        int rowSucces2 = phieuNhanPhongDAO.delete(tblPhieuNhanPhong.getValueAt(i, 1).toString());
                        if (rowSucces1 > 0 && rowSucces2 > 0) {
                            phongDAO.updatePhongDaThanhToan(tblPhieuNhanPhong.getValueAt(i, 4).toString());
                            succesDeltete += "\t" + tblPhieuNhanPhong.getValueAt(i, 1).toString() + "\n";
                        } else {
                            errDeltete += "\t" + tblPhieuNhanPhong.getValueAt(i, 1).toString() + "\n";
                        }

                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Không thể xóa", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            loadData(null, null, null);
            if (check == true) {
                String mess = "";
                if (succesDeltete.length() > 0) {
                    mess += "Bạn đã xóa thành công: \n" + succesDeltete;
                }
                if (errDeltete.length() > 0) {
                    mess += "Không thể xóa: \n" + errDeltete;
                }
                JOptionPane.showMessageDialog(rootPane, mess, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn hàng để xóa", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThemDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDichVuActionPerformed
        showInternalFrame(new QLDichVuPhong(lstNDx, lc));
    }//GEN-LAST:event_btnThemDichVuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel GroupBtn;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnThemDichVu;
    private javax.swing.JButton btnThemMoi;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
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

    @Override
    public void doCheckOut() {
        loadData(null, null, null);
    }

}
