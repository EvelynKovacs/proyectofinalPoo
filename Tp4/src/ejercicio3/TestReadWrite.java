package ejercicio3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestReadWrite {

	public static void main(String[] args) {
		
		ExecutorService application = Executors.newCachedThreadPool();
        ReadWriteLock lock = new ReadWriteLock();
        
        RecursoCompartido recurso = new RecursoCompartido();
        
        for (int i = 0; i < 2; i++) {
        	application.execute( new Escritor( recurso,lock,i ) );
        }
        for (int i = 0; i < 10; i++) {
        	application.execute( new Lector( recurso,lock ) );
        }

       
        
        application.shutdown();

	}

}
