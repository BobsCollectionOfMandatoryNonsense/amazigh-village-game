package io.github.bobdesaunois.amazighvillagegame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

abstract class Drawable
{

    private SpriteBatch batch;
    private Texture texture;

    public void setTexture (String texture) { this.texture = new Texture (texture); }

    public Drawable ()
    {

        batch = new SpriteBatch ();

    }

    public void render (Vector2f pos)
    {

        batch.begin ();
        batch.draw (texture, pos.getX (), pos.getY ());
        batch.end ();

    }

}

//hoidetyfustering



//iksnaphetniet.com