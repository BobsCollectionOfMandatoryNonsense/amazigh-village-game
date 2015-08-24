package io.github.bobdesaunois.amazighvillagegame;

import com.badlogic.gdx.math.Vector3;

public class Dialog
{

    private GameText gameText;

    public GameText getGameText () { return gameText; }

    public Dialog (String text, Vector3 pos)
    {

        gameText = new GameText(text, 3f, pos, true);

    }

}
