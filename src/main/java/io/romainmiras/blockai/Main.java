package io.romainmiras.blockai;

import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.plugin.bootstrap.BootstrapContext;
import io.papermc.paper.plugin.bootstrap.PluginBootstrap;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEventManager;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import io.romainmiras.blockai.commands.BasicBlockAICommands;
import io.romainmiras.blockai.events.onPlayerJoin;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Le Plugin c'est bien allume");
        // Register the event listener
        Bukkit.getPluginManager().registerEvents(new onPlayerJoin(), this);
    }

    @Override
    public void onDisable() {
        System.out.println("Le Plugin c'est bien eteint");
    }

    @Override
    public void onLoad() {
        System.out.println("Le Plugin c'est bien charge");
    }
}