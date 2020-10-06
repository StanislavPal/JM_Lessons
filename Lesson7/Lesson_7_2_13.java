package Lesson7;

import java.security.PublicKey;
import java.util.*;
import java.util.function.Consumer;

public class Lesson_7_2_13 {
    public static void main(String[] args) {
        // Random variables
        String randomFrom = "sldkfjFrom"; // Некоторая случайная строка. Можете выбрать ее самостоятельно.
        String randomTo = "fjksnadTo";  // Некоторая случайная строка. Можете выбрать ее самостоятельно.
        int randomSalary = 100;  // Некоторое случайное целое положительное число. Можете выбрать его самостоятельно.

// Создание списка из трех почтовых сообщений.
        MailMessage firstMessage = new MailMessage(
                "Robert Howard",
                "H.P. Lovecraft",
                "This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!"
        );

        assert firstMessage.getFrom().equals("Robert Howard") : "Wrong firstMessage from address";
        assert firstMessage.getTo().equals("H.P. Lovecraft") : "Wrong firstMessage to address";
        assert firstMessage.getContent().endsWith("Howard!") : "Wrong firstMessage content ending";

        MailMessage secondMessage = new MailMessage(
                "Jonathan Nolan",
                "Christopher Nolan",
                "Брат, почему все так хвалят только тебя, когда практически все сценарии написал я. Так не честно!"
        );

        MailMessage thirdMessage = new MailMessage(
                "Stephen Hawking",
                "Christopher Nolan",
                "Я так и не понял Интерстеллар."
        );

        List<MailMessage> messages = Arrays.asList(
                firstMessage, secondMessage, thirdMessage
        );

// Создание почтового сервиса.
        MailService<String> mailService = new MailService<>();

// Обработка списка писем почтовым сервисом
        messages.stream().forEachOrdered(mailService);

// Получение и проверка словаря "почтового ящика",
//   где по получателю можно получить список сообщений, которые были ему отправлены
        Map<String, List<String>> mailBox = mailService.getMailBox();

        assert mailBox.get("H.P. Lovecraft").equals(
                Arrays.asList(
                        "This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!"
                )
        ) : "wrong mailService mailbox content (1)";

        assert mailBox.get("Christopher Nolan").equals(
                Arrays.asList(
                        "Брат, почему все так хвалят только тебя, когда практически все сценарии написал я. Так не честно!",
                        "Я так и не понял Интерстеллар."
                )
        ) : "wrong mailService mailbox content (2)";

        assert mailBox.get(randomTo).equals(Collections.<String>emptyList()) : "wrong mailService mailbox content (3)";


// Создание списка из трех зарплат.
        Salary salary1 = new Salary("Facebook", "Mark Zuckerberg", 1);
        Salary salary2 = new Salary("FC Barcelona", "Lionel Messi", Integer.MAX_VALUE);
        Salary salary3 = new Salary(randomFrom, randomTo, randomSalary);

// Создание почтового сервиса, обрабатывающего зарплаты.
        MailService<Integer> salaryService = new MailService<>();

// Обработка списка зарплат почтовым сервисом
        Arrays.asList(salary1, salary2, salary3).forEach(salaryService);

// Получение и проверка словаря "почтового ящика",
//   где по получателю можно получить список зарплат, которые были ему отправлены.
        Map<String, List<Integer>> salaries = salaryService.getMailBox();
        assert salaries.get(salary1.getTo()).equals(Arrays.asList(1)) : "wrong salaries mailbox content (1)";
        assert salaries.get(salary2.getTo()).equals(Arrays.asList(Integer.MAX_VALUE)) : "wrong salaries mailbox content (2)";
        assert salaries.get(randomTo).equals(Arrays.asList(randomSalary)) : "wrong salaries mailbox content (3)";

    }

    public static class Dispatch<T> {
        private String from;
        private String to;
        private T t;

        public Dispatch(String from, String to, T t) {
            this.from = from;
            this.to = to;
            this.t = t;
        }

        public String getFrom() {
            return from;
        }

        public String getTo() {
            return to;
        }

        public T getT() {
            return t;
        }

        @Override
        public String toString() {
            return "Dispatch{" +
                    "from='" + from + '\'' +
                    ", to='" + to + '\'' +
                    ", t=" + t +
                    '}';
        }
    }
    public static class MailMessage extends Dispatch<String>{

        public MailMessage(String from, String to, String content) {
            super(from, to, content);
        }

        public String getContent() {
            return super.getT();
        }
    }

    public static class Salary extends Dispatch<Integer>{

        public Salary(String from, String to, Integer salary) {
            super(from, to, salary);
        }

        public Integer getSalary() {
            return super.getT();
        }
    }

    public static class MailService<T> implements Consumer<Dispatch<T>> {
        private Map<String, List<T>> mailBox;

        public static <E> List<E> addToList(List<E> list, E e){
            list.add(e);
            return list;
        }

        @Override
        public void accept(Dispatch<T> dispatch) {
            if (mailBox == null) {
                System.out.println("new Hashmap");
                mailBox = new MailBox<>();
            }

            List<T> list;
            if (mailBox.containsKey(dispatch.to)) {
                list = mailBox.get(dispatch.to);
            } else {
                list = new ArrayList<>();
            }
            list.add(dispatch.t);
            mailBox.put(dispatch.to, list);
//            mailBox.merge(dispatch.to, new ArrayList<T>().add(dispatch.t), (oldList, newValue) -> MailService<T>.addToList(oldList, newValue) );
            System.out.println("accept: " + mailBox);
        }

        public Map<String, List<T>> getMailBox() {
            return mailBox;
        }
    }

    public static class MailBox<K, V> extends HashMap<K, V> {
        @Override
        public V get(Object key) {
            if(super.containsKey(key)) {
                return super.get(key);
            } else {
                return (V) Collections.<String>emptyList();
            }
        }
    }
}


