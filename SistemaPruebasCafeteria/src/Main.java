public class Main {
    /*
    Se requiere desarrollar un módulo dentro de un sistema de software para cafeterías que permita la incorporación de nuevas bebidas. El enfoque de esta asignación está en la lógica de backend que maneja el ingreso de nuevas bebidas, específicamente la validación del formato de entrada. La interfaz de usuario (UI) no es una preocupación en este punto.

    Especificaciones de Entrada:

    El nombre de la bebida debe contener caracteres alfabéticos y tener una longitud de 2 a 15 caracteres.
    El tamaño de la bebida puede variar, permitiendo un máximo de cinco tamaños por artículo, y debe ser un valor entero dentro del rango de 1 a 48.
    Los tamaños deben ingresarse en orden ascendente (los más pequeños primero).
    El nombre del artículo se debe ingresar primero, seguido de una coma y luego una lista de tamaños.
    Una coma separará cada tamaño.
    Se ignorarán los espacios en blanco en cualquier lugar de la entrada.
    Criterios de Aceptación:

    El nombre del artículo es alfabético (válido)
    El nombre del artículo tiene menos de 2 caracteres de longitud (inválido)
    El nombre del artículo tiene de 2 a 15 caracteres de longitud (válido)
    El valor del tamaño está en el rango de 1 a 48 (válido)
    El valor del tamaño es un número entero (válido)
    Los valores del tamaño se ingresan en orden ascendente (válido)
    Se ingresan de uno a cinco valores de tamaño (válido)
    El nombre del artículo es el primero en la entrada (válido)
    Una sola coma separa cada entrada en la lista (válido)
    La entrada contiene o no espacios en blanco (a especificar en las pruebas)
    Casos de Prueba: Para asegurarse de que el módulo funcione como se espera, deben elegirse casos de prueba en el límite de estos conjuntos. Proporcione ejemplos de cada miembro y no miembro del conjunto de especificaciones anteriores.
     */
    public static boolean checkNewBeverage (String beverageCharacteristics)
    {
        //Is empty?
        if (beverageCharacteristics.isEmpty())
        {
            System.out.println("The input for the new beverage was empty.");
            return false;
        }
        //split the beverage characteristics into isolated strings
        String[] beverageSplit = beverageCharacteristics.split(",");
        //Name and at least one size?
        if (beverageSplit.length == 1)
        {
            System.out.println("The input missed one parameter (name of beverage or size) or you didn´t separated the input with commas.");
            return false;
        }

        //the beverage name is okay?
        if (!checkBeverageName(beverageSplit[0]))
        {
            return false;
        }

        //the sizes are okay?
        if (!checkSizes(beverageSplit))
        {
            return false;
        }
        System.out.println("Your beverage was added to the system of the cafeteria.");
        //if arrived to this point it passed all the acceptance criteria
        return true;
    }

    public static boolean checkSizes (String[] sizes)
    {
        if (sizes.length>6)
        {
            System.out.println("You have more sizes than 5.");
            return false;
        }
        int previousSize = 0;
        boolean lastOneIsDigit = false;
        String stringNumber = "";

        for (int i = 1; i< sizes.length; i++)
        {
            sizes[i] = formatString(sizes[i]);
            for (int charI = 0; charI<sizes[i].length(); charI++)
            {
                //get just the number in string
                if (Character.isDigit(sizes[i].charAt(charI)))
                {
                    lastOneIsDigit = true;
                    stringNumber = stringNumber + sizes[i].charAt(charI);
                }
                else {
                    //check if it isnt a number or a space
                    if (!((sizes[i].charAt(charI) == ' ')))
                    {
                        System.out.println("Invalid size format at beverage" + i + " not a number.");
                        return false;
                    }
                    else {
                        if (lastOneIsDigit)
                        {
                            System.out.println("Invalid size format at beverage"+i+" spaces between digits.");
                            return false;
                        }
                    }
                }
            }
            int size = Integer.parseInt(stringNumber);
            if (size<1 || size>48)
            {
                System.out.println("The size of the beverage " + i + " is larger than 48 or lower than 1.");
                return false;
            }
            if (size<=previousSize)
            {
                System.out.println("The size of the beverage " + i + " isn´t larger than the previous one.");
                return false;
            }

            previousSize = size;
            stringNumber = "";
        }

        return true;
    }

    public static String formatString (String str)
    {
        int i = 0;
        int j = str.length()-1;
        boolean foundFirstChar = false;
        boolean foundLastChar = false;
        int indexFirstChar = i;
        int indexLastChar = j;

        while (!foundFirstChar || !foundLastChar)
        {
            //not a space?
            if (!(str.charAt(i)==' '))
            {
                foundFirstChar = true;
                indexFirstChar = i;
            }
            if (!(str.charAt(j)==' '))
            {
                foundLastChar = true;
                indexLastChar = j;
            }

            //advance more?
            if (!foundFirstChar)
            {
                i++;
            }
            if (!foundLastChar)
            {
                j--;
            }

        }

        return str.substring(indexFirstChar, indexLastChar+1);
    }

    public static boolean checkBeverageName(String beverageName)
    {
        beverageName = formatString(beverageName);
        //check the size of the beverage name
        if (beverageName.length()<2 || beverageName.length()>15)
        {
            System.out.println("The name of the beverage was too long(more than 15 chars) or too short(less than 2 chars).");
            return false;
        }
        int continuousSpaces = 0;
        for (int i = 0; i<beverageName.length();i++)
        {
            //check if the spaces that are aside are not more than 1
            if (continuousSpaces>1)
            {
                System.out.println("More than one space in the word.");
                return false;
            }
            if (!(Character.isLetter(beverageName.charAt(i))))
            {
                //not alphabetical char and not a space
                if (!(beverageName.charAt(i) ==' '))
                {
                    System.out.println("Not alphabetical char in your beverage name.");
                    return false;
                }
                else
                {
                    continuousSpaces++;
                }
            }
            else {
                continuousSpaces = 0;
            }

        }
        return true;
    }

    //this function allows to eliminate the spaces at the end ot of the actual name

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}