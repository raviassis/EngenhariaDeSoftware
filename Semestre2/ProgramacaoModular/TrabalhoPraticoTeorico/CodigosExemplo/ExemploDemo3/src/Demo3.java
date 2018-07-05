
public class Demo3 {

	//método que possui uma interface funcional como parametro
    //logo pode receber uma expressão lambda ou uma referência
    //de metodo compatível com a interface
    static boolean numTest(NumInt p, int v){
        return p.test(v);
    }

    public static void main(String args[]){
        int num = 10;
//testa se 5 é positivo. Passa a referência do método
        //positivo como parâmetro
        if( numTest(TestInt::positivo, num) )
            System.out.println(num + " é positivo");
        else 
            System.out.println( num + " é negativo");
        if( numTest(TestInt::par, num))
 System.out.println(num + " é par");
else 
    System.out.println(num + " é ímpar");
    }


}
