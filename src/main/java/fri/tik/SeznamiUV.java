package fri.tik;

import java.util.Scanner;
public class SeznamiUV {
    Sklad<String> sklad = new Sklad<>();
    PrioritetnaVrsta<String> vrsta = new PrioritetnaVrsta<>();

    public String processInput(String input) {
        Scanner sc = new Scanner(input);
        String token = sc.next();
        String result = "OK";

        switch (token) {
            case "push":
                if (sc.hasNext()) {
                    sklad.push(sc.nextLine().trim());
                    result = "OK";
                } else
                    result = "Error: please specify a string";
                break;
            case "s_add":
                if (sc.hasNext()) {
                    sklad.add(sc.nextLine().trim());
                    result = "OK";
                } else
                    result = "Error: please specify a string";
                break;
            case "istop":
                if (sc.hasNext()) {
                    if (!sklad.isEmpty()){
                        var next = sc.nextLine().trim();
                        if (sklad.isTop(next))
                            result = "OK";
                        else
                            result = "Error: Wrong element";
                    } else
                        result = "Error: stack is empty";
                } else
                    result = "Error: please specify a string";
                break;
            case "search":
                if (sc.hasNext())
                    result = String.valueOf(sklad.search(sc.next()));
                else
                    result = "Error: please specify a string";
                break;
            case "top":
                if (!sklad.isEmpty())
                    result = sklad.top();
                else
                    result = "Error: stack is empty";
                break;
            case "s_get_first":
                if (!sklad.isEmpty())
                    result = sklad.getFirst();
                else
                    result = "Error: stack is empty";
                break;
            case "pop":
                if (!sklad.isEmpty())
                    result = sklad.pop();
                else
                    result = "Error: stack is empty";
                break;
            case "s_remove_first":
                if (!sklad.isEmpty())
                    result = sklad.removeFirst();
                else
                    result = "Error: stack is empty";
                break;
            case "reset":
                while (!sklad.isEmpty())
                    sklad.pop();
                break;
            case "count":
                result = String.format("%d", sklad.size());
                break;
            case "s_depth":
                result = String.format("%d", sklad.depth());
                break;

            case "pq_add":
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
                result = "Priority queue is " + (vrsta.isEmpty() ? "" : "not ") + "empty";
                break;
        }
        return result;
    }
}
