package es.angelillo15.zangelchat.listeners;

import es.angelillo15.zangelchat.config.LoadConfig;
import es.angelillo15.zangelchat.config.Messages;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.List;

public class PreMsgCommandEvent implements Listener {
    @EventHandler
    public void onMSG(PlayerCommandPreprocessEvent e){
        List<String> commandBlocked = LoadConfig.getMainConfig().getConfig().getStringList("Config.blockedCommands");
        for (String s : commandBlocked){
            if(e.getMessage().startsWith(s)) {
                e.getPlayer().sendMessage(Messages.commandBlocked());
                e.setCancelled(true);
            }
        }
    }
}
