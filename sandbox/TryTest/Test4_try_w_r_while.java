package sandbox.TryTest;

import java.io.IOException;
import java.sql.SQLException;

public class Test4_try_w_r_while {
    public static void main(String[] args) {
        boolean bExit = false;
        int i = 0;

        System.out.println("До входа в блок try");
        while(!bExit) {
            try( Res res = new Res(true) ) {
                System.out.println("В блоке трай");
                i=2;
            } catch (SQLException e) {
                System.out.println("В блоке кетч");
                i++;
            }
            if(i == 3) bExit = true;
        }
        System.out.println("После блока трай");
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


