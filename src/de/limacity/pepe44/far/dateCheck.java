package de.limacity.pepe44.far;


import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.text.SimpleDateFormat;
import java.util.Date;

public class dateCheck implements Listener {

    @EventHandler
    private void onJoinDateCheck(PlayerJoinEvent event){
        SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy");
        Date now = new Date();

        String[] lastDate = FAR.getLastDate().split(":");

        if(Integer.parseInt(lastDate[0])+7 <= now.getDay()){
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"mv delete Test");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"mvconfirm");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"mv create Test normal");

            FAR.setLastDate(sdf.format(now));
            return;
        }
    }
}
