package com.example.greenarrow.res_mvc;

import android.graphics.drawable.GradientDrawable;

public final class Gradients {
    public static final GradientDrawable GRADIENT_MAIN = new GradientDrawable(
            GradientDrawable.Orientation.TOP_BOTTOM,
            new int[] {0xFF32CD32, 0xFF77CD77});
    public static final GradientDrawable GRADIENT_ORANGE = new GradientDrawable(
            GradientDrawable.Orientation.TOP_BOTTOM,
            new int[] {0xFFFFA500, 0xFFFFBF00});
    public static final GradientDrawable GRADIENT_TRANSPARENT = new GradientDrawable(
            GradientDrawable.Orientation.TOP_BOTTOM,
            new int[] {0xFFFFFFFF, 0xFFEEEEEE});
}
