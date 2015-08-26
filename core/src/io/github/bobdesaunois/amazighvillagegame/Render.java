package io.github.bobdesaunois.amazighvillagegame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Render
{

    public Render ()
    {

        // Insert initialization code

    }

    public void render () {

        Game.getActualCamera().update ();

        // Clear the screen
        Gdx.gl.glClearColor (0, 0, 0, 1);
        Gdx.gl.glClear (GL20.GL_COLOR_BUFFER_BIT);

        if (SceneManager.getCurrentScene() instanceof Scene)
        {

            Scene currentScene = SceneManager.getCurrentScene ();

            List<GameObject> gameObjectList = Collections.synchronizedList (currentScene.getElements ());
            synchronized (gameObjectList)
            {

                Iterator<GameObject> gameObjectIterator = gameObjectList.iterator();
                while (gameObjectIterator.hasNext())
                {

                    GameObject go = gameObjectIterator.next();
                    go.render();

                }

            }

            if (SceneManager.getCurrentScene().isPlayable ())
            {

                Game.getPlayer().getPlayerGO().render ();

            }

            List<GameText> gameTextList = Collections.synchronizedList (currentScene.getTexts ());

            synchronized (gameTextList)
            {

                Iterator<GameText> gameTextIterator = gameTextList.iterator();
                while (gameTextIterator.hasNext())
                {

                    GameText gt = gameTextIterator.next ();
                    gt.render ();

                }

            }

            List<Dialog> dialogList = DialogManager.getDialogList ();
            Iterator<Dialog> dialogIterator = dialogList.iterator ();
            while (dialogIterator.hasNext ())
            {

                Dialog dialogIt = dialogIterator.next ();
                dialogIt.getGameText ().render ();

            }

        } else {

            System.out.println ("WARNING: NO SCENE PRESENT IN currentScene SLOT IN SceneManager.");

        }

        ShapeRenderer sr = new ShapeRenderer ();
        sr.setProjectionMatrix (Game.getActualCamera ().combined);
        sr.setColor (100, 0, 0, 0);
        sr.begin (ShapeRenderer.ShapeType.Filled);
        sr.circle (Game.getInput ().getPos ().x, Game.getInput ().getPos ().y, 30);
        sr.end ();

        sr.setColor (0, 0, 100, 0);
    }

}
