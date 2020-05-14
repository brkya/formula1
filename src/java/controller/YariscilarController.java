/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TakimlarDAO;
import dao.YariscilarDAO;
import entity.Takimlar;
import entity.Yariscilar;
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
public class YariscilarController implements Serializable{  
    private List<Yariscilar> yarisciList;
    private YariscilarDAO yarisciDAO;

    private Yariscilar yarisci;
    
    private List<Takimlar> takimList;
    private TakimlarDAO takimDAO;

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
        this.getYariscilarDao().sil(this.yarisci);
        temizle();
        return "/panel/yarisci/yarisci";
    }

    public String onaylaSil(Yariscilar yarisci) {
        this.yarisci = yarisci;

        return "/panel/onayla/yarisciOnayla";
    }

    public void olustur() {
        this.yarisciDAO.ekle(this.yarisci);
        temizle();
    }

    public void formuGuncelle(Yariscilar yarisci) {
        this.yarisci = yarisci;
    }

    public void guncelle() {
        this.getYariscilarDao().duzelt(this.yarisci);
        temizle();
    }

    public void temizle() {
        this.yarisci = new Yariscilar();
    }

    /*
    public List<Yariscilar> getYariscilarList() {
        this.yarisciList = this.getYariscilarDao().getYariscilar(sayfa, sayfaBoyutu, this.getTerimAra());
        return yarisciList;
    }
     */
    public List<Yariscilar> getYariscilarList() {
        this.yarisciList = this.getYariscilarDao().listele();
        return yarisciList;
    }

    public void setYariscilarList(List<Yariscilar> yarisciList) {
        this.yarisciList = yarisciList;
    }

    public YariscilarDAO getYariscilarDao() {
        if (this.yarisciDAO == null) {
            this.yarisciDAO = new YariscilarDAO();
        }
        return yarisciDAO;
    }

    public void setYariscilarDao(YariscilarDAO yarisciDAO) {
        this.yarisciDAO = yarisciDAO;
    }

    public Yariscilar getYariscilar() {
        if (this.yarisci == null) {
            this.yarisci = new Yariscilar();
        }
        return yarisci;
    }

    public void setYariscilar(Yariscilar yarisci) {
        this.yarisci = yarisci;
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
        this.sayfaSayısı = (int) Math.ceil(this.getYariscilarDao().sayi(this.getTerimAra()) / (double) sayfaBoyutu);
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

    public List<Takimlar> getTakimList() {
        this.takimList = this.getTakimDAO().listele();
        return takimList;
    }

    public void setTakimList(List<Takimlar> takimList) {
        this.takimList = takimList;
    }

    public TakimlarDAO getTakimDAO() {
        if (this.takimDAO==null) {
            this.takimDAO = new TakimlarDAO();
        }
        return takimDAO;
    }

    public void setTakimDAO(TakimlarDAO takimDAO) {
        this.takimDAO = takimDAO;
    }
    
    
    
}
