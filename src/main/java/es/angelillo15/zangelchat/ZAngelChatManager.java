package es.angelillo15.zangelchat;

import es.angelillo15.zangelchat.cmd.MainCommand;
import es.angelillo15.zangelchat.config.LoadConfig;
import es.angelillo15.zangelchat.listeners.ChatEvent;
import es.angelillo15.zangelchat.listeners.PlayerJoin;
import es.angelillo15.zangelchat.listeners.PlayerQuit;
import es.angelillo15.zangelchat.listeners.PreMsgCommandEvent;
import es.angelillo15.zangelchat.utils.ColorUtils;
import jdk.nashorn.internal.runtime.regexp.joni.Config;
import org.bukkit.Bukkit;
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
    public String prefix = "&bzAngelChat &8&l» ";

    void registerListeners(){
        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new ChatEvent(), this);
        if(LoadConfig.getMainConfig().getConfig().getBoolean("Config.chatJoinLeaveAnnouncer")){
            pm.registerEvents(new PlayerJoin(), this);
            pm.registerEvents(new PlayerQuit(), this);
        }
        pm.registerEvents(new PreMsgCommandEvent(), this);
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

    void drawLogo(){
        Bukkit.getConsoleSender().sendMessage(ColorUtils.translateColorCodes("\n" +
                "&b&l     ,.              .  ,-. .       .   \n" +
                "&b&l    /  \\             | /    |       |   \n" +
                "&b&l,-, |--| ;-. ,-: ,-. | |    |-. ,-: |-  \n" +
                "&b&l /  |  | | | | | |-' | \\    | | | | |   \n" +
                "&b&l'-' '  ' ' ' `-| `-' '  `-' ' ' `-` `-' \n" +
                "&b&l             `-'                        \n" +
                "                           &bversion: "+version));
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
