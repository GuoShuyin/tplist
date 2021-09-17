package me.gsy.gsy;

import com.google.common.primitives.Chars;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.List;

public class tplist implements CommandExecutor, TabCompleter {
    Gsy plugin = Gsy.getPlugin(Gsy.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        for (int i=0;i<plugin.getConfig().getStringList("Places").size();i++){
            //System.out.println(args[0]);
            //System.out.println(plugin.getConfig().getStringList("Places").get(i));
            if (args[0].equals(plugin.getConfig().getStringList("Places").get(i))){

               String temp = plugin.getConfig().getStringList("Location").get(i);
               String cut = " ";
               String[] location = temp.split(cut);
                System.out.println(location[0]);
                System.out.println(location[1]);
                System.out.println(location[2]);
                Location location1 = new Location(player.getWorld(),Integer.parseInt(location[0]),Integer.parseInt(location[1]),Integer.parseInt(location[2]));
                player.teleport(location1);
            }
        }


        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {


        if(args.length==1){
            List<String> list = plugin.getConfig().getStringList("Places");
            return list;
        }


        return null;
    }
}
