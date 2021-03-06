/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.view.internalframe;

import com.qlks.custom.FunctionBase;
import com.qlks.dao.impl.KhachHangDAO;
import com.qlks.models.KhachHang;
import com.qlks.utils.MethodMain;
import com.qlks.view.internalframe.action.AddKhachHang;
import com.qlks.view.internalframe.action.SearchKhachHang;
import com.qlks.view.internalframe.action.UpdateKhachHang;
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
public class QuanLyKhachHang extends javax.swing.JInternalFrame implements AddKhachHang.CallBackAdd, UpdateKhachHang.CallBackUpdate, SearchKhachHang.CallBackSearch {

    private KhachHangDAO khachHangDAO;
    private List<KhachHang> lstKhachHang;
    private DefaultTableModel dtmKhachHang;
    private JDesktopPane jdek;
    private FunctionBase funcBase;
    ResourceBundle rb;
    private Locale lc;
    AddKhachHang addKhachHang;
    UpdateKhachHang updateKhachHang;
    SearchKhachHang searchKhachHang;

    public QuanLyKhachHang(Locale lc) {
        initComponents();
        this.lc = lc;
        this.rb = ResourceBundle.getBundle("com.qlks.i18n.resources.resources", this.lc);
        dtmKhachHang = new DefaultTableModel();
        khachHangDAO = new KhachHangDAO();
        funcBase = new FunctionBase();
        loadData(null, null, null, null, null, null, null);

        if (!MethodMain.checkQuyen("QlKhachHang")) {
            GroupBtn.setVisible(false);
        }
    }

    public void loadData(String maSearchInput, String tenSearchInput, String CMNDSearchInput,
            String diaChiSearchInput, String dienThoaiSearchInput, Boolean gioiTinhSearchInput, String quocTichSearchInput) {

        if (maSearchInput != null || tenSearchInput != null || CMNDSearchInput != null
                || diaChiSearchInput != null || dienThoaiSearchInput != null || quocTichSearchInput != null) {
            if (gioiTinhSearchInput == null) {
                lstKhachHang = khachHangDAO.search(maSearchInput, tenSearchInput, CMNDSearchInput, diaChiSearchInput,
                        dienThoaiSearchInput, quocTichSearchInput);
            } else {
                lstKhachHang = khachHangDAO.search(maSearchInput, tenSearchInput, CMNDSearchInput, diaChiSearchInput,
                        dienThoaiSearchInput, gioiTinhSearchInput, quocTichSearchInput);
            }
        } else {
            lstKhachHang = khachHangDAO.getAll();
        }

        Object[] columnNames = {"STT", "Mã khách hàng", "Tên khách hàng", "CMND", "Địa chỉ", "Điện thoại", "Giới tính", "Quốc tịch", ""};
        dtmKhachHang = new DefaultTableModel(new Object[0][0], columnNames);
        int index = 1;
        for (KhachHang adv : lstKhachHang) {
            Object[] o = new Object[9];
            o[0] = index;
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
            index++;
        }
        tblKhachHang.setModel(dtmKhachHang);
        funcBase.addCheckBox(8, tblKhachHang);
        translate(lc);
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

    private void makeText(ResourceBundle rb) {
        btnCapNhat.setText(rb.getString("BtnCapNhat"));
        btnLamMoi.setText(rb.getString("BtnLamMoi"));
        btnThemMoi.setText(rb.getString("BtnThemMoi"));
        btnTimKiem.setText(rb.getString("BtnTimKiem"));
        btnXoa.setText(rb.getString("BtnXoa"));
        setTitle(rb.getString("JIFQLKhachHang"));
    }

    private void makeTableHeader(ResourceBundle rb) {
        tblKhachHang.getColumnModel().getColumn(0).setHeaderValue("STT");
        tblKhachHang.getColumnModel().getColumn(1).setHeaderValue(rb.getString("JIFQLKhachHangMa"));
        tblKhachHang.getColumnModel().getColumn(2).setHeaderValue(rb.getString("JIFQLKhachHangTen"));
        tblKhachHang.getColumnModel().getColumn(3).setHeaderValue(rb.getString("JIFQLKhachHangCMND"));
        tblKhachHang.getColumnModel().getColumn(4).setHeaderValue(rb.getString("JIFQLKhachHangDiaChi"));
        tblKhachHang.getColumnModel().getColumn(5).setHeaderValue(rb.getString("JIFQLKhachHangSDT"));
        tblKhachHang.getColumnModel().getColumn(6).setHeaderValue(rb.getString("JIFQLKhachHangGioiTinh"));
        tblKhachHang.getColumnModel().getColumn(7).setHeaderValue(rb.getString("JIFQLKhachHangQuocTich"));
        tblKhachHang.getColumnModel().getColumn(8).setHeaderValue("");
    }

    public void translate(Locale lc) {
        this.rb = ResourceBundle.getBundle("com.qlks.i18n.resources.resources", lc);
        this.lc = lc;
        makeText(this.rb);
        makeTableHeader(this.rb);
        if (addKhachHang != null) {
            addKhachHang.translate(this.rb);
        }
        if (updateKhachHang != null) {
            updateKhachHang.translate(this.rb);
        }
        if (searchKhachHang != null) {
            searchKhachHang.translate(this.rb);
        }
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

        GroupBtn = new javax.swing.JPanel();
        btnLamMoi = new javax.swing.JButton();
        btnThemMoi = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Quản lý khách hàng");

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
                .addContainerGap(148, Short.MAX_VALUE))
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
        jScrollPane1.setViewportView(tblKhachHang);

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
        //QuanLyCauHinh jInterFrame = new QuanLyCauHinh();
        addKhachHang = new AddKhachHang(this, rb);
        showInternalFrame(addKhachHang);
    }//GEN-LAST:event_btnThemMoiActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        String succesDeltete = "";
        String errDeltete = "";
        Boolean check = false;
        int thongbao = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn không ?", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (thongbao == JOptionPane.YES_OPTION) {

