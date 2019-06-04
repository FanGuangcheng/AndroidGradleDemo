package com.addtimestamp;

public class Config {
    private static Config sInstance = new Config();

    public AddTimeStampExtension extension;
    public static Config getInstance() {
        return sInstance;
    }
}
