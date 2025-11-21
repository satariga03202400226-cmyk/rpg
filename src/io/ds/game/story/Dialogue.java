package game.story;

public class Dialogue {
  private String dialogueID;
    private String text;
    private Dialogue nextDialogue;

    public Dialogue(String dialogueID, String text, DialogueType type) {
        this.dialogueID = dialogueID;
        this.text = text;
        this.type = type;
    }
}
