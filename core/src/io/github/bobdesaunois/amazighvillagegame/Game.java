package io.github.bobdesaunois.amazighvillagegame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends ApplicationAdapter
{

    private static final Scene DEFAULT_SCENE = new Scene ("TestScene");

    private static Render render;
    private static Input input;
    private static Scene activeScene;

    public static Scene getActiveScene ()  { return activeScene; }
    public static Render getRender ()      { return render; }
    public static Input getInput ()        { return input; }

	@Override
	public void create () {

        render = new Render ();
        input = new Input ();

        activeScene = DEFAULT_SCENE;

        activeScene.addToScene (new GameObject (GameObjectType.ANYTHING, "badlogic.jpg", new Vector2f (50, 50)));
        activeScene.addToScene (new GameObject (GameObjectType.ANYTHING, "badlogic.jpg", new Vector2f (120, 120)));

	}

	@Override
	public void render () {

        render.render ();
        input.input ();

	}

}
