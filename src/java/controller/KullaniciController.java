/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.KullaniciDAO;
import dao.YetkiDAO;
import entity.Kullanici;
import entity.Yetki;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Burak
 */
@Named
@ViewScoped
public class KullaniciController implements Serializable{
    private List<Kullanici> kullaniciList;
    private KullaniciDAO kullaniciDAO;

    private Kullanici kullanici;

    private List<Yetki> yetkiList;
    private YetkiDAO yetkiDAO;

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
        this.getKullaniciDao().sil(this.kullanici);
        temizle();
        return "/panel/kullanici/kullanici";
    }

    public String onaylaSil(Kullanici kullanici) {
        this.kullanici = kullanici;

        return "/panel/onayla/kullaniciOnayla";
    }

    public void olustur() {
        this.getKullaniciDao().ekle(this.kullanici);
        temizle();
    }

    public void formuGuncelle(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    public void guncelle() {
        this.getKullaniciDao().guncelle(this.kullanici);
        temizle();
    }

    public void temizle() {
        this.kullanici = new Kullanici();
    }

    /*
    public List<Kullanici> getKullaniciList() {
        this.kullaniciList = this.getKullaniciDao().getKullanici(sayfa, sayfaBoyutu, this.getTerimAra());
        return kullaniciList;
    }
     */
    public List<Kullanici> getKullaniciList() {
        this.kullaniciList = this.getKullaniciDao().listele();
        return kullaniciList;
    }

    public void setKullaniciList(List<Kullanici> kullaniciList) {
        this.kullaniciList = kullaniciList;
    }

    public KullaniciDAO getKullaniciDao() {
        if (this.kullaniciDAO == null) {
            this.kullaniciDAO = new KullaniciDAO();
        }
        return kullaniciDAO;
    }

    public void setKullaniciDao(KullaniciDAO kullaniciDAO) {
        this.kullaniciDAO = kullaniciDAO;
    }

    public Kullanici getKullanici() {
        if (this.kullanici == null) {
            this.kullanici = new Kullanici();
        }
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
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
        this.sayfaSayısı = (int) Math.ceil(this.getKullaniciDao().sayi(this.getTerimAra()) / (double) sayfaBoyutu);
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

    public List<Yetki> getYetkiList() {
        this.yetkiList = this.getYetkiDAO().listele();
        return yetkiList;
    }

    public void setYetkiList(List<Yetki> yetkiList) {
        this.yetkiList = yetkiList;
    }

    public YetkiDAO getYetkiDAO() {
        if (this.yetkiDAO==null) {
            this.yetkiDAO = new YetkiDAO();
        }
        return yetkiDAO;
    }

    public void setYetkiDAO(YetkiDAO yetkiDAO) {
        this.yetkiDAO = yetkiDAO;
    }
    
    
}
