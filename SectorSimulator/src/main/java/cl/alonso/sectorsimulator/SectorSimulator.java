package cl.alonso.sectorsimulator;

import java.util.concurrent.ThreadLocalRandom;

import cl.alonso.sectorsimulator.core.Sector;
import cl.alonso.sectorsimulator.utils.worldUtils;

public class SectorSimulator
{
    public static void main( String[] args )
    {

        Sector[][] world = new Sector[10][10];

        worldUtils.setupWorld(world);

        int inRow = ThreadLocalRandom.current().nextInt(0, world.length);
        int inColumn = ThreadLocalRandom.current().nextInt(0, world[0].length);

        //inRow = 0;
        //inColumn = 0;

        System.out.println("Mapa de sectores:");
        for (Sector[] world1 : world) {
            for (Sector world11 : world1) {
                System.out.print(world11.getName() + "|");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Mapeado con conexiones");

        Sector mySector = world[inRow][inColumn];
        System.out.println("Ubicación actual: " + mySector.getName() + " (" + inRow + "," + inColumn + ")");
        System.out.println("Norte: " + mySector.getNorth().getName());
        System.out.println("Sur: " + mySector.getSouth().getName());
        System.out.println("Este: " + mySector.getEast().getName());
        System.out.println("Oeste: " + mySector.getWest().getName());
        System.out.println();

        for (Sector[] world1 : world) {
            for (Sector currentSector : world1) {
                if (currentSector == mySector) {
                    System.out.print("X" + "  |");
                } else if (currentSector == mySector.getNorth()) {
                    System.out.print("^" + "  |");
                } else if (currentSector == mySector.getEast()) {
                    System.out.print(">" + "  |");
                } else if (currentSector == mySector.getWest()) {
                    System.out.print("<" + "  |");
                } else if (currentSector == mySector.getSouth()) {
                    System.out.print("v" + "  |");
                } else {
                    System.out.print(currentSector.getName() + "|");
                }
            }
            System.out.println();
        }

        System.out.println();

        System.out.println("Mapeado tradicional");

        System.out.println("Norte: " + world[inRow - 1][inColumn].getName());
        System.out.println("Ubicación actual: " + world[inRow][inColumn].getName() + " (" + inRow + "," + inColumn + ")");
        System.out.println("Este: " + world[inRow][inColumn + 1].getName());
        System.out.println("Oeste: " + world[inRow][inColumn - 1].getName());
        System.out.println("Sur: " + world[inRow + 1][inColumn].getName());
        System.out.println();

        for (int row = 0; row < world.length; row++) {
            for (int col = 0; col < world[row].length; col++) {
                if (row == inRow && col == inColumn) {
                    System.out.print("X" + "  |");
                } else if (row == inRow - 1 && col == inColumn) {
                    System.out.print("^" + "  |");
                } else if (row == inRow && col == inColumn + 1) {
                    System.out.print(">" + "  |");
                } else if (row == inRow && col == inColumn - 1) {
                    System.out.print("<" + "  |");
                } else if (row == inRow + 1 && col == inColumn) {
                    System.out.print("v" + "  |");
                } else {
                    System.out.print(world[row][col].getName() + "|");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
