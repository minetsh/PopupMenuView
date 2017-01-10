package me.kareluo.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

import me.kareluo.ui.PopLayout.OnBulgeChangeCallback;

/**
 * Created by felix on 17/1/10.
 */
public class PopVerticalScrollView extends ScrollView implements OnBulgeChangeCallback {

    public PopVerticalScrollView(Context context) {
        super(context);
    }

    public PopVerticalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PopVerticalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onBulgeChanged(int site, int size) {
        if (getChildCount() > 0) {
            View view = getChildAt(0);
            if (view instanceof OnBulgeChangeCallback) {
                ((OnBulgeChangeCallback) view).onBulgeChanged(site, size);
            }
        }
    }
}
