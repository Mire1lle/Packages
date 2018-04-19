package pakendsort.models;

/**
 * Created by admin on 15.03.17.
 */
public class Toru {
    double laius;
    double pikkus;

    public Toru(double laius) {
        this.laius = laius;
        pikkus = 500; //default
    }

    public Toru(double laius, double pikkus) {
        this.laius = laius;
        this.pikkus = pikkus;
    }

    public double getLaius() {
        return laius;
    }

    public void setLaius(double laius) {
        this.laius = laius;
    }

    public double getPikkus() {
        return pikkus;
    }

    public void setPikkus(double pikkus) {
        this.pikkus = pikkus;
    }
}
