package cf.caffeinated01.toomanyphantoms.Listener;

import cf.caffeinated01.toomanyphantoms.Pranks.*;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OnSleepEvent implements Listener {
    @EventHandler
    public void onSleepEvent(PlayerBedEnterEvent event) {
        World world = event.getPlayer().getWorld();

        Bukkit.getLogger().info("triggered event");
        Bukkit.getLogger().info("world time: " + world.getTime());

        // loop through every player that is in the over-world, get their coords and spawn phantoms above them
        if (world.getEnvironment() != World.Environment.NORMAL) {
            return;
        }
        if (world.getTime() < 13000){
            return;
        }

        Block bed = event.getBed();
        bed.setType(Material.AIR);
        world.createExplosion(bed.getLocation(), 0.0F);
        Bukkit.getLogger().warning("LET THE TROLLING BEGIN");

        for (Player p : Bukkit.getOnlinePlayers()) {
            List<Prank> pranks = new ArrayList<>();
            pranks.add(new DrunkPrank());
            pranks.add(new FakeCreeperPrank());
            pranks.add(new FakeEndermanPrank());
            pranks.add(new FakeIpRevealPrank());
            pranks.add(new FakeTntPrank());
            pranks.add(new FakeWardenPrank());
            pranks.add(new SpawnPhantomsPrank());

            Random r = new Random();
            pranks.get(r.nextInt(pranks.size())).playPrank(p);
        }
    }
}
