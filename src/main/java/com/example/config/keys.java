package com.example.config;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvBuilder;

public class keys {
    private static final Dotenv dotenv = new DotenvBuilder().ignoreIfMissing().load();

    public static String botToken = dotenv.get("bottoken");
    public static String botUserName = dotenv.get("botusername");
    public static String handler = dotenv.get("handler");
}
