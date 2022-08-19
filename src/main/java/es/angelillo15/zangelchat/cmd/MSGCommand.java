package es.angelillo15.zangelchat.cmd;

import es.angelillo15.zangelchat.config.Messages;
import es.angelillo15.zangelchat.utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class MSGCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("zac.msg")){
                if(!(args.length < 2)){
                    Player target = Bukkit.getPlayer(args[0]);;
                    if(target != null){
                        p.sendMessage(Messages.playerOffline());
                        return false;
                    }
                    String msg = "";
                    for (int i = 1; i < args.length; i++){
                        msg = msg + args[i]+ " ";
                    }
                    String finalMessage = Messages.msgFormat()
                            .replace("{target}", target.getDisplayName())
                            .replace("{sender}", p.getDisplayName())
                            .replace("{msg}", msg);
                    target.sendMessage(ColorUtils.translateColorCodes(finalMessage));
                }
            }
        }
        return false;
    }
}
