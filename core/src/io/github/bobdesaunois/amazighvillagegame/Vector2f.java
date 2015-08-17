package io.github.bobdesaunois.amazighvillagegame;

import com.badlogic.gdx.Gdx;

public class Vector2f
{

    private float x, y;

    public float getX () { return x; }
    public float getY () { return y; }

    public Vector2f (float x, float y)
    {

        this.x = x;
        this.y = y;

    }

    public void translate (Vector2f translation)
    {

        if (translation.getX () != 0)
            x += translation.getX () + Gdx.graphics.getDeltaTime();

        if (translation.getY () != 0)
            y += translation.getY () + Gdx.graphics.getDeltaTime();

    }

    public boolean inside (Vector2f pos, float height, float width)
    {

        if
        (
            pos.getX () >= x
         && pos.getX () <= x + width
         && pos.getY () >= y
         && pos.getY () <= y + height
        )
        {

            return true;

        } else {

            return false;

        }

    }

}