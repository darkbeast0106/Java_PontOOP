package hu.petrik.pontoop;

public class Pont {
    private int x;
    private int y;

    /*
    Konstruktor:
        - nincs visszatérési értéke (még void sem)
        - Neve mindig az osztály nevével egyezik meg
        - Több is lehet belőle
        - Alapértelmezett konstruktor nincs paramétere mindent alapértelmezett értékre állít be.
            - Ha nem hozunk létre konstruktort akkor is lesz alapértelmezett konstruktor
            - Alapértelmezett értékek
                - számnál: 0
                - logikai: false
                - string/object: null
     */
    public Pont(){
        x = 0;
        y = 0;
    }
    /*
    Túlterheltük a konstruktor
        - Ugyan az a neve
        - Más paraméterezésű
     */
    public Pont(int x, int y){
        this.x = x; //this kulcsszó az éppen aktuális objektumpéldányra hivatkozik
        this.y = y;
    }

    public Pont(int tartomany){
        this.x = (int)(Math.random()*tartomany);
        this.y = (int)(Math.random()*tartomany);
    }
    /*
    El kellene érni az X és Y változót kintről
        - getter és setter metódusok
        - getter -> az adatagokat publicusan lekérdezhetővé teszik
        - setter -> az adattagok publikusan módosíthatók vele
     */

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    //Ez is getter az x értékéhez, de tipikusan getValtozoNeve néven hozzuk létre őket
    public int xKoordinataErteke(){
        return this.x;
    }

    public double origotolVettTavolsag(){
        return Math.sqrt(Math.pow(this.x, 2)+Math.pow(this.getY(), 2));
        //Osztályon belül meg lehet hívni a gettert is
    }

    //Pont távolsága másik ponttól
    public double getTavolsag(Pont masikPont){
        return Math.sqrt(Math.pow(this.x - masikPont.x, 2)+Math.pow(this.getY() - masikPont.y, 2));
    }

    @Override
    public String toString() {
        return "Pont{" +
                "x=" + this.x +
                ", y=" + this.y +
                '}';
    }
}
