import java.util.*;
class Main{
   
static final int MAX = 1000;
static int []dp = new int[MAX + 1];

static List<Integer> denomination =new LinkedList<Integer>();
static int countMinCoins(int n,int C[], int m)
{
  // Base case
  if (n == 0)
  {
    dp[0] = 0;
    return 0;
  }
  if (dp[n] != -1)
    return dp[n];
  int ret = Integer.MAX_VALUE;
 
  for (int i = 0; i < m; i++)
  {
    if (C[i] <= n)
    {
      int x = countMinCoins(n - C[i],C, m);

      if (x != Integer.MAX_VALUE)
        ret = Math.min(ret, 1 + x);
    }
  }
 

  dp[n] = ret;
  return ret;
}
 
static void findSolution(int n,int C[], int m)
{

  if (n == 0)
  {
 
    for (int it : denomination)
    {
      System.out.print(it + " ");
    }
    return;
  }
 
  for (int i = 0; i < m; i++)
  {
  
    if (n - C[i] >= 0 &&
        dp[n - C[i]] + 1 ==
        dp[n])
    {
    
      denomination.add(C[i]);
 
      findSolution(n - C[i], C, m);
      break;
    }
  }
}
 
static void countMinCoinsUtil(int X,int C[], int N)
{
  
  for (int i = 0; i < dp.length; i++)
    dp[i] = -1;
 
  int isPossible = countMinCoins(X, C, N);
 
 
  if (isPossible == Integer.MAX_VALUE)
  {
    System.out.print("-1");
  }
 

  else
  {
    findSolution(X, C, N);
  }
}
 
public static void main(String[] args)
{
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the amount:");
  int X = sc.nextInt();
  System.out.println("Enter the number of denominations:");
 int N=sc.nextInt();
 System.out.println("Enter the denominations one by one:");
  // Set of possible denominations
  int arr[] = new int[N];
 for(int i=0;i<N;i++)
 {
    arr[i]=sc.nextInt();
 }
  
 
  // Function Call
  countMinCoinsUtil(X, arr, N);
}
}