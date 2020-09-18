package sandbox.TryTest;

public class Test1 {
    public static void main(String[] args) {
        boolean bExit = false;
        int i = 0;

        System.out.println("До входа в блок try");
        while(!bExit) {
            try {
                System.out.println("В блоке трай");
                break;
            } catch (Exception e) {
                System.out.println("В блоке кетч");
                i++;
            } finally {
                System.out.println("В блоке файнали");
            }
            if(i == 3) bExit = true;
        }
    }

}
