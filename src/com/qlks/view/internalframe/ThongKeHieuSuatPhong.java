/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.view.internalframe;

import com.qlks.custom.FunctionBase;
import com.qlks.dao.impl.ThongKeHieuSuatPhongDAO;
import com.qlks.dao.impl.ThongKePhongDAO;
import com.qlks.models.ThongKePhong;
import com.qlks.utils.MethodMain;
import java.awt.Dimension;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hello
 */
public class ThongKeHieuSuatPhong extends javax.swing.JInternalFrame {

    private ThongKeHieuSuatPhongDAO thongKeHieuSuatPhongDAO;
    private List<ThongKePhong> lstThongKeHieuSuatPhong;
    private DefaultTableModel dtmThongKeHieuSuatPhong;
    private FunctionBase funcBase;
    ResourceBundle rb;
    private Locale lc;
    private BieuDoHieuSuatPhong bieuDoHieuSuatPhong;
    private JDesktopPane jdek;
    LocalDate ngayBatDau;
    LocalDate ngayKetThuc;
    DateTimeFormatter dateTimeFormatter;

    public ThongKeHieuSuatPhong(Locale lc) {
        initComponents();
        this.lc = lc;
        this.rb = ResourceBundle.getBundle("com.qlks.i18n.resources.resources", this.lc);
        dtmThongKeHieuSuatPhong = new DefaultTableModel();
        thongKeHieuSuatPhongDAO = new ThongKeHieuSuatPhongDAO();
        funcBase = new FunctionBase();
        loadData(null, null);
    }

    public void loadData(LocalDate ngayInput1, LocalDate ngayInput2) {
        LocalDate date1 = LocalDate.parse("2000-01-15");
        LocalDate date2 = LocalDate.parse("2100-01-15");
        if (ngayInput1 != null && ngayInput2 != null) {
            lstThongKeHieuSuatPhong = thongKeHieuSuatPhongDAO.getAll(ngayInput1, ngayInput2);
        } else if (ngayInput1 == null && ngayInput2 != null) {
            lstThongKeHieuSuatPhong = thongKeHieuSuatPhongDAO.getAll(date1, ngayInput2);
        } else if (ngayInput1 != null && ngayInput2 == null) {
            lstThongKeHieuSuatPhong = thongKeHieuSuatPhongDAO.getAll(ngayInput1, date2);
        } else {
            lstThongKeHieuSuatPhong = thongKeHieuSuatPhongDAO.getAll(date1, date2);
        }

        ngayBatDau = ngayInput1 != null ? ngayInput1 : null;
        ngayKetThuc = ngayInput2 != null ? ngayInput2 : null;

        Object[] columnNames = {"STT", "Mã phòng", "Hiệu suất thuê(%)", "Số ngày thuê", "Số lần thuê", "Tiền phòng", "Tiền dịch vụ", "Tiền giảm giá", "Tổng tiền"};
        dtmThongKeHieuSuatPhong = new DefaultTableModel(new Object[0][0], columnNames);
        int index = 1;
        for (ThongKePhong adv : lstThongKeHieuSuatPhong) {
            Object[] o = new Object[9];
            o[0] = index;
            o[1] = adv.getMaPhong();
            o[2] = adv.getHieuSuatPhong();
            o[3] = adv.getSoNgay();
            o[4] = adv.getSoLanThue();
            o[5] = (int) adv.getTienPhong();
            o[6] = (int) adv.getTienDichVu();
            o[7] = (int) adv.getGiamGia();
            o[8] = (int) adv.getTongTien();
            dtmThongKeHieuSuatPhong.addRow(o);
            index++;
        }
        tblThongKeHieuSuatPhong.setModel(dtmThongKeHieuSuatPhong);
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

        jPanel1 = new javax.swing.JPanel();
        btnTimKiem = new javax.swing.JButton();
        btnGhiFile = new javax.swing.JButton();
        jDate1 = new com.toedter.calendar.JDateChooser();
        jDate2 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnShowChart = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThongKeHieuSuatPhong = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Thống kê hiệu suất phòng");

        btnTimKiem.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 14)); // NOI18N
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_search.png"))); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        btnGhiFile.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 14)); // NOI18N
        btnGhiFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_printer.png"))); // NOI18N
        btnGhiFile.setText("Ghi file excel");
        btnGhiFile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGhiFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGhiFileActionPerformed(evt);
            }
        });

        jDate1.setDateFormatString("dd/MM/yyyy");

        jDate2.setDateFormatString("dd/MM/yyyy");

        jLabel1.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 18)); // NOI18N
        jLabel1.setText("Từ ngày:");

        jLabel2.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 18)); // NOI18N
        jLabel2.setText("Đến ngày:");

        btnShowChart.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 14)); // NOI18N
        btnShowChart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_chart.png"))); // NOI18N
        btnShowChart.setText("Biểu đồ");
        btnShowChart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnShowChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowChartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDate2, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnShowChart, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGhiFile, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnGhiFile, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnShowChart, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDate2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66))
        );

        tblThongKeHieuSuatPhong.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblThongKeHieuSuatPhong);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE))
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

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        LocalDate date1 = null;
        if (jDate1.getDate() != null) {
            date1 = jDate1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }
        LocalDate date2 = null;
        if (jDate2.getDate() != null) {
            date2 = jDate2.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }
        loadData(date1, date2);
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnGhiFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhiFileActionPerformed
        MethodMain.exportExcel(tblThongKeHieuSuatPhong);
    }//GEN-LAST:event_btnGhiFileActionPerformed

    private void btnShowChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowChartActionPerformed
        if (bieuDoHieuSuatPhong == null) {
            bieuDoHieuSuatPhong = new BieuDoHieuSuatPhong(ngayBatDau, ngayKetThuc, rb, lstThongKeHieuSuatPhong);

        } else {
            bieuDoHieuSuatPhong.dispose();
            bieuDoHieuSuatPhong = new BieuDoHieuSuatPhong(ngayBatDau, ngayKetThuc, rb, lstThongKeHieuSuatPhong);
        }
        showInternalFrame(bieuDoHieuSuatPhong);
    }//GEN-LAST:event_btnShowChartActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGhiFile;
    private javax.swing.JButton btnShowChart;
    private javax.swing.JButton btnTimKiem;
    private com.toedter.calendar.JDateChooser jDate1;
    private com.toedter.calendar.JDateChooser jDate2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblThongKeHieuSuatPhong;
    // End of variables declaration//GEN-END:variables

}
