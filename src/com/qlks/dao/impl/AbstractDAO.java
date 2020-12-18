package com.qlks.dao.impl;

import com.qlks.dao.GenericDAO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.qlks.mapper.RowMapper;
import com.qlks.utils.DBConnect;
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author admin
 */
public class AbstractDAO<T> implements GenericDAO<T> {

    @Override
    public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameter) {
        List<T> result = new ArrayList<>();
        CallableStatement csmt = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            conn = DBConnect.getInstance().getConnection();
            csmt = conn.prepareCall(sql);
            setParameter(csmt, parameter);
            rs = csmt.executeQuery();
            while (rs.next()) {
                result.add(rowMapper.mapRow(rs));
            }
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(AbstractDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (csmt != null) {
                    csmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                // TODO: handle exception
            }
        }
        return null;
    }

    private void setParameter(CallableStatement cstm, Object... parameters) {
        try {
            for (int i = 0; i < parameters.length; i++) {
                Object parameter = parameters[i];
                int index = i + 1;
                if (parameter instanceof Integer) {
                    cstm.setInt(index, (int) parameter);
                } else if (parameter instanceof String) {
                    cstm.setNString(index, (String) parameter);
                } else if (parameter instanceof Float) {
                    cstm.setFloat(index, (float) parameter);
                } else if (parameter instanceof Boolean) {
                    cstm.setBoolean(index, (boolean) parameter);
                } else if (parameter instanceof LocalDate) {
                    //cstm.setDate(index, (Date) parameter);
                    cstm.setDate(index, (Date.valueOf((LocalDate) parameter)));
                }
            }
        } catch (SQLException e) {
        }
    }

    @Override
    public void update(String sql, Object... parameters) {
        CallableStatement csmt = null;
        ResultSet rs = null;
        Connection conn = null;

        try {
            conn = DBConnect.getInstance().getConnection();
            conn.setAutoCommit(false);
            csmt = conn.prepareCall(sql);
            setParameter(csmt, parameters);
            csmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(AbstractDAO.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            Logger.getLogger(AbstractDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (csmt != null) {
                    csmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                // TODO: handle exception
            }
        }

    }

}
