import data.NamesHolder;

public class Main {
    public static void main(String[] args) {
        NamesHolder namesHolder = new NamesHolder(3);

        //dane testowe
        String[] names = {"Kamil", "Kamil", "Jan", "Piotr", null, "Maciej"};

        //dorzuć imiona do bazy danych
        for (String name : names) {
            try {
                namesHolder.add(name);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
            }
        }
        //wyswietl stan bazy danych imion
        System.out.println(namesHolder.toString());

        System.out.println("-- Cześć dodatkowa --");
        //Usuń imię z tablicy, spróbuj usunąć nieistniejące imię
        try {
            namesHolder.remove("Kamil");
            namesHolder.remove("Nieznajomy");
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
        //wyswietl stan bazy danych imion
        System.out.println(namesHolder.toString());

        //Usuń kolejne imię, dodaj nowe i sprawdź stan tablicy
        namesHolder.remove("Piotr");
        namesHolder.add("Maciej");
        namesHolder.add("Kamila");
        System.out.println(namesHolder.toString());
    }
}
