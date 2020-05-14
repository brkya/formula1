/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Burak
 */
public class YarisYariscilar {

    private Yaris yaris;
    private Yariscilar yarisci;
    private int siralama;
    private int puan;

    public YarisYariscilar() {
    }

    public YarisYariscilar(Yaris yaris, Yariscilar yarisci, int siralama, int puan) {
        this.yaris = yaris;
        this.yarisci = yarisci;
        this.siralama = siralama;
        this.puan = puan;
    }

    public Yaris getYaris() {
        return yaris;
    }

    public void setYaris(Yaris yaris) {
        this.yaris = yaris;
    }

    public Yariscilar getYarisci() {
        return yarisci;
    }

    public void setYarisci(Yariscilar yarisci) {
        this.yarisci = yarisci;
    }

    public int getSiralama() {
        return siralama;
    }

    public void setSiralama(int siralama) {
        this.siralama = siralama;
    }

    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }

    @Override
    public String toString() {
        return "YarisYariscilar{" + "yaris=" + yaris + ", yarisci=" + yarisci + ", siralama=" + siralama + ", puan=" + puan + '}';
    }

    

}
