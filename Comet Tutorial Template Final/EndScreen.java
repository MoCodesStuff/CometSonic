import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot, and MouseInfo)

public class EndScreen extends World {

    public EndScreen() {    
        super(800, 600, 1); 

        // Set the background for the end screen.
        setBackground(new GreenfootImage("end_screen_background.png"));

        // Display end-of-tutorial message.
        showEndMessage();

        // Add a restart button.
        addObject(new RestartButton(), getWidth() / 2, getHeight() / 2 + 100);
    }

    private void showEndMessage() {
        GreenfootImage textImage = new GreenfootImage("Congratulations! You've completed the tutorial.", 30, Color.WHITE, new Color(0, 0, 0, 0));
        Actor message = new Actor() {
            {
                setImage(textImage);
            }
        };
        addObject(message, getWidth() / 2, getHeight() / 2);
    }
}