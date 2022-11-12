#include <bits/stdc++.h>
using namespace std;

struct Process {
	int pid; // Process ID
	int bt; // Burst Time
	int art; // Arrival Time
};


void findWaitingTime(Process proc[], int n, int wt[])
{
	int rt[n];

	for (int i = 0; i < n; i++)
		rt[i] = proc[i].bt;

	int complete = 0, t = 0, minm = INT_MAX;
	int shortest = 0, finish_time;
	bool check = false;

	while (complete != n) {
		for (int j = 0; j < n; j++) {
			if ((proc[j].art <= t) &&
			(rt[j] < minm) && rt[j] > 0) {
				minm = rt[j];
				shortest = j;
				check = true;
			}
		}
		
		

		if (check == false) {
			t++;
			continue;
		}
		rt[shortest]--;

		minm = rt[shortest];
		if (minm == 0)
			minm = INT_MAX;

		// If a process gets completed
		if (rt[shortest] == 0) {
		    
		    cout << shortest + 1 << " ";
			complete++;
			check = false;

			finish_time = t + 1;

			wt[shortest] = finish_time - proc[shortest].bt - proc[shortest].art;

			if (wt[shortest] < 0)
				wt[shortest] = 0;
			
		}
		// Increment time
		t++;
	}
	
	cout << endl;
}

void findResponseTime(Process proc[], int n, int rt[], int wt[])
{

    rt[0] = 0;

    for (int i = 1; i < n ; i++)
    {
        rt[i] =  proc[i-1].bt - proc[i].art;
    }
}


// Function to calculate turn around time
void findTurnAroundTime(Process proc[], int n,
						int wt[], int tat[])
{

	for (int i = 0; i < n; i++)
		tat[i] = proc[i].bt + wt[i];
}


void findavgTime(Process proc[], int n)
{
	int wt[n], tat[n], rt[n], total_wt = 0,total_tat = 0;

	findWaitingTime(proc, n, wt);

	findTurnAroundTime(proc, n, wt, tat);
	
	findResponseTime(proc, n, rt, wt);

	cout << " P\t\t"
		<< "BT\t\t"
		<< "WT\t\t"
		<< "TAT\t\t"
		<< "RT\n";

	// Calculate total waiting time and
	// total turnaround time
	for (int i = 0; i < n; i++) {
		total_wt = total_wt + wt[i];
		total_tat = total_tat + tat[i];
		cout << " " << proc[i].pid << "\t\t"
			<< proc[i].bt << "\t\t " << wt[i]
			<< "\t\t " << tat[i]
			<< "\t\t " << rt[i] << endl;
	}

	cout << "\nAverage waiting time = "
		<< (float)total_wt / (float)n;
	cout << "\nAverage turn around time = "
		<< (float)total_tat / (float)n;
}

// Driver code
int main()
{
	Process proc[] = {{1, 10, 3}, {2, 1, 0}, {3, 2, 1}, {4, 7, 4}, {5, 5, 5}};
	int n = sizeof(proc) / sizeof(proc[0]);

	findavgTime(proc, n);
	return 0;
}
