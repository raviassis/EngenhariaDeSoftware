
public class Demo3 {

	//m�todo que possui uma interface funcional como parametro
    //logo pode receber uma express�o lambda ou uma refer�ncia
    //de metodo compat�vel com a interface
    static boolean numTest(NumInt p, int v){
        return p.test(v);
    }

    public static void main(String args[]){
        int num = 10;
//testa se 5 � positivo. Passa a refer�ncia do m�todo
        //positivo como par�metro
        if( numTest(TestInt::positivo, num) )
            System.out.println(num + " � positivo");
        else 
            System.out.println( num + " � negativo");
        if( numTest(TestInt::par, num))
 System.out.println(num + " � par");
else 
    System.out.println(num + " � �mpar");
    }


}
