/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.view.internalframe;

import com.qlks.custom.FunctionBase;
import com.qlks.dao.impl.ChiTietHoaDonDAO;
import com.qlks.dao.impl.ChiTietPhieuNhanPhongDAO;
import com.qlks.dao.impl.DanhSachSuDungDichVuDAO;
import com.qlks.dao.impl.HoaDonDAO;
import com.qlks.dao.impl.KhachHangDAO;
import com.qlks.dao.impl.KhuyenMaiDAO;
import com.qlks.dao.impl.LoaiPhongDAO;
import com.qlks.dao.impl.PhieuNhanPhongDAO;
import com.qlks.dao.impl.PhongDAO;
import com.qlks.models.DanhSachSuDungDichVu;
import com.qlks.models.HoaDon;
import com.qlks.models.KhachHang;
import com.qlks.models.LoaiPhong;
import com.qlks.models.ChiTietHoaDon;
import com.qlks.models.ChiTietPhieuNhanPhong;
import com.qlks.models.KhuyenMai;
import com.qlks.models.Phong;
import java.awt.Color;
import java.awt.Dimension;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hello
 */
public class ThanhToanHoaDon extends javax.swing.JInternalFrame {

    private DefaultComboBoxModel modelDichVu;

    private DanhSachSuDungDichVuDAO dsSDDichVuDAO;
    private JDesktopPane jdek;
    private PhieuNhanPhongDAO phieuNhanPhongDAO;
    private HoaDonDAO hoaDonDAO;
    private ChiTietHoaDonDAO chiTietHoaDonDAO;
    private List<DanhSachSuDungDichVu> lstDanhSachSuDungDichVu;
    private DefaultTableModel dtmDanhSachSuDungDichVu;
    private KhachHangDAO khachHangDAO;
    private PhongDAO phongDAO;
    private LoaiPhongDAO loaiPhongDAO;
    private List<KhachHang> lstKhachHangByID;
    private String maKhachHang;
    private String maNhanPhong;
    private String maPhong;
    private String tenNhanVien;
    private FunctionBase funcBase;
    private KhuyenMaiDAO khuyenMaiDAO;
    private ChiTietPhieuNhanPhongDAO chiTietPhieuNhanPhongDAO;
    private int soNgay = 0;
    private int _maHoaDon = 0;
    CallBackCheckOut cb;
    private float tienPhong = 0;
    private float tongTienDVu = 0;
    private float tienKM = 0;
    private String maPhieuCodeKM = "";
    private int maKhuyenMai = 0;

    public interface CallBackCheckOut {

        void doCheckOut();
    }

    /**
     * Creates new form PhieuSDDichVu
     */
    public ThanhToanHoaDon(CallBackCheckOut _cb, String _maNhanPhong, String _maPhong, String maKH, String _tenNhanVien) {
        initComponents();
        cb = _cb;
        khuyenMaiDAO = new KhuyenMaiDAO();
        phieuNhanPhongDAO = new PhieuNhanPhongDAO();
        dtmDanhSachSuDungDichVu = new DefaultTableModel();
        chiTietPhieuNhanPhongDAO = new ChiTietPhieuNhanPhongDAO();
        modelDichVu = new DefaultComboBoxModel();
        dsSDDichVuDAO = new DanhSachSuDungDichVuDAO();
        khachHangDAO = new KhachHangDAO();
        phongDAO = new PhongDAO();
        loaiPhongDAO = new LoaiPhongDAO();
        funcBase = new FunctionBase();
        lblMaNhanPhong.setText(_maNhanPhong);
        lblMaPhong.setText(_maPhong);
        maKhachHang = maKH;
        maNhanPhong = _maNhanPhong;
        maPhong = _maPhong;
        tenNhanVien = _tenNhanVien;
        lstKhachHangByID = khachHangDAO.getByMa(maKH);
        txtThongBaoKM.setText("");
        setData();
        initDVDSD();
        lblTongTien.setText(funcBase.formatTien(sumTongTien()));
    }

