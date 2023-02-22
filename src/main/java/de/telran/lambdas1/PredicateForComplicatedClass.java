package de.telran.lambdas1;

import java.util.function.Predicate;

public class PredicateForComplicatedClass implements Predicate<OuterClass> {
        @Override
        public boolean test(OuterClass outerClass) {
                //....
                //....
                return false;
        }
}
