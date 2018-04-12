package MM;

import java.util.Vector;

import MM.Mastermind;

public class MastermindTest
{
	private static Vector<int[]> S;
	private static int[] guess_result;

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int[] a = {1,1,2,2};
		int[] b = {1,1,1,2};
		guess_result = Mastermind.check_result(a,b);
		
		Mastermind.output_result(guess_result);
//		Vector<int[]> S = new Vector<int[]>();
//		for(int i1=1; i1<=8; i1++)
//		{
//			for(int i2=1; i2<=8; i2++)
//			{
//				for(int i3=1; i3<=8; i3++)
//				{
//					for(int i4=1; i4<=8; i4++)
//					{
//						int[] a = {i1,i2,i3,i4};
//						S.add(a);
//					}
//				}
//			}
//		}
//		
//		for(int i=0;i<S.size();i++)
//		{
//			int[] a = S.get(i);
//			System.out.print(a[0]);
//			System.out.print(a[1]);
//			System.out.print(a[2]);
//			System.out.println(a[3]);
//		}
	}

}
