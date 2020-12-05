package react;

import react.impl.AverageCalculatingConsumer;
import react.impl.IntSequenceProducer;
import react.impl.SumCalculatingConsumer;

/**
 * # Reactive
 *
 * Számoljuk ki az első 10 szám összegét és áltagát.
 * 1. Tegyük mindezt úgy, hogy a számok előállítása, az átlag és az összeg számítása külön-külön szálon futsson.
 * 2. Ügyeljünk arra, hogy a számok előállítása ne terhelhesse túl az összeget és átlagot számoló szálakat, bármilyen
 * lassú is legyen a számítás. Az egyes számítások sebessége ne befolyásolja a számok előállításának és más számításoknak a sebességét.
 * 3. Amennyiben egy számítást végző szál nem tudja fogadni a következő számot, azt mentsük el és kínáljuk fel a számítást végző
 * szálnak amint kész van a következő számot fogadni. Az így elmentett számok mennyisége legyen limitálva, ha túl sok számot
 * kellene elmentenünk, töröljük azt, amelyik a legrégebben érkezett.
 * 4. A számokat a számítást végző szálak az előállításuknak megfelelő sorrendben dolgozzák fel.
 * 5. Igyekezzünk minimálisra csökkenteni a blokkolt szálak számát.
 */
public class Main {
    public static void main(String[] args) {
        IntSequenceProducer producer = new IntSequenceProducer(4);
        AverageCalculatingConsumer average = new AverageCalculatingConsumer(producer);
        SumCalculatingConsumer sum = new SumCalculatingConsumer(producer);
        producer.block();
    }
}
