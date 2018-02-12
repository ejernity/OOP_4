import java.util.*;
import java.lang.*;

class App
{
	public static void main(String[] args)
	{
		if (args.length < 2)
		{
			System.out.println("If you want evaluate to run correctly please enter at least 2 arguments.\nOne for array size and one for movement value.");
			return;
		}

		int array_max_size = Integer.parseInt(args[0]);		// store array's size
		int my_movement = 0;
		int my_condition = -1;		// default value if argc != 4

		if (args.length >= 2)
		{	
			my_movement = Integer.parseInt(args[1]);
			if ((my_movement < 0) || (my_movement > 2))	// if user's input is not valid return
			{
				System.out.println("Wrong input. Please enter movement's value as an integer between 0 and 2 ([0,2])");
				return;
			}
		}

		if (args.length > 2)
		{
			my_condition = Integer.parseInt(args[2]);
			if ((my_condition < 0) || (my_condition > 2))	// if user's input is not valid return
			{
				System.out.println("Wrong input. Please enter condition's value as an integer between 0 and 2 ([0,2])");
				return;
			}
		}

		Random rand = new Random();	// Start seed...

		Artifact[] array = new Artifact[array_max_size];

		for (int array_size = 0; array_size < array_max_size; array_size++)
		{	
			int is_painting = rand.nextInt(2);	// decide if we create painting or sculpture
			switch(is_painting)
			{
				case 0:
					array[array_size] = new Painting(array_size+1,"Creator"+Integer.toString(array_size+1),rand.nextInt(2017)+1);
					break;
				case 1:
					array[array_size] = new Sculpture(array_size+1,"Creator"+Integer.toString(array_size+1),rand.nextInt(2017)+1);
					break;
			}
		}
		
		System.out.println("*********************************");

		auction(array, my_movement, my_condition);
	}

	// Function that uses printing-methods and evaluate for comparison between input and initial values
	public static void auction(Artifact[] my_array, final int movement, final int condition)
	{
		int index = 0;
		while (index < my_array.length)
		{
			my_array[index].getIndex();
			my_array[index].getInfo();
			if (condition == -1)
			{
				System.out.println("Evaluate: " + my_array[index].evaluate(movement));
			} else
			{
				System.out.println("Evaluate: " + my_array[index].evaluate(movement, condition));
			}
			System.out.println("*********************************");
			index++;
		}
	}
}