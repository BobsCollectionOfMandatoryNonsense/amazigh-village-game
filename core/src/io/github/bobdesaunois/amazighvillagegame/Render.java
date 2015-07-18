package io.github.bobdesaunois.amazighvillagegame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Render
{

    private List<Object> drawables;


    public Render ()
    {

        drawables = new ArrayList<Object> ();

    }

    public void render () {

        // Clear the screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        Iterator<Object> drawableIterator = drawables.iterator();
        while (drawableIterator.hasNext())
        {

            Object drawableIt = drawableIterator.next();
//            drawableIt.render ();

        }

    }

}
