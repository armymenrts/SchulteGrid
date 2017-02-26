package yuhui.a25.a441.schultegrid;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by Administrator on 2017/2/14.
 */

public class WrongAction extends Animation {
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
       t.getMatrix().setTranslate((float)Math.sin(interpolatedTime*20)*10,0);
    }
}
