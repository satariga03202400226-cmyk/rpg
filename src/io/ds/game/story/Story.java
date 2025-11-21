package game.story;

import java.util.LinkedList;
import java.util.Queue;

public class Story {
    private Queue<Dialogue> dialogueQueue = new LinkedList<>();
    private Dialogue currentDialogue;

    public void addDialogue(Dialogue dialogue) {
        dialogueQueue.offer(dialogue);
    }
    public void startStory() {
        currentDialogue = dialogueQueue.poll();
    }
    public Dialogue getCurrentDialogue() {
        return currentDialogue;
    }
    public void nextDialogue() {
        if (currentDialogue != null) {
            if (currentDialogue.getNextDialogue() != null) {
                currentDialogue = currentDialogue.getNextDialogue();
            } else {
                currentDialogue = dialogueQueue.poll();
            }
        }
    }
    public void chooseOption(int index) {
        if (currentDialogue.getOptions() != null && index >= 0 && index < currentDialogue.getOptions().length) {
            currentDialogue = currentDialogue.getOptions()[index].getNextDialogue();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Story story = new Story();
        //example lng, usabon pa kuni mag sleep pako
        Dialogue intro = new Dialogue("scene-1","something chuchuucucucucuc", Type.DIALOG);
        Dialogue choiceScene = new Dialogue("scene-2","Tas next... something chuchuchuch", Type.CHOICE);
        DialogueOption opt1 = new DialogueOption("Sa left!", null);
        DialogueOption opt2 = new DialogueOption("Sa right!", null);
        
        choiceScene.setOptions(new DialogueOption[]{opt1, opt2});
        intro.setNextDialogue(choiceScene);
        story.addDialogue(intro);
        story.addDialogue(choiceScene);
        story.startStory();
        System.out.println(story.getCurrentDialogue().getText());
        story.nextDialogue();
        System.out.println(story.getCurrentDialogue().getText());
    }
}

