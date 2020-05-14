/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.YarisDAO;
import entity.Yaris;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Burak
 */

@Named
@SessionScoped
public class YarisController implements Serializable{
    private List<Yaris> yarisList;
    private YarisDAO yarisDAO;

    private Yaris yaris;

    private int sayfa = 1;
    private int sayfaBoyutu = 10;
    private int sayfaSayısı;

    private String terimAra;

    public void ara() {
        this.setSayfa(1);
    }

    public void aramaTemizle() {
        this.setTerimAra(null);
    }

    /*   -----------------> Daha sonra aktif hala getireceğim
    public void ileri() {
        if (this.sayfa == this.getSayfaSayısı()) {
            this.sayfa = 1;
        } else {
            this.sayfa++;
        }

    }
     
    public void geri() {
        if (this.sayfa == 1) {
            this.sayfa = this.getSayfaSayısı();
        } else {
            this.sayfa--;
        }
    }
     */
    public String Sil() {
        this.getYarisDao().sil(this.yaris);
        temizle();
        return "/panel/yaris/yaris";
    }

    public String onaylaSil(Yaris yaris) {
        this.yaris = yaris;

        return "/panel/onayla/yarisOnayla";
    }

    public void olustur() {
        this.yarisDAO.ekle(this.yaris);
        temizle();
    }

    public void formuGuncelle(Yaris yaris) {
        this.yaris = yaris;
    }

    public void guncelle() {
        this.getYarisDao().duzelt(this.yaris);
        temizle();
    }

    public void temizle() {
        this.yaris = new Yaris();
    }

    /*
    public List<Yaris> getYarisList() {
        this.yarisList = this.getYarisDao().getYaris(sayfa, sayfaBoyutu, this.getTerimAra());
        return yarisList;
    }
     */
    public List<Yaris> getYarisList() {
        this.yarisList = this.getYarisDao().listele();
        return yarisList;
    }

    public void setYarisList(List<Yaris> yarisList) {
        this.yarisList = yarisList;
    }

    public YarisDAO getYarisDao() {
        if (this.yarisDAO == null) {
            this.yarisDAO = new YarisDAO();
        }
        return yarisDAO;
    }

    public void setYarisDao(YarisDAO yarisDAO) {
        this.yarisDAO = yarisDAO;
    }

    public Yaris getYaris() {
        if (this.yaris == null) {
            this.yaris = new Yaris();
        }
        return yaris;
    }

    public void setYaris(Yaris yaris) {
        this.yaris = yaris;
    }

    public int getSayfa() {
        return sayfa;
    }

    public void setSayfa(int sayfa) {
        this.sayfa = sayfa;
    }

    public int getSayfaBoyutu() {
        return sayfaBoyutu;
    }

    public void setSayfaBoyutu(int sayfaBoyutu) {
        this.sayfaBoyutu = sayfaBoyutu;
    }

    /*
    public int getSayfaSayısı() {
        this.sayfaSayısı = (int) Math.ceil(this.getYarisDao().sayi(this.getTerimAra()) / (double) sayfaBoyutu);
        return sayfaSayısı;
    }
     */
    public void setSayfaSayısı(int sayfaSayısı) {
        this.sayfaSayısı = sayfaSayısı;
    }

    public String getTerimAra() {
        return terimAra;
    }

    public void setTerimAra(String terimAra) {
        this.terimAra = terimAra;
    }
}
