/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.custom;

import javax.swing.JTable;
import javax.swing.table.TableColumn;

/**
 *
 * @author hello
 */
public class FunctionBase {

    public void addCheckBox(int column, JTable table) {
        TableColumn tc = table.getColumnModel().getColumn(column);
        tc.setCellEditor(table.getDefaultEditor(Boolean.class));
        tc.setCellRenderer(table.getDefaultRenderer(Boolean.class));
    }

    public boolean IsSelected(int row, int column, JTable table) {
        if (table.getValueAt(row, column) != null && Boolean.parseBoolean(table.getValueAt(row, column).toString()) != false) {
            return true;
        }
        return false;
    }
}