            for (int i = 0; i < tblKhachHang.getRowCount(); i++) {
        
                if (funcBase.IsSelected(i, 8, tblKhachHang)) {
                    check = true;


                    int rowSucces = khachHangDAO.delete(tblKhachHang.getValueAt(i, 1).toString());
                    if (rowSucces > 0) {
                        succesDeltete += "\t" + tblKhachHang.getValueAt(i, 2).toString() + "\n";
                    } else {
                        errDeltete += "\t" + tblKhachHang.getValueAt(i, 2).toString() + "\n";
                    }
                }
            }
            loadData(null, null, null, null, null, null, null);
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
        loadData(null, null, null, null, null, null, null);
    }//GEN-LAST:event_btnLamMoiKeyPressed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        loadData(null, null, null, null, null, null, null);
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        int currentRow = tblKhachHang.getSelectedRow();

        if (currentRow >= 0) {
            String maKH = dtmKhachHang.getValueAt(currentRow, 1).toString();
            String tenKH = dtmKhachHang.getValueAt(currentRow, 2).toString();
            String CMND = dtmKhachHang.getValueAt(currentRow, 3).toString();
            String diaChi = dtmKhachHang.getValueAt(currentRow, 4).toString();
            String dienThoai = dtmKhachHang.getValueAt(currentRow, 5).toString();
            String gioiTinhInTable = dtmKhachHang.getValueAt(currentRow, 6).toString();
            Boolean gioiTinh = true;
            if (gioiTinhInTable.equals("Nữ")) {
                gioiTinh = false;
            }
            String quocTich = dtmKhachHang.getValueAt(currentRow, 7).toString();
            KhachHang dataKH = new KhachHang(maKH, tenKH, CMND, diaChi, dienThoai, gioiTinh, quocTich);
            updateKhachHang = new UpdateKhachHang(dataKH, this, rb);
            showInternalFrame(updateKhachHang);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn hàng để cập nhật", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        searchKhachHang = new SearchKhachHang(this, rb);
        showInternalFrame(searchKhachHang);
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
    private javax.swing.JTable tblKhachHang;
    // End of variables declaration//GEN-END:variables

    @Override
    public void doAddKH() {
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
