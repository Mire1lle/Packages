package pakendsort;


import pakendsort.models.Pakk;
import pakendsort.models.Toru;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by admin on 15.03.17.
 */
public class Main {
    public static boolean main(String input) {
        List<Double> inputs = getDoubles(input);
        if (inputs.size() > 2) {
            Pakk pakk = getPakk(inputs);
            //kui toru on üks, siis pole vaja nurkade arvestamise loogikat alustada,
            // ja saab lihtsalt kontrollida, et pakk mahtuks torusse.
            // Muidu arvutame kas mahub ka nurkadesse.
            if (inputs.size() == 3) {
                Double toruLaius = inputs.get(2);
                return pakk.getLaius() < toruLaius;
            } else {
                return fitsIntoMoreThanOneToru(inputs, pakk);
            }
        } else {
            System.out.println("You did not fill the input condition");
            return false;
        }
    }

    private static boolean fitsIntoMoreThanOneToru(List<Double> inputs, Pakk pakk) {
        List<Toru> torud = getTorud(inputs);
        return mahubLajusteJargi(pakk, torud) && mahubPindalateJargi(pakk, torud);
    }

    private static boolean mahubPindalateJargi(Pakk pakk, List<Toru> torud) {
        return getAreasOfCorners(torud).stream().allMatch(a -> pakk.getArea() < a);
    }

    private static List<Double> getAreasOfCorners(List<Toru> torud) {
        List<Double> areasOfCorners = new ArrayList<>();
        for (int i = 0; i < torud.size()-1; i++) {
           areasOfCorners.add(torud.get(i).getLaius()*torud.get(i+1).getLaius());
        }
        return areasOfCorners;
    }

    private static boolean mahubLajusteJargi(Pakk pakk, List<Toru> torud) {
        return torud.stream().allMatch(t -> pakk.getLaius() < t.getLaius());
    }

    private static List<Toru> getTorud(List<Double> inputListDoubles) {
        List<Toru> torud = new ArrayList<>();
        for (int i = 2; i < inputListDoubles.size(); i++) {
            torud.add(new Toru(inputListDoubles.get(i)));
        }
        return torud;
    }

    private static Pakk getPakk(List<Double> inputListDoubles) {
        Double sideA = inputListDoubles.get(0);
        Double sideB = inputListDoubles.get(1);
        return sideA > sideB ? new Pakk(sideB, sideA) : new Pakk(sideA, sideB);
    }

    private static List<Double> getDoubles(String input) {
        List<String> inputListStrings = Arrays.asList(input.split(",\\s*"));
        return inputListStrings.stream().map(str -> Double.parseDouble(str)).collect(Collectors.toList());
    }
}
