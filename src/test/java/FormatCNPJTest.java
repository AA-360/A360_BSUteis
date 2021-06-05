import com.automationanywhere.botcommand.data.impl.DictionaryValue;
import com.automationanywhere.botcommand.data.impl.NumberValue;
import com.automationanywhere.botcommand.samples.commands.basic.FormatCNPJ;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.automationanywhere.botcommand.data.impl.StringValue;

import java.util.HashMap;
import java.util.Map;

public class FormatCNPJTest {
    @Test
    public void teste(){
        FormatCNPJ a = new FormatCNPJ();
        StringValue date = a.action("37001056000170");
        System.out.println("==================");
        System.out.println("Expected First Value: " + date);
    }
}