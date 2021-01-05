/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.view.internalframe;

import com.qlks.custom.FunctionBase;
import com.qlks.dao.impl.NguoiDungDAO;
import com.qlks.models.NguoiDung;
import com.qlks.utils.MethodMain;
import com.qlks.view.internalframe.action.AddNguoiDung;
import com.qlks.view.internalframe.action.SearchNguoiDung;
import com.qlks.view.internalframe.action.UpdateNguoiDung;
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
public class QuanLyNguoiDung extends javax.swing.JInternalFrame implements AddNguoiDung.CallBackAdd, UpdateNguoiDung.CallBackUpdate, SearchNguoiDung.CallBackSearch {

    private NguoiDungDAO nguoiDungDAO;
    private List<NguoiDung> lstNguoiDung;
    private DefaultTableModel dtmThietBi;
    private JDesktopPane jdek;
    private FunctionBase funcBase;
    private Locale lc;
    AddNguoiDung addNguoiDung;
    UpdateNguoiDung updateNguoiDung;
    SearchNguoiDung searchNguoiDung;
    ResourceBundle rb;

    public QuanLyNguoiDung(Locale lc) {
        initComponents();
        this.lc = lc;
        this.rb = ResourceBundle.getBundle("com.qlks.i18n.resources.resources", this.lc);

        dtmThietBi = new DefaultTableModel();
        nguoiDungDAO = new NguoiDungDAO();
        funcBase = new FunctionBase();
        loadData(null, null, 0);

    
        if (!MethodMain.checkQuyen("QlNguoiDung")) {
            GroupBtn.setVisible(false);
        }
    }

    public void loadData(String tenNguoiDung, String email, int maNhomQuyen) {

        if (tenNguoiDung != null || email != null || maNhomQuyen != 0) {
            lstNguoiDung = nguoiDungDAO.search(tenNguoiDung, email, maNhomQuyen);
        } else {
            lstNguoiDung = nguoiDungDAO.getAll();
        }

        Object[] columnNames = {
            "STT",
            this.rb.getString("JIFQlNguoiDungTableMaNd"),
            this.rb.getString("JIFQlNguoiDungTableTenNd"),
            this.rb.getString("JIFQlNguoiDungTableTenDangNhap"),
            this.rb.getString("JIFQlNguoiDungTableTenNhomQuyen"),
            "Email",
            this.rb.getString("JIFQlNguoiDungTableNgay"),
            this.rb.getString("JIFQlNguoiDungTableGioiTinh"),
            ""};
        dtmThietBi = new DefaultTableModel(new Object[0][0], columnNames);
        int index = 1;
        for (NguoiDung adv : lstNguoiDung) {
            Object[] o = new Object[9];
            o[0] = index;
            o[1] = adv.getMaNguoiDung();
            o[2] = adv.getTenNguoiDung();
            o[3] = adv.getTenDangNhap();
            o[4] = adv.getTenNhomQuyen();
            o[5] = adv.getEmail();
            o[6] = adv.getNgaySinh();
            Boolean ngaySinh = adv.isGioiTinh();
            String sex = "Nam";
            if (ngaySinh == false) {
                sex = "Nữ";
            }
            o[7] = sex;
            dtmThietBi.addRow(o);
            index++;
        }
        tblNguoiDung.setModel(dtmThietBi);
        funcBase.addCheckBox(8, tblNguoiDung);
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
        setTitle(rb.getString("JIFQlNguoiDungTitle"));
    }

    private void makeTableHeader(ResourceBundle rb) {
        tblNguoiDung.getColumnModel().getColumn(0).setHeaderValue("STT");
        tblNguoiDung.getColumnModel().getColumn(1).setHeaderValue(rb.getString("JIFQlNguoiDungTableMaNd"));
        tblNguoiDung.getColumnModel().getColumn(2).setHeaderValue(rb.getString("JIFQlNguoiDungTableTenNd"));
        tblNguoiDung.getColumnModel().getColumn(3).setHeaderValue(rb.getString("JIFQlNguoiDungTableTenDangNhap"));
        tblNguoiDung.getColumnModel().getColumn(4).setHeaderValue(rb.getString("JIFQlNguoiDungTableTenNhomQuyen"));
        tblNguoiDung.getColumnModel().getColumn(5).setHeaderValue("Email");
        tblNguoiDung.getColumnModel().getColumn(6).setHeaderValue(rb.getString("JIFQlNguoiDungTableNgay"));
        tblNguoiDung.getColumnModel().getColumn(7).setHeaderValue(rb.getString("JIFQlNguoiDungTableGioiTinh"));
        tblNguoiDung.getColumnModel().getColumn(8).setHeaderValue("");
    }

