/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.view;

import com.qlks.dao.impl.CauHinhNguoiDungDAO;
import com.qlks.fonts.FontCustom;
import com.qlks.models.CauHinhNguoiDung;
import com.qlks.models.NguoiDung;
import com.qlks.view.internalframe.DoiMatKhauNguoiDung;
import com.qlks.view.internalframe.NgonNgu;
import com.qlks.view.internalframe.NgonNguItem;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author hoangdung
 */
public class MainJFrame extends javax.swing.JFrame {

    CauHinhNguoiDungDAO cauHinhNguoiDungDAO = new CauHinhNguoiDungDAO();
    CauHinhNguoiDung cauHinhNguoiDung;
    String cauHinhNgonNgu;
    int maNguoiDung;
    List<CauHinhNguoiDung> cauHinhNguoiDungs = new ArrayList<>();
    Locale lc;
    public ResourceBundle rb;

    List<JPanel> listSubMenuItemAdmin = new ArrayList<>();
    List<JPanel> listSubMenuItemRoom = new ArrayList<>();
    List<JPanel> listSubMenuItemCustomer = new ArrayList<>();
    List<JPanel> listSubMenuItemConfig = new ArrayList<>();

    JPanel subMenuAdmin;
    JPanel subMenuPermission;
    JPanel subMenuroupPermission;
    JPanel subMenuRule;

    JPanel subMenuRoomType;
    JPanel subMenuRoom;
    JPanel subMenuRoomStatus;
    JPanel subMenuEquipment;
    JPanel subMenuServiceType;
    JPanel subMenuService;
    JPanel subMenuUnit;
    JPanel subMenuCheckout;

    JPanel subMenuCustommer;
    JPanel subMenuDiscount;

    JPanel subMenuConfig;
    JPanel subMenuLanguage;

    int languageKey;

    private final Font subMenuItemFont = new FontCustom().MontserratSemiBold(16);
    private JPanel jpnSubmenu = new JPanel();

    public Color MainColor = new Color(36, 36, 36);
    public Color subMenuColor = new Color(56, 56, 56);

    JLabel closeSubMenu = new JLabel();

    public JLabel subMenuItemTitle = new JLabel();
    ImageIcon flagIcon = new ImageIcon("src/com/qlks/icon/icon_flag_vn.png");

