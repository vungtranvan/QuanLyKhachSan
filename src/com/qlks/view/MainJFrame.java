/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.view;

import com.qlks.fonts.FontCustom;
import com.qlks.models.NguoiDung;
import com.qlks.models.PhanQuyen;
import com.qlks.utils.MethodMain;
import com.qlks.view.internalframe.DoiMatKhauNguoiDung;
import com.qlks.view.internalframe.NgonNgu;
import com.qlks.view.internalframe.QuanLyCauHinh;
import com.qlks.view.internalframe.QuanLyChinhSachTraPhong;
import com.qlks.view.internalframe.QuanLyDichVu;

import com.qlks.view.internalframe.QuanLyDonVi;
import com.qlks.view.internalframe.QuanLyKhachHang;
import com.qlks.view.internalframe.QuanLyLoaiDichVu;
import com.qlks.view.internalframe.QuanLyLoaiPhong;
import com.qlks.view.internalframe.QuanLyLoaiTinhTrang;
import com.qlks.view.internalframe.QuanLyMaKhuyenMai;
import com.qlks.view.internalframe.QuanLyNguoiDung;
import com.qlks.view.internalframe.QuanLyNhomQuyen;
import com.qlks.view.internalframe.QuanLyPhong;
import com.qlks.view.internalframe.QuanLyQuyDinh;
import com.qlks.view.internalframe.QuanLyQuyen;
import com.qlks.view.internalframe.QuanLyThietBi;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

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
    ImageIcon flagIcon = new ImageIcon("src/com/qlks/icon/icon_flag_vn.png");

    /**
     * Creates new form MainJFrame
     */
    public MainJFrame(List<NguoiDung> listNd) {

        initComponents();

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        jpnSubmenu.setVisible(false);

        jpnSubmenu.setBackground(subMenuColor);
        jpnSubmenu.setLayout(new BoxLayout(jpnSubmenu, BoxLayout.Y_AXIS));

        jpnMainSubMenu.add(jpnSubmenu);

//        showInternalFrame(menuChecking, new QuanLyDatPhong());
        List<JPanel> listSubMenuItemAdmin = new ArrayList<>();
        List<JPanel> listSubMenuItemRoom = new ArrayList<>();
        List<JPanel> listSubMenuItemCustomer = new ArrayList<>();
        List<JPanel> listSubMenuItemConfig = new ArrayList<>();

        JPanel subMenuItemAdmin = new JPanel();

        JPanel subMenuItemPermission = new JPanel();

        JPanel subMenuItemGroupPermission = new JPanel();

        JPanel subMenuItemRule = new JPanel();

        listSubMenuItemAdmin.add(makeSubMenuItem(subMenuItemAdmin, "Quan ly nguoi dung"));
        showInternalFrame(subMenuItemAdmin, new QuanLyNguoiDung());

        listSubMenuItemAdmin.add(makeSubMenuItem(subMenuItemPermission, "Quan ly Quyen"));
        showInternalFrame(subMenuItemPermission, new QuanLyQuyen());

        listSubMenuItemAdmin.add(makeSubMenuItem(subMenuItemGroupPermission, "Quan ly Nhom Quyen"));
        showInternalFrame(subMenuItemGroupPermission, new QuanLyNhomQuyen());

        listSubMenuItemAdmin.add(makeSubMenuItem(subMenuItemRule, "Quan ly Quy Dinh"));
        showInternalFrame(subMenuItemRule, new QuanLyQuyDinh());

        //phong
        JPanel subMenuItemRoom = new JPanel();
        listSubMenuItemRoom.add(makeSubMenuItem(subMenuItemRoom, "Quan ly loai phong"));
        showInternalFrame(subMenuItemRoom, new QuanLyLoaiPhong());

        JPanel subMenuStatus = new JPanel();
        listSubMenuItemRoom.add(makeSubMenuItem(subMenuStatus, "Quan ly tinh trang phong"));
        showInternalFrame(subMenuStatus, new QuanLyLoaiTinhTrang());

        JPanel subMenuRoom = new JPanel();
        listSubMenuItemRoom.add(makeSubMenuItem(subMenuRoom, "Quan ly phong"));
        showInternalFrame(subMenuRoom, new QuanLyPhong());

        JPanel subMenuEquipment = new JPanel();
        listSubMenuItemRoom.add(makeSubMenuItem(subMenuEquipment, "Quan ly Thiet Bi"));
        showInternalFrame(subMenuEquipment, new QuanLyThietBi());

        JPanel subMenuServiceType = new JPanel();
        listSubMenuItemRoom.add(makeSubMenuItem(subMenuServiceType, "Quan ly Loai Dich Vu"));
        showInternalFrame(subMenuServiceType, new QuanLyLoaiDichVu());

        JPanel subMenuService = new JPanel();
        listSubMenuItemRoom.add(makeSubMenuItem(subMenuService, "Quan ly Dich Vu"));
        showInternalFrame(subMenuService, new QuanLyDichVu());

        JPanel subMenuUnit = new JPanel();
        listSubMenuItemRoom.add(makeSubMenuItem(subMenuUnit, "Quan ly Loai Don Vi"));
        showInternalFrame(subMenuUnit, new QuanLyDonVi());

        JPanel subMenuCheckout = new JPanel();
        listSubMenuItemRoom.add(makeSubMenuItem(subMenuCheckout, "Quản lý Chính sách trả phòng"));
        showInternalFrame(subMenuCheckout, new QuanLyChinhSachTraPhong());

        //khac hang
        JPanel subMenuCustommer = new JPanel();
        listSubMenuItemCustomer.add(makeSubMenuItem(subMenuCustommer, "Quản lý khách hàng"));
        showInternalFrame(subMenuCustommer, new QuanLyKhachHang());

        JPanel subMenuDiscount = new JPanel();
        listSubMenuItemCustomer.add(makeSubMenuItem(subMenuDiscount, "Quản lý khuyến mại"));
        showInternalFrame(subMenuDiscount, new QuanLyMaKhuyenMai());

        JPanel subMenuLanguage = new JPanel();
        listSubMenuItemConfig.add(makeSubMenuItem(subMenuLanguage, "Ngon ngu"));
        showInternalFrame(subMenuLanguage, new NgonNgu());
        
        subMenuLanguage.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
//
//                Vector model = new Vector();
//                model.addElement(new Item(new ImageIcon("src/com/qlks/icon/icon_flag_fr.png"), "Phap"));
//                model.addElement(new Item(new ImageIcon("src/com/qlks/icon/icon_flag_uk.png"), "Anh"));
//                model.addElement(new Item(new ImageIcon("src/com/qlks/icon/icon_flag_vn.png"), "Viet Nam"));
//
//                
//  
//                jcbLang.addActionListener(new ActionListener() {
//                    public void actionPerformed(ActionEvent e) {
//                        try {
//                            Item it = (Item) jcbLang.getSelectedItem();
//                            Method mt = it.getClass().getDeclaredMethod("getIcon");
//                            flagIcon = (ImageIcon) (Icon) mt.invoke(it);
//                            jMain.revalidate();
//                            jMain.repaint();
//
//                        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
//                            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    }
//                });
//
////                ImageIcon flagIcon = new ImageIcon("src/com/qlks/icon/icon_flag_fr.png");
//                jcbLang.setRenderer(new ItemRenderer());
//                int input;
//                input = JOptionPane.showConfirmDialog(jMain, jcbLang, "Chon ngon ngu",
//                        JOptionPane.DEFAULT_OPTION,
//                        JOptionPane.DEFAULT_OPTION,
//                        flagIcon);
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

        // Cau hinh
        JPanel subMenuConfig = new JPanel();
        listSubMenuItemConfig.add(makeSubMenuItem(subMenuConfig, "Quản lý cấu hình"));
        showInternalFrame(subMenuConfig, new QuanLyCauHinh());

        visibleSubMenu(menuAdmin, "Người Dùng", listSubMenuItemAdmin);
        visibleSubMenu(menuRoom, "Phòng", listSubMenuItemRoom);
        visibleSubMenu(menuCustomer, "Khách hàng", listSubMenuItemCustomer);
        visibleSubMenu(menuConfig, "Cấu hình", listSubMenuItemConfig);

        invisibleSubMenu(closeSubMenu);
        invisibleSubMenu(jMain);
        setMenuBackGroundColor(36, 36, 36);

        showInternalFrame(menuAvatar, new DoiMatKhauNguoiDung(listNd));

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

    public JDesktopPane getjMain() {
        return jMain;
    }

    public void setjMain(JDesktopPane jMain) {
        this.jMain = jMain;
    }

    public JLabel getMenuAvatar() {
        return menuAvatar;
    }

    public void setMenuAvatar(JLabel menuAvatar) {
        this.menuAvatar = menuAvatar;
    }

    private void visibleSubMenu(JLabel jl, String title, List<JPanel> items) {

        jl.setToolTipText(title);
        jl.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                Dimension dmnsn = new Dimension(300, 1000);
                jpnSubmenu.setPreferredSize(dmnsn);
//                jpnSubmenu.setSize(dmnsn);
                jpnSubmenu.setMaximumSize(new Dimension(1000, 1000));
//                jpnSubmenu.setA

                jpnSubmenu.setVisible(true);
                jpnSubmenu.removeAll();

                jpnSubmenu.add(closeSubMenu);
                jpnSubmenu.add(makeSubMenuTitle(closeSubMenu, "X"));
                closeSubMenu.setPreferredSize(new Dimension(250 - 20, 40));

                closeSubMenu.setHorizontalAlignment(JLabel.RIGHT);
                closeSubMenu.setVerticalAlignment(JLabel.CENTER);

                closeSubMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

                jpnSubmenu.add(makeSubMenuTitle(subMenuItemTitle, title.toUpperCase()));

                items.forEach(item -> {
                    jpnSubmenu.add(item);
                });
                jpnSubmenu.revalidate();
                jpnSubmenu.repaint();

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
        jl.addMouseListener(invisibleSubMenu);
        hover(jl);
    }

    private void invisibleSubMenu(JDesktopPane jd) {
        jd.addMouseListener(invisibleSubMenu);
    }

    private MouseListener invisibleSubMenu = new MouseListener() {
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

        }

        @Override
        public void mouseExited(MouseEvent me) {

        }
    };

    private JPanel makeSubMenuItem(JPanel jp, String label) {
        JLabel jl = new JLabel();
        jl.setText(label);
        jl.setForeground(Color.white);
        jl.setFont(subMenuItemFont);

        jp.setPreferredSize(new Dimension(300, 50));
        jp.setMaximumSize(jp.getPreferredSize());
        jp.setBackground(subMenuColor);
        jp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        jl.setPreferredSize(new Dimension(300 - 30, 50));

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
        jp.setBackground(subMenuColor);
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

    private void showInternalFrame(JLabel jlMenu, JInternalFrame jif) {

        jlMenu.addMouseListener(new MouseListener() {
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

    private void hover(JLabel jl) {
        jl.addMouseListener(new MouseListener() {
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
        menuRoom = new javax.swing.JLabel();
        jpnMainSubMenu = new javax.swing.JPanel();
        menuCustomer = new javax.swing.JLabel();
        menuChecking = new javax.swing.JLabel();
        menuAvatar = new javax.swing.JLabel();
        menuConfig = new javax.swing.JLabel();
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
        menuAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_admin.png"))); // NOI18N
        menuAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menuRoom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_room.png"))); // NOI18N
        menuRoom.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jpnMainSubMenu.setLayout(new javax.swing.BoxLayout(jpnMainSubMenu, javax.swing.BoxLayout.LINE_AXIS));

        menuCustomer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_custommer.png"))); // NOI18N
        menuCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menuChecking.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuChecking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_checking.png"))); // NOI18N
        menuChecking.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menuAvatar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuAvatar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menuConfig.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_config.png"))); // NOI18N
        menuConfig.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jpnMainLeftLayout = new javax.swing.GroupLayout(jpnMainLeft);
        jpnMainLeft.setLayout(jpnMainLeftLayout);
        jpnMainLeftLayout.setHorizontalGroup(
            jpnMainLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnMainLeftLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jpnMainLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuChecking, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnMainLeftLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(menuAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(menuChecking, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(menuRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(menuCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addComponent(menuAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(menuConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7))))
            .addComponent(jpnMainSubMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnMainLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jMain, javax.swing.GroupLayout.DEFAULT_SIZE, 1338, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnMainLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jMain, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JDesktopPane jMain;
    private javax.swing.JPanel jpnLogo;
    private javax.swing.JPanel jpnMainLeft;
    private javax.swing.JPanel jpnMainSubMenu;
    private javax.swing.JPanel jpnMenu;
    private javax.swing.JLabel menuAdmin;
    private javax.swing.JLabel menuAvatar;
    private javax.swing.JLabel menuChecking;
    private javax.swing.JLabel menuConfig;
    private javax.swing.JLabel menuCustomer;
    private javax.swing.JLabel menuRoom;
    // End of variables declaration//GEN-END:variables
}

