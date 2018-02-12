import java.util.*;
import java.lang.*;

abstract class Masterpiece extends Artifact
{
	enum movement_type
	{
		IMPRESSIONISM,
		EXPRESSIONISM,
		NATURALISM;
	}

	enum condition_type
	{
		BAD,
		GOOD,
		EXCELLENT;
	}

	movement_type movement;
	condition_type condition;

	// Constructor
	public Masterpiece(final int my_index, final String my_creator, final int my_year)
	{
		super(my_index,my_creator,my_year);
		Random rand = new Random();
		movement = movement_type.values()[rand.nextInt(3)];
		condition = condition_type.values()[rand.nextInt(3)];
		System.out.println("Creating an instance of masterpiece");
	}

	// Accessor
	public void getInfo()
	{
		super.getInfo();
		switch (movement)
		{
			case IMPRESSIONISM: System.out.println("Movement: impressionism"); break;
			case EXPRESSIONISM: System.out.println("Movement: expressionism"); break;
			case NATURALISM: System.out.println("Movement: naturalism"); break;
		}
		switch (condition)
		{
			case BAD: System.out.println("Condition: bad"); break;
			case GOOD: System.out.println("Condition: good"); break;
			case EXCELLENT: System.out.println("Condition: excellent"); break;
		}
	}

	// Evaluate
	abstract public int evaluate(final int my_movement, final int my_condition);
	abstract public int evaluate(final int my_movement);

}