package es.angelillo15.zangelchat.config;

public class Messages {
    public static String reload(){
        return LoadConfig.getMessages().getConfig().getString("Reload");
    }
}
