package io.github.bobdesaunois.amazighvillagegame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;

public class Input extends InputAdapter {

    private Vector2f pos;

    public Vector2f getPos () { return pos; }

    public Input ()
    {

        pos = new Vector2f (0, 0);

    }

    public void input ()
    {

        if (Gdx.input.isTouched())
        {

            float inputX = (float) Gdx.input.getX();
            float inputY = (float) Gdx.input.getY();

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
