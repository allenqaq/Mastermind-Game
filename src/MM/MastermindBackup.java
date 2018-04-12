package MM;

import java.util.Random;
import java.util.Vector;

public class MastermindBackup
{
	private static int[] answer_code;
	private static int[] guess_result;
	private static int[] guess;
	private static Vector<Vector<Integer>> S;
	
	static int[] generate_code()
	{
		int[] result = new int[4];
		Random random = new Random();
		result[0] = random.nextInt(8) + 1;
		result[1] = random.nextInt(8) + 1;
		result[2] = random.nextInt(8) + 1;
		result[3] = random.nextInt(8) + 1;
		return result;
	}
	
	static Vector<Vector<Integer>> generate_S()
	{
		Vector<Vector<Integer>> vector = new Vector<Vector<Integer>>();
		
		for(int i1=1; i1<=8; i1++)
		{
			for(int i2=1; i2<=8; i2++)
			{
				for(int i3=1; i3<=8; i3++)
				{
					for(int i4=1; i4<=8; i4++)
					{
						Vector<Integer> vector2 = new Vector<Integer>();
						vector2.add(i1);
						vector2.add(i2);
						vector2.add(i3);
						vector2.add(i4);
						vector.add(vector2);
					}
				}
			}
		}
		
		return vector;
	}
	
	static void elimination(int[] result, int[] guess)
	{
		// case 1 all 0
		if(result[0]==0 && result[1]==0)
		{
			for(int i=0; i<S.size(); i++)
			{
				for(int j=0; j<S.get(i).size(); j++)
				{
					int SC = S.get(i).get(j);
					if(SC == guess[0] || SC == guess[1] || SC == guess[2] || SC == guess[3])
					{
						S.remove(i);
					}
				}
			}
		}
		
		//case 2 white 1
		if(result[0]==0 && result[1]==1)
		{
			for(int i=0; i<S.size(); i++)
			{
				int same_color = 0;
				int[] color_check = new int[4];
				for(int j=0; j<4; j++)
				{
					int SC=S.get(i).get(j);
					
					// same color same position
					if(SC == guess[j])
					{
						S.remove(i);
						break;
					}
					
					// same more than 2 color
					for(int k=0; k<4; k++)
					{
						if(k!=j && SC == guess[k] && color_check[k] == 0)
						{
							same_color++;
							color_check[k] = 1;
						}
					}
					if(same_color != 1)
					{
						S.remove(i);
					}
				}
			}
		}
		
		//case 3 white 2
		if(result[0]==0 && result[1]==2)
		{
			for(int i=0; i<S.size(); i++)
			{
				int same_color = 0;
				int[] color_check = new int[4];
				for(int j=0; j<4; j++)
				{
					int SC=S.get(i).get(j);
					
					// same color same position
					if(SC == guess[j])
					{
						S.remove(i);
						break;
					}
					
					// same more or less than 2 color
					for(int k=0; k<4; k++)
					{
						if(k!=j && SC == guess[k] && color_check[k] == 0)
						{
							same_color++;
							color_check[k] = 1;
						}
					}
					if(same_color != 2)
					{
						S.remove(i);
					}
				}
			}
		}
		
		//case 4 white 3
		if(result[0]==0 && result[1]==3)
		{
			for(int i=0; i<S.size(); i++)
			{
				int same_color = 0;
				int[] color_check = new int[4];
				for(int j=0; j<4; j++)
				{
					int SC=S.get(i).get(j);
					
					// same color same position
					if(SC == guess[j])
					{
						S.remove(i);
						break;
					}
					
					// same more or less than 3 color
					for(int k=0; k<4; k++)
					{
						if(k!=j && SC == guess[k] && color_check[k] == 0)
						{
							same_color++;
							color_check[k] = 1;
						}
					}
					if(same_color != 3)
					{
						S.remove(i);
					}
				}
			}
		}
		
		//case 5 white 4
		if(result[0]==0 && result[1]==4)
		{
			for(int i=0; i<S.size(); i++)
			{
				int same_color = 0;
				int[] color_check = new int[4];
				for(int j=0; j<4; j++)
				{
					int SC=S.get(i).get(j);
					
					// same color same position
					if(SC == guess[j])
					{
						S.remove(i);
						break;
					}
					
					// same more or less than 4 color
					for(int k=0; k<4; k++)
					{
						if(k!=j && SC == guess[k] && color_check[k] == 0)
						{
							same_color++;
							color_check[k] = 1;
						}
					}
					if(same_color != 4)
					{
						S.remove(i);
					}
				}
			}
		}
		
		//case 6 black 1
		if(result[0]==1 && result[1]==0)
		{
			for(int i=0; i<S.size(); i++)
			{
				int check_black = 0;
				int check_white = 0;
				
			}
		}
	}
	
	static int min_number_of_elimination(int[] result, int[] guess)
	{
		int sum = 0;
		
		
		
		return sum;
	}
	
	static int[] get_result(int[] guess)
	{
		//  0 is nothing; 1 is white; 2 is black
		int[] result = new int[4];
		result[0] = 0;
		result[1] = 0;
		
		int count_black = 0;
		int count_white = 0;
		for(int i=0; i<=3; i++)
		{
			if(guess[i] == answer_code[i])
			{
				count_black++;
				continue;
			}
			for(int j=0; j<=3; j++)
			{
				if(guess[i] == answer_code[j] && (i != j) )
				{
					count_white++;
				}
			}
		}
		
		result[0] = count_black;
		result[1] = count_white;
		
		return result;
	}
	
	
	
	public static void main(String[] args)
	{
		answer_code = generate_code();
		
		
	}
}
