package cf.caffeinated01.toomanyphantoms.Pranks;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import static cf.caffeinated01.toomanyphantoms.Too_many_phantoms.plugin;

public class FakeEndermanPrank implements Prank{
    @Override
    public void playPrank(Player player) {
        Location playerPos = player.getLocation();
        int[] count = new int[]{0};
        new BukkitRunnable() {

            @Override
            public void run() {
                count[0] += 1;
                player.playSound(playerPos, Sound.ENTITY_ENDERMAN_SCREAM, 0.5F, 1);
                player.playSound(playerPos, Sound.ENTITY_ENDERMAN_TELEPORT, 0.5F, 1);
                if (count[0] > 10) {
                    this.cancel();
                }
            }
        }.runTaskTimer(plugin, 0, 10);
    }
}
