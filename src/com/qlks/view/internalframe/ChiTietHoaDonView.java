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
import com.qlks.dao.impl.LoaiPhongDAO;
import com.qlks.dao.impl.PhongDAO;
import com.qlks.models.ChiTietHoaDon;
import com.qlks.models.ChiTietPhieuNhanPhong;
import com.qlks.models.DanhSachSuDungDichVu;
import com.qlks.models.HoaDon;
import com.qlks.models.KhachHang;
import com.qlks.models.LoaiPhong;
import com.qlks.models.Phong;
import com.qlks.utils.MethodMain;
import java.awt.Dimension;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author hoangdung
 */
public class ChiTietHoaDonView extends javax.swing.JInternalFrame {

    private HoaDonDAO hoaDonDAO;
    private KhachHangDAO khachHangDAO;
    private ChiTietHoaDonDAO chiTietHoaDonDAO;
    private DanhSachSuDungDichVuDAO dsSDDichVuDAO;
    private DefaultTableModel dtmDanhSachSuDungDichVu;
    private ChiTietPhieuNhanPhongDAO chiTietPhieuNhanPhongDAO;
    private List<DanhSachSuDungDichVu> lstDanhSachSuDungDichVu;
    private int maHoaDOn = 0;
    private String maNhanPhong = "";
    private FunctionBase funcBase;
    private PhongDAO phongDAO;
    private LoaiPhongDAO loaiPhongDAO;

    /**
     * Creates new form ChiTietHoaDon
     */
    public ChiTietHoaDonView(int _maHoaDon) {
        initComponents();
        hoaDonDAO = new HoaDonDAO();
        phongDAO = new PhongDAO();
        loaiPhongDAO = new LoaiPhongDAO();
        khachHangDAO = new KhachHangDAO();
        chiTietHoaDonDAO = new ChiTietHoaDonDAO();
        dsSDDichVuDAO = new DanhSachSuDungDichVuDAO();
        dtmDanhSachSuDungDichVu = new DefaultTableModel();
        chiTietPhieuNhanPhongDAO = new ChiTietPhieuNhanPhongDAO();
        maHoaDOn = _maHoaDon;
        funcBase = new FunctionBase();
        setData();
        initDVDSD();
    }

    public void setData() {
        List<HoaDon> lstHoaDon = hoaDonDAO.getByMaHoaDon(maHoaDOn);
        for (HoaDon hd : lstHoaDon) {
            lblMaHoaDon.setText(Integer.toString(hd.getMaHoaDon()));
            lblSo.setText(Integer.toString(hd.getMaHoaDon()));
            lblNhanVienLap.setText(hd.getNhanVienLap());
            lblTongTien.setText(funcBase.formatTien(hd.getTongTien()));

            maNhanPhong = hd.getMaNhanPhong();
            List<ChiTietPhieuNhanPhong> lstCTNPBYID = chiTietPhieuNhanPhongDAO.getByMaNhanPhong(maNhanPhong);
            List<String> lstMaPhong = new ArrayList<>();
            for (ChiTietPhieuNhanPhong lstCT : lstCTNPBYID) {
                lstMaPhong.add(lstCT.getMaPhong());
                LocalDate ngayDn = lstCT.getNgayNhan();
                LocalDate ngayDi = lstCT.getNgayTraThucTe();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                lblNgayThue.setText(ngayDn.format(formatter));
                lblNgayTra.setText(ngayDi.format(formatter));
            }

            List<ChiTietHoaDon> lstChitietHD = chiTietHoaDonDAO.getByMaHoaDon(maHoaDOn);
            String maPhongDT = "";
            int soNgay = 0;
            for (ChiTietHoaDon lstChiTiet : lstChitietHD) {
                maPhongDT += ", " + lstChiTiet.getMaPhong();

                lblPhuThu.setText(funcBase.formatTien(lstChiTiet.getPhuThu()));

                lblTienKhuyenMai.setText(funcBase.formatTien(lstChiTiet.getGiamGiaKH()));
                lblSoNgayO.setText(Integer.toString(lstChiTiet.getSoNgay()));
                soNgay = lstChiTiet.getSoNgay();
                lblHinhThucThanhToan.setText(lstChiTiet.getHinhThucThanhToan());
            }

            lblPhongThue.setText(maPhongDT.replaceFirst(",", ""));
            float tienPhong = 0;
            for (String lstP : lstMaPhong) {
                List<Phong> lstPhong = phongDAO.getByMaPhong(lstP);
                for (Phong p : lstPhong) {
                    List<LoaiPhong> lstLoaiPhong = loaiPhongDAO.getByMa(p.getMaLoaiPhong());
                    for (LoaiPhong lp : lstLoaiPhong) {
                        tienPhong += lp.getDonGia();
                    }
                }
            }
            lblTienPhong.setText(funcBase.formatTien(tienPhong * soNgay));

            List<KhachHang> lstKH = khachHangDAO.getByMa(hd.getMaKhachHang());
            for (KhachHang kh : lstKH) {
                lblTenKH.setText(kh.getTenKhachHang());
                String gioiTInh = "Nữ";
                if (kh.isGioiTinh() == true) {
                    gioiTInh = "Nam";
                }
                lblGioiTinh.setText(gioiTInh);
                lblDienThoai.setText(kh.getDienThoai());
                lblQuocTich.setText(kh.getQuocTich());
                lblDiaChi.setText(kh.getDiaChi());
            }
        }
    }

