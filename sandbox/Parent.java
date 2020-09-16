package sandbox;

public class Parent {
    private int privateValue = 1;
    protected int protectedValue = 2;
    public int publicValue = 3;

    public int getPrivateValue() {
        return privateValue;
    }

    public void setPrivateValue(int privateValue) {
        this.privateValue = privateValue;
    }

    private void sayHelloPrivate() {
        System.out.println("Hello! i a'm private!");
    }

    protected void sayHelloProtected() {
        System.out.println("I'm protected!");
    }

    public void sayHelloPublic() {
        System.out.println("I'm protected!");
    }

}

