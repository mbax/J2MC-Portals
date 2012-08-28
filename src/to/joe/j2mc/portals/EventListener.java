package to.joe.j2mc.portals;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class EventListener implements Listener {
    
    private J2MC_Portals plugin;
    
    public EventListener(JavaPlugin instance) {
        this.plugin = (J2MC_Portals) instance;
    }
    
}
