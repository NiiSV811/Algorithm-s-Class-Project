function ValidationList(list){ //Función que valida que el numero ingresado solo tenga 1 y 0
    list.forEach(i => {
        if (!(i === '1' || i === '0')){
            throw "Numero No Binario";
        }
    });
}

function Converter(id){
    const numArray= document.getElementById(id).value.split(''); //Array del numero ingresado
    try{
        ValidationList(numArray); //Validar que solo tenga 1 y 0
        let binaryList=[]
        let deciNum=0
        numArray.forEach(e=>{
            binaryList.unshift(parseInt(e,10)); // Rellenar otro array con los numeros enteros
        })
        
        for(var i=0; i< binaryList.length; i++){
            deciNum += binaryList[i]*(2**i); // Calcular por descomposición polinomica
        }
        
        let container= document.getElementById('result');//Añadir el resultado en pantalla

        let resultNum=document.getElementById('num');
        resultNum.innerText= 'El numero es '+ deciNum;
        resultNum.style.display='block';
        container.append(resultNum);

    }catch(e){
        alert(e); //Terminar la función cuando se detecte un error... En especial, cuando no es un numero binario.
    }

}


