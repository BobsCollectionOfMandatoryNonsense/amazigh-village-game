package io.github.bobdesaunois.amazighvillagegame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

abstract class DrawableText {

    private SpriteBatch batch;
    private SpriteBatch speechBatch;
    private Texture     speechTexture;
    private BitmapFont  font;
    private String      text;
    private Vector3     pos;
    private float       scale;
    private boolean     speechBubble;

    public Vector3 getPos ()            { return pos; }

    public void setSpeechBubble (boolean speechBubble)  { this.speechBubble = speechBubble; }
    public void setPos (Vector3 pos)                    { this.pos = pos; }
    public void setText (String text)                   { this.text = text; }
    public void setScale (float scale)                  { this.scale = scale; }

    public DrawableText ()
    {

        batch           = new SpriteBatch ();
        font            = new BitmapFont (/*Gdx.files.internal("data/rayanfont.fnt"), false*/);
        speechBatch     = new SpriteBatch ();
        speechTexture   = new Texture ("speech_bubble.png");

    }

    public void render ()
    {

        if (speechBubble)
        {

            speechBatch.begin ();
            speechBatch.setProjectionMatrix (Game.getActualCamera ().combined);
            speechBatch.draw (speechTexture, pos.x - 25, pos.y - 200);
            speechBatch.end ();

        }

        batch.setProjectionMatrix(Game.getActualCamera().combined);
        batch.begin ();
        font.getData ().setScale (scale);
        font.draw (batch, text, pos.x, pos.y);
        batch.end ();

    }

    public void translate (Vector3 translatePos)
    {

        float oldX = pos.x;
        float oldY = pos.y;

        float newX = translatePos.x + Gdx.graphics.getDeltaTime ();
        float newY = translatePos.y + Gdx.graphics.getDeltaTime ();

        Vector3 newPos = new Vector3 (oldX + newX, oldY + newY, 0);

        pos = newPos;

    }

}
