package cf.caffeinated01.toomanyphantoms.Pranks;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class FakeWardenPrank implements Prank{
    @Override
    public void playPrank(Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS, 240, 1));
        player.playSound(player.getLocation(), Sound.ENTITY_WARDEN_EMERGE, 2, 1);
    }
}
