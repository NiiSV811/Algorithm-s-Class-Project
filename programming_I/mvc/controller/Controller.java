package mvc.controller;

import mvc.model.Utilities;

public class Controller {
    Utilities myUtility = new Utilities();
    private int Validator(String option, int floor, Integer maximum){
        int parsedValue = 0;
        int top = 0;
        try{
            parsedValue = Integer.parseInt(option);
            top = (maximum != null)? maximum : parsedValue + 1;
            if( parsedValue >= floor && parsedValue <= top){
                return parsedValue;
            }
        }catch (Exception e){
            return -2;
        }

        return parsedValue = -1 ;
    }

    public String menuValidator(String inputOption){
        String resolve = "";
        int menuParsed = 0;

        menuParsed = this.Validator(inputOption,0, 6 );

        switch (menuParsed){
            case -2 -> {resolve = "Número inválido";}
            case -1 -> {resolve = "Número fuera de rango";}
            case 0  -> {resolve = "Gracias por Utilizar las Utilidades de Rem";}
            case 1  -> {resolve = "Fibonacci";}
            case 6  -> {resolve = "C";}
            default -> {resolve = " ";}
        }
        return resolve;

    }

    public String secondArgValidator(String inputOption){
        String resolve = "";
        int menuParsed = 0;

        menuParsed = this.Validator(inputOption,1, null);
        if(menuParsed == -1){
            resolve = "Número fuera de rango";
            return resolve;
        }
        if(menuParsed == -2){
            resolve = "Número inválido";
            return resolve;
        }
        resolve = " ";
        return resolve;
    }
    public  String CapicuaValidator(String inputCapicua){
        String resolve = "  ";
        if(inputCapicua.equals("")){
            resolve = "V1";
        }

        return resolve;
    }

    public String applyFunctions(String option, String secondArg){
        int optionValue = Integer.parseInt(option);
        int top = 0;
        String message = "";
        String result = "";

        if (optionValue == 6){
            secondArg = secondArg.replaceAll(" ", "");
            result = this.concatCapicua(secondArg);
            return result;
        }

        top = (!secondArg.equals(""))? Integer.parseInt(secondArg): 0;

        if(optionValue == 1){
            myUtility.setArraySize(top);
            myUtility.setArrayResult();
            myUtility.FibonacciSequence();
            message = "Los primeros " + top + " números de la sucesión de Fibonacci son: \n";
        }else {

            switch (optionValue){
                case 2 -> {
                    myUtility.setArraySize(10);
                    myUtility.setArrayResult();
                    myUtility.Digits();
                    message = "Los digitos numéricos son \n";
                }
                case 3 -> {
                    myUtility.setArraySize(10);
                    myUtility.setArrayResult();
                    myUtility.NumsTen();
                    message = "Los numeros hasta del 1 hasta el 10 son \n";
                }
                case 4 -> {
                    myUtility.setArraySize(5);
                    myUtility.setArrayResult();
                    myUtility.EvensToTen();
                    message = "Los pares hasta el 10 son \n";
                }
                case 5 -> {
                    myUtility.setArraySize(5);
                    myUtility.setArrayResult();
                    myUtility.OddsToTen();
                    message = "Los impares hasta el 10 son: \n";
                }
            }
        }

        result = this.concatArrayResult(message);

        return result;
    }


    private String concatArrayResult(String msg){
        int[] resultArray = myUtility.getArrayResult();
        String concatAns = "";

        concatAns += msg + "\n[ ";
        for(int e = 0; e < resultArray.length; e++){
            concatAns += resultArray[e];
            concatAns += e == (resultArray.length - 1)? " ": " , ";
        }
        concatAns += " ]";
        return concatAns;
    }

    private String concatCapicua(String input){
        String answer = "";
        myUtility.IsCapicua(input);
        boolean result = myUtility.getIsCapicua();

        answer += "\"" + input + "\"";
        answer += result? " es Capicúa :P": " No es capicúa :(";

        return answer;
    }

}
