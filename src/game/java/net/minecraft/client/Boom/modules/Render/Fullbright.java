package net.minecraft.client.Boom.modules.render;

import net.lax1dude.eaglercraft.v1_8.internal.KeyboardConstants;

import net.minecraft.client.Boom.events.Event;
import net.minecraft.client.Boom.events.listeners.EventUpdate;
import net.minecraft.client.Boom.modules.Module;

public class Fullbright extends Module{

	public Fullbright() {
	    super("Fullbright", KeyboardConstants.KEY_NONE, Category.RENDER);
	}
	
	public void onEnable() {
		mc.gameSettings.gammaSetting = 100;
		
		
	}
	public void onDisable() {
		mc.gameSettings.gammaSetting = 1;
    }

}