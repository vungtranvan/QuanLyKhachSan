/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.custom;

import com.qlks.dao.impl.DanhSachSuDungDichVuDAO;
import com.qlks.dao.impl.PhieuNhanPhongDAO;
import com.qlks.dao.impl.PhieuThuePhongDAO;
import com.qlks.models.DanhSachSuDungDichVu;
import com.qlks.models.PhieuNhanPhong;
import com.qlks.models.PhieuThuePhong;
import java.util.List;
import java.util.Random;

/**
 *
 * @author hello
 */
public class RanDomMa {

    private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    private static final int RANDOM_STRING_LENGTH = 1;

    public String generateRandomString() {
        StringBuffer randStr = new StringBuffer();
        for (int i = 0; i < RANDOM_STRING_LENGTH; i++) {
            int number = getRandomNumber();
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }

    private int getRandomNumber() {
        int randomInt = 0;
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
        if (randomInt - 1 == -1) {
            return randomInt;
        } else {
            return randomInt - 1;
        }
    }

    public String rDomMaSDVV() {
        String ma = "";
        Random rd = new Random();
        int number = rd.nextInt(999);
        DanhSachSuDungDichVuDAO dao = new DanhSachSuDungDichVuDAO();

        do {
            ma = generateRandomString() + number;
            List<DanhSachSuDungDichVu> lst = dao.getByMaSuDungDichVu(ma);
            if (lst.size() <= 0) {
                break;
            }
        } while (true);

        return ma;
    }

    public String rDomMaThuePhong() {
        String ma = "";
        Random rd = new Random();
        int number = rd.nextInt(999);
        PhieuThuePhongDAO dao = new PhieuThuePhongDAO();

        do {
            ma = generateRandomString() + number;
            List<PhieuThuePhong> lst = dao.getByMaPhieuThue(ma);
            if (lst.size() <= 0) {
                break;
            }
        } while (true);

        return ma;
    }

    public String rDomMaNhanPhong() {
        String ma = "";
        Random rd = new Random();
        int number = rd.nextInt(999);
        PhieuNhanPhongDAO dao = new PhieuNhanPhongDAO();

        do {
            ma = generateRandomString() + number;
            List<PhieuNhanPhong> lst = dao.getByMaNhanPhong(ma);
            if (lst.size() <= 0) {
                break;
            }
        } while (true);

        return ma;
    }
}
