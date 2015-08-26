package io.github.bobdesaunois.amazighvillagegame;

public enum GameObjectType
{

    BAD_LOGIC_LOGO      ("badlogic.jpg",            256,    256),
    BACKGROUND          ("background.png",          1920,   1280),
    BUILDING_1          ("building_1.png",          1500,   1519),
    BUILDING_2          ("building_2.png",          1500,   1596),
    BUILDING_3          ("building_3.png",          1500,   958),
    CHARACTER_MALE      ("character_male.png",      104,    402),
    CHARACTER_FEMALE    ("character_female.png",    104,    402),
    PERSON_1            ("person_1.png",            275,    450),
    PERSON_2            ("person_2.png",            293,    450),
    PERSON_3            ("person_3.png",            343,    450),
    PERSON_4            ("person_4.png",            254,    450),
    PERSON_5            ("person_5.png",            272,    450),
    SPEECH_BUBBLE       ("speech_bubble.png",       1000,   226);

    private String  texture;
    private float   width;
    private float   height;

    public float getWidth ()    { return width; }
    public float getHeight ()   { return height; }
    public String getTexture () { return texture; }

    GameObjectType (String string, float width, float height)
    {

        this.texture    = string;
        this.width      = width;
        this.height     = height;

    }

}
