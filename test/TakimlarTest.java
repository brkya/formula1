
import dao.TakimKoclariDAO;
import dao.TakimlarDAO;
import entity.TakimKoclari;
import entity.Takimlar;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Burak
 */
public class TakimlarTest {

    public Takimlar takim = new Takimlar();
    public TakimlarDAO takimDAO = new TakimlarDAO();
    public TakimKoclari koc = new TakimKoclari();
    public TakimKoclariDAO kocDAO = new TakimKoclariDAO();


    @Test
    public void takimEkleTest() {

        this.getTakim().setTakim_adi("Test kodu");
        this.getTakim().setTakim_merkezi("Test");
        this.getTakim().setMotor("Test");
        this.getTakim().setTakimKoclari(kocDAO.idBul(1L));
        this.getTakimDAO().ekle(takim);
        List<Takimlar> takimList = new ArrayList();
        takimList = this.getTakimDAO().listele();
        int i = takimList.size();
        Takimlar takimSon = takimList.get(i - 1);
        Assert.assertEquals(this.getTakim().getTakim_adi(), takimSon.getTakim_adi());
        Assert.assertEquals(this.getTakim().getTakim_merkezi(), takimSon.getTakim_merkezi());
        Assert.assertEquals(this.getTakim().getMotor(), takimSon.getMotor());
    }

    public Takimlar getTakim() {
        return takim;
    }

    public void setTakim(Takimlar takim) {
        this.takim = takim;
    }

    public TakimlarDAO getTakimDAO() {
        return takimDAO;
    }

    public void setTakimDAO(TakimlarDAO takimDAO) {
        this.takimDAO = takimDAO;
    }

}
