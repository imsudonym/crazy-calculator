
public class Stack {

	public static String stringTemp = "";	
	Queue queue = new Queue();
	
	public boolean isEmpty(){
		return queue.isEmpty();
	}
	
	public void push(String input){				
		queue.enqueue(input);
	}
	
	public String pop(){

		for(int i = 0; i < queue.getSize()-1; i++){
			queue.enqueue(queue.dequeue());
		}
		
		String str = queue.dequeue();		
							
		if(!CrazyCalculator.evaluatingPostfix){
			
			if(stringTemp.length() > 0)
				stringTemp = stringTemp.substring(0, stringTemp.indexOf(str));				
			
			CrazyCalculator.sShots1.stackBlocks.setText(stringTemp);
			
		}else{
			
			if(stringTemp.length() > 0)				
				stringTemp = stringTemp.substring(0, stringTemp.indexOf(str.toCharArray()[0])+1);
			
			CrazyCalculator.sShots2.stackBlocks.setText(stringTemp);
						
		}

		return str;
				
	}
	
	public String peek(){
		return queue.peek();
	}	
}
