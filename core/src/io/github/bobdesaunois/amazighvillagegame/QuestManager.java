package io.github.bobdesaunois.amazighvillagegame;

import com.badlogic.gdx.math.Vector3;

import java.util.HashMap;
import java.util.Map;

public class QuestManager {

    private static Map<String, Quest> quests = new HashMap<String, Quest> ();

    public static Quest get (String name)
    {

        return quests.get (name);

    }

    public static void setupQuests () {

        String findQuest1Dialog     = "Please find my bucket, I lost it !";
        String findQuest1Congrats   = "You found my bucket, thank you !";
        Quest findQuest1            = new Quest ("findQuest1", QuestState.AVAILABLE, findQuest1Dialog, findQuest1Congrats);
        String findQuest2Dialog     = "Please find my broom, I lost it !";
        String findQuest2Congrats   = "You found my broom, thank you !";
        Quest findQuest2            = new Quest ("findQuest2", QuestState.AVAILABLE, findQuest2Dialog, findQuest2Congrats);
        String findQuest3Dialog     = "Please find my dog, I lost it !";
        String findQuest3Congrats   = "You found my dog, thank you !";
        Quest findQuest3            = new Quest ("findQuest3", QuestState.AVAILABLE, findQuest3Dialog, findQuest3Congrats);

        quests.put (findQuest1.getName (), findQuest1);
        quests.put (findQuest2.getName (), findQuest2);
        quests.put (findQuest3.getName (), findQuest3);

    }

}
