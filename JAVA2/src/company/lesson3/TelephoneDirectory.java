package company.lesson3;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class TelephoneDirectory {
    private Map<String, LinkedList<String>> mapTD = new HashMap<>();


    public void add(String surname, String phoneNumber){
        try {
            mapTD.get(surname).add(phoneNumber);
        } catch (Exception e) {
            mapTD.put(surname, new LinkedList<>(Collections.singleton(phoneNumber)));
        }
    }

    public void get (String surname) {
        System.out.print(surname + " : ");
        try{
            for (int i = 0; i < mapTD.get(surname).size(); i++) {
                System.out.print(mapTD.get(surname).get(i) + "; ");
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println("Not found;");
        }
    }

    public void printDirectory(){
        System.out.println(mapTD);
    }
}

