/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.TakimKoclari;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;
import static util.DBConnection.getConnection;

/**
 *
 * @author Burak
 */
public class TakimKoclariDAO {
    DBConnection instance = DBConnection.getInstance();
    public TakimKoclari idBul(Long id) {
        TakimKoclari tk = null;

        try {
            PreparedStatement st = getConnection().prepareStatement("select * from takim_koclari where koc_id=?");
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();
            rs.next();

            tk = new TakimKoclari();
            tk.setKoc_id(rs.getLong("koc_id"));
            tk.setKoc_adi(rs.getString("koc_adi"));
            tk.setKoc_soyadi(rs.getString("koc_soyadi"));
            tk.setYas(rs.getInt("yas"));
            tk.setDogum_yeri(rs.getString("dogum_yeri"));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return tk;
    }

    public List<TakimKoclari> listele() {
        List<TakimKoclari> kocList = new ArrayList();

        try {
            PreparedStatement pst = getConnection().prepareStatement("select * from takim_koclari");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                TakimKoclari tmp = new TakimKoclari();
                tmp.setKoc_id(rs.getLong("koc_id"));
                tmp.setKoc_adi(rs.getString("koc_adi"));
                tmp.setKoc_soyadi(rs.getString("koc_soyadi"));
                tmp.setYas(rs.getInt("yas"));
                tmp.setDogum_yeri(rs.getString("dogum_yeri"));
                kocList.add(tmp);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return kocList;
    }

    public void ekle(TakimKoclari koc) {
        try {
            
            PreparedStatement pst = getConnection().prepareStatement("insert into takim_koclari (koc_adi,koc_soyadi,yas,dogum_yeri) values(?,?,?,?)");
            pst.setString(1, koc.getKoc_adi());
            pst.setString(2, koc.getKoc_soyadi());
            pst.setInt(3, koc.getYas());
            pst.setString(4, koc.getDogum_yeri());
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void sil(TakimKoclari koc) {
        try {
            PreparedStatement pst = getConnection().prepareStatement("delete from takim_koclari where koc_id=?");
            pst.setLong(1, koc.getKoc_id());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void duzelt(TakimKoclari koc) {
        try {
            PreparedStatement pst = getConnection().prepareStatement("update takim_koclari set koc_adi=?,koc_soyadi=?,yas=?,dogum_yeri=? where koc_id=?");
            pst.setString(1, koc.getKoc_adi());
            pst.setString(2, koc.getKoc_soyadi());
            pst.setInt(3, koc.getYas());
            pst.setString(4, koc.getDogum_yeri());
            pst.setLong(5, koc.getKoc_id());
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


}
