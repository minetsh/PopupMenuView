# PopupMenuView
此库主要实现了一个类似iOS中的`UIMenuController`控件的Popup控件。
主要控件如下：

- `PopLayout`继承自`FrameLayout`，用于实现控件的气泡化。
- `OptionMenuView`继承自`LinearLayout`，用于实现Menu控件。
- `PopupView`继承自`PopupWindow`，用于实现控件的指定方位弹出效果。
- `PopupMenuView`是上述三者的集合，实现了弹出气泡菜单的功能。

![预览图片](/screenshots/preview_image.png)

# Demo
安装 [apk](https://www.pgyer.com/menu) 文件预览效果，或者通过下面二维码去下载安装：
![DEMO下载二维码](https://static.pgyer.com/app/qrcode/menu)

# License
``` license
Copyright 2016 kareluo.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```