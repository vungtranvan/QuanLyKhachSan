/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.models;

import javax.swing.Icon;

/**
 *
 * @author hoangdung
 */
public class NgonNguItem {

    private String id;
    private Icon icon;
    private String text;

    public NgonNguItem(String id, Icon icon, String text) {
        this.id = id;
        this.icon = icon;
        this.text = text;
    }

    public Icon getIcon() {
        return icon;
    }

    public String getText() {
        return text;
    }

    public String getId() {
        return id;
    }

    public void setText(String text) {
        this.text = text;
    }

}
