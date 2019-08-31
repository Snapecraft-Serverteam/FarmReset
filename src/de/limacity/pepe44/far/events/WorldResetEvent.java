package de.limacity.pepe44.far.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class WorldResetEvent extends Event {

    public static HandlerList handlers = new HandlerList();

    Location location;

    public WorldResetEvent(Location location){
        this.location = location;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerListr(){
        return handlers;
    }

    public Location getLocation() {
        return location;
    }
}
