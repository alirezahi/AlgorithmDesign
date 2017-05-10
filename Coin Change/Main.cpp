#include <iostream>

using namespace std;

int count( int S[], int m, int n )
{
    // table[i] will be storing the number of solutions for
    // value i. We need n+1 rows as the table is consturcted
    // in bottom up manner using the base case (n = 0)
    int table[n+1];

    // Initialize all table values as 0
    for(int i=0;i<n+1;i++)
        table[i]=0;

    // Base case (If given value is 0)
    table[0] = 1;

    // Pick all coins one by one and update the table[] values
    // after the index greater than or equal to the value of the
    // picked coin
    for(int i=0; i<m; i++)
        for(int j=S[i]; j<=n; j++)
            table[j] += table[j-S[i]];

    return table[n];
}
int main() {
	int n,v;
	cin >> v >> n ;
	int a[v];
	for(int i=0; i<v;i++)
	    cin >> a[i];
    int m = count(a,v,n);
    cout << m <<endl;
	return 0;
}
