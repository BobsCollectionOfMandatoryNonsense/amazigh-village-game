package io.github.bobdesaunois.amazighvillagegame;

public class Dialog
{

    private GameText gameText;

    public GameText getGameText () { return gameText; }

    public Dialog (String text, Vector2f pos)
    {

        gameText = new GameText(text, 3f, pos);

    }

}
