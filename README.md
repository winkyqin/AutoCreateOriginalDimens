# How to use
### AutoCreateDimonsXML
AutoCreateDimonsXML bases on JAVA that is used to create dimens.xml for multiple screens.

### AutoCreateOriginalDimens
AutoCreateOriginalDimens bases on JAVA that is used to create a dimens.xml definding every dip.

LEARN MORE ABOUT AutoCreateDimonsXML:
  - Supporting Multiple Screens.
  - You just spend a few minutes creating a bunch of dimension files.
  - This tool supports densities from ldip to xxxhdpi, or you can defind what size you need easliy. 

# STEPS:
* In AutoCreateOriginalDimens [Main][AutoCreateOriginalDimens_main], add the max dip you need in your view, and set DIMENS_HOME and ORI_DIMENS.
  - *DIMENS_HOME* is where your new dimens files are
  - *ORI_DIMENS* is where your original dimens file is.
```Java
	public static int sizeX = 500;
	public static int sizeY = 500;

	public static String DIMENS_HOME = "/Users/Nexton/Documents/dev/DimensHome/";
	public static String ORI_DIMENS = "/Users/Nexton/Documents/dev/DimensHome/dimens.xml";
```
* Run [AutoCreateOriginalDimens][AutoCreateOriginalDimens] to create an original dimens.xml
* Now you've got a dimens.xml in ORI_DIMENS, it looks like
 ```Xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
  <dimen name="x1">1dp</dimen>
  <dimen name="y1">1dp</dimen>
  <dimen name="x2">2dp</dimen>
  <dimen name="y2">2dp</dimen>
  <dimen name="x3">3dp</dimen>
  <dimen name="y3">3dp</dimen>
  <dimen name="x4">4dp</dimen>
  <dimen name="y4">4dp</dimen>
  ...
  <dimen name="x500">500dp</dimen>
  <dimen name="y500">500dp</dimen>
```
* You've got a original dimens.xml, and you need to create more dimens files. We use  [AutoCreateDimonsXML][AutoCreateDimonsXML].
  - *ORI_DPI* is your device screen density.
  - *ORI_HEIGHT* and *ORI_WIDTH* are your device screen sizes (If you are not sure, please run [Display] the app that shows what your screen size is).
  - If you would like to create a 1920x1080 dimens.xml, you add 1920 in *height[]* and add 1080 to *width[]*, 1920 and 1080 should be in same position of the arrays. I got all information from UMeng(https://www.umeng.com/), providing mobile app analytics solutions.
  - **I suggest you could set ORI_DPI, ORI_HEIGHT and ORI_WIDTH as the device that is used to test your application, cause I set the original dimen name 'x1' as 1dp, and it would not be 1dp on other screen sizes, it might confuse you.**
```Java
	public static String DIMENS_HOME = "/Users/Nexton/Documents/dev/DimensHome/";

	public static String ORI_DIMENS = "/Users/Nexton/Documents/dev/DimensHome/dimens.xml";
	// 原始dimen.xml分辨率 xxhdpi-1803x1080
	public static int ORI_HEIGHT = 1803;
	public static int ORI_WIDTH = 1080;
	public static int ORI_DPI = 480;

	// 其他分辨率 e.g. 1280x720, 1920x1080
	public static int height[] = new int[] { 2560, 2400, 1280, 1280, 1920, 854, 800, 960, 1184, 1803, 1776, 1280, 1800,
			1794, 1920, 1812, 1368, 1280, 1232, 1216, 1280, 1208, 1200, 1196, 1280, 1136, 960, 1024, 976, 776, 1024,
			888, 854, 782, 752, 592, 630, 480, 320 };
	public static int width[] = new int[] { 1440, 1440, 720, 768, 1080, 480, 480, 540, 720, 1080, 1080, 800, 1080, 1080,
			1152, 1080, 900, 800, 800, 800, 752, 720, 720, 720, 672, 640, 640, 600, 600, 600, 552, 540, 480, 480, 480,
			480, 420, 320, 240 };
```
* Run [AutoCreateDimonsXML_main][AutoCreateDimonsXML_main] to create the other dimens.xml files.

# How to ues
* Copy all value files to your res folder.
* E.g. If you want to set layout_width to 50dp, and layout_height to 50dp, your codes should be:
 ```Xml
android:layout_width="@dimen/x50"
android:layout_height="@dimen/y50"
```
* '@dimen/x_' is used to horizontal or width, and '@dimen/y_' is used to vertical or height.
### Version
1.0.0

License
--------
    Copyright 2015 Catherine

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)


   [Apache-2.0]: <https://opensource.org/licenses/Apache-2.0>
   [AutoCreateOriginalDimens]: <https://github.com/JetAircraft/AutoCreateOriginalDimens>
   [AutoCreateOriginalDimens_main]: <https://github.com/JetAircraft/AutoCreateOriginalDimens/blob/master/src/createOriginalDimens/Main.java>
   [AutoCreateDimonsXML]: <https://github.com/JetAircraft/AutoCreateDimonsXML>
   [AutoCreateDimonsXML_main]: <https://github.com/JetAircraft/AutoCreateDimonsXML/blob/master/src/Main.java>
   [Display]: <https://github.com/JetAircraft/Display>
