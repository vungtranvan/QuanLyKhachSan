/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.utils;

import com.qlks.view.MainJFrame;
import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author hoangdung
 */
public class MethodMain {

    public static void globalMessagerSuccess(String msg) {
        MainJFrame.jlbMainMesange.setForeground(Color.GREEN);
        MainJFrame.jlbMainMesange.setText(msg);
    }

    public static void globalMessagerError(String msg) {
        MainJFrame.jlbMainMesange.setForeground(Color.RED);
        MainJFrame.jlbMainMesange.setText(msg);
    }

    public static void globalMessagerWarning(String msg) {
        MainJFrame.jlbMainMesange.setForeground(Color.YELLOW);
        MainJFrame.jlbMainMesange.setText(msg);
    }
}
