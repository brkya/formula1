
import dao.PistlerDAO;
import entity.Pistler;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Burak
 */
public class PistlerTest {
    Pistler pist = new Pistler();
    PistlerDAO pistDAO = new PistlerDAO();
    
    @Test
    public void ekleTest(){
        this.getPist().setPist_adi("Test");
        this.getPist().setTur_sayisi(123);
        this.getPist().setUlke("Test");
        this.getPistDAO().ekle(pist);
        List<Pistler> pistList = new ArrayList();
        pistList = this.getPistDAO().listele();
        int i = pistList.size();
        Pistler pistSon = pistList.get(i - 1);
        Assert.assertEquals(this.getPist().getPist_adi(), pistSon.getPist_adi());
        Assert.assertEquals(this.getPist().getTur_sayisi(), pistSon.getTur_sayisi());
        Assert.assertEquals(this.getPist().getUlke(), pistSon.getUlke());
        
        this.getPistDAO().sil(pistSon);
        
        
    }

    public Pistler getPist() {
        return pist;
    }

    public void setPist(Pistler pist) {
        this.pist = pist;
    }

    public PistlerDAO getPistDAO() {
        return pistDAO;
    }

    public void setPistDAO(PistlerDAO pistDAO) {
        this.pistDAO = pistDAO;
    }
    
    

}
