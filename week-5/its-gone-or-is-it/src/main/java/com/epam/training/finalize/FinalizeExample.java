package com.epam.training.finalize;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * # It's gone. Or is it?
 *
 * Adott a következő osztály:
 *
 * ```
 * public class BugousStuffProducer {
 *
 *     private final Writer writer;
 *
 *     public BugousStuffProducer(String outputFileName) throws IOException {
 *         writer = new FileWriter(outputFileName);
 *     }
 *
 *     public void writeStuff() throws IOException {
 *         writer.write("Stuff");
 *     }
 *
 *     @Override
 *     public void finalize() throws IOException {
 *         writer.close();
 *     }
 * }
 * ```
 *
 * Mutass példát arra az esetre. amikor előfordulhat, hogy bár a program futása során meghívtuk a writeStuff() metódust,
 * a fájl, amibe írtunk még is üres. Magyarázd meg, miért. Mutass alternatívát.
 *
 */
public class FinalizeExample {

    public static void main(String[] args) throws IOException {
        BugousStuffProducer stuffProducer = new BugousStuffProducer("someFile.txt");
        stuffProducer.writeStuff();
        System.gc();    // Csak hogy egy kicsit determinisztikusabbá tegyük a dolgot.
        /*
        Itt a stuffProducer még elérhető lehet (a JVM optimalizáció során rendelhet null értéket
        a változóhoz, mivel a továbbiakban nincs használva, de erre nincs garancia), ráadásul a main()
        befejezése sem garantálja, hogy a finalize() lefut erre az objektumra.
        */
    }

    private static class BugousStuffProducer {
        private final Writer writer;

        public BugousStuffProducer(String outputFileName) throws IOException {
            writer = new FileWriter(outputFileName);
        }

        public void writeStuff() throws IOException {
            writer.write("Stuff");
        }

        @Override
        public void finalize() throws IOException {
            writer.close();
        }
    }
}
