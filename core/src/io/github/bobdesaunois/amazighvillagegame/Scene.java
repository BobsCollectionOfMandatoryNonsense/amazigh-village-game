package io.github.bobdesaunois.amazighvillagegame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Scene
{

    private List<GameObject>    gameObjects;
    private List<GameText>      gameTexts;
    private List<GameText>      dialog;
    private String              title;
    private boolean             playable;

    public List<GameObject> getElements ()  { return gameObjects; }
    public List<GameText>   getTexts ()     { return gameTexts; }
    public List<GameText>   getDialog ()    { return dialog; }
    public String           getTitle ()     { return title; }

    public boolean isPlayable () { return playable; }

    public Scene (String title, boolean playable)
    {

        this.title      = title;
        this.playable   = playable;
        gameObjects     = new ArrayList<GameObject> ();
        gameTexts       = new ArrayList<GameText> ();
        dialog          = new ArrayList<GameText> ();

    }

    public void addElementToScene (GameObject go)
    {

        gameObjects.add (go);

    }

    public void addTextToScene (GameText gameText)
    {

        gameTexts.add (gameText);

    }

    public void addDialogToScene (GameText gameText)
    {

        dialog.add (gameText);

    }

    public GameObject getObject (int index)
    {

        return gameObjects.get (index);

    }

}
