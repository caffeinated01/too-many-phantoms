package cf.caffeinated01.toomanyphantoms.Pranks;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class FakeEndermanPrank implements Prank{
    @Override
    public void playPrank(Player player) {
        Location playerPos = player.getLocation();
        for (int i = 0; i < 20; i++){
            player.playSound(playerPos, Sound.ENTITY_ENDERMAN_SCREAM, 2, 1);
            player.playSound(playerPos, Sound.ENTITY_ENDERMAN_TELEPORT, 2, 1);
        }
    }
}
