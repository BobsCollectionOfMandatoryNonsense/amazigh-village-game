package io.github.bobdesaunois.amazighvillagegame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector3;

import java.util.Iterator;

public class Input extends InputAdapter
{

    private Vector3 pos;

    public Vector3 getPos () { return pos; }

    public Input ()
    {

        pos = new Vector3 (0, 0, 0);

    }

    public boolean isTouched ()
    {

        return Gdx.input.isTouched ();

    }

    private void pollMovementInput ()
    {

        if (pos.x > Gdx.graphics.getWidth () - 200)
        {

            System.out.println ("RIGHT");
            Game.getPlayer().moveRight ();

        } else if (pos.x < 200) {

            System.out.println ("LEFT");
            Game.getPlayer().moveLeft ();

        }

    }

    private void pollGameObjectInteractions ()
    {

        Scene currentScene = SceneManager.getCurrentScene ();

        System.out.println ("==================== INTERACTION CHECK START ====================");

        Iterator<GameObject> gameObjectIterator = currentScene.getElements ().iterator ();
        while (gameObjectIterator.hasNext ())
        {

            GameObject gameObjectIt = gameObjectIterator.next ();

            if (gameObjectIt.inside (pos))
            {

                gameObjectIt.interact();

            }

        }

        System.out.println ("===================== INTERACTION CHECK END =====================");

    }

    public void input ()
    {

        if (isTouched ())
        {

            float inputX = (float) Gdx.input.getX ();
            float inputY = (float) Gdx.graphics.getHeight () - Gdx.input.getY ();

            pos = new Vector3 (inputX, inputY, 0);

            pollMovementInput ();
            pollGameObjectInteractions();

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
