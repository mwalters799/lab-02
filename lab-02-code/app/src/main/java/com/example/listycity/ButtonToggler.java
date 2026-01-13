package com.example.listycity;

import android.widget.Button;

public class ButtonToggler {
    private boolean isActivated = false;

    public ButtonToggler(){
    }

    public void switchState(){
        isActivated = !isActivated;
    }

    public boolean isActivated(){
        return isActivated;
    }

}
