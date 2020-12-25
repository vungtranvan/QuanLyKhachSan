/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.utils;

import com.qlks.view.MainJFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author hoangdung
 */
public class MethodMain {

    public static void globalMessagerSuccess(String msg) {
        MainJFrame.jlbMainMesange.setForeground(Color.GREEN);
        MainJFrame.jlbMainMesange.setIcon(new ImageIcon("src/com/qlks/icon/icon_success_green.png"));
        MainJFrame.jlbMainMesange.setText(msg);
        Timer timer = new Timer(10000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MainJFrame.jlbMainMesange.setIcon(null);
                MainJFrame.jlbMainMesange.setText("");
            }
        });
        timer.setRepeats(false);
        timer.start();

    }

    public static void globalMessagerError(String msg) {
        MainJFrame.jlbMainMesange.setForeground(Color.RED);
        MainJFrame.jlbMainMesange.setIcon(new ImageIcon("src/com/qlks/icon/icon_error_red.png"));
        MainJFrame.jlbMainMesange.setText(msg);
        Timer timer = new Timer(10000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MainJFrame.jlbMainMesange.setIcon(null);
                MainJFrame.jlbMainMesange.setText("");
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    public static void globalMessagerWarning(String msg) {
        MainJFrame.jlbMainMesange.setForeground(Color.YELLOW);
        MainJFrame.jlbMainMesange.setText(msg);
    }
}
