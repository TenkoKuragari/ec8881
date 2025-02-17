public interface MyInterface {
    void method1();
    default void method2() {
        System.out.println("MyInterface method2");
    }
}

class MyClass implements MyInterface {
    @Override
    public void method1() {
        System.out.println("MyClass method1");
    }

    public static void main(String[] args) {
        MyClass mc1 = new MyClass();
        mc1.method1();
        mc1.method2();
    }
}