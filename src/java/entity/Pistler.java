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
public class Pistler {

    private Long pist_id;
    private String pist_adi;
    private int tur_sayisi;
    private String ulke;

    public Pistler() {
    }

    public Pistler(Long pist_id, String pist_adi, int tur_sayisi, String ulke) {
        this.pist_id = pist_id;
        this.pist_adi = pist_adi;
        this.tur_sayisi = tur_sayisi;
        this.ulke = ulke;
    }

    public Long getPist_id() {
        return pist_id;
    }

    public void setPist_id(Long pist_id) {
        this.pist_id = pist_id;
    }

    public String getPist_adi() {
        return pist_adi;
    }

    public void setPist_adi(String pist_adi) {
        this.pist_adi = pist_adi;
    }

    public int getTur_sayisi() {
        return tur_sayisi;
    }

    public void setTur_sayisi(int tur_sayisi) {
        this.tur_sayisi = tur_sayisi;
    }

    public String getUlke() {
        return ulke;
    }

    public void setUlke(String ulke) {
        this.ulke = ulke;
    }

    @Override
    public String toString() {
        return "Pistler{" + "pist_id=" + pist_id + ", pist_adi=" + pist_adi + ", tur_sayisi=" + tur_sayisi + ", ulke=" + ulke + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.pist_id);
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
        final Pistler other = (Pistler) obj;
        if (!Objects.equals(this.pist_id, other.pist_id)) {
            return false;
        }
        return true;
    }

}
