package com.qlks.main;

import com.qlks.dao.impl.PhanQuyenDAO;
import com.qlks.helper.ImageHelper;
import com.qlks.models.NguoiDung;
import com.qlks.models.PhanQuyen;
import com.qlks.utils.MethodMain;
import com.qlks.view.LogInJFrame;
import com.qlks.view.MainJFrame;
import com.qlks.view.internalframe.action.UpdateNguoiDung;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author hello
 */
public class Main {

    LogInJFrame logInJFrame = new LogInJFrame();

    List<NguoiDung> listnd;
    List<PhanQuyen> listQuyen;
    public static List<String> quyens = new ArrayList<>();
    NguoiDung nd;
    private byte[] nguoidungImage;
    PhanQuyenDAO pqdao;

    public void login(LogInJFrame logInJFrame) {

        listnd = logInJFrame.getLogin();

        if (listnd != null) {
            if (listnd.size() > 0) {
                nd = listnd.get(0);
                pqdao = new PhanQuyenDAO();

                listQuyen = pqdao.getMaQuyenByMaQuyen(nd.getMaNhomQuyen());

                quyens = listQuyen.stream().map(e -> e.getQuyen()).collect(Collectors.toList());

                MainJFrame mainFrame = new MainJFrame(listnd);

                mainFrame.setLocationRelativeTo(null);

                logInJFrame.setVisible(false);

                if (!mainFrame.isVisible()) {
                    mainFrame.setVisible(true);
                    showLogOutBtn(mainFrame);
                }

               

                if (nd.getAnh() != null) {
                    try {
                        nguoidungImage = nd.getAnh();
                        Image img = ImageHelper.createImageFromByteArray(nguoidungImage, "jpg");
                        ImageIcon oldImgIcon = new ImageIcon(img);
                        Image oldImg = ImageHelper.resize(oldImgIcon.getImage(), 88, 88);
                        ImageIcon resizedIcon = new ImageIcon(oldImg);
                        mainFrame.getMenuAvatar().setIcon(resizedIcon);

                    } catch (IOException ex) {
                        Logger.getLogger(UpdateNguoiDung.class.getName()).log(Level.SEVERE, null, ex);
                        nguoidungImage = null;
                    }
                } else {

                    ImageIcon oldImgIcon = new ImageIcon("src/com/qlks/image/avatar/avatar_default.jpg");
                    Image oldImg = ImageHelper.resize(oldImgIcon.getImage(), 88, 88);
                    ImageIcon resizedIcon = new ImageIcon(oldImg);
                    mainFrame.getMenuAvatar().setIcon(resizedIcon);
                }
                mainFrame.setTitle(mainFrame.rb.getString("MainJFrameTitle") + "[ " + nd.getTenNguoiDung() + " ]");
                String loginSuccess = mainFrame.rb.getString("MainJFrameLoginSuccessMgs");
                MethodMain.globalMessagerSuccess(loginSuccess, mainFrame.getjMain());
            }
        }
    }

    private KeyListener logInEnter = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent ke) {

        }

        @Override
        public void keyPressed(KeyEvent ke) {
            if (ke.getKeyCode() == 10) {
                login(logInJFrame);
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {

        }

    };

    private void showLogOutBtn(MainJFrame mainJFrame) {
        mainJFrame.getMenuAvatar().addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {

                if (me.getButton() == MouseEvent.BUTTON3) {

                    JMenuItem logout;
                    JPopupMenu jPopupMenu = new JPopupMenu();
                    logout = new JMenuItem();
                    logout.setIcon(new ImageIcon("src/com/qlks/icon/icon_log_out.png"));
                    logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    logout.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            listnd.removeAll(listnd);
                            nd = null;
                            listQuyen.removeAll(listQuyen);
                            quyens.removeAll(quyens);
                            pqdao = null;
                            mainJFrame.dispose();
                            logInJFrame.setVisible(true);
                        }
                    });

                    jPopupMenu.add(logout);
                    jPopupMenu.show(me.getComponent(), 88, me.getY() - 30);
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

    public static void main(String[] args) {
        LocalDate a = LocalDate.parse("2020-10-10");
        LocalDate a1 = LocalDate.parse("2020-10-17");
        
        LocalDate b = LocalDate.parse("2020-10-18");
        LocalDate b1 = LocalDate.parse("2020-10-20");
        
        boolean bl =  MethodMain.isOverlapping(a, a1, b, b1);
      
        System.out.println(bl);
        
        
        
        
        Main main = new Main();

        main.logInJFrame.setLocationRelativeTo(null);

        main.logInJFrame.setVisible(true);

        JButton jbLogin = main.logInJFrame.getBtnLogin();

        jbLogin.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                main.login(main.logInJFrame);
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
        main.logInJFrame.getJtextName().addKeyListener(main.logInEnter);
        main.logInJFrame.getJpassPass().addKeyListener(main.logInEnter);

    }

}
