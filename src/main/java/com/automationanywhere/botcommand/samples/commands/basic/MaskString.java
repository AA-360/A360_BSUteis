package com.automationanywhere.botcommand.samples.commands.basic;

import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.CommandPkg;
import com.automationanywhere.commandsdk.annotations.Execute;
import com.automationanywhere.commandsdk.annotations.Idx;
import com.automationanywhere.commandsdk.annotations.Pkg;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.model.AttributeType;
import com.automationanywhere.commandsdk.model.DataType;
import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;
import static com.automationanywhere.commandsdk.model.DataType.STRING;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;

//import MaskFormatter;

//import java.Math;
//import Math;

@BotCommand
@CommandPkg(label = "MaskString",
        description = "Esta action formata uma string para o formato predefinido", icon = "pkg.svg", name = "MaskString",
        return_description = "", return_type = STRING, return_required = true)


public class MaskString {

    @Execute
    public StringValue format_cpf(
            @Idx(index = "1", type = TEXT)
            @Pkg(label = "VALOR")
            @NotEmpty String value,

            @Idx(index = "2", type = TEXT)
            @Pkg(label = "MASCARA")
            @NotEmpty String mascara,

            @Idx(index = "3", type = TEXT)
            @Pkg(label = "Caracteres válidos",default_value = "ALL", default_value_type = DataType.STRING)
            String validChars

    ) {

        MaskFormatter mask;
        try{
            mask = new MaskFormatter(mascara);
            if(validChars != "ALL"){
                mask.setValidCharacters( validChars ); 
            }
            mask.setValueContainsLiteralCharacters(false);

            return new StringValue(mask.valueToString(value));
        }
        catch(ParseException ex){
            return new StringValue(ex.getMessage());
        }       
    }
    

    

}
