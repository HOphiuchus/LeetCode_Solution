package main;

public class LC010RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0;
        boolean wildcast=false;
        for (; i < s.length() && j < p.length(); ) {
            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                wildcast=true;
            }
            if(!wildcast) {
                if (s.charAt(i) == p.charAt(j)|| p.charAt(j)=='.') {
                    i++;
                    j++;
                }
                else{
                    return false;
                }
            }else{
                if (s.charAt(i) == p.charAt(j) || p.charAt(j)=='.') {
                    return isMatch(s.substring(i+1),p.substring(j)) || isMatch(s.substring(i),p.substring(j+2));
                }
                else{
                    return isMatch(s.substring(i),p.substring(j+2));
                }
            }

        }


        if (i < s.length()) {
            return false;
        } else {
            for (; j < p.length(); ) {
                if (j + 1 == p.length()) {
                    return false;
                } else {
                    if (p.charAt(j + 1) == '*') {
                        j += 2;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;

    }
}
