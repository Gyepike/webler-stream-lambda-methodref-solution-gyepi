package org.example.dataload;

import java.util.*;

public class DataLoad {

    public List<Integer> nums1()  { return List.of(); }

    public Set<Double> nums4() {
           return new HashSet<>(Arrays.asList(1.1, 1.1, 1.1, 2.2, 3.3, 4.4, 5.5));
    }

    public List<String> words() {
        return Arrays.asList("Péter", "Roland");
    }

    public List<Number> nums2() {
        return Arrays.asList(1.1, 2.2, 3.3, 4.4, 5.5);
    }

    public List<Integer> nums3() {
    return  Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    public List<Integer> nums5() {
        return Arrays.asList(1, 0, 2, 100);
    }
}
