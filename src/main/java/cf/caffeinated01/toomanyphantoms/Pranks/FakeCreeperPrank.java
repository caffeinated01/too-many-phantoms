package cf.caffeinated01.toomanyphantoms.Pranks;

import org.bukkit.Sound;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class FakeCreeperPrank implements Prank{
    @Override
    public void playPrank(Player player) {
        if (player.getHealth() < 6) {
            player.playSound(player.getLocation(), Sound.ENTITY_CREEPER_PRIMED, 2, 1);
        } else {
            Creeper creeper = (Creeper) player.getWorld().spawnEntity(player.getLocation(), EntityType.CREEPER);
            creeper.setExplosionRadius(0);
        }
    }
}
