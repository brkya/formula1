
import dao.YarisDAO;
import entity.Yaris;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Burak
 */
public class YarisTest {
    Yaris yaris = new Yaris();
    YarisDAO yarisDAO = new YarisDAO();
    
    @Test
    public void ekleTest(){
        this.getYaris().setYaris_adi("Test");
        this.getYaris().getPist().setPist_id(1L);
        //this.getYaris().setTarih("05-05-2020");
        this.getYarisDAO().ekle(yaris);      
        List<Yaris> yarisList = new ArrayList();
        yarisList = this.getYarisDAO().listele();
        int i = yarisList.size();
        Yaris yarisSon = yarisList.get(i - 1);
        Assert.assertEquals(this.getYaris().getYaris_adi(), yarisSon.getYaris_adi());
        Assert.assertEquals(this.getYaris().getPist().getPist_id(), yarisSon.getPist().getPist_id());
        Assert.assertEquals(this.getYaris().getTarih(), yarisSon.getTarih());

        this.getYarisDAO().sil(yarisSon);
        
    }

    public Yaris getYaris() {
        return yaris;
    }

    public void setYaris(Yaris yaris) {
        this.yaris = yaris;
    }

    public YarisDAO getYarisDAO() {
        return yarisDAO;
    }

    public void setYarisDAO(YarisDAO yarisDAO) {
        this.yarisDAO = yarisDAO;
    }
    
    
    
}
