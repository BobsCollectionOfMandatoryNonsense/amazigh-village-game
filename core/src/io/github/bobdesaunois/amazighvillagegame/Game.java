package io.github.bobdesaunois.amazighvillagegame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class Game extends ApplicationAdapter
{

    private static GameState    gameState;
    private static Player       player;
    private static Camera       camera;
    private static Render       render;
    private static Input        input;
    private static Logic        logic;
    private static Sound        sound;
    private static boolean      running = false;

    public static GameState             getGameState ()     { return gameState; }
    public static Player                getPlayer ()        { return player; }
    public static OrthographicCamera    getActualCamera ()  { return camera.getCamera (); }
    public static Camera                getCamera ()        { return camera; }
    public static Render                getRender ()        { return render; }
    public static Input                 getInput ()         { return input; }
    public static Logic                 getLogic ()         { return logic; }
    public static boolean               isRunning ()        { return running; }

    public static void createPlayer (Player player) { Game.player = player; }

    public Game ()
    {

        gameState = GameState.DEFAULT_GAMESTATE;
        running = true;

    }

    public static void changeGameState (GameState gameState)
    {

        Game.gameState = gameState;

        switch (gameState)
        {

            case START:
                System.out.println ("You can't set the gamestate back to start");
            break;

            case HERO_SELECT:
                SceneManager.setCurrentScene ("HeroSelect");
            break;

            case RUNNING:
                SceneManager.setCurrentScene ("Game");
            break;

            case END_GAME:
                SceneManager.setCurrentScene ("GameOver");
            break;

            default:
                System.out.println ("Unrecognized gamestate");
            break;

        }

    }

	@Override
	public void create () {

        DialogManager.clear ();

        player  = new Player (GameObjectType.CHARACTER_MALE);
        camera  = new Camera ();
        render  = new Render ();
        input   = new Input ();
        logic   = new Logic ();

        SceneManager.setupScenes ();
        SceneManager.setCurrentScene (SceneManager.START_SCENE);

        // Music
        sound = Gdx.audio.newSound (Gdx.files.internal ("guiles-theme.mp3"));
        sound.play ();

        logic.start ();

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

}
