/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.controller;

import com.qlks.bean.DanhMucBean;
import com.qlks.view.IndexJPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author hoangdung
 */
public class MenuController {

    private JPanel root;
    private String kindSelected = "";
    private List<DanhMucBean> listItem = null;

    public MenuController(JPanel root) {
        this.root = root;
    }
    
    
    
    
        public void setView(JPanel pnlItem, JLabel lblItem) {
        kindSelected = "TrangChu";
        pnlItem.setBackground(new Color(96, 100, 191));
        lblItem.setBackground(new Color(96, 100, 191));

        root.removeAll();
        root.setLayout(new BorderLayout());
        IndexJPanel indexJPanel = new IndexJPanel();
        root.add(indexJPanel);
        root.validate();
        root.repaint();
    }

}
