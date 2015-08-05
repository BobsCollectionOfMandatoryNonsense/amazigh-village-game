package io.github.bobdesaunois.amazighvillagegame;

import com.badlogic.gdx.Gdx;

public class GameObject extends Drawable {

    private GameObjectType type;

    public GameObject (GameObjectType type, Vector2f pos)
    {

        this.type = type;
        setPos (pos);
        setTexture (type.getTexture ());

    }

    public void translate (Vector2f translatePos)
    {

        float oldX = getPos ().getX ();
        float oldY = getPos ().getY ();

        float newX = translatePos.getX () + Gdx.graphics.getDeltaTime ();
        float newY = translatePos.getY () + Gdx.graphics.getDeltaTime ();

        Vector2f newPos = new Vector2f (oldX + newX, oldY + newY);

        setPos (newPos);

    }

}
