/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.view;

import com.qlks.fonts.FontCustom;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author hoangdung
 */
public class MainJFrame extends javax.swing.JFrame {
    
   private final Font subMenuItemFont = new FontCustom().MontserratSemiBold(16);
    /**
     * Creates new form MainJFrame
     */
    public MainJFrame() {
        initComponents();
        List<JPanel> listSubMenuItemAdmin = new ArrayList<>();
        List<JPanel> listSubMenuItemRoom = new ArrayList<>();
        
        JPanel subMenuItemAdmin = new JPanel();
        JLabel subMenuItemAdminLabel = new JLabel();
        
        JPanel subMenuItemRule = new JPanel();
        JLabel subMenuItemRuleLabel = new JLabel();
        
        listSubMenuItemAdmin.add(makeSubMenuItem(subMenuItemAdmin, subMenuItemAdminLabel, "Quan ly nguoi dung"));
        listSubMenuItemAdmin.add(makeSubMenuItem(subMenuItemRule, subMenuItemRuleLabel, "Quan ly Quyen"));
        
        JPanel subMenuItemRoom = new JPanel();
        JLabel subMenuItemRoomLabel = new JLabel();

        listSubMenuItemRoom.add(makeSubMenuItem(subMenuItemRoom, subMenuItemRoomLabel, "Quan ly phong"));
        
        jpnSubMenu.setVisible(false);
        jpnSubMenuClose.setBackground(new Color(0, 0, 0, 0));
        jpnSubMenuClose.setVisible(false);
        visibleSubMenu(menuAdmin, "Người Dùng",listSubMenuItemAdmin);
        visibleSubMenu(jLabel3, "Phòng",listSubMenuItemRoom);

        setMenuBackGroundColor(36, 36, 36);
        FontCustom font = new FontCustom();
        jlbMenuTitle.setFont(font.MontserratSemiBold(24));
        jlbMenuTitle.setText(jlbMenuTitle.getText().toUpperCase());

    }
    
    
    

    private void setMenuBackGroundColor(int red, int green, int blue) {
        Color cl = new Color(red, green, blue);
        jpnMainLeft.setBackground(cl);
        jpnLogo.setBackground(cl);
        jpnMenu.setBackground(cl);
    }

    private void visibleSubMenu(JLabel jl, String title,List<JPanel> items) {
        jl.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                jlbMenuTitle.setText(title);
                jpnSubMenuContent.removeAll();
                jpnSubMenuContent.revalidate();
                jpnSubMenuContent.repaint();
                
                for (JPanel item : items) {
                    jpnSubMenuContent.add(item);
                }
                
                jpnSubMenuContent.revalidate();
                jpnSubMenuContent.repaint();
                
                jpnSubMenu.setVisible(true);
                jpnSubMenuClose.setVisible(true);
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

    private JPanel makeSubMenuItem(JPanel jp, JLabel jl, String label) {

        jl.setText(label);
        jl.setForeground(Color.white);
        jl.setFont(subMenuItemFont);

     
        

        
        jp.setPreferredSize(new Dimension(jpnSubMenu.getWidth(), 50));
        jp.setMaximumSize(jp.getPreferredSize());
        jp.setBackground(new Color(50, 55, 52));
        jp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        

        jl.setPreferredSize(jp.getPreferredSize());
        
        
        jp.add(jl);
        hover(jp,jl);
        return jp;
    }



    private void hover(JPanel jp,JLabel jl) {
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
        jLabel3 = new javax.swing.JLabel();
        jpnSubMenu = new javax.swing.JPanel();
        jlbMenuTitle = new javax.swing.JLabel();
        jpnSubMenuContent = new javax.swing.JPanel();
        jpnSubMenuClose = new javax.swing.JPanel();

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
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnLogoLayout.setVerticalGroup(
            jpnLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
        );

        jpnMenu.setLayout(new javax.swing.BoxLayout(jpnMenu, javax.swing.BoxLayout.Y_AXIS));

        menuAdmin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/admin.png"))); // NOI18N
        menuAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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
                    .addGroup(jpnMainLeftLayout.createSequentialGroup()
                        .addGroup(jpnMainLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(menuAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addComponent(jpnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jpnMainLeftLayout.setVerticalGroup(
            jpnMainLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMainLeftLayout.createSequentialGroup()
                .addComponent(jpnLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jpnMainLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                    .addGroup(jpnMainLeftLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(menuAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jpnSubMenu.setBackground(new java.awt.Color(50, 55, 52));

        jlbMenuTitle.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jlbMenuTitle.setForeground(new java.awt.Color(255, 255, 255));
        jlbMenuTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbMenuTitle.setText("Người Dùng");

        jpnSubMenuContent.setBackground(new java.awt.Color(50, 55, 52));
        jpnSubMenuContent.setLayout(new javax.swing.BoxLayout(jpnSubMenuContent, javax.swing.BoxLayout.Y_AXIS));

        javax.swing.GroupLayout jpnSubMenuLayout = new javax.swing.GroupLayout(jpnSubMenu);
        jpnSubMenu.setLayout(jpnSubMenuLayout);
        jpnSubMenuLayout.setHorizontalGroup(
            jpnSubMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnSubMenuContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jlbMenuTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
        );
        jpnSubMenuLayout.setVerticalGroup(
            jpnSubMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnSubMenuLayout.createSequentialGroup()
                .addComponent(jlbMenuTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jpnSubMenuContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpnSubMenuClose.setBackground(new java.awt.Color(87, 106, 124));
        jpnSubMenuClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnSubMenuCloseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpnSubMenuCloseLayout = new javax.swing.GroupLayout(jpnSubMenuClose);
        jpnSubMenuClose.setLayout(jpnSubMenuCloseLayout);
        jpnSubMenuCloseLayout.setHorizontalGroup(
            jpnSubMenuCloseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1028, Short.MAX_VALUE)
        );
        jpnSubMenuCloseLayout.setVerticalGroup(
            jpnSubMenuCloseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnMainLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpnSubMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpnSubMenuClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnSubMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnMainLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jpnSubMenuClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    private void jpnSubMenuCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnSubMenuCloseMouseClicked
        jpnSubMenu.setVisible(false);
        jpnSubMenuClose.setVisible(false);
    }//GEN-LAST:event_jpnSubMenuCloseMouseClicked

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
    private javax.swing.JLabel jlbMenuTitle;
    private javax.swing.JPanel jpnLogo;
    private javax.swing.JPanel jpnMainLeft;
    private javax.swing.JPanel jpnMenu;
    private javax.swing.JPanel jpnSubMenu;
    private javax.swing.JPanel jpnSubMenuClose;
    private javax.swing.JPanel jpnSubMenuContent;
    private javax.swing.JLabel menuAdmin;
    // End of variables declaration//GEN-END:variables
}
