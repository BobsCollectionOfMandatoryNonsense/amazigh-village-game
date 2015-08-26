package io.github.bobdesaunois.amazighvillagegame;

import java.util.ArrayList;
import java.util.List;

public class DialogManager {

    private static List<Dialog> dialogList = new ArrayList<Dialog> ();

    public static List<Dialog> getDialogList () { return dialogList; }

    public static void add (Dialog dialog)
    {

        dialogList.add (dialog);

    }

    public static void clear ()
    {

        dialogList.clear ();

    }

}
