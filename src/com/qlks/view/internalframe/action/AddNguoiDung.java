/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.view.internalframe.action;

import com.qlks.custom.FunctionBase;
import com.qlks.dao.impl.NguoiDungDAO;
import com.qlks.dao.impl.NhomQuyenDAO;
import com.qlks.helper.FileTypeFiler;
import com.qlks.helper.ImageHelper;
import com.qlks.models.NguoiDung;
import com.qlks.models.NhomQuyen;
import java.awt.Image;
import java.io.File;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author hello
 */
public class AddNguoiDung extends javax.swing.JInternalFrame {

    private NguoiDungDAO nguoiDungDAO;
    private NhomQuyenDAO nhomQuyenDAO;

    private List<NhomQuyen> lstNhomQuyen;

    private DefaultComboBoxModel modelNhomQuyen;
    private FunctionBase funcBase;
    private byte[] nguoidungImage;
    CallBackAdd cb;

    public interface CallBackAdd {

        void doAdd();
    }

    /**
     * Creates new form AddKhachHang
     */
    public AddNguoiDung(CallBackAdd _cb) {
        initComponents();
        modelNhomQuyen = new DefaultComboBoxModel();
        nguoiDungDAO = new NguoiDungDAO();
        nhomQuyenDAO = new NhomQuyenDAO();
        lstNhomQuyen = nhomQuyenDAO.getAll();
        funcBase = new FunctionBase();
        resetText();
        this.cb = _cb;
        initDataNhomQuyen();
    }

    public void initDataNhomQuyen() {
        for (NhomQuyen adv : lstNhomQuyen) {
            modelNhomQuyen.addElement(adv);
        }
        jcbMaNhomQuyen.setModel(modelNhomQuyen);
    }

    public void resetText() {
        txtErrorEmail.setText("");
        txtErrorTenDangNhap.setText("");
        txtErrorTenNguoiDung.setText("");
        txtErrorMatKhau.setText("");
        txtErrorNhapLaiMatKhau.setText("");
        txtErrorNgaySinh.setText("");

        txtTenNguoiDung.setText("");
        txtTenDangNhap.setText("");
        txtEmail.setText("");
        txtMatKhau.setText("");
        txtNhapLaiMatKhau.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupGioiTinh = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTenNguoiDung = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnHuyBo = new javax.swing.JButton();
        btnThemMoi = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        txtErrorTenNguoiDung = new javax.swing.JLabel();
        txtErrorEmail = new javax.swing.JLabel();
        txtErrorTenDangNhap = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtTenDangNhap = new javax.swing.JTextField();
        jcbMaNhomQuyen = new javax.swing.JComboBox<NhomQuyen>();
        txtNhapLaiMatKhau = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        txtErrorNhapLaiMatKhau = new javax.swing.JLabel();
        txtErrorMatKhau = new javax.swing.JLabel();
        jDateNgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jRadioNam = new javax.swing.JRadioButton();
        jRadioNu = new javax.swing.JRadioButton();
        txtErrorNgaySinh = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblShowImage = new javax.swing.JLabel();
        btnChonAnh = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Thêm mới người dùng");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÊM MỚI NGƯỜI DÙNG");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Tên người dùng:");

        txtTenNguoiDung.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Email:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Tên đăng nhập:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Mã nhóm quyền:");

