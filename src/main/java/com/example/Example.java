package com.example;

import it.tdlight.common.TelegramClient;
import it.tdlight.common.utils.CantLoadLibrary;
import it.tdlight.tdlight.ClientManager;
import it.tdlight.common.Init;
import it.tdlight.jni.TdApi;

public class Example {
    public static void main(String[] args) {
        // Initialize TDLight native libraries
        try {
            Init.start();
        } catch (CantLoadLibrary e) {
            e.printStackTrace();
        }

        // Create a client
        TelegramClient client = ClientManager.create();

        // Initialize the client
        client.initialize(Example::onUpdate, Example::onUpdateError, Example::onError);

        // Here you can use the client.

        // Documentation of tdlib methods can be found here:
        // https://tdlight-team.github.io/tdlight-docs
      
        // An example on how to use tdlight java can be found here:
        // https://github.com/tdlight-team/tdlight-java/blob/master/example/src/main/java/it.tdlight.example/Example.java

        // A similar example on how to use tdlib can be found here:
        // https://github.com/tdlib/td/blob/master/example/java/org/drinkless/tdlib/example/Example.java
    }

    private static void onUpdate(TdApi.Object object) {
        TdApi.Update update = (TdApi.Update) object;
        System.out.println("Received update: " + update);
    }

    private static void onUpdateError(Throwable exception) {
        System.out.println("Received an error from updates:");
        exception.printStackTrace();
    }

    private static void onError(Throwable exception) {
        System.out.println("Received an error:");
        exception.printStackTrace();
    }
}
