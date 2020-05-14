/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Yaris;
import java.sql.Connection;
import java.sql.Date;
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
public class YarisDAO {
    DBConnection instance = DBConnection.getInstance();
    private PistlerDAO pistDao;

    public Yaris idBul(Long id) {
        Yaris y = null;

        try {
            PreparedStatement st = getConnection().prepareStatement("select * from yaris where yaris_id=?");
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();
            rs.next();

            y = new Yaris();
            y.setYaris_id(rs.getLong("yaris_id"));
            y.setYaris_adi(rs.getString("yaris_adi"));
            y.setTarih(rs.getDate("tarih"));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return y;
    }

    public List<Yaris> listele() {
        List<Yaris> yarisList = new ArrayList();

        try {
            PreparedStatement pst = getConnection().prepareStatement("select * from yaris");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Yaris tmp = new Yaris();
                tmp.setYaris_id(rs.getLong("yaris_id"));
                tmp.setYaris_adi(rs.getString("yaris_adi"));
                tmp.setTarih(rs.getDate("tarih"));
                tmp.setPist(this.pistDao.idBul(rs.getLong("pist_id")));
                yarisList.add(tmp);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return yarisList;
    }

    public void ekle(Yaris yaris) {
        try {

            PreparedStatement pst = getConnection().prepareStatement("insert into yaris (yaris_adi,tarih,pist_id) values(?,?,?)");
            pst.setString(1, yaris.getYaris_adi());
            pst.setDate(2, (Date) yaris.getTarih());
            pst.setLong(3, yaris.getPist().getPist_id());
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void sil(Yaris yaris) {
        try {
            PreparedStatement pst = getConnection().prepareStatement("delete from yaris where yaris_id=?");
            pst.setLong(1, yaris.getYaris_id());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void duzelt(Yaris yaris) {
        try {
            PreparedStatement pst = getConnection().prepareStatement("update yarislar set yaris_adi=?,tarih=?,pist_id=? where yaris_id=?");
            pst.setString(1, yaris.getYaris_adi());
            pst.setDate(2, (Date) yaris.getTarih());
            pst.setLong(3, yaris.getPist().getPist_id());
            pst.setLong(4, yaris.getYaris_id());
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public PistlerDAO getPistDao() {
        if (pistDao == null) {
            this.pistDao = new PistlerDAO();
        }
        return pistDao;
    }

}