        btnHuyBo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnHuyBo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_close.png"))); // NOI18N
        btnHuyBo.setText("Hủy bỏ");
        btnHuyBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyBoActionPerformed(evt);
            }
        });

        btnThemMoi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnThemMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_add.png"))); // NOI18N
        btnThemMoi.setText("Thêm mới");
        btnThemMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMoiActionPerformed(evt);
            }
        });

        btnLamMoi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_refresh.png"))); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        txtErrorTenNguoiDung.setForeground(new java.awt.Color(255, 0, 0));
        txtErrorTenNguoiDung.setText("...");

        txtErrorEmail.setForeground(new java.awt.Color(255, 0, 0));
        txtErrorEmail.setText("...");

        txtErrorTenDangNhap.setForeground(new java.awt.Color(255, 51, 51));
        txtErrorTenDangNhap.setText("...");

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtTenDangNhap.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtNhapLaiMatKhau.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Mật khẩu:");

        txtMatKhau.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Nhập lại mật khẩu:");

        txtErrorNhapLaiMatKhau.setForeground(new java.awt.Color(255, 51, 51));
        txtErrorNhapLaiMatKhau.setText("...");

        txtErrorMatKhau.setForeground(new java.awt.Color(255, 51, 51));
        txtErrorMatKhau.setText("...");

        jDateNgaySinh.setDateFormatString("dd/MM/yyyy");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Giới tính:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Ngày sinh:");

        buttonGroupGioiTinh.add(jRadioNam);
        jRadioNam.setSelected(true);
        jRadioNam.setText("Nam");

        buttonGroupGioiTinh.add(jRadioNu);
        jRadioNu.setText("Nữ");

        txtErrorNgaySinh.setForeground(new java.awt.Color(255, 51, 51));
        txtErrorNgaySinh.setText("...");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Ảnh :");

        lblShowImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblShowImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/image/avatar/avatar_default.jpg"))); // NOI18N
        lblShowImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));

        btnChonAnh.setText("Chọn ảnh");
        btnChonAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonAnhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(337, 337, 337))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                    .addComponent(jLabel8)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtErrorMatKhau, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtMatKhau, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtErrorEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jcbMaNhomQuyen, 0, 353, Short.MAX_VALUE))
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jRadioNam)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioNu)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(jLabel9))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel13)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addComponent(jLabel15))))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtErrorTenNguoiDung, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                                .addComponent(txtTenNguoiDung)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnChonAnh)
                                .addGap(81, 81, 81))
                            .addComponent(txtNhapLaiMatKhau)
                            .addComponent(txtErrorNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                            .addComponent(txtErrorTenDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTenDangNhap)
                            .addComponent(txtErrorNhapLaiMatKhau, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnHuyBo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(btnThemMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblShowImage, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTenNguoiDung, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtErrorTenNguoiDung)
                            .addComponent(txtErrorTenDangNhap))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)))
                    .addComponent(jDateNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtErrorEmail)
                    .addComponent(txtErrorNgaySinh))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNhapLaiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtErrorNhapLaiMatKhau)
                    .addComponent(txtErrorMatKhau))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel7))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jcbMaNhomQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15)
                                    .addComponent(btnChonAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(22, 22, 22)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioNam)
                            .addComponent(jRadioNu)
                            .addComponent(jLabel12))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblShowImage, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuyBo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        resetText();
        ImageIcon img = new ImageIcon(getClass().getResource("/com/qlks/image/avatar/avatar_default.jpg"));
        lblShowImage.setIcon(img);
        jDateNgaySinh.setCalendar(null);
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnHuyBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyBoActionPerformed
        resetText();
        dispose();
    }//GEN-LAST:event_btnHuyBoActionPerformed

    private void btnThemMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoiActionPerformed
        Boolean check = true;

        NhomQuyen nq = (NhomQuyen) modelNhomQuyen.getSelectedItem();
        int maNhomQuyen = nq.getMaNhomQuyen();

        String tenND = txtTenNguoiDung.getText();
        String email = txtEmail.getText();
        String tenDangNhap = txtTenDangNhap.getText();
        String matKhau = new String(txtMatKhau.getPassword());
        String nhapLaiMatKhau = new String(txtNhapLaiMatKhau.getPassword());

        if (tenND.length() <= 0) {
            txtErrorTenNguoiDung.setText("Tên không được để trống");
            check = false;
        } else if (tenND.length() > 50) {
            txtErrorTenNguoiDung.setText("Tên có tối đa là 50 ký tự");
            check = false;
        } else {
            txtErrorTenNguoiDung.setText("");
        }

        if (tenDangNhap.length() <= 0) {
            txtErrorTenDangNhap.setText("Tên đăng nhập không được để trống");
            check = false;
        } else if (tenDangNhap.length() > 50) {
            txtErrorTenDangNhap.setText("Tên đăng nhập có tối đa là 50 ký tự");
            check = false;
        } else {
            txtErrorTenDangNhap.setText("");
        }

        try {
            List<NguoiDung> lstCheckID = nguoiDungDAO.getByTenDangNhap(tenDangNhap);
            if (lstCheckID.size() > 0) {
                txtErrorTenDangNhap.setText("Tên đăng nhập đã tồn tại !");
                check = false;
            }
        } catch (Exception e) {
            txtErrorTenDangNhap.setText("Tên đăng nhập đã tồn tại !");
        }

        if (email.length() <= 0) {
            txtErrorEmail.setText("Email không được để trống");
            check = false;
        } else if (email.length() > 50) {
            txtErrorEmail.setText("Email có tối đa là 50 ký tự");
            check = false;
        } else {
            txtErrorEmail.setText("");
        }

        try {
            List<NguoiDung> lstCheckID = nguoiDungDAO.getByEmail(email);
            if (lstCheckID.size() > 0) {
                txtErrorEmail.setText("Email đã tồn tại !");
                check = false;
            }
        } catch (Exception e) {
            txtErrorEmail.setText("Email đã tồn tại !");
        }

        if (matKhau.length() <= 0) {
            txtErrorMatKhau.setText("Mật khẩu không được để trống");
            check = false;
        } else if (matKhau.length() > 12) {
            txtErrorMatKhau.setText("Mật khẩu có tối đa là 12 ký tự");
            check = false;
        } else {
            txtErrorMatKhau.setText("");
        }

        if (nhapLaiMatKhau.length() <= 0) {
            txtErrorNhapLaiMatKhau.setText("Nhập lại mật khẩu không được để trống");
            check = false;
        } else if (nhapLaiMatKhau.length() > 12) {
            txtErrorNhapLaiMatKhau.setText("Nhập lại mật khẩu có tối đa là 12 ký tự");
            check = false;
        } else if (!Arrays.equals(txtMatKhau.getPassword(), txtNhapLaiMatKhau.getPassword())) {
            txtErrorNhapLaiMatKhau.setText("Mật khẩu nhập lại không trùng khớp");
            check = false;
        } else {
            txtErrorNhapLaiMatKhau.setText("");
        }

        LocalDate dateBatDau = null;
        if (jDateNgaySinh.getDate() != null) {
            dateBatDau = jDateNgaySinh.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            txtErrorNgaySinh.setText("");
        } else {
            txtErrorNgaySinh.setText("Ngày sinh ko được để trống");
            check = false;
        }

        Boolean gioiTinh = true;
        if (jRadioNu.isSelected()) {
            gioiTinh = false;
        }
        if (check == true) {
            if (nguoidungImage == null) {
                File fileDest = new File(("src/com/qlks/image/avatar/avatar_default.jpg"));
                try {
                    ImageIcon icon = new ImageIcon(fileDest.getPath());
                    Image img = ImageHelper.resize(icon.getImage(), 180, 180);
                    ImageIcon resizedIcon = new ImageIcon(img);
                    lblShowImage.setIcon(resizedIcon);
                    nguoidungImage = ImageHelper.toByteArray(img, "jpg");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            int row = nguoiDungDAO.add(new NguoiDung(tenND, tenDangNhap, matKhau, nguoidungImage, email, dateBatDau, gioiTinh, maNhomQuyen));
            if (row > 0) {
                JOptionPane.showMessageDialog(rootPane, "Thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                resetText();
                cb.doAdd();
                dispose();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Thêm thất bại", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnThemMoiActionPerformed

    private void btnChonAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonAnhActionPerformed
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setDialogTitle("Thêm ảnh");
        jFileChooser.setMultiSelectionEnabled(false);
        jFileChooser.setFileFilter(new FileTypeFiler(".jpg", "JPG"));
        jFileChooser.setFileFilter(new FileTypeFiler(".gif", "GIF"));
        jFileChooser.setFileFilter(new FileTypeFiler(".png", "png"));
        int resutl = jFileChooser.showOpenDialog(null);

        if (resutl == jFileChooser.APPROVE_OPTION) {
            File fileSource = jFileChooser.getSelectedFile();
            File fileDest = new File(("src/com/qlks/image/avatar/" + fileSource.getName()));
            try {
                funcBase.copyFileUsingStream(fileSource, fileDest);
                ImageIcon icon = new ImageIcon(fileDest.getPath());
                Image img = ImageHelper.resize(icon.getImage(), 180, 180);
                ImageIcon resizedIcon = new ImageIcon(img);
                lblShowImage.setIcon(resizedIcon);
                nguoidungImage = ImageHelper.toByteArray(img, "jpg");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnChonAnhActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChonAnh;
    private javax.swing.JButton btnHuyBo;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnThemMoi;
    private javax.swing.ButtonGroup buttonGroupGioiTinh;
    private com.toedter.calendar.JDateChooser jDateNgaySinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioNam;
    private javax.swing.JRadioButton jRadioNu;
    private javax.swing.JComboBox<NhomQuyen> jcbMaNhomQuyen;
    private javax.swing.JLabel lblShowImage;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JLabel txtErrorEmail;
    private javax.swing.JLabel txtErrorMatKhau;
    private javax.swing.JLabel txtErrorNgaySinh;
    private javax.swing.JLabel txtErrorNhapLaiMatKhau;
    private javax.swing.JLabel txtErrorTenDangNhap;
    private javax.swing.JLabel txtErrorTenNguoiDung;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JPasswordField txtNhapLaiMatKhau;
    private javax.swing.JTextField txtTenDangNhap;
    private javax.swing.JTextField txtTenNguoiDung;
    // End of variables declaration//GEN-END:variables
}
