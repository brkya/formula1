package entity;

import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Burak
 */
public class Takimlar {

    private Long takim_id;
    private String takim_adi;
    private String takim_merkezi;
    private String motor;

    private TakimKoclari takimKoclari;

    public Takimlar() {
    }

    public Takimlar(Long takim_id, String takim_adi, String takim_merkezi, String motor) {
        this.takim_id = takim_id;
        this.takim_adi = takim_adi;
        this.takim_merkezi = takim_merkezi;
        this.motor = motor;
    }

    public Long getTakim_id() {
        return takim_id;
    }

    public void setTakim_id(Long takim_id) {
        this.takim_id = takim_id;
    }

    public String getTakim_adi() {
        return takim_adi;
    }

    public void setTakim_adi(String takim_adi) {
        this.takim_adi = takim_adi;
    }

    public String getTakim_merkezi() {
        return takim_merkezi;
    }

    public void setTakim_merkezi(String takim_merkezi) {
        this.takim_merkezi = takim_merkezi;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    @Override
    public String toString() {
        return "Takimlar{" + "takim_id=" + takim_id + ", takim_adi=" + takim_adi + ", takim_merkezi=" + takim_merkezi + ", motor=" + motor + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.takim_id);
        return hash;
    }

    public TakimKoclari getTakimKoclari() {
        return takimKoclari;
    }

    public void setTakimKoclari(TakimKoclari takimKoclari) {
        this.takimKoclari = takimKoclari;
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
        final Takimlar other = (Takimlar) obj;
        if (!Objects.equals(this.takim_id, other.takim_id)) {
            return false;
        }
        return true;
    }



}
