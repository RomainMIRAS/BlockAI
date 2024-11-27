package io.romainmiras.blockai.utils.ai_api;

import org.bukkit.entity.Player;

public abstract class AbstractBasicAIUsage {

    protected Player player;

    public AbstractBasicAIUsage(Player player) {
        this.player = player;
    }

    public abstract void generalAsk(String question);

    public abstract boolean testConnection();

    public abstract void reset();

    public Player getPlayer() {
        return player;
    }
}