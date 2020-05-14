/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Yetki;
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
public class YetkiDAO {
    DBConnection instance = DBConnection.getInstance();

    public Yetki idBul(Long id) {
        Yetki y = null;

        try {
            PreparedStatement st = getConnection().prepareStatement("select * from yetki where yetki_id=?");
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();
            rs.next();

            y = new Yetki();
            y.setYetki_id(rs.getLong("yetki_id"));
            y.setGrup(rs.getString("grup"));


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return y;
    }

    public List<Yetki> listele() {
        List<Yetki> yetkiList = new ArrayList();
        try {
            PreparedStatement pst = getConnection().prepareStatement("select * from yetki");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Yetki tmp = new Yetki();
                tmp.setYetki_id(rs.getLong("yetki_id"));
                tmp.setGrup(rs.getString("grup"));
                yetkiList.add(tmp);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return yetkiList;
    }

    public void ekle(Yetki yetki) {
        try {
            PreparedStatement pst = getConnection().prepareStatement("insert into yetki (grup) values(?)");
            pst.setString(1, yetki.getGrup());
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void sil(Yetki yetki) {
        try {
            PreparedStatement pst = getConnection().prepareStatement("delete from yetki where yetki_id=?");
            pst.setLong(1, yetki.getYetki_id());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void duzelt(Yetki yetki) {
        try {
            PreparedStatement pst = getConnection().prepareStatement("update yetki set grup=? where yetki_id=?");
            pst.setString(1, yetki.getGrup());
            pst.setLong(2, yetki.getYetki_id());
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
