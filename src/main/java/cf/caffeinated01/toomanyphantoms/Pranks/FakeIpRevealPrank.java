package cf.caffeinated01.toomanyphantoms.Pranks;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

import static cf.caffeinated01.toomanyphantoms.Too_many_phantoms.plugin;

public class FakeIpRevealPrank implements Prank{

    @Override
    public void playPrank(Player player) {
        Random r = new Random();
        Bukkit.broadcastMessage(player.getDisplayName() + "'s IP is: " + (r.nextInt(254) + 1) + "." + (r.nextInt(254) + 1) + "."+ (r.nextInt(254) + 1) + "."+ (r.nextInt(254) + 1));
        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage("btw the ip was fake");
            }
        }.runTaskLater(plugin, 1200);
    }
}
