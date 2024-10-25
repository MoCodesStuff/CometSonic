import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot, and MouseInfo)

public class Counter extends Actor {
    private int value = 0;
    private String prefix;

    public Counter(String prefix) {
        this.prefix = prefix;
        updateImage();
    }

    public void add(int score) {
        value += score;
        updateImage();
    }

    private void updateImage() {
        GreenfootImage image = new GreenfootImage(prefix + value, 24, Color.WHITE, new Color(0, 0, 0, 0));
        setImage(image);
    }
}