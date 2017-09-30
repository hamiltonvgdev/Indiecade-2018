package Tile;

import java.util.ArrayList;

import Game.Config;
import Player.Player;
import Screen.GameScreen;
import Screen.TransitionScreen;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public class PortalTile extends Tile
{
	String Destination;
	int cost;
	
	public PortalTile(GameScreen gs, float x, float y) 
	{
		super(gs, x, y);
	}

	public PortalTile setDestination(String name, String cost)
	{
		Destination = name.split("-")[1];
		this.cost = Integer.parseInt(cost);
		return this;
	}
	
	public void collideWithPlayer(Player player)
	{
		super.collideWithPlayer(player);
		
		if(collide && !player.getPlay().getAnimation().name.equals("Death"))
		{	
			if(player.getHealth() > cost)
			{
				player.health(-cost);
				
				gs.getGD().write(gs);
				
				GameScreen Dest = new GameScreen(gs.core, gs.getGD(), Destination);
				TiledMapTileLayer Layer = null;
				
				for(MapLayer layer: Dest.getLevel().getMap().getLayers())
				{
					System.out.println(layer.getName());
					if(layer.getName().contains(gs.getLevel().getId()))
					{
						Layer = (TiledMapTileLayer) layer;
						break;
					}
				}
				
				Dest.getPlayer().setPosition(
						Float.parseFloat(Layer.getProperties().get("x").toString()) / Config.PPM, 
						Float.parseFloat(Layer.getProperties().get("y").toString()) / Config.PPM);
				
				gs.core.setScreen(new TransitionScreen(gs.core, Dest.setHUD(gs.getHud())));
			}
		}
	}
}
