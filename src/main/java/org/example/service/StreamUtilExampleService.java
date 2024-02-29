package org.example.service;

import org.example.dataload.DataLoad;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.example.util.DecimalFormatHelper.createDecimalFormat;

public class StreamUtilExampleService {

    DataLoad dataLoad;

    public StreamUtilExampleService(DataLoad dataLoad) {
        this.dataLoad = dataLoad;
    }

    public <T> Stream<T> createStreamFromCollection(Collection<T> collection) {
        return collection.stream();
    }

    public Collection<? extends Number> squareNumbers(Collection<? extends Number> nums) {
        boolean isFloatingPoint = false;

        // Check if the collection contains floating-point numbers
        for (Number num : nums) {
            if (num instanceof Double || num instanceof Float) {
                isFloatingPoint = true;
                break;
            }
        }

        // Square the numbers accordingly
        if (isFloatingPoint) {
            DecimalFormat df = createDecimalFormat();
            return nums.stream()
                    .map(num -> Double.parseDouble(df.format(Math.pow(num.doubleValue(), 2))))
                    .collect(Collectors.toList());
        } else {
            return nums.stream()
                    .map(num -> num.intValue() * num.intValue())
                    .collect(Collectors.toList());
        }
    }

    public <T extends Number> double sumElements(Collection<T> collection) {
        Optional<?> firstElement = collection.stream().findFirst();
        if (firstElement.isPresent() &&
                ((firstElement.get() instanceof Double) || (firstElement.get() instanceof Float))) {
            return collection.stream()
                    .mapToDouble(Number::doubleValue)
                    .sum();
        } else {
            return collection.stream()
                    .mapToInt(Number::intValue)
                    .sum();
        }
    }

    public <T extends Number> T sumElementsMoreGeneric(Collection<T> collection) {
        Optional<T> firstElement = collection.stream().findFirst();
        if (firstElement.isPresent()) {
            Class<?> elementType = firstElement.get().getClass();
            if (elementType.equals(Double.class) || elementType.equals(Float.class)) {
                double sum = collection.stream()
                        .mapToDouble(Number::doubleValue)
                        .sum();
                return (T) Double.valueOf(sum);
            } else {
                long sum = collection.stream()
                        .mapToLong(Number::longValue)
                        .sum();
                if (elementType.equals(Integer.class)) {
                    return (T) Integer.valueOf((int) sum);
                } else {
                    return (T) Long.valueOf(sum);
                }
            }
        }
        return null; // Default value if collection is empty
    }

    public <T extends Number> double sumElements(List<T> nums) {
        if (nums.getFirst() instanceof Double || nums.getFirst() instanceof Float) {
            return nums.stream()
                    .mapToDouble(Number::doubleValue)
                    .sum();
        } else {
            return nums.stream()
                    .mapToInt(Number::intValue)
                    .sum();
        }
    }

    public <T extends Number> Collection<T> filterEven(Collection<T> nums) {
        return nums.stream()
                .filter(num -> num.intValue() % 2 == 0)
                .collect(Collectors.toList());
    }

    public <T extends Number> Collection<String> squareRootElements(Collection<T> collection) {
        return collection.stream()
                .map(Number::doubleValue)
                .map(Math::sqrt)
                .map(num -> String.format("%.2f", num))
                .collect(Collectors.toList());
    }

    public <T extends Number> Collection<T> filterAndCopy(Collection<T> nums) {
        return nums.stream()
                .filter(num -> num.intValue() % 3 == 0)
                .collect(Collectors.toList());
    }

    public <T extends Number> Collection<T> filterAndCopyGreaterThan(Collection<T> collection, int threshold) {
        return collection.stream()
                .filter(num -> num.intValue() > threshold)
                .collect(Collectors.toList());
    }

    public <T extends Number> Collection<T> filterAndCopyOddGreaterThan(Collection<T> collection, int threshold) {
        return collection.stream()
                .filter(num -> num.intValue() > threshold && num.intValue() % 2 != 0)
                .collect(Collectors.toList());
    }

    public <T extends Number> double calculateProduct(Collection<T> collection) {
        return collection.stream()
                .mapToDouble(Number::doubleValue)
                .reduce(1, (a, b) -> a * b);
    }
}
