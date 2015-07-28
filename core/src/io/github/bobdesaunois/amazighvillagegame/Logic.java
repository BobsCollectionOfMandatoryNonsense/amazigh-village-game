package io.github.bobdesaunois.amazighvillagegame;

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



                // Game loop end

                lastRun = System.nanoTime ();

            } else {

                currentRun = System.nanoTime ();

            }

        }

    }

}
