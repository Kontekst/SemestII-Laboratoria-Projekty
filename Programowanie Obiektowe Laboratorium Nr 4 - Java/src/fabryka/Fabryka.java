/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabryka;

/**
 *
 * @author Kacper Łęgowski
 */
public interface Fabryka {
    Figura zwrocFigure(String typ, int a, int b, int c) throws Wyjatek;
}