    public void translate(Locale lc) {
        this.rb = ResourceBundle.getBundle("com.qlks.i18n.resources.resources", lc);
        this.lc = lc;
        makeText(this.rb);
        makeTableHeader(this.rb);
        revalidate();
        repaint();
        if (addNguoiDung != null) {
            addNguoiDung.translate(this.rb);
        }

        if (updateNguoiDung != null) {
            updateNguoiDung.translate(this.rb);
        }
        if (searchNguoiDung != null) {
            searchNguoiDung.translate(this.rb);
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
        tblNguoiDung = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Quản lý người dùng");

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

        tblNguoiDung.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblNguoiDung);

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
        addNguoiDung = new AddNguoiDung(this, this.rb);
        showInternalFrame(addNguoiDung);
    }//GEN-LAST:event_btnThemMoiActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        String succesDeltete = "";
        String errDeltete = "";
        Boolean check = false;
        int thongbao = JOptionPane.showConfirmDialog(this, rb.getString("ConfirmDialogMsg"), rb.getString("ConfirmDialogTitle"), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (thongbao == JOptionPane.YES_OPTION) {

            for (int i = 0; i < tblNguoiDung.getRowCount(); i++) {
                if (funcBase.IsSelected(i, 8, tblNguoiDung)) {
                    check = true;
                    //System.out.println("IsSelected =" + IsSelected(i, 8, tblKhachHang));

                    int rowSucces = nguoiDungDAO.delete(Integer.parseInt(tblNguoiDung.getValueAt(i, 1).toString()));
                    if (rowSucces > 0) {
                        succesDeltete += "\t" + tblNguoiDung.getValueAt(i, 2).toString() + "\n";
                    } else {
                        errDeltete += "\t" + tblNguoiDung.getValueAt(i, 2).toString() + "\n";
                    }
                }
            }
            loadData(null, null, 0);
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
        loadData(null, null, 0);
    }//GEN-LAST:event_btnLamMoiKeyPressed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        loadData(null, null, 0);
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        int currentRow = tblNguoiDung.getSelectedRow();

        if (currentRow >= 0) {

            int maNguoiDung = Integer.parseInt(dtmThietBi.getValueAt(currentRow, 1).toString());
            List<NguoiDung> lstfindId = nguoiDungDAO.getByMa(maNguoiDung);
            NguoiDung dataND = new NguoiDung();
            for (NguoiDung nd : lstfindId) {
                dataND.setMaNguoiDung(nd.getMaNguoiDung());
                dataND.setAnh(nd.getAnh());
                dataND.setTenNguoiDung(nd.getTenNguoiDung());
                dataND.setTenDangNhap(nd.getTenDangNhap());
                dataND.setMatKhau(nd.getMatKhau());
                dataND.setEmail(nd.getEmail());
                dataND.setNgaySinh(nd.getNgaySinh());
                dataND.setGioiTinh(nd.isGioiTinh());
                dataND.setMaNhomQuyen(nd.getMaNhomQuyen());
            }
            updateNguoiDung = new UpdateNguoiDung(dataND, this, this.rb);
            showInternalFrame(updateNguoiDung);
        } else {
            JOptionPane.showMessageDialog(rootPane, rb.getString("ConfirmDialogMsgChonCapNhat"), rb.getString("ConfirmDialogTitle"), JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        searchNguoiDung = new SearchNguoiDung(this, rb);
        showInternalFrame(searchNguoiDung);
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
    private javax.swing.JTable tblNguoiDung;
    // End of variables declaration//GEN-END:variables

    @Override
    public void doAdd() {
        loadData(null, null, 0);
    }

    @Override
    public void doUpdate() {
        loadData(null, null, 0);
    }

    @Override
    public void doSearch(String tenNguoiDung, String email, int maNhomQuyen) {
        loadData(tenNguoiDung, email, maNhomQuyen);
    }
}
