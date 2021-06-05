/*
 * Copyright (c) 2020 Automation Anywhere.
 * All rights reserved.
 *
 * This software is the proprietary information of Automation Anywhere.
 * You shall use it only in accordance with the terms of the license agreement
 * you entered into with Automation Anywhere.
 */

/**
 *
 */
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
@CommandPkg(label = "FormatCPF",
        description = "Esta action formata uma string para o formato de CPF!", icon = "pkg.svg", name = "FormatCPF",
        return_description = "", return_type = STRING, return_required = true)


public class FormatCPF {

    @Execute
    public StringValue format_cpf(
            @Idx(index = "1", type = TEXT)
            @Pkg(label = "VALOR")
            @NotEmpty String value
    ) {


        MaskFormatter mask;
        try{
            mask = new MaskFormatter("###.###.###-##");
            mask.setValidCharacters( "1234567890" );
            mask.setValueContainsLiteralCharacters(false);
            return new StringValue(mask.valueToString(value));
        }
        catch(ParseException ex){
            return new StringValue(ex.getMessage());
        }

        //mf.valueToString(value);
        //MaskFormatter ibanMaskFormatter = new MaskFormatter(IBAN_MASK,"");
        //StringBuilder sbuf = new StringBuilder();
        //Formatter fmt = new Formatter(sbuf);
        //fmt.format("PI = %f%n", Math.PI);


        
    }
    

    

}
