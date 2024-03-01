package org.example.service;

import org.example.dataload.DataLoad;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static org.example.util.Printer.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("Unit test of StudentService")
public class StreamUtilExampleServiceTest {

    private StreamUtilExampleService streamUtilExampleService;
    private DataLoad dataLoadMock;

    @BeforeEach
    void setUp() {
        // Customize the behavior of dataInitializerMock as needed for each test case
      dataLoadMock = mock(DataLoad.class);
      streamUtilExampleService = new StreamUtilExampleService(dataLoadMock);
    }

    @Test()
    @DisplayName("Test Task01 method")
    void testTask01() { // naming convention: testMethodName_StateUnderTest_ExpectedBehavior instead of this: void testGetStudents()
        // Arrange
       List<Integer> nums1 = createNumbersIntList();
       List<String> word = createStringList();

       when(dataLoadMock.nums1()).thenReturn(nums1);
       when(dataLoadMock.words()).thenReturn(word);

        // Act and Assert
       Stream<Integer> numbers = streamUtilExampleService.createStreamFromCollection(dataLoadMock.nums1());
       Stream<String> words = streamUtilExampleService.createStreamFromCollection(dataLoadMock.words());

       System.out.println("--------Task01---------");
       printSeparator();

        // Assert
        assertNotNull(numbers);
        assertEquals(5, numbers.count());
        assertNotNull(words);
        assertEquals(2, words.count());
    }

    @Test()
    @DisplayName("Test Task02 method")
    void testTask02() { // naming convention: testMethodName_StateUnderTest_ExpectedBehavior instead of this: void testGetStudents()
        // Arrange
        List<Integer> nums1 = createNumbersIntList();
        List<Number> nums2 = createNumbersList();
        List<Integer> squareNumbersTest1 = Arrays.asList(1, 4, 9, 16,49);
        List<Double> squareNumbersTest2 = Arrays.asList(1.21d, 4.84d, 10.89d, 19.36d, 30.25d);

        when(dataLoadMock.nums1()).thenReturn(nums1);
        when(dataLoadMock.nums2()).thenReturn(nums2);

        // Act and Assert
        Collection<? extends Number> squaredNums1 = streamUtilExampleService.squareNumbers(dataLoadMock.nums1());
        Collection<? extends Number> squaredNums2 = streamUtilExampleService.squareNumbers(dataLoadMock.nums2());

        printElements(squaredNums1);
        printSeparator();
        printElements(squaredNums2);

        // Assert
        assertNotNull(squaredNums1);
        assertEquals(5, squaredNums1.stream().count());
        assertEquals(squareNumbersTest1,squaredNums1);
        assertEquals(squareNumbersTest2,squaredNums2);

        System.out.println("--------Task02---------");
    }

    @Test()
    @DisplayName("Test Task03 method")
    void testTask03() { // naming convention: testMethodName_StateUnderTest_ExpectedBehavior instead of this: void testGetStudents()
        // Arrange
        List<Integer> nums1 = createNumbersIntList();
        List<Number> nums2 = createNumbersList();

        when(dataLoadMock.nums1()).thenReturn(nums1);
        when(dataLoadMock.nums2()).thenReturn(nums2);

        // Act and Assert
        int sum1 = (int) streamUtilExampleService.sumElements(dataLoadMock.nums1());
        double sum2 = streamUtilExampleService.sumElements(dataLoadMock.nums2());

        System.out.println("--------Task03---------");
        printElement(sum1);
        printSeparator();
        printElement(sum2);
        printSeparator();
        System.out.println("--------Task03---------");

        // Assert
        assertEquals(17, sum1);
        assertEquals(16.5, sum2);
    }

    @Test()
    @DisplayName("Test Task04 method")
    void testTask04() { // naming convention: testMethodName_StateUnderTest_ExpectedBehavior instead of this: void testGetStudents()
        // Arrange
        List<Integer> nums1 = createNumbersIntList();
        List<Number> nums2 = createNumbersList();

        when(dataLoadMock.nums1()).thenReturn(nums1);
        when(dataLoadMock.nums2()).thenReturn(nums2);

        // Act and Assert
        System.out.println("--------Task04---------");
        Double sum3 = Double.valueOf(String.valueOf(streamUtilExampleService.sumElementsMoreGeneric(dataLoadMock.nums2())));
        printElement(sum3);
        Integer sum4 = Integer.valueOf(String.valueOf(streamUtilExampleService.sumElementsMoreGeneric(dataLoadMock.nums1())));
        printSeparator();
        printElement(sum4);
        printSeparator();

        // Assert
        assertEquals(16.5, sum3);
        assertEquals(17, sum4);
    }

