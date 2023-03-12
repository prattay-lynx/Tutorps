#include<stdio.h>
#include<stdbool.h>
int main()
{ int i,n=8;bool check = false,check1=true,check2=true;
  int a[]={-1, -5, -3, -1100, -1100, -1101, -1102, -9001};
  for(i=0;i<n-1;i++)
  {  
        if(a[i]>a[i+1])
        {
        check1 = false; 
        }
   }
   for(i=0;i<n-1;i++)
  {  
        if(a[i]<a[i+1])
        {
        check2 = false; 
        }
   }
     check = check1 || check2;
    if(check == true)
    printf("true");
    else printf("false");
    }