package io.github.bobdesaunois.amazighvillagegame;

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

        x += translatePos.getX ();
        y += translatePos.getY ();

    }

}