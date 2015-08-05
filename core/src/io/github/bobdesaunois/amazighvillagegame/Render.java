package io.github.bobdesaunois.amazighvillagegame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import java.util.Iterator;

public class Render
{

    public Render ()
    {

        // Insert initialization code

    }

    public void render () {

        // Clear the screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (SceneManager.getCurrentScene() instanceof Scene)
        {

            Scene currentScene = SceneManager.getCurrentScene ();

            Iterator<GameObject> gameObjectIterator = currentScene.getElements().iterator();
            while (gameObjectIterator.hasNext())
            {

                GameObject go = gameObjectIterator.next();
                go.render ();

            }

            if (SceneManager.getCurrentScene().isPlayable ())
            {

                Game.getPlayer().getPlayerGO().render ();

            }

            Iterator<GameText> gameTextIterator = currentScene.getTexts().iterator();
            while (gameTextIterator.hasNext())
            {

                GameText gt = gameTextIterator.next ();
                gt.render ();

            }

        } else {

            System.out.println ("WARNING: NO SCENE PRESENT IN currentScene SLOT IN SceneManager.");

        }

    }

}
