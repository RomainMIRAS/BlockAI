package io.romainmiras.blockai.commands;

import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.romainmiras.blockai.utils.AIUtil;
import io.romainmiras.blockai.utils.MessageUtil;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jspecify.annotations.Nullable;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class BasicBlockAICommands implements BasicCommand {

    private Collection<String> SUB_COMMANDS;
    private AIUtil aiUtil;

    public BasicBlockAICommands() {
        this.SUB_COMMANDS = Arrays.asList("ask", "stop", "setup","social", "help", "testConnection");
        this.aiUtil = AIUtil.getInstance();
    }

    @Override
    public void execute(CommandSourceStack stack, String[] args) {
        Player player;

        if (stack.getSender() instanceof Player) {
            player = (Player) stack.getSender();
        } else {
            MessageUtil.sendPlayerOnlyMessage(stack.getSender());
            return;
        }

        if (args.length >= 1) {
            switch (args[0]) {
                case "ask":
                    _ask(stack, args, player);
                    return;
                case "stop":
                    aiUtil.stop(player);
                    MessageUtil.sendBlockAIStoppedMessage(player);
                    return;
                case "setup":
                    _setup(stack, args, player);
                    return;
                case "social":
                    MessageUtil.sendAuthorSocialsMessage(player);
                    return;
                case "help":
                    MessageUtil.sendHelpMessage(player);
                    return;
                case "testConnection":
                    aiUtil.testAIUsageConnection(player);
                    return;
            }
        }
        MessageUtil.sendBaseUsageMessage(player);
    }

    @Override
    public Collection<String> suggest(CommandSourceStack commandSourceStack, String[] args) {
        if (args.length == 1) {
            return SUB_COMMANDS;
        }
        return Collections.emptyList();
    }

    private void _ask(CommandSourceStack stack, String[] args, Player player) {
        if (args.length > 1) {
            String question = String.join(" ", Arrays.copyOfRange(args, 1, args.length));
            MessageUtil.sendAskMessage(player, question);
            aiUtil.ask(question, player);
        } else {
            MessageUtil.sendAskUsageMessage(player);
        }
    }

    private void _setup(CommandSourceStack stack, String[] args, Player player) {
        if (args.length == 3) {
            String aiType = args[1];
            String apiKey = args[2];

            AIUtil.AIType type = AIUtil.AIType.valueOf(aiType.toUpperCase());
            boolean result = aiUtil.setup(type, apiKey, player);

            if (result) {
                MessageUtil.sendBlockAISetupSuccessMessage(player, aiType, apiKey);
            } else {
                MessageUtil.sendBlockAISetupFailureMessage(player);
            }
        } else {
            MessageUtil.sendSetupUsageMessage(player);
        }
    }
}