package com.gregorbrett.barnio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Hiro extends Sprite{


	private Vector2 velocity = new Vector2();
	private float speed = 60 * 3, gravity = 60 * 3.8f;
	
	public Hiro() {
	
		super(new Sprite(new Texture("data/pooch.png")));
		
	
	}
	
	@Override
	public void draw(SpriteBatch spriteBatch) {
		update(Gdx.graphics.getDeltaTime());
		super.draw(spriteBatch);
	}

	
	public void update(float delta) {
		
	}
}
