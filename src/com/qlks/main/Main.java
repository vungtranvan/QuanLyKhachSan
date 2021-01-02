package com.qlks.main;

import com.qlks.dao.impl.NhomQuyenDAO;
import com.qlks.dao.impl.PhanQuyenDAO;
import com.qlks.dao.impl.QuyenDAO;
import com.qlks.helper.ImageHelper;
import com.qlks.models.NguoiDung;
import com.qlks.models.PhanQuyen;
import com.qlks.models.Quyen;
import com.qlks.utils.MethodMain;
import com.qlks.view.LogInJFrame;
import com.qlks.view.MainJFrame;
import com.qlks.view.internalframe.action.UpdateNguoiDung;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.ImageIcon;
import javax.swing.JButton;

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

    public void login(LogInJFrame logInJFrame) {

        listnd = logInJFrame.getLogin();

        if (listnd != null) {
            if (listnd.size() > 0) {
                nd = listnd.get(0);
                PhanQuyenDAO pqdao = new PhanQuyenDAO();

                listQuyen = pqdao.getMaQuyenByMaQuyen(nd.getMaNhomQuyen());

                quyens = listQuyen.stream().map(e -> e.getQuyen()).collect(Collectors.toList());
                System.out.println(quyens);

                MainJFrame mainFrame = new MainJFrame(listnd);

                mainFrame.setLocationRelativeTo(null);
                logInJFrame.setVisible(false);

                if (!mainFrame.isVisible()) {
                    mainFrame.setVisible(true); 
                }

                String loginSuccess = mainFrame.rb.getString("MainJFrameLoginSuccessMgs");

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
                    ImageIcon icon = new ImageIcon(getClass().getResource("com/qlks/image/avatar/avatar_default.jpg"));
                    mainFrame.getMenuAvatar().setIcon(icon);
                    nguoidungImage = nd.getAnh();
                }
                mainFrame.setTitle(mainFrame.rb.getString("MainJFrameTitle") + "[ " + nd.getTenNguoiDung() + " ]");

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

    public static void main(String[] args) {

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
