package countries;

import javax.xml.namespace.QName;
import java.io.IOException;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.*;

import java.time.ZoneId;
import java.util.stream.IntStream;

public class Homework2 {

    private List<Country> countries;

    public Homework2() {
        countries = new CountryRepository().getAll();
    }

    /**
     * Returns the longest country name translation.
     */
    public Optional<String> streamPipeline1() {

        return Optional.of(countries.stream()
                .flatMap(x -> x.getTranslations().values().stream())
                .max(Comparator.comparing(String::length))
                .get());
    }

    /**
     * Returns the longest Italian (i.e., {@code "it"}) country name translation.
     */
    public Optional<String> streamPipeline2() {

        return Optional.of(countries.stream()
                .flatMap(x -> x.getTranslations().entrySet().stream())
                .filter(x -> x.getKey().equals("it"))
                .map(Map.Entry::getValue)
                .max(Comparator.comparing(String::length))
                .get());
    }

    /**
     * Prints the longest country name translation together with its language code in the form language=translation.
     */
    public void streamPipeline3() {
        // TODO
        /*
        countries.stream()
                .flatMap(x -> x.getTranslations().values().stream())
                .max(Comparator.comparing(String::length))
                .map(x -> x.getTranslations())
                .forEach(entry -> System.out.println(entry.getKey() + "=" + entry.getValue()));

         */
    }


    /**
     * Prints single word country names (i.e., country names that do not contain any space characters).
     */
    public void streamPipeline4() {
        countries.stream()
                .map(Country::getName)
                .filter(name-> !(name.contains(" ")))
                .forEach(System.out::println);

    }

    /**
     * Returns the country name with the most number of words.
     */
    public Optional<String> streamPipeline5() {

        return Optional.of(countries.stream()
                .max(Comparator.comparing(country -> country.getName().split(" ").length))
                .map(Country::getName)
                .get());
                        //.max((str1, str2) ->Comparator.comparingInt(str1.split(" ").length,
                          //      str2.split(" ").length));



    }

    /**
     * Returns whether there exists at least one capital that is a palindrome.
     */
    public boolean streamPipeline6() {
        
        return countries.stream()
                        .filter(x->IntStream.range(0, x.getCapital().length()/2).
                                noneMatch(i -> x.getCapital().charAt(i) != x.getCapital().charAt(x.getCapital().length() - i -1)))
                        .anyMatch(entry -> !entry.getCapital().isEmpty());



    }

    /**
     * Returns the country name with the most number of {@code 'e'} characters ignoring case.
     */
    public Optional<String> streamPipeline7() {
        // TODO
        return null;
    }

    /**
     *  Returns the capital with the most number of English vowels (i.e., {@code 'a'}, {@code 'e'}, {@code 'i'}, {@code 'o'}, {@code 'u'}).
     */
    public Optional<String> streamPipeline8() {
        // TODO
        return null;
    }

    /**
     * Returns a map that contains for each character the number of occurrences in country names ignoring case.
     */
    public Map<Character, Long> streamPipeline9() {
        // TODO
        return null;
    }

    /**
     * Returns a map that contains the number of countries for each possible timezone.
     */
    public Map<ZoneId, Long> streamPipeline10() {
        // TODO
        return null;
    }

    /**
     * Returns the number of country names by region that starts with their two-letter country code ignoring case.
     */
    public Map<Region, Long> streamPipeline11() {
        // TODO
        return null;
    }

    /**
     * Returns a map that contains the number of countries whose population is greater or equal than the population average versus the the number of number of countries with population below the average.
     */
    public Map<Boolean, Long> streamPipeline12() {
        // TODO
        return null;
    }

    /**
     * Returns a map that contains for each country code the name of the corresponding country in Portuguese ({@code "pt"}).
     */
    public Map<String, String> streamPipeline13() {
        // TODO
        return null;
    }

    /**
     * Returns the list of capitals by region whose name is the same is the same as the name of their country.
     */
    public Map<Region, List<String>> streamPipeline14() {
        // TODO
        return null;
    }

    /**
     *  Returns a map of country name-population density pairs.
     */
    public Map<String, Double> streamPipeline15() {
        // TODO
        return null;
    }

}