    @Test()
    @DisplayName("Test Task05 method")
    void testTask05() { // naming convention: testMethodName_StateUnderTest_ExpectedBehavior instead of this: void testGetStudents()
        // Arrange
        List<Integer> nums1 = createNumbersIntList();
        List<Number> nums2 = createNumbersList();
        List<Integer> filteredNumbersTest1 = Arrays.asList(2,4);
        List<Double> filteredNumbersTest2 = Arrays.asList(2.2d, 4.4);

        when(dataLoadMock.nums1()).thenReturn(nums1);
        when(dataLoadMock.nums2()).thenReturn(nums2);

        // Act and Assert
        System.out.println("--------Task05---------");
        Collection<Integer> evenFilteredIntegerNums = streamUtilExampleService.filterEven(dataLoadMock.nums1());
        Collection<Number> evenFilteredDoubleNums = streamUtilExampleService.filterEven(dataLoadMock.nums2());

        printElements(evenFilteredIntegerNums);
        printSeparator();
        printElements(evenFilteredDoubleNums);
        printSeparator();

        // Assert
        assertEquals(filteredNumbersTest1, evenFilteredIntegerNums);
        assertEquals(filteredNumbersTest2, evenFilteredDoubleNums);
    }

    @Test()
    @DisplayName("Test Task06 method")
    void testTask06() { // naming convention: testMethodName_StateUnderTest_ExpectedBehavior instead of this: void testGetStudents()
        // Arrange
        List<Integer> nums1 = createNumbersIntList();
        List<Number> nums2 = createNumbersList();
        List<String> filteredNumbersTest1 = Arrays.asList("1,00","1,41","1,73","2,00","2,65");
        List<String> filteredNumbersTest2 = Arrays.asList("1,05","1,48","1,82","2,10","2,35");

        when(dataLoadMock.nums1()).thenReturn(nums1);
        when(dataLoadMock.nums2()).thenReturn(nums2);

        // Act and Assert
        System.out.println("--------Task06---------");
        Collection<String> sqrtIntNums = streamUtilExampleService.squareRootElements(dataLoadMock.nums1());
        Collection<String> sqrtDoubleNums = streamUtilExampleService.squareRootElements(dataLoadMock.nums2());
        printElements(sqrtIntNums);
        printSeparator();
        printElements(sqrtDoubleNums);
        printSeparator();

        // Assert
        assertEquals(filteredNumbersTest1, sqrtIntNums);
        assertEquals(filteredNumbersTest2, sqrtDoubleNums);
    }

    @Test()
    @DisplayName("Test Task07 method")
    void testTask07() { //
        // Arrange
        List<Integer> numbersList = createNumsListTwo();
        List<Integer> filteredNumbersTest1 = Arrays.asList(3,12,9);
        when(dataLoadMock.nums3()).thenReturn(numbersList);

        // Act and Assert
        System.out.println("--------Task07---------");
        Collection<Integer> divisibleByThree = streamUtilExampleService.filterAndCopy(dataLoadMock.nums3());
        printElements(divisibleByThree);
        printSeparator();

        // Assert
        assertEquals(filteredNumbersTest1, divisibleByThree);
    }

    @Test()
    @DisplayName("Test Task08 method")
    void testTask08() { //
        // Arrange
        List<Integer> numbersList = createNumsListTwo();
        List<Integer> filteredNumbersTest1 = Arrays.asList(3,7,9);
        when(dataLoadMock.nums3()).thenReturn(numbersList);

        // Act and Assert
        System.out.println("--------Task09---------");
        int givenNumber = 2;
        Collection<Integer> oddGreaterThan = streamUtilExampleService.filterAndCopyOddGreaterThan(dataLoadMock.nums3(), givenNumber);
        printElements(oddGreaterThan);
        printSeparator();

        // Assert
        assertEquals(filteredNumbersTest1, oddGreaterThan);
    }

    @Test()
    @DisplayName("Test Task09 method")
    void testTask09() { //
        // Arrange
        List<Integer> numbersList = createNumsListTwo();

        when(dataLoadMock.nums1()).thenReturn(numbersList);

        // Act and Assert
        System.out.println("--------Task09---------");
        double product = streamUtilExampleService.calculateProduct(dataLoadMock.nums1());
        printElement(product);
        printSeparator();
        double productInclZero = streamUtilExampleService.calculateProduct(dataLoadMock.nums5());
        printElement(productInclZero);
        printSeparator();

        // Assert
        assertEquals(145152.0, product);
        assertEquals(1.0, productInclZero);
    }

    private List<Integer> createNumsListTwo() {
        return  Arrays.asList(8, 2, 3, 4, 7,12,9);
    }
    public List<Number> createNumbersList() {
        return Arrays.asList(1.1, 2.2, 3.3, 4.4, 5.5);
    }

    private List<Integer> createNumbersIntList() {
        return  Arrays.asList(1, 2, 3, 4, 7);
    }

    private List<String> createStringList() {
        return  Arrays.asList("Péter", "Roland");
    }
}
