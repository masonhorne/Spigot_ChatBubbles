package me.TheTealViper.chatbubbles.implentations;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.TheTealViper.chatbubbles.ChatBubbles;

public class ChatListenerPrototype {
	public static void onChat(ChatBubbles plugin, AsyncPlayerChatEvent e) {
		if(e.isCancelled() || e.getPlayer().getGameMode().name().equals(GameMode.SPECTATOR.name()))
			return;
		switch (plugin.getConfig().getInt("ChatBubble_Configuration_Mode")){
		case 0:
			if(!plugin.getConfig().getBoolean("ChatBubble_Send_Original_Message")) //This MUST be handled here. If handled by manual player.chat() leads to infinite recursion onPlayerChatEvent
				e.setCancelled(true);
			plugin.handleZero(e.getMessage(), e.getPlayer());
			break;
		case 1:
			//This is handled in the command event
			break;
		case 2:
			if(!plugin.getConfig().getBoolean("ChatBubble_Send_Original_Message")) //This MUST be handled here. If handled by manual player.chat() leads to infinite recursion onPlayerChatEvent
				e.setCancelled(true);
			plugin.handleTwo(e.getMessage(), e.getPlayer());
			break;
		case 3:
			if(Bukkit.getServer().getPluginManager().getPlugin("Factions") != null) {
				if(!plugin.getConfig().getBoolean("ChatBubble_Send_Original_Message")) //This MUST be handled here. If handled by manual player.chat() leads to infinite recursion onPlayerChatEvent
					e.setCancelled(true);
				plugin.handleThree(e.getMessage(), e.getPlayer());
			}else{
				plugin.getServer().getConsoleSender().sendMessage("ChatBubbles is set to configuration mode 3 but Factions can't be found!");
			}
			break;
		case 4:
			if(!plugin.getConfig().getBoolean("ChatBubble_Send_Original_Message")) //This MUST be handled here. If handled by manual player.chat() leads to infinite recursion onPlayerChatEvent
				e.setCancelled(true);
			plugin.handleFour(e.getMessage(), e.getPlayer());
			break;
		case 5:
			if(e.getMessage().startsWith(".")) {
				if(!plugin.getConfig().getBoolean("ChatBubble_Send_Original_Message")) //This MUST be handled here. If handled by manual player.chat() leads to infinite recursion onPlayerChatEvent
					e.setCancelled(true);
				else
					e.setMessage(e.getMessage().substring(1)); //This is uniquely necessary to this config mode 5
				plugin.handleFive(e.getMessage(), e.getPlayer());
			}
			break;
		default:
			break;
		}
	}
}
