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
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author hello
 */
public class UpdateNguoiDung extends javax.swing.JInternalFrame {

    private NguoiDungDAO nguoiDungDAO;
    private NhomQuyenDAO nhomQuyenDAO;

    private List<NhomQuyen> lstNhomQuyen;

    private DefaultComboBoxModel modelNhomQuyen;
    private int maNguoiDung;
    private FunctionBase funcBase;
    private byte[] nguoidungImage;
    CallBackUpdate cb;
    ResourceBundle rb;

    public interface CallBackUpdate {

        void doUpdate();
    }

    /**
     * Creates new form AddKhachHang
     */
    public UpdateNguoiDung(NguoiDung nd, CallBackUpdate _cb, ResourceBundle rb) {
        initComponents();
        this.rb = rb;
        funcBase = new FunctionBase();
        modelNhomQuyen = new DefaultComboBoxModel();
        nguoiDungDAO = new NguoiDungDAO();
        nhomQuyenDAO = new NhomQuyenDAO();
        lstNhomQuyen = nhomQuyenDAO.getAll();
        resetText();
        this.cb = _cb;
        initDataNhomQuyen();

        maNguoiDung = nd.getMaNguoiDung();
        txtTenNguoiDung.setText(nd.getTenNguoiDung());
        txtTenDangNhap.setText(nd.getTenDangNhap());
        txtEmail.setText(nd.getEmail());
        txtMatKhau.setText(nd.getMatKhau());
        txtNhapLaiMatKhau.setText(nd.getMatKhau());

        if (nd.isGioiTinh() == true) {
            jRadioNam.setSelected(true);
        } else {
            jRadioNu.setSelected(true);
        }

        LocalDate ngaysinh = nd.getNgaySinh();

        Date dateBD = java.sql.Date.valueOf(ngaysinh);
        jDateNgaySinh.setDate(dateBD);

        int tt_id = nd.getMaNhomQuyen();
        NhomQuyen tt = lstNhomQuyen.stream().filter(x -> x.getMaNhomQuyen() == tt_id).findAny().orElse(null);
        modelNhomQuyen.setSelectedItem(tt);

        if (nd.getAnh() != null) {
            try {
                nguoidungImage = nd.getAnh();
                Image img = ImageHelper.createImageFromByteArray(nguoidungImage, "jpg");
                lblShowImage.setIcon(new ImageIcon(img));

            } catch (IOException ex) {
                Logger.getLogger(UpdateNguoiDung.class.getName()).log(Level.SEVERE, null, ex);
                nguoidungImage = null;
            }
        } else {
            ImageIcon icon = new ImageIcon(getClass().getResource("/com/qlks/image/avatar/avatar_default.jpg"));
            lblShowImage.setIcon(icon);
            nguoidungImage = nd.getAnh();
        }
        translate(this.rb);
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

    public void translate(ResourceBundle rb) {
        this.rb = rb;
        setTitle(this.rb.getString("updateNdTieuDe"));
        jlbTitle.setText(this.rb.getString("AddNdTieuDe"));
        jlbTenNguoiDung.setText(this.rb.getString("AddNdTenNguoiDung"));
        jlbMatKhau.setText(this.rb.getString("AddNdMatKhau"));
        JblMaNhomQuyen.setText(this.rb.getString("AddNdMaNhomQuyen"));
        JblGioiTinh.setText(this.rb.getString("AddNdGioiTinh"));
        jRadioNam.setText(this.rb.getString("AddNdNam"));
        jRadioNu.setText(this.rb.getString("AddNdNu"));
        jblTenDangNhap.setText(this.rb.getString("AddNdTenDangNhap"));
        JblNgaySinh.setText(this.rb.getString("AddNdNgaySinh"));
        JblNhapLaiMatKhau.setText(this.rb.getString("AddNdNhapLaiMk"));

        btnLamMoi.setText(this.rb.getString("BtnLamMoi"));
        btnHuyBo.setText(this.rb.getString("BtnHuy"));
        btnCapNhat.setText(this.rb.getString("BtnCapNhat"));
        btnChonAnh.setText(this.rb.getString("AddNdChonAnh"));
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

        buttonGroupGioiTinh = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jlbTitle = new javax.swing.JLabel();
        jlbTenNguoiDung = new javax.swing.JLabel();
        txtTenNguoiDung = new javax.swing.JTextField();
        jlbEmail = new javax.swing.JLabel();
        jblTenDangNhap = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        JblMaNhomQuyen = new javax.swing.JLabel();
        btnHuyBo = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        txtErrorTenNguoiDung = new javax.swing.JLabel();
        txtErrorEmail = new javax.swing.JLabel();
        txtErrorTenDangNhap = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtTenDangNhap = new javax.swing.JTextField();
        jcbMaNhomQuyen = new javax.swing.JComboBox<>();
        txtNhapLaiMatKhau = new javax.swing.JPasswordField();
        jlbMatKhau = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JPasswordField();
        JblNhapLaiMatKhau = new javax.swing.JLabel();
        txtErrorNhapLaiMatKhau = new javax.swing.JLabel();
        txtErrorMatKhau = new javax.swing.JLabel();
        jDateNgaySinh = new com.toedter.calendar.JDateChooser();
        JblGioiTinh = new javax.swing.JLabel();
        JblNgaySinh = new javax.swing.JLabel();
        jRadioNam = new javax.swing.JRadioButton();
        jRadioNu = new javax.swing.JRadioButton();
        txtErrorNgaySinh = new javax.swing.JLabel();
        btnChonAnh = new javax.swing.JButton();
        lblShowImage = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cập nhật người dùng");

        jlbTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbTitle.setText("CẬP NHẬT NGƯỜI DÙNG");

        jlbTenNguoiDung.setFont(new java.awt.Font("DejaVu Serif Condensed", 0, 14)); // NOI18N
        jlbTenNguoiDung.setText("Tên người dùng:");

        txtTenNguoiDung.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jlbEmail.setFont(new java.awt.Font("DejaVu Serif Condensed", 0, 14)); // NOI18N
        jlbEmail.setText("Email:");

        jblTenDangNhap.setFont(new java.awt.Font("DejaVu Serif Condensed", 0, 14)); // NOI18N
        jblTenDangNhap.setText("Tên đăng nhập:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        JblMaNhomQuyen.setFont(new java.awt.Font("DejaVu Serif Condensed", 0, 14)); // NOI18N
        JblMaNhomQuyen.setText("Mã nhóm quyền:");

        btnHuyBo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnHuyBo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_close.png"))); // NOI18N
        btnHuyBo.setText("Hủy bỏ");
        btnHuyBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyBoActionPerformed(evt);
            }
        });

