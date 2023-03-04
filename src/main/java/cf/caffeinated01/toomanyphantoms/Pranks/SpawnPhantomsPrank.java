package cf.caffeinated01.toomanyphantoms.Pranks;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class SpawnPhantomsPrank implements Prank{
    @Override
    public void playPrank(Player player) {
        Location phantomSpawnLoc = player.getLocation().add(0, 5, 0);
        for (int i = 0; i < 10; i++) {
            player.getWorld().spawnEntity(phantomSpawnLoc, EntityType.PHANTOM);
        }
    }
}
