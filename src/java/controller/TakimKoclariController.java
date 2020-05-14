/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TakimKoclariDAO;
import entity.TakimKoclari;
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
public class TakimKoclariController implements Serializable {

    private List<TakimKoclari> kocList;
    private TakimKoclariDAO kocDAO;

    private TakimKoclari koc;

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
        this.getTakimKoclariDao().sil(this.koc);
        temizle();
        return "/panel/koc/koc";
    }

    public String onaylaSil(TakimKoclari koc) {
        this.koc = koc;

        return "/panel/onayla/kocOnayla";
    }

    public void olustur() {
        this.kocDAO.ekle(this.koc);
        temizle();
    }

    public void formuGuncelle(TakimKoclari koc) {
        this.koc = koc;
    }

    public void guncelle() {
        this.getTakimKoclariDao().duzelt(this.koc);
        temizle();
    }

    public void temizle() {
        this.koc = new TakimKoclari();
    }

    /*
    public List<TakimKoclari> getTakimKoclariList() {
        this.kocList = this.getTakimKoclariDao().getTakimKoclari(sayfa, sayfaBoyutu, this.getTerimAra());
        return kocList;
    }
     */
    public List<TakimKoclari> getTakimKoclariList() {
        this.kocList = this.getTakimKoclariDao().listele();
        return kocList;
    }

    public void setTakimKoclariList(List<TakimKoclari> kocList) {
        this.kocList = kocList;
    }

    public TakimKoclariDAO getTakimKoclariDao() {
        if (this.kocDAO == null) {
            this.kocDAO = new TakimKoclariDAO();
        }
        return kocDAO;
    }

    public void setTakimKoclariDao(TakimKoclariDAO kocDAO) {
        this.kocDAO = kocDAO;
    }

    public TakimKoclari getTakimKoclari() {
        if (this.koc == null) {
            this.koc = new TakimKoclari();
        }
        return koc;
    }

    public void setTakimKoclari(TakimKoclari koc) {
        this.koc = koc;
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
        this.sayfaSayısı = (int) Math.ceil(this.getTakimKoclariDao().sayi(this.getTerimAra()) / (double) sayfaBoyutu);
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
