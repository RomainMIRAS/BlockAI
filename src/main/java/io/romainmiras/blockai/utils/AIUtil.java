package io.romainmiras.blockai.utils;

import io.romainmiras.blockai.utils.ai_api.AbstractBasicAIUsage;
import io.romainmiras.blockai.utils.ai_api.AbstractSetupState;
import org.bukkit.entity.Player;

import java.util.Map;

public class AIUtil {

    private Map<Player, AbstractBasicAIUsage> playerAIUsageMap;

    private Map<Player, AbstractSetupState> playerInSetup;

    public static enum AIType {
        OPENAI,
        VERTEXAI,
        HUGGINGFACE,
        AWS
    }

    private static AIUtil instance;

    private AIUtil() {
        playerAIUsageMap = new java.util.HashMap<>();
    }

    public static AIUtil getInstance() {
        if (instance == null) {
            instance = new AIUtil();
        }
        return instance;
    }

    public boolean setup(AIType aiType, String apiKey, Player player) {

        AbstractBasicAIUsage aiUsage;

        switch (aiType) {
            case OPENAI:
                // aiUsage = new OpenAIUsage(apiKey, player);
                return false;
            case VERTEXAI:
                // aiUsage = new VertexAIUsage(apiKey, player);
                return false;
            case HUGGINGFACE:
                // aiUsage = new HuggingFaceUsage(apiKey, player);
                break;
            case AWS:
                // aiUsage = new AWSUsage(apiKey, player);
                return false;
            default:
                return false;
        }
        boolean result = aiUsage.testConnection();
        if (result) {
            playerAIUsageMap.put(player, aiUsage);
        }
        return result;
    }


    public void ask(String question, Player player) {
        AbstractBasicAIUsage aiUsage = playerAIUsageMap.get(player);
        if (aiUsage == null) {
            MessageUtil.sendBlockAISetupFailureMessage(player);
        }
        assert aiUsage != null;
        aiUsage.generalAsk(question);
    }

    public void stop(Player player) {
        playerAIUsageMap.remove(player);
    }

    public void testAIUsageConnection(Player player) {
        AbstractBasicAIUsage aiUsage = playerAIUsageMap.get(player);
        if (aiUsage == null) {
            return;
        }
        aiUsage.testConnection();
    }

}