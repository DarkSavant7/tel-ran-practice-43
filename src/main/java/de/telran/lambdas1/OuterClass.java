package de.telran.lambdas1;

import java.io.Serializable;

public class OuterClass extends Human {
    private String someStringField;
    private int someIntegerField;
    private InnerClass inner;

    public OuterClass() {
    }

    public OuterClass(String someStringField, int someIntegerField, String innerField) {
        this.someStringField = someStringField;
        this.someIntegerField = someIntegerField;
        this.inner = new InnerClass(innerField);
    }

    public InnerClass createInnerInstance(String field) {
        return new InnerClass(field);
    }

    public InnerClass getInner() {
        return inner;
    }

    public void doSomething() {
//        System.out.println(innerField);
        System.out.println(inner.innerField);
//        System.out.println(inner.getInnerField());
    }

    public int getSomeIntegerField() {
        return someIntegerField;
    }

    public String getSomeStringField() {
        return someStringField;
    }

    public void setSomeStringField(String someStringField) {
        this.someStringField = someStringField;
    }

    @Override
    public String toString() {
        return "OuterClass{" +
                "someStringField='" + someStringField + '\'' +
                ", someIntegerField=" + someIntegerField +
                ", inner=" + inner +
                '}';
    }

    public class InnerClass extends Plane implements Serializable {
        private String innerField;

        public void printOuterSomeField() {
            System.out.println(someStringField);
        }

        public InnerClass(String innerField) {
            this.innerField = innerField;
        }

        public String getInnerField() {
            return innerField;
        }

        public void setInnerField(String innerField) {
            this.innerField = innerField;
        }

        @Override
        public String toString() {
            return "InnerClass{" +
                    "innerField='" + innerField + '\'' +
                    '}';
        }
    }

    public static class NestedClass {
        private String stringField;

        public NestedClass(String stringField) {
            this.stringField = stringField;
        }

        public String getStringField() {
            return stringField;
        }

        public void setStringField(String stringField) {
            this.stringField = stringField;
        }

        @Override
        public String toString() {
            return "NestedClass{" +
                    "stringField='" + stringField + '\'' +
                    '}';
        }
    }
}
