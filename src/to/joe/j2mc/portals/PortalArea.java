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
        int x = loc.getBlockX();
        int y = loc.getBlockY();
        int z = loc.getBlockY();
        for(Location l : locations) {
            if(l.getBlockX() == x && l.getBlockZ() == z && ((l.getBlockY() == y) || (l.getBlockY() == y+1) || l.getBlockY() == y+2)) {
                return true;
            }
        }
        return false;
    }
    
    public String getDestination(){
        return this.destination;
    }
    
    public String getPermission(){
        return this.permission;
    }

}