    /**
     * Creates new form MainJFrame
     *
     * @param listNd
     */
    public MainJFrame(List<NguoiDung> listNd) {
        maNguoiDung = listNd.get(0).getMaNguoiDung();
        cauHinhNguoiDungs = cauHinhNguoiDungDAO.getValue(1, maNguoiDung);

        cauHinhNguoiDungs.forEach(chnd -> {
            cauHinhNgonNgu = chnd.getNoiDungCauHinh();
        });

        setLocale(cauHinhNgonNgu);
        initComponents();

        this.rb = ResourceBundle.getBundle("com.qlks.i18n.resources.resources", lc);

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        jpnSubmenu.setVisible(false);

        jpnSubmenu.setBackground(subMenuColor);
        jpnSubmenu.setLayout(new BoxLayout(jpnSubmenu, BoxLayout.Y_AXIS));

        jpnMainSubMenu.add(jpnSubmenu);

//        showInternalFrame(menuChecking, new QuanLyDatPhong());
        subMenuAdmin = new JPanel();
        listSubMenuItemAdmin.add(makeSubMenuItem(subMenuAdmin, rb.getString("subMenuAdmin")));
        showInternalFrame(subMenuAdmin, new QuanLyNguoiDung());

        subMenuPermission = new JPanel();
        listSubMenuItemAdmin.add(makeSubMenuItem(subMenuPermission, rb.getString("subMenuPermission")));
        showInternalFrame(subMenuPermission, new QuanLyQuyen());

        subMenuroupPermission = new JPanel();
        listSubMenuItemAdmin.add(makeSubMenuItem(subMenuroupPermission, rb.getString("subMenuroupPermission")));
        showInternalFrame(subMenuroupPermission, new QuanLyNhomQuyen());

        subMenuRule = new JPanel();
        listSubMenuItemAdmin.add(makeSubMenuItem(subMenuRule, rb.getString("subMenuRule")));
        showInternalFrame(subMenuRule, new QuanLyQuyDinh());

        //phong
        subMenuRoomType = new JPanel();
        listSubMenuItemRoom.add(makeSubMenuItem(subMenuRoomType, rb.getString("subMenuRoomType")));
        showInternalFrame(subMenuRoomType, new QuanLyLoaiPhong());

        subMenuRoomStatus = new JPanel();
        listSubMenuItemRoom.add(makeSubMenuItem(subMenuRoomStatus, rb.getString("subMenuRoomStatus")));
        showInternalFrame(subMenuRoomStatus, new QuanLyLoaiTinhTrang());

        subMenuRoom = new JPanel();
        listSubMenuItemRoom.add(makeSubMenuItem(subMenuRoom, rb.getString("subMenuRoom")));
        showInternalFrame(subMenuRoom, new QuanLyPhong());

        subMenuEquipment = new JPanel();
        listSubMenuItemRoom.add(makeSubMenuItem(subMenuEquipment, rb.getString("subMenuEquipment")));
        showInternalFrame(subMenuEquipment, new QuanLyThietBi());

        subMenuServiceType = new JPanel();
        listSubMenuItemRoom.add(makeSubMenuItem(subMenuServiceType, rb.getString("subMenuServiceType")));
        showInternalFrame(subMenuServiceType, new QuanLyLoaiDichVu());

        subMenuService = new JPanel();
        listSubMenuItemRoom.add(makeSubMenuItem(subMenuService, rb.getString("subMenuService")));
        showInternalFrame(subMenuService, new QuanLyDichVu());

        subMenuUnit = new JPanel();
        listSubMenuItemRoom.add(makeSubMenuItem(subMenuUnit, rb.getString("subMenuUnit")));
        showInternalFrame(subMenuUnit, new QuanLyDonVi());

        subMenuCheckout = new JPanel();
        listSubMenuItemRoom.add(makeSubMenuItem(subMenuCheckout, rb.getString("subMenuCheckout")));
        showInternalFrame(subMenuCheckout, new QuanLyChinhSachTraPhong());

        //khac hang
        subMenuCustommer = new JPanel();
        listSubMenuItemCustomer.add(makeSubMenuItem(subMenuCustommer, rb.getString("subMenuCustommer")));
        showInternalFrame(subMenuCustommer, new QuanLyKhachHang());

        subMenuDiscount = new JPanel();
        listSubMenuItemCustomer.add(makeSubMenuItem(subMenuDiscount, rb.getString("subMenuDiscount")));
        showInternalFrame(subMenuDiscount, new QuanLyMaKhuyenMai());

        NgonNgu ngonNgu = new NgonNgu(lc);
        subMenuLanguage = new JPanel();
        listSubMenuItemConfig.add(makeSubMenuItem(subMenuLanguage, rb.getString("subMenuLanguage")));
        controllang(ngonNgu, maNguoiDung);
        showInternalFrame(subMenuLanguage, ngonNgu);

        // Cau hinh
         subMenuConfig = new JPanel();
        listSubMenuItemConfig.add(makeSubMenuItem(subMenuConfig, rb.getString("subMenuConfig")));
        showInternalFrame(subMenuConfig, new QuanLyCauHinh());

        visibleSubMenu(menuAdmin, rb.getString("SubMenuTitleAdmin"), listSubMenuItemAdmin, 1);
        visibleSubMenu(menuRoom, rb.getString("SubMenuTitleRoom"), listSubMenuItemRoom, 2);
        visibleSubMenu(menuCustomer, rb.getString("SubMenuTitleCustomer"), listSubMenuItemCustomer, 3);
        visibleSubMenu(menuConfig, rb.getString("SubMenuTitleConfig"), listSubMenuItemConfig, 4);

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

    private void visibleSubMenu(JLabel jl, String title, List<JPanel> items, int langKey) {

        jl.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                Dimension dmnsn = new Dimension(300, 1000);
                jpnSubmenu.setPreferredSize(dmnsn);
//                jpnSubmenu.setSize(dmnsn);
                jpnSubmenu.setMaximumSize(new Dimension(1000, 1000));
//                jpnSubmenu.setA

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

                languageKey = langKey;
                jpnSubmenu.revalidate();
                jpnSubmenu.repaint();
                jpnSubmenu.setVisible(true);

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

    private void controllang(NgonNgu ngonNgu, int maNd) {
        ngonNgu.getJcbLang().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NgonNguItem it = (NgonNguItem) ngonNgu.getJcbLang().getSelectedItem();
                MainJFrame.this.cauHinhNgonNgu = it.getId();
                System.out.println(cauHinhNgonNgu);
                ngonNgu.getJlbLangMsg().setText("");
            }
        });
        ngonNgu.getJpnLangOk().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                System.out.println(cauHinhNgonNgu);
                cauHinhNguoiDung = new CauHinhNguoiDung(1, maNd, cauHinhNgonNgu);
                setLocale(cauHinhNgonNgu);
                int row = cauHinhNguoiDungDAO.update(cauHinhNguoiDung);
                if (row > 0) {
                    translate(lc);
                    ngonNgu.translate(lc);
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

    public void setLocale(String cauHinhNgNg) {
        switch (cauHinhNgNg) {
            case "anh":
                this.lc = Locale.ENGLISH;
                break;
            case "phap":
                this.lc = Locale.FRANCE;
                break;
            case "vietnam":
                this.lc = new Locale("vi", "VN");
                break;
            default:
                this.lc = new Locale("vi", "VN");
                break;

        }
    }

    private void setTextJlbFromJpn(JPanel jp, String text) {
        Component[] jc = jp.getComponents();
        if (jc != null && jc.length > 0) {
            for (Component component : jc) {
                if (component instanceof JLabel) {
                    JLabel jl = (JLabel) component;
                    jl.setText(text);
                }
            }
        }
    }

    public void translate(Locale lc) {
        rb = ResourceBundle.getBundle("com.qlks.i18n.resources.resources", lc);
        setTextJlbFromJpn(subMenuAdmin, rb.getString("subMenuAdmin"));
        setTextJlbFromJpn(subMenuPermission, rb.getString("subMenuPermission"));
        setTextJlbFromJpn(subMenuroupPermission, rb.getString("subMenuroupPermission"));
        setTextJlbFromJpn(subMenuRule, rb.getString("subMenuRule"));
        setTextJlbFromJpn(subMenuRoom, rb.getString("subMenuRoom"));
        setTextJlbFromJpn(subMenuRoomType, rb.getString("subMenuRoomType"));
        setTextJlbFromJpn(subMenuRoomStatus, rb.getString("subMenuRoomStatus"));
        setTextJlbFromJpn(subMenuEquipment, rb.getString("subMenuEquipment"));
        setTextJlbFromJpn(subMenuServiceType, rb.getString("subMenuServiceType"));
        setTextJlbFromJpn(subMenuService, rb.getString("subMenuService"));
        setTextJlbFromJpn(subMenuUnit, rb.getString("subMenuUnit"));
        setTextJlbFromJpn(subMenuCheckout, rb.getString("subMenuCheckout"));
        setTextJlbFromJpn(subMenuCustommer, rb.getString("subMenuCustommer"));
        setTextJlbFromJpn(subMenuDiscount, rb.getString("subMenuDiscount"));
        setTextJlbFromJpn(subMenuConfig, rb.getString("subMenuConfig"));
        setTextJlbFromJpn(subMenuLanguage, rb.getString("subMenuLanguage"));
        setTextJlbFromJpn(subMenuLanguage, rb.getString("subMenuLanguage"));

        switch (languageKey) {
            case 1:
                subMenuItemTitle.setText(rb.getString("SubMenuTitleAdmin").toUpperCase());
                break;
            case 2:
                subMenuItemTitle.setText(rb.getString("SubMenuTitleRoom").toUpperCase());
                break;
            case 3:
                subMenuItemTitle.setText(rb.getString("SubMenuTitleCustomer").toUpperCase());
                break;
            case 4:
                subMenuItemTitle.setText(rb.getString("SubMenuTitleConfig").toUpperCase());
                break;
        }
        visibleSubMenu(menuAdmin, rb.getString("SubMenuTitleAdmin"), listSubMenuItemAdmin, 1);
        visibleSubMenu(menuRoom, rb.getString("SubMenuTitleRoom"), listSubMenuItemRoom, 2);
        visibleSubMenu(menuCustomer, rb.getString("SubMenuTitleCustomer"), listSubMenuItemCustomer, 3);
        visibleSubMenu(menuConfig, rb.getString("SubMenuTitleConfig"), listSubMenuItemConfig, 4);

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
