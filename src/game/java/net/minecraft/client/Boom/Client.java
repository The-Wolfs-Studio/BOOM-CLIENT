package net.minecraft.client.Boom;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import net.minecraft.client.Boom.events.Event;
import net.minecraft.client.Boom.events.listeners.EventKey;
import net.minecraft.client.Boom.modules.Module;
import net.minecraft.client.Boom.modules.Module.Category;
import net.minecraft.client.Boom.modules.movement.fly;
import net.minecraft.client.Boom.modules.render.Fullbright;


public class Client {
	public static String name = "Boom", version = "1";
	public static CopyOnWriteArrayList<Module> modules = new CopyOnWriteArrayList<Module>();
	

	// Method for adding a glowing effect to text
	public static void drawGlowingText(String text, int x, int y, int color, int glowColor) {
	}

	public static void startup() {
		System.out.println("Starting " + name + " " + version);

		modules.add(new fly());			
		modules.add(new Fullbright());

	}

	public static void onEvent(Event<?> e) {
		for (Module m : modules) {
			if (!m.toggled)
				continue;
			m.onEvent(e);
		}
	}

	public static void keyPress(int key) {
		Client.onEvent(new EventKey(key));
		for (Module m : modules) {
			if (m.getKey() == key) {
				m.toggle();
			}
		}
	}

	public static List<Module> getModulesByCategory(Category c) {
		List<Module> modules = new ArrayList<Module>();

		for (Module m : Client.modules) {
			if (m.category == c)
				modules.add(m);
		}
		return modules;
	}

	// Example method for rendering glowing text, can be used in GUI rendering
	public static void renderClientName() {
		// Call the drawGlowingText method with the name "Boom" and a glowing color
		// effect
		drawGlowingText(name, 50, 50, 0xFFFFFF, 0xFF00FF); // White text with a pink glow
	}
}