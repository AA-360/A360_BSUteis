import com.automationanywhere.botcommand.data.impl.ListValue;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.botcommand.samples.commands.basic.ReplaceInFile;
import org.testng.annotations.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class ReplaceInFileTest {
    @Test
    public void teste(){
        System.out.println("==================INICIO======================");
        ReplaceInFile a = new ReplaceInFile();
        a.action("C:/Temp/08052021_PENDENCIAS_EM_ABERTO.txt","","","-1",true);

        System.out.println("==================FIM======================");
        //System.out.println("Expected First Value: " + values.get(1));
    }
}