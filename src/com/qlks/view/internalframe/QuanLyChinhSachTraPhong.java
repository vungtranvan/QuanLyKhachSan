/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.view.internalframe;

import com.qlks.dao.impl.ChinhSachTraPhongDAO;
import com.qlks.models.ChinhSachTraPhong;
import com.qlks.utils.MethodMain;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MinhVuFC
 */
public class QuanLyChinhSachTraPhong extends javax.swing.JInternalFrame {

    private ChinhSachTraPhongDAO chinhsachtpDAO;
    private List<ChinhSachTraPhong> lstCSTraPhong;
    private DefaultTableModel dtmCSTraPhong;

    /**
     * Creates new form QuanLyTaiSan
     */
    public QuanLyChinhSachTraPhong() {
        initComponents();
        dtmCSTraPhong = new DefaultTableModel();
        chinhsachtpDAO = new ChinhSachTraPhongDAO();
        loadData(null, null);
        resetText();
        if (!MethodMain.checkQuyen("QlChinhSachTraPhong")) {
            jPanel1.setVisible(false);
        }
    }

    public void loadData(String maSeaechInput, String noidungSearchInput) {
        if (maSeaechInput != null && noidungSearchInput != null) {
            lstCSTraPhong = chinhsachtpDAO.search(maSeaechInput, noidungSearchInput);
        } else {
            lstCSTraPhong = chinhsachtpDAO.getAll();
        }
        Object[] columnNames = {"STT", "Mã Chính Sách Trả Phòng", "Nội dung", "Phụ thu(%)"};
        dtmCSTraPhong = new DefaultTableModel(new Object[0][0], columnNames);
        int index = 1;
        for (ChinhSachTraPhong adv : lstCSTraPhong) {
            Object[] o = new Object[5];
            o[0] = index;
            o[1] = adv.getMaChinhSach();
            o[2] = adv.getNoiDung();
            o[3] = adv.getPhuThu();
            dtmCSTraPhong.addRow(o);
            index++;
        }
        tblChinhSachTraPhong.setModel(dtmCSTraPhong);
        // Cài đặt sự kiện khi click từng dòng trong bảng
        if (lstCSTraPhong.size() > 0) {
    
            tblChinhSachTraPhong.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    int currentRow = tblChinhSachTraPhong.getSelectedRow();
                    if (currentRow < 0) {
                        currentRow = 0;
                    }

                    // Chèn dữ liệu lên form
                    if (currentRow >= 0) {
                        txtMaChinhSach.setText(tblChinhSachTraPhong.getValueAt(currentRow, 1).toString());
                        txtNoiDung.setText(tblChinhSachTraPhong.getValueAt(currentRow, 2).toString());
                        txtPhuThu.setText(tblChinhSachTraPhong.getValueAt(currentRow, 3).toString());
                    }
                }
            });
        }
    }

    public void resetText() {
        txtMaChinhSach.setText("");
        txtNoiDung.setText("");
        txtPhuThu.setText("");
        txtErrorMaChinhSach.setText("");
        txtErrorNoiDung.setText("");
        txtErrorPhuThu.setText("");
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
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNoiDung = new javax.swing.JTextField();
        btnThemMoi = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        lblResult = new javax.swing.JLabel();
        btnLamMoi = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtPhuThu = new javax.swing.JTextField();
        txtMaChinhSach = new javax.swing.JTextField();
        txtErrorMaChinhSach = new javax.swing.JLabel();
        txtErrorNoiDung = new javax.swing.JLabel();
        txtErrorPhuThu = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblChinhSachTraPhong = new javax.swing.JTable();
        btnTimKiem = new javax.swing.JButton();
        txtSeachMaCSach = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSearchNoiDung = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Quản lý  chính sách trả phòng");
        setToolTipText("");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Chính sách trả phòng"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Mã chính sách:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Nội dung:");

        txtNoiDung.setColumns(5);
        txtNoiDung.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnThemMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_add.png"))); // NOI18N
        btnThemMoi.setText("Thêm mới");
        btnThemMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMoiActionPerformed(evt);
            }
        });

        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_edit.png"))); // NOI18N
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        lblResult.setForeground(new java.awt.Color(248, 13, 33));

        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_refresh.png"))); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Phụ thu:");

        txtPhuThu.setColumns(5);
        txtPhuThu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtMaChinhSach.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtErrorMaChinhSach.setForeground(new java.awt.Color(255, 51, 51));
        txtErrorMaChinhSach.setText("...");

        txtErrorNoiDung.setForeground(new java.awt.Color(255, 0, 0));
        txtErrorNoiDung.setText("...");

        txtErrorPhuThu.setForeground(new java.awt.Color(255, 0, 0));
        txtErrorPhuThu.setText("...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(lblResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 79, Short.MAX_VALUE)
                                .addComponent(btnLamMoi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnThemMoi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCapNhat))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNoiDung)
                                    .addComponent(txtPhuThu)
                                    .addComponent(txtMaChinhSach)
                                    .addComponent(txtErrorMaChinhSach, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtErrorNoiDung, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtErrorPhuThu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaChinhSach, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(txtErrorMaChinhSach)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNoiDung, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(3, 3, 3)
                .addComponent(txtErrorNoiDung)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblResult)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhuThu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtErrorPhuThu)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblChinhSachTraPhong.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblChinhSachTraPhong);

        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_search.png"))); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        txtSeachMaCSach.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Mã Chính Sách :");

        txtSearchNoiDung.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Nội dung :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSeachMaCSach, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtSearchNoiDung, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTimKiem))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSearchNoiDung)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addComponent(txtSeachMaCSach, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 647, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoiActionPerformed
        String maCS = txtMaChinhSach.getText();
        String noiDungSC = txtNoiDung.getText();
        String phuThu = txtPhuThu.getText();

        Boolean check = true;
        List<ChinhSachTraPhong> lstCheckID = chinhsachtpDAO.getByMa(maCS);
        if (maCS.length() <= 0) {
            txtErrorMaChinhSach.setText("Mã chính sách không được để trống !");
            check = false;
        } else {
            txtErrorMaChinhSach.setText("");
        }
        if (maCS.length() > 5) {
            txtErrorMaChinhSach.setText("Mã chính sách tối đa là 5 ký tự !");
            check = false;
        }

        if (lstCheckID.size() > 0) {
            txtErrorMaChinhSach.setText("Mã chính sách đã tồn tại !");
            check = false;
        }

        if (noiDungSC.length() <= 0) {
            txtErrorNoiDung.setText("Nội dung không được để trống !");
            check = false;
        } else {
            txtErrorNoiDung.setText("");
        }
        if (noiDungSC.length() > 50) {
            txtErrorNoiDung.setText("Nội dung tối đa là 50 ký tự !");
            check = false;
        }
        if (phuThu.length() <= 0) {
            txtErrorPhuThu.setText("Phụ thu không được để trống !");
            check = false;
        } else {
            txtErrorPhuThu.setText("");
        }

        if (check == true) {
            Float phuThuT;
            try {
                phuThuT = Float.parseFloat(phuThu);
                if (phuThuT < 0) {
                    txtErrorPhuThu.setText("Phụ thu phải lớn hơn hoặc bằng 0 !");
                } else {
                    txtErrorPhuThu.setText("");
                    int row = chinhsachtpDAO.add(new ChinhSachTraPhong(maCS, noiDungSC, phuThuT));
                    if (row > 0) {
                        JOptionPane.showMessageDialog(rootPane, "Thêm thành công", null, JOptionPane.INFORMATION_MESSAGE);
                        loadData(null, null);
                        resetText();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Thêm thất bại", null, JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (Exception e) {
                txtErrorPhuThu.setText("Phụ thu phải lớn hơn hoặc bằng 0 !");
            }
        }
    }//GEN-LAST:event_btnThemMoiActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        int currentRow = tblChinhSachTraPhong.getSelectedRow();

        if (currentRow >= 0) {
            String maCS = txtMaChinhSach.getText().trim();
            String noiDungSC = txtNoiDung.getText().trim();
            Float phuThu = Float.parseFloat(txtPhuThu.getText());
            Boolean check = true;
            List<ChinhSachTraPhong> lstCheckID = chinhsachtpDAO.getByMa(maCS);

            if (maCS.length() <= 0) {
                txtErrorMaChinhSach.setText("Mã chính sách không được để trống !");
                check = false;
            } else {
                txtErrorMaChinhSach.setText("");
            }
            if (maCS.length() > 5) {
                txtErrorMaChinhSach.setText("Mã chính sách tối đa là 5 ký tự !");
                check = false;
            }
            if (noiDungSC.length() <= 0) {
                txtErrorNoiDung.setText("Nội dung không được để trống !");
                check = false;
            } else {
                txtErrorNoiDung.setText("");
            }
            if (noiDungSC.length() > 50) {
                txtErrorNoiDung.setText("Nội dung tối đa là 50 ký tự !");
                check = false;
            }
            if (phuThu == null) {
                txtErrorPhuThu.setText("Phụ thu không được để trống !");
                check = false;
            }
            if (phuThu < 0) {
                txtErrorPhuThu.setText("Phụ thu phải lớn hơn hoặc bằng 0 !");
                check = false;
            }

            if (check == true) {
                if (lstCheckID.size() < 0) {
                    txtErrorMaChinhSach.setText("Mã chính sách không tồn tại !");
                } else {
                    int row = chinhsachtpDAO.update(new ChinhSachTraPhong(maCS, noiDungSC, phuThu));
                    if (row > 0) {
                        JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công", null, JOptionPane.INFORMATION_MESSAGE);
                        loadData(null, null);
                        resetText();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Cập nhật thất bại", null, JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn hàng để cập nhật", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        tblChinhSachTraPhong.clearSelection();
        loadData(null, null);
        resetText();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        tblChinhSachTraPhong.clearSelection();
        String maCS = txtSeachMaCSach.getText();
        String noidungCS = txtSearchNoiDung.getText();
        if (maCS == null) {
            maCS = "";
        } else if (noidungCS == null) {
            noidungCS = "";
        }
        loadData(maCS, noidungCS);
        resetText();
    }//GEN-LAST:event_btnTimKiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnThemMoi;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblResult;
    private javax.swing.JTable tblChinhSachTraPhong;
    private javax.swing.JLabel txtErrorMaChinhSach;
    private javax.swing.JLabel txtErrorNoiDung;
    private javax.swing.JLabel txtErrorPhuThu;
    private javax.swing.JTextField txtMaChinhSach;
    private javax.swing.JTextField txtNoiDung;
    private javax.swing.JTextField txtPhuThu;
    private javax.swing.JTextField txtSeachMaCSach;
    private javax.swing.JTextField txtSearchNoiDung;
    // End of variables declaration//GEN-END:variables
}
