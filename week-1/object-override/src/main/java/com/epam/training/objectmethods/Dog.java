package com.epam.training.objectmethods;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Java Object metódusok
 *
 * Mutasd be a Java Object metódusait és mutass rá mely metódusokat érdemes
 * egy saját osztályunkban felüldefiniálni és miért. (Lásd még Object class forráskódja)
 *
 * Note: Minden osztály, így ez is, az Object osztály leszármazottja, akkor is, ha ezt explicit nem határoztuk meg,
 * így örökli is annak minden metódusát (a láthatóságnak megfelelően).
 *
 */
public class Dog {

    private final String name;
    private final String color;
    private final LocalDate dateOfBirth;


    public Dog(String name, String color, LocalDate dateOfBirth) {
        this.name = name;
        this.color = color;
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Az == operátor referencia típusú változók esetén a hivatkozott objektum azonosságát vizsgálja
     * (azaz `a == b` igaz pontosan akkor, ha `a` és `b` is null vagy ugyan arra a példányra vagy tömbre hivatkozik,
     * lásd: https://docs.oracle.com/javase/specs/jls/se7/html/jls-15.html#jls-15.21.3).
     * Az `Object` definiálja az equals metódust, amit használhatunk arra, hogy a példányokat állapotuk alapján
     * össze tudjuk hasonlítani. Az `Object`-beli implementáció hasonlóan működik, mint az == operátor, a további
     * részleteket és a `Object.equals` contractját lásd:
     * https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#equals(java.lang.Object)
     *
     * Az ősosztályban definiált metódust felüldefiniálhatjuk a nekünk megfelelő módon,
     * például úgy, hogy két `Dog` példány, amelynek azonos a neve, színe és születési éve,
     * legyen azonosnak tekinthető.
     *
     * @param o Az objektum, amit össze akarunk hasonlítani azzal az objektummal, amelyen a metódust hívtuk (this).
     * @return `true` pontosan akkor, ha a paraméterben adott példány nem null és a fent leírtak alapján azonosnak tekinthető
     *      azzal a példánnyal, amelyen a metódust hívták.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Dog dog = (Dog) o;
        return Objects.equals(name, dog.name) &&
            Objects.equals(color, dog.color) &&
            Objects.equals(dateOfBirth, dog.dateOfBirth);
    }

    /**
     * Ahogy ezt kiemelték az `Object.equals` dokumentációjában, a hash függvényt használó
     * containerek (pl. `HashMap`) és egyéb osztályok megfelelő működéséhez az equals-nak
     * és a hashCode-nak összhangban kell lennie. Lásd: https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#hashCode()
     *
     * @return az objektum állapota alapján számolt hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, color, dateOfBirth);
    }

    /**
     * Az objektum emberek számára olvasható, informatív String reprezentációját szolgáltatja.
     *
     * @return az objektum String reprezentációja
     */
    @Override
    public String toString() {
        return "Dog{" +
            "name='" + name + '\'' +
            ", color='" + color + '\'' +
            ", dateOfBirth=" + dateOfBirth +
            '}';
    }


}
