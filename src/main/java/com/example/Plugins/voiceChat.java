package com.example.Plugins;

import com.example.Bot;
import com.example.Master;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.voicechat.VoiceChatScheduled;

public class voiceChat extends Bot implements Master{

    @Override
    public void handleRequest(Update update, String cmd) {
        if(cmd.equals(getHandler()+"vc")){
            VoiceChatScheduled voiceChatScheduled = new VoiceChatScheduled();
            voiceChatScheduled.setStartDate(25/07/2021);

            sendMessage(update, "Scheduled Voice Chat");
        }
        
    }
    
    
}
