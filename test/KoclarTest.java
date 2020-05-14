
import dao.TakimKoclariDAO;
import entity.TakimKoclari;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Burak
 */
public class KoclarTest {

    public TakimKoclari koc = new TakimKoclari();
    public TakimKoclariDAO kocDAO = new TakimKoclariDAO();

    @Test
    public void ekleTest() {
        this.getKoc().setKoc_adi("Test kodu");
        this.getKoc().setKoc_soyadi("Test");
        this.getKoc().setYas(123);
        this.getKoc().setDogum_yeri("Test");
        this.getKocDAO().ekle(koc);
        List<TakimKoclari> kocList = new ArrayList();
        kocList = this.getKocDAO().listele();
        int i = kocList.size();
        TakimKoclari kocSon = kocList.get(i - 1);
        Assert.assertEquals(this.getKoc().getKoc_adi(), kocSon.getKoc_adi());
        Assert.assertEquals(this.getKoc().getKoc_soyadi(), kocSon.getKoc_soyadi());
        Assert.assertEquals(this.getKoc().getYas(), kocSon.getYas());
        Assert.assertEquals(this.getKoc().getDogum_yeri(), kocSon.getDogum_yeri());
        
        this.getKocDAO().sil(kocSon);
    }

    public TakimKoclari getKoc() {
        return koc;
    }

    public void setKoc(TakimKoclari koc) {
        this.koc = koc;
    }

    public TakimKoclariDAO getKocDAO() {
        return kocDAO;
    }

    public void setKocDAO(TakimKoclariDAO kocDAO) {
        this.kocDAO = kocDAO;
    }

}
