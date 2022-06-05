package org.example.shunin.sand;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        Cat cat1 = new Cat("Barsik", 12);
        Cat cat2 = new Cat("Bob", 4);
        Cat cat3 = new Cat("Arhci", 8);
        Cat cat4 = new Cat("Lolik", 10);
        Cat cat5 = new Cat("Furia", 15);

        List<Cat> catList = new ArrayList<>(List.of(cat1, cat2, cat3, cat4, cat5));

        Predicate<Cat> pr1 = cat -> cat.getAge() < 13;
        Predicate<Cat> pr2 = cat -> cat.getName().startsWith("B");

        Predicate<Cat> pr3 = Main::remName;
        Predicate<Cat> pr4 = Main::remAge;
        Predicate<Cat> pr5 = Predicate.isEqual(cat3);
        BiPredicate<String, Integer> pr6 = (a, b) -> a.length() < b;

        System.out.println(pr6.test("Helloy", 8));


        //catList.removeIf(pr3.and(pr4));

      //  catList.removeIf(pr3.negate());
       // catList.removeIf(Predicate.not(a -> a.getName().startsWith("B")));

       // catList.removeIf(pr1.and(pr2));
        System.out.println(catList);

    }

    public static boolean remAge(Cat cat) {
        return  cat.getAge() < 13;
    }
    public static boolean remName(Cat cat) {
        return cat.getName().startsWith("B");
    }



}
