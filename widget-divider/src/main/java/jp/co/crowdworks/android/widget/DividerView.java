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
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import jp.co.crowdworks.widget_divider.R;

/**
 * divider.
 */
public class DividerView extends FrameLayout {
  public DividerView(Context context) {
    super(context);
    initialize(context, null);
  }

  public DividerView(Context context, AttributeSet attrs) {
    super(context, attrs);
    initialize(context, attrs);
  }

  public DividerView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    initialize(context, attrs);
  }

  private void initialize(Context context, AttributeSet attrs) {
    int thickness =
        context.getResources().getDimensionPixelSize(R.dimen.def_divider_view_thickness);

    if (attrs != null) {
      TypedArray array =
          context.getTheme().obtainStyledAttributes(attrs, R.styleable.DividerView, 0, 0);
      thickness = array.getDimensionPixelSize(R.styleable.DividerView_thickness, thickness);
      array.recycle();
    }

    int color = Color.GRAY;
    TypedArray array2 = context.getTheme().obtainStyledAttributes(new int[] {
        getColorControlNormalRes()
    });
    color = array2.getColor(0, color);
    array2.recycle();

    setBackgroundColor(color);
    setAlpha(0.4f);
    setMinimumWidth(thickness);
    setMinimumHeight(thickness);
  }

  private int getColorControlNormalRes() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      return android.R.attr.colorControlNormal;
    } else {
      return android.R.attr.textColorSecondary;
    }
  }
}
