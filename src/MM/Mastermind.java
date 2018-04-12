package MM;

import java.util.Random;
import java.util.Vector;

public class Mastermind
{
	private static int[] answer_code;
	private static int[] guess_result;
	private static int[] guess;
	private static Vector<int[]> S;
	
	public static int[] generate_code()
	{
		int[] result = new int[4];
		Random random = new Random();
		result[0] = random.nextInt(8) + 1;
		result[1] = random.nextInt(8) + 1;
		result[2] = random.nextInt(8) + 1;
		result[3] = random.nextInt(8) + 1;
		return result;
	}
	
	public static Vector<int[]> generate_S()
	{
		Vector<int[]> vector = new Vector<int[]>();
		for(int i1=1; i1<=8; i1++)
		{
			for(int i2=1; i2<=8; i2++)
			{
				for(int i3=1; i3<=8; i3++)
				{
					for(int i4=1; i4<=8; i4++)
					{
						int[] a = {i1,i2,i3,i4};
						vector.add(a);
					}
				}
			}
		}
		return vector;
	}
	
	public static void elimination(int[] result, int[] guess)
	{
		int i=0;
		while(i<S.size())
		{
			int[] check_case = check_result(guess, S.get(i));
			int flag = 0;
			if(result[0] != check_case[0] || result[1] != check_case[1])
			{
				flag = 1;
				S.remove(i);
			}
			if(flag == 0)
			{
				i++;
			}
		}
	}
	
	public static int[] check_result(int[] guess, int[] s)
	{
		int[] result = new int[2];
		
		int count_black = 0;
		int count_white = 0;
		int[] color_check = new int[4];
		int[] check_use = new int[4];
		for(int i=0; i<=3; i++)
		{
			if(guess[i] == s[i])
			{
				count_black++;
				color_check[i]++;
				check_use[i]++;
			}
		}
		
		for(int i=0; i<=3; i++)
		{
			if(check_use[i]!=0)
			{
				continue;
			}
			for(int j=0; j<=3; j++)
			{
				if(guess[i] == s[j] && (i != j) && color_check[j] == 0)
				{
					count_white++;
					color_check[j]++;
				}
			}
		}
		
		result[0] = count_black;
		result[1] = count_white;
		
		return result;
	}
	
	public static int min_number_of_elimination(int[] guess)
	{
		int sum = 0;
		int min = 99999;
		int[][] suppose = {{4,0},{3,0},{2,2},{2,1},{2,0},{1,3},{1,2},{1,1},{1,0},{0,4},{0,3},{0,2},{0,1},{0,0}};
		
		for(int i=0; i<14; i++)
		{
			if(suppose[i][0] < guess_result[0] || suppose[i][1] < guess_result[1])
			{
				continue;
			}
			
			sum=0;
			for(int j=0; j<S.size(); j++)
			{
				int[] check_case = check_result(guess, S.get(j));
				if(suppose[i][0]!=check_case[0] || suppose[i][1]!=check_case[1])
				{
					sum++;
				}
			}
			if(min>sum)
			{
				min = sum;
			}
		}
		return min;
	}
	
	public static int[] get_next_guess()
	{
		int[] result = new int[4];
		
		int max = 0;
		for(int i=0; i<S.size(); i++)
		{
			int score = min_number_of_elimination(S.get(i));
			if(score>=max)
			{
				max = score;
				result = S.get(i);
			}
		}
		return result;
	}
	
	public static void output_guess(int[] guess)
	{
		System.out.print(" | ");
		System.out.print(guess[0]);
		System.out.print(" ");
		System.out.print(guess[1]);
		System.out.print(" ");
		System.out.print(guess[2]);
		System.out.print(" ");
		System.out.print(guess[3]);
		System.out.print(" | ");
	}
	
	public static void output_result(int[] result)
	{
		for(int i=0; i<result[0]; i++)
		{
			System.out.print(" black ");
		}
		for(int i=0; i<result[1]; i++)
		{
			System.out.print(" white ");
		}
		System.out.println(" ");
	}
	
	public static void main(String[] args)
	{
		long startTime=System.nanoTime(); 
		answer_code = generate_code();
		
		S = generate_S();
		
		guess = new int[4];
		guess[0] = 1;
		guess[1] = 1;
		guess[2] = 2;
		guess[3] = 2;
		
		guess_result = check_result(guess,answer_code);
		
		output_guess(guess);
		output_result(guess_result);
		
		elimination(guess_result, guess);
		
		while(guess_result[0]!=4)
		{
			guess = get_next_guess();
			guess_result = check_result(guess,answer_code);
			
			output_guess(guess);
			output_result(guess_result);
			
			elimination(guess_result, guess);
		}
		long endTime=System.nanoTime();
		System.out.println("The algorithm take ： "+(endTime-startTime)+" ns");
	}
}
