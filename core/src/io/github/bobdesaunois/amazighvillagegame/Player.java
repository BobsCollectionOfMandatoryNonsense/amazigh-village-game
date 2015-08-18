package io.github.bobdesaunois.amazighvillagegame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;

public class Player {

    public static final float  MOVEMENT_SPEED   = 8.75f;
    public static final int    TEXTURE_WIDTH    = 300;

//    private Vector2f pos;
    private GameObject gameObject;

    public GameObject getPlayerGO () { return gameObject; }
    public Vector3 getPos () { return gameObject.getPos(); }

    public Player (GameObjectType gameObjectType)
    {

//        this.pos        = new Vector2f (0, 0); // adapt the positions from the GameObject
        this.gameObject = new GameObject (gameObjectType, new Vector3 (0, 0, 0));

    }

    public void moveRight()
    {

        Vector3 translation = new Vector3 (MOVEMENT_SPEED, 0, 0);

        gameObject.getPos().add (translation);
        Game.getCamera().translate (translation);

    }

    public void moveLeft()
    {

        Vector3 translation = new Vector3 (-MOVEMENT_SPEED, 0, 0);

        gameObject.getPos().add (translation);
        Game.getCamera().translate (translation);

    }
}
