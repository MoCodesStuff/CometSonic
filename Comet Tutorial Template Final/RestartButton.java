import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot, and MouseInfo)

public class RestartButton extends Actor {
    public RestartButton() {
        setImage("restart_button.png"); // Ensure you have this image.
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            // Restart the tutorial.
            Greenfoot.setWorld(new TutorialWorld());
        }
    }
}