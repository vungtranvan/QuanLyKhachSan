/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.view.internalframe;

import com.qlks.custom.FunctionBase;
import com.qlks.dao.impl.LoaiPhongDAO;
import com.qlks.models.LoaiPhong;
import com.qlks.utils.MethodMain;
import com.qlks.view.internalframe.action.AddLoaiPhong;
import com.qlks.view.internalframe.action.SearchLoaiPhong;
import com.qlks.view.internalframe.action.UpdateLoaiPhong;
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
public class QuanLyLoaiPhong extends javax.swing.JInternalFrame implements AddLoaiPhong.CallBackAdd, UpdateLoaiPhong.CallBackUpdate, SearchLoaiPhong.CallBackSearch {

    private LoaiPhongDAO loaiPhongDAO;
    private List<LoaiPhong> lstLoaiPhong;
    private DefaultTableModel dtmLoaiPhong;
    private JDesktopPane jdek;
    private FunctionBase funcBase;
    ResourceBundle rb;
    private Locale lc;
    AddLoaiPhong addLoaiPhong;
    UpdateLoaiPhong updateLoaiPhong;
    SearchLoaiPhong searchLoaiPhong;

    public QuanLyLoaiPhong(Locale lc) {
        initComponents();
        this.lc = lc;
        this.rb = ResourceBundle.getBundle("com.qlks.i18n.resources.resources", this.lc);
        dtmLoaiPhong = new DefaultTableModel();
        loaiPhongDAO = new LoaiPhongDAO();
        funcBase = new FunctionBase();
        loadData(null, null);
        
        if (!MethodMain.checkQuyen("QlPhong")) {
            GroupBtn.setVisible(false);
        }
    }

    public void loadData(String maSearchInput, String tenSearchInput) {

        if (maSearchInput != null || tenSearchInput != null) {
            lstLoaiPhong = loaiPhongDAO.search(maSearchInput, tenSearchInput);
        } else {
            lstLoaiPhong = loaiPhongDAO.getAll();
        }

        Object[] columnNames = {"STT", "Mã loại phòng", "Tên loại phòng", "Đơn giá", "Số người chuẩn", "Số người tối đa", "Tỷ lệ tăng", ""};
        dtmLoaiPhong = new DefaultTableModel(new Object[0][0], columnNames);
        int index = 1;
        for (LoaiPhong adv : lstLoaiPhong) {
            Object[] o = new Object[8];
            o[0] = index;
            o[1] = adv.getMaLoaiPhong();
            o[2] = adv.getTenLoaiPhong();
            o[3] = adv.getDonGia();
            o[4] = adv.getSoNguoiChuan();
            o[5] = adv.getSoNguoiToiDa();
            o[6] = adv.getTyLeTang();
            dtmLoaiPhong.addRow(o);
            index++;
        }
        tblLoaiPhong.setModel(dtmLoaiPhong);
        funcBase.addCheckBox(7, tblLoaiPhong);
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
        tblLoaiPhong.getColumnModel().getColumn(0).setHeaderValue("STT");
        tblLoaiPhong.getColumnModel().getColumn(1).setHeaderValue(rb.getString("JIFLoaiPhongMaLoaiPhong"));
        tblLoaiPhong.getColumnModel().getColumn(2).setHeaderValue(rb.getString("JIFLoaiPhongTenLoaiPhong"));
        tblLoaiPhong.getColumnModel().getColumn(3).setHeaderValue(rb.getString("JIFLoaiPhongDonGia"));
        tblLoaiPhong.getColumnModel().getColumn(4).setHeaderValue(rb.getString("JIFLoaiPhongNguoiChuan"));
        tblLoaiPhong.getColumnModel().getColumn(5).setHeaderValue(rb.getString("JIFLoaiPhongNguoiToiDa"));
        tblLoaiPhong.getColumnModel().getColumn(6).setHeaderValue(rb.getString("JIFLoaiPhongTyLeTang"));
        tblLoaiPhong.getColumnModel().getColumn(7).setHeaderValue("");
    }

