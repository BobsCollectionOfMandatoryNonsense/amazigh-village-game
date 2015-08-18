package io.github.bobdesaunois.amazighvillagegame;

import com.badlogic.gdx.math.Vector3;

public class GameObject extends Drawable {

    private GameObjectType type;
    private Dialog dialog;

    public GameObjectType getType ()        { return type; }
    public float getWidth ()                { return type.getWidth (); }
    public float getHeight ()               { return type.getHeight(); }
    public void setDialog (Dialog dialog)   { this.dialog = dialog; }

    public void interact ()
    {

        System.out.println ("GameObject interaction");
//        DialogManager.activate (dialog);

    }

    public GameObject (GameObjectType type, Vector3 pos)
    {

        this.type = type;
        setPos (pos);
        setTexture(type.getTexture());

    }

    public boolean inside (Vector3 pos)
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
}
