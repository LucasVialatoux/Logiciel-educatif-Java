/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiciel_edu;

import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class PageAide extends Fenetre {
    public PageAide(String bgd){
        super(bgd);
        text();
    }
    public void text(){
        Font police = Font.loadFont(PageAide.class.getResourceAsStream("/GOTHICB0.TTF"), 20);
        Text aide=new Text();
        aide.setText("  Logiciel de covoiturage\n\n            crée par     \n\n    Antoine DULHOSTE\n\n      Lucas VIALATOUX\n\n");
        aide.setFont(police);
        this.root.setCenter(aide);
    }
}
