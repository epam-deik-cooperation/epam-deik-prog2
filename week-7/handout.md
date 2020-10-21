# 7. hét

Adatfolyamok kezelése, streamek, I/O, állománykezelés. Szerializáció.

## Adatfolyamok kezelése, streamek, I/O

### Byte stream-ek

1. 8 bites byte alapú olvasáshoz és íráshoz
1. `InptuStream`-ből és `OutputStream`-ből származó osztályok
1. Az API gyakran használja a decorator mintát, ahol egy objektum más `InputStream` vagy `OutputStream` objektumot 
   csomagol be, ám valamilyen módon gazdagítja/megváltoztatja a viselkedését.

```java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) throws IOException {

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("xanadu.txt");
            out = new FileOutputStream("outagain.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
```

### Karakter stream-ek
1. Karakter alapú olvasására - karakterkódolás
1. `Reader`-ből és `Writer`-ből származó osztályok
1. Jellemzően byte stream-eket csomagolnak be (implicit, vagy explicit az `InputStreamReader` és `OutputStreamWriter` esetén)

```java
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharacters {
    public static void main(String[] args) throws IOException {

        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("xanadu.txt");
            outputStream = new FileWriter("characteroutput.txt");

            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
```

### Adat stream-ek
1. Primitív típusok illetve String byte alapú stream-ekbe történő írására
1. `DataInput`-ból és `DataOutput`-ból származó osztályok

```
// ...
static final String dataFile = "invoicedata";

static final double[] prices = { 19.99, 9.99, 15.99, 3.99, 4.99 };
static final int[] units = { 12, 8, 13, 29, 50 };
static final String[] descs = {
    "Java T-shirt",
    "Java Mug",
    "Duke Juggling Dolls",
    "Java Pin",
    "Java Key Chain"
};
// ...
var out = new DataOutputStream(new BufferedOutputStream(
              new FileOutputStream(dataFile)));
// ...
for (int i = 0; i < prices.length; i ++) {
    out.writeDouble(prices[i]);
    out.writeInt(units[i]);
    out.writeUTF(descs[i]);
}
```

### Formázás, tokenizálás

#### `Scanner` osztály

1. A bemenet tokenekre bontásához, megfelelő típusúvá alakításához
1. Alapértelmezés szerint whitespace-eket használnak a tokenek határolásához
1. Iterator pattern

```
Scanner sc = new Scanner(new File("myNumbers"));
while (sc.hasNextLong()) {
    long aLong = sc.nextLong();
}
```

#### Formázás

1. A kívánt formátum kényelmes eléréséhez
1. `PrintWriter` (karakter alapú) és `PrintStream` (byte alapú) osztályok segítségével
1. `print`, `println` metódusokkal az adott típusnak megfelelően
1. `format`metódussal az adott format stringnek megfelelően.

```java
public class Root {
    public static void main(String[] args) {
        int i = 2;
        double r = Math.sqrt(i);
        
        System.out.print("The square root of ");
        System.out.print(i);
        System.out.print(" is ");
        System.out.print(r);
        System.out.println(".");

        i = 5;
        r = Math.sqrt(i);
        System.out.println("The square root of " + i + " is " + r + ".");
    }
}
```

```java
public class Root2 {
    public static void main(String[] args) {
        int i = 2;
        double r = Math.sqrt(i);
        
        System.out.format("The square root of %d is %f.%n", i, r);
    }
}
```

## Állománykezelés

### A `Path` osztály

1. Egy (nem feltétlenül létező) fájlrendszer-beli elérési útvonalat reprezentál
1. Nem platformfüggetlen, pl. Linuxon a `/home/joe/foo` formátumot használja, Windows-on a `C:\home\joe\foo`-t
1. A `Files` osztályban található meg számos, fájlkezeléssel kapcsolatos metódus.

### A `File` osztály

1. Egy fájlrendszerbeli fájl, könyvtár, partíció, stb. elérési útjának absztrakt, platformfüggetlen reprezentációja
1. Az reprezentált absztrakt elérési útnak és a hozzá tartozó metaadatoknak eléréséhez és manipulálásáhozl