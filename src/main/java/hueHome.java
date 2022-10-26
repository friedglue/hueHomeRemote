// Author: Joshua Hayes

import io.github.zeroone3010.yahueapi.*;

import java.util.Optional;

public class hueHome {
    public static void main( String[] args) {

        final String bridgeIp = "192.168.50.210"; // Fill in the IP address of your Bridge
        final String apiKey = "HU3nuIZVAJ1l2gXEaWS-XRGjU23k3tU0VQxEHwY4"; // Fill in an API key to access your Bridge
        final Hue hue = new Hue(bridgeIp, apiKey);

        System.out.println("Hello world");

        // Get a room or a zone -- returns Optional.empty() if the room does not exist, but
    // let's assume we know for a fact it exists and can do the .get() right away:
        final Room living_room = hue.getRoomByName("Living room").get();

    // Turn the lights on, make them pink:
        living_room.setState(State.builder().color(Color.of(java.awt.Color.PINK)).on());

    // Make the entire room dimly lit:
        living_room.setBrightness(10);

    // Turn one of the lights green. This also demonstrates the proper use of Optionals:
        final Optional<Light> light = living_room.getLightByName("Black Lamp");
        light.ifPresent(l -> l.setState(State.builder().color(Color.of(java.awt.Color.GREEN.getRGB())).keepCurrentState()));



    }


}
