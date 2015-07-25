package io.github.bobdesaunois.amazighvillagegame;

public enum GameObjectType
{

    BAD_LOGIC_LOGO ("badlogic.jpg");

    private String texture;

    GameObjectType (String string)
    {

        this.texture = string;

    }

    public String getTexture ()
    {

        return texture;

    }

}
