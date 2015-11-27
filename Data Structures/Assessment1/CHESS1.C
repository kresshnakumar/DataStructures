/* effecient file accessing algorithm by using arrays computing */
#include<stdio.h>
#include<conio.h>
main()
{
  int n,p,q;
  clrscr();
  printf("\n\t\t\t\t MENU");
  printf("\n******************************************************************************");
  printf("\n\t\t\t\t1-KING");
  printf("\n\t\t\t\t2-QUEEN");
  printf("\n\t\t\t\t3-CAMEL");
  printf("\n\t\t\t\t4-HORSE");
  printf("\n\t\t\t\t5-ELEPHANT");
  printf("\n\t\t\t\t6-SOLDIER");
  printf("\n*****************************************************************************");
  printf("\nenter your choice:");
  scanf("%d",&n);
  p=1;q=1;
  switch(n)
  {
    case 1:printf("\nenter the position:");
	   scanf("%d%d",&p,&q);
	   king(p,q);  break;
    case 2:printf("\nenter the posiotion:");
	   scanf("%d%d",&p,&q);
	   queen(p,q); break;
    case 3:printf("enter the position:");
	   scanf("%d%d",&p,&q);
	   camel(p,q); break;
    case 4:printf("\nenter the position:");
	   scanf("%d%d",&p,&q);
	   horse(p,q); break;
    case 5:printf("\nenter the position:");
	   scanf("%d%d",&p,&q);
	   elephant(p,q); break;
    case 6:printf("\nenter the position:");
	   scanf("%d%d",&p,&q);
	   soldier(p,q); break;
    default : printf("enter correct choice:"); break;
  }
}
king(int i,int j)
{
    if(i<1 || i>8)
    {
      printf("out of range");
    }
    if(j<1 || j>8)
    {
      printf("out of range");
    }
    if(i>1 && i<8)
    {
      if(j>1 && j<8)
      {
       printf("\n%d,%d",i-1,j-1);
       printf("\n%d,%d",i-1,j);
       printf("\n%d,%d",i-1,j+1);
       printf("\n%d,%d",i,j-1);
       printf("\n%d,%d",i,j+1);
       printf("\n%d,%d",i+1,j-1);
       printf("\n%d,%d",i+1,j);
       printf("\n%d,%d",i+1,j+1);
      }
    }
    if(i>1 && i<8)
    {
      if(j==1)
      {
	printf("\n%d,%d",i-1,j);
	printf("\n%d,%d",i-1,j+1);
	printf("\n%d,%d",i,j+1);
	printf("\n%d,%d",i+1,j);
	printf("\n%d,%d",i+1,j+1);
      }
      else if(j==8)
      {
	printf("\n%d,%d",i-1,j);
	printf("\n%d,%d",i-1,j-1);
	printf("\n%d,%d",i,j-1);
	printf("\n%d,%d",i+1,j-1);
	printf("\n%d,%d",i+1,j);
      }
    }
    if(i==1)
    {
      if(j>1 && j<8)
      {
	printf("\n%d,%d",i,j-1);
	printf("\n%d,%d",i+1,j-1);
	printf("\n%d,%d",i+1,j);
	printf("\n%d,%d",i+1,j+1);
	printf("\n%d,%d",i,j+1);
      }
    }
    if(i==8)
    {
      if(j>1 && j<8)
      {
	printf("\n%d,%d",i,j-1);
	printf("\n%d,%d",i-1,j-1);
	printf("\n%d,%d",i-1,j);
	printf("\n%d,%d",i-1,j+1);
	printf("\n%d,%d",i,j+1);
      }
    }
    if(i==1 && j==1)
    {
      printf("\n%d,%d",i+1,j);
      printf("\n%d,%d",i+1,j+1);
      printf("\n%d,%d",i,j+1);
    }
    if(i==8 && j==1)
    {
       printf("\n%d,%d",i-1,j);
       printf("\n%d,%d",i-1,j+1);
       printf("\n%d,%d",i,j+1);
    }
    if(i==1 && j==8)
    {
      printf("\n%d,%d",i,j-1);
      printf("\n%d,%d",i+1,j-1);
      printf("\n%d,%d",i+1,j);
    }
    if(i==8 && j==8)
    {
      printf("\n%d,%d",i,j-1);
      printf("\n%d,%d",i-1,j-1);
      printf("\n%d,%d",i-1,j);
    }
}
queen(int i,int j)
{
int a,b;
a=i;
b=j;
if(i<1 || i>8)
{
      printf("out of range");
}
else if(j<1 || j>8)
     {
      printf("out of range");
     }
else
{
  for(j=1;j<=8;j++)
  {
    if(j!=b)
    {
     printf("\n%d,%d\t",i,j);
    }
  }
  j=b;
  for(i=1;i<=8;i++)
  {
    if(i!=a)
    {
     printf("\n%d,%d",i,j);
    }
  }
  i=a;j=b;
  for(i=a,j=b;i<8,j<8;i++,j++)
  {
    if(i<8 && j<8)
    {
     printf("\n%d,%d\t",(i+1),(j+1));
    }
  }
  i=a;j=b;
  for(i=a,j=b;i>1,j>1;i--,j--)
  {
   if(i>1 && j>1)
   {
    printf("\n%d,%d\t",(i-1),(j-1));
   }
  }
  i=a;j=b;
  for(i=a,j=b;i>1,j<8;i--,j++)
  {
   if(i>1 && j<8)
   {
    printf("\n%d,%d\t",(i-1),(j+1));
   }
  }
  i=a;j=b;
  for(i=a,j=b;i<8,j>1;i++,j--)
  {
   if(i<8 && j>1)
   {
    printf("\n%d,%d\t",(i+1),(j-1));
   }
  }
}
}
camel(int i,int j)
{
  int a,b;
  a=i;
  b=j;
  i=a;j=b;
if(i<1 || i>8)
{
      printf("out of range");
}
else if(j<1 || j>8)
{
      printf("out of range");
}
else
{
  for(i=a,j=b;i<8,j<8;i++,j++)
  {
    if(i<8 && j<8)
    {
     printf("\n%d,%d\t",(i+1),(j+1));
    }
  }
  i=a;j=b;
  for(i=a,j=b;i>1,j>1;i--,j--)
  {
    if(i>1 && j>1)
    {
     printf("\n%d,%d\t",(i-1),(j-1));
    }
  }
  i=a;j=b;
  for(i=a,j=b;i>1,j<8;i--,j++)
  {
    if(i>1 && j<8)
    {
     printf("\n%d,%d\t",(i-1),(j+1));
    }
  }
  i=a;j=b;
  for(i=a,j=b;i<8,j>1;i++,j--)
  {
    if(i<8 && j>1)
    {
     printf("\n%d,%d\t",(i+1),(j-1));
    }
  }
}
}
right(int a,int b)
{
  printf("\n%d,%d",(a+2),(b+1));
  printf("\n%d,%d",(a+2),(b-1));
}
down(int a,int b)
{
  printf("\n%d,%d",(a-1),(b+2));
  printf("\n%d,%d",(a+1),(b+2));
}
left(int a,int b)
{
  printf("\n%d,%d",(a-2),(b+1));
  printf("\n%d,%d",(a-2),(b-1));
}
up(int a,int b)
{
  printf("\n%d,%d",(a-1),(b-2));
  printf("\n%d,%d",(a+1),(b-2));
}
horse(int i,int j)
{
 if(i<1 || i>8)
    {
      printf("out of range");
    }
    if(j<1 || j>8)
    {
      printf("out of range");
    }
  /*for p,q=3,4,5,6  */
 if(i>2 && i<7)
 {
  if(j>2 && j<7)
  {
    left(i,j);
    right(i,j);
    up(i,j);
    down(i,j);
  }
 }
 /*if p,q=2 */
 if(i==2 && j==2)
 {
    down(i,j);
    right(i,j);
 }
 /*if p=2,q=7 */
 if(i==2 && j==7)
 {
   up(i,j);
   right(i,j);
 }
 if(i==7 && j==2)
 {
    left(i,j);
    down(i,j);
 }
 if(i==7 && j==7)
 {
    left(i,j);
    up(i,j);
 }
 /*for p=3,4,5,6 & q=2 */
 if(i>2 && i<7)
 {
   if(j==2)
   {
     left(i,j);
     down(i,j);
     right(i,j);
   }
 }
 /*for p=2 & q=3,4,5,6 */
 if(i==2)
 {
   if(j>2 && j<7)
   {
     up(i,j);
     right(i,j);
     down(i,j);
   }
 }
 /*for p=3,4,5,6 & q=7 */
 if(i>2 && i<7)
 {
   if(j==7)
   {
     left(i,j);
     right(i,j);
     up(i,j);
   }
 }
 /*for p=7 & q=3,4,5,6 */
 if(i==7)
 {
   if(j>2 && j<7)
   {
     up(i,j);
     left(i,j);
     down(i,j);
   }
 }
 if(i==1 && j==1)
 {
   printf("\n%d,%d",(i+2),(j+1));
   printf("\n%d,%d",(i+1),(j+2));
 }
 if(i==1 && j==8)
 {
   printf("\n%d,%d",(i+1),(j-2));
   printf("\n%d,%d",(i+2),(j-1));
 }
 if(i==8 && j==1)
 {
   printf("\n%d,%d",(i-2),(j+1));
   printf("\n%d,%d",(i-1),(j+2));
 }
 if(i==8 && j==8)
 {
   printf("\n%d,%d",(i-1),(j-2));
   printf("\n%d,%d",(i-2),(j-1));
 }
 /*for p=3,4,5,6 && q=1 */
 if(i>2 && i<7)
 {
  if(j==1)
  {
   down(i,j);
   printf("\n%d,%d",(i-2),(j+1));
   printf("\n%d,%d",(i+2),(j+1));
  }
 }
 /*for p=1 && q=3,4,5,6 */
 if(i==1)
 {
  if(j>2 && j<7)
  {
      right(i,j);
      printf("\n%d,%d",(i+1),(j-2));
      printf("\n%d,%d",(i+1),(j+2));
   }
 }
 /*for p=3,4,5,6 && q=8 */
 if(i>2 && i<7)
 {
   if(j==8)
   {
    up(i,j);
    printf("\n%d,%d",(i-2),(j-1));
    printf("\n%d,%d",(i+2),(j-1));
   }
 }
 /*for p=8 && q=3,4,5,6 */
 if(i==8)
 {
 if(j>2 && j<7)
   {
     left(i,j);
     printf("\n%d,%d",(i-2),(j-1));
     printf("\n%d,%d",(i-2),(j+1));
   }
 }
 if(i==2 && j==1)
 {
   printf("\n%d,%d",(i+2),(j+1));
   down(i,j);
 }
 if(i==1 && j==2)
 {
   right(i,j);
   printf("\n%d,%d",(i+1),(j+2));
 }
 if(i==7 && j==1)
 {
  down(i,j);
  printf("\n%d,%d",(i-2),(j+1));
 }
 if(i==8 && j==2)
 {
   left(i,j);
   printf("\n%d,%d",(i-1),(j+2));
 }
 if(i==8 && j==7)
 {
   left(i,j);
   printf("\n%d,%d",(i-1),(j+2));
 }
 if(i==7 && j==8)
 {
   up(i,j);
   printf("\n%d,%d",(i-2),(j-1));
 }
 if(i==2 && j==8)
 {
   up(i,j);
   printf("\n%d,%d",(i+2),(j-1));
 }
 if(i==1 && j==7)
 {
   right(i,j);
   printf("\n%d,%d",(i+1),(j-2));
 }
}
elephant(int i,int j)
{
  int a,b;
  a=i;
  b=j;
if(i<1 || i>8)
{
      printf("out of range");
}
else if(j<1 || j>8)
{
      printf("out of range");
}
else
{
  for(j=1;j<=8;j++)
  {
    if(j!=b)
    {
      printf("\n%d,%d\t",i,j);
    }
  }
  j=b;
  for(i=1;i<=8;i++)
  {
    if(i!=a)
    {
      printf("\n%d,%d",i,j);
    }
  }
}
}
soldier(int i,int j)
{
  if(i<1 || i>8)
    {
      printf("out of range");
    }
    if(j<1 || j>8)
    {
      printf("out of range");
    }
  if(i>=1 && i<=8)
  {
    if(j>=1 && j<8)
    {
      printf("\n%d,%d",i,j+1);
    }
  }
  if(j==8)
  {
    if(i==1 || i==8)
    {
      printf("changed to elephant");
    }
    else if(i==2 || i==7)
	 {
	   printf("changed to horse");
	 }
	 else if(i==3 || i==6)
	      {
		printf("changed to camel");
	      }
	      else if(i==4)
		   {
		     printf("changed to queen");
		   }
		   else
		   {
		     printf("change to any one");
		   }
  }
}