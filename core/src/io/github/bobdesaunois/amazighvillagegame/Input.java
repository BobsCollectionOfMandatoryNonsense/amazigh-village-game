package io.github.bobdesaunois.amazighvillagegame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector3;

import java.util.Iterator;

public class Input extends InputAdapter
{

    private Vector3 pos;
    private Vector3 truePos;

    public Vector3 getPos ()        { return pos; }
    public Vector3 getTruePos ()    { return truePos; }

    public Input ()
    {

        pos     = new Vector3 (0, 0, 0);
        truePos = new Vector3 (0, 0, 0);

    }

    public boolean isTouched ()
    {

        return Gdx.input.isTouched ();

    }

    private void pollMovementInput ()
    {

        if (truePos.x > Gdx.graphics.getWidth () - 200)
        {

            System.out.println ("RIGHT");
            Game.getPlayer().moveRight ();

        } else if (truePos.x < 200) {

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
            float inputY = (float) Gdx.input.getY ();

            pos     = new Vector3 (inputX, inputY, 0);
            truePos = new Vector3 (inputX, Gdx.graphics.getHeight () - inputY, 0);
            pos     = Game.getActualCamera().unproject (pos); // This is fucking magic

            pollMovementInput ();
            pollGameObjectInteractions();

            // Log positions

            System.out.println("TuePos:");
            System.out.println("X: " + truePos.x);
            System.out.println("Y: " + truePos.y);


            System.out.println ("Pos:");
            System.out.println ("X: " + pos.x);
            System.out.println ("Y: " + pos.y);

        }

    }

}
