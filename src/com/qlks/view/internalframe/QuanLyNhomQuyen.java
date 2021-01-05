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
import com.qlks.utils.MethodMain;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
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
    Locale lc;

    /**
     * Creates new form QuanLyTaiSan
     */
    public QuanLyNhomQuyen(Locale lc) {
        initComponents();
        this.lc = lc;
        dtmNhomQuyen = new DefaultTableModel();
        nhomQuyenDAO = new NhomQuyenDAO();
        phanQuyenDAO = new PhanQuyenDAO();
        funcBase = new FunctionBase();
        loadData(null);
        txtErrorTenNhomQuyen.setText("");
        makeText(lc);
        ValidJcheck();
        resetText();
        if (!MethodMain.checkQuyen("QlNguoiDung")) {
            jpnNhomQuyen.setVisible(false);
            setSize(620, 700);
        }

    }

    private void loadData(String nameSeaechInput) {
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
        makeText(lc);
        ValidJcheck();
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

    private void resetText() {
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

    private void ValidJcheck() {
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

    private void makeText(Locale lc) {
        ResourceBundle rb = ResourceBundle.getBundle("com.qlks.i18n.resources.resources", lc);
        setTitle(rb.getString("JIFQuanLyNhomQuyenTitle"));
        jblSearch.setText(rb.getString("JIFQuanLyNhomQuyenJblSearch"));
        btnSearch.setText(rb.getString("BtnTimKiem"));
        ((TitledBorder) jpnNhomQuyen.getBorder()).setTitle(rb.getString("JIFQuanLyNhomQuyenJpnNhomQuyenTitle"));
        jlbTenNhomQuyen.setText(rb.getString("JIFQuanLyNhomQuyenJblTennhomQuyen"));
        jblGiaoDich.setText(rb.getString("JIFQuanLyNhomQuyenJblGiaoDich"));
        jblNguoiDung.setText(rb.getString("JIFQuanLyNhomQuyenJblNguoiDung"));
        jblPhong.setText(rb.getString("JIFQuanLyNhomQuyenJblPhong"));
        jblThietBi.setText(rb.getString("JIFQuanLyNhomQuyenJblThietBi"));
        JblDichVu.setText(rb.getString("JIFQuanLyNhomQuyenJblDichVu"));
        JblChinhSachTraPhong.setText(rb.getString("JIFQuanLyNhomQuyenJblChinhSachTraPhong"));
        JblKhachHang.setText(rb.getString("JIFQuanLyNhomQuyenJblKhachHang"));
        JblKhuyenMai.setText(rb.getString("JIFQuanLyNhomQuyenJblKhuyenMai"));
        JblQuyDinh.setText(rb.getString("JIFQuanLyNhomQuyenJblQuyDinh"));
        btnLamMoi.setText(rb.getString("BtnLamMoi"));
        btnThemMoi.setText(rb.getString("BtnThemMoi"));
        btnCapNhat.setText(rb.getString("BtnCapNhat"));
        btnXoa.setText(rb.getString("BtnXoa"));
        JblQuyDinh.setText(rb.getString("JIFQuanLyNhomQuyenJblQuyDinh"));
        JblQuyDinh.setText(rb.getString("JIFQuanLyNhomQuyenJblQuyDinh"));
        tblNhomQuyen.getColumnModel().getColumn(2).setHeaderValue(rb.getString("JIFQuanLyNhomQuyenTableMaCauHinh"));
        tblNhomQuyen.getColumnModel().getColumn(3).setHeaderValue(rb.getString("JIFQuanLyNhomQuyenTableLoaiCauHinh"));
    }

    public void translate(Locale lc) {
        makeText(lc);
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

        jPanel1 = new javax.swing.JPanel();
        jpnBangNhomQuyen = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhomQuyen = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jblSearch = new javax.swing.JLabel();
        jpnNhomQuyen = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        jlbTenNhomQuyen = new javax.swing.JLabel();
        txtTenNhomQuyen = new javax.swing.JTextField();
        btnThemMoi = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        lblResult = new javax.swing.JLabel();
        btnLamMoi = new javax.swing.JButton();
        txtErrorTenNhomQuyen = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jblGiaoDich = new javax.swing.JLabel();
        chbXemDd = new javax.swing.JCheckBox();
        chbQlDd = new javax.swing.JCheckBox();
        jPanel7 = new javax.swing.JPanel();
        jblPhong = new javax.swing.JLabel();
        chbQlPhong = new javax.swing.JCheckBox();
        chbXemPhong = new javax.swing.JCheckBox();
        jPanel9 = new javax.swing.JPanel();
        jblThietBi = new javax.swing.JLabel();
        chbQlThietBi = new javax.swing.JCheckBox();
        chbXemThietBi = new javax.swing.JCheckBox();
        jPanel10 = new javax.swing.JPanel();
        JblDichVu = new javax.swing.JLabel();
        chbQlDichVu = new javax.swing.JCheckBox();
        chbXemDichVu = new javax.swing.JCheckBox();
        jPanel11 = new javax.swing.JPanel();
        JblChinhSachTraPhong = new javax.swing.JLabel();
        chbQlCstp = new javax.swing.JCheckBox();
        chbXemCstp = new javax.swing.JCheckBox();
        jPanel12 = new javax.swing.JPanel();
        JblKhachHang = new javax.swing.JLabel();
        chbQlKh = new javax.swing.JCheckBox();
        chbXemKh = new javax.swing.JCheckBox();
        jPanel13 = new javax.swing.JPanel();
        JblKhuyenMai = new javax.swing.JLabel();
        chbQlKm = new javax.swing.JCheckBox();
        chbXemKm = new javax.swing.JCheckBox();
        jPanel14 = new javax.swing.JPanel();
        JblQuyDinh = new javax.swing.JLabel();
        chbQlQd = new javax.swing.JCheckBox();
        chbXemQd = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        jblNguoiDung = new javax.swing.JLabel();
        chbXemNd = new javax.swing.JCheckBox();
        chbQlNd = new javax.swing.JCheckBox();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Quản lý nhóm quyền");

        jpnBangNhomQuyen.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        btnSearch.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_search.png"))); // NOI18N
        btnSearch.setText("Tìm kiếm");
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        txtSearch.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 15, 0, 15));

        jblSearch.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 18)); // NOI18N
        jblSearch.setText("Nhập tên nhóm quyền:");

        javax.swing.GroupLayout jpnBangNhomQuyenLayout = new javax.swing.GroupLayout(jpnBangNhomQuyen);
        jpnBangNhomQuyen.setLayout(jpnBangNhomQuyenLayout);
        jpnBangNhomQuyenLayout.setHorizontalGroup(
            jpnBangNhomQuyenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBangNhomQuyenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnBangNhomQuyenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnBangNhomQuyenLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnBangNhomQuyenLayout.createSequentialGroup()
                        .addComponent(jblSearch)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpnBangNhomQuyenLayout.setVerticalGroup(
            jpnBangNhomQuyenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnBangNhomQuyenLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpnBangNhomQuyenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtSearch)
                    .addComponent(jblSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        jpnNhomQuyen.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhóm quyền", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Sans Condensed", 1, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("DejaVu Serif", 0, 16)); // NOI18N
        jLabel1.setText("ID:");

        lblID.setText("...");

        jlbTenNhomQuyen.setFont(new java.awt.Font("DejaVu Serif", 0, 16)); // NOI18N
        jlbTenNhomQuyen.setText("Tên nhóm quyền:");

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

        jblGiaoDich.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jblGiaoDich.setText("Giao dịch");
        jblGiaoDich.setBorder(null);

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
                .addComponent(jblGiaoDich, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(jblGiaoDich, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chbXemDd, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(chbQlDd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jblPhong.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jblPhong.setText("Phòng");
        jblPhong.setBorder(null);

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
                .addComponent(jblPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(chbXemPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chbQlPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jblPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chbXemPhong, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(chbQlPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jblThietBi.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jblThietBi.setText("Thiết bị");
        jblThietBi.setBorder(null);

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
                .addComponent(jblThietBi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(chbXemThietBi, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chbQlThietBi, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jblThietBi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chbXemThietBi, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(chbQlThietBi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        JblDichVu.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        JblDichVu.setText("Dịch vụ");
        JblDichVu.setBorder(null);

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
                .addComponent(JblDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(chbXemDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chbQlDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JblDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chbXemDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(chbQlDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        JblChinhSachTraPhong.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        JblChinhSachTraPhong.setText("Chính Sách trả phòng");
        JblChinhSachTraPhong.setBorder(null);

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
                .addComponent(JblChinhSachTraPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(chbXemCstp, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chbQlCstp, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JblChinhSachTraPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chbXemCstp, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(chbQlCstp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        JblKhachHang.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        JblKhachHang.setText("Khách hàng");
        JblKhachHang.setBorder(null);

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
                .addComponent(JblKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(chbXemKh, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chbQlKh, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JblKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chbXemKh, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(chbQlKh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        JblKhuyenMai.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        JblKhuyenMai.setText("Khuyến mại");
        JblKhuyenMai.setBorder(null);

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
                .addComponent(JblKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(chbXemKm, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chbQlKm, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JblKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chbXemKm, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(chbQlKm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        JblQuyDinh.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        JblQuyDinh.setText("Quy đinh");
        JblQuyDinh.setBorder(null);

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
                .addComponent(JblQuyDinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(chbXemQd, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chbQlQd, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JblQuyDinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chbXemQd, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(chbQlQd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jblNguoiDung.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jblNguoiDung.setText("Người dùng");
        jblNguoiDung.setBorder(null);

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
                .addComponent(jblNguoiDung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(jblNguoiDung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jpnNhomQuyenLayout = new javax.swing.GroupLayout(jpnNhomQuyen);
        jpnNhomQuyen.setLayout(jpnNhomQuyenLayout);
        jpnNhomQuyenLayout.setHorizontalGroup(
            jpnNhomQuyenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnNhomQuyenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnNhomQuyenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnNhomQuyenLayout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(lblResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpnNhomQuyenLayout.createSequentialGroup()
                        .addGroup(jpnNhomQuyenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jpnNhomQuyenLayout.createSequentialGroup()
                                .addGroup(jpnNhomQuyenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jlbTenNhomQuyen))
                                .addGap(18, 18, 18)
                                .addGroup(jpnNhomQuyenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTenNhomQuyen)
                                    .addComponent(lblID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtErrorTenNhomQuyen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jpnNhomQuyenLayout.createSequentialGroup()
                                .addComponent(btnLamMoi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnThemMoi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCapNhat)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jpnNhomQuyenLayout.setVerticalGroup(
            jpnNhomQuyenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnNhomQuyenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnNhomQuyenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblID))
                .addGap(10, 10, 10)
                .addGroup(jpnNhomQuyenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbTenNhomQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenNhomQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtErrorTenNhomQuyen)
                .addGap(20, 20, 20)
                .addComponent(lblResult)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnNhomQuyenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(btnThemMoi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnBangNhomQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnNhomQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpnBangNhomQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpnNhomQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chbXemNdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbXemNdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbXemNdActionPerformed

    private void chbXemPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbXemPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbXemPhongActionPerformed

    private void chbXemDdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbXemDdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbXemDdActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        loadData(null);
        resetText();
    }//GEN-LAST:event_btnLamMoiActionPerformed

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

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        tblNhomQuyen.clearSelection();
        if (txtSearch.getText() != null) {
            loadData(txtSearch.getText());
        } else {
            loadData(null);
        }
        resetText();
    }//GEN-LAST:event_btnSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JblChinhSachTraPhong;
    private javax.swing.JLabel JblDichVu;
    private javax.swing.JLabel JblKhachHang;
    private javax.swing.JLabel JblKhuyenMai;
    private javax.swing.JLabel JblQuyDinh;
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnThemMoi;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jblGiaoDich;
    private javax.swing.JLabel jblNguoiDung;
    private javax.swing.JLabel jblPhong;
    private javax.swing.JLabel jblSearch;
    private javax.swing.JLabel jblThietBi;
    private javax.swing.JLabel jlbTenNhomQuyen;
    private javax.swing.JPanel jpnBangNhomQuyen;
    private javax.swing.JPanel jpnNhomQuyen;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblResult;
    private javax.swing.JTable tblNhomQuyen;
    private javax.swing.JLabel txtErrorTenNhomQuyen;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTenNhomQuyen;
    // End of variables declaration//GEN-END:variables
}
