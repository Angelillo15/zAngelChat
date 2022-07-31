package es.angelillo15.zangelchat.config;

public class Messages {
    public static String reload(){
        return LoadConfig.getMainConfig().getConfig().getString("Reload");
    }
}
