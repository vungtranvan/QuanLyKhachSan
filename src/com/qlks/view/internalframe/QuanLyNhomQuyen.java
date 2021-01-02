/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.view.internalframe;

import com.qlks.custom.FunctionBase;
import com.qlks.dao.impl.NhomQuyenDAO;
import com.qlks.dao.impl.PhanQuyenDAO;
import com.qlks.models.NhomQuyen;
import com.qlks.models.PhanQuyen;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MinhVuFC
 */
public class QuanLyNhomQuyen extends javax.swing.JInternalFrame {

    private NhomQuyenDAO nhomQuyenDAO;
    private PhanQuyenDAO phanQuyenDAO;
    private PhanQuyen phanQuyen;
    private List<NhomQuyen> lstNhomQuyen;
    private DefaultTableModel dtmNhomQuyen;
    private FunctionBase funcBase;
    List<PhanQuyen> listPhanQuyen;
    private List<Integer> listQuyen = new ArrayList<>();

    /**
     * Creates new form QuanLyTaiSan
     */
    public QuanLyNhomQuyen() {
        initComponents();
        dtmNhomQuyen = new DefaultTableModel();
        nhomQuyenDAO = new NhomQuyenDAO();
        phanQuyenDAO = new PhanQuyenDAO();
        funcBase = new FunctionBase();
        loadData(null);
        txtErrorTenNhomQuyen.setText("");
        ValidJcheck();
        resetText();

    }

