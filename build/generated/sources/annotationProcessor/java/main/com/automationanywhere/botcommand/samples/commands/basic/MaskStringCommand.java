package com.automationanywhere.botcommand.samples.commands.basic;

import com.automationanywhere.bot.service.GlobalSessionContext;
import com.automationanywhere.botcommand.BotCommand;
import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;
import java.lang.ClassCastException;
import java.lang.Deprecated;
import java.lang.Object;
import java.lang.String;
import java.lang.Throwable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class MaskStringCommand implements BotCommand {
  private static final Logger logger = LogManager.getLogger(MaskStringCommand.class);

  private static final Messages MESSAGES_GENERIC = MessagesFactory.getMessages("com.automationanywhere.commandsdk.generic.messages");

  @Deprecated
  public Optional<Value> execute(Map<String, Value> parameters, Map<String, Object> sessionMap) {
    return execute(null, parameters, sessionMap);
  }

  public Optional<Value> execute(GlobalSessionContext globalSessionContext,
      Map<String, Value> parameters, Map<String, Object> sessionMap) {
    logger.traceEntry(() -> parameters != null ? parameters.entrySet().stream().filter(en -> !Arrays.asList( new String[] {}).contains(en.getKey()) && en.getValue() != null).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)).toString() : null, ()-> sessionMap != null ?sessionMap.toString() : null);
    MaskString command = new MaskString();
    HashMap<String, Object> convertedParameters = new HashMap<String, Object>();
    if(parameters.containsKey("value") && parameters.get("value") != null && parameters.get("value").get() != null) {
      convertedParameters.put("value", parameters.get("value").get());
      if(convertedParameters.get("value") !=null && !(convertedParameters.get("value") instanceof String)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","value", "String", parameters.get("value").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("value") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","value"));
    }

    if(parameters.containsKey("mascara") && parameters.get("mascara") != null && parameters.get("mascara").get() != null) {
      convertedParameters.put("mascara", parameters.get("mascara").get());
      if(convertedParameters.get("mascara") !=null && !(convertedParameters.get("mascara") instanceof String)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","mascara", "String", parameters.get("mascara").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("mascara") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","mascara"));
    }

    if(parameters.containsKey("validChars") && parameters.get("validChars") != null && parameters.get("validChars").get() != null) {
      convertedParameters.put("validChars", parameters.get("validChars").get());
      if(convertedParameters.get("validChars") !=null && !(convertedParameters.get("validChars") instanceof String)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","validChars", "String", parameters.get("validChars").get().getClass().getSimpleName()));
      }
    }

    try {
      Optional<Value> result =  Optional.ofNullable(command.format_cpf((String)convertedParameters.get("value"),(String)convertedParameters.get("mascara"),(String)convertedParameters.get("validChars")));
      return logger.traceExit(result);
    }
    catch (ClassCastException e) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.IllegalParameters","format_cpf"));
    }
    catch (BotCommandException e) {
      logger.fatal(e.getMessage(),e);
      throw e;
    }
    catch (Throwable e) {
      logger.fatal(e.getMessage(),e);
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.NotBotCommandException",e.getMessage()),e);
    }
  }
}
