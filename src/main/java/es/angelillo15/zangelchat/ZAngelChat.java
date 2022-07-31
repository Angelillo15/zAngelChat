package es.angelillo15.zangelchat;

import org.bukkit.plugin.java.JavaPlugin;

public final class ZAngelChat extends ZAngelChatManager {

    @Override
    public void onEnable() {
        // Plugin startup logic
        registerConfig();
        registerListeners();
        setupPermissions();
        registerCommands();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
