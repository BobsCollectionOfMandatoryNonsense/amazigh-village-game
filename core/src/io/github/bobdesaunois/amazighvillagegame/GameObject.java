package io.github.bobdesaunois.amazighvillagegame;

import com.badlogic.gdx.Gdx;

public class GameObject extends Drawable
{

    private GameObjectType type;
    private Vector2f pos;

    public Vector2f getPos () { return pos; }

    public GameObject (GameObjectType type, Vector2f pos)
    {

        this.type = type;
        this.pos = pos;
        setTexture (type.getTexture ());

    }

    public void translate (Vector2f translatePos)
    {

        float oldX = pos.getX ();
        float oldY = pos.getY ();

        float newX = translatePos.getX () + Gdx.graphics.getDeltaTime ();
        float newY = translatePos.getY () + Gdx.graphics.getDeltaTime ();

        Vector2f newPos = new Vector2f (oldX + newX, oldY + newY);

        pos = newPos;

    }

}
