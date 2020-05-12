package data;

import logic.DuplicateException;
import logic.NoValueException;

import java.util.Arrays;

public class NamesHolder {
    private String[] strings;
    private int counter;

    public NamesHolder(int containerSize) {
        this.strings = new String[containerSize];
        this.counter = 0;
    }

    public void add(String name) {
        if (name == null) throw new NullPointerException("Nie podałeś imienia");
        if (contains(name)) throw new DuplicateException("Podane imie istnieje w tablicy: " + name);
        if (counter == strings.length) throw new ArrayIndexOutOfBoundsException("Brak miejsca na nowe imiona");
        strings[counter] = name;
        counter++;
    }

    public void remove(String name) {
        if (name == null) throw new NullPointerException("Nie podałeś imienia");
        if (!contains(name)) throw new NoValueException("Podane imie nie istnieje w tablicy: " + name);
        boolean modifyNextValues = false;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i] == null) return; //wyjdz z petli jesli element wskazuje na null
            if (strings[i].equals(name)) {
                modifyNextValues = true; //ustaw flagę do nadpisywania obiektów wartością z prawej
                counter--; //zmniejsz licznik obiektów w tablicy - co pozwoli dodać nową wartość
            }
            if (modifyNextValues) {
                if (i == (strings.length - 1))
                    strings[i] = null; // ustaw ostatni element jako null (w zamian usuniętego)
                else strings[i] = strings[i + 1]; //dla każdego innego przepisz wartość kolejnego obiektu do obecnego
            }
        }
    }

    private boolean contains(String name) {
        if (name == null) throw new IllegalArgumentException("Nie podałeś imienia");
        for (String s : strings) {
            if (s == null) return false; //pusta tablica lub koniec obiektów.
            if (s.equals(name)) return true;
        }
        return false;
    }

    private int size() {
        return counter;
    }

    @Override
    public String toString() {
        return "NamesHolder{" +
                "strings=" + Arrays.toString(strings) +
                ", counter=" + counter +
                '}';
    }
}
