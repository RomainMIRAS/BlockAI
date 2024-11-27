package io.romainmiras.blockai.utils.ai_api.openai;

import io.romainmiras.blockai.utils.AIUtil;
import io.romainmiras.blockai.utils.MessageUtil;
import io.romainmiras.blockai.utils.ai_api.AbstractBasicAIUsage;
import io.romainmiras.blockai.utils.ai_api.AbstractSetupState;
import org.bukkit.entity.Player;

public class OpenAISetupState extends AbstractSetupState {

    public OpenAISetupState(AbstractBasicAIUsage aiUsage) {
        super(aiUsage);
    }

    @Override
    public void handleStep(Player player, String input) {
        switch (step) {
            case 0:
                this.apiKey = input;
                nextStep();
                MessageUtil.sendSetupAPIKeyMessage(player);
                break;
            case 1:
                // Handle API key validation and setup
                boolean result = AIUtil.getInstance().setup(AIUtil.AIType.OPENAI, apiKey, player);
                if (result) {
                    MessageUtil.sendBlockAISetupSuccessMessage(player, "OPENAI", apiKey);
                } else {
                    MessageUtil.sendBlockAISetupFailureMessage(player);
                }
                AIUtil.getInstance().completeSetup(player, uiUsage);
                break;
            default:
                break;
        }
    }
}
