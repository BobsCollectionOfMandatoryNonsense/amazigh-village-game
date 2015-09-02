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
                    (Gdx.graphics.getWidth () / 16) - (Gdx.graphics.getWidth () / 3),
                    Gdx.graphics.getHeight () - 50,
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
                    Gdx.graphics.getHeight () - 280,
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
        characterMale.addInteraction (new Interaction () {
            @Override
            public void action () {

                Game.createPlayer (new Player (GameObjectType.CHARACTER_MALE));
                Game.changeGameState (GameState.RUNNING);

            }
        });
        heroSelectScene.addElementToScene (characterMale);

        GameObject characterFemale = new GameObject (GameObjectType.CHARACTER_FEMALE, new Vector3 (-400, 400, 0));
        characterFemale.addInteraction (new Interaction () {
            @Override
            public void action () {

                Game.createPlayer (new Player (GameObjectType.CHARACTER_FEMALE));
                Game.changeGameState (GameState.RUNNING);

            }
        });
        heroSelectScene.addElementToScene (characterFemale);

        heroSelectScene.addTextToScene (new GameText ("Select your hero", 5f, new Vector3 (0 - (Gdx.graphics.getWidth () / 18), 200, 0), false));
        // Background

        SceneManager.addScene (heroSelectScene);

        //////////////////////
        // * Game running * //
        //////////////////////

        Scene gameScene = new Scene ("Game", true);

        // Background
        for (int i = -3; i < 7; i++)
            gameScene.addElementToScene (new GameObject (GameObjectType.BACKGROUND, new Vector3 (1880 * i, 0, 0)));
        // Background end

        // Buildings
        GameObject buildingHidingDog = new GameObject (GameObjectType.BUILDING_3, new Vector3 (50, 100, 0));
        buildingHidingDog.addInteraction (new Interaction () {
            @Override
            public void action () {

                Quest quest = QuestManager.get ("findQuest3");
                if (quest.getQuestState () == QuestState.ACTIVE) {

                    quest.setQuestState (QuestState.FULFILLED);
                    DialogManager.add (new Dialog ("You found a dog inside the house !", new Vector3 (Game.getPlayer ().getPlayerGO ().getPos ().x - 200, (Game.getPlayer ().getPlayerGO ().getPos ().y + Game.getPlayer ().getPlayerGO ().getHeight () + 200), 0)));

                }

            }
        });
        gameScene.addElementToScene (buildingHidingDog);

        gameScene.addElementToScene (new GameObject (GameObjectType.BUILDING_2, new Vector3 (1850, 100, 0)));

        GameObject buildingHidingBroom = new GameObject (GameObjectType.BUILDING_1, new Vector3 (3200, 100, 0));
        buildingHidingBroom.addInteraction (new Interaction () {
            @Override
            public void action () {

                Quest quest = QuestManager.get ("findQuest2");
                if (quest.getQuestState () == QuestState.ACTIVE) {

                    quest.setQuestState (QuestState.FULFILLED);
                    DialogManager.add (new Dialog ("You found a broom inside the house !", new Vector3 (Game.getPlayer ().getPlayerGO ().getPos ().x - 200, (Game.getPlayer ().getPlayerGO ().getPos ().y + Game.getPlayer ().getPlayerGO ().getHeight () + 200), 0)));

                }

            }
        });
        gameScene.addElementToScene (buildingHidingBroom);

        gameScene.addElementToScene (new GameObject (GameObjectType.BUILDING_2, new Vector3 (5000, 100, 0)));
        gameScene.addElementToScene (new GameObject (GameObjectType.BUILDING_2, new Vector3 (6400, 100, 0)));

        GameObject well = new GameObject (GameObjectType.WELL, new Vector3 (4600, 100, 0));
        well.addInteraction (new Interaction () {
            @Override
            public void action () {

                Quest quest = QuestManager.get ("findQuest1");
                if (quest.getQuestState () == QuestState.ACTIVE)
                {

                    quest.setQuestState (QuestState.FULFILLED);
                    DialogManager.add (new Dialog ("You found a bucket inside the well !", new Vector3 (Game.getPlayer ().getPlayerGO ().getPos ().x - 200, (Game.getPlayer ().getPlayerGO ().getPos ().y + Game.getPlayer ().getPlayerGO ().getHeight () + 200), 0)));

                }

            }
        });
        gameScene.addElementToScene (well);
        // Buildings end

        // People
        // Riddle person 1
        final GameObject riddlePerson1 = new GameObject (GameObjectType.PERSON_1, new Vector3 (120, 50, 0));
        riddlePerson1.addInteraction (new Interaction () {
            @Override
            public void action () {

                DialogManager.add (new Dialog ("Hoi ik ben raadsel persoon 1", new Vector3 (riddlePerson1.getPos ().x - 200, (riddlePerson1.getPos ().y + riddlePerson1.getHeight () + 200), 0)));

            }
        });
        gameScene.addElementToScene (riddlePerson1);

        final GameObject riddlePerson2 = new GameObject (GameObjectType.PERSON_2, new Vector3 (2200, 50, 0));
        riddlePerson2.addInteraction (new Interaction () {
            @Override
            public void action () {

                DialogManager.add (new Dialog ("Hoi ik ben raadsel persoon 2", new Vector3 (riddlePerson2.getPos ().x - 200, (riddlePerson2.getPos ().y + riddlePerson2.getHeight () + 200), 0)));

            }
        });
        gameScene.addElementToScene (riddlePerson2);

        final GameObject findPerson1 = new GameObject (GameObjectType.PERSON_3, new Vector3 (3500, 50, 0));
        findPerson1.addInteraction (new Interaction () {
            @Override
            public void action () {

                Quest quest = QuestManager.get ("findQuest1");

                if (quest.getQuestState () == QuestState.AVAILABLE || quest.getQuestState () == QuestState.ACTIVE) {

                    quest.setQuestState (QuestState.ACTIVE);
                    DialogManager.add (new Dialog (quest.getInstructions (), new Vector3 (findPerson1.getPos ().x - 200, (findPerson1.getPos ().y + findPerson1.getHeight () + 200), 0)));

                } else if (quest.getQuestState () == QuestState.FULFILLED) {

                    quest.setQuestState (QuestState.COMPLETED);
                    DialogManager.add (new Dialog (quest.getCongradulations (), new Vector3 (findPerson1.getPos ().x - 200, (findPerson1.getPos ().y + findPerson1.getHeight () + 200), 0)));

                } else if (quest.getQuestState () == QuestState.COMPLETED) {

                    DialogManager.add (new Dialog ("Thanks again for finding my item!", new Vector3 (findPerson1.getPos ().x - 200, (findPerson1.getPos ().y + findPerson1.getHeight () + 200), 0)));

                }

            }
        });
        gameScene.addElementToScene (findPerson1);

        final GameObject findPerson2 = new GameObject (GameObjectType.PERSON_4, new Vector3 (5300, 50, 0));
        findPerson2.addInteraction (new Interaction () {
            @Override
            public void action () {

                Quest quest = QuestManager.get ("findQuest2");

                if (quest.getQuestState () == QuestState.AVAILABLE || quest.getQuestState () == QuestState.ACTIVE) {

                    quest.setQuestState (QuestState.ACTIVE);
                    DialogManager.add (new Dialog (quest.getInstructions (), new Vector3 (findPerson2.getPos ().x - 200, (findPerson2.getPos ().y + findPerson2.getHeight () + 200), 0)));

                } else if (quest.getQuestState () == QuestState.FULFILLED) {

                    quest.setQuestState (QuestState.COMPLETED);
                    DialogManager.add (new Dialog (quest.getCongradulations (), new Vector3 (findPerson2.getPos ().x - 200, (findPerson2.getPos ().y + findPerson2.getHeight () + 200), 0)));

                } else if (quest.getQuestState () == QuestState.COMPLETED) {

                    DialogManager.add (new Dialog ("Thanks again for finding my item!", new Vector3 (findPerson2.getPos ().x - 200, (findPerson2.getPos ().y + findPerson2.getHeight () + 200), 0)));

                }

            }
        });
        gameScene.addElementToScene (findPerson2);

        final GameObject findPerson3 = new GameObject (GameObjectType.PERSON_5, new Vector3 (6800, 50, 0));
        findPerson3.addInteraction (new Interaction () {
            @Override
            public void action () {

                Quest quest = QuestManager.get ("findQuest3");

                if (quest.getQuestState () == QuestState.AVAILABLE || quest.getQuestState () == QuestState.ACTIVE) {

                    quest.setQuestState (QuestState.ACTIVE);
                    DialogManager.add (new Dialog (quest.getInstructions (), new Vector3 (findPerson3.getPos ().x - 200, (findPerson3.getPos ().y + findPerson3.getHeight () + 200), 0)));

                } else if (quest.getQuestState () == QuestState.FULFILLED) {

                    quest.setQuestState (QuestState.COMPLETED);
                    DialogManager.add (new Dialog (quest.getCongradulations (), new Vector3 (findPerson3.getPos ().x - 200, (findPerson3.getPos ().y + findPerson3.getHeight () + 200), 0)));

                } else if (quest.getQuestState () == QuestState.COMPLETED) {

                    DialogManager.add (new Dialog ("Thanks again for finding my item!", new Vector3 (findPerson3.getPos ().x - 200, (findPerson3.getPos ().y + findPerson3.getHeight () + 200), 0)));

                }

            }
        });
        gameScene.addElementToScene (findPerson3);
        // People end

        SceneManager.addScene (gameScene);

    }

}
