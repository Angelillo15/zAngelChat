package es.angelillo15.zangelchat.config;

import es.angelillo15.zangelchat.ZAngelChatManager;
import es.angelillo15.zangelchat.utils.ColorUtils;
import org.bukkit.Bukkit;

public class LoadConfig {
    private static ConfigManager mainConfig;
    private static ConfigManager messages;
    private static ConfigManager blockedWords;
    private final ZAngelChatManager plugin;
    public LoadConfig(ZAngelChatManager plugin){
        this.plugin = plugin;
    }
    public void LoadMainConfig(){
        mainConfig = new ConfigManager(plugin, "", "config.yml");
        mainConfig.saveDefaultConfig();
    }

    public void loadBlockedWordsConfig(){
        blockedWords = new ConfigManager(plugin, "", "BlockedWords.yml");
        blockedWords.saveDefaultConfig();
    }

    public void loadMessages(){
        messages = new ConfigManager(plugin, "", "messages.yml");
        messages.saveDefaultConfig();
    }
    public void load(){
        LoadMainConfig();
        loadBlockedWordsConfig();
        loadMessages();
        Bukkit.getConsoleSender().sendMessage("Loading Config");
    }

    public void reload(){
        mainConfig.reloadConfig();
        mainConfig.reloadConfig();
        messages.reloadConfig();
        messages.saveConfig();
        blockedWords.reloadConfig();
        blockedWords.saveConfig();
        Bukkit.getConsoleSender().sendMessage(ColorUtils.translateColorCodes(plugin.getPrefix() + "&7Plugin reloaded"));
    }
    public static ConfigManager getMainConfig() {
        return mainConfig;
    }

    public static ConfigManager getMessages() {
        return messages;
    }

    public static ConfigManager getBlockedWords() {
        return blockedWords;
    }

}
