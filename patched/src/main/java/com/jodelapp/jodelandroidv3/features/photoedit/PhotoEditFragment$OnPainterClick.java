package com.jodelapp.jodelandroidv3.features.photoedit;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.jodelapp.jodelandroidv3.view.drawing.ColorImageButton;
import com.jodelapp.jodelandroidv3.view.drawing.DrawingView;
import com.pes.androidmaterialcolorpickerdialog.ColorPicker;
import com.pes.androidmaterialcolorpickerdialog.ColorPickerCallback;

import java.util.Random;

/**
 * Created by Admin on 12.12.2017.
 */

public class PhotoEditFragment$OnPainterClick implements View.OnClickListener {

    private FragmentActivity mActivity;
    private OnColorChoosenCallback mCallback;
    private static int prevAlpha = 255;
    private static int prevRed;
    private static int prevGreen;
    private static int prevBlue;



    public interface OnColorChoosenCallback{
        void choosen(int color);
    }


    public PhotoEditFragment$OnPainterClick(FragmentActivity mActivity, OnColorChoosenCallback mOnColorChoosenCallback) {
        this.mActivity = mActivity;
        this.mCallback = mOnColorChoosenCallback;

        Random mRandom = new Random();
        prevRed = mRandom.nextInt(255)+1;
        prevBlue = mRandom.nextInt(255)+1;
        prevGreen = mRandom.nextInt(255)+1;
    }

    @Override
    public void onClick(View v) {
        final ColorPicker mColorPicker = new ColorPicker(mActivity, prevAlpha, prevRed, prevGreen, prevBlue);

        mColorPicker.setCallback(new ColorPickerCallback() {
            @Override
            public void onColorChosen(int color) {
                prevAlpha = Color.alpha(color);
                prevRed = Color.red(color);
                prevGreen = Color.green(color);
                prevBlue = Color.blue(color);
                mCallback.choosen(color);
                mColorPicker.dismiss();
            }
        });

        mColorPicker.show();
    }
}