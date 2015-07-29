package io.github.bobdesaunois.amazighvillagegame;

public class GameText extends DrawableText {

    public GameText (String text, float scale, Vector2f pos)
    {

        setPos (pos);
        setText (text);
        setScale (scale);

    }

}
