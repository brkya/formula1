/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PistlerDAO;
import entity.Pistler;
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
public class PistlerController implements Serializable {

    private List<Pistler> pistList;
    private PistlerDAO pistDAO;

    private Pistler pist;

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
        this.getPistlerDao().sil(this.pist);
        temizle();
        return "/panel/pist/pist";
    }

    public String onaylaSil(Pistler pist) {
        this.pist = pist;

        return "/panel/onayla/pistOnayla";
    }

    public void olustur() {
        this.pistDAO.ekle(this.pist);
        temizle();
    }

    public void formuGuncelle(Pistler pist) {
        this.pist = pist;
    }

    public void guncelle() {
        this.getPistlerDao().duzelt(this.pist);
        temizle();
    }

    public void temizle() {
        this.pist = new Pistler();
    }

    /*
    public List<Pistler> getPistlerList() {
        this.pistList = this.getPistlerDao().getPistler(sayfa, sayfaBoyutu, this.getTerimAra());
        return pistList;
    }
     */
    public List<Pistler> getPistlerList() {
        this.pistList = this.getPistlerDao().listele();
        return pistList;
    }

    public void setPistlerList(List<Pistler> pistList) {
        this.pistList = pistList;
    }

    public PistlerDAO getPistlerDao() {
        if (this.pistDAO == null) {
            this.pistDAO = new PistlerDAO();
        }
        return pistDAO;
    }

    public void setPistlerDao(PistlerDAO pistDAO) {
        this.pistDAO = pistDAO;
    }

    public Pistler getPistler() {
        if (this.pist == null) {
            this.pist = new Pistler();
        }
        return pist;
    }

    public void setPistler(Pistler pist) {
        this.pist = pist;
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
        this.sayfaSayısı = (int) Math.ceil(this.getPistlerDao().sayi(this.getTerimAra()) / (double) sayfaBoyutu);
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
