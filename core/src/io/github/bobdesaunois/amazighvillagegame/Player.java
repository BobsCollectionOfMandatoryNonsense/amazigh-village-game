package io.github.bobdesaunois.amazighvillagegame;

import com.badlogic.gdx.Gdx;

public class Player {

    public static final float  MOVEMENT_SPEED   = 5.75f;
    public static final int    TEXTURE_WIDTH    = 300;

//    private Vector2f pos;
    private GameObject gameObject;

    public GameObject getPlayerGO () { return gameObject; }
    public Vector2f getPos () { return gameObject.getPos(); }

    public Player (GameObjectType gameObjectType)
    {

//        this.pos        = new Vector2f (0, 0); // adapt the positions from the GameObject
        this.gameObject = new GameObject (gameObjectType, new Vector2f (0, 0));

    }

    public void moveRight()
    {

        Vector2f translation = new Vector2f(MOVEMENT_SPEED, 0);

        gameObject.getPos().translate (translation);
        Game.getCamera().translate (translation);

    }

    public void moveLeft()
    {

        Vector2f translation = new Vector2f(-MOVEMENT_SPEED, 0);

        gameObject.getPos().translate (translation);
        Game.getCamera().translate (translation);

    }
}
