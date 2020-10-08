package com.mmu.fracgoal;

import android.widget.VideoView;

public class MaterialMember {

    private String MaterialName;
    private String MaterialUri;

    private MaterialMember(){}

    public MaterialMember(String name, String materialUri){
        if (name.trim().equals("")){
            name = " not available";
        }
        MaterialName = name;
        MaterialUri = materialUri;
    }

    public String getMaterialName() {
        return MaterialName;
    }

    public void setMaterialName(String materialName) {
        MaterialName = materialName;
    }

    public String getMaterialUri() {
        return MaterialUri;
    }

    public void setMaterialUri(String materialUri) {
        MaterialUri = materialUri;
    }


}
