package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // a) Создайте массив из N случайных чисел от 0 до 100
        int N = 100;
        ArrayList<Integer> arr = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            arr.add((int) (Math.random() * 100));
        }
        System.out.println("Original Array: " + arr);

        // b) На основе массива создайте список List
        List<Integer> list = new ArrayList<>(arr);
        System.out.println("List: " + list);

        // c) Отсортируйте список по возрастанию
        Collections.sort(list);
        System.out.println("Sorted List (ASC): " + list);

        // d) Отсортируйте список в обратном порядке
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("Sorted List (DESC): " + list);

        // e) Перемешайте список
        Collections.shuffle(list);
        System.out.println("Shuffled List: " + list);

        // f) Выполните циклический сдвиг на 1 элемент
        Collections.rotate(list, 1);
        System.out.println("Rotated List: " + list);

        // g) Оставьте в списке только уникальные элементы
        Set<Integer> uniqueSet = new HashSet<>(list);
        System.out.println("Unique Elements: " + uniqueSet);

        // h) Оставьте в списке только дублирующиеся элементы
        List<Integer> duplicates = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        for (Integer num : list) {
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }
        System.out.println("Duplicate Elements: " + duplicates);

        // i) Из списка получите массив
        Integer[] arrayFromList = list.toArray(new Integer[0]);
        System.out.println("Array from List: " + Arrays.toString(arrayFromList));

        // j) Посчитайте количество вхождений каждого числа в массив и выведите на экран
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (Integer num : list) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        System.out.println("Frequency of each element: " + frequencyMap);


        // Task 3


        List<Human> humans = new ArrayList<>();
        humans.add(new Human("Egor", "Javascriptov", 30));
        humans.add(new Human("Egor", "Golangov", 25));
        humans.add(new Human("Vlad", "CSharpov", 40));
        humans.add(new Human("Semen", "Debilov", 35));

        Set<Human> hashSet = new HashSet<>(humans);
        System.out.println("HashSet:");
        for (Human human : hashSet) {
            System.out.println(human);
        }

        Set<Human> linkedHashSet = new LinkedHashSet<>(humans);
        System.out.println("\nLinkedHashSet:");
        for (Human human : linkedHashSet) {
            System.out.println(human);
        }

        Set<Human> treeSetByName = new TreeSet<>(humans);
        System.out.println("\nTreeSet (по имени):");
        for (Human human : treeSetByName) {
            System.out.println(human);
        }

        Set<Human> treeSetByLastName = new TreeSet<>(new HumanComparatorByLastName());
        treeSetByLastName.addAll(humans);
        System.out.println("\nTreeSet (по фамилии):");
        for (Human human : treeSetByLastName) {
            System.out.println(human);
        }

        Set<Human> treeSetByAge = new TreeSet<>(new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                return Integer.compare(h1.getAge(), h2.getAge());
            }
        });
        treeSetByAge.addAll(humans);
        System.out.println("\nTreeSet (по возрасту):");
        for (Human human : treeSetByAge) {
            System.out.println(human);
        }

        // 1. HashSet: Элементы выводятся в произвольном порядке, т.к. HashSet не гарантирует порядок хранения элементов.
        // 2. LinkedHashSet: Элементы выводятся в том порядке, в котором были добавлены в коллекцию.
        // 3. TreeSet (Comparable): Элементы сортируются по имени (т.к. реализация Comparable в классе Human основана на firstName).
        // 4. TreeSet (Comparator by last name): Элементы сортируются по фамилии, т.к. используется наш компаратор HumanComparatorByLastName.
        // 5. TreeSet (анонимный компаратор по возрасту): Элементы сортируются по возрасту, т.к. для сортировки используется анонимный компаратор.


        // Task 4


        String inputText = "Hello, hello nice to meet you! Are you great?";

        String[] words = inputText.toLowerCase().split("\\W+");

        HashMap<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }


        // Task 5


        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("one", 1);
        originalMap.put("two", 2);
        originalMap.put("three", 3);

        Map<Integer, String> invertedMap = invertMap(originalMap);

        for (Map.Entry<Integer, String> entry : invertedMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static <K, V> Map<V, K> invertMap(Map<K, V> originalMap) {
        Map<V, K> invertedMap = new HashMap<>();

        for (Map.Entry<K, V> entry : originalMap.entrySet()) {
            invertedMap.put(entry.getValue(), entry.getKey());
        }

        return invertedMap;
    }
}