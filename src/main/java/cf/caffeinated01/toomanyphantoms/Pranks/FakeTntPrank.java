package cf.caffeinated01.toomanyphantoms.Pranks;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;

public class FakeTntPrank implements Prank{
    @Override
    public void playPrank(Player player) {
        TNTPrimed primedTnt = (TNTPrimed) player.getWorld().spawnEntity(player.getLocation().add(0, 5, 0), EntityType.PRIMED_TNT);
        primedTnt.setYield(0); // fuck you spigot`
    }
}