    public void initDVDSD() {
        lstDanhSachSuDungDichVu = dsSDDichVuDAO.getAll(maNhanPhong);
        Object[] columnNames = {"STT", "Loại dịch vụ", "Đơn vị", "Số lượng", "Đơn giá", "Thành tiền"};
        dtmDanhSachSuDungDichVu = new DefaultTableModel(new Object[0][0], columnNames);

        int index = 1;
        for (DanhSachSuDungDichVu adv : lstDanhSachSuDungDichVu) {
            if (!adv.getMaDichVu().equals("DV00")) {
                Object[] o = new Object[6];
                o[0] = index;
                o[1] = adv.getTenLoaiDichVu();
                o[2] = adv.getTenDonvi();
                o[3] = adv.getSoLuong();
                o[4] = (int) adv.getDonGia();
                o[5] = adv.getSoLuong() * (int) adv.getDonGia();
                dtmDanhSachSuDungDichVu.addRow(o);
                index++;
            }
        }
        tblDichVuDaSD.setModel(dtmDanhSachSuDungDichVu);
        TableColumnModel column = (TableColumnModel) tblDichVuDaSD.getColumnModel();
        column.getColumn(0).setPreferredWidth(10);
        column.getColumn(1).setPreferredWidth(175);

        if (lstDanhSachSuDungDichVu.size() > 1) {
            lblTienDichVu.setText(funcBase.formatTien(SumTienDV()));
        } else {
            lblTienDichVu.setText(funcBase.formatTien(0));
        }
    }

