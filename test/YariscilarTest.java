
import dao.YariscilarDAO;
import entity.Yariscilar;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Burak
 */
public class YariscilarTest {

    Yariscilar yarisci = new Yariscilar();
    YariscilarDAO yarisciDAO = new YariscilarDAO();

    @Test
    public void ekleTest() {
        this.getYarisci().setYarisci_adi("Test");
        this.getYarisci().setYarisci_soyadi("Test");
        this.getYarisci().setYas(123);
        this.getYarisci().setDogum_yeri("Test");
        this.getYarisci().setPuan(123);
        this.getYarisciDAO().ekle(yarisci);
        List<Yariscilar> yarisciList = new ArrayList();
        yarisciList = this.getYarisciDAO().listele();
        int i = yarisciList.size();
        Yariscilar yarisciSon = yarisciList.get(i - 1);
        Assert.assertEquals(this.getYarisci().getYarisci_adi(), yarisciSon.getYarisci_adi());
        Assert.assertEquals(this.getYarisci().getYarisci_soyadi(), yarisciSon.getYarisci_soyadi());
        Assert.assertEquals(this.getYarisci().getYas(), yarisciSon.getYas());
        Assert.assertEquals(this.getYarisci().getDogum_yeri(), yarisciSon.getDogum_yeri());
        Assert.assertEquals(this.getYarisci().getPuan(), yarisciSon.getPuan());

        this.getYarisciDAO().sil(yarisciSon);

    }

    public Yariscilar getYarisci() {
        return yarisci;
    }

    public void setYarisci(Yariscilar yarisci) {
        this.yarisci = yarisci;
    }

    public YariscilarDAO getYarisciDAO() {
        return yarisciDAO;
    }

    public void setYarisciDAO(YariscilarDAO yarisciDAO) {
        this.yarisciDAO = yarisciDAO;
    }

}
