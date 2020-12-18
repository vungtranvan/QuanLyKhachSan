/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.fonts;

import com.qlks.view.MainJFrame;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hoangdung
 */
public class FontCustom {

    public FontCustom() {

    }

    public Font MontserratSemiBold(float size) {
        return setFonts("src/com/qlks/fonts/Montserrat-SemiBold.ttf", size);
    }

    private Font setFonts(String url, float size) {
        try {
            File font_file = new File(url);
            return Font.createFont(Font.TRUETYPE_FONT, font_file).deriveFont(size);

        } catch (FontFormatException ex) {
            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
