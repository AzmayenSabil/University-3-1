#include<bits/stdc++.h>

using namespace std;

struct Process
{
   int pid;         // process ID
   int bt;          // burst Time
   int priority;     // priority
   int arrival_time;
};


bool comparisonByArrival(Process a, Process b)
{
    return (a.arrival_time < b.arrival_time);
}


bool comparisonByBurstTime(Process a, Process b)
{
    return (a.bt < b.bt);
}


void findWaitingTime(Process proc[], int n, int wt[])
{
    wt[0] = 0;
    for (int i = 1; i < n ; i++)
    {
        wt[i] = proc[i-1].bt + wt[i-1] ;
    }
}


void findResponseTime(Process proc[], int n, int rt[], int wt[])
{

    rt[0] = 0;

    for (int i = 1; i < n ; i++)
    {
        rt[i] =  wt[i] - proc[i].arrival_time;
    }
}


void findAverageTime(Process proc[], int n)
{
    int wt[n], total_wt = 0, total_rt = 0;
    int rt[n];

    findWaitingTime(proc, n, wt);
    findResponseTime(proc, n, rt, wt);

    cout << "\nProcesses "<< " Burst time "
         << " Waiting time " << " Response Time " << endl;

    for (int i = 0; i < n; i++)
    {
        total_wt = total_wt + wt[i];
        total_rt = total_rt + rt[i];
        cout << " " << proc[i].pid << "\t\t"
             << proc[i].bt << "\t " << wt[i]
             << "\t\t" << rt[i] << endl;
    }

    cout << "Average waiting time = "
         << (float)total_wt / (float)n << endl;

    cout << "Average response time = "
         << (float)total_rt / (float)n;
}


int main()
{
    Process proc[] = {{1, 10, 3, 3}, {2, 1, 1, 0}, {3, 2, 3, 1}, {4, 7, 4, 4}, {5, 5, 2, 5}};
    int n = sizeof proc / sizeof proc[0];

    sort(proc, proc + n, comparisonByArrival);

    cout << "Order in which process gets executed\n";
    for (int i = 0 ; i < n; i++)
    {
        cout << "p" << proc[i].pid <<" ";
    }

    findAverageTime(proc, n);

    return 0;
}
