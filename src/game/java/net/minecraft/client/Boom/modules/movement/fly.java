package net.minecraft.client.Boom.modules.movement;

import net.lax1dude.eaglercraft.v1_8.internal.KeyboardConstants;

import net.minecraft.client.Boom.events.Event;
import net.minecraft.client.Boom.events.listeners.EventUpdate;
import net.minecraft.client.Boom.modules.Module;

public class fly extends Module{

	public fly() {
	    super("Fly", KeyboardConstants.KEY_K, Category.MOVEMENT);
	}
	public void onDisable() {
		mc.thePlayer.capabilities.isFlying = false;
	}

    public void onEvent(Event e) {
    	if(e instanceof EventUpdate) {
    		if(e.isPre()) {
    			mc.thePlayer.capabilities.isFlying = true;
    		}
    	}
    }

}