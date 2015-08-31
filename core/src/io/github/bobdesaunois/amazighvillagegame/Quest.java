package io.github.bobdesaunois.amazighvillagegame;

public class Quest {

    private String name;
    private boolean complete;

    private Quest (String name, boolean complete)
    {

        this.name       = name;
        this.complete   = complete;

    }

    public Quest getInstance (String name, boolean complete)
    {

        return new Quest (name, complete);

    }

}
