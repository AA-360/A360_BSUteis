import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.samples.commands.basic.FormatCNPJ;
import com.automationanywhere.botcommand.samples.commands.basic.XlsxSheetExport;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.Test;



public class ExportSheetTest {
    @Test
    public void teste(){



        XlsxSheetExport a = new XlsxSheetExport();


        a.action("C:\\Users\\melque\\Documents\\teste3.xlsx","asd");
        System.out.println("==================");
        System.out.println("Expected First Value: ");
    }
}