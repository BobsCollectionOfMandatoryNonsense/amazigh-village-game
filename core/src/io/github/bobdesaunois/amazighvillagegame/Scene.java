package io.github.bobdesaunois.amazighvillagegame;

import java.util.List;

public class Scene {

    private List<GameObject> gameObjects;
    private String title;

    public List<GameObject> getGameObjects ()   { return gameObjects; }
    public String getTitle ()                   { return title; }

    public Scene (String title)
    {

        this.title = title;

    }

    public void addToScene (GameObject go)
    {

        gameObjects.add (go);

    }

    public void get (int index)
    {



    }

}
