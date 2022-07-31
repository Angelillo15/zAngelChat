package es.angelillo15.zangelchat.config;

import es.angelillo15.zangelchat.ZAngelChat;
import es.angelillo15.zangelchat.ZAngelChatManager;
import es.angelillo15.zangelchat.utils.ColorUtils;
import org.bukkit.Bukkit;

public class LoadConfig {
    private static ConfigManager MainConfig;
    private static ConfigManager Messages;
    private static ConfigManager blockedWords;
    private final ZAngelChatManager plugin;
    public LoadConfig(ZAngelChatManager plugin){
        this.plugin = plugin;
    }
    public void LoadMainConfig(){
        MainConfig = new ConfigManager(plugin, "", "config.yml");
        MainConfig.saveDefaultConfig();
    }

    public void loadBlockedWordsConfig(){
        blockedWords = new ConfigManager(plugin, "", "BlockedWords.yml");
        blockedWords.saveDefaultConfig();
    }
    public void load(){
        LoadMainConfig();
        loadBlockedWordsConfig();
        Bukkit.getConsoleSender().sendMessage("Loading Config");
    }

    public void reload(){
        MainConfig.reloadConfig();
        MainConfig.reloadConfig();
        Messages.reloadConfig();
        Messages.saveConfig();
        blockedWords.reloadConfig();
        blockedWords.saveConfig();
        Bukkit.getConsoleSender().sendMessage(ColorUtils.translateColorCodes(plugin.getPrefix() + "&7Plugin reloaded"));
    }
    public static ConfigManager getMainConfig() {
        return MainConfig;
    }

    public static ConfigManager getMessages() {
        return Messages;
    }

    public static ConfigManager getBlockedWords() {
        return blockedWords;
    }

}
