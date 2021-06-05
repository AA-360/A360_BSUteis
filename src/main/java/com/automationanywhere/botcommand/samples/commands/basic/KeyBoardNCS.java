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
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.model.AttributeType;

import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.text.ParseException;

import static com.automationanywhere.commandsdk.model.AttributeType.BOOLEAN;
import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;
import static com.automationanywhere.commandsdk.model.DataType.STRING;
//import MaskFormatter;

//import java.Math;
//import Math;

@BotCommand
@CommandPkg(label = "KeyBoardNCW",
        description = "Esta action habilita/desabilita o NUMLOCK e CAPSLOCK", icon = "pkg.svg", name = "KeyBoardNCW",
        return_description = "", return_type = STRING, return_required = true)


public class KeyBoardNCS {

    @Execute
    public void action(
            @Idx(index = "1", type = AttributeType.SELECT, options = {
                    @Idx.Option(index ="1.1", pkg = @Pkg(label = "NUMLOCK", value = "N")),
                    @Idx.Option(index ="1.2", pkg = @Pkg(label = "CAPSLOCK", value = "C")),
                    @Idx.Option(index ="1.3", pkg = @Pkg(label = "SCROLLLOCK", value = "S"))
            })
            @Pkg(label = "Key",default_value_type = STRING,default_value = "C")
            @NotEmpty
            String select,
            @Idx(index = "2", type = BOOLEAN)
            @Pkg(label = "Status", description = "true-> Habilitar | false-> Desabilitar")
            @NotEmpty
            Boolean status
    ) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int Key = (select.equals("C")?KeyEvent.VK_CAPS_LOCK: (select.equals("N")?KeyEvent.VK_NUM_LOCK:KeyEvent.VK_SCROLL_LOCK));

        toolkit.setLockingKeyState(Key, status);
    }
    

    

}
