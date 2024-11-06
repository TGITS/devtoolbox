/// usr/bin/env jbang "$0" "$@" ; exit $?
// A exécuter avec JBang : jbang some-super-heroes-height-facts.java

import java.util.Map;
import java.util.Comparator;
import java.util.HashMap;


class DictionaryProcessingExample {

    public static void main(String... args)  {
       Map<String, Double> heightBySuperHeroName = new HashMap<>();
       /* Height of some superheroes - data found on the Super Hero Dataset (https://www.kaggle.com/datasets/claudiodavi/superhero-set) on Kaggle */
       heightBySuperHeroName.put("Brainiac", 198.0);
       heightBySuperHeroName.put("Captain Marvel", 180.0);
       heightBySuperHeroName.put("Ant-Man", 211.0);
       heightBySuperHeroName.put("Aquaman", 185.0);
       heightBySuperHeroName.put("Batman", 188.0);
       heightBySuperHeroName.put("Catwoman", 175.0);
       heightBySuperHeroName.put("Chuck Norris", 178.0);

       int height_threshold = 200;

       System.out.println("Heroes with the max height of the superheroes sample below the treshold (" + Integer.toString(height_threshold) + ") : " + heightBySuperHeroName.entrySet().stream().filter(entry -> entry.getValue() < height_threshold).max(Comparator.comparingDouble(entry -> entry.getValue())).get().getKey());
       System.out.println("Heroes with the min height of the superheroes sample below the treshold (" + Integer.toString(height_threshold) + ") : " + heightBySuperHeroName.entrySet().stream().filter(entry -> entry.getValue() < height_threshold).min(Comparator.comparingDouble(entry -> entry.getValue())).get().getKey());
    }

}