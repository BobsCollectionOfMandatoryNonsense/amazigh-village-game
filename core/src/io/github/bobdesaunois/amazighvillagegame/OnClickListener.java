package io.github.bobdesaunois.amazighvillagegame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OnClickListener {

    private static List<Clickable> clickables = new ArrayList<Clickable> ();

    public static void add (Clickable clickable)
    {

        clickables.add (clickable);

    }

    public static void empty ()
    {

        clickables.clear ();

    }

//    public static void listen ()
//    {
//
//        Iterator<Clickable> clickablesIterator = clickables.iterator ();
//        while (clickablesIterator.hasNext ())
//        {
//
//            Clickable clickableIt = clickablesIterator.next ();
//            if (clickableIt.getGO ().hasInside (Game.getInput ().getPos ()))
//            {
//
//                clickableIt.action ();
//
//            }
//
//        }
//
//    }

}