    public void setData() {

        List<ChiTietPhieuNhanPhong> lstCTNPBYID = chiTietPhieuNhanPhongDAO.getByMaNhanPhong(maNhanPhong);
        for (ChiTietPhieuNhanPhong lstCT : lstCTNPBYID) {
            LocalDate ngayDn = lstCT.getNgayNhan();
            LocalDate ngayDi = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            lblNgayThue.setText(ngayDn.format(formatter));
            lblNgayDi.setText(ngayDi.format(formatter));
        }
        soNgay = funcBase.calendaDay(lblNgayThue.getText(), lblNgayDi.getText());
        hoaDonDAO = new HoaDonDAO();
        chiTietHoaDonDAO = new ChiTietHoaDonDAO();
        List<Phong> lstPhong = phongDAO.getByMaPhong(maPhong);
        for (Phong p : lstPhong) {
            List<LoaiPhong> lstLoaiPhong = loaiPhongDAO.getByMa(p.getMaLoaiPhong());
            for (LoaiPhong lp : lstLoaiPhong) {
                tienPhong = lp.getDonGia();
                lblGiaPhong.setText(funcBase.formatTien(tienPhong));
                lblLoaiPhong.setText(lp.getTenLoaiPhong());
            }
        }

        lblKhuyenMai.setText(Float.toString(tienKM));

        lblPhuThu.setText(Float.toString(funcBase.funcGetGiaTriPhuThu()));
        for (KhachHang kh : lstKhachHangByID) {
            lblTenKhachHang.setText(kh.getTenKhachHang());
            lblCMND.setText(kh.getChungMinhThuNhanDan());
            lblSDT.setText(kh.getDienThoai());
            if (kh.isGioiTinh() == true) {
                lblGioiTinh.setText("Nam");
            } else {
                lblGioiTinh.setText("Nữ");
            }

        }
    }

    public void initDVDSD() {
        lstDanhSachSuDungDichVu = dsSDDichVuDAO.getAll(maNhanPhong);
        //lstDanhSachSuDungDichVu.remove(0);
        Object[] columnNames = {"STT", "Mã dịch vụ", "Loại dịch vụ", "Đơn vị", "Số lượng", "Đơn giá", "Thành tiền"};
        dtmDanhSachSuDungDichVu = new DefaultTableModel(new Object[0][0], columnNames);
        if (lstDanhSachSuDungDichVu.size() > 0) {
            int index = 1;
            for (DanhSachSuDungDichVu adv : lstDanhSachSuDungDichVu) {
                if (lstDanhSachSuDungDichVu.get(lstDanhSachSuDungDichVu.size() - 1) != adv) {
                    modelDichVu.addElement(adv);
                    Object[] o = new Object[7];
                    o[0] = index;
                    o[1] = adv.getMaDichVu();
                    o[2] = adv.getTenLoaiDichVu();
                    o[3] = adv.getTenDonvi();
                    o[4] = adv.getSoLuong();
                    o[5] = (int) adv.getDonGia();
                    o[6] = adv.getSoLuong() * (int) adv.getDonGia();
                    dtmDanhSachSuDungDichVu.addRow(o);
                    index++;
                }
            }
            tblDichVuDaSD.setModel(dtmDanhSachSuDungDichVu);
            tongTienDVu = SumTienDV();
            lblTienDichVu.setText(funcBase.formatTien(tongTienDVu));
        } else {
            tblDichVuDaSD.setModel(dtmDanhSachSuDungDichVu);
            lblTienDichVu.setText(funcBase.formatTien(tongTienDVu));
        }

    }

    public int SumTienDV() {
        int rowcount = tblDichVuDaSD.getRowCount();
        int sum = 0;
        for (int i = 0; i < rowcount; i++) {
            sum += Integer.parseInt(tblDichVuDaSD.getValueAt(i, 6).toString());
        }
        return sum;
    }

