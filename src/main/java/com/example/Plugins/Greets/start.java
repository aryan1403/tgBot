package com.example.Plugins.Greets;

import com.example.Bot;
import com.example.Master;

import org.telegram.telegrambots.meta.api.objects.Update;

public class start extends Bot implements Master{

    @Override
    public void handleRequest(Update update, String cmd) {
        if(cmd.equalsIgnoreCase(getHandler()+"start")){
            sendMessage(update, "Hey ["+update.getMessage().getFrom().getFirstName()+"](tg://user?id="+update.getMessage().getFrom().getId());
        }
    }
}
