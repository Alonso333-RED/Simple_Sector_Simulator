package cl.alonso.sectorsimulator;

import java.util.concurrent.ThreadLocalRandom;

import cl.alonso.sectorsimulator.core.Sector;
import cl.alonso.sectorsimulator.utils.worldUtils;

public class SectorSimulator
{
    public static void main( String[] args )
    {
        int xSize = ThreadLocalRandom.current().nextInt(1, 10+1);
        int ySize = ThreadLocalRandom.current().nextInt(1, 10+1);

        //xSize = 10;
        //ySize = 10;

        Sector[][] world = new Sector[xSize][ySize];
        worldUtils.setupWorld(world);

        System.out.println("Tamaño del mundo: "+xSize+","+ySize);

        int inRow = ThreadLocalRandom.current().nextInt(0, world.length);
        int inColumn = ThreadLocalRandom.current().nextInt(0, world[0].length);

        //inRow = 0;
        //inColumn = 0;

        System.out.println("Mapa del Mundo");
        System.out.println();

        Sector mySector = world[inRow][inColumn];

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
                    System.out.print(currentSector.getID() + "|");
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Ubicación actual: " + mySector.getName() + " (" + mySector.getXLocation()+","+mySector.getYLocation()+")");
        System.out.println("Norte: " + mySector.getNorth().getName()+" ("+mySector.getNorth().getID()+")");
        System.out.println("Sur: " + mySector.getSouth().getName()+" ("+mySector.getSouth().getID()+")");
        System.out.println("Este: " + mySector.getEast().getName()+" ("+mySector.getEast().getID()+")");
        System.out.println("Oeste: " + mySector.getWest().getName()+" ("+mySector.getWest().getID()+")");
        System.out.println();
    }
}
