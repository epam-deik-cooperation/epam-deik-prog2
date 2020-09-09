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
 */
public class FinalizeFixedExample {

    public static void main(String[] args) throws Exception {
        try (BugousStuffProducer stuffProducer = new BugousStuffProducer("someFile.txt")) {
            stuffProducer.writeStuff();
        }
    }

    private static class BugousStuffProducer implements AutoCloseable {
        private final Writer writer;

        public BugousStuffProducer(String outputFileName) throws IOException {
            writer = new FileWriter(outputFileName);
        }

        public void writeStuff() throws IOException {
            writer.write("Stuff");
        }

        @Override
        public void close() throws Exception {
            writer.close();
        }
    }
}
