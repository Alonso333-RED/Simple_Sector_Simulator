package cl.alonso.sectorsimulator.utils;

import cl.alonso.sectorsimulator.core.Sector;

public class worldUtils {

    public static void setupWorld(Sector[][] world) {
        for (int row = 0; row < world.length; row++) {
            for (int col = 0; col < world[row].length; col++) {
                world[row][col] = new Sector(row + "," + col);
            }
        }

        for (int row = 0; row < world.length; row++) {
            for (int col = 0; col < world[row].length; col++) {
                Sector current = world[row][col];
                current.setNorth(world[(row - 1 + world.length) % world.length][col]);
                current.setSouth(world[(row + 1) % world.length][col]);
                current.setWest(world[row][(col - 1 + world[row].length) % world[row].length]);
                current.setEast(world[row][(col + 1) % world[row].length]);
            }
        }
    }
}
