import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot, and MouseInfo)

public class Sign extends Actor {
    public Sign(String message) {
        GreenfootImage image = new GreenfootImage(220, 30);
        image.setColor(Color.WHITE);
        image.setFont(new Font("Arial", false, false, 16));
        image.drawString(message, 10, 20);
        setImage(image);
    }
}