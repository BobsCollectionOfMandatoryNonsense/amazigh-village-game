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

}
