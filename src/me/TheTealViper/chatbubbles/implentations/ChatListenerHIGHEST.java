package me.TheTealViper.chatbubbles.implentations;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.TheTealViper.chatbubbles.ChatBubbles;

public class ChatListenerHIGHEST implements Listener {
	public static ChatBubbles plugin;
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onChat(AsyncPlayerChatEvent e){
		ChatListenerPrototype.onChat(plugin, e);
	}
	
}
