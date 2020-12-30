/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.view.internalframe;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

/**
 *
 * @author hoangdung
 */

public class NgonNguItemRenderer extends BasicComboBoxRenderer {

    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected,
                cellHasFocus);

        NgonNguItem item = (NgonNguItem) value;

        if (index == -1) {
            setText(item.getText());
            setIcon(null);
        } else {
            setText(item.getText());
            setIcon(item.getIcon());
        }
        return this;
    }
}
