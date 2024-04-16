package timrekelj.fri;

import java.util.HashMap;
import java.util.Scanner;

public class SeznamiUV {
    HashMap<String, Seznam<String>> seznami = new HashMap<>();
    Seznam<String> seznam;

    public SeznamiUV() {
        seznami.put("sk", new Sklad<>());
        seznami.put("pv", new PrioritetnaVrsta<>());
        seznami.put("bst", new BST<>());
        seznam = seznami.get("sk");
    }

    public String processInput(String input) {
        Scanner sc = new Scanner(input);
        String token = sc.next();
        String value = "";
        String result = "OK";
        switch (token) {
            case "use":
                if (sc.hasNext()) {
                    seznam = seznami.get(sc.next());
                    if (null == seznam)
                        result = "Error: please specify a correct data structure type (sk, pv, bst)";
                }
                else result = "Error: please specify a data structure type (sk, pv, bst)";
                break;
            case "add":
                if (!sc.hasNext()) {
                    result = "Error: please specify a string";
                    break;
                }
                value = sc.next();
                if (value.charAt(0) == '\"') {
                    while (sc.hasNext()) {
                        value += " " + sc.next();
                        if (value.charAt(value.length()-1) == '\"')
                            seznam.add(value.substring(1, value.length()-1));
                    }
                    if (value.charAt(value.length()-1) == '\"')
                        result = "OK";
                    else
                        result = "Error: invalid string";
                    break;
                }
                seznam.add(value);
                break;
            case "remove_first":
                result = !seznam.isEmpty() ? seznam.removeFirst() : "Error: data structure is empty";
                break;
            case "get_first":
                if (!seznam.isEmpty())
                    result = seznam.getFirst();
                else
                    result = "Error: data structure is empty";
                break;
            case "size":
                result = String.valueOf(seznam.size());
                break;
            case "depth":
                if (seznam instanceof BST || seznam instanceof PrioritetnaVrsta)
                    result = String.valueOf(seznam.depth());
                else
                    result = "Error: invalid data structure type";
                break;
            case "is_empty":
                result = seznam.isEmpty() ? "Data structure is empty" : "Data structure is not empty";
                break;
            case "remove":
                if (!sc.hasNext()) {
                    result = "Error: please specify a string";
                    break;
                }
                value = sc.next();
                if (value.charAt(0) == '\"') {
                    while (sc.hasNext()) {
                        value += " " + sc.next();
                        if (value.charAt(value.length()-1) != '\"')
                            continue;
                        try {
                            result = seznam.remove(value.substring(1, value.length() - 1));
                        } catch (Exception e) {
                            if (e instanceof java.util.NoSuchElementException)
                                result = "Error: element not found";
                            else
                                result = "Error: data structure is empty";
                        }
                    }
                    if (value.charAt(value.length()-1) != '\"')
                        result = "Error: invalid string";
                    break;
                }
                try {
                    result = seznam.remove(value);
                } catch (Exception e) {
                    if (e instanceof java.util.NoSuchElementException)
                        result = "Error: element not found";
                    else
                        result = "Error: data structure is empty";
                }
                break;
            case "exists":
                if (!sc.hasNext()) {
                    result = "Error: please specify a string";
                    break;
                }
                result = seznam.exists(sc.next()) ? "Element exists" : "Element does not exist";
                break;
            case "search":
                if (!sc.hasNext()) {
                    result = "Error: please specify a string";
                    break;
                }
                value = sc.next();
                if (seznam instanceof Sklad)
                    result = String.valueOf(((Sklad<String>) seznam).search(value));
                else
                    result = "Error: invalid data structure type";
                break;
            case "reset":
                while (!seznam.isEmpty())
                    seznam.removeFirst();
                break;
            default:
                result = "Error: Invalid command";
        }
        return result;
    }
}
