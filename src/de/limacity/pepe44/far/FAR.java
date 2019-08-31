package de.limacity.pepe44.far;


import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


import java.text.SimpleDateFormat;
import java.util.Date;

public class FAR extends JavaPlugin {

    private static String LastDate = "";

    public void onEnable(){

        Bukkit.getPluginManager().registerEvents(new dateCheck(),this);

        System.out.println("Farmweltreset Geladen");

        SimpleDateFormat sdf = new SimpleDateFormat("mm:HH");
        Date now = new Date();
        LastDate = sdf.format(now);

    }

    public static String getLastDate() {
        return LastDate;
    }

    public static void setLastDate(String lastDate) {
        LastDate = lastDate;
    }
}
