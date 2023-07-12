/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * En esta clase se cargara la fuente para que sea utilizada en cualquier parte
 * del proyecto
 *
 * @author Daniel
 */
public class Fuente {
    private static Font customFont;
    private static final Path FONT_FILE_PATH = Paths.get("src", "main", "java","views" ,"resources","font" ,"TypoGraphica.otf");

    public static Font getFuente(float fontSize) {
        if (customFont == null) {
            try {
                customFont = Font.createFont(Font.TRUETYPE_FONT, FONT_FILE_PATH.toFile());
            } catch (FontFormatException | IOException e) {
                e.printStackTrace();
            }
        }
        return customFont.deriveFont(fontSize);
    }
}