    public void translate(Locale lc) {
        this.rb = ResourceBundle.getBundle("com.qlks.i18n.resources.resources", lc);
        this.lc = lc;
        makeText(this.rb);
        makeTableHeader(this.rb);
        if (addLoaiPhong != null) {
            addLoaiPhong.translate(this.rb);
        }
        if (updateLoaiPhong != null) {
            updateLoaiPhong.translate(this.rb);
        }
        if (searchLoaiPhong != null) {
            searchLoaiPhong.translate(this.rb);
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
        tblLoaiPhong = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Quản lý loại phòng");

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

        tblLoaiPhong.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblLoaiPhong);

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
        addLoaiPhong = new AddLoaiPhong(this, this.rb);
        showInternalFrame(addLoaiPhong);
    }//GEN-LAST:event_btnThemMoiActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        String succesDeltete = "";
        String errDeltete = "";
        Boolean check = false;
        int thongbao = JOptionPane.showConfirmDialog(this, rb.getString("ConfirmDialogMsg"), rb.getString("ConfirmDialogTitle"), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (thongbao == JOptionPane.YES_OPTION) {

            for (int i = 0; i < tblLoaiPhong.getRowCount(); i++) {
                if (funcBase.IsSelected(i, 7, tblLoaiPhong)) {
                    check = true;
                    //System.out.println("IsSelected =" + IsSelected(i, 8, tblKhachHang));

                    int rowSucces = loaiPhongDAO.delete(tblLoaiPhong.getValueAt(i, 1).toString());
                    if (rowSucces > 0) {
                        succesDeltete += "\t" + tblLoaiPhong.getValueAt(i, 2).toString() + "\n";
                    } else {
                        errDeltete += "\t" + tblLoaiPhong.getValueAt(i, 2).toString() + "\n";
                    }
                }
            }
            loadData(null, null);
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
        loadData(null, null);
    }//GEN-LAST:event_btnLamMoiKeyPressed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        loadData(null, null);
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        int currentRow = tblLoaiPhong.getSelectedRow();
        if (currentRow >= 0) {
            String maLP = dtmLoaiPhong.getValueAt(currentRow, 1).toString();
            String tenLP = dtmLoaiPhong.getValueAt(currentRow, 2).toString();
            Float donGia = Float.parseFloat(dtmLoaiPhong.getValueAt(currentRow, 3).toString());
            int soNguoiChuan = Integer.parseInt(dtmLoaiPhong.getValueAt(currentRow, 4).toString());
            int soNguoiToiDa = Integer.parseInt(dtmLoaiPhong.getValueAt(currentRow, 5).toString());
            Float tyLeTang = Float.parseFloat(dtmLoaiPhong.getValueAt(currentRow, 6).toString());

            LoaiPhong dataLP = new LoaiPhong(maLP, tenLP, donGia, soNguoiChuan, soNguoiToiDa, tyLeTang);
            updateLoaiPhong = new UpdateLoaiPhong(dataLP, this, rb);
            showInternalFrame(updateLoaiPhong);
        } else {
            JOptionPane.showMessageDialog(rootPane, rb.getString("ConfirmDialogMsgChonCapNhat"), rb.getString("ConfirmDialogTitle"), JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        searchLoaiPhong = new SearchLoaiPhong(this, this.rb);
        showInternalFrame(searchLoaiPhong);
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
    private javax.swing.JTable tblLoaiPhong;
    // End of variables declaration//GEN-END:variables

    @Override
    public void doAdd() {
        loadData(null, null);
    }

    @Override
    public void doUpdate() {
        loadData(null, null);
    }

    @Override
    public void doSearch(String maSearchInput, String tenSearchInput) {
        loadData(maSearchInput, tenSearchInput);
    }

}
