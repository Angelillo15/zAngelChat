package es.angelillo15.zangelchat.listeners;

import es.angelillo15.zangelchat.ZAngelChatManager;
import es.angelillo15.zangelchat.config.LoadConfig;
import es.angelillo15.zangelchat.config.Messages;
import es.angelillo15.zangelchat.utils.ColorUtils;
import es.angelillo15.zangelchat.utils.MessageUtils;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        FileConfiguration c = LoadConfig.getMainConfig().getConfig();
        Permission perms = ZAngelChatManager.perms;
        String msg;
        if(c.contains("Config.ChatJoinMessage.Groups."+perms.getPrimaryGroup(e.getPlayer()))){
            msg = MessageUtils.parsePlaceHolders(c.getString("Config.ChatJoinMessage.Groups."+perms.getPrimaryGroup(e.getPlayer())), e.getPlayer());
        }else{
            msg = MessageUtils.parsePlaceHolders(c.getString("Config.ChatJoinMessage.Groups.default"), e.getPlayer());
        }
        e.setJoinMessage(ColorUtils.translateColorCodes(msg));
    }
}
