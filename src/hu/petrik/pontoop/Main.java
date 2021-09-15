package hu.petrik.pontoop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Pont p1 = new Pont();
        System.out.println(p1);
        //[0,10[
        Pont p2 = new Pont(10);
        System.out.println(p2);
        /*
        létrehoztunk egy 5db egész értéket tartalmazó tömböt
            - 5 * 32 bit (4 bájt) lefoglalva a memóriából
         */
        int[] egeszTomb = new int[5];
        //egész tömb bejárása foreach ciklussal
        for (int egesz: egeszTomb) {

        }
        //Pontokból álló tömb (12 elem)
        Pont[] pontTomb = new Pont[12];
        /*
        Feladat elemméternek megfelelő hosszúságó pont tömb ahol a pontok ugyan olyan távolságra
        vannak az x és y koordinátától
         */
        for (int i = 0; i < pontTomb.length; i++) {
            pontTomb[i] = new Pont(i,i);
        }
        for (Pont pont: pontTomb) {
            System.out.println(pont+" origotól a távolsága: "+pont.origotolVettTavolsag());
        }

        //p2 Pont távolsága origotól - Pitagorasz tétel használható
        //Math.sqrt() Math.pow() sqrt(x^2+y^2)
        System.out.println(origotolVettTavolsag(p2));
        System.out.println(p2.getTavolsag(p1));

        List<Pont> pontLista = fajlOlvasas("pontok.txt");
        for (Pont pont: pontLista) {
            System.out.println(pont);
        }
    }

    //Fájl beolvasása FileReader és BufferedReader segítségével
    public static List<Pont> fajlOlvasas(String fajlNev) {
        List<Pont> pontLista = new ArrayList<>();
        try {
            FileReader fr = new FileReader(fajlNev);
            BufferedReader br = new BufferedReader(fr);
            String sor = br.readLine(); //egy sor olvasása, stringet ad vissza
            while (sor != null){
                String[] adatok = sor.split(";");
                //Nem karaktert hanem regexet vár -> " között kell megadni nem '
                int x = Integer.parseInt(adatok[0]);
                int y = Integer.parseInt(adatok[1]);
                Pont p = new Pont(x, y);
                pontLista.add(p);
                sor = br.readLine();
            }
            /*
            Bezárás fontos, hogy ne legyen hiba:
                - "Másik program használja" mert nyitva hagytuk olvasáskor
                - Íráskor alapból csak bufferbe ír, és bezáráskor ment le -> elveszehet amit írtunk
             */
            br.close();
            fr.close();
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        return pontLista;
    }

    /*
    OOP-s szemlélettel nem jó megoldás, jó lenne ha az osztály tudná ezt kiszámolni.
     */
    public static double origotolVettTavolsag(int x, int y){
        return Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
    }

    public static double origotolVettTavolsag(Pont p){
        return Math.sqrt(Math.pow(p.getX(), 2)+Math.pow(p.getY(), 2));
        //vagy
        //return origotolVettTavolsag(p.getX(), p.getY());
    }
}
