package cf.caffeinated01.toomanyphantoms.Pranks;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Random;

import static cf.caffeinated01.toomanyphantoms.Too_many_phantoms.plugin;

/*
Gives player nausea, and mess up their movement
 */
public class DrunkPrank implements Prank{
    @Override
    public void playPrank(Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 2400, 1));

        new BukkitRunnable() {
            @Override
            public void run() {
                Random r = new Random();
                player.setVelocity(new Vector(r.nextInt(100), r.nextInt(5), r.nextInt(100)));
            }
        }.runTaskTimer(plugin, 0, 40);
    }
}
