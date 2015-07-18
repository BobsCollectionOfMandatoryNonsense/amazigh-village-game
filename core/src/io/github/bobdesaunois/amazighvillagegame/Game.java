package io.github.bobdesaunois.amazighvillagegame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends ApplicationAdapter {

    Render render;
    Input input;

	@Override
	public void create () {

        render = new Render ();
        input = new Input ();

	}

	@Override
	public void render () {

        render.render ();
        input.input ();

	}

}
