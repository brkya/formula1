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
public class Yariscilar {

    private Long yarisci_id;
    private String yarisci_adi;
    private String yarisci_soyadi;
    private int yas;
    private String dogum_yeri;
    private int puan;

    private Takimlar takim;

    public Yariscilar() {
    }

    public Yariscilar(Long yarisci_id, String yarisci_adi, String yarisci_soyadi, int yas, String dogum_yeri, int puan) {
        this.yarisci_id = yarisci_id;
        this.yarisci_adi = yarisci_adi;
        this.yarisci_soyadi = yarisci_soyadi;
        this.yas = yas;
        this.dogum_yeri = dogum_yeri;
        this.puan = puan;
    }

    public Long getYarisci_id() {
        return yarisci_id;
    }

    public void setYarisci_id(Long yarisci_id) {
        this.yarisci_id = yarisci_id;
    }

    public String getYarisci_adi() {
        return yarisci_adi;
    }

    public void setYarisci_adi(String yarisci_adi) {
        this.yarisci_adi = yarisci_adi;
    }

    public String getYarisci_soyadi() {
        return yarisci_soyadi;
    }

    public void setYarisci_soyadi(String yarisci_soyadi) {
        this.yarisci_soyadi = yarisci_soyadi;
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

    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }

    public Takimlar getTakim() {
        return takim;
    }

    public void setTakim(Takimlar takim) {
        this.takim = takim;
    }

    @Override
    public String toString() {
        return "Yariscilar{" + "yarisci_id=" + yarisci_id + ", yarisci_adi=" + yarisci_adi + ", yarisci_soyadi=" + yarisci_soyadi + ", yas=" + yas + ", dogum_yeri=" + dogum_yeri + ", puan=" + puan + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.yarisci_id);
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
        final Yariscilar other = (Yariscilar) obj;
        if (!Objects.equals(this.yarisci_id, other.yarisci_id)) {
            return false;
        }
        return true;
    }

}
