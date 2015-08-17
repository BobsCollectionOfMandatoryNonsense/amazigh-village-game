package io.github.bobdesaunois.amazighvillagegame;

public class DialogManager {

    public static void activate (Dialog dialog)
    {

        SceneManager.getCurrentScene().addDialogToScene (dialog.getGameText ());

    }

    public static void clearDialog ()
    {

        SceneManager.getCurrentScene().getDialog().clear ();

    }

}
