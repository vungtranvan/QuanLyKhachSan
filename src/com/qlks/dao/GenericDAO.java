/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.mapper.RowMapper;
import java.util.List;


/**
 *
 * @author admin
 */
public interface GenericDAO<T> {
       <T> List <T> query(String sql, RowMapper<T> rowMapper, Object... parameter);
       int update(String sql, Object... parameters);
}
