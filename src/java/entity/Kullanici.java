/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;

/**
 *
 * @author Burak
 */
public class Kullanici {

    private Long kullanici_id;
    private String kullanici_adi;
    private String sifre;
    private String eposta;
    private Yetki yetki;

    public Kullanici() {
    }

    public Kullanici(Long kullanici_id, String kullanici_adi, String sifre, String eposta) {
        this.kullanici_id = kullanici_id;
        this.kullanici_adi = kullanici_adi;
        this.sifre = sifre;
        this.eposta = eposta;
    }

    public Long getKullanici_id() {
        return kullanici_id;
    }

    public void setKullanici_id(Long kullanici_id) {
        this.kullanici_id = kullanici_id;
    }

    public String getKullanici_adi() {
        return kullanici_adi;
    }

    public void setKullanici_adi(String kullanici_adi) {
        this.kullanici_adi = kullanici_adi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getEposta() {
        return eposta;
    }

    public void setEposta(String eposta) {
        this.eposta = eposta;
    }

    public Yetki getYetki() {
        if (this.yetki == null) {
            this.yetki = new Yetki();
        }
        return yetki;
    }

    public void setYetki(Yetki yetki) {
        this.yetki = yetki;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.kullanici_id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Kullanici other = (Kullanici) obj;
        if (!Objects.equals(this.kullanici_id, other.kullanici_id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Kullanici{" + "kullanici_id=" + kullanici_id + ", kullanici_adi=" + kullanici_adi + ", sifre=" + sifre + ", eposta=" + eposta + '}';
    }

}
