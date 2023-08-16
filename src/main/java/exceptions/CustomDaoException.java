/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 *
 * @author dan-dev
 */
public class CustomDaoException extends Exception{
    public CustomDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
