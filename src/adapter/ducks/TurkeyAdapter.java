package adapter.ducks;

public class TurkeyAdapter implements Duck { //Duck Target Inter
	Turkey turkey; // Adaptee 위임, 구성(composite)방식
 
	public TurkeyAdapter(Turkey turkey) {
		this.turkey = turkey;
	}
    
	public void quack() {
		turkey.gobble();
	}
  
	public void fly() {
		for(int i=0; i < 5; i++) {
			turkey.fly();
		}
	}
}
