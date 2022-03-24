import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.samples.commands.basic.LetterCalc;
import com.automationanywhere.botcommand.samples.commands.basic.XlsxSheetExport;
import org.testng.annotations.Test;


public class Teste {
    @Test
    public void teste(){
        LetterCalc a = new LetterCalc();

        StringValue ret = a.action("b",-1.0);
        System.out.println("Expected First Value: " + ret.toString());
    }
}