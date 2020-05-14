/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Kullanici;
import entity.Yetki;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;
import static util.DBConnection.getConnection;

/**
 *
 * @author Burak
 */
public class KullaniciDAO {

    DBConnection instance = DBConnection.getInstance();
    YetkiDAO yetkiDAO;

    public Kullanici giris(String kullanici_adi, String sifre) {
        Kullanici kul = null;
        try {

            String q = "select * from kullanici where kullanici_adi=? and sifre=?";
            PreparedStatement pst = getConnection().prepareStatement(q);
            pst.setString(1, kullanici_adi);
            pst.setString(2, sifre);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                kul = new Kullanici();
                kul.setKullanici_id(rs.getLong("kullanici_id"));
                kul.setKullanici_adi(rs.getString("kullanici_adi"));
                kul.setSifre(rs.getString("sifre"));
                kul.setEposta(rs.getString("eposta"));
                kul.setYetki(this.yetkiBul(rs.getLong("yetki_id")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return kul;

    }

    public List<Kullanici> listele() {
        List<Kullanici> kullaniciList = new ArrayList();
        try {
            PreparedStatement pst = getConnection().prepareStatement("select * from kullanici");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Kullanici tmp = new Kullanici();
                tmp.setKullanici_id(rs.getLong("kullanici_id"));
                tmp.setKullanici_adi(rs.getString("kullanici_adi"));
                tmp.setSifre(rs.getString("sifre"));
                kullaniciList.add(tmp);
                tmp.setYetki(this.getYetkiDAO().idBul(rs.getLong("yetki_id")));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return kullaniciList;
    }

    public Yetki yetkiBul(Long id) {
        Yetki yet = null;
        try {
            String q = "select * from yetki where yetki_id=?";
            PreparedStatement pst = getConnection().prepareStatement(q);
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();

            rs.next();

            yet = new Yetki();
            yet.setYetki_id(rs.getLong("yetki_id"));
            yet.setGrup(rs.getString("grup"));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return yet;
    }

    public void ekle(Kullanici kullanici) {
        try {
            PreparedStatement pst = getConnection().prepareStatement("insert into kullanici (kullanici_adi,sifre,eposta) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, kullanici.getKullanici_adi());
            pst.setString(2, kullanici.getSifre());
            pst.setString(3, kullanici.getEposta());

            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void sil(Kullanici kullanici) {
        try {
            PreparedStatement pst = getConnection().prepareStatement("delete from kullanici where kullanici_id=?");
            pst.setLong(1, kullanici.getKullanici_id());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void guncelle(Kullanici kullanici) {

        try {
            PreparedStatement pst = getConnection().prepareStatement("update kullanici set kullanici_adi=?,sifre=?,eposta=?,yetki_id=? where kullanici_id=?");
            pst.setString(1, kullanici.getKullanici_adi());
            pst.setString(2, kullanici.getSifre());
            pst.setString(3, kullanici.getEposta());
            pst.setLong(4, kullanici.getYetki().getYetki_id());
            pst.setLong(5, kullanici.getKullanici_id());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public YetkiDAO getYetkiDAO() {
        if (this.yetkiDAO == null) {
            this.yetkiDAO = new YetkiDAO();
        }
        return yetkiDAO;
    }
}
