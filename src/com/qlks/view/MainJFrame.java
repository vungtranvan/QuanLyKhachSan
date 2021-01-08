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
import com.qlks.utils.MethodMain;
import com.qlks.view.internalframe.BieuDoThongKePhong;
import com.qlks.view.internalframe.DoiMatKhauNguoiDung;
import com.qlks.models.NgonNgu;
import com.qlks.models.NgonNguItem;
import com.qlks.view.internalframe.QLDichVuPhong;
import com.qlks.view.internalframe.QLHoaDon;
import com.qlks.view.internalframe.QLPhieuNhanPhong;
import com.qlks.view.internalframe.QLPhieuThuePhong;
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
import com.qlks.view.internalframe.QuanLyThietBi;
import com.qlks.view.internalframe.ThongKeDoanhThuPhong;
import com.qlks.view.internalframe.ThongKeHieuSuatPhong;
import com.qlks.view.internalframe.ThongKeKhachHang;
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
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
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

    private CauHinhNguoiDungDAO cauHinhNguoiDungDAO = new CauHinhNguoiDungDAO();
    private CauHinhNguoiDung cauHinhNguoiDung;
    private String cauHinhNgonNgu;
    private int maNguoiDung;
    private List<CauHinhNguoiDung> cauHinhNguoiDungs = new ArrayList<>();
    private Locale lc;
    public ResourceBundle rb;

    private List<JPanel> listSubMenuItemAdmin = new ArrayList<>();
    private List<JPanel> listSubMenuItemChecking = new ArrayList<>();

    private List<JPanel> listSubMenuItemRoom = new ArrayList<>();
    private List<JPanel> listSubMenuSevice = new ArrayList<>();

    private List<JPanel> listSubMenuItemCustomer = new ArrayList<>();

    private List<JPanel> listSubMenuStatistic = new ArrayList<>();

    private List<JPanel> listSubMenuItemConfig = new ArrayList<>();

    QuanLyNguoiDung quanLyNguoiDung;
    private JPanel subMenuAdmin;

    QuanLyNhomQuyen quanLyNhomQuyen;
    private JPanel subMenuroupPermission;
    QuanLyQuyDinh quanLyQuyDinh;
    private JPanel subMenuRule;

    QLPhieuThuePhong qLPhieuThuePhong;
    private JPanel subMenuBook;
    QLPhieuNhanPhong qLPhieuNhanPhong;

    private JPanel subMenuAddServiceToRoom;
    QLDichVuPhong qLDichVuPhong;
    private JPanel subMenuCheckIn;
    private JPanel subMenuTax;
    QLHoaDon qLHoaDon;
    private JPanel subMenuHoaDon;
    QuanLyLoaiPhong quanLyLoaiPhong;
    private JPanel subMenuRoomType;
    QuanLyPhong quanLyPhong;
    private JPanel subMenuRoom;


    QuanLyLoaiTinhTrang quanLyLoaiTinhTrang;
    private JPanel subMenuRoomStatus;
    QuanLyThietBi quanLyThietBi;
    private JPanel subMenuEquipment;
    QuanLyLoaiDichVu quanLyLoaiDichVu;
    private JPanel subMenuServiceType;
    QuanLyDichVu quanLyDichVu;

    private JPanel subMenuService;
    QuanLyDonVi quanLyDonVi;
    private JPanel subMenuUnit;

    private JPanel subMenuCheckout;

    QuanLyKhachHang quanLyKhachHang;
    private JPanel subMenuCustommer;
    QuanLyMaKhuyenMai quanLyMaKhuyenMai;
    private JPanel subMenuDiscount;

    ThongKeDoanhThuPhong thongKeDoanhThuPhong;
    private JPanel submenuStatisticsRoom;
    private JPanel submenuStatisticsKhachHang;
    ThongKeKhachHang thongKeKhachHang;

    JPanel submenuStatisticsHsPhong;
    ThongKeHieuSuatPhong thongKeHsPhong;

    private JPanel subMenuConfig;
    private JPanel subMenuLanguage;

    private int languageKey;

    DoiMatKhauNguoiDung doiMatKhauNguoiDung;

    private final Font subMenuItemFont = new FontCustom().MontserratSemiBold(16);
    private JPanel jpnSubmenu = new JPanel();

    public Color MainColor;
    public Color subMenuColor;

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
        String color = cauHinhNguoiDungDAO.getValue(2, maNguoiDung).get(0).getNoiDungCauHinh();
        String newColor = color.replace("[", "").replace("]", "").replace(" ", "");

        String[] ColorString = newColor.split(",");
        this.MainColor = new Color(Integer.parseInt(ColorString[0]), Integer.parseInt(ColorString[1]), Integer.parseInt(ColorString[2]));
        this.subMenuColor = brighten(MainColor, 0.05);
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

        // nguoi dung
        menuAdmin.setVisible(false);
        if (MethodMain.checkQuyen("XemNguoiDung")) {
            menuAdmin.setVisible(true);

            subMenuAdmin = new JPanel();
            quanLyNguoiDung = new QuanLyNguoiDung(lc);
            listSubMenuItemAdmin.add(makeSubMenuItem(subMenuAdmin, rb.getString("subMenuAdmin")));
            showInternalFrame(subMenuAdmin, quanLyNguoiDung);

            subMenuroupPermission = new JPanel();
            quanLyNhomQuyen = new QuanLyNhomQuyen(lc);
            listSubMenuItemAdmin.add(makeSubMenuItem(subMenuroupPermission, rb.getString("subMenuroupPermission")));
            showInternalFrame(subMenuroupPermission, quanLyNhomQuyen);

            visibleSubMenu(menuAdmin, rb.getString("SubMenuTitleAdmin"), listSubMenuItemAdmin, 1);
        }
        // Dat phong
        menuChecking.setVisible(false);
        if (MethodMain.checkQuyen("XemGiaoDich")) {
            menuChecking.setVisible(true);

            subMenuBook = new JPanel();
            qLPhieuThuePhong = new QLPhieuThuePhong(lc);
            listSubMenuItemChecking.add(makeSubMenuItem(subMenuBook, rb.getString("subMenuBook")));
            showInternalFrame(subMenuBook, qLPhieuThuePhong);

            subMenuCheckIn = new JPanel();
            qLPhieuNhanPhong = new QLPhieuNhanPhong(listNd, lc);
            listSubMenuItemChecking.add(makeSubMenuItem(subMenuCheckIn, rb.getString("subMenuCheckIn")));
            showInternalFrame(subMenuCheckIn, qLPhieuNhanPhong);

            subMenuAddServiceToRoom = new JPanel();
            qLDichVuPhong = new QLDichVuPhong(listNd, lc);
            listSubMenuItemChecking.add(makeSubMenuItem(subMenuAddServiceToRoom, rb.getString("subMenuAddServiceToRoom")));
            showInternalFrame(subMenuAddServiceToRoom, qLDichVuPhong);

            subMenuHoaDon = new JPanel();
            qLHoaDon = new QLHoaDon(lc);
            listSubMenuItemChecking.add(makeSubMenuItem(subMenuHoaDon, rb.getString("subMenuHoaDon")));
            showInternalFrame(subMenuHoaDon, qLHoaDon);
            subMenuTax = new JPanel();
            visibleSubMenu(menuChecking, rb.getString("SubMenuTitleChecking"), listSubMenuItemChecking, 5);
        }
        //phong
        menuRoom.setVisible(false);
        if (MethodMain.checkQuyen("XemPhong,XemThietBi")) {
            menuRoom.setVisible(true);
            if (MethodMain.checkQuyen("XemPhong")) {
                subMenuRoom = new JPanel();
                quanLyPhong = new QuanLyPhong(lc);
                listSubMenuItemRoom.add(makeSubMenuItem(subMenuRoom, rb.getString("subMenuRoom")));
                showInternalFrame(subMenuRoom, quanLyPhong);

                subMenuRoomType = new JPanel();
                quanLyLoaiPhong = new QuanLyLoaiPhong(lc);
                listSubMenuItemRoom.add(makeSubMenuItem(subMenuRoomType, rb.getString("subMenuRoomType")));
                showInternalFrame(subMenuRoomType, quanLyLoaiPhong);

                subMenuRoomStatus = new JPanel();
                quanLyLoaiTinhTrang = new QuanLyLoaiTinhTrang(lc);
                listSubMenuItemRoom.add(makeSubMenuItem(subMenuRoomStatus, rb.getString("subMenuRoomStatus")));
                showInternalFrame(subMenuRoomStatus, quanLyLoaiTinhTrang);

                subMenuCheckout = new JPanel();
                listSubMenuItemRoom.add(makeSubMenuItem(subMenuCheckout, rb.getString("subMenuCheckout")));
                showInternalFrame(subMenuCheckout, new QuanLyChinhSachTraPhong());
            }
            if (MethodMain.checkQuyen("XemThietBi")) {
                subMenuEquipment = new JPanel();
                quanLyThietBi = new QuanLyThietBi(lc);
                listSubMenuItemRoom.add(makeSubMenuItem(subMenuEquipment, rb.getString("subMenuEquipment")));
                showInternalFrame(subMenuEquipment, quanLyThietBi);
            }
            visibleSubMenu(menuRoom, rb.getString("SubMenuTitleRoom"), listSubMenuItemRoom, 2);
        }
        // Dich vu
        menuService.setVisible(false);
        if (MethodMain.checkQuyen("XemDichVu")) {
            menuService.setVisible(true);

            subMenuService = new JPanel();
            quanLyDichVu = new QuanLyDichVu(lc);
            listSubMenuSevice.add(makeSubMenuItem(subMenuService, rb.getString("subMenuService")));
            showInternalFrame(subMenuService, quanLyDichVu);

            subMenuServiceType = new JPanel();
            quanLyLoaiDichVu = new QuanLyLoaiDichVu(lc);
            listSubMenuSevice.add(makeSubMenuItem(subMenuServiceType, rb.getString("subMenuServiceType")));
            showInternalFrame(subMenuServiceType, quanLyLoaiDichVu);

            subMenuUnit = new JPanel();
            quanLyDonVi = new QuanLyDonVi(lc);
            listSubMenuSevice.add(makeSubMenuItem(subMenuUnit, rb.getString("subMenuUnit")));
            showInternalFrame(subMenuUnit, quanLyDonVi);

            visibleSubMenu(menuService, rb.getString("SubMenuTitleSevice"), listSubMenuSevice, 6);
        }
        //khac hang
        menuCustomer.setVisible(false);
        if (MethodMain.checkQuyen("XemKhachHang,XemKhuyenMai,XemQuyDinh")) {
            menuCustomer.setVisible(true);
            if (MethodMain.checkQuyen("XemKhachHang")) {
                subMenuCustommer = new JPanel();
                quanLyKhachHang = new QuanLyKhachHang(lc);
                listSubMenuItemCustomer.add(makeSubMenuItem(subMenuCustommer, rb.getString("subMenuCustommer")));
                showInternalFrame(subMenuCustommer, quanLyKhachHang);
            }
            if (MethodMain.checkQuyen("XemKhuyenMai")) {
                subMenuDiscount = new JPanel();
                quanLyMaKhuyenMai = new QuanLyMaKhuyenMai(lc);
                listSubMenuItemCustomer.add(makeSubMenuItem(subMenuDiscount, rb.getString("subMenuDiscount")));
                showInternalFrame(subMenuDiscount, quanLyMaKhuyenMai);
            }
            if (MethodMain.checkQuyen("XemQuyDinh")) {
                subMenuRule = new JPanel();
                quanLyQuyDinh = new QuanLyQuyDinh(lc);
                listSubMenuItemCustomer.add(makeSubMenuItem(subMenuRule, rb.getString("subMenuRule")));
                showInternalFrame(subMenuRule, quanLyQuyDinh);
            }
            visibleSubMenu(menuCustomer, rb.getString("SubMenuTitleCustomer"), listSubMenuItemCustomer, 3);
        }
        //Thong ke
        if (MethodMain.checkQuyen("QlDaoDich")) {

            submenuStatisticsRoom = new JPanel();
            thongKeDoanhThuPhong = new ThongKeDoanhThuPhong(lc);
            listSubMenuStatistic.add(makeSubMenuItem(submenuStatisticsRoom, rb.getString("submenuStatisticsRoom")));
            showInternalFrame(submenuStatisticsRoom, thongKeDoanhThuPhong);

            submenuStatisticsKhachHang = new JPanel();
            thongKeKhachHang = new ThongKeKhachHang(lc);
            listSubMenuStatistic.add(makeSubMenuItem(submenuStatisticsKhachHang, rb.getString("submenuStatisticsKhachHang")));
            showInternalFrame(submenuStatisticsKhachHang, thongKeKhachHang);

            JPanel submenuStatisticsHsPhong = new JPanel();
            ThongKeHieuSuatPhong thongKeHsPhong = new ThongKeHieuSuatPhong(lc);
            listSubMenuStatistic.add(makeSubMenuItem(submenuStatisticsHsPhong, rb.getString("submenuStatisticsHsPhong")));
            showInternalFrame(submenuStatisticsHsPhong, thongKeHsPhong);

            visibleSubMenu(menuStatistics, rb.getString("SubMenuTitleStatistics"), listSubMenuStatistic, 7);
        }
        // Ngon ngu
        NgonNgu ngonNgu = new NgonNgu(lc);
        subMenuLanguage = new JPanel();
        listSubMenuItemConfig.add(makeSubMenuItem(subMenuLanguage, rb.getString("subMenuLanguage")));
        controllang(ngonNgu, maNguoiDung);
        showInternalFrame(subMenuLanguage, ngonNgu);

        // Cau hinh
        QuanLyCauHinh quanLyCauHinh = new QuanLyCauHinh();
        subMenuConfig = new JPanel();
        listSubMenuItemConfig.add(makeSubMenuItem(subMenuConfig, rb.getString("subMenuColor")));
        subMenuConfig.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {

                MainColor = JColorChooser.showDialog(jMain, "Choise color", MainColor);
                jpnSubmenu.setBackground(brighten(MainColor, 0.25));
                setMenuBackGroundColor(MainColor.getRed(), MainColor.getGreen(), MainColor.getBlue());
                int[] color = {MainColor.getRed(), MainColor.getGreen(), MainColor.getBlue()};
                Arrays.toString(color);
                CauHinhNguoiDung cauHinhNguoiDungColor = new CauHinhNguoiDung(2, 1, Arrays.toString(color));

                cauHinhNguoiDungDAO.update(cauHinhNguoiDungColor);
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

//        showInternalFrame(subMenuConfig, quanLyCauHinh);
        visibleSubMenu(menuConfig, rb.getString("SubMenuTitleConfig"), listSubMenuItemConfig, 4);

        invisibleSubMenu(closeSubMenu);
        invisibleSubMenu(jMain);
        setMenuBackGroundColor(this.MainColor.getRed(), this.MainColor.getGreen(), this.MainColor.getBlue());

        doiMatKhauNguoiDung = new DoiMatKhauNguoiDung(listNd, lc);
        showInternalFrame(menuAvatar, doiMatKhauNguoiDung);
    }

    public Color brighten(Color color, double fraction) {

        int red = (int) Math.round(Math.min(255, color.getRed() + 255 * fraction));
        int green = (int) Math.round(Math.min(255, color.getGreen() + 255 * fraction));
        int blue = (int) Math.round(Math.min(255, color.getBlue() + 255 * fraction));

        int alpha = color.getAlpha();

        return new Color(red, green, blue, alpha);

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
                if (me.getButton() == MouseEvent.BUTTON1) {

                    Dimension dmnsn = new Dimension(300, 2000);
                    jpnSubmenu.setPreferredSize(dmnsn);

                    jpnSubmenu.setMaximumSize(new Dimension(1000, 1000));

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
        jp.setOpaque(false);
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
        jp.setOpaque(false);
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
                if (me.getButton() == MouseEvent.BUTTON1) {
                    if (!jif.isVisible()) {
                        jMain.add(jif);
                        centerJIF(jif);
                        jif.setVisible(true);
                    } else {
                        jif.moveToFront();
                    }

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
                if (me.getButton() == MouseEvent.BUTTON1) {
                    if (!jif.isVisible()) {
                        jMain.add(jif);
                        centerJIF(jif);
                        jif.setVisible(true);
                    } else {
                        jif.moveToFront();
                    }
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

                ngonNgu.getJlbLangMsg().setText("");
            }
        });
        ngonNgu.getJpnLangOk().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {

                cauHinhNguoiDung = new CauHinhNguoiDung(1, maNd, cauHinhNgonNgu);
                setLocale(cauHinhNgonNgu);
                int row = cauHinhNguoiDungDAO.update(cauHinhNguoiDung);
                if (row > 0) {
                    translate(lc);
                    ngonNgu.translate(lc);

                    doiMatKhauNguoiDung.translate(lc);
                    if (quanLyNhomQuyen != null) {
                        quanLyNhomQuyen.translate(lc);
                    }
                    if (quanLyNguoiDung != null) {
                        quanLyNguoiDung.translate(lc);
                    }
                    if (quanLyLoaiPhong != null) {
                        quanLyLoaiPhong.translate(lc);
                    }
                    if (quanLyPhong != null) {
                        quanLyPhong.translate(lc);
                    }
                    if (quanLyThietBi != null) {
                        quanLyThietBi.translate(lc);
                    }
                    if (quanLyLoaiTinhTrang != null) {
                        quanLyLoaiTinhTrang.translate(lc);
                    }
                    if (quanLyDichVu != null) {
                        quanLyDichVu.translate(lc);
                    }
                    if (quanLyLoaiDichVu != null) {
                        quanLyLoaiDichVu.translate(lc);
                    }
                    if (quanLyDonVi != null) {
                        quanLyDonVi.translate(lc);
                    }
                    if (quanLyKhachHang != null) {
                        quanLyKhachHang.translate(lc);
                    }
                    if (quanLyMaKhuyenMai != null) {
                        quanLyMaKhuyenMai.translate(lc);
                    }
                    if (quanLyQuyDinh != null) {
                        quanLyQuyDinh.translate(lc);
                    }

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
        setTextJlbFromJpn(subMenuAddServiceToRoom, rb.getString("subMenuAddServiceToRoom"));
        setTextJlbFromJpn(subMenuConfig, rb.getString("subMenuColor"));
        setTextJlbFromJpn(subMenuLanguage, rb.getString("subMenuLanguage"));
        setTextJlbFromJpn(subMenuLanguage, rb.getString("subMenuLanguage"));
        setTextJlbFromJpn(subMenuBook, rb.getString("subMenuBook"));
        setTextJlbFromJpn(subMenuCheckIn, rb.getString("subMenuCheckIn"));
        setTextJlbFromJpn(submenuStatisticsRoom, rb.getString("submenuStatisticsRoom"));
        setTextJlbFromJpn(subMenuHoaDon, rb.getString("subMenuHoaDon"));

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
            case 5:
                subMenuItemTitle.setText(rb.getString("SubMenuTitleChecking").toUpperCase());
                break;
            case 6:
                subMenuItemTitle.setText(rb.getString("SubMenuTitleSevice").toUpperCase());
                break;
            case 7:
                subMenuItemTitle.setText(rb.getString("SubMenuTitleStatistics").toUpperCase());
                break;
        }
        visibleSubMenu(menuAdmin, rb.getString("SubMenuTitleAdmin"), listSubMenuItemAdmin, 1);
        visibleSubMenu(menuRoom, rb.getString("SubMenuTitleRoom"), listSubMenuItemRoom, 2);
        visibleSubMenu(menuCustomer, rb.getString("SubMenuTitleCustomer"), listSubMenuItemCustomer, 3);
        visibleSubMenu(menuConfig, rb.getString("SubMenuTitleConfig"), listSubMenuItemConfig, 4);
        visibleSubMenu(menuChecking, rb.getString("SubMenuTitleChecking"), listSubMenuItemChecking, 5);
        visibleSubMenu(menuService, rb.getString("SubMenuTitleSevice"), listSubMenuSevice, 6);
        visibleSubMenu(menuStatistics, rb.getString("SubMenuTitleStatistics"), listSubMenuStatistic, 7);

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
        menuAdmin = new javax.swing.JLabel();
        menuRoom = new javax.swing.JLabel();
        jpnMainSubMenu = new javax.swing.JPanel();
        menuCustomer = new javax.swing.JLabel();
        menuChecking = new javax.swing.JLabel();
        menuAvatar = new javax.swing.JLabel();
        menuConfig = new javax.swing.JLabel();
        menuService = new javax.swing.JLabel();
        menuStatistics = new javax.swing.JLabel();
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
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnLogoLayout.setVerticalGroup(
            jpnLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
        );

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

        menuService.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuService.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_service.png"))); // NOI18N
        menuService.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menuStatistics.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuStatistics.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/icon_statistics .png"))); // NOI18N
        menuStatistics.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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
                    .addComponent(menuConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuService, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuStatistics, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jpnMainSubMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnMainLeftLayout.setVerticalGroup(
            jpnMainLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMainLeftLayout.createSequentialGroup()
                .addComponent(jpnLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(menuAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(menuChecking, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(menuRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(menuService, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(menuCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(menuStatistics, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(menuAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
            .addComponent(jpnMainSubMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnMainLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jMain, javax.swing.GroupLayout.DEFAULT_SIZE, 1326, Short.MAX_VALUE))
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
    private javax.swing.JLabel menuAdmin;
    private javax.swing.JLabel menuAvatar;
    private javax.swing.JLabel menuChecking;
    private javax.swing.JLabel menuConfig;
    private javax.swing.JLabel menuCustomer;
    private javax.swing.JLabel menuRoom;
    private javax.swing.JLabel menuService;
    private javax.swing.JLabel menuStatistics;
    // End of variables declaration//GEN-END:variables

}
