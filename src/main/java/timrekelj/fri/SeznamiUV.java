package timrekelj.fri;

import java.util.Scanner;

public class SeznamiUV {
    private Sklad<String> sklad;
    private PrioritetnaVrsta<String> vrsta;

    public SeznamiUV() {
        sklad = new Sklad<String>();
        vrsta = new PrioritetnaVrsta<String>();
    }

    public String processInput(String input) {
        Scanner sc = new Scanner(input);
        String token = sc.next();
        String value = "";
        String result = "OK";
        switch (token) {
            /////////////////////////////////// SKLAD ///////////////////////////////////
            case "s_add":
                if (!sc.hasNext()) {
                    result = "Error: please specify a string";
                    break;
                }
                value = sc.next();
                if (value.charAt(0) == '\"') {
                    while (sc.hasNext()) {
                        value += " " + sc.next();
                        if (value.charAt(value.length()-1) == '\"')
                            sklad.add(value.substring(1, value.length()-1));
                    }
                    if (value.charAt(value.length()-1) == '\"')
                        result = "OK";
                    else
                        result = "Error: invalid string";
                    break;
                }
                sklad.add(value);
                break;
            case "s_remove_first":
                result = !sklad.isEmpty() ? sklad.removeFirst() : "Error: stack is empty";
                break;
            case "s_reset":
                while (!sklad.isEmpty())
                    sklad.removeFirst();
                break;
            case "s_size":
                result = Integer.toString(sklad.size());
                break;
            case "s_is_first":
                if (!sc.hasNext()) {
                    result = "Error: please specify a string";
                    break;
                }
                if (sklad.isEmpty()) {
                    result = "Error: stack is empty";
                    break;
                }
                if (sc.next().equals(sklad.getFirst()))
                    result = "OK";
                else
                    result = "Error: wrong element";
                break;
            case "s_search":
                if (!sc.hasNext()) {
                    result = "Error: please specify a string";
                    break;
                }
                value = sc.next();
                if (value.charAt(0) == '\"') {
                    while (sc.hasNext()) {
                        value += " " + sc.next();
                        if (value.charAt(value.length() - 1) == '\"')
                            result = Integer.toString(sklad.search(value.substring(1, value.length() - 1)));
                    }
                    if (value.charAt(value.length() - 1) != '\"')
                        result = "Error: invalid string";
                    break;
                }
                result = Integer.toString(sklad.search(value));
                break;

            /////////////////////////////////// PRIORITETNA VRSTA ///////////////////////////////////
            case "pq_add": // brez elementov z več nizi “"
                if (sc.hasNext()) {
                    String val = sc.next();
                    vrsta.add(val);
                }
                else
                    result = "Error: please specify a string";
                break;
            case "pq_remove_first":
                if (!vrsta.isEmpty())
                    result = vrsta.removeFirst();
                else
                    result = "Error: priority queue is empty";
                break;
            case "pq_get_first":
                if (!vrsta.isEmpty())
                    result = vrsta.getFirst();
                else
                    result = "Error: priority queue is empty";
                break;
            case "pq_size":
                result = String.valueOf(vrsta.size());
                break;
            case "pq_depth":
                result = String.valueOf(vrsta.depth());
                break;
            case "pq_isEmpty":
                result = vrsta.isEmpty() ? "Priority queue is empty" : "Priority queue is not empty";
                break;

            default:
                result = "Error: Invalid command";
        }
        return result;
    }
}
