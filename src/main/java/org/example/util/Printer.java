package org.example.util;

import java.util.Collection;
import java.util.stream.Stream;
public class Printer {
    public static void printSeparator() {
        System.out.println("----------------------");
    }

    public static <T> void printElements(Stream<T> stream) {
        // stream.forEach(System.out::println);
        stream.map(Object::toString) // Convert elements to strings
                .forEach(System.out::println);
    }

    public static <T> void printElements(Collection<T> collection) {
        // list.forEach(System.out::println);
        collection.stream()
                .map(Object::toString)
                .forEach(System.out::println);
    }

    public static <T> void printElement(T element) {
        System.out.println(element);
    }

    private Printer() {

    }
}
