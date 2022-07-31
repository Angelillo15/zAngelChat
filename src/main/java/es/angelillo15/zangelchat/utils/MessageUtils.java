package es.angelillo15.zangelchat.utils;

import es.angelillo15.zangelchat.ZAngelChat;
import es.angelillo15.zangelchat.config.LoadConfig;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.List;

public class MessageUtils {
    public static boolean isPluginEnabled() {
        return Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI");
    }

    public static String parsePlaceHolders(String message, Player player) {
        if (isPluginEnabled()) {
            return PlaceholderAPI.setPlaceholders(player, message);
        }
        return message;
    }

    public static String colorCodes(String message, Player player) {
        if (player.hasPermission("zAngelChat.colourWrite")) {
            return ColorUtils.translateColorCodes(message);
        }
        return message.replace("&", "");
    }

    public static String getFinalMessage(Player player, String message) {
        FileConfiguration c = LoadConfig.getMainConfig().getConfig();
        String format = c.getString("Config.ChatFormat.Groups." + ZAngelChat.perms.getPrimaryGroup(player));
        assert format != null;
        String formatParsed = parsePlaceHolders(format, player);
        return ColorUtils.translateColorCodes(parseBlockWords(
                formatParsed.replace("{msg}", colorCodes(message, player))
                        .replace("{player}", player.getName()), player));
    }

    public static String parseBlockWords(String message, Player player) {
        FileConfiguration blockedWords = LoadConfig.getBlockedWords().getConfig();
        List<String> list = blockedWords.getStringList("BlockedWords.list");
        if (!player.hasPermission("AChatManager.notBlocked")) {
            for (int i = 0; i < list.size(); i++) {
                if (message.toLowerCase().contains(list.get(i))) {
                    String star = "";
                    for (int j = 0; j < list.get(i).length(); j++) {
                        star = star + "*";
                    }
                    return message.replace(list.get(i), star);
                }
            }
        }
        return message;
    }
}
