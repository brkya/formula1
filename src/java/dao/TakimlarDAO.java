/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Takimlar;
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
public class TakimlarDAO {
    DBConnection instance = DBConnection.getInstance();
    private TakimKoclariDAO kocDAO;

    public Takimlar idBul(Long id) {
        Takimlar t = null;

        try {
            PreparedStatement st = getConnection().prepareStatement("select * from takimlar where takim_id=?");
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();
            rs.next();

            t = new Takimlar();
            t.setTakim_id(rs.getLong("takim_id"));
            t.setTakim_adi(rs.getString("takim_adi"));
            t.setTakim_merkezi(rs.getString("takim_merkezi"));
            t.setMotor(rs.getString("motor"));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return t;
    }

    public List<Takimlar> listele() {
        List<Takimlar> takimList = new ArrayList();

        try {
            PreparedStatement pst = getConnection().prepareStatement("select * from takimlar");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Takimlar tmp = new Takimlar();
                tmp.setTakim_id(rs.getLong("takim_id"));
                tmp.setTakim_adi(rs.getString("takim_adi"));
                tmp.setTakim_merkezi(rs.getString("takim_merkezi"));
                tmp.setMotor(rs.getString("motor"));
                tmp.setTakimKoclari(this.getKocDAO().idBul(rs.getLong("koc_id")));
                takimList.add(tmp);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return takimList;
    }

    public void ekle(Takimlar takim) {
        try {

            PreparedStatement pst = getConnection().prepareStatement("insert into takimlar (takim_adi,takim_merkezi,motor,koc_id) values(?,?,?,?)");
            pst.setString(1, takim.getTakim_adi());
            pst.setString(2, takim.getTakim_merkezi());
            pst.setString(3, takim.getMotor());
            pst.setLong(4, takim.getTakimKoclari().getKoc_id());
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void sil(Takimlar takim) {
        try {
            PreparedStatement pst = getConnection().prepareStatement("delete from takimlar where takim_id=?");
            pst.setLong(1, takim.getTakim_id());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void duzelt(Takimlar takim) {
        try {
            PreparedStatement pst = getConnection().prepareStatement("update takimlar set takim_adi=?,takim_merkezi=?,motor=?,koc_id=? where takim_id=?");
            pst.setString(1, takim.getTakim_adi());
            pst.setString(2, takim.getTakim_merkezi());
            pst.setString(3, takim.getMotor());
            pst.setLong(4, takim.getTakimKoclari().getKoc_id());
            pst.setLong(5, takim.getTakim_id());
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public TakimKoclariDAO getKocDAO() {
        if (kocDAO == null) {
            this.kocDAO = new TakimKoclariDAO();
        }
        return kocDAO;
    }

}
