package com.automationanywhere.botcommand.samples.commands.basic;

import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.GreaterThanEqualTo;
import com.automationanywhere.commandsdk.annotations.rules.MatchesRegex;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.model.DataType;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;

import static com.automationanywhere.commandsdk.model.AttributeType.NUMBER;
import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;
import static com.automationanywhere.commandsdk.model.DataType.STRING;

//import MaskFormatter;

//import java.Math;
//import Math;

@BotCommand
@CommandPkg(
        label = "LetterCalc",
        description = "Esta action soma ou subtrai um numero de uma letra\n Exemplo: B-1 = A, D-2 = B, A-1 = ",
        icon = "pkg.svg",
        name = "LetterCalc",
        return_description = "",
        return_type = STRING,
        return_required = true
)


public class LetterCalc {

    @Execute
    public StringValue action(
            @Idx(index = "1", type = TEXT)
            @Pkg(label = "Letra", description = "a,A,b,C")
            @MatchesRegex("\\w{1}")
            @NotEmpty String value,

            @Idx(index = "2", type = NUMBER)
            @Pkg(label = "Numero")
            @NotEmpty Double number

    ) {
        int Letra = (int) value.charAt(0);
        String novaLetra = Character.toString((char) Letra + number.intValue());
        return new StringValue(novaLetra);

    }
}
