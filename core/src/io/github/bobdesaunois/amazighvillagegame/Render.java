package io.github.bobdesaunois.amazighvillagegame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

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

        if (Game.getActiveScene() instanceof Scene)
        {

            Iterator<GameObject> gameObjectIterator = Game.getActiveScene().getGameObjects().iterator();
            while (gameObjectIterator.hasNext())
            {

                GameObject go = gameObjectIterator.next ();
                go.render (go.getPos());

            }

        }

        ///////////////////////////// TESTING CODE /////////////////////////////
//
//        SpriteBatch testBatch = new SpriteBatch();
//        Texture texture = new Texture ("badlogic.jpg");
//        testBatch.begin();
//        testBatch.draw (texture, 0, 0);
//        testBatch.end();

        ///////////////////////////// TESTING CODE /////////////////////////////

        // Insert render code

    }

}
