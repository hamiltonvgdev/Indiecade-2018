package Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.brashmonkey.spriter.Drawer;

import Environment.Thing;
import Screen.GameScreen;

public class Health extends Thing{
	protected int Healthnumber;
	private Texture texture;
	private Sprite healthSprite;
	protected Drawer draw;
	private int scale = 100;
	protected com.brashmonkey.spriter.Player play;
	public Health(GameScreen gs) {
		super(gs);
		Healthnumber = 6;
		// TODO Auto-generated constructor stub
		texture = new Texture(Gdx.files.local("test/heartTest.png"));
		healthSprite = new Sprite(texture);
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		super.update(delta);
		
	}
	public void render(SpriteBatch batch){
		super.render(batch);
		for (int i = 0; i< scale*Healthnumber;i = i+scale){
			batch.draw(healthSprite,i,0,scale,scale);
		}
	}
	public void minusHealth(){
		Healthnumber--;
	}
	public void plusHealth(){
		Healthnumber++;
	}
	public void checkHealth(){
		if (Healthnumber == 0){
			System.out.print("You suck");
		}
	}


}