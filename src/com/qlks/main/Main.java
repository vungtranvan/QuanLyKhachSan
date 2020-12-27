package com.qlks.main;

import com.qlks.dao.impl.NhomQuyenDAO;
import com.qlks.dao.impl.QuyenDAO;
import com.qlks.models.NguoiDung;
import com.qlks.models.Quyen;
import com.qlks.utils.MethodMain;
import com.qlks.view.LogInJFrame;
import com.qlks.view.MainJFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author hello
 */
public class Main {

    LogInJFrame logInJFrame = new LogInJFrame();
    List<NguoiDung> listnd;

    public void login(LogInJFrame logInJFrame) {

        listnd = logInJFrame.getLogin();
        if (listnd != null) {
            if (listnd.size() > 0) {
                
                QuyenDAO qdao = new QuyenDAO();
//                List<Quyen> listQuyen = qdao.;
                
                MainJFrame mainFrame = new MainJFrame(listnd);

//                mainFrame.setListNd(listnd);
                mainFrame.setLocationRelativeTo(null);
                logInJFrame.setVisible(false);

                if (!mainFrame.isVisible()) {
                    mainFrame.setVisible(true);
                }

                String loginSuccess = "Dang nhap thanh cong";
                mainFrame.getMenuAvatar().setIcon(new ImageIcon("src/com/qlks/icon/" + listnd.get(0).getAnh()));
                mainFrame.setTitle("Quản lý khách sạn [ " + listnd.get(0).getTenNguoiDung() + " ]");
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
