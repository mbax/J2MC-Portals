package to.joe.j2mc.portals;

import java.util.HashSet;

import org.bukkit.Location;

public class PortalArea {
    
    private HashSet<Location> locations;
    private String destination;
    private String permission;
    private Location upperLeft;
    
    public PortalArea(HashSet<Location> locations, String destination, String permission, Location upperLeft) {
        this.locations = locations;
        this.destination = destination;
        this.permission = permission;
        this.upperLeft = upperLeft;
    }
    
    public HashSet<Location> getLocations() {
        return this.getLocations();
    }

}
