package io.github.bobdesaunois.amazighvillagegame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Scene
{

    private List<GameObject> gameObjects;
    private String title;

    public List<GameObject> getElements ()  { return gameObjects; }
    public String getTitle ()               { return title; }

    public Scene (String title)
    {

        this.title = title;
        gameObjects = new ArrayList<GameObject> ();

    }

    public void addToScene (GameObject go)
    {

        gameObjects.add (go);

    }

    public GameObject getObject (int index)
    {

        return gameObjects.get (index);

    }

    public List<GameObject> getObjectList ()
    {

        return gameObjects;

    }

}