        btnCapNhat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_edit.png"))); // NOI18N
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
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

        jlbMatKhau.setFont(new java.awt.Font("DejaVu Serif Condensed", 0, 14)); // NOI18N
        jlbMatKhau.setText("Mật khẩu:");

        txtMatKhau.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        JblNhapLaiMatKhau.setFont(new java.awt.Font("DejaVu Serif Condensed", 0, 14)); // NOI18N
        JblNhapLaiMatKhau.setText("Nhập lại mật khẩu:");

        txtErrorNhapLaiMatKhau.setForeground(new java.awt.Color(255, 51, 51));
        txtErrorNhapLaiMatKhau.setText("...");

        txtErrorMatKhau.setForeground(new java.awt.Color(255, 51, 51));
        txtErrorMatKhau.setText("...");

        jDateNgaySinh.setDateFormatString("dd/MM/yyyy");

        JblGioiTinh.setFont(new java.awt.Font("DejaVu Serif Condensed", 0, 14)); // NOI18N
        JblGioiTinh.setText("Giới tính:");

        JblNgaySinh.setFont(new java.awt.Font("DejaVu Serif Condensed", 0, 14)); // NOI18N
        JblNgaySinh.setText("Ngày sinh:");

        buttonGroupGioiTinh.add(jRadioNam);
        jRadioNam.setSelected(true);
        jRadioNam.setText("Nam");