    public float sumTongTien() {
        float sum = 0;
        float tongTienDV = 0;
        if (lstDanhSachSuDungDichVu.size() > 0) {
            tongTienDV = (float) SumTienDV();
        }

        float tongTienPhong = tienPhong * soNgay;
        float tienPhuThu = tienPhong * funcBase.funcGetGiaTriPhuThu() / 100;
        float tienKhuyenMai = tienKM;
        sum = tongTienDV + tongTienPhong + tienPhuThu - tienKhuyenMai;
        return sum;
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblMaNhanPhong = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblMaPhong = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblTenKhachHang = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblCMND = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblGioiTinh = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblSDT = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblLoaiPhong = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lblNgayThue = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lblNgayDi = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDichVuDaSD = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblGiaPhong = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblTienDichVu = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        btnHuyBo = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txtSearchMaKhuyenMai = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        lblKhuyenMai = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        rdTienMat = new javax.swing.JRadioButton();
        rdTienThe = new javax.swing.JRadioButton();
        jLabel21 = new javax.swing.JLabel();
        lblPhuThu = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        btnKiemTraMaKM = new javax.swing.JButton();
        txtThongBaoKM = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin phòng và khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Mã nhận phòng:");

        lblMaNhanPhong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMaNhanPhong.setText("...");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Mã phòng:");

        lblMaPhong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMaPhong.setText("...");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Tên khách hàng:");

        lblTenKhachHang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTenKhachHang.setText("....");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("CMND:");

        lblCMND.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCMND.setText("...");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Giới tính:");

        lblGioiTinh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblGioiTinh.setText("...");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("SĐT:");

        lblSDT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSDT.setText("...");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Loại phòng:");

        lblLoaiPhong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblLoaiPhong.setText("...");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setText("Ngày thuê:");

        lblNgayThue.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNgayThue.setText("...");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setText("Ngày đi:");

        lblNgayDi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNgayDi.setText("...");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8))
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblMaNhanPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMaPhong, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
                    .addComponent(lblLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTenKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCMND, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(lblNgayThue, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15)
                    .addComponent(jLabel24))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSDT, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                    .addComponent(lblNgayDi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblMaNhanPhong)
                    .addComponent(jLabel5)
                    .addComponent(lblTenKhachHang)
                    .addComponent(jLabel13)
                    .addComponent(lblGioiTinh))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblMaPhong)
                    .addComponent(jLabel4)
                    .addComponent(lblCMND)
                    .addComponent(jLabel15)
                    .addComponent(lblSDT))
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblLoaiPhong)
                    .addComponent(jLabel19)
                    .addComponent(lblNgayThue)
                    .addComponent(jLabel24)
                    .addComponent(lblNgayDi))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách dịch vụ đã sử dụng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        tblDichVuDaSD.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblDichVuDaSD);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("THANH TOÁN");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Tiền phòng:");

        lblGiaPhong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblGiaPhong.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGiaPhong.setText("...");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Tiền dịch vụ: ");

        lblTienDichVu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTienDichVu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTienDichVu.setText("...");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Tổng tiền:");

        lblTongTien.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTongTien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTongTien.setText("...");

        btnThanhToan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_ckeckout.png"))); // NOI18N
        btnThanhToan.setText("Trả phòng và thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnHuyBo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnHuyBo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_close.png"))); // NOI18N
        btnHuyBo.setText("Hủy bỏ");
        btnHuyBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyBoActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Mã giảm giá:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("Khuyến mại:");

        lblKhuyenMai.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblKhuyenMai.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblKhuyenMai.setText("...");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setText("Hình thức thanh toán:");

        buttonGroup1.add(rdTienMat);
        rdTienMat.setSelected(true);
        rdTienMat.setText("Tiền mặt");

        buttonGroup1.add(rdTienThe);
        rdTienThe.setText("Tiền thẻ");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setText("Phụ thu:");

        lblPhuThu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPhuThu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPhuThu.setText("...");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("VND");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("VND");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("%");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("VND");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("VND");

        btnKiemTraMaKM.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnKiemTraMaKM.setText("Kiểm tra");
        btnKiemTraMaKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKiemTraMaKMActionPerformed(evt);
            }
        });

        txtThongBaoKM.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtThongBaoKM.setText("Mã đã tồn tại");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(482, Short.MAX_VALUE)
                .addComponent(btnHuyBo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnThanhToan)
                .addGap(23, 23, 23))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)
                        .addComponent(rdTienMat)
                        .addGap(18, 18, 18)
                        .addComponent(rdTienThe))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtThongBaoKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSearchMaKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnKiemTraMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addGap(36, 36, 36)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel18))
                                .addGap(27, 27, 27)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPhuThu, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblKhuyenMai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblTienDichVu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblGiaPhong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10)
                    .addComponent(jLabel16)
                    .addComponent(jLabel23)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel14)))
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel10)
                        .addGap(17, 17, 17)
                        .addComponent(jLabel23))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jLabel16))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(lblGiaPhong))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(txtThongBaoKM, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(lblTienDichVu))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblKhuyenMai)
                                    .addComponent(jLabel18))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21)
                                    .addComponent(lblPhuThu)
                                    .addComponent(jLabel14))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(lblTongTien)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSearchMaKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17)
                                    .addComponent(btnKiemTraMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20)
                                    .addComponent(rdTienMat)
                                    .addComponent(rdTienThe))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuyBo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(339, 339, 339)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 25, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addGap(41, 41, 41)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        int row = 0;
        if (tienKM > 0) {
            row = hoaDonDAO.add(new HoaDon(maKhachHang, maNhanPhong, maKhuyenMai, tenNhanVien, sumTongTien(), LocalDate.now()));
        } else {
            row = hoaDonDAO.addNoKM(new HoaDon(maKhachHang, maNhanPhong, tenNhanVien, sumTongTien(), LocalDate.now()));
        }

        if (row > 0) {
            List<HoaDon> getIdHoaDon = hoaDonDAO.getIdMAX();
            int row2 = 0;
            String hinhThucTT = "Tiền mặt";
            if (rdTienThe.isSelected() == true) {
                hinhThucTT = "Tiền thẻ";
            }
            for (HoaDon idHoaDon : getIdHoaDon) {
                _maHoaDon = idHoaDon.getMaHoaDon();
                for (DanhSachSuDungDichVu adv : lstDanhSachSuDungDichVu) {
                    row2 = chiTietHoaDonDAO.addCoDV(new ChiTietHoaDon(idHoaDon.getMaHoaDon(), maPhong, adv.getMaSuDungDVu(), funcBase.funcGetMaPhuThu(), funcBase.funcGetGiaTriPhuThu(),
                            tienPhong, adv.getDonGia(), tienKM, hinhThucTT, soNgay, sumTongTien()));
                }

            }
            if (row2 > 0) {
                phieuNhanPhongDAO.updateTrangThai(maNhanPhong);
                phongDAO.updatePhongDaThanhToan(maPhong);
                ChiTietPhieuNhanPhong ctP = new ChiTietPhieuNhanPhong(maNhanPhong, LocalDate.now());
                chiTietPhieuNhanPhongDAO.updateNgayTraDuKien(ctP);
                JOptionPane.showMessageDialog(rootPane, "Thanh toán thành công", null, JOptionPane.INFORMATION_MESSAGE);
                cb.doCheckOut();
                ChiTietHoaDonView jframeChiTietHoaDon = new ChiTietHoaDonView(_maHoaDon);
                showInternalFrame(jframeChiTietHoaDon);

                if (tienKM > 0) {
                    khuyenMaiDAO.updateTrangThai(maPhieuCodeKM);
                }

                dispose();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Thanh toán thất bại", null, JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnHuyBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyBoActionPerformed
        dispose();
    }//GEN-LAST:event_btnHuyBoActionPerformed

    private void btnKiemTraMaKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKiemTraMaKMActionPerformed
        String maPhieuInput = txtSearchMaKhuyenMai.getText().trim();
        if (maPhieuInput.length() > 0) {
            List<KhuyenMai> lstKM = khuyenMaiDAO.getByMaPhieuKhuyenMai(maPhieuInput);
            List<KhuyenMai> lstKM_KTDate = khuyenMaiDAO.kiemTraHieuLucKM(maPhieuInput, LocalDate.now());
            if (lstKM.size() > 0) {
                if (lstKM_KTDate.size() > 0) {
                    for (KhuyenMai km : lstKM) {
                        maPhieuCodeKM = km.getMaPhieu();
                        maKhuyenMai = km.getMaKhuyenMai();
                        if (km.isTrangThai() == false) {
                            if (km.isKieuTinh() == true) {
                                tienKM = (tienPhong * km.getGiaTri()) / 100;
                            } else {
                                tienKM = km.getGiaTri();
                            }
                            txtThongBaoKM.setText("");
                        } else {
                            txtThongBaoKM.setText("Mã này đã được sử dụng trước đó !!!");
                            txtThongBaoKM.setForeground(Color.RED);
                        }
                    }
                } else {
                    txtThongBaoKM.setText("Mã này đã hết hạn sử dụng !!!");
                    txtThongBaoKM.setForeground(Color.RED);
                }

            } else {
                txtThongBaoKM.setText("Mã không tồn tại !!!");
                txtThongBaoKM.setForeground(Color.RED);
            }
        } else {
            txtThongBaoKM.setText("");
            txtThongBaoKM.setForeground(Color.BLACK);
            tienKM = 0;
        }
        setData();
        initDVDSD();
        lblTongTien.setText(funcBase.formatTien(sumTongTien()));
    }//GEN-LAST:event_btnKiemTraMaKMActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuyBo;
    private javax.swing.JButton btnKiemTraMaKM;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCMND;
    private javax.swing.JLabel lblGiaPhong;
    private javax.swing.JLabel lblGioiTinh;
    private javax.swing.JLabel lblKhuyenMai;
    private javax.swing.JLabel lblLoaiPhong;
    private javax.swing.JLabel lblMaNhanPhong;
    private javax.swing.JLabel lblMaPhong;
    private javax.swing.JLabel lblNgayDi;
    private javax.swing.JLabel lblNgayThue;
    private javax.swing.JLabel lblPhuThu;
    private javax.swing.JLabel lblSDT;
    private javax.swing.JLabel lblTenKhachHang;
    private javax.swing.JLabel lblTienDichVu;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JRadioButton rdTienMat;
    private javax.swing.JRadioButton rdTienThe;
    private javax.swing.JTable tblDichVuDaSD;
    private javax.swing.JTextField txtSearchMaKhuyenMai;
    private javax.swing.JLabel txtThongBaoKM;
    // End of variables declaration//GEN-END:variables
}
