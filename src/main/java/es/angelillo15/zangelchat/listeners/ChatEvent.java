package es.angelillo15.zangelchat.listeners;

import es.angelillo15.zangelchat.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEvent implements Listener {

    @EventHandler
    public void playerChatEvent(AsyncPlayerChatEvent e){
        Player player = e.getPlayer();
        String message = MessageUtils.getFinalMessage(player, e.getMessage());
        for (Player people : Bukkit.getOnlinePlayers()){
            people.sendMessage(message);
        }
        Bukkit.getConsoleSender().sendMessage(message);
        e.setCancelled(true);
    }
}
