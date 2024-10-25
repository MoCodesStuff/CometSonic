import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot, and MouseInfo)

public class Teamoc extends Actor {
    private int speed = 5;
    private int jumpStrength = -15;
    private int verticalSpeed = 0;
    private int gravity = 1;
    private Counter ringCounter;

    public Teamoc(Counter counter) {
        this.ringCounter = counter;
        setImage("teamoc_idle.png"); // Ensure you have this image.
    }

    public void act() {
        handleMovement();
        applyGravity();
        checkPlatformCollision();
        collectRings();
        checkHazards();
        checkGoal();
    }

    private void handleMovement() {
        if (Greenfoot.isKeyDown("left")) {
            move(-speed);
            setImage("teamoc_run_left.png");
        } else if (Greenfoot.isKeyDown("right")) {
            move(speed);
            setImage("teamoc_run_right.png");
        } else {
            setImage("teamoc_idle.png");
        }

        if (Greenfoot.isKeyDown("up") && isOnGround()) {
            verticalSpeed = jumpStrength;
            Greenfoot.playSound("jump.wav");
        }
    }

    private void applyGravity() {
        setLocation(getX(), getY() + verticalSpeed);
        verticalSpeed += gravity;
    }

    private boolean isOnGround() {
        // Check if Teamoc is standing on a platform or the ground.
        int spriteHeight = getImage().getHeight();
        Actor platformBelow = getOneObjectAtOffset(0, spriteHeight / 2 + 5, Platform.class);
        return platformBelow != null || getY() >= getWorld().getHeight() - spriteHeight / 2;
    }

    private void checkPlatformCollision() {
        if (isOnGround()) {
            verticalSpeed = 0;
        }
    }

    private void collectRings() {
        if (isTouching(Ring.class)) {
            removeTouching(Ring.class);
            ringCounter.add(1);
            Greenfoot.playSound("ring.wav");
        }
    }

    private void checkHazards() {
        if (isTouching(Spike.class)) {
            setLocation(100, 500); // Reset position.
            Greenfoot.playSound("hurt.wav");
        }
    }

    private void checkGoal() {
        if (isTouching(Goal.class)) {
            Greenfoot.playSound("goal.wav");
            // Transition to the end-of-tutorial screen.
            Greenfoot.setWorld(new EndScreen());
        }
    }
}