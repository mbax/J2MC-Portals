package to.joe.j2mc.portals;

import java.util.ArrayList;
import java.util.HashSet;

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
            
            HashSet<Location> locations = new HashSet<Location>();
            //TODO load all the locations from the map
            
            String destination = area;
            String perm = this.getConfig().getString(path + ".permission");
            if(perm.equals("j2mc.portals.everyone")) {
                this.getServer().getPluginManager().addPermission(new Permission("perm",PermissionDefault.OP));
            }
            
            this.portalAreas.add(new PortalArea(locations, destination, perm, upperLeft));
        }
    }
    
    public HashSet<Location> getAllLocations() {
        HashSet<Location> return_ = new HashSet<Location>();
        for(PortalArea area : this.portalAreas) {
            for(Location loc : area.getLocations()) {
                return_.add(loc);
            }
        }
        return return_;
    }

}
