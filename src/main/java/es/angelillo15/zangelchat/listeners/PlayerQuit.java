package es.angelillo15.zangelchat.listeners;

import es.angelillo15.zangelchat.ZAngelChatManager;
import es.angelillo15.zangelchat.config.LoadConfig;
import es.angelillo15.zangelchat.utils.ColorUtils;
import es.angelillo15.zangelchat.utils.MessageUtils;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {
    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        FileConfiguration c = LoadConfig.getMainConfig().getConfig();
        Permission perms = ZAngelChatManager.perms;
        String msg;
        if(c.contains("Config.ChatJoinMessage.Groups."+perms.getPrimaryGroup(e.getPlayer()))){
            msg = MessageUtils.parsePlaceHolders(c.getString("Config.ChatLeaveMessage.Groups."+perms.getPrimaryGroup(e.getPlayer())), e.getPlayer());
        }else{
            msg = MessageUtils.parsePlaceHolders(c.getString("Config.ChatLeaveMessage.Groups.default"), e.getPlayer());
        }
        e.setQuitMessage(ColorUtils.translateColorCodes(msg));
    }
}
