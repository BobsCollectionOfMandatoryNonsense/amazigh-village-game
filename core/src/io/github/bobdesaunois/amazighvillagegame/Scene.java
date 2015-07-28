package io.github.bobdesaunois.amazighvillagegame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Scene
{

    private List<GameObject> gameObjects;
    private List<GameText>   gameTexts;
    private String           title;

    public List<GameObject> getElements ()  { return gameObjects; }
    public List<GameText>   getTexts ()     { return gameTexts; }
    public String getTitle ()               { return title; }

    public Scene (String title)
    {

        this.title  = title;
        gameObjects = new ArrayList<GameObject> ();
        gameTexts   = new ArrayList<GameText> ();

    }

    public void addElementToScene (GameObject go)
    {

        gameObjects.add (go);

    }

    public void addTextToScene (GameText gameText)
    {

        gameTexts.add (gameText);

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
