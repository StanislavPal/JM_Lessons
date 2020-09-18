package sandbox.TryTest;

import java.sql.SQLException;

public class Test5_try_w_r_for {
    public static void main(String[] args) {
        int i = 0;

        System.out.println("До входа в блок try. i = " + i);
        for (i = 0; i < 3; i++){
            try( Res res = new Res(true) ) {
                System.out.println("В блоке трай. i = " + i);
                i=4;
                System.out.println("В блоке трай. i = " + i);
            } catch (SQLException e) {
                System.out.println("В блоке кетч. i = " + i);
                i++;
            }
            System.out.println("За блоком трай, но внутри цикла. i = " + i);
        }
        System.out.println("После блока трай. i = " + i);
    }

    static class Res implements AutoCloseable {
        private boolean bThrowException = false;

        Res (boolean bThrowException) {
            this.bThrowException = bThrowException;
        }

        @Override
        public void close() throws SQLException {
            if(bThrowException) {
                System.out.println("В блоке close() бросаем SQLException");
                throw new SQLException();
            }
            System.out.println("Закрыли ресурс");
        }
    }
}


