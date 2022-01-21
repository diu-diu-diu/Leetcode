package javaPackage.Interface;

public class Cat extends Animal {
    @Override
    public void eat() {
        System.out.println("eat!!!");
    }

    public Cat() {
    }

    public Cat(String name, int age) {
        super(name, age);
    }

    public void test(){
        Jump j = new Jump(){
            @Override
            public void jump() {
                System.out.println("匿名内部类");
            }
        };
        j.jump();
    }

}
