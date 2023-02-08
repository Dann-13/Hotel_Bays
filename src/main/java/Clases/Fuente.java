/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * En esta clase se cargara la fuente para que sea utilizada en cualquier parte
 * del proyecto
 *
 * @author Daniel
 */
public class Fuente {
    private static Font customFont;
    

    public static Font getFuente() {
        try {
            // Crea un nuevo objeto de tipo InputStream para leer la fuente desde un archivo
            InputStream is = new BufferedInputStream(new FileInputStream("./src/main/java/Source/Font/TypoGraphica.otf"));
            // Crea una nueva fuente a partir del InputStream
            customFont = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        return customFont;
    }
}
