package sandbox.TryTest;

public class Test3 {
    public static void main(String[] args) {
        boolean bExit = false;
        int i = 0;

        System.out.println("До входа в блок try");
        while(!bExit) {
            try( Res res = new Res() ) {
                System.out.println("В блоке трай");
                break;
            } catch (Exception e) {
                System.out.println("В блоке кетч");
                i++;
            }
            if(i == 3) bExit = true;
        }
        System.out.println("После блока трай");
    }

    static class Res implements AutoCloseable {
        @Override
        public void close() throws Exception {
            System.out.println("Закрыли ресурс");
        }
    }
}


