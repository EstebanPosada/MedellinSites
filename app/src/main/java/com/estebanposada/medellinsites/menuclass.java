package com.estebanposada.medellinsites;

/**
 * Created by usuario on 06/11/2015.
 */
public class menuclass {
    private int imagevec;
    private String menu;
    private String subm;

    public menuclass (int idimage, String menu, String subm){
        imagevec = idimage;
        this.menu = menu;
        this.subm = subm;
    }

    public int getImagevec() {
        return imagevec;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getSubm() {
        return subm;
    }

    public void setSubm(String subm) {
        this.subm = subm;
    }
}
