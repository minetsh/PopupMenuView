# PopupMenuView
此库主要实现了一个类似iOS中的`UIMenuController`控件的Popup控件。
主要控件如下：

- `PopLayout`继承自`FrameLayout`，用于实现控件的气泡化。
- `OptionMenuView`继承自`LinearLayout`，用于实现Menu控件。
- `PopupView`继承自`PopupWindow`，用于实现控件的指定方位弹出效果。
- `PopupMenuView`是上述三者的集合，实现了弹出气泡菜单的功能。

![预览图片](/screenshot/preview_image.png)

# Demo
安装 [apk](https://www.pgyer.com/menu) 文件预览效果，或者通过下面二维码去下载安装：

![DEMO下载二维码](/screenshot/code.png)

# Usage

Use Gradle:
``` java
compile 'me.kareluo.ui:popmenu:1.1.0'
```

Or Maven:
``` maven
<dependency>
  <groupId>me.kareluo.ui</groupId>
  <artifactId>popmenu</artifactId>
  <version>1.1.0</version>
  <type>pom</type>
</dependency>
```

# Sample

`PopupMenuView`可以通过menu布局文件加载出预先准备的菜单：

``` java
// 根据menu资源文件创建
PopupMenuView menuView = new PopupMenuView(this, R.menu.menu_pop, new MenuBuilder(context));

// 设置点击监听事件
menuView.setOnMenuClickListener(new OptionMenuView.OnOptionMenuClickListener() {
    @Override
    public boolean onOptionMenuClick(int position, OptionMenu menu) {
        Toast.makeText(this, menu.getTitle(), Toast.LENGTH_SHORT).show();
        return true;
    }
});

// 显示在mButtom控件的周围
menuView.show(mButtom);
```

或者通过代码添加:

``` java
menuView.setMenuItems(Arrays.asList(
    new OptionMenu("复制"), new OptionMenu("转发到朋友圈"),
    new OptionMenu("收藏"), new OptionMenu("翻译"),
    new OptionMenu("删除")));
```

默认的显示方位为：上、下、左、右，即按照这种顺序测试界面是否可以显示下菜单，可以如下方式自定义：

``` java
menuView.setSites(PopupView.SITE_BOTTOM, PopupView.SITE_LEFT, PopupView.SITE_TOP, PopupView.SITE_RIGHT);
```

# Update Logs

#### v1.0.0
- 弹出菜单`PopupMenuView`
- 气泡布局
- 菜单控件

#### v1.0.1
- 移除support库引用，加载menu资源文件方法变动

#### v1.0.2
- 增加气泡布局资源属性offsetSize，并修改部分资源属性名称

#### v1.0.3
- 修改了module的名称，之前版本为`library`，后续版本为`popmenu`

#### v1.0.4
- 修复菜单条目变化时无法显示BUG

#### v1.0.5
- 增加自定义样式接口

#### v1.1.0
- 默认样式微调
- 菜单项过多时可滚动视图

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