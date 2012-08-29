package to.joe.j2mc.portals;

import java.util.HashSet;

import org.bukkit.Location;

public class PortalArea {
    
    private HashSet<Location> locations;
    private String destination;
    private String permission;
    
    public PortalArea(HashSet<Location> locations, String destination, String permission, Location upperLeft) {
        this.locations = locations;
        this.destination = destination;
        this.permission = permission;
    }
    
    public HashSet<Location> getLocations() {
        return this.locations;
    }
    
    public boolean isLocationInPortal(Location loc) {
        return locations.contains(loc);
    }
    
    public String getDestination(){
        return this.destination;
    }
    
    public String getPermission(){
        return this.permission;
    }

}
