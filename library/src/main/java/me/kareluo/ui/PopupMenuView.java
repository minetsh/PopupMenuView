package me.kareluo.ui;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;

import java.util.List;

/**
 * Created by felix on 16/11/18.
 */
public class PopupMenuView extends PopupView implements OptionMenuView.OnOptionMenuClickListener {

    private PopLayout mPopLayout;

    private OptionMenuView mOptionMenuView;

    private OptionMenuView.OnOptionMenuClickListener mOnOptionMenuClickListener;

    public PopupMenuView(Context context) {
        super(context);
        mOptionMenuView = new OptionMenuView(context);
        mOptionMenuView.setOnOptionMenuClickListener(this);
        mPopLayout = new PopLayout(context);
        mPopLayout.addView(mOptionMenuView);
        setContentView(mPopLayout);
    }

    public PopupMenuView(Context context, int menuRes) {
        this(context);
        inflate(menuRes);
    }

    public void inflate(int meenuRes) {
        mOptionMenuView.inflate(meenuRes);
        measureContentView();
    }

    public void setMenuItems(List<OptionMenu> optionMenus) {
        mOptionMenuView.setOptionMenus(optionMenus);
        measureContentView();
    }

    public void setOrientation(int orientation) {
        mOptionMenuView.setOrientation(orientation);
        measureContentView();
    }

    // 暂时暴露出
    @Deprecated
    public PopLayout getPopLayout() {
        return mPopLayout;
    }

    // 暂时暴露出
    @Deprecated
    public OptionMenuView getMenuView() {
        return mOptionMenuView;
    }

    public void setOnMenuClickListener(OptionMenuView.OnOptionMenuClickListener listener) {
        mOnOptionMenuClickListener = listener;
    }

    @Override
    public void show(View anchor, Rect frame, Point origin) {
        mOptionMenuView.notifyMenusChange();
        super.show(anchor, frame, origin);
    }

    @Override
    public void showAtTop(View anchor, Point origin, int xOff, int yOff) {
        mPopLayout.setSiteMode(PopLayout.SITE_BOTTOM);
        mPopLayout.setOffset(origin.x - xOff);
        super.showAtTop(anchor, origin, xOff, yOff);
    }

    @Override
    public void showAtLeft(View anchor, Point origin, int xOff, int yOff) {
        mPopLayout.setSiteMode(PopLayout.SITE_RIGHT);
        mPopLayout.setOffset(-origin.y - yOff);
        super.showAtLeft(anchor, origin, xOff, yOff);
    }

    @Override
    public void showAtRight(View anchor, Point origin, int xOff, int yOff) {
        mPopLayout.setSiteMode(PopLayout.SITE_LEFT);
        mPopLayout.setOffset(-origin.y - yOff);
        super.showAtRight(anchor, origin, xOff, yOff);
    }

    @Override
    public void showAtBottom(View anchor, Point origin, int xOff, int yOff) {
        mPopLayout.setSiteMode(PopLayout.SITE_TOP);
        mPopLayout.setOffset(origin.x - xOff);
        super.showAtBottom(anchor, origin, xOff, yOff);
    }

    @Override
    public boolean onOptionMenuClick(int position, OptionMenu menu) {
        if (mOnOptionMenuClickListener != null) {
            if (mOnOptionMenuClickListener.onOptionMenuClick(position, menu)) {
                dismiss();
                return true;
            }
        }
        return false;
    }
}
