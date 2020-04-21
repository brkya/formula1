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
public class TakimKoclari {

    private Long koc_id;
    private String koc_adi;
    private String koc_soyadi;
    private int yas;
    private String dogum_yeri;

    public TakimKoclari() {
    }

    public TakimKoclari(Long koc_id, String koc_adi, String koc_soyadi, int yas, String dogum_yeri) {
        this.koc_id = koc_id;
        this.koc_adi = koc_adi;
        this.koc_soyadi = koc_soyadi;
        this.yas = yas;
        this.dogum_yeri = dogum_yeri;
    }

    public Long getKoc_id() {
        return koc_id;
    }

    public void setKoc_id(Long koc_id) {
        this.koc_id = koc_id;
    }

    public String getKoc_adi() {
        return koc_adi;
    }

    public void setKoc_adi(String koc_adi) {
        this.koc_adi = koc_adi;
    }

    public String getKoc_soyadi() {
        return koc_soyadi;
    }

    public void setKoc_soyadi(String koc_soyadi) {
        this.koc_soyadi = koc_soyadi;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public String getDogum_yeri() {
        return dogum_yeri;
    }

    public void setDogum_yeri(String dogum_yeri) {
        this.dogum_yeri = dogum_yeri;
    }

    @Override
    public String toString() {
        return "TakimKoclari{" + "koc_id=" + koc_id + ", koc_adi=" + koc_adi + ", koc_soyadi=" + koc_soyadi + ", yas=" + yas + ", dogum_yeri=" + dogum_yeri + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.koc_id);
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
        final TakimKoclari other = (TakimKoclari) obj;
        if (!Objects.equals(this.koc_id, other.koc_id)) {
            return false;
        }
        return true;
    }

}
