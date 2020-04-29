/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TakimlarDAO;
import entity.Takimlar;
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
public class TakimlarController implements Serializable {
    
    
    private List<Takimlar> takimList;
    private TakimlarDAO takimDAO;

    private Takimlar takim;

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
        this.getTakimlarDao().sil(this.takim);
        temizle();
        return "/panel/takim/takim";
    }

    public String onaylaSil(Takimlar takim) {
        this.takim = takim;

        return "/panel/onayla/takimOnayla";
    }

    public void olustur() {
        this.takimDAO.ekle(this.takim);
        temizle();
    }

    public void formuGuncelle(Takimlar takim) {
        this.takim = takim;
    }

    public void guncelle() {
        this.getTakimlarDao().duzelt(this.takim);
        temizle();
    }

    public void temizle() {
        this.takim = new Takimlar();
    }

    /*
    public List<Takimlar> getTakimlarList() {
        this.takimList = this.getTakimlarDao().getTakimlar(sayfa, sayfaBoyutu, this.getTerimAra());
        return takimList;
    }
     */
    public List<Takimlar> getTakimlarList() {
        this.takimList = this.getTakimlarDao().listele();
        return takimList;
    }

    public void setTakimlarList(List<Takimlar> takimList) {
        this.takimList = takimList;
    }

    public TakimlarDAO getTakimlarDao() {
        if (this.takimDAO == null) {
            this.takimDAO = new TakimlarDAO();
        }
        return takimDAO;
    }

    public void setTakimlarDao(TakimlarDAO takimDAO) {
        this.takimDAO = takimDAO;
    }

    public Takimlar getTakimlar() {
        if (this.takim == null) {
            this.takim = new Takimlar();
        }
        return takim;
    }

    public void setTakimlar(Takimlar takim) {
        this.takim = takim;
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
        this.sayfaSayısı = (int) Math.ceil(this.getTakimlarDao().sayi(this.getTerimAra()) / (double) sayfaBoyutu);
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
