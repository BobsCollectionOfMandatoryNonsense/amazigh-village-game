package io.github.bobdesaunois.amazighvillagegame;

import com.badlogic.gdx.math.Vector3;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Logic extends Thread {

    public Long lastRun;
    public Long currentRun;

    @Override
    public void run ()
    {

        lastRun     = System.nanoTime ();
        currentRun  = System.nanoTime ();

        while (Game.isRunning ()) {

            if (currentRun - lastRun > 1000000)
            {

                // Game loop

                switch (Game.getGameState ())
                {

                    case START:

                        Scene titleScreen = SceneManager.getScene ("TitleScreen");
                        List<GameObject> titleScreenGOs = Collections.synchronizedList (SceneManager.getScene ("TitleScreen").getElements ());

                        synchronized (titleScreenGOs) {

                            Iterator<GameObject> titleScreenGOsIterator = titleScreenGOs.iterator ();
                            while (titleScreenGOsIterator.hasNext ()) {

                                GameObject titleScreenGOsIt = titleScreenGOsIterator.next ();
                                titleScreenGOsIt.move (new Vector3 (-0.3f, 0, 0));

                                if (titleScreenGOsIt.getPos ().x < (0 - (GameObjectType.BACKGROUND.getWidth () * 2))) {

                                    float xPositionOfLastGOInList = titleScreenGOs.get (titleScreenGOs.size () - 1).getPos ().x;
                                    titleScreenGOsIt.move (new Vector3 (xPositionOfLastGOInList + GameObjectType.BACKGROUND.getWidth (), 0, 0));

                                    // @todo this shit is bugged as fuck
                                    GameObject toMoveUp = titleScreenGOsIt;
                                    while (titleScreenGOs.indexOf(toMoveUp) != titleScreenGOs.size () - 1)
                                    {

                                        int i = titleScreenGOs.indexOf(toMoveUp);
                                        Collections.swap(titleScreenGOs, i, i + 1);

                                    }

                                    break;

                                }

                            }

                        }

                    break;

                    case HERO_SELECT:
                    break;

                    case RUNNING:
                    break;

                    case END_GAME:
                    break;

                }

                // Game loop end

                lastRun = System.nanoTime ();

            } else {

                currentRun = System.nanoTime ();

            }

        }

    }

}
