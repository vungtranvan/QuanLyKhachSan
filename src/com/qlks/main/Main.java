package com.qlks.main;

import com.qlks.models.NguoiDung;
import com.qlks.view.LogInJFrame;
import com.qlks.view.MainJFrame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JButton;

/**
 *
 * @author hello
 */
public class Main {

    public static void main(String[] args) {
       
        MainJFrame mainFrame = new MainJFrame();
        mainFrame.setLocationRelativeTo(null);
        LogInJFrame logInJFrame = new LogInJFrame();
        
        JButton jbLogin = logInJFrame.getBtnLogin();
        jbLogin.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent me) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent me) {
               
            }

            @Override
            public void mouseExited(MouseEvent me) {
                
            }
        });
        
        logInJFrame.setLocationRelativeTo(null);
        logInJFrame.setVisible(true);
        
        List<NguoiDung> listnd = logInJFrame.getLogin();

        if (listnd.size() > 0) {
            logInJFrame.setVisible(false);
            mainFrame.setVisible(true);
        }

    }
}
