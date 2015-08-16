package io.github.bobdesaunois.amazighvillagegame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class Game extends ApplicationAdapter
{

    private static Player   player;
    private static Camera   camera;
    private static Render   render;
    private static Input    input;
    private static Logic    logic;
    private static Sound    sound;
    private static boolean  running = false;


    public static Player                getPlayer ()        { return player; }
    public static OrthographicCamera    getActualCamera ()  { return camera.getCamera (); }
    public static Camera                getCamera ()        { return camera; }
    public static Render                getRender ()        { return render; }
    public static Input                 getInput ()         { return input; }
    public static Logic                 getLogic ()         { return logic; }
    public static boolean               isRunning ()        { return running; }

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

        player  = new Player (GameObjectType.CHARACTER_MALE);
        camera  = new Camera ();
        render  = new Render ();
        input   = new Input ();
        logic   = new Logic ();

        initialization ();

        // Music
        sound = Gdx.audio.newSound (Gdx.files.internal ("guiles-theme.mp3"));
        sound.play ();

        logic.start();

	}

	@Override
	public void render () {

        render.render ();
        input.input ();

	}

    @Override
    public void dispose ()
    {

        sound.dispose ();

    }

    public void setupScenes ()
    {

        Scene startScene = new Scene ("StartScene", true);

        // Background
        for (int i = 0; i < 7; i++)
            startScene.addElementToScene (new GameObject (GameObjectType.BACKGROUND, new Vector2f (1880 * i, 0)));
        // Background end

        // Buildings
        startScene.addElementToScene (new GameObject (GameObjectType.BUILDING_3, new Vector2f (50, 100)));
        startScene.addElementToScene (new GameObject (GameObjectType.BUILDING_2, new Vector2f (1850, 100)));
        // Buildings end

        // People
        startScene.addElementToScene (new GameObject (GameObjectType.PERSON_1, new Vector2f (10, 50)));
        startScene.addElementToScene (new GameObject (GameObjectType.PERSON_2, new Vector2f (400, 50)));
        startScene.addElementToScene (new GameObject (GameObjectType.PERSON_3, new Vector2f (600, 50)));
        startScene.addElementToScene (new GameObject (GameObjectType.PERSON_4, new Vector2f (900, 50)));
        startScene.addElementToScene (new GameObject (GameObjectType.PERSON_5, new Vector2f (1200, 50)));
        // People end

        // Speech bubbles
//        startScene.addTextToScene (new GameText ("Hallo dit is een test speech bubble.", 3f, new Vector2f (55, 200)));
        // Speech bubbles end

        SceneManager.addScene (startScene);
        SceneManager.setCurrentScene ("StartScene");

    }

}
