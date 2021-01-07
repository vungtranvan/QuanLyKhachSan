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
import java.util.ResourceBundle;
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

    ResourceBundle rb;

    public interface CallBackCheckOut {

        void doCheckOut();
    }

    /**
     * Creates new form PhieuSDDichVu
     */
    public ThanhToanHoaDon(CallBackCheckOut _cb, String _maNhanPhong, String _maPhong, String maKH, String _tenNhanVien, ResourceBundle rb) {
        initComponents();
        this.rb = rb;
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
        jlbMaDaTonTai.setText("");
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

    public void translate(ResourceBundle rb) {
        this.rb = rb;
        btnHuyBo.setText(rb.getString("btnHuyBo"));
        btnThanhToan.setText(rb.getString("btnThanhToan"));
        jlbKhuyenMai.setText(rb.getString("jlbKhuyenMai"));
        jlbHinhThucThanhToan.setText(rb.getString("jlbHinhThucThanhToan"));
        jlbMaGiamGia.setText(rb.getString("jlbMaGiamGia"));
        jlbMaNhanPhong.setText(rb.getString("jlbMaNhanPhong"));
        jlbMaPhong.setText(rb.getString("jlbMaPhong"));
        jlbNgayDi.setText(rb.getString("jlbNgayDi"));
        jlbNgayThue.setText(rb.getString("jlbNgayThue"));
        jlbPhuThu.setText(rb.getString("jlbPhuThu"));
        jlbTenKhachhang.setText(rb.getString("jlbTenKhachhang"));
        jlbTienDichVu.setText(rb.getString("jlbTienDichVu"));
        jlbTienPhong.setText(rb.getString("jlbTienPhong"));
        jlbTongTien.setText(rb.getString("jlbTongTien"));
        jlbCMND.setText(rb.getString("lblCMND"));
        jlbLoaiPhong.setText(rb.getString("jlbLoaiPhong"));
        jlbGioiTinh.setText(rb.getString("lblGioiTinh"));
        jlbMaNhanPhong.setText(rb.getString("lblMaNhanPhong"));
        jlbMaPhong.setText(rb.getString("lblMaPhong"));
        jlbNgayDi.setText(rb.getString("lblNgayDi"));
        jlbNgayThue.setText(rb.getString("lblNgayThue"));
        jlbPhuThu.setText(rb.getString("lblPhuThu"));
        jlbTenKhachhang.setText(rb.getString("lblTenKhachHang"));
        jlbTienDichVu.setText(rb.getString("lblTienDichVu"));
        jlbTongTien.setText(rb.getString("lblTongTien"));
        rdTienMat.setText(rb.getString("rdTienMat"));
        rdTienThe.setText(rb.getString("rdTienThe"));
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
        jpnTTKhachHang = new javax.swing.JPanel();
        jlbMaNhanPhong = new javax.swing.JLabel();
        lblMaNhanPhong = new javax.swing.JLabel();
        jlbMaPhong = new javax.swing.JLabel();
        lblMaPhong = new javax.swing.JLabel();
        jlbTenKhachhang = new javax.swing.JLabel();
        lblTenKhachHang = new javax.swing.JLabel();
        jlbCMND = new javax.swing.JLabel();
        lblCMND = new javax.swing.JLabel();
        jlbGioiTinh = new javax.swing.JLabel();
        lblGioiTinh = new javax.swing.JLabel();
        jlbSDT = new javax.swing.JLabel();
        lblSDT = new javax.swing.JLabel();
        jlbLoaiPhong = new javax.swing.JLabel();
        lblLoaiPhong = new javax.swing.JLabel();
        jlbNgayThue = new javax.swing.JLabel();
        lblNgayThue = new javax.swing.JLabel();
        jlbNgayDi = new javax.swing.JLabel();
        lblNgayDi = new javax.swing.JLabel();
        jtbDanhSachSuDungDichVu = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDichVuDaSD = new javax.swing.JTable();
        jblTitle = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jlbTienPhong = new javax.swing.JLabel();
        lblGiaPhong = new javax.swing.JLabel();
        jlbTienDichVu = new javax.swing.JLabel();
        lblTienDichVu = new javax.swing.JLabel();
        jlbTongTien = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        btnHuyBo = new javax.swing.JButton();
        jlbMaGiamGia = new javax.swing.JLabel();
        txtSearchMaKhuyenMai = new javax.swing.JTextField();
        jlbKhuyenMai = new javax.swing.JLabel();
        lblKhuyenMai = new javax.swing.JLabel();
        jlbHinhThucThanhToan = new javax.swing.JLabel();
        rdTienMat = new javax.swing.JRadioButton();
        rdTienThe = new javax.swing.JRadioButton();
        jlbPhuThu = new javax.swing.JLabel();
        lblPhuThu = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        btnKiemTraMaKM = new javax.swing.JButton();
        jlbMaDaTonTai = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);

        jpnTTKhachHang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin phòng và khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jlbMaNhanPhong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlbMaNhanPhong.setText("Mã nhận phòng:");

        lblMaNhanPhong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMaNhanPhong.setText("...");

        jlbMaPhong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlbMaPhong.setText("Mã phòng:");

        lblMaPhong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMaPhong.setText("...");

        jlbTenKhachhang.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlbTenKhachhang.setText("Tên khách hàng:");

        lblTenKhachHang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTenKhachHang.setText("....");

        jlbCMND.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlbCMND.setText("CMND:");

        lblCMND.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCMND.setText("...");

        jlbGioiTinh.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlbGioiTinh.setText("Giới tính:");

        lblGioiTinh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblGioiTinh.setText("...");

        jlbSDT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlbSDT.setText("SĐT:");

        lblSDT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSDT.setText("...");

        jlbLoaiPhong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlbLoaiPhong.setText("Loại phòng:");

        lblLoaiPhong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblLoaiPhong.setText("...");

        jlbNgayThue.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlbNgayThue.setText("Ngày thuê:");

        lblNgayThue.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNgayThue.setText("...");

        jlbNgayDi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlbNgayDi.setText("Ngày đi:");

        lblNgayDi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNgayDi.setText("...");

        javax.swing.GroupLayout jpnTTKhachHangLayout = new javax.swing.GroupLayout(jpnTTKhachHang);
        jpnTTKhachHang.setLayout(jpnTTKhachHangLayout);
        jpnTTKhachHangLayout.setHorizontalGroup(
            jpnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTTKhachHangLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jpnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbMaNhanPhong)
                    .addComponent(jlbMaPhong)
                    .addComponent(jlbLoaiPhong))
                .addGap(27, 27, 27)
                .addGroup(jpnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblMaNhanPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMaPhong, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
                    .addComponent(lblLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jpnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbTenKhachhang)
                    .addComponent(jlbCMND)
                    .addComponent(jlbNgayThue))
                .addGap(18, 18, 18)
                .addGroup(jpnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTenKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCMND, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(lblNgayThue, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbGioiTinh)
                    .addComponent(jlbSDT)
                    .addComponent(jlbNgayDi))
                .addGap(18, 18, 18)
                .addGroup(jpnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSDT, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                    .addComponent(lblNgayDi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jpnTTKhachHangLayout.setVerticalGroup(
            jpnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTTKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbMaNhanPhong)
                    .addComponent(lblMaNhanPhong)
                    .addComponent(jlbTenKhachhang)
                    .addComponent(lblTenKhachHang)
                    .addComponent(jlbGioiTinh)
                    .addComponent(lblGioiTinh))
                .addGap(18, 18, 18)
                .addGroup(jpnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbMaPhong)
                    .addComponent(lblMaPhong)
                    .addComponent(jlbCMND)
                    .addComponent(lblCMND)
                    .addComponent(jlbSDT)
                    .addComponent(lblSDT))
                .addGap(26, 26, 26)
                .addGroup(jpnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbLoaiPhong)
                    .addComponent(lblLoaiPhong)
                    .addComponent(jlbNgayThue)
                    .addComponent(lblNgayThue)
                    .addComponent(jlbNgayDi)
                    .addComponent(lblNgayDi))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtbDanhSachSuDungDichVu.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách dịch vụ đã sử dụng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

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

        javax.swing.GroupLayout jtbDanhSachSuDungDichVuLayout = new javax.swing.GroupLayout(jtbDanhSachSuDungDichVu);
        jtbDanhSachSuDungDichVu.setLayout(jtbDanhSachSuDungDichVuLayout);
        jtbDanhSachSuDungDichVuLayout.setHorizontalGroup(
            jtbDanhSachSuDungDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jtbDanhSachSuDungDichVuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jtbDanhSachSuDungDichVuLayout.setVerticalGroup(
            jtbDanhSachSuDungDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jtbDanhSachSuDungDichVuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jblTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jblTitle.setText("THANH TOÁN");

        jlbTienPhong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlbTienPhong.setText("Tiền phòng:");

        lblGiaPhong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblGiaPhong.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGiaPhong.setText("...");

        jlbTienDichVu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlbTienDichVu.setText("Tiền dịch vụ: ");

        lblTienDichVu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTienDichVu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTienDichVu.setText("...");

        jlbTongTien.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlbTongTien.setText("Tổng tiền:");

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

        jlbMaGiamGia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlbMaGiamGia.setText("Mã giảm giá:");

        jlbKhuyenMai.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlbKhuyenMai.setText("Khuyến mại:");

        lblKhuyenMai.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblKhuyenMai.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblKhuyenMai.setText("...");

        jlbHinhThucThanhToan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlbHinhThucThanhToan.setText("Hình thức thanh toán:");

        buttonGroup1.add(rdTienMat);
        rdTienMat.setSelected(true);
        rdTienMat.setText("Tiền mặt");

        buttonGroup1.add(rdTienThe);
        rdTienThe.setText("Tiền thẻ");

        jlbPhuThu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlbPhuThu.setText("Phụ thu:");

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

        jlbMaDaTonTai.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jlbMaDaTonTai.setText("Mã đã tồn tại");

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
                        .addComponent(jlbHinhThucThanhToan)
                        .addGap(18, 18, 18)
                        .addComponent(rdTienMat)
                        .addGap(18, 18, 18)
                        .addComponent(rdTienThe))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlbMaGiamGia)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlbMaDaTonTai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSearchMaKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnKiemTraMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jlbTienDichVu)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jlbTongTien)
                            .addGap(36, 36, 36)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlbPhuThu)
                            .addComponent(jlbTienPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlbKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(27, 27, 27)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPhuThu, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblKhuyenMai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTienDichVu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblGiaPhong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addComponent(jlbTienPhong)
                                .addComponent(lblGiaPhong))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jlbMaDaTonTai, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbTienDichVu)
                            .addComponent(lblTienDichVu))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblKhuyenMai)
                                    .addComponent(jlbKhuyenMai))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlbPhuThu)
                                    .addComponent(lblPhuThu)
                                    .addComponent(jLabel14))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlbTongTien)
                                    .addComponent(lblTongTien)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSearchMaKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlbMaGiamGia)
                                    .addComponent(btnKiemTraMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlbHinhThucThanhToan)
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
                            .addComponent(jtbDanhSachSuDungDichVu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(339, 339, 339)
                        .addComponent(jblTitle)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 25, Short.MAX_VALUE)
                .addComponent(jpnTTKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jblTitle)
                .addGap(41, 41, 41)
                .addComponent(jpnTTKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jtbDanhSachSuDungDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            jlbMaDaTonTai.setText("");
                        } else {
                            jlbMaDaTonTai.setText("Mã này đã được sử dụng trước đó !!!");
                            jlbMaDaTonTai.setForeground(Color.RED);
                        }
                    }
                } else {
                    jlbMaDaTonTai.setText("Mã này đã hết hạn sử dụng !!!");
                    jlbMaDaTonTai.setForeground(Color.RED);
                }

            } else {
                jlbMaDaTonTai.setText("Mã không tồn tại !!!");
                jlbMaDaTonTai.setForeground(Color.RED);
            }
        } else {
            jlbMaDaTonTai.setText("");
            jlbMaDaTonTai.setForeground(Color.BLACK);
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jblTitle;
    private javax.swing.JLabel jlbCMND;
    private javax.swing.JLabel jlbGioiTinh;
    private javax.swing.JLabel jlbHinhThucThanhToan;
    private javax.swing.JLabel jlbKhuyenMai;
    private javax.swing.JLabel jlbLoaiPhong;
    private javax.swing.JLabel jlbMaDaTonTai;
    private javax.swing.JLabel jlbMaGiamGia;
    private javax.swing.JLabel jlbMaNhanPhong;
    private javax.swing.JLabel jlbMaPhong;
    private javax.swing.JLabel jlbNgayDi;
    private javax.swing.JLabel jlbNgayThue;
    private javax.swing.JLabel jlbPhuThu;
    private javax.swing.JLabel jlbSDT;
    private javax.swing.JLabel jlbTenKhachhang;
    private javax.swing.JLabel jlbTienDichVu;
    private javax.swing.JLabel jlbTienPhong;
    private javax.swing.JLabel jlbTongTien;
    private javax.swing.JPanel jpnTTKhachHang;
    private javax.swing.JPanel jtbDanhSachSuDungDichVu;
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
    // End of variables declaration//GEN-END:variables
}
