/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.view.internalframe;

import com.qlks.dao.impl.KhachHangDAO;
import com.qlks.models.ChinhSachTraPhong;
import com.qlks.models.KhachHang;
import com.qlks.view.internalframe.action.AddKhachHang;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author hello
 */
public class QuanLyKhachHang extends javax.swing.JInternalFrame implements AddKhachHang.CallBackAdd {

    private KhachHangDAO khachHangDAO;
    public List<KhachHang> lstKhachHang;
    public DefaultTableModel dtmKhachHang;
    public JDesktopPane jdek;

    public QuanLyKhachHang() {
        initComponents();
        dtmKhachHang = new DefaultTableModel();
        khachHangDAO = new KhachHangDAO();
        loadData(null);
    }

    public void loadData(String nameSeaechInput) {
        Object[] columnNames = {"STT", "Mã khách hàng", "Tên khách hàng", "CMND", "Địa chỉ", "Điện thoại", "Giới tính", "Quốc tịch", ""};
        if (nameSeaechInput != null) {
            //   lstKhachHang = khachHangDAO.search(nameSeaechInput);
        } else {
            lstKhachHang = khachHangDAO.getAll();
        }

        dtmKhachHang = new DefaultTableModel(new Object[0][0], columnNames);
        int index = 1;
        for (KhachHang adv : lstKhachHang) {
            Object[] o = new Object[8];
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
        addCheckBox(8, tblKhachHang);
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

    public void addCheckBox(int column, JTable table) {
        TableColumn tc = table.getColumnModel().getColumn(column);
        tc.setCellEditor(table.getDefaultEditor(Boolean.class));
        tc.setCellRenderer(table.getDefaultRenderer(Boolean.class));
    }

    public boolean IsSelected(int row, int column, JTable table) {
        return table.getValueAt(row, column) != null;
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
        btnThemMoi = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(btnThemMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(199, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE))
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

    private void btnThemMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoiActionPerformed
        //QuanLyCauHinh jInterFrame = new QuanLyCauHinh();
        showInternalFrame(new AddKhachHang(this));
    }//GEN-LAST:event_btnThemMoiActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        String succesDeltete = "";
        String errDeltete = "";
        int thongbao = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn không ?", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (thongbao == JOptionPane.YES_OPTION) {

            for (int i = 0; i < tblKhachHang.getRowCount(); i++) {
//                if (IsSelected(i, 8, tblKhachHang)) {
//                    //System.out.println(tblKhachHang.getValueAt(i, 1).toString());
//                    System.out.println(tblKhachHang.getValueAt(i, 2).toString());
//                    int rowSucces = khachHangDAO.delete(tblKhachHang.getValueAt(i, 1).toString());
//                    if (rowSucces > 0) {
//                        succesDeltete += "\t" + tblKhachHang.getValueAt(i, 2).toString() + "\n";
//                        loadData(null);
//                    } else {
//                        errDeltete += "\t" + tblKhachHang.getValueAt(i, 2).toString() + "\n";
//                    }
//                }
//            }
            String mess = "Bạn đã xóa thành công: \n" + succesDeltete;
            System.out.println(mess);
            if (errDeltete.length() > 0) {
                mess += "Không thể xóa: \n" + errDeltete;
            }
            JOptionPane.showMessageDialog(rootPane, mess, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        loadData(null);
    }//GEN-LAST:event_btnLamMoiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnThemMoi;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblKhachHang;
    // End of variables declaration//GEN-END:variables

    @Override
    public void doDelete() {
        loadData(null);
    }
}
