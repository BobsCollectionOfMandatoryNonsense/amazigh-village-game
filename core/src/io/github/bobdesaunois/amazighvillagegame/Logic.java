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

                System.out.println (Game.getPlayer().getPos ().getX ());
                //pls

                // Game loop end

                lastRun = System.nanoTime ();

            } else {

                currentRun = System.nanoTime ();

            }

        }

    }

}
