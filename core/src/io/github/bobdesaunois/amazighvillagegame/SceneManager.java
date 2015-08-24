package io.github.bobdesaunois.amazighvillagegame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;

import java.util.HashMap;
import java.util.Map;

public class SceneManager
{

    public static final String START_SCENE = "TitleScreen";

    private static Map<String, Scene> scenes = new HashMap<String, Scene>();
    private static Scene currentScene;

    public static Map<String, Scene> getScenes ()                { return scenes; }
    public static Scene              getScene (String sceneName) { return scenes.get (sceneName); }
    public static Scene              getCurrentScene ()          { return currentScene; }

    public static void setCurrentScene (String sceneName) { currentScene = scenes.get (sceneName); }
    public static void addScene (Scene scene)             { scenes.put (scene.getTitle(), scene); }

    public static void setupScenes ()
    {

        //////////////////////
        // * Title screen * //
        //////////////////////

        Scene titleScene = new Scene ("TitleScreen", false);

        for (int i = 0; i < 10; i++)
            titleScene.addElementToScene (new GameObject (GameObjectType.BACKGROUND, new Vector3 ((GameObjectType.BACKGROUND.getWidth () * i) - GameObjectType.BACKGROUND.getWidth (), 0, 0)));

        titleScene.addTextToScene
        (
            new GameText
            (
                "Amazigh Village",
                10f,
                new Vector3
                (
                    (Gdx.graphics.getWidth () / 8) - (Gdx.graphics.getWidth () / 3),
                    Gdx.graphics.getHeight () - 400,
                    0
                ),
                false
            )
        );

        titleScene.addTextToScene
        (
            new GameText
            (
                "Press the screen to continue",
                3f,
                new Vector3
                (
                    (Gdx.graphics.getWidth () / 6) - (Gdx.graphics.getWidth () / 4),
                    Gdx.graphics.getHeight () - 650,
                    0
                ),
                false
            )
        );

        SceneManager.addScene (titleScene);

        ///////////////////////
        // * Hero selectie * //
        ///////////////////////

        Scene heroSelectScene = new Scene ("HeroSelect", false);

        //////////////////////
        // * Game running * //
        //////////////////////

        Scene gameScene = new Scene ("Game", true);

        // Background
        for (int i = 0; i < 7; i++)
            gameScene.addElementToScene (new GameObject (GameObjectType.BACKGROUND, new Vector3 (1880 * i, 0, 0)));
        // Background end

        // Buildings
        gameScene.addElementToScene (new GameObject (GameObjectType.BUILDING_3, new Vector3 (50, 100, 0)));
        gameScene.addElementToScene (new GameObject (GameObjectType.BUILDING_2, new Vector3 (1850, 100, 0)));
        // Buildings end

        // People
        gameScene.addElementToScene (new GameObject (GameObjectType.PERSON_1, new Vector3 (10, 50, 0)));
        gameScene.addElementToScene (new GameObject (GameObjectType.PERSON_2, new Vector3 (400, 50, 0)));
        gameScene.addElementToScene (new GameObject (GameObjectType.PERSON_3, new Vector3 (600, 50, 0)));
        gameScene.addElementToScene (new GameObject (GameObjectType.PERSON_4, new Vector3 (900, 50, 0)));
        gameScene.addElementToScene (new GameObject (GameObjectType.PERSON_5, new Vector3 (1200, 50, 0)));
        // People end

        SceneManager.addScene (gameScene);

        //////////////////
        // * End game * //
        //////////////////

        Scene gameOverScene = new Scene ("GameOver", false);

    }

}
