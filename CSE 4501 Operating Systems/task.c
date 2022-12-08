#include <fcntl.h>
#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/wait.h>
#include <unistd.h> // pipe er maaL

void isPalindrome(char *str) {
    int len = strlen(str);
    for (int i = 0; i < len / 2; i++) {
        if (str[i] != str[len - i - 1]) {
            printf("%s is not a palindrome\n", str);
        }
    }
    printf("%s is a palindrome\n", str);
}

void isStrongPassword(char *str) {
    int len = strlen(str);
    int hasUpper = 0, hasLower = 0, hasDigit = 0;
    for (int i = 0; i < len; i++) {
        if (str[i] >= 'A' && str[i] <= 'Z') {
            hasUpper = 1;
        } else if (str[i] >= 'a' && str[i] <= 'z') {
            hasLower = 1;
        } else if (str[i] >= '0' && str[i] <= '9') {
            hasDigit = 1;
        }
    }
    if (hasUpper && hasLower && hasDigit && len >= 8) {
        printf("%s is a strong password\n", str);
    } else {
        printf("%s is not a strong password\n", str);
    }
}

int isPrime(int n) {
    if (n <= 1) {
        return 0;
    }
    for (int i = 2; i < n; i++) {
        if (n % i == 0) {
            return 0;
        }
    }
    return 1;
}

void printPrimeNumbersInRange(int start, int end) {
    int count = 0;
    printf("Prime numbers between %d and %d are: ", start, end);
    for (int i = start; i <= end; i++) {
        if (isPrime(i)) {
            printf("%d ", i);
            count++;
        }
    }
    printf("\n");

    printf("Total prime numbers: %d\n", count);
}

void pipeToFile(char *fileName, int pipeFd) {
    int file = open(fileName, O_WRONLY, 0644);
    char task[50];
    read(pipeFd, task, sizeof(task));
    write(file, task, strlen(task));
    close(file);
    close(pipeFd);
}

char files[4][20] = {"file1.txt", "file2.txt", "file3.txt", "file4.txt"};
char tasks[4][50] = {"palindrome_checking\0", "password_strength_checking\0", "prime_number_generation\0", "prime_number_checking\0"};

void assignTask(char *task) {
    if (strncmp(task, tasks[0], strlen(tasks[0])) == 0) {
        printf("Enter a string: ");
        char str[100];
        scanf("%s", str);
        isPalindrome(str);
    } else if (strncmp(task, tasks[1], strlen(tasks[1])) == 0) {
        printf("Enter a password: ");
        char str[100];
        scanf("%s", str);
        isStrongPassword(str);
    } else if (strncmp(task, tasks[2], strlen(tasks[2])) == 0) {
        printf("Enter the range: ");
        int start, end;
        scanf("%d %d", &start, &end);
        printPrimeNumbersInRange(start, end);
    } else if (strncmp(task, tasks[3], strlen(tasks[3])) == 0) {
        printf("Enter a number: ");
        int n;
        scanf("%d", &n);
        if (isPrime(n)) {
            printf("%d is a prime number\n", n);
        } else {
            printf("%d is not a prime number\n", n);
        }
    }
}

void threadTask(void *arg) {
    char *fileName = (char *)arg;
    printf("Thread %s started\n", fileName);
    int file = open(fileName, O_RDONLY, 0644);
    char task[50]; // buffer
    read(file, &task, 50);
    close(file);
    printf("Task assigned: %s\n", task);
    assignTask(task);
}

// main function with arguments
int main(int argc, char *argv[]) {
    // create four text files
    int file1 = open(files[0], O_CREAT, 0644);
    int file2 = open(files[1], O_CREAT, 0644);
    int file3 = open(files[2], O_CREAT, 0644);
    int file4 = open(files[3], O_CREAT, 0644);

    // close the files
    close(file1);
    close(file2);
    close(file3);
    close(file4);

    // create four pipes
    int pipe1[2];
    int pipe2[2];
    int pipe3[2];
    int pipe4[2];

    pipe(pipe1);
    pipe(pipe2);
    pipe(pipe3);
    pipe(pipe4);

    // write tasks to the pipes
    write(pipe1[1], &tasks[0], strlen(tasks[0]));
    write(pipe2[1], &tasks[1], strlen(tasks[1]));
    write(pipe3[1], &tasks[2], strlen(tasks[2]));
    write(pipe4[1], &tasks[3], strlen(tasks[3]));

    // close the pipes
    close(pipe1[1]); // upore 2 size pipe er niche 1 ken
    close(pipe2[1]);
    close(pipe3[1]);
    close(pipe4[1]);

    // create four child processes
    int pid1 = fork();
    if (pid1 > 0) {
        // write task1 to pipe1
        int pid2 = fork();
        if (pid2 > 0) {
            int pid3 = fork();
            if (pid3 > 0) {
                int pid4 = fork();
                if (pid4 > 0) {
                    // wait for all child processes to finish
                    wait(NULL);
                    wait(NULL);
                    wait(NULL);
                    wait(NULL);

                    // print the contents of the files
                    for (int i = 0; i < 4; i++) {
                        int file = open(files[i], O_RDONLY);
                        char buffer[100];
                        read(file, buffer, 100);
                        printf("%s: %s\n", tasks[i], buffer); // for debugging
                    }

                    pthread_t thread1, thread2, thread3, thread4;
                    pthread_create(&thread1, NULL, (void *)threadTask, (void *)files[0]);
                    pthread_join(thread1, NULL);

                    pthread_create(&thread2, NULL, (void *)threadTask, (void *)files[1]);
                    pthread_join(thread2, NULL);

                    pthread_create(&thread3, NULL, (void *)threadTask, (void *)files[2]);
                    pthread_join(thread3, NULL);

                    pthread_create(&thread4, NULL, (void *)threadTask, (void *)files[3]);
                    pthread_join(thread4, NULL);
                } else if (pid4 == 0) {
                    close(pipe4[1]);
                    pipeToFile(files[3], pipe4[0]);
                }
            } else if (pid3 == 0) {
                close(pipe3[1]);
                pipeToFile(files[2], pipe3[0]);
            }
        } else if (pid2 == 0) {
            close(pipe2[1]);
            pipeToFile(files[1], pipe2[0]);
        }
    } else if (pid1 == 0) {
        close(pipe1[1]);
        pipeToFile(files[0], pipe1[0]);
    }
}