package io.github.bobdesaunois.amazighvillagegame;

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

    public GameObject (GameObjectType type, Vector2f pos)
    {

        this.type = type;
        setPos (pos);
        setTexture (type.getTexture ());

    }

}
