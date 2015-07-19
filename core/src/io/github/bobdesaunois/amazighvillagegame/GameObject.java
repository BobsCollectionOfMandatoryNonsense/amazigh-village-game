package io.github.bobdesaunois.amazighvillagegame;

public class GameObject extends Drawable {

    private Vector2f pos;

    public GameObject (String texture, Vector2f pos)
    {

        setTexture (texture);
        this.pos = pos;

    }

    public void move (Vector2f translatePos)
    {

        float oldX = pos.getX ();
        float oldY = pos.getY ();

        float newX = translatePos.getX ();
        float newY = translatePos.getY ();

        Vector2f newPos = new Vector2f (oldX + newX, oldY + newY);

        pos = newPos;

    }

}
