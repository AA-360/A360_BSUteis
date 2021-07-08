import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.ListValue;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.botcommand.samples.commands.basic.KeyBoardNCS;
import com.automationanywhere.botcommand.samples.commands.basic.StringJoinList;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StringJoinListTest {
    @Test
    public void teste(){
        StringJoinList a = new StringJoinList();



        ListValue<String> returnvalue = new ListValue<String>();
        ArrayList<String> vals = new ArrayList<String>();

        vals.add("ASD");
        vals.add("ASD");
        vals.add("ASD");
        vals.add("ASD");

        //returnvalue.set(vals);

        StringValue ret = a.action(";",vals);
        System.out.println("==================" + ret.toString());
    }
}