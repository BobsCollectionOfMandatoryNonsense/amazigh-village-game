package io.github.bobdesaunois.amazighvillagegame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

abstract class Drawable
{

    private SpriteBatch batch;
    private Texture texture;
    protected Vector3 pos;

    public Vector3 getPos () { return pos; }

    public void setTexture (String texture) { this.texture = new Texture (texture); }
    public void setPos (Vector3 pos)        { this.pos = pos; }

    public Drawable ()
    {

        batch = new SpriteBatch ();

    }

    public void render ()
    {

        float drawX = pos.x;
        float drawY = pos.y;

        batch.setProjectionMatrix (Game.getActualCamera().combined);
        batch.begin ();
        batch.draw (texture, drawX, drawY);
        batch.end ();

    }

    // RETIRED METHOD //
//    public void renderRelevantToPlayerPos()
//    {
//
//        float drawX = (pos.getX () - (Gdx.graphics.getDeltaTime() / 2) - Player.TEXTURE_WIDTH) - Game.getPlayer().getPos ().getX ();
//        float drawY = pos.getY ();
//
//        batch.begin ();
//        batch.draw (texture, drawX, drawY);
//        batch.end ();
//
//    }
}
