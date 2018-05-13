package org.lym.sourcecodeparse.source.parse.recyclerview.data;

/**
 * doc
 *
 * @author yaoming.li
 * @since 2018/5/12
 */
public class GuessModel implements MultipleItemEntity {
    private String mGuess;

    public GuessModel(String guess) {
        this.mGuess = guess;
    }

    public String getGuess() {
        return mGuess;
    }

    @Override
    public int getSpanCount() {
        return 4;
    }

    @Override
    public int getItemType() {
        return GUESS_YOU_LIKE;
    }
}
