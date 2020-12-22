/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.view;

import com.qlks.fonts.FontCustom;
import com.qlks.view.internalframe.DangNhap;
import com.qlks.view.internalframe.QuanLyQuyen;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author hoangdung
 */
public class MainJFrame extends javax.swing.JFrame {

    private final Font subMenuItemFont = new FontCustom().MontserratSemiBold(16);
    private JPanel jpnSubmenu = new JPanel();

    public Color MainColor = new Color(36, 36, 36);
    public Color subMenuColor = new Color(56, 56, 56);

    JLabel closeSubMenu = new JLabel();

    public JLabel subMenuItemTitle = new JLabel();

    /**
     * Creates new form MainJFrame
     */
    public MainJFrame() {
        initComponents();

        jpnSubmenu.setVisible(false);

        jpnSubmenu.setBackground(subMenuColor);
        jpnSubmenu.setLayout(new BoxLayout(jpnSubmenu, BoxLayout.Y_AXIS));

        jpnMainSubMenu.add(jpnSubmenu);

        List<JPanel> listSubMenuItemAdmin = new ArrayList<>();
        List<JPanel> listSubMenuItemRoom = new ArrayList<>();

        JPanel subMenuItemAdmin = new JPanel();

        JPanel subMenuItemRule = new JPanel();

        listSubMenuItemAdmin.add(makeSubMenuItem(subMenuItemAdmin, "Quan ly nguoi dung"));
        JInternalFrame dangnhap = new DangNhap();
        showInternalFrame(subMenuItemAdmin, dangnhap);

        listSubMenuItemAdmin.add(makeSubMenuItem(subMenuItemRule, "Quan ly Quyen"));
        showInternalFrame(subMenuItemRule, new QuanLyQuyen());
        JPanel subMenuItemRoom = new JPanel();

        listSubMenuItemRoom.add(makeSubMenuItem(subMenuItemRoom, "Quan ly phong"));

        visibleSubMenu(menuAdmin, "Người Dùng", listSubMenuItemAdmin);
        visibleSubMenu(jLabel3, "Phòng", listSubMenuItemRoom);

        invisibleSubMenu(closeSubMenu);
        setMenuBackGroundColor(36, 36, 36);

    }

    public void centerJIF(JInternalFrame jif) {
        Dimension desktopSize = jMain.getSize();
        Dimension jInternalFrameSize = jif.getSize();
        int width = (desktopSize.width - jInternalFrameSize.width) / 2;
        int height = (desktopSize.height - jInternalFrameSize.height) / 2;
        jif.setLocation(width, height);
        jif.setVisible(true);
    }

    private void setMenuBackGroundColor(int red, int green, int blue) {
        Color cl = new Color(red, green, blue);
        jpnMainLeft.setBackground(cl);
        jpnLogo.setBackground(cl);
        jpnMenu.setBackground(cl);
    }

    private void visibleSubMenu(JLabel jl, String title, List<JPanel> items) {

        jl.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                Dimension dmnsn = new Dimension(250, 1000);
                jpnSubmenu.setPreferredSize(dmnsn);
                jpnSubmenu.setSize(dmnsn);
                jpnSubmenu.setMaximumSize(dmnsn);
                jpnSubmenu.setVisible(true);
                jpnSubmenu.removeAll();

                jpnSubmenu.add(closeSubMenu);
                jpnSubmenu.add(makeSubMenuTitle(closeSubMenu, "X"));
                closeSubMenu.setPreferredSize(new Dimension(250 - 20, 40));

                closeSubMenu.setHorizontalAlignment(JLabel.RIGHT);
                closeSubMenu.setVerticalAlignment(JLabel.CENTER);

                closeSubMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

                jpnSubmenu.add(makeSubMenuTitle(subMenuItemTitle, title));

                items.forEach(item -> {
                    jpnSubmenu.add(item);
                });
                jpnSubmenu.revalidate();
                jpnSubmenu.repaint();

                System.out.println(jl.getLabelFor());

            }

            @Override
            public void mousePressed(MouseEvent me) {

            }

            @Override
            public void mouseReleased(MouseEvent me) {

            }

            @Override
            public void mouseEntered(MouseEvent me) {

            }

