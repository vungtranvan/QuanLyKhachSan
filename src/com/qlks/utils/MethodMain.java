/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.utils;

import javax.swing.JLabel;

/**
 *
 * @author hoangdung
 */
public class MethodMain {

    public static boolean checkNull(String Checker, String Message, JLabel show) {
        if (Checker.isEmpty()) {
            show.setText(Message);
            return true;
        } else {
            return false;
        }
    }
}
