/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.view.internalframe;

import com.qlks.custom.FunctionBase;
import com.qlks.dao.impl.ChiTietPhieuThuePhongDAO;
import com.qlks.dao.impl.PhieuNhanPhongDAO;
import com.qlks.dao.impl.PhieuThuePhongDAO;
import com.qlks.dao.impl.PhongDAO;
import com.qlks.models.ChiTietPhieuThuePhong;
import com.qlks.models.PhieuNhanPhong;
import com.qlks.models.PhieuThuePhong;
import com.qlks.utils.MethodMain;
import com.qlks.view.internalframe.action.AddPhieuThuePhong;
import com.qlks.view.internalframe.action.SearchPhieuThuePhong;
import com.qlks.view.internalframe.action.UpdatePhieuThuePhong;
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
public class QLPhieuThuePhong extends javax.swing.JInternalFrame implements AddPhieuThuePhong.CallBackAdd, UpdatePhieuThuePhong.CallBackUpdate, SearchPhieuThuePhong.CallBackSearch {

    private PhieuThuePhongDAO phieuThuePhongDAO;
    private PhieuNhanPhongDAO phieuNhanPhongDAO;
    private ChiTietPhieuThuePhongDAO chiTietPhieuThuePhongDAO;
    private PhongDAO phongDAO;
    private List<PhieuThuePhong> lstPhieuThuePhong;
    private DefaultTableModel dtmPhieuThuePhong;
    private JDesktopPane jdek;
    private FunctionBase funcBase;
    private List<PhieuThuePhong> lstPhieuThuePhong2;
    ResourceBundle rb;
    private Locale lc;

    public QLPhieuThuePhong(Locale lc) {
        initComponents();
        phieuNhanPhongDAO = new PhieuNhanPhongDAO();
        dtmPhieuThuePhong = new DefaultTableModel();
        phieuThuePhongDAO = new PhieuThuePhongDAO();
        phongDAO = new PhongDAO();
        chiTietPhieuThuePhongDAO = new ChiTietPhieuThuePhongDAO();
        funcBase = new FunctionBase();
        lstPhieuThuePhong2 = new ArrayList<>();
        loadData(null, null, null);
        this.lc = lc;
        this.rb = ResourceBundle.getBundle("com.qlks.i18n.resources.resources", this.lc);

        if (!MethodMain.checkQuyen("QlDaoDich")) {
            GroupBtn.setVisible(false);
        }
    }

    List<PhieuThuePhong> getListPtpByMaPt(String maPt, List<PhieuThuePhong> list) {
        List<PhieuThuePhong> listPt = new ArrayList<>();
        for (PhieuThuePhong phieuThuePhong : list) {
            if (phieuThuePhong.getMaPhieuThue().equals(maPt)) {
                listPt.add(phieuThuePhong);
            }
        }
        return listPt;
    }

