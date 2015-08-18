package io.github.bobdesaunois.amazighvillagegame;

import com.badlogic.gdx.math.Vector3;

public class GameText extends DrawableText {

    public GameText (String text, float scale, Vector3 pos)
    {

        setPos (pos);
        setText (text);
        setScale (scale);

    }

}
