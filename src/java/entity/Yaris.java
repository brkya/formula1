/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Burak
 */
public class Yaris {

    private Long yaris_id;
    private String yaris_adi;
    private Date tarih;

    private Pistler pist;

    public Yaris() {
    }

    public Yaris(Long yaris_id, String yaris_adi, Date tarih) {
        this.yaris_id = yaris_id;
        this.yaris_adi = yaris_adi;
        this.tarih = tarih;
    }

    public Long getYaris_id() {
        return yaris_id;
    }

    public void setYaris_id(Long yaris_id) {
        this.yaris_id = yaris_id;
    }

    public String getYaris_adi() {
        return yaris_adi;
    }

    public void setYaris_adi(String yaris_adi) {
        this.yaris_adi = yaris_adi;
    }

    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    public Pistler getPist() {
        return pist;
    }

    public void setPist(Pistler pist) {
        this.pist = pist;
    }

    @Override
    public String toString() {
        return "Yaris{" + "yaris_id=" + yaris_id + ", yaris_adi=" + yaris_adi + ", tarih=" + tarih + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.yaris_id);
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
        final Yaris other = (Yaris) obj;
        if (!Objects.equals(this.yaris_id, other.yaris_id)) {
            return false;
        }
        return true;
    }

}