    public void loadData(String maPhieu, String tenKH, String maPhong) {

        if (maPhieu != null || tenKH != null || maPhong != null) {
            lstPhieuThuePhong2 = phieuThuePhongDAO.search(maPhieu, tenKH, maPhong);
        } else {
            lstPhieuThuePhong2 = phieuThuePhongDAO.getAll();
        }

        Set<String> set = new HashSet<>(lstPhieuThuePhong2.size());
        lstPhieuThuePhong = lstPhieuThuePhong2.stream().filter(p -> set.add(p.getMaPhieuThue())).collect(Collectors.toList());
        String phong = "";
        for (PhieuThuePhong phieuThuePhong : lstPhieuThuePhong2) {
            phong = "";
            for (PhieuThuePhong phieuThuePhong1 : getListPtpByMaPt(phieuThuePhong.getMaPhieuThue(), lstPhieuThuePhong2)) {
                phong += phieuThuePhong1.getMaPhong() + ",";
            }
            phieuThuePhong.setMaPhong(phong.replaceFirst(".$", ""));
        }

        Object[] columnNames = {"STT", "Mã phiếu thuê", "Mã khách hàng", "Tên khách hàng", "Mã phòng", "Ngày đăng ký", "Ngày nhận", "Ngày trả dự kiến", "Trạng thái", ""};
        dtmPhieuThuePhong = new DefaultTableModel(new Object[0][0], columnNames);
        int index = 1;
        for (PhieuThuePhong adv : lstPhieuThuePhong) {
            Object[] o = new Object[10];
            o[0] = index;
            o[1] = adv.getMaPhieuThue();
            o[2] = adv.getMaKhachHang();
            o[3] = adv.getTenKhachHang();
            o[4] = adv.getMaPhong();
            o[5] = adv.getNgayDangKy();
            o[6] = adv.getNgayNhan();
            o[7] = adv.getNgayTraDuKien();

            Boolean Status = adv.isTrangThai();
            String trangThai = "Chưa xử lý";
            if (Status == true) {
                trangThai = "Đã xử lý";
            }
            o[8] = trangThai;
            dtmPhieuThuePhong.addRow(o);
            index++;
        }
        tblPhieuThuePhong.setModel(dtmPhieuThuePhong);
        funcBase.addCheckBox(9, tblPhieuThuePhong);
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
        btnCapNhat = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhieuThuePhong = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Quản lý phiếu thuê phòng");

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

        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_edit.png"))); // NOI18N
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout GroupBtnLayout = new javax.swing.GroupLayout(GroupBtn);
        GroupBtn.setLayout(GroupBtnLayout);
        GroupBtnLayout.setHorizontalGroup(
            GroupBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GroupBtnLayout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(btnThemMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(235, Short.MAX_VALUE))
        );
        GroupBtnLayout.setVerticalGroup(
            GroupBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GroupBtnLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(GroupBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

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
        jScrollPane1.setViewportView(tblPhieuThuePhong);

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
        showInternalFrame(new AddPhieuThuePhong(this, this.rb));
    }//GEN-LAST:event_btnThemMoiActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        String succesDeltete = "";
        String errDeltete = "";
        Boolean check = false;
        int thongbao = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn không ?", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (thongbao == JOptionPane.YES_OPTION) {

            for (int i = 0; i < tblPhieuThuePhong.getRowCount(); i++) {
                if (funcBase.IsSelected(i, 9, tblPhieuThuePhong)) {
                    check = true;
                    List<PhieuNhanPhong> lstcheckDelete = phieuNhanPhongDAO.getByMaPhieuThue(tblPhieuThuePhong.getValueAt(i, 1).toString());
                    if (lstcheckDelete.size() > 0) {
                        check = false;
                        JOptionPane.showMessageDialog(rootPane, "Không thể xóa <" + tblPhieuThuePhong.getValueAt(i, 1).toString() + ">", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    } else {
                        int rowSucces1 = chiTietPhieuThuePhongDAO.delete(tblPhieuThuePhong.getValueAt(i, 1).toString());
                        int rowSucces2 = phieuThuePhongDAO.delete(tblPhieuThuePhong.getValueAt(i, 1).toString());
                        if (rowSucces1 > 0 && rowSucces2 > 0) {
                            phongDAO.updatePhongDaThanhToan(tblPhieuThuePhong.getValueAt(i, 4).toString());
                            succesDeltete += "\t" + tblPhieuThuePhong.getValueAt(i, 1).toString() + "\n";
                        } else {
                            errDeltete += "\t" + tblPhieuThuePhong.getValueAt(i, 1).toString() + "\n";
                        }
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

    private void btnLamMoiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnLamMoiKeyPressed
        loadData(null, null, null);
    }//GEN-LAST:event_btnLamMoiKeyPressed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        loadData(null, null, null);
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        int currentRow = tblPhieuThuePhong.getSelectedRow();

        if (currentRow >= 0) {
            String maPhong = dtmPhieuThuePhong.getValueAt(currentRow, 1).toString();
            List<ChiTietPhieuThuePhong> lstPhongByMa = chiTietPhieuThuePhongDAO.getByMaPhieuThue(maPhong);
            ChiTietPhieuThuePhong data = null;
            for (ChiTietPhieuThuePhong ph : lstPhongByMa) {
                data = new ChiTietPhieuThuePhong(ph.getMaPhieuThue(), ph.getNgayDangKy(), ph.getNgayNhan());
            }
            showInternalFrame(new UpdatePhieuThuePhong(data, this));
        } else {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn hàng để cập nhật", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        showInternalFrame(new SearchPhieuThuePhong(this));
    }//GEN-LAST:event_btnTimKiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel GroupBtn;
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnThemMoi;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPhieuThuePhong;
    // End of variables declaration//GEN-END:variables

    @Override
    public void doAdd() {
        loadData(null, null, null);
    }

    @Override
    public void doUpdate() {
        loadData(null, null, null);
    }

    @Override
    public void doSearch(String maPhieu, String tenKH, String maPhong) {
        loadData(maPhieu, tenKH, maPhong);
    }

}
