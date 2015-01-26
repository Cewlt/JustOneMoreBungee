package com.colt.JustOneMoreBungee;
 
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.ServerPing.Players;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;
 
public class JustOneMore extends Plugin implements Listener {
  
  @Override
    public void onEnable() {
      	this.getProxy().getPluginManager().registerListener(this, this);
   }
	
  @EventHandler
  public void onPing(ProxyPingEvent ev) {
		ServerPing r = ev.getResponse();
		Players p = r.getPlayers();
		p = new Players(p.getOnline() + 1, p.getOnline(), p.getSample());
		ServerPing ping = new ServerPing(r.getVersion(), p, r.getDescription(), r.getFaviconObject());
		ev.setResponse(ping);
	}
}
