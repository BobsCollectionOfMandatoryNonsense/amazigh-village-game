package io.github.bobdesaunois.amazighvillagegame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class Camera {

    private Vector2f pos;
    private OrthographicCamera camera;

    public Camera (Vector2f pos)
    {

        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        this.pos = pos;

    }

    public void translate ()
    {



    }

}
