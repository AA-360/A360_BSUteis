package com.automationanywhere.botcommand.samples.commands.basic;

import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.botcommand.samples.commands.utils.WorkbookHelper;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.FileExtension;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.model.DataType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.text.MaskFormatter;
import java.io.*;
import java.text.ParseException;
import java.util.Iterator;

import static com.automationanywhere.commandsdk.model.AttributeType.FILE;
import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;
import static com.automationanywhere.commandsdk.model.DataType.STRING;

//import MaskFormatter;

//import java.Math;
//import Math;


//@BotCommand
@CommandPkg(
        label = "XlsxSheetExport",
        description = "Esta action Exporta uma sheet de um arquivo para outro",
        icon = "pkg.svg",
        name = "XlsxSheetExport",
        return_description = "",
        return_type = STRING,
        return_required = true
)


public class XlsxSheetExport {

    @Execute
    public void action(
            @Idx(index = "1", type = FILE)
            @Pkg(label = "XLSX file",description = "example: C:\\folder\\file.xlsx")
            @FileExtension("xlsx")
            @NotEmpty
                    String file,
            @Idx(index = "2", type = TEXT)
            @Pkg(label = "Insira o nome da sheet:")
            @NotEmpty
                    String sheetName

    ) {
        //================================================================= CREATE WORKBOOK OBJECT
        XSSFWorkbook myWorkBook = this.createXLSXWorkbook(file);
        System.out.println("FOI 1");
        //XSSFWorkbook myWorkBook2 = new XSSFWorkbook();
        //Sheet sh = myWorkBook2.createSheet("AGNIVJU");

        //myWorkBook.getSheet("AGNIVJU");

        int totalSheets = myWorkBook.getNumberOfSheets();
        System.out.println(totalSheets);
        for (int i = 1; i < totalSheets; i++ ) {
                myWorkBook.removeSheetAt(1);
        }


//        while(sheetIterator.hasNext()){
//            sheetNam = sheetIterator.next().getSheetName();
//            if(!sheetNam.equals("AGNIVJU")) {
//                idx = myWorkBook.getSheetIndex(sheetNam);
//                myWorkBook.removeSheetAt(idx);
//            }
//        }

        System.out.println("FOI 2");

        String filePath = "C:\\Users\\melque\\Documents\\excelFileName.xlsx";

        try {
            FileOutputStream outFile = new FileOutputStream(new File(filePath));
            myWorkBook.write(outFile);
            outFile.close();
        }catch (IOException e){

        }

    }
    private XSSFWorkbook createXLSXWorkbook(String file){

        try{
            File myFile = new File(file);
            if(!myFile.exists()){
                throw new BotCommandException("File '" + file + "' not found!");
            }
            FileInputStream fis = new FileInputStream(myFile);

            XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
            return myWorkBook;
        }catch (IOException e){
            throw new BotCommandException("Error reading/crearing xlsx file:" + e.getMessage());
        }
    }

    

}
