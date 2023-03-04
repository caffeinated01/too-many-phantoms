package cf.caffeinated01.toomanyphantoms.Pranks;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static cf.caffeinated01.toomanyphantoms.Too_many_phantoms.plugin;

/*
Gives player nausea, and mess up their movement
 */
public class DrunkPrank implements Prank, Listener {

    public int time = 0;
    public static List<Player> drunkPlayers = new ArrayList<>();

    @Override
    public void playPrank(Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 2400, 1));
        Random r = new Random();

        int[] count = new int[]{0};
        drunkPlayers.add(player);

        new BukkitRunnable() {
            @Override
            public void run() {
                count[0]++;
                player.setVelocity(new Vector(r.nextInt(5), 0, r.nextInt(5)));
                if (count[0] > 60) {
                    drunkPlayers.remove(player);
                    this.cancel();
                }
            }
        }.runTaskTimer(plugin, 0, 40);
    }

    // player is drunk
    @EventHandler
    public void move(PlayerMoveEvent event) {
        if (drunkPlayers.contains(event.getPlayer())) {
            if ((event.getFrom().getX() != event.getTo().getX()) || (event.getFrom().getZ() != event.getTo().getZ())) {
                Player player = event.getPlayer();
                if (player.isOnGround()) {
                    time--;
                    if (time == 0) {
                        Vector push = new Vector();
                        push.setX((Math.random() - 0.5) / 2.0);
                        push.setZ((Math.random() - 0.5) / 2.0);
                        player.setVelocity(push);
                        time = new Random().nextInt(201);
                    }
                }
            }
        }
    }
}
