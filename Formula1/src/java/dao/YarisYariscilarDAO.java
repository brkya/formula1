/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.YarisYariscilar;
import entity.Yariscilar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author Burak
 */
public class YarisYariscilarDAO {

    private DBConnection connector;
    private Connection connection;

    private YarisDAO yarisDAO;
    private YariscilarDAO yarisciDAO;

    public List<YarisYariscilar> listele() {
        List<YarisYariscilar> yarisYarisciList = new ArrayList();

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from yaris_yariscilar ");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                YarisYariscilar tmp = new YarisYariscilar();
                tmp.setYaris(this.yarisDAO.idBul(rs.getLong("yaris_id")));
                tmp.setYarisci((Yariscilar) this.yarisciDAO.yarisdaYarisanlar(tmp.getYaris().getYaris_id()));
                tmp.setSiralama(rs.getInt("siralama"));
                tmp.setPuan(rs.getInt("puan"));
                yarisYarisciList.add(tmp);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return yarisYarisciList;
    }

   /* 
    public void ekle(YarisYariscilar yarisYarisci) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("insert into yarisYarisciler (yarisYarisci_adi,tur_sayisi,ulke) values(?,?,?)");
            pst.setString(1, yarisYarisci.getPist_adi());
            pst.setInt(2, yarisYarisci.getTur_sayisi());
            pst.setString(3, yarisYarisci.getUlke());
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void sil(YarisYariscilar yarisYarisci) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from yarisYarisciler where yarisYarisci_id=?");
            pst.setLong(1, yarisYarisci.getPist_id());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
*/
    public DBConnection getConnector() {
        if (this.connector == null) {
            this.connector = new DBConnection();
        }
        return connector;
    }

    public Connection getConnection() {
        if (this.connection == null) {
            this.connection = this.getConnector().connect();
        }
        return connection;
    }

    public YarisDAO getYarisDAO() {
        if (yarisDAO == null) {
            this.yarisDAO = new YarisDAO();
        }
        return yarisDAO;
    }

    public YariscilarDAO getYarisciDAO() {
        if (yarisciDAO == null) {
            this.yarisciDAO = new YariscilarDAO();
        }
        return yarisciDAO;
    }

}
