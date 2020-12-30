/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.view.internalframe;

import java.awt.event.ActionEvent;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author hoangdung
 */
public class NgonNgu extends javax.swing.JInternalFrame {

    String id;
    NgonNguItem it;
    Locale lc;
    String cauHinhNgonNgu;
    ResourceBundle rb;

    public NgonNgu(Locale lc, String cauHinhNgonNgu) {
        this.lc = lc;
        this.cauHinhNgonNgu = cauHinhNgonNgu;
        initComponents();

        DefaultComboBoxModel model = new DefaultComboBoxModel<String>();
        setLocale(cauHinhNgonNgu, model);
        jcbLang.setModel(model);
        jcbLang.setRenderer(new NgonNguItemRenderer());

        jcbLang.addActionListener((ActionEvent e) -> {
            it = (NgonNguItem) jcbLang.getSelectedItem();
            this.id = it.getId();
            jlbLangFlag.setIcon(it.getIcon());

        });
    }

    public JComboBox<String> getJcbLang() {
        return jcbLang;
    }

    public void setJcbLang(JComboBox<String> jcbLang) {
        this.jcbLang = jcbLang;
    }

    public JLabel getJlbLangFlag() {
        return jlbLangFlag;
    }

    public void setJlbLangFlag(JLabel jlbLangFlag) {
        this.jlbLangFlag = jlbLangFlag;
    }

    public JPanel getJpnLangOk() {
        return jpnLangOk;
    }

    public void setJpnLangOk(JPanel jpnLangOk) {
        this.jpnLangOk = jpnLangOk;
    }

    public JLabel getJlbLangMsg() {
        return jlbLangMsg;
    }

    public void setJlbLangMsg(JLabel jlbLangMsg) {
        this.jlbLangMsg = jlbLangMsg;
    }

    private void setLocale(String cauHinhNgNg, DefaultComboBoxModel model) {
        switch (cauHinhNgNg) {
            case "anh":
                lc = Locale.ENGLISH;
                makeLocale(model, lc);
                break;
            case "phap":
                lc = Locale.FRANCE;
                makeLocale(model, lc);
                break;
            case "vietnam":
                lc = new Locale("vi", "VN");
                makeLocale(model, lc);
                break;
            default:
                lc = new Locale("vi", "VN");
                makeLocale(model, lc);
                break;

        }
    }

    private void makeLocale(DefaultComboBoxModel model, Locale lc) {

        rb = ResourceBundle.getBundle("com.qlks.i18n.resources.resources", lc);
        model.addElement(new NgonNguItem("phap", new ImageIcon("src/com/qlks/icon/icon_flag_fr.png"), rb.getString("JIFNgonNguPhap")));
        model.addElement(new NgonNguItem("anh", new ImageIcon("src/com/qlks/icon/icon_flag_uk.png"), rb.getString("JIFNgonNguVietNam")));
        model.addElement(new NgonNguItem("vietnam", new ImageIcon("src/com/qlks/icon/icon_flag_vn.png"), rb.getString("JIFNgonNguAnh")));

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
        jlbLangMsg = new javax.swing.JLabel();
        jcbLang = new javax.swing.JComboBox<>();
        jlbLangFlag = new javax.swing.JLabel();
        jpnLangOk = new javax.swing.JPanel();
        lblDongY = new javax.swing.JLabel();

        setClosable(true);

        jlbLangMsg.setFont(new java.awt.Font("DejaVu Serif Condensed", 0, 18)); // NOI18N
        jlbLangMsg.setForeground(new java.awt.Color(48, 155, 2));
        jlbLangMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jcbLang.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jcbLang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbLang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jcbLang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbLangActionPerformed(evt);
            }
        });

        jlbLangFlag.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbLangFlag.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_flag_vn.png"))); // NOI18N

        jpnLangOk.setBackground(new java.awt.Color(160, 223, 104));
        jpnLangOk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblDongY.setBackground(new java.awt.Color(116, 244, 144));
        lblDongY.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 18)); // NOI18N
        lblDongY.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDongY.setText("Dong y");

        javax.swing.GroupLayout jpnLangOkLayout = new javax.swing.GroupLayout(jpnLangOk);
        jpnLangOk.setLayout(jpnLangOkLayout);
        jpnLangOkLayout.setHorizontalGroup(
            jpnLangOkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDongY, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
        );
        jpnLangOkLayout.setVerticalGroup(
            jpnLangOkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnLangOkLayout.createSequentialGroup()
                .addComponent(lblDongY, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jlbLangFlag, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jcbLang, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpnLangOk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
            .addComponent(jlbLangMsg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jlbLangMsg)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlbLangFlag, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcbLang))
                .addGap(18, 18, 18)
                .addComponent(jpnLangOk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbLangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbLangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbLangActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> jcbLang;
    private javax.swing.JLabel jlbLangFlag;
    private javax.swing.JLabel jlbLangMsg;
    private javax.swing.JPanel jpnLangOk;
    private javax.swing.JLabel lblDongY;
    // End of variables declaration//GEN-END:variables
}
