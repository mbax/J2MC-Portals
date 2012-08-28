package to.joe.j2mc.portals;

import java.util.ArrayList;

import org.bukkit.Location;

public class PortalArea {
    
    public ArrayList<Location> locations;
    public String destination;
    public String permission;
    public Location upperLeft;
    
    public PortalArea(ArrayList<Location> locations_, String destination_, String perm, Location upperLeft_) {
        this.locations = locations_;
        this.destination = destination_;
        this.permission = perm;
        this.upperLeft = upperLeft_;
    }

}
