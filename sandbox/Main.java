package sandbox;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Parent parent = new Parent();
        System.out.println(parent.protectedValue);
        System.out.println(parent.getPrivateValue());

        Child child = new Child();
        child.showInfo();
        child.protectedValue = 50;
        child.publicValue = 70;
        child.showInfo();
    }
}

class Child extends Parent {
    Child(){
        protectedValue = 20;
        publicValue = 30;
    }

    public void showInfo() {
        System.out.println(protectedValue + " == " + publicValue);
    }

}
