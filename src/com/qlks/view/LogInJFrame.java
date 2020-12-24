/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.view;

import com.qlks.dao.impl.NguoiDungDAO;
import com.qlks.models.NguoiDung;
import com.qlks.utils.MethodMain;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author hoangdung
 */
public class LogInJFrame extends javax.swing.JFrame {

    /**
     * Creates new form LogInJFrame
     */
    public LogInJFrame() {
        initComponents();
        String loginTitle = "Đăng nhập";
        setTitle(loginTitle);
        jplPass.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {

            }

            @Override
            public void mousePressed(MouseEvent me) {
                jpassPass.setEchoChar((char) 0);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                jpassPass.setEchoChar('•');
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                jplPass.setBackground(Color.pink);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                jplPass.setBackground(Color.white);

            }
        });

    }

    public JButton getBtnLogin() {
        return btnLogin;
    }

    public void setBtnLogIn(JButton jb) {
        this.btnLogin = jb;
    }

    public List<NguoiDung> getLogin() {
        boolean check = true;
        String messagerNull = " không được bỏ trống\n";
        String messagerWorng = "Tên đăng nhập hoặc mật khẩu sai";

        String userNameTxt = "Tên đăng nhập";
        String passWordTxt = "Mật Khẩu";

        String userName = jtextName.getText();

        char[] passWordChar = jpassPass.getPassword();
        String passWord = new String(passWordChar);

        System.out.println(passWord);
        NguoiDungDAO nddao = new NguoiDungDAO();
        String ms = "";
        jpnMessager.removeAll();
        if (userName.isEmpty()) {
            jpnMessager.add(makeLoginMs(userNameTxt + messagerNull));
            check = false;
        }
        if (passWord.isEmpty()) {
            jpnMessager.add(makeLoginMs(passWordTxt + messagerNull));
            check = false;
        }

        jpnMessager.revalidate();
        jpnMessager.repaint();
        if (check == true) {
            List<NguoiDung> listNguoiDung = nddao.checkDangNhap(userName, passWord);
            if (listNguoiDung.size() > 0) {
                return listNguoiDung;
            } else {
                jpnMessager.removeAll();
                jpnMessager.add(makeLoginMs(messagerWorng));
                jpnMessager.revalidate();
                jpnMessager.repaint();
                return null;
            }
        }
        return null;
    }

    private JLabel makeLoginMs(String ms) {
        JLabel lb = new JLabel();
        lb.setPreferredSize(new Dimension(300, 30));
        lb.setSize(lb.getPreferredSize());
        lb.setMaximumSize(lb.getPreferredSize());

        lb.setText(ms);
        lb.setForeground(Color.WHITE);
        return lb;
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
        jlbLogInIcon = new javax.swing.JLabel();
        jlbName = new javax.swing.JLabel();
        jtextName = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        jlbName1 = new javax.swing.JLabel();
        jplPass = new javax.swing.JPanel();
        jlbpass = new javax.swing.JLabel();
        jpassPass = new javax.swing.JPasswordField();
        btnReset = new javax.swing.JButton();
        jpnMessager = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(54, 54, 54));

        jlbLogInIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbLogInIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_login.png"))); // NOI18N

        jlbName.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jlbName.setForeground(new java.awt.Color(255, 255, 255));
        jlbName.setText("Tên/Email");

        jtextName.setBackground(new java.awt.Color(255, 255, 255));
        jtextName.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jtextName.setForeground(new java.awt.Color(0, 0, 0));
        jtextName.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 15));
        jtextName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jtextName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtextNameActionPerformed(evt);
            }
        });

        btnLogin.setBackground(new java.awt.Color(255, 255, 255));
        btnLogin.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        btnLogin.setText("Đăng nhập");
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jlbName1.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jlbName1.setForeground(new java.awt.Color(255, 255, 255));
        jlbName1.setText("Mật khẩu");

        jplPass.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jplPassPropertyChange(evt);
            }
        });

        jlbpass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbpass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_passwordeye.png"))); // NOI18N
        jlbpass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jplPassLayout = new javax.swing.GroupLayout(jplPass);
        jplPass.setLayout(jplPassLayout);
        jplPassLayout.setHorizontalGroup(
            jplPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbpass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jplPassLayout.setVerticalGroup(
            jplPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jplPassLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlbpass, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jpassPass.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jpassPass.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 15, 0, 15));
        jpassPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpassPassActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(255, 255, 255));
        btnReset.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        btnReset.setText("Nhập lại");
        btnReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jpnMessager.setBackground(new java.awt.Color(54, 54, 54));
        jpnMessager.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jpnMessager.setForeground(new java.awt.Color(255, 255, 255));
        jpnMessager.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jpnMessager.setLayout(new javax.swing.BoxLayout(jpnMessager, javax.swing.BoxLayout.Y_AXIS));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbLogInIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jlbName, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtextName, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jlbName1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpassPass, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jplPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jpnMessager, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jlbLogInIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtextName, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jlbName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jplPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpassPass)
                    .addComponent(jlbName1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jpnMessager, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtextNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtextNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtextNameActionPerformed

    private void jpassPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpassPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpassPassActionPerformed

    private void jplPassPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jplPassPropertyChange

    }//GEN-LAST:event_jplPassPropertyChange

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnResetActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnReset;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlbLogInIcon;
    private javax.swing.JLabel jlbName;
    private javax.swing.JLabel jlbName1;
    private javax.swing.JLabel jlbpass;
    private javax.swing.JPasswordField jpassPass;
    private javax.swing.JPanel jplPass;
    private javax.swing.JPanel jpnMessager;
    private javax.swing.JTextField jtextName;
    // End of variables declaration//GEN-END:variables
}
