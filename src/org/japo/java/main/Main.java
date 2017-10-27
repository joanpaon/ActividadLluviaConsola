/* 
 * Copyright 2017 José A. Pacheco Ondoño - joanpaon@gmail.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.main;

import java.util.Locale;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Constantes
        final int DATO_MIN = 0;
        final int DATO_MAX = 500;
        final int NUM_DIAS = 7;

        // Random
        Random rnd = new Random();

        // Variables
        String nombre = "indefinido";
        int diaMin = 0;
        int diaMax = 0;
        int lectura = 0;
        int lecturaMin = 0;
        int lecturaMax = 0;
        double acumulador = 0;

        // Cabecera
        System.out.println("CONTROL SEMANAL DE PLUVIOMETRÍA");
        System.out.println("===============================");

        // Turno Persona
        for (int dia = 0; dia < NUM_DIAS; dia++) {
            // Nombre dia
            switch (dia + 1) {
                case 1:
                    nombre = "lunes";
                    break;
                case 2:
                    nombre = "martes";
                    break;
                case 3:
                    nombre = "miércoles";
                    break;
                case 4:
                    nombre = "jueves";
                    break;
                case 5:
                    nombre = "viernes";
                    break;
                case 6:
                    nombre = "sábado";
                    break;
                case 7:
                    nombre = "domingo";
            }

            // Entrada dato
            lectura = rnd.nextInt(DATO_MAX - DATO_MIN + 1) + DATO_MIN;

            // Lluvia diaria
            System.out.printf("Lectura diaria ..: %3d l/m2 - %s\n", lectura, nombre);

            // Analizar Minimo
            if (dia == 0) {
                diaMin = 0;
                lecturaMin = lectura;
            } else if (lectura < lecturaMin) {
                diaMin = dia;
                lecturaMin = lectura;
            }

            // Analizar Máximo
            if (dia == 0) {
                diaMax = 0;
                lecturaMax = lectura;
            } else if (lectura > lecturaMax) {
                diaMax = dia;
                lecturaMax = lectura;
            }

            // Acumula Lectura
            acumulador += lectura;
        }
        
        // Separador
        System.out.println("---");

        // Menos Lluvia
        switch (diaMin + 1) {
            case 1:
                nombre = "lunes";
                break;
            case 2:
                nombre = "martes";
                break;
            case 3:
                nombre = "miércoles";
                break;
            case 4:
                nombre = "jueves";
                break;
            case 5:
                nombre = "viernes";
                break;
            case 6:
                nombre = "sábado";
                break;
            case 7:
                nombre = "domingo";
        }
        System.out.printf("Menor lluvia ....: %3d l/m2 - %s\n", lecturaMin, nombre);

        // Más Lluvia
        switch (diaMax + 1) {
            case 1:
                nombre = "lunes";
                break;
            case 2:
                nombre = "martes";
                break;
            case 3:
                nombre = "miércoles";
                break;
            case 4:
                nombre = "jueves";
                break;
            case 5:
                nombre = "viernes";
                break;
            case 6:
                nombre = "sábado";
                break;
            case 7:
                nombre = "domingo";
        }
        System.out.printf("Mayor lluvia ....: %3d l/m2 - %s\n", lecturaMax, nombre);
        
        // Media
        System.out.printf(Locale.ENGLISH, "Promedio semana .: %.2f l/m2\n", acumulador / NUM_DIAS);        
    }
}