    public void loadData(String nameSeaechInput) {
        Object[] columnNames = {"STT", "Mã cấu hình", "Loại cấu hình", ""};
        if (nameSeaechInput != null) {
            lstNhomQuyen = nhomQuyenDAO.search(nameSeaechInput);
        } else {
            lstNhomQuyen = nhomQuyenDAO.getAll();
        }

        dtmNhomQuyen = new DefaultTableModel(new Object[0][0], columnNames);
        int index = 1;
        for (NhomQuyen adv : lstNhomQuyen) {
            Object[] o = new Object[4];
            o[0] = index;
            o[1] = adv.getMaNhomQuyen();
            o[2] = adv.getTenNhomQuyen();
            dtmNhomQuyen.addRow(o);
            index++;
        }
        tblNhomQuyen.setModel(dtmNhomQuyen);
        funcBase.addCheckBox(3, tblNhomQuyen);

        // Cài đặt sự kiện khi click từng dòng trong bảng
        if (lstNhomQuyen.size() > 0) {

            tblNhomQuyen.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    resetText();
                    int currentRow = tblNhomQuyen.getSelectedRow();
                    if (currentRow < 0) {
                        currentRow = 0;
                    }

                    // Chèn dữ liệu lên form
                    if (currentRow >= 0) {
                        lblID.setText(tblNhomQuyen.getValueAt(currentRow, 1).toString());

                        txtTenNhomQuyen.setText(tblNhomQuyen.getValueAt(currentRow, 2).toString());

                        listPhanQuyen = phanQuyenDAO.getMaQuyenByMaQuyen(Integer.parseInt(tblNhomQuyen.getValueAt(currentRow, 1).toString()));

                        for (PhanQuyen pQ : listPhanQuyen) {
                            updateSelect(pQ.getMaQuyen());
                        }
                    }
                }
            });
        }
    }

    private void updateSelect(int MaQ) {
        switch (MaQ) {
            case 1:
                chbXemDd.setSelected(true);
                break;
            case 2:
                chbQlDd.setSelected(true);
                break;
            case 3:
                chbXemNd.setSelected(true);
                break;
            case 4:
                chbQlNd.setSelected(true);
                break;
            case 5:
                chbXemPhong.setSelected(true);
                break;
            case 6:
                chbQlPhong.setSelected(true);
                break;
            case 7:
                chbXemThietBi.setSelected(true);
                break;
            case 8:
                chbQlThietBi.setSelected(true);
                break;
            case 9:
                chbXemDichVu.setSelected(true);
                break;
            case 10:
                chbQlDichVu.setSelected(true);
                break;
            case 11:
                chbXemCstp.setSelected(true);
                break;
            case 12:
                chbQlCstp.setSelected(true);
                break;
            case 13:
                chbXemKh.setSelected(true);
                break;
            case 14:
                chbQlKh.setSelected(true);
                break;
            case 15:
                chbXemKm.setSelected(true);
                break;
            case 16:
                chbQlKm.setSelected(true);
                break;
            case 17:
                chbXemQd.setSelected(true);
                break;
            case 18:
                chbQlQd.setSelected(true);
                break;
        }

    }

    public void resetText() {
        lblID.setText("");
        txtTenNhomQuyen.setText("");
        txtErrorTenNhomQuyen.setText("");
        unselectQuyen();
    }

    private void unselectQuyen(JCheckBox jck) {
        jck.setSelected(false);
    }

    private void unselectQuyen() {
        unselectQuyen(chbXemDd);
        unselectQuyen(chbQlDd);

        unselectQuyen(chbXemNd);
        unselectQuyen(chbQlNd);

        unselectQuyen(chbXemPhong);
        unselectQuyen(chbQlPhong);

        unselectQuyen(chbXemThietBi);
        unselectQuyen(chbQlThietBi);

        unselectQuyen(chbXemDichVu);
        unselectQuyen(chbQlDichVu);

        unselectQuyen(chbXemCstp);
        unselectQuyen(chbQlCstp);

        unselectQuyen(chbXemKh);
        unselectQuyen(chbQlKh);

        unselectQuyen(chbXemKm);
        unselectQuyen(chbQlKm);

        unselectQuyen(chbXemQd);
        unselectQuyen(chbQlQd);
    }

    private void listQuyen(JCheckBox jchek) {
        if (jchek.isSelected()) {
            listQuyen.add(Integer.parseInt(jchek.getName()));
        }
    }

    private void listQuyen() {
        listQuyen.removeAll(listQuyen);
        listQuyen(chbXemDd);
        listQuyen(chbQlDd);

        listQuyen(chbXemNd);
        listQuyen(chbQlNd);

        listQuyen(chbXemPhong);
        listQuyen(chbQlPhong);

        listQuyen(chbXemThietBi);
        listQuyen(chbQlThietBi);

        listQuyen(chbXemDichVu);
        listQuyen(chbQlDichVu);

        listQuyen(chbXemCstp);
        listQuyen(chbQlCstp);

        listQuyen(chbXemKh);
        listQuyen(chbQlKh);

        listQuyen(chbXemKm);
        listQuyen(chbQlKm);

        listQuyen(chbXemQd);
        listQuyen(chbQlQd);
    }

    private void ValidJcheck(JCheckBox xem, JCheckBox ql) {
        xem.addActionListener((ActionEvent ae) -> {
            if (!xem.isSelected()) {
                if (ql.isSelected()) {
                    ql.setSelected(false);
                }
            }
        });
        ql.addActionListener((ActionEvent ae) -> {
            if (ql.isSelected()) {
                if (!xem.isSelected()) {
                    xem.setSelected(true);
                }
            }
        });
    }

    public void ValidJcheck() {
        ValidJcheck(chbXemDd, chbQlDd);
        ValidJcheck(chbXemNd, chbQlNd);
        ValidJcheck(chbXemPhong, chbQlPhong);
        ValidJcheck(chbXemThietBi, chbQlThietBi);
        ValidJcheck(chbXemDichVu, chbQlDichVu);
        ValidJcheck(chbXemCstp, chbQlCstp);
        ValidJcheck(chbXemKh, chbQlKh);
        ValidJcheck(chbXemKm, chbQlKm);
        ValidJcheck(chbXemQd, chbQlQd);
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
        lblID = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTenNhomQuyen = new javax.swing.JTextField();
        btnThemMoi = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        lblResult = new javax.swing.JLabel();
        btnLamMoi = new javax.swing.JButton();
        txtErrorTenNhomQuyen = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        chbXemDd = new javax.swing.JCheckBox();
        chbQlDd = new javax.swing.JCheckBox();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        chbQlPhong = new javax.swing.JCheckBox();
        chbXemPhong = new javax.swing.JCheckBox();
        jPanel9 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        chbQlThietBi = new javax.swing.JCheckBox();
        chbXemThietBi = new javax.swing.JCheckBox();
        jPanel10 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        chbQlDichVu = new javax.swing.JCheckBox();
        chbXemDichVu = new javax.swing.JCheckBox();
        jPanel11 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        chbQlCstp = new javax.swing.JCheckBox();
        chbXemCstp = new javax.swing.JCheckBox();
        jPanel12 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        chbQlKh = new javax.swing.JCheckBox();
        chbXemKh = new javax.swing.JCheckBox();
        jPanel13 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        chbQlKm = new javax.swing.JCheckBox();
        chbXemKm = new javax.swing.JCheckBox();
        jPanel14 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        chbQlQd = new javax.swing.JCheckBox();
        chbXemQd = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        chbXemNd = new javax.swing.JCheckBox();
        chbQlNd = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhomQuyen = new javax.swing.JTable();
        btnTimKiem = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Quản lý nhóm quyền");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhóm quyền", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Sans Condensed", 1, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("DejaVu Serif", 0, 16)); // NOI18N
        jLabel1.setText("ID:");

        lblID.setText("...");

        jLabel3.setFont(new java.awt.Font("DejaVu Serif", 0, 16)); // NOI18N
        jLabel3.setText("Tên nhóm quyền:");

        txtTenNhomQuyen.setColumns(5);
        txtTenNhomQuyen.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 15, 0, 15));

        btnThemMoi.setFont(new java.awt.Font("DejaVu Serif", 0, 16)); // NOI18N
        btnThemMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_add.png"))); // NOI18N
        btnThemMoi.setText("Thêm mới");
        btnThemMoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThemMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMoiActionPerformed(evt);
            }
        });

        btnCapNhat.setFont(new java.awt.Font("DejaVu Serif", 0, 16)); // NOI18N
        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_edit.png"))); // NOI18N
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("DejaVu Serif", 0, 16)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        lblResult.setForeground(new java.awt.Color(248, 13, 33));

        btnLamMoi.setFont(new java.awt.Font("DejaVu Serif", 0, 16)); // NOI18N
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_refresh.png"))); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        txtErrorTenNhomQuyen.setForeground(new java.awt.Color(255, 0, 0));
        txtErrorTenNhomQuyen.setText("...");

        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel6.setText("Giao dịch");
        jLabel6.setBorder(null);

        chbXemDd.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        chbXemDd.setText("Xem");
        chbXemDd.setName("1"); // NOI18N
        chbXemDd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbXemDdActionPerformed(evt);
            }
        });

        chbQlDd.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        chbQlDd.setText("Quản Lý");
        chbQlDd.setName("2"); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(chbXemDd, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chbQlDd, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chbXemDd, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(chbQlDd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel8.setText("Phòng");
        jLabel8.setBorder(null);

        chbQlPhong.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        chbQlPhong.setText("Quản Lý");
        chbQlPhong.setName("6"); // NOI18N

        chbXemPhong.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        chbXemPhong.setText("Xem");
        chbXemPhong.setName("5"); // NOI18N
        chbXemPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbXemPhongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(chbXemPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chbQlPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chbXemPhong, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(chbQlPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel10.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel10.setText("Thiết bị");
        jLabel10.setBorder(null);

        chbQlThietBi.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        chbQlThietBi.setText("Quản Lý");
        chbQlThietBi.setName("8"); // NOI18N

        chbXemThietBi.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        chbXemThietBi.setText("Xem");
        chbXemThietBi.setName("7"); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(chbXemThietBi, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chbQlThietBi, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chbXemThietBi, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(chbQlThietBi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel11.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel11.setText("Dịch vụ");
        jLabel11.setBorder(null);

        chbQlDichVu.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        chbQlDichVu.setText("Quản Lý");
        chbQlDichVu.setName("10"); // NOI18N

        chbXemDichVu.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        chbXemDichVu.setText("Xem");
        chbXemDichVu.setName("9"); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(chbXemDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chbQlDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chbXemDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(chbQlDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel12.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel12.setText("Chính Sách trả phòng");
        jLabel12.setBorder(null);

        chbQlCstp.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        chbQlCstp.setText("Quản Lý");
        chbQlCstp.setName("12"); // NOI18N

        chbXemCstp.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        chbXemCstp.setText("Xem");
        chbXemCstp.setName("11"); // NOI18N

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(chbXemCstp, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chbQlCstp, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chbXemCstp, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(chbQlCstp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel13.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel13.setText("Khách hàng");
        jLabel13.setBorder(null);

        chbQlKh.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        chbQlKh.setText("Quản Lý");
        chbQlKh.setName("14"); // NOI18N

        chbXemKh.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        chbXemKh.setText("Xem");
        chbXemKh.setName("13"); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(chbXemKh, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chbQlKh, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chbXemKh, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(chbQlKh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel14.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel14.setText("Khuyến mại");
        jLabel14.setBorder(null);

        chbQlKm.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        chbQlKm.setText("Quản Lý");
        chbQlKm.setName("16"); // NOI18N

        chbXemKm.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        chbXemKm.setText("Xem");
        chbXemKm.setName("15"); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(chbXemKm, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chbQlKm, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chbXemKm, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(chbQlKm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel15.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel15.setText("Quy đinh");
        jLabel15.setBorder(null);

        chbQlQd.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        chbQlQd.setText("Quản Lý");
        chbQlQd.setName("16"); // NOI18N

        chbXemQd.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        chbXemQd.setText("Xem");
        chbXemQd.setName("15"); // NOI18N

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(chbXemQd, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chbQlQd, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chbXemQd, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(chbQlQd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel7.setText("Người dùng");
        jLabel7.setBorder(null);

        chbXemNd.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        chbXemNd.setText("Xem");
        chbXemNd.setName("3"); // NOI18N
        chbXemNd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbXemNdActionPerformed(evt);
            }
        });

        chbQlNd.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        chbQlNd.setText("Quản Lý");
        chbQlNd.setName("4"); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(chbXemNd, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chbQlNd, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chbXemNd, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(chbQlNd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );

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
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTenNhomQuyen)
                                    .addComponent(lblID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtErrorTenNhomQuyen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnLamMoi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnThemMoi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCapNhat)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblID))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenNhomQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtErrorTenNhomQuyen)
                .addGap(20, 20, 20)
                .addComponent(lblResult)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(btnThemMoi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblNhomQuyen.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblNhomQuyen);

        btnTimKiem.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_search.png"))); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        txtSearch.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 15, 0, 15));

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jLabel2.setText("Nhập tên nhóm quyền:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(77, 77, 77))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtSearch)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoiActionPerformed
        String tenNhomQuyen = txtTenNhomQuyen.getText().trim();

        if (tenNhomQuyen.length() > 0) {
            int row = nhomQuyenDAO.add(new NhomQuyen(tenNhomQuyen));
            if (row > 0) {
                listQuyen();
                List<NhomQuyen> listLastNhomQuyen = nhomQuyenDAO.getMaxId();
                int maNhomQuyen = listLastNhomQuyen.get(0).getMaNhomQuyen();
                int row2;
                String SuccessMsg = "";

                for (Integer quyen : listQuyen) {
                    row2 = 0;
                    row2 = phanQuyenDAO.add(new PhanQuyen(quyen, maNhomQuyen));
                    if (row2 > 0) {
                        SuccessMsg = "";
                    }
                }

                JOptionPane.showMessageDialog(rootPane, "Thêm thành công", null, JOptionPane.INFORMATION_MESSAGE);
                loadData(null);
                resetText();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Thêm thất bại", null, JOptionPane.ERROR_MESSAGE);
            }
        } else {
            txtErrorTenNhomQuyen.setText("Tên cấu hình không được để trống !");
        }
    }//GEN-LAST:event_btnThemMoiActionPerformed


    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        int currentRow = tblNhomQuyen.getSelectedRow();

        if (currentRow >= 0) {
            String tenNhomQuyen = txtTenNhomQuyen.getText();
            String maNhomQuyen = lblID.getText();
            Boolean ckeck = true;

            if (tenNhomQuyen.length() < 0) {
                txtErrorTenNhomQuyen.setText("Tên quyền không được để trống !");
                ckeck = false;
            }

            if (maNhomQuyen.length() <= 0) {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn hàng để cập nhật!", null, JOptionPane.WARNING_MESSAGE);
                ckeck = false;
            }
            if (ckeck == true) {
                int id = Integer.parseInt(maNhomQuyen);
                int row = nhomQuyenDAO.update(new NhomQuyen(id, tenNhomQuyen));
                int row2;

                if (row > 0) {
                    listQuyen();
                    int pQDel = 0;
                    if (phanQuyenDAO.getMaQuyenByMaQuyen(id).size() > 0) {
                        pQDel = phanQuyenDAO.delete(id);
                    } else {
                        pQDel = 1;
                    }

                    if (pQDel > 0) {
                        for (Integer quyen : listQuyen) {
                            row2 = 0;
                            row2 = phanQuyenDAO.add(new PhanQuyen(quyen, id));
                        }
                    }

                    JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công", null, JOptionPane.INFORMATION_MESSAGE);
                    loadData(null);
                    resetText();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Cập nhật thất bại", null, JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn hàng để cập nhật", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        String succesDeltete = "";
        String errDeltete = "";
        Boolean check = false;
        int thongbao = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn không ?", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (thongbao == JOptionPane.YES_OPTION) {

            for (int i = 0; i < tblNhomQuyen.getRowCount(); i++) {
                System.out.println("getRowCount= " + tblNhomQuyen.getRowCount());
                if (funcBase.IsSelected(i, 3, tblNhomQuyen)) {
                    check = true;
                    int rowSucces = nhomQuyenDAO.delete(Integer.parseInt(tblNhomQuyen.getValueAt(i, 1).toString()));
                    tblNhomQuyen.clearSelection();
                    if (rowSucces > 0) {
                        succesDeltete += "\t" + tblNhomQuyen.getValueAt(i, 2).toString() + "\n";
                    } else {
                        errDeltete += "\t" + tblNhomQuyen.getValueAt(i, 2).toString() + "\n";
                    }
                }
            }
            loadData(null);
            resetText();
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

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        loadData(null);
        resetText();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        tblNhomQuyen.clearSelection();
        if (txtSearch.getText() != null) {
            loadData(txtSearch.getText());
        } else {
            loadData(null);
        }
        resetText();
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void chbXemPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbXemPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbXemPhongActionPerformed

    private void chbXemDdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbXemDdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbXemDdActionPerformed

    private void chbXemNdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbXemNdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbXemNdActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnThemMoi;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JCheckBox chbQlCstp;
    private javax.swing.JCheckBox chbQlDd;
    private javax.swing.JCheckBox chbQlDichVu;
    private javax.swing.JCheckBox chbQlKh;
    private javax.swing.JCheckBox chbQlKm;
    private javax.swing.JCheckBox chbQlNd;
    private javax.swing.JCheckBox chbQlPhong;
    private javax.swing.JCheckBox chbQlQd;
    private javax.swing.JCheckBox chbQlThietBi;
    private javax.swing.JCheckBox chbXemCstp;
    private javax.swing.JCheckBox chbXemDd;
    private javax.swing.JCheckBox chbXemDichVu;
    private javax.swing.JCheckBox chbXemKh;
    private javax.swing.JCheckBox chbXemKm;
    private javax.swing.JCheckBox chbXemNd;
    private javax.swing.JCheckBox chbXemPhong;
    private javax.swing.JCheckBox chbXemQd;
    private javax.swing.JCheckBox chbXemThietBi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblResult;
    private javax.swing.JTable tblNhomQuyen;
    private javax.swing.JLabel txtErrorTenNhomQuyen;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTenNhomQuyen;
    // End of variables declaration//GEN-END:variables
}
