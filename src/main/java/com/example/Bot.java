package com.example;

import com.example.Plugins.voiceChat;
import com.example.Plugins.Greets.start;
import com.example.Plugins.info.me;
import com.example.config.keys;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot{

    @Override
    public void onUpdateReceived(Update update) {
        String cmd = update.getMessage().getText();
        sendRequest(update, cmd);
    }

    public void sendRequest(Update update, String cmd){
        if(cmd.startsWith(getHandler())){
            new start().handleRequest(update, cmd);
            new me().handleRequest(update, cmd);
            new voiceChat().handleRequest(update, cmd);
        }

    }

    public String chatID(Update update){
        return update.getMessage().getChatId().toString();
    }

    public Message sendMessage(Update update, String msg){
        try {
            SendMessage m = new SendMessage(update.getMessage().getChatId().toString(), msg);
            m.enableMarkdown(true);
            Message message = execute(m);
            return message;
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getHandler(){
        return keys.handler;
    }

    @Override
    public String getBotUsername() {
        return keys.botUserName;
    }

    @Override
    public String getBotToken() {
        return keys.botToken;
    }
    
}
