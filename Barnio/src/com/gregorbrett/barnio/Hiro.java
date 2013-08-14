package com.gregorbrett.barnio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

public class Hiro extends Sprite {

	private Vector2 velocity = new Vector2();
	private float speed = 60 * 3, gravity = 60 * 1.8f;
	private TiledMapTileLayer collisionLayer;
	private float tileWidth;
	private float tileHeight;
	private boolean collisionY;

	public Hiro(TiledMapTileLayer tmtl) {
		super(new Sprite(new Texture("data/pooch.png")));
		collisionLayer = tmtl;
		tileWidth = collisionLayer.getTileWidth();
		tileHeight = collisionLayer.getTileHeight();
	}

	@Override
	public void draw(SpriteBatch spriteBatch) {
		update(Gdx.graphics.getDeltaTime());
		super.draw(spriteBatch);
	}

	public void update(float delta) {

		velocity.y -= gravity * delta;

		if (velocity.y > speed)
			velocity.y = speed;
		else if (velocity.y < -speed)
			velocity.y = -speed;

		setY(getY() + velocity.y * delta);

		if (velocity.y < 0) { // going down
			// bottom left
			collisionY = collisionLayer.getCell((int) (getX() / tileWidth), (int) (getY() / tileHeight)).getTile().getProperties().containsKey("floor");

			// bottom middle
			if (!collisionY)
				collisionY = collisionLayer.getCell((int) ((getX() + getWidth() / 2) / tileWidth), (int) (getY() / tileHeight)).getTile().getProperties().containsKey("floor");

			// bottom right
			if (!collisionY)
				collisionY = collisionLayer.getCell((int) ((getX() + getWidth()) / tileWidth), (int) (getY() / tileHeight)).getTile().getProperties().containsKey("floor");

			// react to y collision
			if (collisionY) {

				velocity.y = 0;
			}

		}

	}
}
