package io.github.bobdesaunois.amazighvillagegame;

import java.util.List;

public class DialogManager {

    public static List<Dialog> dialogList;

    public static void add (Dialog dialog)
    {

        dialogList.add (dialog);

    }

    public static void clear ()
    {

        dialogList.clear ();

    }

}
