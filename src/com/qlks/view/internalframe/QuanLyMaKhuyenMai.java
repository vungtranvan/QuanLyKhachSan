/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.view.internalframe;

import com.qlks.custom.FunctionBase;
import com.qlks.dao.impl.KhuyenMaiDAO;
import com.qlks.models.KhuyenMai;
import com.qlks.utils.MethodMain;
import com.qlks.view.internalframe.action.AddKhuyenMai;
import com.qlks.view.internalframe.action.SearchKhuyenMai;
import com.qlks.view.internalframe.action.UpdateKhuyenMai;
import java.awt.Dimension;
import java.time.LocalDate;
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
public class QuanLyMaKhuyenMai extends javax.swing.JInternalFrame implements AddKhuyenMai.CallBackAdd, UpdateKhuyenMai.CallBackUpdate, SearchKhuyenMai.CallBackSearch {

    private KhuyenMaiDAO khuyenMaiDAO;
    private List<KhuyenMai> lstKhuyenMai;
    private DefaultTableModel dtmKhuyenMai;
    private JDesktopPane jdek;
    private FunctionBase funcBase;
    ResourceBundle rb;
    private Locale lc;
    AddKhuyenMai addKhuyenMai;
    UpdateKhuyenMai updateKhuyenMai;
    SearchKhuyenMai searchKhuyenMai;

    public QuanLyMaKhuyenMai(Locale lc) {
        initComponents();
        this.lc = lc;
        this.rb = ResourceBundle.getBundle("com.qlks.i18n.resources.resources", this.lc);
        dtmKhuyenMai = new DefaultTableModel();
        khuyenMaiDAO = new KhuyenMaiDAO();
        funcBase = new FunctionBase();
        loadData(null, null, null);

        if (!MethodMain.checkQuyen("QlKhuyenMai")) {
            GroupBtn.setVisible(false);
        }
    }

    public void loadData(String maPhieu, String noiDung, Boolean trangThai) {

        if (maPhieu != null || noiDung != null || trangThai != null) {
            if (trangThai == null) {
                lstKhuyenMai = khuyenMaiDAO.search(maPhieu, noiDung);
            } else {
                lstKhuyenMai = khuyenMaiDAO.search(maPhieu, noiDung, trangThai);
            }
        } else {
            lstKhuyenMai = khuyenMaiDAO.getAll();
        }

        Object[] columnNames = {"STT", "ID", "Mã code KM", "Giá trị", "Nội dung", "Ngày bắt đầu", "Ngày kết thúc", "Kiểu tính", "Trạng thái", ""};
        dtmKhuyenMai = new DefaultTableModel(new Object[0][0], columnNames);
        int index = 1;
        for (KhuyenMai adv : lstKhuyenMai) {
            Object[] o = new Object[10];
            o[0] = index;
            o[1] = adv.getMaKhuyenMai();
            o[2] = adv.getMaPhieu();
            o[3] = adv.getGiaTri();
            o[4] = adv.getNoiDung();
            o[5] = adv.getNgayBatDau();
            o[6] = adv.getNgayKetThuc();
            String kieuTinh = "Trực tiếp";
            if (adv.isKieuTinh() == true) {
                kieuTinh = "Phần trăm";
            }
            o[7] = kieuTinh;
            String trangThaiB = "Chưa sử dụng";
            if (adv.isTrangThai() == true) {
                trangThaiB = "Đã sử dụng";
            }
            o[8] = trangThaiB;
            dtmKhuyenMai.addRow(o);
            index++;
        }
        tblMaKhuyenMai.setModel(dtmKhuyenMai);
        funcBase.addCheckBox(9, tblMaKhuyenMai);
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
        setTitle(rb.getString("JIFQLKhuyenMai"));
    }

