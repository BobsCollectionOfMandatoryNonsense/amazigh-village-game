package io.github.bobdesaunois.amazighvillagegame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;

public class GameObject extends Drawable {

    private GameObjectType  type;
    private Interaction interaction;

    public GameObjectType   getType ()      { return type; }
    public float            getWidth ()     { return type.getWidth (); }
    public float            getHeight ()    { return type.getHeight (); }

    public GameObject (GameObjectType type, Vector3 pos)
    {

        this.type = type;
        setTexture (type.getTexture ());
        setPos (pos);

    }

    public void move (Vector3 move)
    {

        float x = move.x;
        float y = move.y;

        if (x == 0)
            x = x; // self assignment to cancel the if loop
        else if (x > 0)
            x += Gdx.graphics.getDeltaTime ();
        else if (x < 0)
            x -= Gdx.graphics.getDeltaTime ();

        if (y == 0)
            y = y; // self-assignment to cancel the if loop
        else if (y > 0)
            y += Gdx.graphics.getDeltaTime ();
        else if (y < 0)
            y -= Gdx.graphics.getDeltaTime ();

        pos.add (x, y, 0);

    }

    public boolean hasInside (Vector3 pos)
    {

        if
        (
            pos.x >= this.pos.x
         && pos.x <= this.pos.x + type.getWidth ()
         && pos.y >= this.pos.y
         && pos.y <= this.pos.y + type.getHeight ()
        )
        {

            return true;

        }

        return false;

    }

    public void interaction ()
    {

        interaction.action ();

    }

    public void addInteraction (Interaction interaction)
    {

        this.interaction = interaction;

    }

    public Interaction getInteraction ()
    {

        return interaction;

    }

}
