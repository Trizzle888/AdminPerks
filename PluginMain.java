package vb.$adminperks;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import org.bukkit.*;
import org.bukkit.block.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.plugin.java.*;
import org.bukkit.util.*;

public class PluginMain extends JavaPlugin implements Listener {

	private static PluginMain instance;
	private static Object localVariableScope = new Object();

	public void onEnable() {
		instance = this;
		getDataFolder().mkdir();
		getServer().getPluginManager().registerEvents(this, this);
		Object localVariableScope = new Object();
		PluginMain.createResourceFile("AdminFlySpeed.yml");
	}

	public void onDisable() {
	}

	public boolean onCommand(CommandSender commandSender, Command command, String label, String[] commandArgs) {
		if (command.getName().equalsIgnoreCase("admininvisibledisable")) {
			try {
				Object localVariableScope = new Object();
				((org.bukkit.entity.LivingEntity) commandSender).setInvisible(!true);
				commandSender.sendMessage(PluginMain.color("You are no longer invisible."));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (command.getName().equalsIgnoreCase("admininvisible")) {
			try {
				Object localVariableScope = new Object();
				((org.bukkit.entity.LivingEntity) commandSender).setInvisible(!false);
				commandSender.sendMessage(PluginMain.color("You are now invisible."));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (command.getName().equalsIgnoreCase("adminimmortaldisable")) {
			try {
				Object localVariableScope = new Object();
				((org.bukkit.entity.Entity) commandSender).setInvulnerable(false);
				commandSender.sendMessage(PluginMain.color("You are no longer immortal."));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (command.getName().equalsIgnoreCase("adminimmortal")) {
			try {
				Object localVariableScope = new Object();
				((org.bukkit.entity.Entity) commandSender).setInvulnerable(true);
				commandSender.sendMessage(PluginMain.color("You are now immortal."));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (command.getName().equalsIgnoreCase("adminflydisable")) {
			try {
				Object localVariableScope = new Object();
				((org.bukkit.entity.Player) commandSender).setAllowFlight(false);
				commandSender.sendMessage(PluginMain.color("You have disabled admin flight."));
				((org.bukkit.entity.Player) commandSender).setFlySpeed(((float) 100d));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (command.getName().equalsIgnoreCase("adminfly")) {
			try {
				Object localVariableScope = new Object();
				((org.bukkit.entity.Player) commandSender).setAllowFlight(true);
				commandSender.sendMessage(PluginMain.color("You have enabled admin flight."));
				((org.bukkit.entity.Player) commandSender).setFlySpeed(((float) 300d));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public static void procedure(String procedure, List<?> procedureArgs) throws Exception {
	}

	public static Object function(String function, List<?> functionArgs) throws Exception {
		return null;
	}

	public static List<Object> createList(Object obj) {
		List<Object> list = new ArrayList<>();
		if (obj.getClass().isArray()) {
			int length = java.lang.reflect.Array.getLength(obj);
			for (int i = 0; i < length; i++) {
				list.add(java.lang.reflect.Array.get(obj, i));
			}
		} else if (obj instanceof Collection<?>) {
			list.addAll((Collection<?>) obj);
		} else {
			list.add(obj);
		}
		return list;
	}

	public static String color(String string) {
		return string != null ? ChatColor.translateAlternateColorCodes('&', string) : null;
	}

	public static void createResourceFile(String path) {
		Path file = getInstance().getDataFolder().toPath().resolve(path);
		if (Files.notExists(file)) {
			try (InputStream inputStream = PluginMain.class.getResourceAsStream("/" + path)) {
				Files.createDirectories(file.getParent());
				Files.copy(inputStream, file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static PluginMain getInstance() {
		return instance;
	}
}
