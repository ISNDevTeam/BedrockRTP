package net.isnserver.bedrockrtp;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class BedrockRTP extends JavaPlugin implements Listener {
    public BedrockRTP() {
    }

    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("");
        getLogger().info("\u001B[32mBedrockRTP Enabled ✓\u001B[0m");
        getLogger().info("");
    }

    public void onDisable() {
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location location = player.getLocation();
        World world = location.getWorld();
        if (world.getBlockAt(location).getY() < 0) {
            Location teleportLocation = new Location(world, location.getX(), (double)1.0F, location.getZ());
            player.teleport(teleportLocation);
        }

    }
}
