public class Main {

	public static void main(String[] args) {
		
		Human h = new Human();
		
		try{
		Optional<int[]> opt = h.parseMove("1 2");
		if(opt.isPresent()) {
			System.out.println(opt.get()[0]);
			System.out.println(opt.get()[1]);
		} else {
			System.out.println("\n");
		}
	}catch(Exception e){
			System.out.println("There is error in Main function");
		}
	}

}