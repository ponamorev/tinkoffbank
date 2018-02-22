package com.andersenlab.ponamorev.tinkoffbank.data;

public class SavedObject {
    private static String header;

    public static String getHeader() {
        return header;
    }

    public static void setHeader(String header) {
        SavedObject.header = header;
    }
}