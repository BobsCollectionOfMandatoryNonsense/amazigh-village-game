package io.github.bobdesaunois.amazighvillagegame;

import com.badlogic.gdx.ApplicationAdapter;

public class Game extends ApplicationAdapter
{

    private static Render render;
    private static Input  input;
    private static Logic  logic;
    private static boolean running = false;

    public static Render getRender ()       { return render; }
    public static Input  getInput ()        { return input; }
    public static Logic  getLogic ()        { return logic; }
    public static boolean isRunning ()      { return running; }

    public Game ()
    {

        running = true;

    }

    public void initialization ()
    {

        setupScenes();

    }

	@Override
	public void create () {

        initialization ();

        render  = new Render ();
        input   = new Input ();
        logic   = new Logic ();

        logic.start();

	}

	@Override
	public void render () {

        render.render ();
        input.input ();

	}

    public void setupScenes ()
    {

        Scene startScene = new Scene ("StartScene");
        startScene.addTextToScene (new GameText ("Test 1 2 3 test.", new Vector2f (400, 400)));
        startScene.addElementToScene (new GameObject (GameObjectType.BAD_LOGIC_LOGO, new Vector2f (100, 100)));
        SceneManager.addScene (startScene);
        SceneManager.setCurrentScene ("StartScene");

    }

}
