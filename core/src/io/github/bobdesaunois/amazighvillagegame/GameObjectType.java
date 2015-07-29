package io.github.bobdesaunois.amazighvillagegame;

public enum GameObjectType
{

    BAD_LOGIC_LOGO  ("badlogic.jpg"),
    BACKGROUND      ("background.png"),
    BUILDING_1      ("building_1.png"),
    BUILDING_2      ("building_2.png"),
    BUILDING_3      ("building_3.png"),
    CHARACTER_MALE  ("character_male.png"),
    PERSON_1        ("person_1.png"),
    PERSON_2        ("person_2.png"),
    PERSON_3        ("person_3.png"),
    PERSON_4        ("person_4.png"),
    PERSON_5        ("person_5.png"),
    SPEECH_BUBBLE   ("speech_bubble.png");

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
