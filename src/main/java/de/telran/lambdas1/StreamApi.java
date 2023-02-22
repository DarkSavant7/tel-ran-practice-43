package de.telran.lambdas1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class StreamApi {

    public static void main(String[] args) {
//        functionalInterfaceIntroduction();
//        innerExample();
//        nestedMicroExample();
//        localClassExample();
//        anonymousExample();
//        functionsExample();

        var strings = new ArrayList<>(List.of("January", "February", "March", "April", "May"));
//        strings.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return 0;
//            }
//        });

        strings.sort((o1, o2) -> o1.length() - o2.length());
    }

    private static void functionsExample() {


        List<OuterClass> outers = new ArrayList<>(List.of(
                new OuterClass(),
                new OuterClass()
        ));

        outers.removeIf(new PredicateForComplicatedClass());
        outers.removeIf(o -> o.getInner() != null);

        Predicate<OuterClass> predicate1 = new Predicate<OuterClass>() {
            @Override
            public boolean test(OuterClass outerClass) {
                return outerClass.getInner() != null;
            }
        };

        Predicate<OuterClass> predicate2 = outer -> outer.getInner() != null;

        outers.removeIf(predicate2);
    }

    private static void anonymousExample() {
        AbstractClass abs = new AbstractClass() {
            private String anonField1;
            private String anonField2;

            void anonMethod() {
                System.out.println(" mnlsaflnjsdvfonjsdvf");
            }

            public String getAnonField1() {
                return anonField1;
            }

            public void setAnonField1(String anonField1) {
                this.anonField1 = anonField1;
            }

            public String getAnonField2() {
                return anonField2;
            }

            public void setAnonField2(String anonField2) {
                this.anonField2 = anonField2;
            }

            @Override
            public void doSomethingAbstract() {
                System.out.println("Anon function");
                anonMethod();
            }
        };

        abs.doSomethingAbstract();
        abs.someMethod();
//        abs.anonMethod();
    }

    private static void localClassExample() {
        class LocalClass extends Ship implements Cloneable {
            private String stringField;

            public LocalClass(String stringField) {
                this.stringField = stringField;
            }

            public String getStringField() {
                return stringField;
            }

            public void setStringField(String stringField) {
                this.stringField = stringField;
            }

            public void doSomething() {
                System.out.println("Something local");
            }
        }

        LocalClass local = new LocalClass("Local field");
        local.doSomething();
    }

    private static void nestedMicroExample() {
        OuterClass.NestedClass nested = new OuterClass.NestedClass("Nested");

        System.out.println(nested);
    }

    private static void innerExample() {
        OuterClass outer = new OuterClass(
                "Str",
                10,
                "INNER");

        System.out.println(outer);
        OuterClass.InnerClass inner = outer.getInner();
        inner.printOuterSomeField();


//        OuterClass.InnerClass inner2 = new OuterClass.InnerClass("ddddd"); won't work
//        OuterClass.InnerClass inner3 = outer.new InnerClass("IIII");
        OuterClass.InnerClass inner4 = new OuterClass(
                "SSS",
                14,
                "Inner"
        ).new InnerClass("NEW INNER");

        OuterClass.InnerClass inner5 = outer.createInnerInstance("Inner  5");
    }

    private static void functionalInterfaceIntroduction() {
        Moving[] units = {
                new Human(),
                new Plane(),
                new Ship(),
                new Moving() {
                    @Override
                    public void move() {
                        System.out.println("Anonymous slides");
                    }
                },
                () -> System.out.println("Lambda crawls"),
                () -> System.out.println("Anonymous2 slides")
        };

//        for (Moving unit : units) {
//            unit.move();
//        }

        var movingList = Arrays.asList(units);
//        movingList.forEach(new Consumer<Moving>() {
//            @Override
//            public void accept(Moving moving) {
//                moving.move();
//            }
//        });
//        movingList.forEach(moving -> moving.move());
//        movingList.forEach(Moving::move);
//        movingList.forEach(System.out::println);


        var strings = new ArrayList<>(List.of("January", "February", "March", "April", "May"));

//        strings.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.length() - o1.length();
//            }
//        });

//        strings.sort((s1, s2) -> s2.length() - s1.length());
//        strings.sort((s1, s2) -> s1.compareTo(s2));
//        strings.sort(String::compareTo);
//
//        System.out.println(strings);
//
//        var alphabet = new ArrayList<>(List.of("d", "q", "w", "h"));
//
//        alphabet.sort(String::compareTo);
//        System.out.println(alphabet);
//
//        Map<Character, Integer> standardAlphabet = Map.of('a', 1, 'b', 2, 'c', 3);//....
//        alphabet.sort((s1, s2)
//                -> standardAlphabet.getOrDefault(s1.charAt(0), 0)
//                - standardAlphabet.getOrDefault(s2.charAt(0), 0));

//        alphabet.sort(Comparator
//                .comparingInt(s -> standardAlphabet
//                        .getOrDefault(s.charAt(0), 0)));

//        strings.removeIf(new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return s.length() > 5;
//            }
//        });

//        strings.removeIf(s -> s.length() > 5);
//        System.out.println(strings);

//        strings.replaceAll(new UnaryOperator<String>() {
//            @Override
//            public String apply(String s) {
//                return s + "-month";
//            }
//        });

        strings.replaceAll(s -> s + "-month");
        System.out.println(strings);
    }
}
