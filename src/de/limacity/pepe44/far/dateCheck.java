package de.limacity.pepe44.far;


import de.limacity.pepe44.far.events.WorldResetEvent;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.text.SimpleDateFormat;
import java.util.Date;

public class dateCheck implements Listener {

    @EventHandler
    private void onJoinDateCheck(PlayerJoinEvent event){
        SimpleDateFormat sdf = new SimpleDateFormat("mm:HH");
        Date now = new Date();

        String[] lastDate = FAR.getLastDate().split(":");

        if(Integer.parseInt(lastDate[0])+1 <= now.getMinutes()){
            Bukkit.getScheduler().runTaskLater(FAR.getPlugin(FAR.class), new Runnable() {
                @Override
                public void run() {
                    Bukkit.broadcastMessage( "§7[§3Server§7]§5 > §r§aDie §6§lFarmwelt §awird Resetet und ist einen Moment nicht verfügbar.");
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"mv delete Farmwelt");
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"mvconfirm");
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"mv create Farmwelt normal");

                    FAR.setLastDate(sdf.format(now));
                }
            },20*1);

            Bukkit.getScheduler().runTaskLater(FAR.getPlugin(FAR.class), new Runnable() {
                @Override
                public void run() {

                    World world = Bukkit.getWorld("Farmwelt");

                    Bukkit.getPluginManager().callEvent(new WorldResetEvent(world.getSpawnLocation()));
                    Bukkit.broadcastMessage( "§7[§3Server§7]§5 > §r§aDie §6§lFarmwelt §aist jetzt Resetet und wieder verfügbar.");
                }
            },20*11);

            return;
        }
    }
}
