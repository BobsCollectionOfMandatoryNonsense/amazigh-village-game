package io.github.bobdesaunois.amazighvillagegame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;

import java.util.HashMap;
import java.util.Map;

public class SceneManager
{

    public static final String START_SCENE = "HeroSelect";

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

        // Background
        for (int i = 0; i < 3; i++)
            heroSelectScene.addElementToScene (new GameObject (GameObjectType.BACKGROUND, new Vector3 ((1880 * i) - (GameObjectType.BACKGROUND.getWidth () * 2), 0, 0)));

        GameObject characterMale = new GameObject (GameObjectType.CHARACTER_MALE, new Vector3 (400 + GameObjectType.CHARACTER_MALE.getWidth () , 400, 0));
        characterMale.addClickable (new Clickable ()
        {
            @Override public void action ()
            {

                System.out.println ("Hello!");

            }
        });
        heroSelectScene.addElementToScene (characterMale);

        GameObject characterFemale = new GameObject (GameObjectType.CHARACTER_FEMALE, new Vector3 (-400, 400, 0));
        heroSelectScene.addElementToScene (characterFemale);

        heroSelectScene.addTextToScene (new GameText ("Select your hero", 5f, new Vector3 (0 - (Gdx.graphics.getWidth () / 18), 200, 0), false));
        // Background end



        SceneManager.addScene (heroSelectScene);

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

        SceneManager.addScene (gameOverScene);

    }

}
