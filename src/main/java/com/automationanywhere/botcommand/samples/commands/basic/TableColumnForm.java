package com.automationanywhere.botcommand.samples.commands.basic;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.data.impl.TableValue;
import com.automationanywhere.botcommand.data.model.Schema;
import com.automationanywhere.botcommand.data.model.table.Row;
import com.automationanywhere.botcommand.data.model.table.Table;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.botcommand.samples.commands.utils.FindInListSchema;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.CodeType;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.model.AttributeType;
import com.automationanywhere.commandsdk.model.DataType;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.automationanywhere.commandsdk.model.AttributeType.NUMBER;
import static com.automationanywhere.commandsdk.model.AttributeType.TABLE;
import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;
import static com.automationanywhere.commandsdk.model.DataType.*;

@BotCommand
@CommandPkg(label = "TableColumnForm",
        description = "Inclusao de uma nova coluna calculada", icon = "pkg.svg", name = "TableColumnForm",
        return_description = "", return_type = DataType.TABLE, return_required = true)


public class TableColumnForm {

    @Execute
    public TableValue action(
            @Idx(index = "1", type = TABLE)
            @Pkg(label = "Tabela")
            @NotEmpty
            Table Tabela,
            @Idx(index = "2", type = TEXT)
            @Pkg(label = "Colunas de Entrada",description = "Colunas a serem inseridas no tratamento Ex:'COl1|COL2'")
            @NotEmpty
            String i_colunas,
            @Idx(index = "3", type = TEXT)
            @Pkg(label = "Nome da nova Coluna",description = "Insira o nome da nova coluna gerada!")
            @NotEmpty
            String i_columnName,
            @Idx(index = "4", type = NUMBER)
            @Pkg(label = "Posição da nova coluna na tabela: (index)",default_value_type = DataType.NUMBER,default_value = "0")
            @NotEmpty
            Double i_idx,
            @Idx(index = "5", type = AttributeType.CODE)
            @Pkg(label = "javaScript Code",description = "sua função deve se chamar 'calc' obrigatoriamente ")
            @CodeType(value = "text/javascript")
            @NotEmpty
            String code
    ) {

        //========================================================== LITURA DO JS
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        try{
            engine.eval(code);
            //engine.eval(Files.newBufferedReader(Paths.get("C:/Temp/js.js"), StandardCharsets.UTF_8));
        }
        catch (Exception e){
            throw new BotCommandException("Error when trying to load Js code!");
        }
        //============================================================ CHECKING COLUMNS
        List<Schema> SCHEMAS = Tabela.getSchema();
        FindInListSchema fnd = new FindInListSchema(SCHEMAS);
        List<String> SCHEMA_NAMES = new ArrayList();


        SCHEMA_NAMES = Arrays.asList(i_colunas.split("\\|"));
        for (String sc : SCHEMA_NAMES) {
            if (!fnd.exists(sc)) {
                throw new BotCommandException("Column '" + sc + "' not found!");
            }
        }
        List<Integer> SCHEMA_IDX = fnd.indexSchema(SCHEMA_NAMES);

        //============================================================ RUN CALC
        Invocable inv = (Invocable) engine;
        List<Row> newTbl = new ArrayList();
        int counter = 0;


        for(Row rw: Tabela.getRows()){
            counter ++;
            Object params[] = {};
            List<Value> RowListValues = rw.getValues();

            //ADCIONA OS PARAMETROS DA LINHA
            for(Integer i: SCHEMA_IDX){
                String val = RowListValues.get(i).toString();
                params = append(params,val);
            }
            //EXECUTA A FORMULA
            try{
                String newValue = inv.invokeFunction("calc", params).toString();

                RowListValues.add(i_idx.intValue(),new StringValue(newValue));
                Row newRow = new Row(RowListValues);

                newTbl.add(newRow);
                System.out.println(newValue);
            }
            catch (Exception e){
                throw new BotCommandException("Error calling method 'calc': row " + counter + "");
            }
        }

        Table tbl = new Table();
        TableValue OUTPUT = new TableValue();
        tbl.setRows(newTbl);
        fnd.addSchema(i_idx.intValue(),i_columnName);
        tbl.setSchema(fnd.schemas);
        OUTPUT.set(tbl);

        return OUTPUT;

    }
    static <T> T[] append(T[] arr, T element) {
        final int N = arr.length;
        arr = Arrays.copyOf(arr, N + 1);
        arr[N] = element;
        return arr;
    }
}
