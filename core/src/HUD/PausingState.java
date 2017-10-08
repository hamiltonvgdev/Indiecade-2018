package HUD;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

import Environment.Thing;
import Game.Config;
import Game.Core;
import Player.Health;
import Screen.GameScreen;
import Screen.MenuScreen;

public class PausingState extends Thing{
	// pausing stuff
	Texture pausingstate;
	Sprite pausing;
	Texture pausingbackground;
	Sprite pausingback;
	//current batch
	SpriteBatch batch;
	//resume/exit
	Texture Resume;
	Sprite ResumeS;
	Texture Exit;
	Sprite ExitS;
	OrthographicCamera cam;
	Core core;
	MenuScreen menu;
	public PausingState(GameScreen gs, Core core) {
		super(gs);
		this.core =core;
		// TODO Auto-generated constructor stub
		pausingstate = new Texture(Gdx.files.internal("pauseButton/detail_pause (1).png"));
		pausing = new Sprite(pausingstate);
		pausingbackground = new Texture(Gdx.files.internal("Black_Screen.png"));
		pausingback = new Sprite(pausingbackground);
		pausingback.setAlpha((float) 0.2);
		pausing.setSize(Config.GAME_HEIGHT * 1.25F, Config.GAME_HEIGHT * 1.25F);
		pausing.setX((Config.GAME_WIDTH-Config.GAME_HEIGHT* 1.25F)/2);
		pausing.setY((-Config.GAME_HEIGHT* .175F));
		//resume/exit
		Resume = new Texture(Gdx.files.internal("pauseButton/pasue_optains_br.png"));
		ResumeS = new Sprite(Resume);
		ResumeS.setSize(Config.GAME_HEIGHT * 1.25F-25,Config.GAME_HEIGHT * 1.25F-25);
		ResumeS.setX((Config.GAME_WIDTH-Config.GAME_HEIGHT* 1.2F)/2);
		ResumeS.setY((-Config.GAME_HEIGHT* .01F));
		Exit = new Texture(Gdx.files.internal("pauseButton/pasue_optains_br.png"));
		ExitS = new Sprite(Exit);
		ExitS.setSize(Config.GAME_HEIGHT * 1.25F-25,Config.GAME_HEIGHT * 1.25F-25);
		ExitS.setX((Config.GAME_WIDTH-Config.GAME_HEIGHT* 1.2F)/2);
		ExitS.setY((-Config.GAME_HEIGHT* .25F));
		//camera setting
		cam = new OrthographicCamera();
		cam.setToOrtho(true,Config.GAME_WIDTH,Config.GAME_HEIGHT);
		//menuScreen
		menu = new MenuScreen(core);
	}
	public void update(float delta) {
		// TODO Auto-generated method stub
		super.update(delta);
		int x = Gdx.input.getX();
		int y = Gdx.input.getY();
		Vector3 input = new Vector3(x, y, 0);
		cam.unproject(input);
		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
			if(ResumeS.getBoundingRectangle().contains(input.x,input.y)){
				HUD.pause = false;
			}
			if(ExitS.getBoundingRectangle().contains(input.x,input.y)){

			}
		}
	}
	public void render(SpriteBatch batch,boolean pause){
		this.batch = batch;
		if(pause == true){
			pausingback.draw(batch);
			pausing.draw(batch);
			ResumeS.draw(batch);
			ExitS.draw(batch);
		}

	}
}
