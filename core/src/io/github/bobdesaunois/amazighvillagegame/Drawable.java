package io.github.bobdesaunois.amazighvillagegame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

abstract class Drawable
{

    private SpriteBatch batch;
    private Texture texture;
    private Vector2f pos;

    public Vector2f getPos () { return pos; }

    public void setTexture (String texture) { this.texture = new Texture (texture); }
    public void setPos (Vector2f pos) { this.pos = pos; }

    public Drawable ()
    {

        batch = new SpriteBatch ();

    }

    public void render ()
    {

        batch.begin ();
        batch.draw (texture, pos.getX (), pos.getY ());
        batch.end ();

    }

}
