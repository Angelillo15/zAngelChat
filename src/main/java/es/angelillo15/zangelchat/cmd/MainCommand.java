package es.angelillo15.zangelchat.cmd;

import es.angelillo15.zangelchat.ZAngelChatManager;
import es.angelillo15.zangelchat.cmd.MainSC.SCReload;
import es.angelillo15.zangelchat.utils.ColorUtils;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class MainCommand implements CommandExecutor {
    private final ArrayList<SubCommand> subCommands = new ArrayList<>();
    private final ArrayList<SubCommand> consoleSubcommands = new ArrayList<>();
    private ZAngelChatManager plugin;
    public MainCommand(ZAngelChatManager plugin){
        this.plugin = plugin;

        this.getSubCommands().add(new SCReload(plugin));

    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (args.length > 0) {
                for (int i = 0; i < getSubCommands().size(); i++) {
                    if (args[0].equalsIgnoreCase(getSubCommands().get(i).getName())) {
                        getSubCommands().get(i).execute(p, args);
                    }
                }
            }else {
                help(p);
            }

        }
        return false;
    }

    public ArrayList<SubCommand> getSubCommands() {
        return subCommands;
    }

    public void help(Player p) {
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6----------------zAngelChat----------------"));
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bAvailable Commands:"));
        for(SubCommand csb : getSubCommands()){
            p.sendMessage(ColorUtils.translateColorCodes("&b" + csb.getSyntax() + " &8&l» &f " + csb.getDescription()));
        }
    }
}
