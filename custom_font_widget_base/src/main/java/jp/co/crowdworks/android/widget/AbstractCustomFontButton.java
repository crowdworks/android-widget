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
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.Gravity;

abstract class AbstractCustomFontButton extends AppCompatButton {

  public AbstractCustomFontButton(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
    init();
  }

  public AbstractCustomFontButton(Context context, AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public AbstractCustomFontButton(Context context) {
    super(context);
    init();
  }

  protected abstract String getFont();

  private void init() {
    String font = getFont();
    if (font != null) {
      Typeface typeface = TypefaceHelper.getTypeface(getContext(), font);
      if (typeface != null) {
        setTypeface(typeface);
      }
    }
    setMinWidth(0);
    setMinHeight(0);
    setGravity(Gravity.CENTER);
  }
}
