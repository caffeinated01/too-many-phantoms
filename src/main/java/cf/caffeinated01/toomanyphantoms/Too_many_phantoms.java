package cf.caffeinated01.toomanyphantoms;

import cf.caffeinated01.toomanyphantoms.Listener.OnSleepEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Too_many_phantoms extends JavaPlugin{

    public static Plugin plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        getServer().getPluginManager().registerEvents(new OnSleepEvent(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
