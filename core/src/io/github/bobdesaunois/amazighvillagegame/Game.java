package io.github.bobdesaunois.amazighvillagegame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

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
            startScene.addElementToScene (new GameObject (GameObjectType.BACKGROUND, new Vector3 (1880 * i, 0, 0)));
        // Background end

        // Buildings
        startScene.addElementToScene (new GameObject (GameObjectType.BUILDING_3, new Vector3 (50, 100, 0)));
        startScene.addElementToScene (new GameObject (GameObjectType.BUILDING_2, new Vector3 (1850, 100, 0)));
        // Buildings end

        // People
        startScene.addElementToScene (new GameObject (GameObjectType.PERSON_1, new Vector3 (10,   50,  0)));
        startScene.addElementToScene (new GameObject (GameObjectType.PERSON_2, new Vector3 (400,  50,  0)));
        startScene.addElementToScene (new GameObject (GameObjectType.PERSON_3, new Vector3 (600,  50,  0)));
        startScene.addElementToScene (new GameObject (GameObjectType.PERSON_4, new Vector3 (900,  50,  0)));
        startScene.addElementToScene (new GameObject (GameObjectType.PERSON_5, new Vector3 (1200, 50,  0)));
        // People end

        SceneManager.addScene (startScene);
        SceneManager.setCurrentScene ("StartScene");

    }

}
