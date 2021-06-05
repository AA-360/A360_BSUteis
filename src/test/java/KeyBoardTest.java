import com.automationanywhere.botcommand.samples.commands.basic.KeyBoardNCS;
import org.testng.annotations.Test;

public class KeyBoardTest {
    @Test
    public void teste(){
        KeyBoardNCS a = new KeyBoardNCS();
        a.action("S",false);
        System.out.println("==================");
    }
}