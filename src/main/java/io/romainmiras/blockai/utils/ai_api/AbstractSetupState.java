// src/main/java/io/romainmiras/blockai/utils/AbstractSetupState.java
package io.romainmiras.blockai.utils.ai_api;

import org.bukkit.entity.Player;

public abstract class AbstractSetupState {

    protected int step;

    private AbstractBasicAIUsage aiUsage;

    public AbstractSetupState(AbstractBasicAIUsage aiUsage) {
        this.step = 0;
        this.aiUsage = aiUsage;
    }

    public int getStep() {
        return step;
    }

    public void nextStep() {
        this.step++;
    }

    public void resetStep() {
        this.step = 0;
    }

    public abstract void handleStep(Player player, String input);
}