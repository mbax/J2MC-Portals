package to.joe.j2mc.portals;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;
import org.bukkit.plugin.java.JavaPlugin;

public class J2MC_Portals extends JavaPlugin {

    public EventListener listener;
    public ArrayList<PortalArea> portalAreas;

    @Override
    public void onEnable() {
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
        
        this.listener = new EventListener(this);
        this.loadPortalAreas();
    }
    
    public void loadPortalAreas() {
        for(String area : this.getConfig().getStringList("portals")) {
            String path = "portals." + area;
            int x = this.getConfig().getInt(path + ".x");
            int y = this.getConfig().getInt(path + ".y");
            int z = this.getConfig().getInt(path + ".z");
            Location upperLeft = new Location(this.getServer().getWorlds().get(0), x, y, z);
            
            ArrayList<Location> locations = new ArrayList<Location>();
            //TODO load all the locations from the map
            
            String destination = area;
            String perm = this.getConfig().getString(path + ".permission");
            this.getServer().getPluginManager().addPermission(new Permission("perm",PermissionDefault.OP));
            
            this.portalAreas.add(new PortalArea(locations, destination, perm, upperLeft));
        }
    }
    
    public ArrayList<Location> getAllLocations() {
        ArrayList<Location> return_ = new ArrayList<Location>();
        for(PortalArea area : this.portalAreas) {
            for(Location loc : area.locations) {
                return_.add(loc);
            }
        }
        return return_;
    }

}