        buttonGroupGioiTinh.add(jRadioNu);
        jRadioNu.setText("Nữ");

        txtErrorNgaySinh.setForeground(new java.awt.Color(255, 51, 51));
        txtErrorNgaySinh.setText("...");

        btnChonAnh.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        btnChonAnh.setText("Chọn Ảnh");
        btnChonAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonAnhActionPerformed(evt);
            }
        });

        lblShowImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(337, 337, 337))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jlbEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                            .addComponent(jlbMatKhau)
                            .addComponent(jlbTenNguoiDung)
                            .addComponent(JblMaNhomQuyen)
                            .addComponent(JblGioiTinh))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jblTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(JblNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGap(46, 46, 46))
                                        .addComponent(JblNhapLaiMatKhau))))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtErrorTenNguoiDung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTenNguoiDung, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNhapLaiMatKhau, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtErrorNgaySinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jDateNgaySinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                                    .addComponent(txtErrorTenDangNhap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTenDangNhap, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtErrorNhapLaiMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnChonAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                    .addComponent(lblShowImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHuyBo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbTenNguoiDung)
                            .addComponent(txtTenNguoiDung, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jblTenDangNhap)
                            .addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtErrorTenNguoiDung)
                            .addComponent(txtErrorTenDangNhap))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbEmail)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JblNgaySinh)))
                    .addComponent(jDateNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtErrorEmail)
                    .addComponent(txtErrorNgaySinh))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNhapLaiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JblNhapLaiMatKhau))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlbMatKhau)
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
                                .addComponent(JblMaNhomQuyen))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jcbMaNhomQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioNam)
                            .addComponent(jRadioNu)
                            .addComponent(JblGioiTinh)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblShowImage, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuyBo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChonAnh))
                .addGap(98, 98, 98))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(123, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        resetText();
        jDateNgaySinh.setCalendar(null);
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnHuyBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyBoActionPerformed
        resetText();
        dispose();
    }//GEN-LAST:event_btnHuyBoActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        Boolean check = true;

        NhomQuyen nq = (NhomQuyen) modelNhomQuyen.getSelectedItem();
        int maNhomQuyen = nq.getMaNhomQuyen();

        String tenND = txtTenNguoiDung.getText();
        String email = txtEmail.getText();
        String tenDangNhap = txtTenDangNhap.getText();
        String matKhau = new String(txtMatKhau.getPassword());
        String nhapLaiMatKhau = new String(txtNhapLaiMatKhau.getPassword());

        if (tenND.length() <= 0) {
            txtErrorTenNguoiDung.setText(this.rb.getString("AddNdTenTrong"));
            check = false;
        } else if (tenND.length() > 50) {
            txtErrorTenNguoiDung.setText(this.rb.getString("AddNdTenToiDa"));
            check = false;
        } else {
            txtErrorTenNguoiDung.setText("");
        }

        if (tenDangNhap.length() <= 0) {
            txtErrorTenDangNhap.setText(this.rb.getString("AddNdTenDangNhapTrong"));
            check = false;
        } else if (tenDangNhap.length() > 50) {
            txtErrorTenDangNhap.setText(this.rb.getString("AddNdTenDangNhapToiDa"));
            check = false;
        } else {
            txtErrorTenDangNhap.setText("");
        }

        try {
            List<NguoiDung> lstCheckID = nguoiDungDAO.getByTenDangNhap(tenDangNhap);
            if (lstCheckID.size() > 0) {
                txtErrorTenDangNhap.setText(this.rb.getString("AddNdTenDangNhapTonTai"));
                check = false;
            }
        } catch (Exception e) {
            txtErrorTenDangNhap.setText(this.rb.getString("AddNdTenDangNhapTonTai"));
        }

        if (email.length() <= 0) {
            txtErrorEmail.setText(this.rb.getString("AddNdEmailTrong"));
            check = false;
        } else if (email.length() > 50) {
            txtErrorEmail.setText(this.rb.getString("AddNdEmailToiDa"));
            check = false;
        } else {
            txtErrorEmail.setText("");
        }

        try {
            List<NguoiDung> lstCheckID = nguoiDungDAO.getByEmail(email);
            if (lstCheckID.size() > 0) {
                txtErrorEmail.setText(this.rb.getString("AddNdEmailTonTai"));
                check = false;
            }
        } catch (Exception e) {
            txtErrorEmail.setText(this.rb.getString("AddNdEmailTonTai"));
        }

        if (matKhau.length() <= 0) {
            txtErrorMatKhau.setText(this.rb.getString("AddNdMkTrong"));
            check = false;
        } else if (matKhau.length() > 12) {
            txtErrorMatKhau.setText(this.rb.getString("AddNdMkToiDa"));
            check = false;
        } else {
            txtErrorMatKhau.setText("");
        }

        if (nhapLaiMatKhau.length() <= 0) {
            txtErrorNhapLaiMatKhau.setText(this.rb.getString("AddNdMkNlTrong"));
            check = false;
        } else if (nhapLaiMatKhau.length() > 12) {
            txtErrorNhapLaiMatKhau.setText(this.rb.getString("AddNdMkNlToiDa"));
            check = false;
        } else if (!Arrays.equals(txtMatKhau.getPassword(), txtNhapLaiMatKhau.getPassword())) {
            txtErrorNhapLaiMatKhau.setText(this.rb.getString("AddNdMkTrung"));
            check = false;
        } else {
            txtErrorNhapLaiMatKhau.setText("");
        }

        LocalDate dateBatDau = null;
        if (jDateNgaySinh.getDate() != null) {
            dateBatDau = jDateNgaySinh.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            txtErrorNgaySinh.setText("");
        } else {
            txtErrorNgaySinh.setText(this.rb.getString("AddNdNSTrong"));
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
            int row = nguoiDungDAO.update(new NguoiDung(maNguoiDung, tenND, tenDangNhap, matKhau, nguoidungImage, email, dateBatDau, gioiTinh, maNhomQuyen));
            if (row > 0) {
                JOptionPane.showMessageDialog(rootPane, this.rb.getString("ConfirmDialogMsgCapNhatOK"), this.rb.getString("ConfirmDialogTitle"), JOptionPane.INFORMATION_MESSAGE);
                resetText();
                cb.doUpdate();
                dispose();
            } else {
                JOptionPane.showMessageDialog(rootPane, this.rb.getString("ConfirmDialogMsgCapNhatErr"), this.rb.getString("ConfirmDialogTitle"), JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

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
    private javax.swing.JLabel JblGioiTinh;
    private javax.swing.JLabel JblMaNhomQuyen;
    private javax.swing.JLabel JblNgaySinh;
    private javax.swing.JLabel JblNhapLaiMatKhau;
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnChonAnh;
    private javax.swing.JButton btnHuyBo;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.ButtonGroup buttonGroupGioiTinh;
    private com.toedter.calendar.JDateChooser jDateNgaySinh;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioNam;
    private javax.swing.JRadioButton jRadioNu;
    private javax.swing.JLabel jblTenDangNhap;
    private javax.swing.JComboBox<NhomQuyen> jcbMaNhomQuyen;
    private javax.swing.JLabel jlbEmail;
    private javax.swing.JLabel jlbMatKhau;
    private javax.swing.JLabel jlbTenNguoiDung;
    private javax.swing.JLabel jlbTitle;
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
