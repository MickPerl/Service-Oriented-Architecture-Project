package it.unibo.soseng.acmesky;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;


public class InitListener implements ExecutionListener {
	
	@Override
    public void notify(DelegateExecution execution) throws Exception {
     
		ArrayList<String> airlines = new ArrayList<String>();
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/public/simonef/server_list1.config")));
		
		String airline = bufferedReader.readLine();
		while(airline != null) {
			airlines.add(airline);
			airline = bufferedReader.readLine();
		}
        
        execution.setVariable("airlines", airlines);
		
	}
		
}