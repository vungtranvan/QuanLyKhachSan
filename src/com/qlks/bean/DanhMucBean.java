package com.qlks.bean;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author hello
 */
public class DanhMucBean {
    private String loai;
    private JPanel pnl;
    private JLabel lbl;
    
    

    public DanhMucBean() {
    }

    public DanhMucBean(String loai, JPanel pnl, JLabel lbl) {
        this.loai = loai;
        this.pnl = pnl;
        this.lbl = lbl;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public JPanel getPnl() {
        return pnl;
    }

    public void setPnl(JPanel pnl) {
        this.pnl = pnl;
    }

    public JLabel getLbl() {
        return lbl;
    }

    public void setLbl(JLabel lbl) {
        this.lbl = lbl;
    }
    
}
