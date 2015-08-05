package io.github.bobdesaunois.amazighvillagegame;

public class Player {

    private static final float MOVEMENT_SPEED = 5.75f;

    private Vector2f pos;
    private GameObject gameObject;

    public GameObject getPlayerGO ()    { return gameObject; }

    public Player (GameObject gameObject)
    {

        this.gameObject = gameObject;

    }

    public void moveRight()
    {

        gameObject.getPos().translate (new Vector2f (MOVEMENT_SPEED, 0));

    }

    public void moveLeft()
    {

        gameObject.getPos().translate (new Vector2f (-MOVEMENT_SPEED, 0));

    }
}
