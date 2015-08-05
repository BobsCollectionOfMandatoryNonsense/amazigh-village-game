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

    public void translate (Vector2f translatePos)
    {

        if (translatePos.getX () != 0)
            x += translatePos.getX () + Gdx.graphics.getDeltaTime();

        if (translatePos.getY () != 0)
            y += translatePos.getY () + Gdx.graphics.getDeltaTime();

    }

}