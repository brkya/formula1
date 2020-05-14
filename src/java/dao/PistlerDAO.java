/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Pistler;
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
public class PistlerDAO {
    DBConnection instance = DBConnection.getInstance();

    public Pistler idBul(Long id) {
        Pistler p = null;

        try {
            PreparedStatement st = getConnection().prepareStatement("select * from pistler where pist_id=?");
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();
            rs.next();

            p = new Pistler();
            p.setPist_id(rs.getLong("pist_id"));
            p.setPist_adi(rs.getString("pist_adi"));
            p.setTur_sayisi(rs.getInt("tur_sayisi"));
            p.setUlke(rs.getString("ulke"));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return p;
    }

    public List<Pistler> listele() {
        List<Pistler> pistList = new ArrayList();
        try {
            PreparedStatement pst = getConnection().prepareStatement("select * from pistler");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Pistler tmp = new Pistler();
                tmp.setPist_id(rs.getLong("pist_id"));
                tmp.setPist_adi(rs.getString("pist_adi"));
                tmp.setTur_sayisi(rs.getInt("tur_sayisi"));
                tmp.setUlke(rs.getString("ulke"));
                pistList.add(tmp);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return pistList;
    }

    public void ekle(Pistler pist) {
        try {
            PreparedStatement pst = getConnection().prepareStatement("insert into pistler (pist_adi,tur_sayisi,ulke) values(?,?,?)");
            pst.setString(1, pist.getPist_adi());
            pst.setInt(2, pist.getTur_sayisi());
            pst.setString(3, pist.getUlke());
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void sil(Pistler pist) {
        try {
            PreparedStatement pst = getConnection().prepareStatement("delete from pistler where pist_id=?");
            pst.setLong(1, pist.getPist_id());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void duzelt(Pistler pist) {
        try {
            PreparedStatement pst = getConnection().prepareStatement("update pistler set pist_adi=?,tur_sayisi=?,ulke=? where takim_id=?");
            pst.setString(1, pist.getPist_adi());
            pst.setInt(2, pist.getTur_sayisi());
            pst.setString(3, pist.getUlke());
            pst.setLong(5, pist.getPist_id());
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
