package io.romainmiras.blockai;

import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.plugin.bootstrap.BootstrapContext;
import io.papermc.paper.plugin.bootstrap.PluginBootstrap;
import io.papermc.paper.plugin.bootstrap.PluginProviderContext;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEventManager;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEventOwner;
import io.papermc.paper.plugin.lifecycle.event.handler.configuration.PrioritizedLifecycleEventHandlerConfiguration;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import io.romainmiras.blockai.commands.BasicBlockAICommands;
import org.bukkit.plugin.java.JavaPlugin;

public class Bootstrapper  implements PluginBootstrap {
    @Override
    public void bootstrap(BootstrapContext context) {
        LifecycleEventManager<BootstrapContext> manager = context.getLifecycleManager();

        // Register the event listener
        manager.registerEventHandler(LifecycleEvents.COMMANDS, event -> {
            final Commands commands = event.registrar();
            commands.register("blockai", "Basic BlockAI commands", new BasicBlockAICommands());
        });
    }

    @Override
    public JavaPlugin createPlugin(PluginProviderContext context) {
        return new Main();
    }
}