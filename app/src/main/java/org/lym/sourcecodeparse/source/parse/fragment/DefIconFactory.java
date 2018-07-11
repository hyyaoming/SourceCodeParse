package org.lym.sourcecodeparse.source.parse.fragment;

import org.lym.sourcecodeparse.R;

import java.util.Random;

/**
 * doc
 *
 * @author yaoming.li
 * @since 2018/6/3
 */
public class DefIconFactory {
    private static int[] defaultImage = new int[]{
            R.drawable.ic_default_1, R.drawable.ic_default_2, R.drawable.ic_default_3, R.drawable.ic_default_4, R.drawable.ic_default_5};

    private static Random sRandom = new Random();

    private DefIconFactory() {
        throw new RuntimeException("cannot be instantiated");
    }

    public static int iconDefault() {
        int x = sRandom.nextInt(defaultImage.length);
        return defaultImage[x];
    }
}
