package com.epam.training;

import org.junit.Test;

public class LiskovTest {

    /**
     * Mi történik ezen kódok futtatása esetén (mi íratódik ki a standard outputra)?
     * Válaszát indokolja!
     */
    @Test
    public void testLiskov() {
        Vehicle firstVehicle = new Supercar();
        firstVehicle.start();
        System.out.println(firstVehicle instanceof Car);

        Car secondVehicle = (Car) firstVehicle;
        secondVehicle.start();
        System.out.println(secondVehicle instanceof Supercar);

        /**
         * Az alábbi kódrészlet miért okoz szintaktikai hibát?
         *
         * Supercar supercar = new Vehicle();
         */
    }

}