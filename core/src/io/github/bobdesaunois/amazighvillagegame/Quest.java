package io.github.bobdesaunois.amazighvillagegame;

public class Quest {

    private String name;
    private String instructions;
    private String congradulations;
    private QuestState questState;

    public String getName ()            { return name; }
    public String getInstructions ()    { return instructions; }
    public String getCongradulations () { return congradulations; }
    public QuestState getQuestState ()  { return questState; }

    public void setQuestState (QuestState questState) { this.questState = questState; }

    public Quest (String name, QuestState questState, String instructions, String congradulations)
    {

        this.name               = name;
        this.questState         = questState;
        this.instructions       = instructions;
        this.congradulations    = congradulations;

    }

}
