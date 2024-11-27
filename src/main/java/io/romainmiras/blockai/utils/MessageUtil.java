package io.romainmiras.blockai.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageUtil {

    public static void sendWelcomeMessage(Player player) {
        Component message = Component.text()
                .content("Hello, ")
                .append(Component.text(player.getName()).color(NamedTextColor.AQUA))
                .append(Component.text("! Welcome to the server.").color(NamedTextColor.GREEN))
                .build();
        player.sendMessage(message);
    }

    public static void sendBlockAIStoppedMessage(CommandSender sender) {
        Component message = Component.text("BlockAI stopped!")
                .color(NamedTextColor.RED)
                .append(Component.newline())
                .append(Component.text("You can restart it using /blockai start."))
                .color(NamedTextColor.YELLOW);
        sender.sendMessage(message);
    }

    public static void sendBlockAISetupSuccessMessage(CommandSender sender, String aiType, String apiKey) {
        Component message = Component.text("BlockAI setup successfully!")
                .color(NamedTextColor.GREEN)
                .append(Component.newline())
                .append(Component.text("AI Type: ").append(Component.text(aiType).color(NamedTextColor.AQUA)))
                .append(Component.newline())
                .append(Component.text("API Key: ").append(Component.text(apiKey).color(NamedTextColor.AQUA)));
        sender.sendMessage(message);
    }

    public static void sendBlockAISetupFailureMessage(CommandSender sender) {
        Component message = Component.text("Failed to setup BlockAI!")
                .color(NamedTextColor.RED)
                .append(Component.newline())
                .append(Component.text("Please check the AI Type and API Key and try again."))
                .color(NamedTextColor.YELLOW);
        sender.sendMessage(message);
    }

    public static void sendBaseUsageMessage(CommandSender sender) {
        Component message = Component.text("Usage: /blockai <ask|stop|setup|social|help>")
                .color(NamedTextColor.RED);
        sender.sendMessage(message);
    }

    public static void sendSetupUsageMessage(CommandSender sender) {
        Component message = Component.text("Usage: /blockai setup <AI Type> <API Key>")
                .color(NamedTextColor.RED);
        sender.sendMessage(message);
    }

    public static void sendHelpMessage(CommandSender sender) {
        Component message = Component.text("BlockAI Help")
                .color(NamedTextColor.AQUA)
                .append(Component.newline())
                .append(Component.text("/blockai ask <question>").color(NamedTextColor.GREEN))
                .append(Component.newline())
                .append(Component.text("/blockai stop").color(NamedTextColor.GREEN))
                .append(Component.newline())
                .append(Component.text("/blockai setup <AI Type> <API Key>").color(NamedTextColor.GREEN))
                .append(Component.newline())
                .append(Component.text("/blockai social").color(NamedTextColor.GREEN));
        sender.sendMessage(message);
    }

        public static void sendAskUsageMessage(CommandSender sender) {
        Component message = Component.text("Usage: /blockai ask <question>")
                .color(NamedTextColor.RED);
        sender.sendMessage(message);
    }


        public static void sendAskMessage(CommandSender sender, String question) {
        Component message = Component.text("You asked: ")
                .append(Component.text(question).color(NamedTextColor.AQUA))
                .append(Component.newline())
                .append(Component.text("The AI is processing your question...").color(NamedTextColor.GREEN));
        sender.sendMessage(message);
    }

    public static void sendAuthorSocialsMessage(CommandSender sender) {
        Component message = Component.text("Author: Romain Miras")
                .color(NamedTextColor.AQUA)
                .append(Component.newline())
                .append(Component.text("Twitter: ").color(NamedTextColor.AQUA))
                .append(Component.text("@romainmiras").color(NamedTextColor.BLUE).clickEvent(ClickEvent.openUrl("https://x.com/Grimmjoow_Multi")))
                .append(Component.newline())
                .append(Component.text("GitHub: ").color(NamedTextColor.AQUA))
                .append(Component.text("@romainmiras").color(NamedTextColor.BLUE).clickEvent(ClickEvent.openUrl("https://github.com/RomainMIRAS")));
        sender.sendMessage(message);
    }

    public static void sendTestConnectionSuccessMessage(CommandSender sender, String aiType, String apiKey) {
        Component message = Component.text("Test connection successful!")
                .color(NamedTextColor.GREEN)
                .append(Component.newline())
                .append(Component.text("AI Type: ").append(Component.text(aiType).color(NamedTextColor.AQUA)))
                .append(Component.newline())
                .append(Component.text("API Key: ").append(Component.text(apiKey).color(NamedTextColor.AQUA)));
        sender.sendMessage(message);
    }

    public static void sendTestConnectionFailureMessage(CommandSender sender, String aiType, String apiKey) {
        Component message = Component.text("Test connection failed!")
                .color(NamedTextColor.RED)
                .append(Component.newline())
                .append(Component.text("AI Type: ").append(Component.text(aiType).color(NamedTextColor.AQUA)))
                .append(Component.newline())
                .append(Component.text("API Key: ").append(Component.text(apiKey).color(NamedTextColor.AQUA)));
        sender.sendMessage(message);
    }

    public static void sendPlayerOnlyMessage(CommandSender sender) {
        Component message = Component.text("This command can only be used by players!")
                .color(NamedTextColor.RED);
        sender.sendMessage(message);
    }

    public static void sendSetupAPIKeyMessage(Player player) {
        Component message = Component.text("Please enter your API Key:")
                .color(NamedTextColor.AQUA);
        player.sendMessage(message);
    }
}