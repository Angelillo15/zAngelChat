package es.angelillo15.zangelchat.cmd.MainSC;

import es.angelillo15.zangelchat.ZAngelChatManager;
import es.angelillo15.zangelchat.cmd.SubCommand;
import es.angelillo15.zangelchat.config.Messages;
import es.angelillo15.zangelchat.utils.ColorUtils;
import org.bukkit.entity.Player;

public class SCReload extends SubCommand {
    private ZAngelChatManager plugin;
    public SCReload (ZAngelChatManager plugin){
        this.plugin = plugin;
    }
    @Override
    public String getName() {
        return "reload";
    }

    @Override
    public String getDescription() {
        return "command to reload the plugin";
    }

    @Override
    public String getSyntax() {
        return "/zac reload";
    }

    @Override
    public String getPermission() {
        return "zac.reload";
    }

    @Override
    public void execute(Player player, String[] args) {
        if(player.hasPermission(getPermission()) || player.hasPermission("zac.reload")){
            plugin.reload();
            player.sendMessage(ColorUtils.translateColorCodes(Messages.reload()));
        }
    }
}
