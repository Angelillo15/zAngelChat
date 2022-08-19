package es.angelillo15.zangelchat.config;

import es.angelillo15.zangelchat.utils.ColorUtils;

public class Messages {
    public static String reload(){
        return LoadConfig.getMessages().getConfig().getString("Reload");
    }
    public static String commandBlocked(){
        return ColorUtils.translateColorCodes(LoadConfig.getMessages().getConfig().getString("CommandBlocked"));
    }
    public static String playerOffline(){
        return ColorUtils.translateColorCodes(LoadConfig.getMessages().getConfig().getString("PlayerOffline"));
    }
    public static String msgFormat(){
        return LoadConfig.getMainConfig().getConfig().getString("Config.msgFormat");
    }
}
