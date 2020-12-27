/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.utils;

import com.qlks.view.internalframe.ThongBao;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.Timer;

/**
 *
 * @author hoangdung
 */
public class MethodMain {

   private static ThongBao tb;

    public static void globalMessagerSuccess(String msg, JDesktopPane jdp) {
        tb = new ThongBao();
        tb.getJlbThongBao().setText(msg);
        tb.getJlbThongBao().setForeground(Color.green);
        
        tb.setVisible(true);
        jdp.add(tb);
        Timer timer = new Timer(10000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tb.setVisible(false);
                tb = null;
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
}
