import list.LinkedList;
import list.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = new LinkedList<>();
        names.add("Gabriel");
        names.add("Caroline");
        names.add("Pablo");

        names.forEach(System.out::println);

    }
}