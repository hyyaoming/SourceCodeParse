package org.lym.sourcecodeparse.source.parse.anim;


import android.animation.TypeEvaluator;

/**
 * doc
 *
 * @author yaoming.li
 * @since 2018/5/8
 */
public class PointEvaluation implements TypeEvaluator {
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        Point startPoint = (Point) startValue;
        Point endPoint = (Point) endValue;
        float x = startPoint.getX() + fraction * (endPoint.getX() - startPoint.getX());
        float y = startPoint.getY() + fraction * (endPoint.getY() - startPoint.getY());
        Point point = new Point(x, y);
        return point;
    }
}
