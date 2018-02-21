import java.util.Scanner;

public class RabbitHouse {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String InputRabbit = input.nextLine();
		String Rabbitname = InputRabbit.split(" ")[1];
		int Rabbit = Rabbitname.length();
		System.out.println(RabbitTotal (Rabbit));
		}
	
	public static int RabbitTotal(int Rabbit){
		int RabbitOut = 1;
		if (Rabbit == 1){
			return 1;
		} else {
			RabbitOut += Rabbit * RabbitTotal(Rabbit - 1);
			return RabbitOut;
		}
	}
}