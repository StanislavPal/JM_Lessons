package Lesson4.Lesson_4_3_7;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
Класс, в котором скрыта логика настоящей почты
*/
public class RealMailService implements MailService {
    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";
    public static final String STONES = "stones";


    @Override
    public Sendable processMail(Sendable mail) {
        // Здесь описан код настоящей системы отправки почты.
        return mail;
    }

    /*
    Класс, моделирующий ненадежного работника почты, который вместо того,
    чтобы передать почтовый объект непосредственно в сервис почты,
    последовательно передает этот объект набору третьих лиц, а затем, в конце концов,
    передает получившийся объект непосредственно экземпляру RealMailService.
    У UntrustworthyMailWorker должен быть конструктор от массива MailService
    (результат вызова processMail первого элемента массива передается на вход processMail
    второго элемента, и т. д.) и метод getRealMailService, который возвращает ссылку на
    внутренний экземпляр RealMailService, он не приходит масивом в конструкторе
    и не настраивается извне класса.
    */
    public static class UntrustworthyMailWorker implements MailService {
        private final MailService[] mailServices;
        private RealMailService realMailService;

        {
            realMailService = new RealMailService();
        }

        public UntrustworthyMailWorker(MailService[] mailServices) {
            this.mailServices = mailServices;
        }

        public RealMailService getRealMailService() {
            return this.realMailService;
        }

        @Override
        public Sendable processMail(Sendable sendable) {

            for (MailService mailService : mailServices) {
                sendable = mailService.processMail(sendable);
            }
            return getRealMailService().processMail(sendable);
        }

    }

    /*
    Класс – шпион, который логгирует о всей почтовой переписке, которая проходит через его руки.
    Объект конструируется от экземпляра Logger, с помощью которого шпион будет сообщать о всех действиях.
    Он следит только за объектами класса MailMessage и пишет в логгер следующие сообщения
    (в выражениях нужно заменить части в фигурных скобках на значения полей почты):
    1) Если в качестве отправителя или получателя указан "Austin Powers", то нужно написать в лог
    сообщение с уровнем WARN: Detected target mail correspondence: from {from} to {to} "{message}"
    2) Иначе, необходимо написать в лог сообщение с уровнем INFO: Usual correspondence: from {from} to {to}
    */
    public static class Spy implements MailService {
        private final Logger LOGGER;

        public Spy (Logger logger) {
            this.LOGGER = logger;
        }

        @Override
        public Sendable processMail(Sendable sendable) {
            if (sendable instanceof MailMessage) {
                MailMessage mail = (MailMessage) sendable;
                if((mail.from == AUSTIN_POWERS) || (mail.to == AUSTIN_POWERS)) {
                    LOGGER.log(Level.WARNING,
                            "Detected target mail correspondence: from {0} to {1} \"{2}\"",
                            new String[] {mail.from,
                                          mail.to,
                                          mail.getMessage() });
                } else {
                    LOGGER.log(Level.INFO,
                            "Usual correspondence: from {0} to {1}",
                            new String[] {mail.from,
                                          mail.to} );
                }
            }
            return sendable;
        }

    }

    /*
    Класс - вор, который ворует самые ценные посылки и игнорирует все остальное.
    Вор принимает в конструкторе переменную int – минимальную стоимость посылки, которую он будет воровать.
    Также, в данном классе должен присутствовать метод getStolenValue, который возвращает суммарную
    стоимость всех посылок, которые он своровал. Воровство происходит следующим образом: вместо посылки,
    которая пришла вору, он отдает новую, такую же, только с нулевой ценностью и
    содержимым посылки "stones instead of {content}".
    */
    public static class Thief implements MailService {
        private final int minValue;
        private int stolenValue;

        public Thief (int minCost) {
            this.minValue = minCost;
            stolenValue = 0;
        }

        public int getStolenValue() {
            return stolenValue;
        }

        @Override
        public Sendable processMail(Sendable sendable) {
            MailPackage fakeMailPackage = null;
            if(sendable instanceof MailPackage) {
                MailPackage mailPackage = (MailPackage) sendable;
                int price = mailPackage.getContent().getPrice();
                if (price >= minValue) {
                    String content = mailPackage.getContent().getContent();

                    fakeMailPackage = new MailPackage(
                            mailPackage.from,
                            mailPackage.to,
                            new Package(
                                    "stones instead of " + content,
                                    0));

                    stolenValue += price;
                }
            }
            if (fakeMailPackage != null) {
                return fakeMailPackage;
            }
            return sendable;
        }

    }

    /*
    Класс – Инспектор, который следит за запрещенными и украденными посылками и
    бьет тревогу в виде исключения, если была обнаружена подобная посылка.
    Если он заметил запрещенную посылку с одним из запрещенных содержимым
    ("weapons" и "banned substance"), то он бросает IllegalPackageException.
    Если он находит посылку, состоящую из камней (содержит слово "stones"),
    то тревога прозвучит в виде StolenPackageException.
    Оба исключения вы должны объявить самостоятельно в виде непроверяемых исключений.
    */
    public static class Inspector implements MailService {

        @Override
        public Sendable processMail(Sendable sendable) throws RuntimeException {
            if(sendable instanceof MailPackage) {
                MailPackage mailPackage = (MailPackage) sendable;
                String content = mailPackage.getContent().getContent();
                if (( content.toLowerCase().contains(WEAPONS) )
                        || ( content.toLowerCase().contains(BANNED_SUBSTANCE) )){
                    throw new IllegalPackageException();
                }
                if ( content.toLowerCase().contains(STONES) ) {
                    throw new StolenPackageException();
                }

            }
            return sendable;
        }

    }

    public static class IllegalPackageException extends RuntimeException {
    }

    public static class StolenPackageException extends RuntimeException {
    }

}
