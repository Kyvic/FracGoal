package com.mmu.fracgoal;

public class Materials {

    public String materialName, materialUri;

    public Materials(){

    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getMaterialUri() {
        return materialUri;
    }

    public void setMaterialUri(String uri) {
        this.materialUri = materialUri;
    }

    public Materials(String materialName, String materialUri) {
        this.materialName = materialName;
        this.materialUri = materialUri;
    }
}