            @Override
            public void mouseExited(MouseEvent me) {

            }
        });
    }

    private void invisibleSubMenu(JLabel jl) {

        jl.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                jpnSubmenu.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent me) {

            }

            @Override
            public void mouseReleased(MouseEvent me) {

            }

            @Override
            public void mouseEntered(MouseEvent me) {
                jl.setForeground(Color.ORANGE);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                jl.setForeground(Color.WHITE);
            }
        });
    }

    private JPanel makeSubMenuItem(JPanel jp, String label) {
        JLabel jl = new JLabel();
        jl.setText(label);
        jl.setForeground(Color.white);
        jl.setFont(subMenuItemFont);

        jp.setPreferredSize(new Dimension(250, 50));
        jp.setMaximumSize(jp.getPreferredSize());
        jp.setBackground(new Color(50, 55, 52));
        jp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        jl.setPreferredSize(new Dimension(250 - 30, 50));

        jp.add(jl);
        hover(jp, jl);
        return jp;
    }

    private JPanel makeSubMenuTitle(JLabel jl, String label) {
        JPanel jp = new JPanel();
        jl.setText(label);
        jl.setForeground(Color.white);
        jl.setFont(new FontCustom().MontserratSemiBold(24));

        jp.setPreferredSize(new Dimension(250, 50));
        jp.setMaximumSize(jp.getPreferredSize());
        jp.setBackground(new Color(50, 55, 52));
        jl.setSize(jp.getPreferredSize());
        jl.setPreferredSize(jp.getPreferredSize());

        jl.setHorizontalAlignment(JLabel.CENTER);
        jl.setVerticalAlignment(JLabel.TOP);

        jp.add(jl);
        return jp;
    }

    private void showInternalFrame(JPanel jb, JInternalFrame jif) {

        jb.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {

                if (!jif.isVisible()) {
                    jMain.add(jif);
                    centerJIF(jif);
                    jif.setVisible(true);
                }

            }

            @Override
            public void mousePressed(MouseEvent me) {

            }

            @Override
            public void mouseReleased(MouseEvent me) {

            }

            @Override
            public void mouseEntered(MouseEvent me) {

            }

            @Override
            public void mouseExited(MouseEvent me) {

            }
        });
    }

    private void hover(JPanel jp, JLabel jl) {
        jp.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {

            }

            @Override
            public void mousePressed(MouseEvent me) {

            }

            @Override
            public void mouseReleased(MouseEvent me) {

            }

            @Override
            public void mouseEntered(MouseEvent me) {
                jl.setForeground(Color.blue);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                jl.setForeground(new Color(255, 255, 255));
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnMainLeft = new javax.swing.JPanel();
        jpnLogo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jpnMenu = new javax.swing.JPanel();
        menuAdmin = new javax.swing.JLabel();
        jpnMainSubMenu = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jMain = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/logo.png"))); // NOI18N

        javax.swing.GroupLayout jpnLogoLayout = new javax.swing.GroupLayout(jpnLogo);
        jpnLogo.setLayout(jpnLogoLayout);
        jpnLogoLayout.setHorizontalGroup(
            jpnLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
        );
        jpnLogoLayout.setVerticalGroup(
            jpnLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
        );

        jpnMenu.setLayout(new javax.swing.BoxLayout(jpnMenu, javax.swing.BoxLayout.Y_AXIS));

        menuAdmin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/admin.png"))); // NOI18N
        menuAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jpnMainSubMenu.setLayout(new javax.swing.BoxLayout(jpnMainSubMenu, javax.swing.BoxLayout.LINE_AXIS));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/admin.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jpnMainLeftLayout = new javax.swing.GroupLayout(jpnMainLeft);
        jpnMainLeft.setLayout(jpnMainLeftLayout);
        jpnMainLeftLayout.setHorizontalGroup(
            jpnMainLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnMainLeftLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jpnMainLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jpnMainSubMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 3, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jpnMainLeftLayout.setVerticalGroup(
            jpnMainLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMainLeftLayout.createSequentialGroup()
                .addComponent(jpnLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jpnMainLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpnMainLeftLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(menuAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 474, Short.MAX_VALUE))))
            .addComponent(jpnMainSubMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnMainLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jMain, javax.swing.GroupLayout.DEFAULT_SIZE, 1332, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnMainLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jMain)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JDesktopPane jMain;
    private javax.swing.JPanel jpnLogo;
    private javax.swing.JPanel jpnMainLeft;
    private javax.swing.JPanel jpnMainSubMenu;
    private javax.swing.JPanel jpnMenu;
    private javax.swing.JLabel menuAdmin;
    // End of variables declaration//GEN-END:variables
}