    private void makeTableHeader(ResourceBundle rb) {
        tblMaKhuyenMai.getColumnModel().getColumn(0).setHeaderValue("STT");
        tblMaKhuyenMai.getColumnModel().getColumn(1).setHeaderValue("ID");
        tblMaKhuyenMai.getColumnModel().getColumn(2).setHeaderValue(rb.getString("JIFQLKhuyenMaiCode"));
        tblMaKhuyenMai.getColumnModel().getColumn(3).setHeaderValue(rb.getString("JIFQLKhuyenMaiGiaTri"));
        tblMaKhuyenMai.getColumnModel().getColumn(4).setHeaderValue(rb.getString("JIFQLKhuyenMaiNoiDung"));
        tblMaKhuyenMai.getColumnModel().getColumn(5).setHeaderValue(rb.getString("JIFQLKhuyenMaiNgayBatDau"));
        tblMaKhuyenMai.getColumnModel().getColumn(6).setHeaderValue(rb.getString("JIFQLKhuyenMaiNgayKetThuc"));
        tblMaKhuyenMai.getColumnModel().getColumn(7).setHeaderValue(rb.getString("JIFQLKhuyenMaiKieuTinh"));
        tblMaKhuyenMai.getColumnModel().getColumn(8).setHeaderValue(rb.getString("JIFQLKhuyenMaiTrangThai"));
        tblMaKhuyenMai.getColumnModel().getColumn(9).setHeaderValue("");
    }

    public void translate(Locale lc) {
        this.rb = ResourceBundle.getBundle("com.qlks.i18n.resources.resources", lc);
        this.lc = lc;
        makeText(this.rb);
        makeTableHeader(this.rb);
        if (addKhuyenMai != null) {
            addKhuyenMai.translate(this.rb);
        }
        if (updateKhuyenMai != null) {
            updateKhuyenMai.translate(this.rb);
        }
        if (searchKhuyenMai != null) {
            searchKhuyenMai.translate(this.rb);
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
        tblMaKhuyenMai = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Quản lý khuyến mại");

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

        tblMaKhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblMaKhuyenMai);

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
        addKhuyenMai = new AddKhuyenMai(this, rb);
        showInternalFrame(addKhuyenMai);
    }//GEN-LAST:event_btnThemMoiActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        String succesDeltete = "";
        String errDeltete = "";
        Boolean check = false;
        int thongbao = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn không ?", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (thongbao == JOptionPane.YES_OPTION) {

            for (int i = 0; i < tblMaKhuyenMai.getRowCount(); i++) {
    
                if (funcBase.IsSelected(i, 9, tblMaKhuyenMai)) {
                    check = true;
                    //System.out.println("IsSelected =" + IsSelected(i, 8, tblKhachHang));

                    int rowSucces = khuyenMaiDAO.delete(Integer.parseInt(tblMaKhuyenMai.getValueAt(i, 1).toString()));
                    if (rowSucces > 0) {
                        succesDeltete += "\t" + tblMaKhuyenMai.getValueAt(i, 2).toString() + "\n";
                    } else {
                        errDeltete += "\t" + tblMaKhuyenMai.getValueAt(i, 2).toString() + "\n";
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
        int currentRow = tblMaKhuyenMai.getSelectedRow();

        if (currentRow >= 0) {
            int IdKM = Integer.parseInt(dtmKhuyenMai.getValueAt(currentRow, 1).toString());
            String maKM = dtmKhuyenMai.getValueAt(currentRow, 2).toString();
            Float giaTri = Float.parseFloat(dtmKhuyenMai.getValueAt(currentRow, 3).toString());
            String noiDung = dtmKhuyenMai.getValueAt(currentRow, 4).toString();
            LocalDate ngayBatDau = LocalDate.parse(dtmKhuyenMai.getValueAt(currentRow, 5).toString());
            LocalDate ngayKetThuc = LocalDate.parse(dtmKhuyenMai.getValueAt(currentRow, 6).toString());
            Boolean kieuTinh = true;
            if (dtmKhuyenMai.getValueAt(currentRow, 7).toString().equals("Trực tiếp")) {
                kieuTinh = false;
            }
            Boolean trangThai = true;
            if (dtmKhuyenMai.getValueAt(currentRow, 8).toString().equals("Chưa sử dụng")) {
                trangThai = false;
            }
            KhuyenMai dataKM = new KhuyenMai(IdKM, maKM, giaTri, noiDung, ngayBatDau, ngayKetThuc, kieuTinh, trangThai);
            updateKhuyenMai = new UpdateKhuyenMai(dataKM, this, rb);
            showInternalFrame(updateKhuyenMai);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn hàng để cập nhật", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        searchKhuyenMai = new SearchKhuyenMai(this, rb);
        showInternalFrame(searchKhuyenMai);
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
    private javax.swing.JTable tblMaKhuyenMai;
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
    public void doSearch(String maSearchInput, String tenSearchInput, Boolean trangThai) {
        loadData(maSearchInput, tenSearchInput, trangThai);
    }

}
