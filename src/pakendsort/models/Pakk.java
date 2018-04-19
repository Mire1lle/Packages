package pakendsort.models;

/**
 * Created by admin on 15.03.17.
 */
public class Pakk {
    double laius;
    double pikkus;

    public Pakk(double laius, double pikkus) {
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

    public double getArea() {
        return laius * pikkus;
    }
}
