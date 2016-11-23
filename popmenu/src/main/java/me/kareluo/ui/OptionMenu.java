package me.kareluo.ui;

import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckedTextView;

/**
 * Created by felix on 16/11/19.
 */
public class OptionMenu {

    private int id;

    private boolean enable;

    // 暂时不支持
    private boolean visible;

    private boolean checked;

    private boolean checkable;

    private int titleRes;

    private CharSequence title;

    private Drawable drawableLeft;

    private Drawable drawableTop;

    private Drawable drawableRight;

    private Drawable drawableBottom;

    public OptionMenu() {
        this.enable = true;
        this.visible = true;
        this.checked = false;
        this.checkable = true;
    }

    public OptionMenu(int titleRes) {
        this();
        this.titleRes = titleRes;
    }

    public OptionMenu(CharSequence title) {
        this();
        this.title = title;
    }

    public OptionMenu(MenuItem item) {
        this.id = item.getItemId();
        this.title = item.getTitle();
        this.enable = item.isEnabled();
        this.visible = item.isVisible();
        this.checked = item.isChecked();
        this.checkable = item.isCheckable();
        switch (item.getOrder()) {
            case 0:
                this.drawableLeft = item.getIcon();
                break;
            case 1:
                this.drawableTop = item.getIcon();
                break;
            case 2:
                this.drawableRight = item.getIcon();
                break;
            case 3:
                this.drawableBottom = item.getIcon();
                break;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    private boolean isVisible() {
        return visible;
    }

    // 暂时不支持
    private void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        if (checkable) {
            this.checked = checked;
        }
    }

    public void toggle() {
        setChecked(!checked);
    }

    public boolean isCheckable() {
        return checkable;
    }

    public void setCheckable(boolean checkable) {
        this.checkable = checkable;
    }

    public int getTitleRes() {
        return titleRes;
    }

    public void setTitleRes(int titleRes) {
        this.titleRes = titleRes;
    }

    public CharSequence getTitle() {
        return title;
    }

    public void setTitle(CharSequence title) {
        this.title = title;
    }

    public Drawable getDrawableLeft() {
        return drawableLeft;
    }

    public void setDrawableLeft(Drawable drawableLeft) {
        this.drawableLeft = drawableLeft;
    }

    public Drawable getDrawableTop() {
        return drawableTop;
    }

    public void setDrawableTop(Drawable drawableTop) {
        this.drawableTop = drawableTop;
    }

    public Drawable getDrawableRight() {
        return drawableRight;
    }

    public void setDrawableRight(Drawable drawableRight) {
        this.drawableRight = drawableRight;
    }

    public Drawable getDrawableBottom() {
        return drawableBottom;
    }

    public void setDrawableBottom(Drawable drawableBottom) {
        this.drawableBottom = drawableBottom;
    }

    public void validate(CheckedTextView textView) {
        if (titleRes > 0) {
            textView.setText(titleRes);
        } else textView.setText(title);
        textView.setEnabled(enable);
        textView.setChecked(checked);
        // 暂时不支持
        // textView.setVisibility(visible ? View.VISIBLE : View.GONE);
        textView.setCompoundDrawablesWithIntrinsicBounds(
                drawableLeft, drawableTop, drawableRight, drawableBottom);
    }
}
