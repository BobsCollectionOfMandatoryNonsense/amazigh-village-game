package io.github.bobdesaunois.amazighvillagegame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

abstract class DrawableText {

    private SpriteBatch batch;
    private BitmapFont  font;
    private String      text;
    private Vector2f    pos;
    private float       scale;

    public Vector2f getPos () { return pos; }

    public void setPos (Vector2f pos)   { this.pos = pos; }
    public void setText (String text)   { this.text = text; }
    public void setScale (float scale)  { this.scale = scale; }

    public DrawableText ()
    {

        batch       = new SpriteBatch ();
        font        = new BitmapFont (/*Gdx.files.internal("data/rayanfont.fnt"), false*/);

    }

    public void render ()
    {

        batch.begin ();
        font.getData ().setScale (scale);
        font.draw (batch, text, pos.getX (), pos.getY ());
        batch.end ();

    }

    public void translate (Vector2f translatePos)
    {

        float oldX = pos.getX ();
        float oldY = pos.getY ();

        float newX = translatePos.getX () + Gdx.graphics.getDeltaTime ();
        float newY = translatePos.getY () + Gdx.graphics.getDeltaTime ();

        Vector2f newPos = new Vector2f (oldX + newX, oldY + newY);

        pos = newPos;

    }

}
