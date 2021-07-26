package com.example.Plugins.info;

import java.io.File;
import java.util.List;
import com.example.Bot;
import com.example.Master;
import org.telegram.telegrambots.meta.api.methods.GetFile;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.UserProfilePhotos;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class me extends Bot implements Master {

    @Override
    public void handleRequest(Update update, String cmd) {
        if(cmd.equalsIgnoreCase(getHandler()+"me")){
            sendMessage(update, "Getting info..");
            User user = update.getMessage().getFrom();

            UserProfilePhotos userProfilePhotos = new UserProfilePhotos();
            List<List<PhotoSize>> list = userProfilePhotos.getPhotos();

            int no_ofDP = list.size();

            List<PhotoSize> photos = list.get(0);

            PhotoSize photo = null;

            sendMessage(update, "First Name : "+user.getFirstName()+
            "\n"+ "ID : "+user.getId()+"\n"+"Number of profile pics : "+no_ofDP
            +"\n"+ "Link to profile : ["+user.getFirstName()+"](tg://user?id="+user.getId());

            for(int i = 0;i < photos.size();i++){
                for (int j = 0; j < photos.size(); j++) {
                    if(list.get(i).size() >= list.get(j).size()) photo = photos.get(i);
                }
            }

            if(photo==null){
                sendMessage(update, "First Name : "+user.getFirstName()+
                "\n"+ "ID : "+user.getId()+"\n"+"Number of profile pics : "+no_ofDP
                +"\n"+ "Link to profile : ["+user.getFirstName()+"](tg://user?id="+user.getId());

            }

            else{
                GetFile getFile = new GetFile(photo.getFileId());
                try {
                    org.telegram.telegrambots.meta.api.objects.File file = execute(getFile);
                    File f = downloadFile(file);
                    InputFile inputFile = new InputFile();
                    inputFile.setMedia(f);
                    SendPhoto sendPhoto = new SendPhoto(chatID(update), inputFile);
                    sendPhoto.setCaption("First Name : "+user.getFirstName()+
                    "\n"+ "ID : "+user.getId()+"\n"+"Number of profile pics : "+no_ofDP
                    +"\n"+ "Link to profile : ["+user.getFirstName()+"](tg://user?id="+user.getId());
                    execute(sendPhoto);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                
            }

        }
        
    }

}
