package io.github.bobdesaunois.amazighvillagegame;

import java.util.HashMap;
import java.util.Map;

public class SceneManager
{

    private static Map<String, Scene> scenes = new HashMap<String, Scene>();
    private static Scene currentScene;

    public static Map<String, Scene> getScenes ()                { return scenes; }
    public static Scene              getScene (String sceneName) { return scenes.get (sceneName); }
    public static Scene              getCurrentScene ()          { return currentScene; }

    public static void setCurrentScene (String sceneName) { currentScene = scenes.get (sceneName); }
    public static void addScene (Scene scene)             { scenes.put (scene.getTitle(), scene); }

}
