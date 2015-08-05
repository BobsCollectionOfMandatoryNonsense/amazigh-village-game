package io.github.bobdesaunois.amazighvillagegame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.sun.javafx.image.BytePixelSetter;

public class Input extends InputAdapter
{

    private Vector2f pos;

    public Vector2f getPos () { return pos; }

    public Input ()
    {

        pos = new Vector2f (0, 0);

    }

    public boolean isTouched ()
    {

        return Gdx.input.isTouched ();

    }

    private void pollMovementInput()
    {

        if (pos.getX () > Gdx.graphics.getWidth () / 2)
        {

            System.out.println ("RIGHT");
            Game.getPlayer().moveRight ();

        } else {

            System.out.println ("LEFT");
            Game.getPlayer().moveLeft ();

        }

    }

    public void input ()
    {

        if (isTouched ())
        {

            float inputX = (float) Gdx.input.getX();
            float inputY = (float) Gdx.input.getY();

            pos = new Vector2f (inputX, inputY);

            pollMovementInput ();

            // Log positions
            StringBuilder xSb = new StringBuilder();
            xSb.append ("X: ");
            xSb.append (inputX);
            String outputX = xSb.toString();

            StringBuilder ySb = new StringBuilder();
            ySb.append ("Y: ");
            ySb.append (inputY);
            String outputY = ySb.toString();

            System.out.println (outputX);
            System.out.println (outputY);

        }

    }

}
