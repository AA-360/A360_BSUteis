package com.automationanywhere.botcommand.samples.commands.basic;

import com.automationanywhere.bot.service.GlobalSessionContext;
import com.automationanywhere.botcommand.BotCommand;
import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.model.table.Table;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;
import java.lang.ClassCastException;
import java.lang.Deprecated;
import java.lang.Double;
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

public final class TableColumnFormCommand implements BotCommand {
  private static final Logger logger = LogManager.getLogger(TableColumnFormCommand.class);

  private static final Messages MESSAGES_GENERIC = MessagesFactory.getMessages("com.automationanywhere.commandsdk.generic.messages");

  @Deprecated
  public Optional<Value> execute(Map<String, Value> parameters, Map<String, Object> sessionMap) {
    return execute(null, parameters, sessionMap);
  }

  public Optional<Value> execute(GlobalSessionContext globalSessionContext,
      Map<String, Value> parameters, Map<String, Object> sessionMap) {
    logger.traceEntry(() -> parameters != null ? parameters.entrySet().stream().filter(en -> !Arrays.asList( new String[] {}).contains(en.getKey()) && en.getValue() != null).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)).toString() : null, ()-> sessionMap != null ?sessionMap.toString() : null);
    TableColumnForm command = new TableColumnForm();
    HashMap<String, Object> convertedParameters = new HashMap<String, Object>();
    if(parameters.containsKey("Tabela") && parameters.get("Tabela") != null && parameters.get("Tabela").get() != null) {
      convertedParameters.put("Tabela", parameters.get("Tabela").get());
      if(convertedParameters.get("Tabela") !=null && !(convertedParameters.get("Tabela") instanceof Table)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","Tabela", "Table", parameters.get("Tabela").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("Tabela") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","Tabela"));
    }

    if(parameters.containsKey("i_colunas") && parameters.get("i_colunas") != null && parameters.get("i_colunas").get() != null) {
      convertedParameters.put("i_colunas", parameters.get("i_colunas").get());
      if(convertedParameters.get("i_colunas") !=null && !(convertedParameters.get("i_colunas") instanceof String)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","i_colunas", "String", parameters.get("i_colunas").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("i_colunas") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","i_colunas"));
    }

    if(parameters.containsKey("i_columnName") && parameters.get("i_columnName") != null && parameters.get("i_columnName").get() != null) {
      convertedParameters.put("i_columnName", parameters.get("i_columnName").get());
      if(convertedParameters.get("i_columnName") !=null && !(convertedParameters.get("i_columnName") instanceof String)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","i_columnName", "String", parameters.get("i_columnName").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("i_columnName") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","i_columnName"));
    }

    if(parameters.containsKey("i_idx") && parameters.get("i_idx") != null && parameters.get("i_idx").get() != null) {
      convertedParameters.put("i_idx", parameters.get("i_idx").get());
      if(convertedParameters.get("i_idx") !=null && !(convertedParameters.get("i_idx") instanceof Double)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","i_idx", "Double", parameters.get("i_idx").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("i_idx") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","i_idx"));
    }

    if(parameters.containsKey("code") && parameters.get("code") != null && parameters.get("code").get() != null) {
      convertedParameters.put("code", parameters.get("code").get());
      if(convertedParameters.get("code") !=null && !(convertedParameters.get("code") instanceof String)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","code", "String", parameters.get("code").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("code") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","code"));
    }

    try {
      Optional<Value> result =  Optional.ofNullable(command.action((Table)convertedParameters.get("Tabela"),(String)convertedParameters.get("i_colunas"),(String)convertedParameters.get("i_columnName"),(Double)convertedParameters.get("i_idx"),(String)convertedParameters.get("code")));
      return logger.traceExit(result);
    }
    catch (ClassCastException e) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.IllegalParameters","action"));
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
