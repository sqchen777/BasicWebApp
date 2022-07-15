package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
            return "MyTeam";
        } else if (query.contains("plus")) { // TODO extend the programm here
            String sub = query.substring(8);
            String[] nums = sub.split(" plus ");
            int a = Integer.parseInt(nums[0]);
            int b = Integer.parseInt(nums[1]);
            return Integer.toString(a + b);
        } else if (query.contains("largest")) {
            String sub = query.substring(query.indexOf(":") + 1);
            String[] nums = sub.split(",");
            int[] n = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                n[i] = Integer.parseInt(nums[i].trim());
            }

            int max = 0;
            for (int i = 0; i < n.length; i++) {
                if (n[i] > max) {
                    max = n[i];
                }
            }
            return Integer.toString(max);
        } else {
            return "";
        }
    }
}
