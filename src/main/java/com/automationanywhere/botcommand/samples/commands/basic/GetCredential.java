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
import static com.automationanywhere.commandsdk.model.AttributeType.CREDENTIAL;
import static com.automationanywhere.commandsdk.model.DataType.STRING;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import com.automationanywhere.core.security.SecureString;
//import MaskFormatter;

//import java.Math;
//import Math;

@BotCommand
@CommandPkg(label = "GetCredential",
        description = "Esta action retorna a credential como string", icon = "pkg.svg", name = "GetCredential",
        return_description = "", return_type = STRING, return_required = true)


public class GetCredential {

    @Execute
    public StringValue get_credential(
            @Idx(index = "1", type = CREDENTIAL)
            @Pkg(label = "Credential")
            @NotEmpty SecureString Credential
    ) {
        try{
            String crd = Credential.getInsecureString();
            return new StringValue(crd);
        }catch(Exception ex){
            return new StringValue(ex.getMessage());
        }       
    }
}
