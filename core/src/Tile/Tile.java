package Tile;

import Environment.Thing;
import Game.Config;
import Mob.Mob;
import Player.Player;
import Screen.GameScreen;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class Tile extends Thing
{
	boolean collide;
	
	
	public Tile(GameScreen gs, float x, float y)
	{
		super(gs);
		collide = true;
		
		shape = new PolygonShape();
		shape.setAsBox(0.5F, 0.5F);
		
		this.x = x;
		this.y = y;
		
		
		bdef = new BodyDef();
		bdef.position.set(x, y);
		bdef.type = BodyType.KinematicBody;
		body = gs.getWorld().createBody(bdef);
		
		fdef = new FixtureDef();
		fdef.shape = shape;
	}
	
	@Override
	public Tile setID(int id)
	{
		this.id = Config.TILE_Z + "-" + id;
		body.createFixture(fdef).setUserData(Config.TILE_Z + "-" + id);
		shape.dispose();
		
		return this;
	}
	
	@Override
	public void update(float delta)
	{
		super.update(delta);
		
		//System.out.println(x + " " + y + " " + body.getPosition());
	}
	
	@Override
	public void collideWith(Thing thing)
	{
		if(Integer.parseInt(thing.getID().split("-")[0]) == Config.ENTITY_Z)
		{
			collideWithEnt((Mob) thing);
		}else if(Integer.parseInt(thing.getID().split("-")[0]) == Config.PLAYER_Z)
		{
			collideWithPlayer((Player) thing);
		}
	}
	
	@Override
	public void unCollideWith(Thing thing)
	{
		
	}
	
	public void collideWithEnt(Mob ent)
	{
		if(collide)
		{
			
		}
	}
	
	public void collideWithPlayer(Player player)
	{
		if(collide)
		{
			
		}
	}
}
