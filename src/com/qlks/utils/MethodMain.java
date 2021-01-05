/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.utils;

import com.qlks.main.Main;
import com.qlks.view.internalframe.ThongBao;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
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
                if (tb != null) {
                    tb.setVisible(false);  tb.setVisible(false);
                    tb = null;
                }

            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    public static boolean checkQuyen(String quyen) {
        String[] qs = quyen.split(",");
        for (String q : qs) {
            if (Main.quyens.stream().anyMatch(_item -> (_item.equals(q)))) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkInputNull(JPasswordField jpass, JLabel jlbMsg, String stringMsg) {

        if (jpass.getPassword().length == 0) {
            jlbMsg.setText(stringMsg);
            return false;
        } else {
            jlbMsg.setText(null);
            return true;
        }

    }

    public static boolean checkInputNull(JTextField jtext, JLabel jlbMsg, String stringMsg) {
        if (jtext != null) {
            jlbMsg.setText(stringMsg);
            return false;
        } else {
            jlbMsg.setText(null);
            return true;
        }
    }
}
