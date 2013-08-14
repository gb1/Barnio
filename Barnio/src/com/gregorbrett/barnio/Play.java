package com.gregorbrett.barnio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class Play implements Screen {

	private TiledMap map;
	private OrthogonalTiledMapRenderer render;
	private OrthographicCamera camera;

	private final float unitScale = 1 / 32f;

	private static int WIDTH = 34;
	private static int HEIGHT = 20;
	
	private Hiro hiro;

	@Override
	public void show() {

	     TmxMapLoader loader = new TmxMapLoader();
	      
	      map = loader.load("maps/map.tmx");
	      
	      render = new OrthogonalTiledMapRenderer(map,unitScale);
	      
	      camera = new OrthographicCamera();
	      camera.setToOrtho(false, WIDTH, HEIGHT);
	      camera.position.x = WIDTH / 2;
	      camera.position.y = HEIGHT / 2;
	      camera.update();
	   
	      hiro = new Hiro((TiledMapTileLayer)map.getLayers().get(0));
	      hiro.setScale(unitScale);
	      
	      
	      //set up player position
	      //player.setPosition(20 * player.getCollisionLayer().getTileWidth(), 14 * player.getCollisionLayer().getTileHeight());
	}

	@Override
	public void render(float delta) {

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.position.x = WIDTH / 2;
		camera.position.y = HEIGHT / 2;
		camera.update();

		render.setView(camera);
		render.render();
		
		render.getSpriteBatch().begin();
		hiro.draw(render.getSpriteBatch());
		render.getSpriteBatch().end();

		camera.update();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		map.dispose();
		render.dispose();

	}

}
