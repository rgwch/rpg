import ch.rgw.rpg.Generator;
import ch.rgw.rpg.Lipsum;
import ch.rgw.rpg.Namen;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by gerry on 09.05.16.
 */
public class rpgTest {

    @Test
    public void testName(){
        Namen namen=new Namen();
        Assert.assertTrue(namen.getRandomNachname().length()>3);
        Assert.assertTrue(namen.getRandomVorname().length()>3);
    }

    @Test
    public void testLipsum(){
        Lipsum lipsum=new Lipsum();
        Assert.assertTrue(lipsum.getSentence().length()>10);
        Assert.assertTrue(lipsum.getParagraph().length()>10);

    }

    @Test
    public void testGenerator(){
        Generator g=new Generator();
        String vn=g.getRandomFirstname();
        String ln=g.getRandomLastname();
        String bd=g.getRandomBirthdate();
        String street=g.getRandomStreet();
        String zip=g.getRandomZip();
        String place=g.getRandomCity();
        String phone=g.getRandomPhoneNumber();
        System.out.println(vn+" "+ln+", "+bd+", "+street+", "+zip+" "+place+", "+phone);

    }
}
