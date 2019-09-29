package com.sergo.stringmetric;

public class StringMetricAlgorithm {

    /**
     * @param source
     * @param target
     * @param caseSensitive
     * @return
     */
    public static int damerauLevensteinDistance(CharSequence source, CharSequence target, boolean caseSensitive) {
        if (source == null || target == null) {
            throw new NullPointerException("Null parameter in method call");
        }
        if (!caseSensitive) {
            return damerauLevensteinDistance(source.toString().toLowerCase(), target.toString().toLowerCase());
        } else {
            return damerauLevensteinDistance(source, target);
        }
    }

    public static int damerauLevensteinDistance(CharSequence source, CharSequence target) {
        if (source == null || target == null) {
            throw new NullPointerException("Null parameter in method call");
        }
        int sourceLength = source.length();
        int targetLength = target.length();

        return -1; //TODO
    }


    /**
     * @param source
     * @param target
     * @param caseSensitive
     * @return
     */
    public static int levensteinDistance(CharSequence source, CharSequence target, boolean caseSensitive) {
        if (source == null || target == null) {
            throw new NullPointerException("Null parameter in method call");
        }
        if (!caseSensitive) {
            return levensteinDistance(source.toString().toLowerCase(), target.toString().toLowerCase());
        } else {
            return levensteinDistance(source, target);
        }
    }

    public static int levensteinDistance(CharSequence source, CharSequence target) {
        if (source == null || target == null) {
            throw new NullPointerException("Null parameter in method call");
        }

        int sourceLength = source.length();
        int targetLength = target.length();

        int[][] distMatrix = new int[sourceLength + 1][targetLength + 1];

        for (int i = 0; i <= sourceLength; i++) {
            distMatrix[i][0] = i;
        }
        for (int i = 0; i <= targetLength; i++) {
            distMatrix[0][i] = i;
        }

        int cost;
        for (int i = 1; i <= sourceLength; i++) {
            for (int j = 1; j <= targetLength; j++) {
                if (source.charAt(i-1)== target.charAt(j-1)){
                    cost = 0;
                }
                else{
                    cost = 1;
                }
                distMatrix[i][j] = Math.min(Math.min(distMatrix[i-1][j]+1, //deletion
                                                     distMatrix[i][j-1]+1),//insertion
                                                     distMatrix[i-1][j-1]+cost);//substitution
            }
        }
        return distMatrix[sourceLength][targetLength];
    }
}
