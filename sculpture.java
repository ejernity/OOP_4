import java.util.*;
import java.lang.*;

class Sculpture extends Masterpiece
{
	enum material_type
	{
		IRON,
		STONE,
		WOOD;
	}

	int volume;
	material_type material;

	// Constructor
	public Sculpture(final int my_index, final String my_creator, final int my_year)
	{
		super(my_index,my_creator,my_year);
		Random rand = new Random();
		volume = rand.nextInt(500) + 1;
		material = material_type.values()[rand.nextInt(3)];
		System.out.println("Creating an instance of sculpture");
	}

	// Accessor
	public void getInfo()
	{
		super.getInfo();
		System.out.println("Volume: " + volume);
		switch(material)
		{
			case IRON: System.out.println("Material: iron"); break;
			case STONE: System.out.println("Material: stone"); break;
			case WOOD: System.out.println("Material: wood"); break;
		}
	}

	// Evaluate
	public int evaluate(final int my_movement, final int my_condition)
	{
		if (movement_type.values()[my_movement] == movement && condition_type.values()[my_condition] == condition)
			return 1;
		return 0;
	}
	public int evaluate(final int my_movement) { return evaluate(my_movement, 2); }
}