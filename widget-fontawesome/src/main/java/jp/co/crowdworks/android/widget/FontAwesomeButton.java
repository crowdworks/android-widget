/*
 * Copyright 2017. CrowdWorks, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.co.crowdworks.android.widget;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Button with font-awesome text.
 */
public class FontAwesomeButton extends AbstractCustomFontButton {
  public FontAwesomeButton(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  public FontAwesomeButton(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public FontAwesomeButton(Context context) {
    super(context);
  }

  @Override protected String getFont() {
    return "fontawesome-webfont.ttf";
  }
}
