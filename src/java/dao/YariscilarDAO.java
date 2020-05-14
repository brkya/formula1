/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Yariscilar;
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
public class YariscilarDAO {
    DBConnection instance = DBConnection.getInstance();
    private TakimlarDAO takimDAO;
    
        public Yariscilar idBul(Long id) {
        Yariscilar y = null;

        try {
            PreparedStatement st = getConnection().prepareStatement("select * from yariscilar where yarisci_id=?");
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();
            rs.next();

            y = new Yariscilar();
            y.setYarisci_id(rs.getLong("yarisci_id"));
            y.setYarisci_adi(rs.getString("yarisci_adi"));
            y.setYarisci_soyadi(rs.getString("yarisci_soyadi"));
            y.setYas(rs.getInt("yas"));
            y.setDogum_yeri(rs.getString("dogum_yeri"));
            y.setPuan(rs.getInt("puan"));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return y;
    }

    public List<Yariscilar> listele() {
        List<Yariscilar> yarisciList = new ArrayList();

        try {
            PreparedStatement pst = getConnection().prepareStatement("select * from yariscilar");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Yariscilar tmp = new Yariscilar();
                tmp.setYarisci_id(rs.getLong("yarisci_id"));
                tmp.setYarisci_adi(rs.getString("yarisci_adi"));
                tmp.setYarisci_soyadi(rs.getString("yarisci_soyadi"));
                tmp.setYas(rs.getInt("yas"));
                tmp.setDogum_yeri(rs.getString("dogum_yeri"));
                tmp.setPuan(rs.getInt("puan"));
                tmp.setTakim(this.getTakim().idBul(rs.getLong("takim_id")));
                yarisciList.add(tmp);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return yarisciList;
    }

    public void ekle(Yariscilar yarisci) {
        try {

            PreparedStatement pst = getConnection().prepareStatement("insert into yariscilar (yarisci_adi,yarisci_soyadi,yas,dogum_yeri,puan,takim_id) values(?,?,?,?,?,?)");
            pst.setString(1, yarisci.getYarisci_adi());
            pst.setString(2, yarisci.getYarisci_soyadi());
            pst.setInt(3, yarisci.getYas());
            pst.setString(4, yarisci.getDogum_yeri());
            pst.setInt(5, yarisci.getPuan());
            pst.setLong(6, yarisci.getTakim().getTakim_id());
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void sil(Yariscilar yarisci) {
        try {
            PreparedStatement pst = getConnection().prepareStatement("delete from yariscilar where yarisci_id=?");
            pst.setLong(1, yarisci.getYarisci_id());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void duzelt(Yariscilar yarisci) {
        try {
            PreparedStatement pst = getConnection().prepareStatement("update yariscilar set yarisci_adi=?,yarisci_soyadi=?,yas=?,dogum_yeri=?,puan=?,takim_id=? where yarisci_id =?");
            pst.setString(1, yarisci.getYarisci_adi());
            pst.setString(2, yarisci.getYarisci_soyadi());
            pst.setInt(3, yarisci.getYas());
            pst.setString(4, yarisci.getDogum_yeri());
            pst.setInt(5, yarisci.getPuan());
            pst.setLong(6, yarisci.getTakim().getTakim_id());
            pst.setLong(7, yarisci.getYarisci_id());
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
        public List<Yariscilar> yarisdaYarisanlar(Long yaris_id) {
        List<Yariscilar> yarisdaYarisanlar = new ArrayList<>();

        try {
            PreparedStatement st = getConnection().prepareStatement("select * from yaris_yarisci where yaris_id=?");
            st.setLong(1, yaris_id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                yarisdaYarisanlar.add(this.idBul(rs.getLong("yarisci_id")));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return yarisdaYarisanlar;
    }

    public TakimlarDAO getTakim() {
        if (takimDAO == null) {
            this.takimDAO = new TakimlarDAO();
        }
        return takimDAO;
    }

}
