# PopupMenuView
此库主要实现了一个类似iOS中的`UIMenuController`控件的Popup控件。
主要控件如下：

- `PopLayout`继承自`FrameLayout`，用于实现控件的气泡化。
- `OptionMenuView`继承自`LinearLayout`，用于实现Menu控件。
- `PopupView`继承自`PopupWindow`，用于实现控件的指定方位弹出效果。
- `PopupMenuView`是上述三者的集合，实现了弹出气泡菜单的功能。

![预览图片](/screenshots/preview_image.png)
