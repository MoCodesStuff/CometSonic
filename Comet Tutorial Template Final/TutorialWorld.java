import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot, and MouseInfo)

public class TutorialWorld extends World {
    public TutorialWorld() {    
        // Create a new world with 800x600 pixels.
        super(800, 600, 1); 

        // Set the background to a Sonic-esque image.
        setBackground(new GreenfootImage("tutorial_background.png"));

        // Initialize the ring counter (HUD).
        Counter ringCounter = new Counter("Rings: ");
        addObject(ringCounter, 70, 20);

        // Add the player character, Teamoc.
        Teamoc teamoc = new Teamoc(ringCounter);
        addObject(teamoc, 100, 500); // Starting position.

        // Create the level layout.
        createPlatforms();
        createRings();
        createHazards();

        // Add instructional signs.
        addObject(new Sign("Use LEFT/RIGHT to move"), 200, 550);
        addObject(new Sign("Press UP to jump"), 400, 550);
        addObject(new Sign("Collect rings to increase score"), 600, 550);

        // Add a goal object to signify the end of the level.
        addObject(new Goal(), 750, 100);
    }

    private void createPlatforms() {
        // Add ground and elevated platforms.
        addObject(new Platform(), 200, 550);
        addObject(new Platform(), 400, 450);
        addObject(new Platform(), 600, 350);
    }

    private void createRings() {
        // Place rings for the player to collect.
        addObject(new Ring(), 220, 500);
        addObject(new Ring(), 420, 400);
        addObject(new Ring(), 620, 300);
    }

    private void createHazards() {
        // Add simple hazards like spikes.
        addObject(new Spike(), 350, 550);
    }
}