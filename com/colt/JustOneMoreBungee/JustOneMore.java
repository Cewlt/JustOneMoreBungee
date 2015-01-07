package com.colt.JustOneMoreBungee;
 
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.ServerPing.Players;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;
 
public class JustOneMore extends Plugin implements Listener {
  
  @Override
  public void onEnable(){
    this.getProxy().getPluginManager().registerListener(this, this);
}
	
  @EventHandler
  public void onPing(ProxyPingEvent ev) {
		ServerPing response = ev.getResponse();
		Players players = response.getPlayers();
		players = new Players(Math.min(players.getOnline() + 1, players.getMax()), players.getOnline(), players.getSample());
		ServerPing ping = new ServerPing(response.getVersion(), players, response.getDescription(), response.getFaviconObject());
		ev.setResponse(ping);
	}
}