    public int SumTienDV() {
        int rowcount = tblDichVuDaSD.getRowCount();
        int sum = 0;
        for (int i = 0; i < rowcount; i++) {
            sum += Integer.parseInt(tblDichVuDaSD.getValueAt(i, 5).toString());
        }
        return sum;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu1 = new java.awt.PopupMenu();
        jSpinner1 = new javax.swing.JSpinner();
        jpnHoaDon = new javax.swing.JPanel();
        jlbHoaDonTitle = new javax.swing.JLabel();
        jpnC = new javax.swing.JPanel();
        jlbCustommerN2 = new javax.swing.JLabel();
        jlbCustommerN1 = new javax.swing.JLabel();
        jlbCustommerN = new javax.swing.JLabel();
        lblTenKH = new javax.swing.JLabel();
        jlbCustomerGenderLb = new javax.swing.JLabel();
        lblGioiTinh = new javax.swing.JLabel();
        lblQuocTich = new javax.swing.JLabel();
        jlbCustomerGenderLb1 = new javax.swing.JLabel();
        lblDienThoai = new javax.swing.JLabel();
        lblDiaChi = new javax.swing.JLabel();
        jlbCustommerN4 = new javax.swing.JLabel();
        lblPhongThue = new javax.swing.JLabel();
        jlbCustommerN5 = new javax.swing.JLabel();
        lblNgayThue = new javax.swing.JLabel();
        jlbCustommerN6 = new javax.swing.JLabel();
        lblNgayTra = new javax.swing.JLabel();
        jlbCustommerN7 = new javax.swing.JLabel();
        lblSoNgayO = new javax.swing.JLabel();
        jlbCustommerN3 = new javax.swing.JLabel();
        lblMaHoaDon = new javax.swing.JLabel();
        jlbCustommerN9 = new javax.swing.JLabel();
        lblNhanVienLap = new javax.swing.JLabel();
        jpnC1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDichVuDaSD = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblTienPhong = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblTienDichVu = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblTienKhuyenMai = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lblPhuThu = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblHinhThucThanhToan = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblSo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnXuatFile = new javax.swing.JButton();

        popupMenu1.setLabel("popupMenu1");

        setClosable(true);
        setIconifiable(true);

        jpnHoaDon.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N

        jlbHoaDonTitle.setFont(new java.awt.Font("DejaVu Serif", 1, 28)); // NOI18N
        jlbHoaDonTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbHoaDonTitle.setText("Hóa Đơn");

        jpnC.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Sans", 1, 12))); // NOI18N

        jlbCustommerN2.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jlbCustommerN2.setText("Số điện thoại:");

        jlbCustommerN1.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jlbCustommerN1.setText("Địa chỉ:");

        jlbCustommerN.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jlbCustommerN.setText("Mã hóa đơn:");

        lblTenKH.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        lblTenKH.setText("Trần Văn Vững");

        jlbCustomerGenderLb.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jlbCustomerGenderLb.setText("Giới tính:");

        lblGioiTinh.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        lblGioiTinh.setText("Nam");

        lblQuocTich.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        lblQuocTich.setText("Việt Nam");

        jlbCustomerGenderLb1.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jlbCustomerGenderLb1.setText("Quốc tịch:");

        lblDienThoai.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        lblDienThoai.setText("012345678");

        lblDiaChi.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        lblDiaChi.setText("abc");

        jlbCustommerN4.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jlbCustommerN4.setText("Phòng thuê:");

        lblPhongThue.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        lblPhongThue.setText("abc");

        jlbCustommerN5.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jlbCustommerN5.setText("Ngày thuê:");

        lblNgayThue.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        lblNgayThue.setText("abc");

        jlbCustommerN6.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jlbCustommerN6.setText("Ngày trả:");

        lblNgayTra.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        lblNgayTra.setText("abc");

        jlbCustommerN7.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jlbCustommerN7.setText("Số ngày ở:");

        lblSoNgayO.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        lblSoNgayO.setText("abc");

        jlbCustommerN3.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jlbCustommerN3.setText("Họ tên khách hàng: ");

        lblMaHoaDon.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        lblMaHoaDon.setText("123#");

        jlbCustommerN9.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jlbCustommerN9.setText("Nhân viên lập:");

        lblNhanVienLap.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        lblNhanVienLap.setText("123#");

        javax.swing.GroupLayout jpnCLayout = new javax.swing.GroupLayout(jpnC);
        jpnC.setLayout(jpnCLayout);
        jpnCLayout.setHorizontalGroup(
            jpnCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jpnCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnCLayout.createSequentialGroup()
                        .addComponent(jlbCustommerN)
                        .addGap(18, 18, 18)
                        .addComponent(lblMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jlbCustommerN9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNhanVienLap, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(191, 191, 191))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnCLayout.createSequentialGroup()
                        .addGroup(jpnCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnCLayout.createSequentialGroup()
                                .addComponent(jlbCustommerN1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jpnCLayout.createSequentialGroup()
                                    .addGroup(jpnCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jpnCLayout.createSequentialGroup()
                                            .addComponent(jlbCustommerN4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(lblPhongThue, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jpnCLayout.createSequentialGroup()
                                            .addComponent(jlbCustommerN7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(lblSoNgayO, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(54, 54, 54)
                                    .addGroup(jpnCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jlbCustommerN5)
                                        .addComponent(jlbCustommerN6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(30, 30, 30)
                                    .addGroup(jpnCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jpnCLayout.createSequentialGroup()
                                            .addComponent(lblNgayTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGap(46, 46, 46))
                                        .addComponent(lblNgayThue, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jpnCLayout.createSequentialGroup()
                                    .addGroup(jpnCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jpnCLayout.createSequentialGroup()
                                            .addComponent(jlbCustommerN2)
                                            .addGap(18, 18, 18)
                                            .addComponent(lblDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jpnCLayout.createSequentialGroup()
                                            .addComponent(jlbCustommerN3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(73, 73, 73)
                                    .addGroup(jpnCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jlbCustomerGenderLb, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jlbCustomerGenderLb1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jpnCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblQuocTich, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jpnCLayout.setVerticalGroup(
            jpnCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jpnCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbCustommerN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMaHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbCustommerN9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNhanVienLap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jpnCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbCustommerN3)
                    .addComponent(lblTenKH)
                    .addComponent(jlbCustomerGenderLb, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGioiTinh))
                .addGap(8, 8, 8)
                .addGroup(jpnCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbCustommerN2)
                    .addComponent(lblDienThoai)
                    .addComponent(jlbCustomerGenderLb1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQuocTich, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpnCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbCustommerN1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDiaChi))
                .addGap(9, 9, 9)
                .addGroup(jpnCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpnCLayout.createSequentialGroup()
                        .addGroup(jpnCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbCustommerN4)
                            .addComponent(lblPhongThue))
                        .addGap(10, 10, 10)
                        .addGroup(jpnCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbCustommerN7)
                            .addComponent(lblSoNgayO)))
                    .addGroup(jpnCLayout.createSequentialGroup()
                        .addGroup(jpnCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbCustommerN5)
                            .addComponent(lblNgayThue, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(jpnCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnCLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jlbCustommerN6))
                            .addGroup(jpnCLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblNgayTra)))))
                .addGap(12, 12, 12))
        );

        jpnC1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách dịch vụ đã sử dụng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Sans", 1, 12))); // NOI18N

        tblDichVuDaSD.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
        jScrollPane1.setViewportView(tblDichVuDaSD);

        javax.swing.GroupLayout jpnC1Layout = new javax.swing.GroupLayout(jpnC1);
        jpnC1.setLayout(jpnC1Layout);
        jpnC1Layout.setHorizontalGroup(
            jpnC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnC1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jpnC1Layout.setVerticalGroup(
            jpnC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnC1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Tiền phòng:");

        lblTienPhong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTienPhong.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTienPhong.setText("....");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Tiền dịch vụ:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Tiền khuyến mại:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Phụ thu:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Tổng tiền:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("VND");

        lblTienDichVu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTienDichVu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTienDichVu.setText("...");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("VND");

        lblTienKhuyenMai.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTienKhuyenMai.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTienKhuyenMai.setText("...");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("VND");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("%");

        lblTongTien.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTongTien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTongTien.setText("...");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("VND");

        lblPhuThu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPhuThu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPhuThu.setText("...");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Hình thức thanh toán:");

        lblHinhThucThanhToan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblHinhThucThanhToan.setText("Tiền mặt");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(lblHinhThucThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblTienKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lblTienPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel11))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lblTienDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel13))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblPhuThu, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(52, 52, 52)
                                .addComponent(lblTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel19)))))
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblTienPhong)
                    .addComponent(jLabel11)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHinhThucThanhToan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblTienDichVu)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblTienKhuyenMai)
                    .addComponent(jLabel15))
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhuThu)
                    .addComponent(jLabel16)
                    .addComponent(jLabel9))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblTongTien)
                    .addComponent(jLabel19))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Khách sạn: ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Số:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Bôn Ba");

        lblSo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSo.setText("1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSo)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(lblSo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpnHoaDonLayout = new javax.swing.GroupLayout(jpnHoaDon);
        jpnHoaDon.setLayout(jpnHoaDonLayout);
        jpnHoaDonLayout.setHorizontalGroup(
            jpnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnC, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jpnC1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpnHoaDonLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 15, Short.MAX_VALUE))
                    .addComponent(jlbHoaDonTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );
        jpnHoaDonLayout.setVerticalGroup(
            jpnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHoaDonLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbHoaDonTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnC1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnXuatFile.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnXuatFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_printer.png"))); // NOI18N
        btnXuatFile.setText("Xuất file");
        btnXuatFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXuatFile, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnXuatFile, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jpnHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXuatFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatFileActionPerformed
        MethodMain.printComponenet(jpnHoaDon);
    }//GEN-LAST:event_btnXuatFileActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnXuatFile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel jlbCustomerGenderLb;
    private javax.swing.JLabel jlbCustomerGenderLb1;
    private javax.swing.JLabel jlbCustommerN;
    private javax.swing.JLabel jlbCustommerN1;
    private javax.swing.JLabel jlbCustommerN2;
    private javax.swing.JLabel jlbCustommerN3;
    private javax.swing.JLabel jlbCustommerN4;
    private javax.swing.JLabel jlbCustommerN5;
    private javax.swing.JLabel jlbCustommerN6;
    private javax.swing.JLabel jlbCustommerN7;
    private javax.swing.JLabel jlbCustommerN9;
    private javax.swing.JLabel jlbHoaDonTitle;
    private javax.swing.JPanel jpnC;
    private javax.swing.JPanel jpnC1;
    private javax.swing.JPanel jpnHoaDon;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblDienThoai;
    private javax.swing.JLabel lblGioiTinh;
    private javax.swing.JLabel lblHinhThucThanhToan;
    private javax.swing.JLabel lblMaHoaDon;
    private javax.swing.JLabel lblNgayThue;
    private javax.swing.JLabel lblNgayTra;
    private javax.swing.JLabel lblNhanVienLap;
    private javax.swing.JLabel lblPhongThue;
    private javax.swing.JLabel lblPhuThu;
    private javax.swing.JLabel lblQuocTich;
    private javax.swing.JLabel lblSo;
    private javax.swing.JLabel lblSoNgayO;
    private javax.swing.JLabel lblTenKH;
    private javax.swing.JLabel lblTienDichVu;
    private javax.swing.JLabel lblTienKhuyenMai;
    private javax.swing.JLabel lblTienPhong;
    private javax.swing.JLabel lblTongTien;
    private java.awt.PopupMenu popupMenu1;
    private javax.swing.JTable tblDichVuDaSD;
    // End of variables declaration//GEN-END:variables
}
