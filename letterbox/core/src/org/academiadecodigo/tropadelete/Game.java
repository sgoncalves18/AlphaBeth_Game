package org.academiadecodigo.tropadelete;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.tropadelete.gameobjects.Player;

public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	Player player;
	InputHandler inputHandler;
	OrthographicCamera camera;

	
	@Override
	public void create () {
		batch = new SpriteBatch();

		player = new Player(new Texture("badlogic.jpg"),new Rectangle());
		camera = new OrthographicCamera();
		camera.setToOrtho(false,800,480);

		inputHandler = new InputHandler(player);

	}

	@Override
	public void render () {

		camera.update();

		createImage();
		inputHandler.keyboardListener();
		player.jump();

	}


	@Override
	public void dispose () {

		batch.dispose();
		player.dispose();
	}


	private void createImage(){


		batch.setProjectionMatrix(camera.combined);

		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(player.getImg(), player.getX(), player.getY());
		batch.end();
	}

}
