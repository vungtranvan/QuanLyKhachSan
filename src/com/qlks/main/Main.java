package com.qlks.main;

import com.qlks.models.NguoiDung;
import com.qlks.utils.MethodMain;
import com.qlks.view.LogInJFrame;
import com.qlks.view.MainJFrame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author hello
 */
public class Main {

    List<NguoiDung> listnd;

    public static void main(String[] args) {

        Main main = new Main();
        MainJFrame mainFrame = new MainJFrame();
        mainFrame.setLocationRelativeTo(null);
        LogInJFrame logInJFrame = new LogInJFrame();

        logInJFrame.setLocationRelativeTo(null);

        logInJFrame.setVisible(true);

        JButton jbLogin = logInJFrame.getBtnLogin();

        jbLogin.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                main.listnd = logInJFrame.getLogin();
                if (main.listnd != null) {
                    if (main.listnd.size() > 0) {
                        logInJFrame.setVisible(false);
                        mainFrame.setVisible(true);
                        String loginSuccess = "Dang nhap thanh cong";
                        MethodMain.globalMessagerSuccess(loginSuccess,mainFrame.getjMain());

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
}
