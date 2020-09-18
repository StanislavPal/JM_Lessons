package sandbox.TryTest;

public class Test2 {
    public static void main(String[] args) {
        boolean bExit = false;
        int i = 0;

        Res res = new Res();
        System.out.println("До входа в блок try");
        while(!bExit) {
            try {
                System.out.println("В блоке трай");
                break;
            } catch (Exception e) {
                System.out.println("В блоке кетч");
                i++;
            } finally {
                try {
                    res.close();
                } catch (Exception e2) {
                    System.out.println("Во 2 блоке кетч");
                } finally {
                    System.out.println("Во 2 блоке файнали");
                }
                System.out.println("В 1 блоке файнали");
            }
            if(i == 3) bExit = true;
        }
    }

    static class Res implements AutoCloseable {

        @Override
        public void close() throws Exception {
            System.out.println("Закрыли ресурс");
        }
    }
}


