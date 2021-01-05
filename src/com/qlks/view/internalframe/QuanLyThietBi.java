/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.view.internalframe;

import com.qlks.custom.FunctionBase;
import com.qlks.dao.impl.ThietBiDAO;
import com.qlks.models.ThietBi;
import com.qlks.utils.MethodMain;
import com.qlks.view.internalframe.action.AddThietBi;
import com.qlks.view.internalframe.action.SearchThietBi;
import com.qlks.view.internalframe.action.UpdateThietBi;
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
public class QuanLyThietBi extends javax.swing.JInternalFrame implements AddThietBi.CallBackAdd, UpdateThietBi.CallBackUpdate, SearchThietBi.CallBackSearch {

    private ThietBiDAO thietBiDAO;
    private List<ThietBi> lstThietBi;
    private DefaultTableModel dtmThietBi;
    private JDesktopPane jdek;
    private FunctionBase funcBase;
    ResourceBundle rb;
    private Locale lc;

    public QuanLyThietBi(Locale lc) {
        initComponents();
        this.lc = lc;
        this.rb = ResourceBundle.getBundle("com.qlks.i18n.resources.resources", this.lc);
        dtmThietBi = new DefaultTableModel();
        thietBiDAO = new ThietBiDAO();
        funcBase = new FunctionBase();
        loadData(null, null, null);
        
        if (!MethodMain.checkQuyen("QlThietBi")) {
            GroupBtn.setVisible(false);
        }
    }

    public void loadData(String maThietBi, String maLoaiPhong, String tenThietBi) {

        if (maThietBi != null || maLoaiPhong != null || tenThietBi != null) {
            lstThietBi = thietBiDAO.search(maThietBi, maLoaiPhong, tenThietBi);
        } else {
            lstThietBi = thietBiDAO.getAll();
        }

        Object[] columnNames = {"STT", "Mã Thiết bị", "Tên loại phòng", "Tên thiết bị", "Số lượng", "Giá", ""};
        dtmThietBi = new DefaultTableModel(new Object[0][0], columnNames);
        int index = 1;
        for (ThietBi adv : lstThietBi) {
            Object[] o = new Object[7];
            o[0] = index;
            o[1] = adv.getMaThietBi();
            o[2] = adv.getTenLoaiPhong();
            o[3] = adv.getTenThietBi();
            o[4] = adv.getSoLuong();
            o[5] = (int) adv.getGia();
            dtmThietBi.addRow(o);
            index++;
        }
        tblThietBi.setModel(dtmThietBi);
        funcBase.addCheckBox(6, tblThietBi);
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
        setTitle(rb.getString("JIFLoaiPhongTitle"));
    }

    private void makeTableHeader(ResourceBundle rb) {
        tblThietBi.getColumnModel().getColumn(0).setHeaderValue("STT");
        tblThietBi.getColumnModel().getColumn(1).setHeaderValue(rb.getString("JIFThietBiMaThietBi"));
        tblThietBi.getColumnModel().getColumn(2).setHeaderValue(rb.getString("AddLoaiPhongTen"));
        tblThietBi.getColumnModel().getColumn(3).setHeaderValue(rb.getString("JIFThietBiTenThietBi"));
        tblThietBi.getColumnModel().getColumn(4).setHeaderValue(rb.getString("SoLuong"));
        tblThietBi.getColumnModel().getColumn(5).setHeaderValue(rb.getString("JIFQuanLyPhongGia"));
        tblThietBi.getColumnModel().getColumn(5).setHeaderValue(rb.getString("JIFQuanLyPhongGhiChu"));
        tblThietBi.getColumnModel().getColumn(6).setHeaderValue("");
    }

    public void translate(Locale lc) {
        this.rb = ResourceBundle.getBundle("com.qlks.i18n.resources.resources", lc);
        this.lc = lc;
        makeText(this.rb);
        makeTableHeader(this.rb);
//        if (addPhong != null) {
//            addPhong.translate(this.rb);
//        }
//        if (updatePhong != null) {
//            updatePhong.translate(this.rb);
//        }
//        if (searchPhong != null) {
//            searchPhong.translate(this.rb);
//        }
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
        tblThietBi = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Quản lýthiết bị");

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

        tblThietBi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblThietBi);

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
        showInternalFrame(new AddThietBi(this));
    }//GEN-LAST:event_btnThemMoiActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        String succesDeltete = "";
        String errDeltete = "";
        Boolean check = false;
        int thongbao = JOptionPane.showConfirmDialog(this, rb.getString("ConfirmDialogMsg"), rb.getString("ConfirmDialogTitle"), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (thongbao == JOptionPane.YES_OPTION) {

            for (int i = 0; i < tblThietBi.getRowCount(); i++) {
                if (funcBase.IsSelected(i, 6, tblThietBi)) {
                    check = true;
                    //System.out.println("IsSelected =" + IsSelected(i, 8, tblKhachHang));

                    int rowSucces = thietBiDAO.delete(tblThietBi.getValueAt(i, 1).toString());
                    if (rowSucces > 0) {
                        succesDeltete += "\t" + tblThietBi.getValueAt(i, 3).toString() + "\n";
                    } else {
                        errDeltete += "\t" + tblThietBi.getValueAt(i, 3).toString() + "\n";
                    }
                }
            }
            loadData(null, null, null);
            if (check == true) {
                String mess = "";
                if (succesDeltete.length() > 0) {
                    mess += rb.getString("ConfirmDialogMsgXoaOK") + "\n" + succesDeltete;
                }
                if (errDeltete.length() > 0) {
                    mess += rb.getString("ConfirmDialogMsgXoaErr") + "\n" + errDeltete;
                }
                JOptionPane.showMessageDialog(rootPane, mess, rb.getString("ConfirmDialogTitle"), JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(rootPane, rb.getString("ConfirmDialogMsgChonXoa"), rb.getString("ConfirmDialogTitle"), JOptionPane.WARNING_MESSAGE);
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
        int currentRow = tblThietBi.getSelectedRow();

        if (currentRow >= 0) {
            String maTB = dtmThietBi.getValueAt(currentRow, 1).toString();
            List<ThietBi> lstThietBiById = thietBiDAO.getByMaThietBi(maTB);
            ThietBi dataKM = null;
            for (ThietBi lstTB : lstThietBiById) {
                dataKM = new ThietBi(lstTB.getMaThietBi(), lstTB.getMaLoaiPhong(), lstTB.getTenThietBi(), lstTB.getSoLuong(), lstTB.getGia());
            }
            showInternalFrame(new UpdateThietBi(dataKM, this));
        } else {
            JOptionPane.showMessageDialog(rootPane, rb.getString("ConfirmDialogMsgChonCapNhat"), rb.getString("ConfirmDialogTitle"), JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        showInternalFrame(new SearchThietBi(this));
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
    private javax.swing.JTable tblThietBi;
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
    public void doSearch(String maThietBi, String maLoaiPhong, String tenThietBi) {
        loadData(maThietBi, maLoaiPhong, tenThietBi);
    }

}
