package timrekelj.fri;

import java.util.Scanner;

public class SeznamiUV {
    private Sklad<String> sklad;

    public SeznamiUV() {
        sklad = new Sklad<String>();
    }

    public String processInput(String input) {
        Scanner sc = new Scanner(input);
        String token = sc.next();
        String value = "";
        String result = "OK";
        switch (token) {
            case "push":
                if (!sc.hasNext()) {
                    result = "Error: please specify a string";
                    break;
                }
                value = sc.next();
                if (value.charAt(0) == '\"') {
                    while (sc.hasNext()) {
                        value += " " + sc.next();
                        if (value.charAt(value.length()-1) == '\"')
                            sklad.push(value.substring(1, value.length()-1));
                    }
                    if (value.charAt(value.length()-1) == '\"')
                        result = "OK";
                    else
                        result = "Error: invalid string";
                    break;
                }
                sklad.push(value);
                break;
            case "pop":
                result = !sklad.isEmpty() ? sklad.pop() : "Error: stack is empty";
                break;
            case "reset":
                while (!sklad.isEmpty())
                    sklad.pop();
                break;
            case "count":
                result = Integer.toString(sklad.size());
                break;
            case "isTop":
                if (!sc.hasNext()) {
                    result = "Error: please specify a string";
                    break;
                }
                if (sklad.isEmpty()) {
                    result = "Error: stack is empty";
                    break;
                }
                if (sc.next().equals(sklad.top()))
                    result = "OK";
                else
                    result = "Error: wrong element";
                break;
            case "search":
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
        }
        return result;
    }
}
