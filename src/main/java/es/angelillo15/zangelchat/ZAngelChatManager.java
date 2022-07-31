package es.angelillo15.zangelchat;

import es.angelillo15.zangelchat.cmd.MainCommand;
import es.angelillo15.zangelchat.config.LoadConfig;
import es.angelillo15.zangelchat.listeners.ChatEvent;
import jdk.nashorn.internal.runtime.regexp.joni.Config;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import net.milkbowl.vault.permission.Permission;

public class ZAngelChatManager extends JavaPlugin {
    private LoadConfig lc;
    public static Permission perms = null;
    PluginDescriptionFile pdf = this.getDescription();
    public String version = pdf.getVersion();
    public String prefix = "&bzAngelChat &8&l»";

    void registerListeners(){
        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new ChatEvent(), this);
    }
    void registerConfig(){
        lc = new LoadConfig(this);
        lc.load();
    }
    void setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        assert rsp != null;
        perms = rsp.getProvider();
    }
    void registerCommands(){
        this.getCommand("zac").setExecutor(new MainCommand(this));
    }
    public String getPrefix(){
        return this.prefix;
    }
    public void reload(){
        this.lc.reload();
    }

}
