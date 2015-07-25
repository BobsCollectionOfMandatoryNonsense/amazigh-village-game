package io.github.bobdesaunois.amazighvillagegame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends ApplicationAdapter
{

    private static Render render;
    private static Input input;
    private static Scene activeScene;

    public static Render getRender ()      { return render; }
    public static Input getInput ()        { return input; }

    public void initialization ()
    {

        SceneManager.addScene (new Scene ("TestScene"));
        SceneManager.getScene ("TestScene").addToScene (new GameObject (GameObjectType.BAD_LOGIC_LOGO, new Vector2f (400, 400)));
        SceneManager.getScene ("TestScene").addToScene (new GameObject (GameObjectType.BAD_LOGIC_LOGO, new Vector2f (10, 400)));
        SceneManager.getScene ("TestScene").addToScene (new GameObject (GameObjectType.BAD_LOGIC_LOGO, new Vector2f (1200, 400)));
        SceneManager.getScene ("TestScene").addToScene (new GameObject (GameObjectType.BAD_LOGIC_LOGO, new Vector2f (800, 400)));
        SceneManager.setCurrentScene ("TestScene");

    }

	@Override
	public void create () {

        render = new Render ();
        input = new Input ();

        initialization ();

	}

	@Override
	public void render () {

        render.render ();
        input.input ();

	}

}
